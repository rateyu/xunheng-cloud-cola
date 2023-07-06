/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : xhcc-system

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 06/07/2023 18:04:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_custom_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_custom_config`;
CREATE TABLE `sys_custom_config` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `config_key` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `config_value` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `personal` int(11) DEFAULT NULL,
  `config_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `config_title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_custom_config
-- ----------------------------
BEGIN;
INSERT INTO `sys_custom_config` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `user_id`, `config_key`, `config_value`, `personal`, `config_type`, `config_title`) VALUES ('1674711909625495554', '682265633886208', '2023-06-30 17:30:09', NULL, NULL, 0, '999', '999', '999', '-1', 'token', '123456', 0, 'msg', '短信通道token');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sort_order` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `type`, `description`, `sort_order`) VALUES ('1477141639434784770', '682265633886208', '2022-01-01 12:56:25', '682265633886208', '2022-01-01 13:08:23', 0, '999', NULL, NULL, '性别', 'sex', '111', 0.00);
INSERT INTO `sys_dict` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `type`, `description`, `sort_order`) VALUES ('1479394221582655490', '682265633886208', '2022-01-07 18:07:23', NULL, NULL, 0, '999', NULL, NULL, '功能库类型', 'actionGroup', '', 0.00);
INSERT INTO `sys_dict` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `type`, `description`, `sort_order`) VALUES ('1481868594822414337', '682265633886208', '2022-01-14 13:59:39', '682265633886208', '2022-01-14 13:59:46', 0, '999', '999', '999', '上传存储方式', 'uploadLocation', '', 2.00);
INSERT INTO `sys_dict` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `type`, `description`, `sort_order`) VALUES ('1522834517238349825', '682265633886208', '2022-05-07 15:03:36', '682265633886208', '2022-05-11 12:21:42', 0, '999', '999', '999', '系统消息类型', 'notice', '', 3.00);
INSERT INTO `sys_dict` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `type`, `description`, `sort_order`) VALUES ('1524243023816429569', '682265633886208', '2022-05-11 12:20:31', '682265633886208', '2022-05-11 12:56:30', 0, '999', '999', '999', '自定义配置类型', 'customConfig', '', 4.00);
INSERT INTO `sys_dict` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `type`, `description`, `sort_order`) VALUES ('1547793696688390145', '682265633886208', '2022-07-15 12:02:29', NULL, NULL, 0, '999', '999', '999', '流程定义类型', 'processDef', '', 5.00);
INSERT INTO `sys_dict` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `type`, `description`, `sort_order`) VALUES ('1552604535652012033', '682265633886208', '2022-07-28 18:39:02', NULL, NULL, 0, '999', '999', '999', '矩阵列类型', 'matrixColumn', '', 6.00);
INSERT INTO `sys_dict` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `type`, `description`, `sort_order`) VALUES ('1635278438769287169', '682265633886208', '2023-03-13 21:55:36', NULL, NULL, 0, '999', '999', '999', '计量单位类型', 'measurementType', '', 7.00);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `value` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sort_order` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dict_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1477183292291862529', '682265633886208', '2022-01-01 15:41:56', '682265633886208', '2023-06-27 19:57:18', 0, '999', NULL, NULL, '男', 'man', 2.00, 0, '男的', '1477141639434784770');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1477183336856342529', '682265633886208', '2022-01-01 15:42:07', '682265633886208', '2023-06-27 19:55:41', 0, '999', NULL, NULL, '女', 'woman', 4.00, 0, '女的', '1477141639434784770');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1479394293858902018', '682265633886208', '2022-01-07 18:07:40', NULL, NULL, 0, '999', NULL, NULL, '系统功能', 'system', 0.00, 0, '', '1479394221582655490');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1481557683574308866', '682265633886208', '2022-01-13 17:24:12', NULL, NULL, 0, '999', '999', '999', '文件系统', 'file', 1.00, 0, '', '1479394221582655490');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1481868688648994817', '682265633886208', '2022-01-14 14:00:02', NULL, NULL, 0, '999', '999', '999', '本地存储', 'local', 0.00, 0, '', '1481868594822414337');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1522834579007864833', '682265633886208', '2022-05-07 15:03:51', NULL, NULL, 0, '999', '999', '999', '系统消息', 'system', 0.00, 0, '', '1522834517238349825');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1522834695886340097', '682265633886208', '2022-05-07 15:04:19', NULL, NULL, 0, '999', '999', '999', '个人私信', 'personal', 1.00, 0, '', '1522834517238349825');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1524243081974648833', '682265633886208', '2022-05-11 12:20:44', '682265633886208', '2022-05-11 12:55:58', 0, '999', '999', '999', '短信', 'msg', 0.50, 0, '', '1524243023816429569');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1524243149611995138', '682265633886208', '2022-05-11 12:21:01', '682265633886208', '2022-05-11 12:21:12', 0, '999', '999', '999', '其他', 'other', 100.00, 0, '', '1524243023816429569');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1524244330417623042', '682265633886208', '2022-05-11 12:25:42', NULL, NULL, 0, '999', '999', '999', '文件', 'file', 1.00, 0, '', '1524243023816429569');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1524251924372885505', '682265633886208', '2022-05-11 12:55:53', NULL, NULL, 0, '999', '999', '999', '个性化设置', 'personal', 0.00, 0, '', '1524243023816429569');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1547793775641968641', '682265633886208', '2022-07-15 12:02:47', NULL, NULL, 0, '999', '999', '999', '人事流程', 'hr', 0.00, 0, '', '1547793696688390145');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1547794116408197121', '682265633886208', '2022-07-15 12:04:09', NULL, NULL, 0, '999', '999', '999', '行政流程', 'adm', 1.00, 0, '', '1547793696688390145');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1547853645221134338', '682265633886208', '2022-07-15 16:00:41', NULL, NULL, 0, '999', '999', '999', '流程引擎', 'processEngine', 2.00, 0, '', '1479394221582655490');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1552605132266590209', '682265633886208', '2022-07-28 18:41:24', NULL, NULL, 0, '999', '999', '999', '人员', 'human', 3.00, 0, '', '1552604535652012033');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1552605329503735809', '682265633886208', '2022-07-28 18:42:11', NULL, NULL, 0, '999', '999', '999', '普通文本', 'text', 4.00, 0, '', '1552604535652012033');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1554864915094884353', '682265633886208', '2022-08-04 00:20:58', NULL, NULL, 0, '999', '999', '999', '日期', 'date', 5.00, 0, '', '1552604535652012033');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1555092018566467585', '682265633886208', '2022-08-04 15:23:24', NULL, NULL, 0, '999', '999', '999', '组织架构', 'org', 0.00, 0, '', '1552604535652012033');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1635278487003783170', '682265633886208', '2023-03-13 21:55:48', NULL, NULL, 0, '999', '999', '999', '数量', '1', 0.00, 0, '', '1635278438769287169');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1635278519631273985', '682265633886208', '2023-03-13 21:55:56', NULL, NULL, 0, '999', '999', '999', '重量', '0', 1.00, 0, '', '1635278438769287169');
INSERT INTO `sys_dict_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `value`, `sort_order`, `status`, `description`, `dict_id`) VALUES ('1635903883470626817', '682265633886208', '2023-03-15 15:20:54', NULL, NULL, 0, '999', '999', '999', 'erp', 'erp', 3.00, 0, '', '1479394221582655490');
COMMIT;

-- ----------------------------
-- Table structure for sys_feedback
-- ----------------------------
DROP TABLE IF EXISTS `sys_feedback`;
CREATE TABLE `sys_feedback` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` text COLLATE utf8_bin,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_feedback
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_matrix
-- ----------------------------
DROP TABLE IF EXISTS `sys_matrix`;
CREATE TABLE `sys_matrix` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_matrix
-- ----------------------------
BEGIN;
INSERT INTO `sys_matrix` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `name`, `description`) VALUES ('1552586045784199169', '682265633886208', '2022-07-28 17:25:34', '682265633886208', '2023-06-30 17:31:08', 0, '999', '999', '999', '财务矩阵', '每个分公司对应的会计/出纳');
INSERT INTO `sys_matrix` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `name`, `description`) VALUES ('1552594945602408450', '682265633886208', '2022-07-28 18:00:56', '682265633886208', '2023-06-30 17:32:55', 0, '999', '999', '999', '银行卡矩阵', '各分子公司与对应的银行卡');
INSERT INTO `sys_matrix` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `name`, `description`) VALUES ('1552595360582651906', '682265633886208', '2022-07-28 18:02:34', '682265633886208', '2023-06-30 17:33:03', 0, '999', '999', '999', '公司负责人矩阵', '公司负责人矩阵');
INSERT INTO `sys_matrix` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `name`, `description`) VALUES ('1673977674191101954', '682265633886208', '2023-06-28 16:52:33', '682265633886208', '2023-06-30 17:33:18', 0, '999', '999', '999', '测试', '测测测');
COMMIT;

-- ----------------------------
-- Table structure for sys_matrix_column
-- ----------------------------
DROP TABLE IF EXISTS `sys_matrix_column`;
CREATE TABLE `sys_matrix_column` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `matrix_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sort_order` decimal(10,2) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tag` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_matrix_column
-- ----------------------------
BEGIN;
INSERT INTO `sys_matrix_column` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `matrix_id`, `type`, `sort_order`, `title`, `tag`) VALUES ('1673986394220482562', '682265633886208', '2023-06-30 17:31:47', NULL, NULL, '999', '999', '999', '1552586045784199169', 'text', 0.00, '公司名称', 'company');
INSERT INTO `sys_matrix_column` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `matrix_id`, `type`, `sort_order`, `title`, `tag`) VALUES ('1673986396867088385', '682265633886208', '2023-06-30 17:31:47', NULL, NULL, '999', '999', '999', '1552586045784199169', 'human', 1.00, '出纳', 'cn');
INSERT INTO `sys_matrix_column` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `matrix_id`, `type`, `sort_order`, `title`, `tag`) VALUES ('1674712323859152898', '682265633886208', '2023-06-30 17:31:47', NULL, NULL, '999', '999', '999', '1552586045784199169', 'human', 2.00, '会计', 'kj');
COMMIT;

-- ----------------------------
-- Table structure for sys_matrix_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_matrix_data`;
CREATE TABLE `sys_matrix_data` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `data` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `row_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `matrix_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `column_tag` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_matrix_data
-- ----------------------------
BEGIN;
INSERT INTO `sys_matrix_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `data`, `row_id`, `matrix_id`, `column_tag`) VALUES ('1673991915971346433', '682265633886208', '2023-06-28 17:49:09', '682265633886208', '2023-06-30 17:32:25', '999', '999', '999', '11', '1673991915953065984', '1552586045784199169', 'name');
INSERT INTO `sys_matrix_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `data`, `row_id`, `matrix_id`, `column_tag`) VALUES ('1673991918479540226', '682265633886208', '2023-06-28 17:49:09', '682265633886208', '2023-06-30 17:32:25', '999', '999', '999', '', '1673991915953065984', '1552586045784199169', 'age');
INSERT INTO `sys_matrix_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `data`, `row_id`, `matrix_id`, `column_tag`) VALUES ('1673993017101950977', '682265633886208', '2023-06-28 17:53:31', '682265633886208', '2023-06-30 17:32:25', '999', '999', '999', '', '1673993017087889408', '1552586045784199169', 'name');
INSERT INTO `sys_matrix_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `data`, `row_id`, `matrix_id`, `column_tag`) VALUES ('1673993017731096578', '682265633886208', '2023-06-28 17:53:32', '682265633886208', '2023-06-30 17:32:25', '999', '999', '999', '12', '1673993017087889408', '1552586045784199169', 'age');
INSERT INTO `sys_matrix_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `data`, `row_id`, `matrix_id`, `column_tag`) VALUES ('1674712481426571266', '682265633886208', '2023-06-30 17:32:25', NULL, NULL, '999', '999', '999', '公司1', '1673991915953065984', '1552586045784199169', 'company');
INSERT INTO `sys_matrix_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `data`, `row_id`, `matrix_id`, `column_tag`) VALUES ('1674712481539817474', '682265633886208', '2023-06-30 17:32:25', NULL, NULL, '999', '999', '999', '{id=1642855955355975681, username=体验账号4}', '1673991915953065984', '1552586045784199169', 'cn');
INSERT INTO `sys_matrix_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `data`, `row_id`, `matrix_id`, `column_tag`) VALUES ('1674712481665646594', '682265633886208', '2023-06-30 17:32:25', NULL, NULL, '999', '999', '999', '{id=1642855819389222913, username=体验账号3}', '1673991915953065984', '1552586045784199169', 'kj');
INSERT INTO `sys_matrix_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `data`, `row_id`, `matrix_id`, `column_tag`) VALUES ('1674712482047328257', '682265633886208', '2023-06-30 17:32:25', NULL, NULL, '999', '999', '999', '公司2', '1673993017087889408', '1552586045784199169', 'company');
INSERT INTO `sys_matrix_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `data`, `row_id`, `matrix_id`, `column_tag`) VALUES ('1674712482185740290', '682265633886208', '2023-06-30 17:32:25', NULL, NULL, '999', '999', '999', '{id=1642855955355975681, username=体验账号4}', '1673993017087889408', '1552586045784199169', 'cn');
INSERT INTO `sys_matrix_data` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`, `data`, `row_id`, `matrix_id`, `column_tag`) VALUES ('1674712482353512450', '682265633886208', '2023-06-30 17:32:25', NULL, NULL, '999', '999', '999', '{id=1642855819389222913, username=体验账号3}', '1673993017087889408', '1552586045784199169', 'kj');
COMMIT;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_pub` int(11) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
BEGIN;
INSERT INTO `sys_notice` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `user_id`, `title`, `description`, `content`, `is_pub`, `type`) VALUES ('1', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, '欢迎', '系统信息', '欢迎使用寻衡CLOUD', 1, 'system');
COMMIT;

-- ----------------------------
-- Table structure for sys_notice_read
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice_read`;
CREATE TABLE `sys_notice_read` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `notice_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_notice_read
-- ----------------------------
BEGIN;
INSERT INTO `sys_notice_read` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `notice_id`, `user_id`) VALUES ('1673560383355998210', '682265633886208', '2023-06-27 13:14:23', NULL, NULL, 0, '999', '999', '999', '1', '682265633886208');
COMMIT;

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parent_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sort_order` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
BEGIN;
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638391972344537089', '682265633886208', '2023-03-22 12:08:37', '682265633886208', '2023-06-27 18:46:11', 0, '1638391972344537089', '999', NULL, '测试租户1', '999', 2.00, 0, 'tenant');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638392079592890369', '682265633886208', '2023-03-22 12:08:29', '682265633886208', '2023-03-22 12:09:53', 0, '1638392079592890369', '999', NULL, '测试租户2', '999', 3.00, 0, 'tenant');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638392677037940737', '682265633886208', '2023-03-22 12:10:29', '682265633886208', '2023-03-22 12:12:34', 0, '1638391972344537089', '999', '1638391972344537089', '1采购部', '1638391972344537089', 0.00, 0, 'department');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638393211522293762', '682265633886208', '2023-03-22 12:12:36', '682265633886208', '2023-03-22 12:12:49', 0, '1638391972344537089', '999', '1638391972344537089', '1销售部', '1638391972344537089', 1.00, 0, 'department');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638393273019179009', '682265633886208', '2023-03-22 12:12:51', '682265633886208', '2023-03-22 12:13:01', 0, '1638391972344537089', '999', '1638391972344537089', '1生产部A', '1638391972344537089', 2.00, 0, 'department');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638393331013820417', '682265633886208', '2023-03-22 12:13:05', '682265633886208', '2023-03-22 12:13:13', 0, '1638391972344537089', '999', '1638391972344537089', '1生产部B', '1638391972344537089', 3.00, 0, 'department');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638393377738366978', '682265633886208', '2023-03-22 12:13:16', '682265633886208', '2023-03-22 12:13:26', 0, '1638392079592890369', '999', '1638392079592890369', '2采购部', '1638392079592890369', 0.00, 0, 'department');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638393427013050369', '682265633886208', '2023-03-22 12:13:28', '682265633886208', '2023-03-22 12:13:43', 0, '1638392079592890369', '999', '1638392079592890369', '2销售部', '1638392079592890369', 1.00, 0, 'department');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638393504716726274', '682265633886208', '2023-03-22 12:13:46', '682265633886208', '2023-03-22 12:14:10', 0, '1638392079592890369', '999', '1638392079592890369', '2生产部A', '1638392079592890369', 2.00, 0, 'department');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638393615807062017', '682265633886208', '2023-03-22 12:14:13', '682265633886208', '2023-03-22 12:14:23', 0, '1638392079592890369', '999', NULL, '2生产部B', '1638392079592890369', 3.00, 0, 'department');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638399392198311938', '682265633886208', '2023-03-22 12:37:10', '682265633886208', '2023-03-22 12:38:37', 0, '1638391972344537089', '999', '1638391972344537089', '1经理室', '1638391972344537089', 0.00, 0, 'department');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('1638399455054151681', '682265633886208', '2023-03-22 12:37:25', '682265633886208', '2023-03-22 12:38:36', 0, '1638392079592890369', '999', '1638392079592890369', '2经理室', '1638392079592890369', 0.00, 0, 'department');
INSERT INTO `sys_organization` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `title`, `parent_id`, `sort_order`, `status`, `type`) VALUES ('999', '682265633886208', '2021-12-21 22:50:22', '682265633886208', '2023-06-30 18:45:28', 0, '999', NULL, NULL, '寻衡cloud', NULL, 0.00, 0, 'hq');
COMMIT;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `component` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parent_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sort_order` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `fullpage` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1', '682265633886208', '2021-12-21 00:54:31', '682265633886208', '2023-03-13 23:58:33', 0, NULL, NULL, NULL, 'system', 'menu', '系统', '/system', NULL, 'el-icon-setting', NULL, 0.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1472865995263754242', '682265633886208', '2021-12-20 17:46:32', '682265633886208', '2023-06-30 17:03:40', 0, NULL, NULL, NULL, 'organization-manage', 'menu', '组织架构管理', '/system/setting/organization-manage', 'system/setting/organization-manage', 'el-icon-share', '2', 1.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1472866650397261825', '682265633886208', '2021-12-20 17:49:09', '682265633886208', '2023-06-28 19:10:41', 0, NULL, NULL, NULL, 'user-manage', 'menu', '系统用户管理', '/system/setting/user-manage', 'system/setting/user-manage', 'el-icon-avatar', '2', 0.00, 0, b'0');
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1472867171975741441', '682265633886208', '2021-12-20 17:51:13', '682265633886208', '2023-06-30 17:15:39', 0, NULL, NULL, NULL, 'tenant-manage', 'menu', '平台租户信息', '/system/tenant-setting/tenant-manage', 'system/tenant-setting/tenant-manage', 'el-icon-home-filled', '1472972040162189313', 0.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1472972040162189313', '682265633886208', '2021-12-21 00:47:56', '682265633886208', '2021-12-21 00:49:16', 0, NULL, NULL, NULL, 'tenant-setting', 'menu', '平台租户设置', '/system/tenant-setting', '', 'el-icon-house', '1', 1.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1472972566912245761', '682265633886208', '2021-12-21 00:50:01', '682265633886208', '2023-06-30 17:15:34', 0, NULL, NULL, NULL, 'tenant-auth', 'menu', '平台租户授权', '/system/tenant-setting/tenant-auth', 'system/tenant-setting/tenant-auth', 'el-icon-document-add', '1472972040162189313', 1.00, 0, b'0');
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1474027520317886465', '682265633886208', '2021-12-23 22:42:02', '682265633886208', '2023-06-30 17:16:05', 0, NULL, NULL, NULL, 'task-manage', 'menu', '计划任务管理', '/system/setting/task-manage', 'system/setting/task-manage', 'el-icon-calendar', '2', 4.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1475691322109263873', '682265633886208', '2021-12-28 12:53:23', '682265633886208', '2021-12-28 12:54:53', 0, '999', NULL, NULL, 'system-monitor', 'menu', '系统监控', '/system/monitor', '', 'el-icon-odometer', '1', 2.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1475691725383204866', '682265633886208', '2021-12-28 12:54:59', '682265633886208', '2022-01-01 18:16:03', 0, '999', NULL, NULL, 'nacos', 'link', 'nacos监控', 'http://localhost:8848/nacos', '', 'el-icon-help-filled', '1475691322109263873', 2.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1475695680821592066', '682265633886208', '2021-12-28 13:10:42', '682265633886208', '2022-01-01 18:16:06', 0, '999', NULL, NULL, 'sentinel', 'iframe', 'sentinel监控', 'http://localhost:8858', '', 'el-icon-help-filled', '1475691322109263873', 3.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1475842525770227713', '682265633886208', '2021-12-28 22:54:13', '682265633886208', '2023-06-30 17:19:28', 0, '999', NULL, NULL, 'operation-log', 'menu', '操作日志', '/system/monitor/operation-log', 'system/monitor/operation-log', 'el-icon-help-filled', '1475691322109263873', NULL, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1476975283020156929', '682265633886208', '2022-01-01 01:55:23', '682265633886208', '2023-06-30 17:15:58', 0, '999', NULL, NULL, 'dict-manage', 'menu', '数据字典管理', '/system/setting/dict-manage', 'system/setting/dict-manage', 'el-icon-document', '2', 5.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1477222093206827010', '682265633886208', '2022-01-01 18:16:07', '682265633886208', '2023-06-30 17:19:40', 0, '999', NULL, NULL, 'session-manage', 'menu', '会话监控', '/system/monitor/session-manage', 'system/monitor/session-manage', 'el-icon-avatar', '1475691322109263873', 1.00, 0, b'0');
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1480033062375038977', '682265633886208', '2022-01-09 12:25:54', '682265633886208', '2023-06-30 17:04:05', 0, '999', NULL, NULL, 'system-user-resetPass', 'actionGroup', '重置密码', '', '', '', '1472866650397261825', 3.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1480043642439819266', '682265633886208', '2022-01-09 13:07:57', '682265633886208', '2023-06-30 17:03:17', 0, '999', NULL, NULL, 'system-role-perm-edit', 'actionGroup', '分配权限', '', '', NULL, '4', 2.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1480057569806606337', '682265633886208', '2022-01-09 14:03:17', '682265633886208', '2023-06-30 17:09:22', 0, '999', NULL, NULL, 'system-quartz-log-pageList', 'actionGroup', '日志', '', '', NULL, '1474027520317886465', 3.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1480080201729925121', '682265633886208', '2022-01-09 15:33:13', '682265633886208', '2023-06-30 17:19:53', 0, '999', NULL, NULL, 'system-saSession-kickOut', 'actionGroup', '下线', '', '', NULL, '1477222093206827010', 1.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1480080205207003138', '682265633886208', '2022-01-09 15:33:14', '682265633886208', '2023-06-30 17:20:03', 0, '999', NULL, NULL, 'system-saSession-changeSession', 'actionGroup', '切换账号', '', '', NULL, '1477222093206827010', 2.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1482256966501965825', '682265633886208', '2022-01-15 15:42:54', '682265633886208', '2022-01-15 15:43:47', 0, '999', '999', '999', 'generator', 'menu', '代码生成', '/system/generator', '', 'el-icon-monitor', '1', 3.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1482257207691223042', '682265633886208', '2022-01-15 15:43:52', '682265633886208', '2023-07-06 18:03:50', 0, '999', '999', '999', 'code-gen', 'menu', '代码生成', '/system/generator/code-gen', 'system/generator/code-gen', 'el-icon-notebook', '1482256966501965825', 0.00, 0, b'0');
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1524087313912745985', '682265633886208', '2022-05-11 02:01:46', '682265633886208', '2022-05-11 02:06:21', 0, '999', '999', '999', 'extend-config-manage', 'menu', '拓展配置管理', '/system/setting/extend-config-manage', 'system/setting/extend-config-manage', 'el-icon-help-filled', '2', 7.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1552578261495730178', '682265633886208', '2022-07-28 16:54:38', '682265633886208', '2022-07-28 16:55:36', 0, '999', '999', '999', 'matrix-manage', 'menu', '矩阵管理', '/system/setting/matrix-manage', 'system/setting/matrix-manage', 'el-icon-grid', '2', 8.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1552578570175533058', '682265633886208', '2022-07-28 16:55:51', '682265633886208', '2023-06-30 17:13:32', 0, '999', '999', '999', 'system-matrix-basic', 'actionGroup', '基础维护', '', '', '', '1552578261495730178', 1.00, 0, b'0');
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674703117533851649', '682265633886208', '2023-06-30 16:55:12', '682265633886208', '2023-06-30 17:27:20', 0, '999', '999', '999', 'system-user-basic', 'actionGroup', '基础维护', '', '', '', '1472866650397261825', 1.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674703973528383489', '682265633886208', '2023-06-30 16:58:37', '682265633886208', '2023-06-30 16:59:27', 0, '999', '999', '999', 'system-user-status', 'actionGroup', '启用禁用', '', '', '', '1472866650397261825', 2.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674704279796461570', '682265633886208', '2023-06-30 16:59:50', '682265633886208', '2023-06-30 17:00:47', 0, '999', '999', '999', 'system-organization-basic', 'actionGroup', '基础维护', '', '', '', '1472865995263754242', 1.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674704562098286593', '682265633886208', '2023-06-30 17:00:57', '682265633886208', '2023-06-30 17:06:12', 0, '999', '999', '999', 'system-role-basic', 'actionGroup', '基础维护', '', '', NULL, '4', 1.00, 0, b'0');
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674705519834050561', '682265633886208', '2023-06-30 17:04:45', '682265633886208', '2023-06-30 17:06:20', 0, '999', '999', '999', 'system-permission-basic', 'actionGroup', '基础维护', '', '', '', '3', 1.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674705981664669697', '682265633886208', '2023-06-30 17:06:35', '682265633886208', '2023-06-30 17:07:40', 0, '999', '999', '999', 'system-quartz-basic', 'actionGroup', '基础维护', '', '', '', '1474027520317886465', 1.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674706265656799234', '682265633886208', '2023-06-30 17:07:43', '682265633886208', '2023-06-30 17:08:38', 0, '999', '999', '999', '未命名4', 'actionGroup', '执行', '', '', '', '1474027520317886465', 2.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674706758403633154', '682265633886208', '2023-06-30 17:09:41', '682265633886208', '2023-06-30 17:10:24', 0, '999', '999', '999', 'system-dict-basic', 'actionGroup', '字典基础维护', '', '', '', '1476975283020156929', 1.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674706953103224834', '682265633886208', '2023-06-30 17:10:27', '682265633886208', '2023-06-30 17:11:25', 0, '999', '999', '999', 'system-dictdata-basic', 'actionGroup', '字典数据基础维护', '', '', '', '1476975283020156929', 2.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674707781801226242', '682265633886208', '2023-06-30 17:13:45', '682265633886208', '2023-06-30 17:14:29', 0, '999', '999', '999', 'system-tenant-basic', 'actionGroup', '基础维护', '', '', '', '1472867171975741441', 1.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('1674707998801932289', '682265633886208', '2023-06-30 17:14:36', '682265633886208', '2023-06-30 17:15:09', 0, '999', '999', '999', 'system-tenantAuthRecord-basic', 'actionGroup', '基础维护', '', '', '', '1472972566912245761', 1.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('2', '496138616573952', '2021-12-18 13:47:52', '682265633886208', '2021-12-21 00:51:09', 0, NULL, NULL, NULL, 'system-setting', 'menu', '系统设置', '/system/setting', NULL, 'el-icon-grid', '1', 0.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('3', '496138616573952', '2021-12-18 13:47:52', '682265633886208', '2023-06-30 17:04:42', 0, NULL, NULL, NULL, 'menu-manage', 'menu', '菜单权限管理', '/system/setting/menu-manage', 'system/setting/menu-manage', 'el-icon-fold', '2', 3.00, 0, NULL);
INSERT INTO `sys_permission` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `type`, `title`, `path`, `component`, `icon`, `parent_id`, `sort_order`, `status`, `fullpage`) VALUES ('4', '496138616573952', '2021-12-18 21:45:05', '682265633886208', '2023-06-30 17:04:27', 0, NULL, NULL, NULL, 'role-manage', 'menu', '角色权限管理', '/system/setting/role-manage', 'system/setting/role-manage', 'el-icon-notebook', '2', 2.00, 0, b'0');
COMMIT;

-- ----------------------------
-- Table structure for sys_permission_action
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_action`;
CREATE TABLE `sys_permission_action` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `permission_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `actable_idx_permission_id` (`permission_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_permission_action
-- ----------------------------
BEGIN;
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674012434212876290', '682265633886208', '2023-06-28 19:10:41', NULL, NULL, '999', '999', '999', '1472866650397261825', 'system.user.pageList', 0, '分页列表');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674012434984628225', '682265633886208', '2023-06-28 19:10:41', NULL, NULL, '999', '999', '999', '1472866650397261825', 'system.role.allList', 0, '角色列表');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674704184099221505', '682265633886208', '2023-06-30 16:59:27', NULL, NULL, '999', '999', '999', '1674703973528383489', 'system.user.enable', 0, '启用');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674704184535429122', '682265633886208', '2023-06-30 16:59:27', NULL, NULL, '999', '999', '999', '1674703973528383489', 'system.user.disable', 0, '禁用');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674704521698750465', '682265633886208', '2023-06-30 17:00:47', NULL, NULL, '999', '999', '999', '1674704279796461570', 'system.organization.add', 0, '新增');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674704522097209345', '682265633886208', '2023-06-30 17:00:47', NULL, NULL, '999', '999', '999', '1674704279796461570', 'system.organization.edit', 0, '修改');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674704522432753666', '682265633886208', '2023-06-30 17:00:47', NULL, NULL, '999', '999', '999', '1674704279796461570', 'system.organization.deleteBatch', 0, '删除');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705148617175042', '682265633886208', '2023-06-30 17:03:17', NULL, NULL, '999', '999', '999', '1480043642439819266', 'system.role.editRolePerm', 0, '权限分配');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705245098749953', '682265633886208', '2023-06-30 17:03:40', NULL, NULL, '999', '999', '999', '1472865995263754242', 'system.organization.tree', 0, '组织架构树');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705352422600705', '682265633886208', '2023-06-30 17:04:05', NULL, NULL, '999', '999', '999', '1480033062375038977', 'system.user.resetPass', 0, '重制密码');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705443522883586', '682265633886208', '2023-06-30 17:04:27', NULL, NULL, '999', '999', '999', '4', 'system.role.pageList', 0, '分页列表');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705507666374657', '682265633886208', '2023-06-30 17:04:42', NULL, NULL, '999', '999', '999', '3', 'system.permission.tree', 0, '权限树列表');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705886323945474', '682265633886208', '2023-06-30 17:06:13', NULL, NULL, '999', '999', '999', '1674704562098286593', 'system.role.add', 0, '新增');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705886902759426', '682265633886208', '2023-06-30 17:06:13', NULL, NULL, '999', '999', '999', '1674704562098286593', 'system.role.edit', 0, '修改');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705888257519617', '682265633886208', '2023-06-30 17:06:13', NULL, NULL, '999', '999', '999', '1674704562098286593', 'system.role.deleteBatch', 0, '删除');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705916791369730', '682265633886208', '2023-06-30 17:06:20', NULL, NULL, '999', '999', '999', '1674705519834050561', 'system.permission.add', 0, '新增');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705917210800130', '682265633886208', '2023-06-30 17:06:20', NULL, NULL, '999', '999', '999', '1674705519834050561', 'system.permission.edit', 0, '修改');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674705917613453314', '682265633886208', '2023-06-30 17:06:20', NULL, NULL, '999', '999', '999', '1674705519834050561', 'system.permission.deleteBatch', 0, '批量删除');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674706253501706241', '682265633886208', '2023-06-30 17:07:40', NULL, NULL, '999', '999', '999', '1674705981664669697', 'system.quartz.add', 0, '新增');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674706254042771458', '682265633886208', '2023-06-30 17:07:40', NULL, NULL, '999', '999', '999', '1674705981664669697', 'system.quartz.edit', 0, '修改');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674706254676111361', '682265633886208', '2023-06-30 17:07:40', NULL, NULL, '999', '999', '999', '1674705981664669697', 'system.quartz.delete', 0, '删除');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674706496733589506', '682265633886208', '2023-06-30 17:08:38', NULL, NULL, '999', '999', '999', '1674706265656799234', 'system.quartz.pause', 0, '暂停');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674706497132048385', '682265633886208', '2023-06-30 17:08:38', NULL, NULL, '999', '999', '999', '1674706265656799234', 'system.quartz.resume', 0, '恢复');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674706497643753473', '682265633886208', '2023-06-30 17:08:38', NULL, NULL, '999', '999', '999', '1674706265656799234', 'system.quartz.execute', 0, '执行一次');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674706682868412417', '682265633886208', '2023-06-30 17:09:23', NULL, NULL, '999', '999', '999', '1480057569806606337', 'system.quartzLog.pageList', 0, '日志分页');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674706941803769858', '682265633886208', '2023-06-30 17:10:24', NULL, NULL, '999', '999', '999', '1674706758403633154', 'system.dict.add', 0, '新增');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674706942235783170', '682265633886208', '2023-06-30 17:10:24', NULL, NULL, '999', '999', '999', '1674706758403633154', 'system.dict.edit', 0, '修改');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674706942747488257', '682265633886208', '2023-06-30 17:10:24', NULL, NULL, '999', '999', '999', '1674706758403633154', 'system.dict.delete', 0, '删除');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674707198788775937', '682265633886208', '2023-06-30 17:11:26', NULL, NULL, '999', '999', '999', '1674706953103224834', 'system.dictData.add', 0, '新增');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674707199375978498', '682265633886208', '2023-06-30 17:11:26', NULL, NULL, '999', '999', '999', '1674706953103224834', 'system.dictData.edit', 0, '修改');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674707199883489282', '682265633886208', '2023-06-30 17:11:26', NULL, NULL, '999', '999', '999', '1674706953103224834', 'system.dictData.deleteBatch', 0, '删除');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674707200365834241', '682265633886208', '2023-06-30 17:11:26', NULL, NULL, '999', '999', '999', '1674706953103224834', 'system.dictData.enable', 0, '启用');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674707200688795650', '682265633886208', '2023-06-30 17:11:26', NULL, NULL, '999', '999', '999', '1674706953103224834', 'system.dictData.disable', 0, '禁用');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674707729171099650', '682265633886208', '2023-06-30 17:13:32', NULL, NULL, '999', '999', '999', '1552578570175533058', 'system.matrix.add', 0, '新增');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674707970226139138', '682265633886208', '2023-06-30 17:14:29', NULL, NULL, '999', '999', '999', '1674707781801226242', 'system.tenant.add', 0, '新增');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674707970637180929', '682265633886208', '2023-06-30 17:14:30', NULL, NULL, '999', '999', '999', '1674707781801226242', 'system.tenant.edit', 0, '修改');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674707971136303106', '682265633886208', '2023-06-30 17:14:30', NULL, NULL, '999', '999', '999', '1674707781801226242', 'system.tenant.deleteBatch', 0, '删除');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674708135888564226', '682265633886208', '2023-06-30 17:15:09', NULL, NULL, '999', '999', '999', '1674707998801932289', 'system.tenantAuthRecord.add', 0, '新增');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674708136232497153', '682265633886208', '2023-06-30 17:15:09', NULL, NULL, '999', '999', '999', '1674707998801932289', 'system.tenantAuthRecord.edit', 0, '修改');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674708136614178818', '682265633886208', '2023-06-30 17:15:09', NULL, NULL, '999', '999', '999', '1674707998801932289', 'system.tenantAuthRecord.deleteBatch', 0, '删除');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674708243413741570', '682265633886208', '2023-06-30 17:15:35', NULL, NULL, '999', '999', '999', '1472972566912245761', 'system.tenantAuthRecord.pageList', 0, '分页列表');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674708264162963458', '682265633886208', '2023-06-30 17:15:40', NULL, NULL, '999', '999', '999', '1472867171975741441', 'system.tenant.pageList', 0, '分页列表');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674708342164434945', '682265633886208', '2023-06-30 17:15:58', NULL, NULL, '999', '999', '999', '1476975283020156929', 'system.dictData.pageList', 0, '数据分页列表');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674708342701305857', '682265633886208', '2023-06-30 17:15:58', NULL, NULL, '999', '999', '999', '1476975283020156929', 'system.dict.allList', 0, '字典列表');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674708369607766017', '682265633886208', '2023-06-30 17:16:05', NULL, NULL, '999', '999', '999', '1474027520317886465', 'system.quartz.allList', 0, '列表');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674709271357960193', '682265633886208', '2023-06-30 17:19:40', NULL, NULL, '999', '999', '999', '1477222093206827010', 'system.saSession.pageList', 0, ' 分页列表');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674709328094310402', '682265633886208', '2023-06-30 17:19:53', NULL, NULL, '999', '999', '999', '1480080201729925121', 'system.saSession.kickOut', 0, '下线');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674709370079293442', '682265633886208', '2023-06-30 17:20:03', NULL, NULL, '999', '999', '999', '1480080205207003138', 'system.saSession.changeSession', 0, '切换账号');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674711201719267329', '682265633886208', '2023-06-30 17:27:20', NULL, NULL, '999', '999', '999', '1674703117533851649', 'system.user.adminAdd', 0, '添加');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674711201937371137', '682265633886208', '2023-06-30 17:27:20', NULL, NULL, '999', '999', '999', '1674703117533851649', 'system.user.adminEdit', 0, '修改');
INSERT INTO `sys_permission_action` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `permission_id`, `code`, `status`, `name`) VALUES ('1674711202096754689', '682265633886208', '2023-06-30 17:27:20', NULL, NULL, '999', '999', '999', '1674703117533851649', 'system.user.deleteBatch', 0, '删除');
COMMIT;

-- ----------------------------
-- Table structure for sys_permission_code
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_code`;
CREATE TABLE `sys_permission_code` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `permission_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_permission_code
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `data_type` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `include_low` int(11) DEFAULT NULL,
  `custom_expression` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `data_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `data_type`, `description`, `include_low`, `custom_expression`, `data_level`) VALUES ('1', NULL, '2021-12-18 13:45:23', NULL, NULL, 0, NULL, NULL, NULL, 'ROLE_ADMIN', 0, '超级管理员', NULL, NULL, NULL);
INSERT INTO `sys_role` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `data_type`, `description`, `include_low`, `custom_expression`, `data_level`) VALUES ('1473514407084560386', '682265633886208', '2021-12-22 12:43:06', '682265633886208', '2023-06-30 16:52:26', 0, NULL, NULL, NULL, 'ROLE_MANAGE', 1, '总经理', -1, '', 0);
INSERT INTO `sys_role` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `data_type`, `description`, `include_low`, `custom_expression`, `data_level`) VALUES ('1661936404691234817', '682265633886208', '2023-05-26 03:24:51', '682265633886208', '2023-06-30 16:52:15', 0, '999', '999', '999', 'ROLE_SUB_MANAGE', 1, '经理', -1, '', 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_organization`;
CREATE TABLE `sys_role_organization` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `organization_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_all_check` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_organization
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `permission_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_all_check` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_tenant
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant`;
CREATE TABLE `sys_tenant` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `contactor` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `contact` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_tenant
-- ----------------------------
BEGIN;
INSERT INTO `sys_tenant` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `code`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `status`, `address`, `contactor`, `contact`, `end_date`) VALUES ('1638391972344537089', '682265633886208', '2023-03-22 12:07:41', '682265633886208', '2023-03-22 12:08:37', 0, 'TE0002', '999', '999', '999', '测试租户1', 0, '111', '租户1', '111', '2024-12-31');
INSERT INTO `sys_tenant` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `code`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `status`, `address`, `contactor`, `contact`, `end_date`) VALUES ('1638392079592890369', '682265633886208', '2023-03-22 12:08:06', '682265633886208', '2023-06-28 13:36:10', 0, 'TE0003', '999', '999', '999', '测试租户2', 0, '111123122', '租户22', '1112322', '2024-12-31');
INSERT INTO `sys_tenant` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `code`, `tenant_id`, `department_id`, `sub_company_id`, `name`, `status`, `address`, `contactor`, `contact`, `end_date`) VALUES ('999', '682265633886208', '2021-12-01 14:52:58', NULL, NULL, 0, 'TE0000', NULL, NULL, NULL, 'XHCLOUD', 0, NULL, NULL, NULL, '2099-12-31');
COMMIT;

-- ----------------------------
-- Table structure for sys_tenant_auth_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant_auth_record`;
CREATE TABLE `sys_tenant_auth_record` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `auth_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_tenant_auth_record
-- ----------------------------
BEGIN;
INSERT INTO `sys_tenant_auth_record` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `auth_date`, `end_date`) VALUES ('1638392174107336706', '682265633886208', '2023-03-22 12:08:29', NULL, NULL, -1, '1638392079592890369', '999', '999', '2023-03-22', '2024-12-31');
INSERT INTO `sys_tenant_auth_record` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `auth_date`, `end_date`) VALUES ('1638392206378311681', '682265633886208', '2023-03-22 12:08:37', NULL, NULL, 0, '1638391972344537089', '999', '999', '2023-03-22', '2024-12-31');
INSERT INTO `sys_tenant_auth_record` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `auth_date`, `end_date`) VALUES ('1673926285540810753', '682265633886208', '2023-06-28 13:28:21', '682265633886208', '2023-06-28 13:36:10', 0, '1638392079592890369', '999', '999', '2023-06-28', '2024-12-31');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `organization_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `about` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `superior` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `street` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `organization_id`, `department_id`, `birth`, `about`, `superior`, `sub_company_id`, `sex`, `description`, `username`, `password`, `nick_name`, `mobile`, `email`, `address`, `street`, `avatar`, `type`, `status`) VALUES ('1638399837075554306', '682265633886208', '2023-03-22 12:38:56', NULL, NULL, 0, '1638391972344537089', '1638399392198311938', '999', NULL, NULL, '', '1638391972344537089', 'man', NULL, '总经理1', '$2a$10$o5hMLhBQSVD1FNXELZ57ne4NMfCvd4WJUR8r/3JRTUJgKPDhYmAUK', '总经理1', '', '', NULL, NULL, NULL, 0, 0);
INSERT INTO `sys_user` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `organization_id`, `department_id`, `birth`, `about`, `superior`, `sub_company_id`, `sex`, `description`, `username`, `password`, `nick_name`, `mobile`, `email`, `address`, `street`, `avatar`, `type`, `status`) VALUES ('1638400150977265666', '682265633886208', '2023-03-22 12:40:11', '682265633886208', '2023-04-03 05:44:30', 0, '1638392079592890369', '1638399455054151681', '999', '2023-03-22', '欢迎体验寻衡ERP', '', '1638392079592890369', 'man', NULL, '体验账号2', '$2a$10$i1jpY45omAwbYsSE9fRM0us6QBf6RAasJU4JE90lvr60mZxgVhHQO', '体验账号2', '', '', NULL, NULL, NULL, -1, 0);
INSERT INTO `sys_user` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `organization_id`, `department_id`, `birth`, `about`, `superior`, `sub_company_id`, `sex`, `description`, `username`, `password`, `nick_name`, `mobile`, `email`, `address`, `street`, `avatar`, `type`, `status`) VALUES ('1642855819389222913', '682265633886208', '2023-04-03 11:45:25', '682265633886208', '2023-06-27 12:08:10', 0, '1638392079592890369', '1638399455054151681', '999', NULL, NULL, '', '1638392079592890369', 'man', NULL, '体验账号3', '$2a$10$x1a41TrUdoLM9h/8JupTTO/Fy3l4k6GiqWBxv0uU04pv74rw8W.ii', '体验账号3', '', '', NULL, NULL, NULL, -1, 0);
INSERT INTO `sys_user` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `organization_id`, `department_id`, `birth`, `about`, `superior`, `sub_company_id`, `sex`, `description`, `username`, `password`, `nick_name`, `mobile`, `email`, `address`, `street`, `avatar`, `type`, `status`) VALUES ('1642855955355975681', '682265633886208', '2023-04-03 11:45:57', '682265633886208', '2023-06-27 17:30:13', 0, '1638391972344537089', '1638392677037940737', '999', NULL, NULL, '1638399837075554306', '1638392079592890369', 'man', NULL, '体验账号4', '$2a$10$Kipyp6XtJYiwD.j7zGU8KeAxwtyp4lZHN3G11waKYZtqeMrVwu4Fe', '体验账号4', '', '', NULL, NULL, NULL, 0, 0);
INSERT INTO `sys_user` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `organization_id`, `department_id`, `birth`, `about`, `superior`, `sub_company_id`, `sex`, `description`, `username`, `password`, `nick_name`, `mobile`, `email`, `address`, `street`, `avatar`, `type`, `status`) VALUES ('1673628257735004162', '682265633886208', '2023-06-27 17:44:06', '682265633886208', '2023-06-27 17:44:45', 0, '1638391972344537089', '1638392677037940737', '999', '2023-06-13', NULL, '1642855955355975681', '999', 'man', NULL, 'ceshi2', '$2a$10$TRJckQmAV1HypF4pi9t7zO2FVsVlhAawL93u0kJ8gznRSIqZvNSjC', 'ceshi2', '111', '111', NULL, NULL, NULL, 0, 0);
INSERT INTO `sys_user` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `organization_id`, `department_id`, `birth`, `about`, `superior`, `sub_company_id`, `sex`, `description`, `username`, `password`, `nick_name`, `mobile`, `email`, `address`, `street`, `avatar`, `type`, `status`) VALUES ('682265633886208', NULL, '2021-12-16 00:00:00', '682265633886208', '2023-06-27 13:30:00', 0, '999', NULL, NULL, '1996-04-20', '我有一个小目标123123', NULL, NULL, 'man', NULL, 'admin', '$2a$10$a.ZuGVp06kb96aUBFeB0OeXC9p1RfK/Z5QRboSqRkwPYqiF2lAJtK', '超级管理员', '158173624141', '452794162@qq.com', NULL, NULL, NULL, 3, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `user_id`, `role_id`) VALUES ('1', '682265633886208', '2021-12-22 14:35:39', NULL, NULL, NULL, NULL, NULL, '682265633886208', '1');
INSERT INTO `sys_user_role` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `user_id`, `role_id`) VALUES ('1638399837343989761', '682265633886208', '2023-03-22 12:38:56', NULL, NULL, '999', '999', '999', '1638399837075554306', '1473514407084560386');
INSERT INTO `sys_user_role` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `user_id`, `role_id`) VALUES ('1642764992373637121', '682265633886208', '2023-04-03 05:44:30', NULL, NULL, '999', '999', '999', '1638400150977265666', '1473514407084560386');
INSERT INTO `sys_user_role` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `user_id`, `role_id`) VALUES ('1642855819426971649', '682265633886208', '2023-04-03 11:45:25', NULL, NULL, '999', '999', '999', '1642855819389222913', '1473514407084560386');
INSERT INTO `sys_user_role` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `user_id`, `role_id`) VALUES ('1673624764966031362', '682265633886208', '2023-06-27 17:30:13', NULL, NULL, '999', '999', '999', '1642855955355975681', '1473514407084560386');
INSERT INTO `sys_user_role` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `department_id`, `sub_company_id`, `user_id`, `role_id`) VALUES ('1673628258536116226', '682265633886208', '2023-06-27 17:44:06', NULL, NULL, '999', '999', '999', '1673628257735004162', '1661936404691234817');
COMMIT;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `branch_id` bigint(20) NOT NULL COMMENT 'branch transaction id',
  `xid` varchar(100) NOT NULL COMMENT 'global transaction id',
  `context` varchar(128) NOT NULL COMMENT 'undo_log context,such as serialization',
  `rollback_info` longblob NOT NULL COMMENT 'rollback info',
  `log_status` int(11) NOT NULL COMMENT '0:normal status,1:defense status',
  `log_created` datetime(6) NOT NULL COMMENT 'create datetime',
  `log_modified` datetime(6) NOT NULL COMMENT 'modify datetime',
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='AT transaction mode undo table';

-- ----------------------------
-- Records of undo_log
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
