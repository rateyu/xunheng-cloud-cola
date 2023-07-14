//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tangzc.mpe.actable.manager.system;

import com.google.common.collect.Sets;
import com.tangzc.mpe.actable.annotation.*;
import com.tangzc.mpe.actable.annotation.constants.MySqlCharsetConstant;
import com.tangzc.mpe.actable.annotation.constants.MySqlEngineConstant;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.tangzc.mpe.actable.command.*;
import com.tangzc.mpe.actable.mapper.CreateMysqlTablesMapper;
import com.tangzc.mpe.actable.utils.ClassScanner;
import com.tangzc.mpe.actable.utils.ClassTools;
import com.tangzc.mpe.actable.utils.ColumnUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AnnotatedElementUtils;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 重写actable的一些规则 让父类的字段在数据库表中排序在前 不需要此规则可以删除
 * @author: hhqkkr
 * @date: 2023/6/29 17:00
 */
@GlobalTransactional
public class SysMysqlCreateTableManager {
    private static final Logger log = LoggerFactory.getLogger(SysMysqlCreateTableManager.class);
    @Resource
    private CreateMysqlTablesMapper createMysqlTablesMapper;
    @Value("${actable.model.pack:}")
    private String pack;
    @Value("${actable.table.auto:update}")
    private String tableAuto;
    @Value("${actable.unique.prefix:actable_uni_}")
    private String uniPrefix;
    @Value("${actable.index.prefix:actable_idx_}")
    private String idxPrefix;

    public SysMysqlCreateTableManager() {
    }

    @PostConstruct
    public void initPack() {
        if (StringUtils.isEmpty(this.pack)) {
            this.pack = ClassTools.getBootPackage();
        }

    }

    public void createMysqlTable() {
        if (!"none".equals(this.tableAuto) && !"update".equals(this.tableAuto) && !"create".equals(this.tableAuto) && !"add".equals(this.tableAuto)) {
            log.warn("配置mybatis.table.auto错误无法识别，当前配置只支持[none/update/create/add]三种类型!");
        } else if ("none".equals(this.tableAuto)) {
            log.info("配置mybatis.table.auto=none，不需要做任何事情");
        } else {
            String[] packs = this.pack.split(",|;");
            Set<Class<?>> classes = ClassScanner.scan(packs, new Class[]{Table.class});
            Map<String, Map<String, TableConfig>> baseTableMap = this.initTableMap();
            Set<Class<?>> needCreateTable = this.filterRepeatTable(classes);
            Iterator var5 = needCreateTable.iterator();

            while(var5.hasNext()) {
                Class<?> clas = (Class)var5.next();
                if (ColumnUtils.hasIgnoreTableAnnotation(clas)) {
                    log.warn("{}，配置了@IgnoreTable注解直接跳过", clas.getName());
                } else {
                    this.buildTableMapConstruct(clas, baseTableMap);
                }
            }

            this.createOrModifyTableConstruct(baseTableMap);
        }
    }

    private Set<Class<?>> filterRepeatTable(Set<Class<?>> classes) {
        Map<String, List<Class<?>>> classMap = (Map)classes.stream().collect(Collectors.groupingBy(ColumnUtils::getTableName));
        Set<Class<?>> needCreateTable = new HashSet();
        classMap.forEach((tableName, sameClasses) -> {
            if (sameClasses.size() > 1) {
                List<Class<?>> primaryClasses = (List)sameClasses.stream().filter((clazz) -> {
                    return ((TablePrimary)AnnotatedElementUtils.findMergedAnnotation(clazz, TablePrimary.class)).value();
                }).collect(Collectors.toList());
                if (primaryClasses.isEmpty()) {
                    throw new RuntimeException("表名[" + tableName + "]出现重复，必须指定一个为@TablePrimary！");
                }

                if (primaryClasses.size() > 1) {
                    throw new RuntimeException("表名[" + tableName + "]出现重复，有且只能有一个为@TablePrimary！");
                }

                needCreateTable.add(primaryClasses.get(0));
            } else {
                needCreateTable.add(sameClasses.get(0));
            }

        });
        return needCreateTable;
    }

    private Map<String, Map<String, TableConfig>> initTableMap() {
        Map<String, Map<String, TableConfig>> baseTableMap = new HashMap();
        baseTableMap.put("newTableMap", new HashMap());
        baseTableMap.put("modifyTableMap", new HashMap());
        baseTableMap.put("addTableMap", new HashMap());
        baseTableMap.put("removeTableMap", new HashMap());
        baseTableMap.put("dropKeyTableMap", new HashMap());
        baseTableMap.put("dropIndexAndUniqueTableMap", new HashMap());
        baseTableMap.put("addIndexTableMap", new HashMap());
        baseTableMap.put("addUniqueTableMap", new HashMap());
        baseTableMap.put("modifyTablePropertyMap", new HashMap());
        return baseTableMap;
    }

    private void buildTableMapConstruct(Class<?> clas, Map<String, Map<String, TableConfig>> baseTableMap) {
        String tableName = ColumnUtils.getTableName(clas);
        String tableComment = ColumnUtils.getTableComment(clas);
        MySqlCharsetConstant tableCharset = ColumnUtils.getTableCharset(clas);
        MySqlEngineConstant tableEngine = ColumnUtils.getTableEngine(clas);

        List allFieldList;
        try {
            allFieldList = this.getAllFields(clas);
            if (allFieldList.isEmpty()) {
                log.warn("扫描发现{}没有建表字段请检查！", clas.getName());
                return;
            }
        } catch (Exception var20) {
            log.error("表：{}，初始化字段结构失败！", tableName);
            throw new RuntimeException(var20);
        }

        if ("create".equals(this.tableAuto)) {
            log.info("由于配置的模式是create，因此先删除表后续根据结构重建，删除表：{}", tableName);
            this.createMysqlTablesMapper.dropTableByName(tableName);
        }

        SysMysqlTable table = this.createMysqlTablesMapper.findTableByTableName(tableName);
        HashMap map;
        if (table == null) {
            map = new HashMap();
            if (!StringUtils.isEmpty(tableComment)) {
                map.put("table_comment", tableComment);
            }

            if (tableCharset != null && tableCharset != MySqlCharsetConstant.DEFAULT) {
                map.put("table_collation", tableCharset.toString().toLowerCase());
            }

            if (tableEngine != null && tableEngine != MySqlEngineConstant.DEFAULT) {
                map.put("engine", tableEngine.toString());
            }

            ((Map)baseTableMap.get("newTableMap")).put(tableName, new TableConfig(allFieldList, map));
            ((Map)baseTableMap.get("addIndexTableMap")).put(tableName, new TableConfig(this.getAddIndexList((Set)null, allFieldList)));
            ((Map)baseTableMap.get("addUniqueTableMap")).put(tableName, new TableConfig(this.getAddUniqueList((Set)null, allFieldList)));
        } else {
            map = new HashMap();
            if (!StringUtils.isEmpty(tableComment) && !tableComment.equals(table.getTable_comment())) {
                map.put("table_comment", tableComment);
            }

            if (tableCharset != null && tableCharset != MySqlCharsetConstant.DEFAULT && !tableCharset.toString().toLowerCase().equals(table.getTable_collation().replace("_general_ci", ""))) {
                map.put("table_collation", tableCharset.toString().toLowerCase());
            }

            if (tableEngine != null && tableEngine != MySqlEngineConstant.DEFAULT && !tableEngine.toString().equals(table.getEngine())) {
                map.put("engine", tableEngine.toString());
            }

            ((Map)baseTableMap.get("modifyTablePropertyMap")).put(tableName, new TableConfig(map));
            List<SysMysqlColumns> tableColumnList = this.createMysqlTablesMapper.findTableEnsembleByTableName(tableName);
            List<String> columnNames = ClassTools.getPropertyValueList(tableColumnList, "column_name");
            List<Object> addFieldList = this.getAddFieldList(allFieldList, columnNames);
            List<Object> removeFieldList = this.getRemoveFieldList(columnNames, allFieldList);
            List<Object> modifyFieldList = this.getModifyFieldList(tableColumnList, allFieldList);
            List<Object> dropKeyFieldList = this.getDropKeyFieldList(tableColumnList, allFieldList);
            Map<String, String> paramMap = new HashMap();
            paramMap.put("tableName", tableName);
            paramMap.put("uniquePrefix", this.uniPrefix);
            paramMap.put("indexPrefix", this.idxPrefix);
            Set<String> allIndexAndUniqueNames = this.createMysqlTablesMapper.findTableIndexByTableName(paramMap);
            List<Object> dropIndexAndUniqueFieldList = this.getDropIndexAndUniqueList(allIndexAndUniqueNames, allFieldList);
            List<Object> addIndexFieldList = this.getAddIndexList(allIndexAndUniqueNames, allFieldList);
            List<Object> addUniqueFieldList = this.getAddUniqueList(allIndexAndUniqueNames, allFieldList);
            if (!addFieldList.isEmpty()) {
                ((Map)baseTableMap.get("addTableMap")).put(tableName, new TableConfig(addFieldList));
            }

            if (!removeFieldList.isEmpty()) {
                ((Map)baseTableMap.get("removeTableMap")).put(tableName, new TableConfig(removeFieldList));
            }

            if (!modifyFieldList.isEmpty()) {
                ((Map)baseTableMap.get("modifyTableMap")).put(tableName, new TableConfig(modifyFieldList));
            }

            if (!dropKeyFieldList.isEmpty()) {
                ((Map)baseTableMap.get("dropKeyTableMap")).put(tableName, new TableConfig(dropKeyFieldList));
            }

            if (!dropIndexAndUniqueFieldList.isEmpty()) {
                ((Map)baseTableMap.get("dropIndexAndUniqueTableMap")).put(tableName, new TableConfig(dropIndexAndUniqueFieldList));
            }

            if (!addIndexFieldList.isEmpty()) {
                ((Map)baseTableMap.get("addIndexTableMap")).put(tableName, new TableConfig(addIndexFieldList));
            }

            if (!addUniqueFieldList.isEmpty()) {
                ((Map)baseTableMap.get("addUniqueTableMap")).put(tableName, new TableConfig(addUniqueFieldList));
            }

        }
    }

    private List<Object> getAddIndexList(Set<String> allIndexAndUniqueNames, List<Object> allFieldList) {
        List<Object> addIndexFieldList = new ArrayList();
        if (null == allIndexAndUniqueNames) {
            allIndexAndUniqueNames = new HashSet();
        }

        Iterator var4 = allFieldList.iterator();

        while(var4.hasNext()) {
            Object obj = var4.next();
            CreateTableParam createTableParam = (CreateTableParam)obj;
            if (null != createTableParam.getFiledIndexName() && !((Set)allIndexAndUniqueNames).contains(createTableParam.getFiledIndexName())) {
                addIndexFieldList.add(createTableParam);
            }
        }

        return addIndexFieldList;
    }

    private List<Object> getAddUniqueList(Set<String> allIndexAndUniqueNames, List<Object> allFieldList) {
        List<Object> addUniqueFieldList = new ArrayList();
        if (null == allIndexAndUniqueNames) {
            allIndexAndUniqueNames = new HashSet();
        }

        Iterator var4 = allFieldList.iterator();

        while(var4.hasNext()) {
            Object obj = var4.next();
            CreateTableParam createTableParam = (CreateTableParam)obj;
            if (null != createTableParam.getFiledUniqueName() && !((Set)allIndexAndUniqueNames).contains(createTableParam.getFiledUniqueName())) {
                addUniqueFieldList.add(createTableParam);
            }
        }

        return addUniqueFieldList;
    }

    private List<Object> getDropIndexAndUniqueList(Set<String> allIndexAndUniqueNames, List<Object> allFieldList) {
        List<Object> dropIndexAndUniqueFieldList = new ArrayList();
        if (null != allIndexAndUniqueNames && allIndexAndUniqueNames.size() != 0) {
            List<String> currentModelIndexAndUnique = new ArrayList();
            Iterator var5 = allFieldList.iterator();

            while(var5.hasNext()) {
                Object obj = var5.next();
                CreateTableParam createTableParam = (CreateTableParam)obj;
                if (null != createTableParam.getFiledIndexName()) {
                    currentModelIndexAndUnique.add(createTableParam.getFiledIndexName());
                }

                if (null != createTableParam.getFiledUniqueName()) {
                    currentModelIndexAndUnique.add(createTableParam.getFiledUniqueName());
                }
            }

            var5 = allIndexAndUniqueNames.iterator();

            while(var5.hasNext()) {
                String string = (String)var5.next();
                if (!currentModelIndexAndUnique.contains(string)) {
                    dropIndexAndUniqueFieldList.add(string);
                }
            }

            return dropIndexAndUniqueFieldList;
        } else {
            return dropIndexAndUniqueFieldList;
        }
    }

    private List<Object> getDropKeyFieldList(List<SysMysqlColumns> tableColumnList, List<Object> allFieldList) {
        Map<String, CreateTableParam> fieldMap = this.getAllFieldMap(allFieldList);
        List<Object> dropKeyFieldList = new ArrayList();
        Iterator var5 = tableColumnList.iterator();

        while(var5.hasNext()) {
            SysMysqlColumns sysColumn = (SysMysqlColumns)var5.next();
            CreateTableParam createTableParam = (CreateTableParam)fieldMap.get(sysColumn.getColumn_name().toLowerCase());
            if (createTableParam != null && "PRI".equals(sysColumn.getColumn_key()) && !createTableParam.isFieldIsKey()) {
                dropKeyFieldList.add(createTableParam);
            }
        }

        return dropKeyFieldList;
    }

    private List<Object> getModifyFieldList(List<SysMysqlColumns> tableColumnList, List<Object> allFieldList) {
        Map<String, CreateTableParam> fieldMap = this.getAllFieldMap(allFieldList);
        List<Object> modifyFieldList = new ArrayList();
        Set<String> ignoredTypes = Sets.newHashSet(new String[]{"int", "bigint", "tinyint", "int(0)", "bigint(0)", "tinyint(0)"});
        Iterator var6 = tableColumnList.iterator();

        while(true) {
            while(true) {
                SysMysqlColumns sysColumn;
                CreateTableParam createTableParam;
                do {
                    do {
                        if (!var6.hasNext()) {
                            return modifyFieldList;
                        }

                        sysColumn = (SysMysqlColumns)var6.next();
                        createTableParam = (CreateTableParam)fieldMap.get(sysColumn.getColumn_name().toLowerCase());
                    } while(createTableParam == null);
                } while(createTableParam.getIgnoreUpdate());

                CreateTableParam modifyTableParam = createTableParam.clone();
                if (!"PRI".equals(sysColumn.getColumn_key()) && createTableParam.isFieldIsKey()) {
                    modifyFieldList.add(modifyTableParam);
                } else {
                    if ("PRI".equals(sysColumn.getColumn_key()) && createTableParam.isFieldIsKey()) {
                        modifyTableParam.setFieldIsKey(false);
                    }

                    if (!sysColumn.getData_type().toLowerCase().equals(createTableParam.getFieldType().toLowerCase())) {
                        modifyFieldList.add(modifyTableParam);
                    } else {
                        String typeAndLength = createTableParam.getFieldType().toLowerCase();
                        if (createTableParam.getFileTypeLength() == 1) {
                            typeAndLength = typeAndLength + "(" + createTableParam.getFieldLength() + ")";
                        } else if (createTableParam.getFileTypeLength() == 2) {
                            typeAndLength = typeAndLength + "(" + createTableParam.getFieldLength() + "," + createTableParam.getFieldDecimalLength() + ")";
                        }

                        String columnType = sysColumn.getColumn_type().toLowerCase();
                        if (!columnType.equals(typeAndLength) && !ignoredTypes.contains(columnType)) {
                            modifyFieldList.add(modifyTableParam);
                        } else if ("auto_increment".equals(sysColumn.getExtra()) && !createTableParam.isFieldIsAutoIncrement()) {
                            modifyFieldList.add(modifyTableParam);
                        } else if (!"auto_increment".equals(sysColumn.getExtra()) && createTableParam.isFieldIsAutoIncrement()) {
                            modifyFieldList.add(modifyTableParam);
                        } else {
                            String fieldDefaultValue = createTableParam.getFieldDefaultValue();
                            if (sysColumn.getColumn_default() != null && !"".equals(sysColumn.getColumn_default())) {
                                if (!sysColumn.getColumn_default().equals(fieldDefaultValue)) {
                                    if (MySqlTypeConstant.BIT.toString().toLowerCase().equals(createTableParam.getFieldType()) && !createTableParam.isFieldDefaultValueNative()) {
                                        if (("true".equals(fieldDefaultValue) || "1".equals(fieldDefaultValue)) && !"b'1'".equals(sysColumn.getColumn_default())) {
                                            modifyFieldList.add(modifyTableParam);
                                            continue;
                                        }

                                        if (("false".equals(fieldDefaultValue) || "0".equals(fieldDefaultValue)) && !"b'0'".equals(sysColumn.getColumn_default())) {
                                            modifyFieldList.add(modifyTableParam);
                                            continue;
                                        }
                                    } else {
                                        if (fieldDefaultValue == null || !fieldDefaultValue.startsWith("'") || !fieldDefaultValue.endsWith("'")) {
                                            modifyFieldList.add(modifyTableParam);
                                            continue;
                                        }

                                        fieldDefaultValue = fieldDefaultValue.substring(1, fieldDefaultValue.length() - 1);
                                        if (!sysColumn.getColumn_default().equals(fieldDefaultValue)) {
                                            modifyFieldList.add(modifyTableParam);
                                            continue;
                                        }
                                    }
                                }
                            } else if (fieldDefaultValue != null && !"".equals(fieldDefaultValue)) {
                                modifyFieldList.add(modifyTableParam);
                                continue;
                            }

                            if (sysColumn.getIs_nullable().equals("NO") && !createTableParam.isFieldIsKey()) {
                                if (createTableParam.isFieldIsNull()) {
                                    modifyFieldList.add(modifyTableParam);
                                    continue;
                                }
                            } else if (sysColumn.getIs_nullable().equals("YES") && !createTableParam.isFieldIsKey() && !createTableParam.isFieldIsNull()) {
                                modifyFieldList.add(modifyTableParam);
                                continue;
                            }

                            if (!sysColumn.getColumn_comment().equals(createTableParam.getFieldComment())) {
                                modifyFieldList.add(modifyTableParam);
                            }
                        }
                    }
                }
            }
        }
    }

    private Map<String, CreateTableParam> getAllFieldMap(List<Object> allFieldList) {
        Map<String, CreateTableParam> fieldMap = new HashMap();
        Iterator var3 = allFieldList.iterator();

        while(var3.hasNext()) {
            Object obj = var3.next();
            CreateTableParam createTableParam = (CreateTableParam)obj;
            fieldMap.put(createTableParam.getFieldName().toLowerCase(), createTableParam);
        }

        return fieldMap;
    }

    private List<Object> getRemoveFieldList(List<String> columnNames, List<Object> allFieldList) {
        List<String> toLowerCaseColumnNames = ClassTools.toLowerCase(columnNames);
        Map<String, CreateTableParam> fieldMap = this.getAllFieldMap(allFieldList);
        List<Object> removeFieldList = new ArrayList();
        Iterator var6 = toLowerCaseColumnNames.iterator();

        while(var6.hasNext()) {
            String fieldNm = (String)var6.next();
            if (fieldMap.get(fieldNm) == null) {
                removeFieldList.add(fieldNm);
            }
        }

        return removeFieldList;
    }

    private List<Object> getAddFieldList(List<Object> allFieldList, List<String> columnNames) {
        List<String> toLowerCaseColumnNames = ClassTools.toLowerCase(columnNames);
        List<Object> addFieldList = new ArrayList();
        Iterator var5 = allFieldList.iterator();

        while(var5.hasNext()) {
            Object obj = var5.next();
            CreateTableParam createTableParam = (CreateTableParam)obj;
            if (!toLowerCaseColumnNames.contains(createTableParam.getFieldName().toLowerCase())) {
                addFieldList.add(obj);
            }
        }

        return addFieldList;
    }

    public List<Object> getAllFields(Class<?> clas) {
        List<Object> fieldList = new ArrayList();
        Field[] fields = clas.getDeclaredFields();
        fields = this.recursionParents(clas, fields);
        Field[] var4 = fields;
        int var5 = fields.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field field = var4[var6];
            if (ColumnUtils.isIncloudField(field, clas)) {
                CreateTableParam param = new CreateTableParam();
                param.setFieldName(ColumnUtils.getColumnName(field));
                MySqlTypeAndLength mySqlTypeAndLength = ColumnUtils.getMySqlTypeAndLength(field, clas);
                param.setFieldType(mySqlTypeAndLength.getType().toLowerCase());
                param.setFileTypeLength(mySqlTypeAndLength.getLengthCount());
                if (mySqlTypeAndLength.getLengthCount() == 1) {
                    param.setFieldLength(mySqlTypeAndLength.getLength());
                } else if (mySqlTypeAndLength.getLengthCount() == 2) {
                    param.setFieldLength(mySqlTypeAndLength.getLength());
                    param.setFieldDecimalLength(mySqlTypeAndLength.getDecimalLength());
                }

                param.setFieldIsNull(ColumnUtils.isNull(field, clas));
                param.setFieldIsKey(ColumnUtils.isKey(field, clas));
                param.setFieldIsAutoIncrement(ColumnUtils.isAutoIncrement(field, clas));
                param.setFieldDefaultValue(ColumnUtils.getDefaultValue(field, clas));
                param.setFieldDefaultValueNative(ColumnUtils.getDefaultValueNative(field, clas));
                param.setFieldComment(ColumnUtils.getComment(field, clas));
                Index index = (Index)AnnotatedElementUtils.findMergedAnnotation(field, Index.class);
                if (null != index) {
                    String[] indexValue = index.columns();
                    param.setFiledIndexName(index.value() != null && !index.value().equals("") ? this.idxPrefix + index.value() : this.idxPrefix + (indexValue.length == 0 ? ColumnUtils.getColumnName(field) : this.stringArrFormat(indexValue)));
                    param.setFiledIndexValue(indexValue.length == 0 ? Arrays.asList(ColumnUtils.getColumnName(field)) : Arrays.asList(indexValue));
                }

                Unique unique = (Unique)AnnotatedElementUtils.findMergedAnnotation(field, Unique.class);
                if (null != unique) {
                    String[] uniqueValue = unique.columns();
                    param.setFiledUniqueName("".equals(unique.value()) ? this.uniPrefix + (uniqueValue.length == 0 ? ColumnUtils.getColumnName(field) : this.stringArrFormat(uniqueValue)) : this.uniPrefix + unique.value());
                    param.setFiledUniqueValue(uniqueValue.length == 0 ? Collections.singletonList(ColumnUtils.getColumnName(field)) : Arrays.asList(uniqueValue));
                }

                IgnoreUpdate ignoreUpdate = (IgnoreUpdate)AnnotatedElementUtils.findMergedAnnotation(field, IgnoreUpdate.class);
                if (null != ignoreUpdate) {
                    param.setIgnoreUpdate(ignoreUpdate.value());
                }

                fieldList.add(param);
            }
        }

        return fieldList;
    }

    private String stringArrFormat(String[] arr) {
        return Arrays.toString(arr).replace(",", "_").replace(" ", "").replace("[", "").replace("]", "");
    }

    private Field[] recursionParents(Class<?> clas, Field[] fields) {
        if (clas.getSuperclass() != null) {
            Class clsSup = clas.getSuperclass();
            List<Field> cfieldList = new ArrayList(Arrays.asList(fields));
            Field[] fieldsSup = clsSup.getDeclaredFields();
            List<Field> fieldList = new ArrayList(Arrays.asList(fieldsSup));
            List<String> pfNames = this.getFieldNames(fieldList);
            int cfieldLength = cfieldList.size();

            for(int i = 0; i < cfieldLength; ++i) {
                Field cfield = cfieldList.get(i);
                Boolean isContain = false;
                for (int j = 0; j < pfNames.size(); j++) {
                    if(pfNames.get(j).equals(cfield.getName())){
                        fieldList.set(j,cfield);
                        isContain = true;
                    }
                }
                if(!isContain) fieldList.add(cfield);
            }

            fields = new Field[fieldList.size()];
            int i = 0;
            Object[] var12 = fieldList.toArray();

            for(int var13 = 0; var13 < var12.length; ++var13) {
                Object field = var12[var13];
                fields[i] = (Field)field;
                ++i;
            }

            fields = this.recursionParents(clsSup, fields);
        }

        return fields;
    }

    private List<String> getFieldNames(List<Field> fieldList) {
        List<String> fdNames = new ArrayList();
        Iterator var3 = fieldList.iterator();

        while(var3.hasNext()) {
            Field fd = (Field)var3.next();
            fdNames.add(fd.getName());
        }

        return fdNames;
    }

    private void createOrModifyTableConstruct(Map<String, Map<String, TableConfig>> baseTableMap) {
        this.createTableByMap((Map)baseTableMap.get("newTableMap"));
        if (!"add".equals(this.tableAuto)) {
            this.dropFieldsKeyByMap((Map)baseTableMap.get("dropKeyTableMap"));
        }

        if (!"add".equals(this.tableAuto)) {
            this.dropIndexAndUniqueByMap((Map)baseTableMap.get("dropIndexAndUniqueTableMap"));
            this.removeFieldsByMap((Map)baseTableMap.get("removeTableMap"));
            this.modifyTableCommentByMap((Map)baseTableMap.get("modifyTablePropertyMap"));
            this.modifyFieldsByMap((Map)baseTableMap.get("modifyTableMap"));
        }

        this.addFieldsByMap((Map)baseTableMap.get("addTableMap"));
        this.addIndexByMap((Map)baseTableMap.get("addIndexTableMap"));
        this.addUniqueByMap((Map)baseTableMap.get("addUniqueTableMap"));
    }

    private void dropIndexAndUniqueByMap(Map<String, TableConfig> dropIndexAndUniqueMap) {
        if (dropIndexAndUniqueMap.size() > 0) {
            Iterator var2 = dropIndexAndUniqueMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, TableConfig> entry = (Entry)var2.next();
                Iterator var4 = ((TableConfig)entry.getValue()).getList().iterator();

                while(var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    log.info("开始删除表" + (String)entry.getKey() + "中的索引" + obj);
                    this.createMysqlTablesMapper.dropTabelIndex(map);
                    log.info("完成删除表" + (String)entry.getKey() + "中的索引" + obj);
                }
            }
        }

    }

    private void addIndexByMap(Map<String, TableConfig> addIndexMap) {
        if (addIndexMap.size() > 0) {
            Iterator var2 = addIndexMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, TableConfig> entry = (Entry)var2.next();
                Iterator var4 = ((TableConfig)entry.getValue()).getList().iterator();

                while(var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    CreateTableParam fieldProperties = (CreateTableParam)obj;
                    if (null != fieldProperties.getFiledIndexName()) {
                        log.info("开始创建表" + (String)entry.getKey() + "中的索引" + fieldProperties.getFiledIndexName());
                        this.createMysqlTablesMapper.addTableIndex(map);
                        log.info("完成创建表" + (String)entry.getKey() + "中的索引" + fieldProperties.getFiledIndexName());
                    }
                }
            }
        }

    }

    private void addUniqueByMap(Map<String, TableConfig> addUniqueMap) {
        if (addUniqueMap.size() > 0) {
            Iterator var2 = addUniqueMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, TableConfig> entry = (Entry)var2.next();
                Iterator var4 = ((TableConfig)entry.getValue()).getList().iterator();

                while(var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    CreateTableParam fieldProperties = (CreateTableParam)obj;
                    if (null != fieldProperties.getFiledUniqueName()) {
                        log.info("开始创建表" + (String)entry.getKey() + "中的唯一约束" + fieldProperties.getFiledUniqueName());
                        this.createMysqlTablesMapper.addTableUnique(map);
                        log.info("完成创建表" + (String)entry.getKey() + "中的唯一约束" + fieldProperties.getFiledUniqueName());
                    }
                }
            }
        }

    }

    private void modifyFieldsByMap(Map<String, TableConfig> modifyTableMap) {
        if (modifyTableMap.size() > 0) {
            Iterator var2 = modifyTableMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, TableConfig> entry = (Entry)var2.next();
                Iterator var4 = ((TableConfig)entry.getValue()).getList().iterator();

                while(var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    CreateTableParam fieldProperties = (CreateTableParam)obj;
                    log.info("开始修改表{}中的字段{}", entry.getKey(), fieldProperties.getFieldName());
                    this.createMysqlTablesMapper.modifyTableField(map);
                    log.info("完成修改表{}中的字段{}", entry.getKey(), fieldProperties.getFieldName());
                }
            }
        }

    }

    private void removeFieldsByMap(Map<String, TableConfig> removeTableMap) {
        if (removeTableMap.size() > 0) {
            Iterator var2 = removeTableMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, TableConfig> entry = (Entry)var2.next();
                Iterator var4 = ((TableConfig)entry.getValue()).getList().iterator();

                while(var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    String fieldName = (String)obj;
                    log.info("开始删除表" + (String)entry.getKey() + "中的字段" + fieldName);
                    this.createMysqlTablesMapper.removeTableField(map);
                    log.info("完成删除表" + (String)entry.getKey() + "中的字段" + fieldName);
                }
            }
        }

    }

    private void modifyTableCommentByMap(Map<String, TableConfig> modifyTableCommentMap) {
        if (modifyTableCommentMap.size() > 0) {
            Iterator var2 = modifyTableCommentMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, TableConfig> entry = (Entry)var2.next();
                Iterator var4 = ((TableConfig)entry.getValue()).getMap().keySet().iterator();

                while(var4.hasNext()) {
                    String property = (String)var4.next();
                    Map<String, TableConfig> map = new HashMap();
                    Map<String, Object> tcMap = new HashMap();
                    Object value = ((TableConfig)entry.getValue()).getMap().get(property);
                    tcMap.put(property, value);
                    map.put(entry.getKey(), new TableConfig(tcMap));
                    log.info("开始更新表" + (String)entry.getKey() + "的" + property + "为" + value);
                    this.createMysqlTablesMapper.modifyTableProperty(map);
                    log.info("完成更新表" + (String)entry.getKey() + "的" + property + "为" + value);
                }
            }
        }

    }

    private void addFieldsByMap(Map<String, TableConfig> addTableMap) {
        if (addTableMap.size() > 0) {
            Iterator var2 = addTableMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, TableConfig> entry = (Entry)var2.next();
                Iterator var4 = ((TableConfig)entry.getValue()).getList().iterator();

                while(var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    CreateTableParam fieldProperties = (CreateTableParam)obj;
                    log.info("开始为表" + (String)entry.getKey() + "增加字段" + fieldProperties.getFieldName());
                    this.createMysqlTablesMapper.addTableField(map);
                    log.info("完成为表" + (String)entry.getKey() + "增加字段" + fieldProperties.getFieldName());
                }
            }
        }

    }

    private void dropFieldsKeyByMap(Map<String, TableConfig> dropKeyTableMap) {
        if (dropKeyTableMap.size() > 0) {
            Iterator var2 = dropKeyTableMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, TableConfig> entry = (Entry)var2.next();
                Iterator var4 = ((TableConfig)entry.getValue()).getList().iterator();

                while(var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    CreateTableParam fieldProperties = (CreateTableParam)obj;
                    log.info("开始为表" + (String)entry.getKey() + "删除主键" + fieldProperties.getFieldName());
                    this.createMysqlTablesMapper.dropKeyTableField(map);
                    log.info("完成为表" + (String)entry.getKey() + "删除主键" + fieldProperties.getFieldName());
                }
            }
        }

    }

    private void createTableByMap(Map<String, TableConfig> newTableMap) {
        if (newTableMap.size() > 0) {
            Iterator var2 = newTableMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, TableConfig> entry = (Entry)var2.next();
                Map<String, TableConfig> map = new HashMap();
                map.put(entry.getKey(), entry.getValue());
                log.info("开始创建表：" + (String)entry.getKey());
                this.createMysqlTablesMapper.createTable(map);
                log.info("完成创建表：" + (String)entry.getKey());
            }
        }

    }
}
