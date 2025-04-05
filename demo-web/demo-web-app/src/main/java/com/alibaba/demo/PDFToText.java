package com.alibaba.demo;

import com.mysql.cj.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDFToText {
    public static final String TMP_FILTER = "疯狂创客圈 \n" +
            "牛逼的职业发展之路 \n" +
            "40 岁老架构尼恩用一张图揭秘: Java工程师的高端职业发展路径，走向食物链顶端的之路 \n" +
            "链接：https:\n" +
            "疯狂创客圈 \n" +
            "史上最全：价值10W的架构师知识图谱 \n" +
            "此图梳理于尼恩的多个 3高生产项目：多个亿级人民币的大型 SAAS平台和智慧城市项目 \n" +
            "链接：https:\n" +
            "疯狂创客圈 \n" +
            "牛逼的架构师哲学 \n" +
            "40 岁老架构师尼恩对自己的 20年的开发、架构经验总结 \n" +
            "链接：https:\n" +
            "疯狂创客圈 \n" +
            "牛逼的3高架构知识宇宙 \n" +
            "尼恩 3高架构知识宇宙，帮助大家穿透 3高架构，走向技术自由，远离中年危机 \n" +
            "链接：https:\n" +
            "疯狂创客圈 \n" +
            "尼恩Java高并发三部曲（卷1加强版） \n" +
            "老版本：《Java高并发核心编程 卷 1：NIO、Netty、Redis、ZooKeeper》（已经过时，不建\n" +
            "议购买） \n" +
            "新版本：《Java高并发核心编程 卷 1加强版：NIO、Netty、Redis、ZooKeeper》 \n" +
            "\uF06C 由浅入深地剖析了高并发 IO 的底层原理。 \n" +
            "\uF06C 图文并茂的介绍了 TCP、HTTP、WebSocket 协议的核心原理。 \n" +
            "\uF06C 细致深入地揭秘了 Reactor 高性能模式。 \n" +
            "\uF06C 全面介绍了 Netty 框架，并完成单体 IM、分布式 IM 的实战设计。 \n" +
            "\uF06C 详尽地介绍了 ZooKeeper、Redis 的使用，以帮助提升高并发、可扩展能力 \n" +
            "详情：https:\n" +
            "疯狂创客圈 \n" +
            "尼恩Java高并发三部曲（卷2加强版） \n" +
            "老版本：《Java高并发核心编程 卷 2：多线程、锁、JMM、JUC、高并发设计模式》 \n" +
            "（已经过时，不建议购买） \n" +
            "新版本：《Java高并发核心编程 卷 2加强版：多线程、锁、JMM、JUC、高并发设计模式》 \n" +
            "\uF06C 由浅入深地剖析了 Java 多线程、线程池的底层原理。 \n" +
            "\uF06C 总结了 IO 密集型、CPU 密集型线程池的线程数预估算法。 \n" +
            "\uF06C 图文并茂的介绍了 Java 内置锁、JUC 显式锁的核心原理。 \n" +
            "\uF06C 细致深入地揭秘了 JMM 内存模型。 \n" +
            "\uF06C 全面介绍了 JUC 框架的设计模式与核心原理，并完成其高核心组件的实战介绍。 \n" +
            "\uF06C 详尽地介绍了高并发设计模式的使用，以帮助提升高并发、可扩展能力 \n" +
            "详情参阅：https:\n" +
            "疯狂创客圈 \n" +
            "尼恩Java高并发三部曲（卷3加强版） \n" +
            "老版本：《SpringCloud Nginx 高并发核心编程》（已经过时，不建议购买） \n" +
            "新版本：《Java高并发核心编程 卷 3加强版：亿级用户 Web应用架构与实战》 \n" +
            "\uF06C 在当今的面试场景中，3 高知识是大家面试必备的核心知识，本书基于亿级用户 3 高 Web 应用\n" +
            "的架构分析理论，为大家对 3 高架构系统做一个系统化和清晰化的介绍。 \n" +
            "\uF06C 从 Java 静态代理、动态代理模式入手，抽丝剥茧地解读了 Spring Cloud 全家桶中 RPC 核心原\n" +
            "理和执行过程，这是高级 Java 工程师面试必备的基础知识。 \n" +
            "\uF06C 从Reactor反应器模式入手，抽丝剥茧地解读了Nginx核心思想和各配置项的底层知识和原理，\n" +
            "这是高级 Java 工程师、架构师面试必备的基础知识。 \n" +
            "\uF06C 从观察者模式入手，抽丝剥茧地解读了 RxJava、Hystrix 的核心思想和使用方法，这也是高级\n" +
            "Java 工程师、架构师面试必备的基础知识。 \n" +
            "详情：https:\n" +
            "疯狂创客圈 \n" +
            "尼恩Java面试宝典 \n" +
            "35 个专题（卷王专供+ 史上最全 + 2023面试必备） \n" +
            "详情：https:\n" +
            "专题1：JVM面试题（史上最全、定期更新）  \n" +
            "本文版本说明：V20  \n" +
            "此文的格式，由markdown 通过程序转成而来，由于很多表格，没有来的及调整，出现一个格式\n" +
            "问题，尼恩在此给大家道歉啦。\n" +
            "由于社群很多小伙伴，在面试，不断的交流最新的面试难题，所以，《Java面试红宝书》， 后面\n" +
            "会不断升级，迭代。\n" +
            "本专题，作为  《Java面试红宝书》的第10个专题，  《Java面试红宝书》一共30个面试专题。\n" +
            "《Java面试红宝书》升级的规划为：  \n" +
            "后续基本上，每一个月，都会发布一次，最新版本，可以扫描扫架构师尼恩微信， 发送 “领取电子书”  \n" +
            "获取。\n" +
            "尼恩的微信二维码在哪里呢 ？  具体可以百度搜索  疯狂创客圈 总目录\n" +
            "面试问题交流说明：  \n" +
            "如果遇到面试难题，或者职业发展问题， 或者中年危机问题，都可以来 疯狂创客圈社群交流， \n" +
            "加入交流群，加尼恩微信即可， \n" +
            "尼恩的微信二维码在哪里呢 ？  具体参见文末";

    public static String zhuanti41 = "技术自由圈 \n" +
            "牛逼的职业发展之路 \n" +
            "40 岁老架构尼恩用一张图揭秘: Java工程师的高端职业发展路径，走向食物链顶端的之路 \n" +
            " \n" +
            "链接：https:\n" +
            " \n" +
            " \n" +
            " \n" +
            "  \n" +
            "技术自由圈 \n" +
            " \n" +
            "史上最全：价值10W的架构师知识图谱 \n" +
            "此图梳理于尼恩的多个 3高生产项目：多个亿级人民币的大型 SAAS平台和智慧城市项目 \n" +
            " \n" +
            "链接：https:\n" +
            " \n" +
            "技术自由圈 \n" +
            " \n" +
            "牛逼的架构师哲学 \n" +
            "40 岁老架构师尼恩对自己的 20年的开发、架构经验总结 \n" +
            " \n" +
            "链接：https:\n" +
            " \n" +
            " \n" +
            " \n" +
            " \n" +
            "技术自由圈 \n" +
            "牛逼的3高架构知识宇宙 \n" +
            "尼恩 3高架构知识宇宙，帮助大家穿透 3高架构，走向技术自由，远离中年危机 \n" +
            " \n" +
            "链接：https:\n" +
            " \n" +
            " \n" +
            " \n" +
            " \n" +
            "  \n" +
            "技术自由圈 \n" +
            " \n" +
            "尼恩Java面试宝典 \n" +
            "40个专题（卷王专供+ 史上最全 + 2023面试必备） \n" +
            "详情：https:\n" +
            " \n" +
            " \n" +
            "技术自由圈 \n" +
            " \n" +
            "未来职业，如何突围：三栖架构师 \n" +
            " \n" +
            " \n" +
            "专题41：大厂面试真题 （史上最全、定期更\n" +
            "新）\n" +
            " \n" +
            "本文版本说明：V138  \n" +
            "由于社群很多小伙伴，在面试，不断的交流最新的面试难题，所以，《尼恩Java面试宝典》， 后\n" +
            "面会不断升级，迭代。\n" +
            "本专题，作为  《尼恩Java面试宝典》专题之一，  《尼恩Java面试宝典》一共41个面试专题，后\n" +
            "续还会增加\n" +
            "《尼恩Java面试宝典》升级的规划为：  \n" +
            "后续基本上，每一个月，都会发布一次，最新版本，可以关注公众号【技术自由圈】，扫描扫架构师尼\n" +
            "恩个人微信， 发送 “领电子书”  获取。\n" +
            "尼恩的微信二维码在哪里呢 ？ 请参见文末\n" +
            "历史版本：  \n" +
            "V138升级说明（2023-11-18）：\n" +
            "问懵了：滴滴9大灵魂拷问.....60W年薪 面试真题\n" +
            "V126升级说明（2023-11-18）：\n" +
            "央企太卷.....来自央企的7个面试题，一个一个生产难题\n" +
            "V124升级说明（2023-11-08）：\n" +
            "赢麻了......腾讯1面核心9问，小伙伴过了提42W offer\n" +
            "V121升级说明（2023-11-08）：\n" +
            "太细了：美团一面连环夺命20问，搞定就60W起\n" +
            "V95升级说明（2023-08-06）：\n" +
            "炸裂，靠“吹牛”过京东一面，月薪40k\n" +
            "V93升级说明（2023-07-29）：\n" +
            "太猛了，靠“吹牛”过顺丰一面，月薪30k\n" +
            "V83升级说明（2023-07-08）：\n" +
            "炸裂了…京东一面索命40问，过了就50W+\n" +
            "V78升级说明（2023-06-10）：\n" +
            "问麻了…阿里一面索命27问，过了就60W+\n" +
            "V72升级说明（2023-06-03）：\n" +
            "百度狂问3小时，大厂offer到手，小伙真狠！\n" +
            "V71升级说明（2023-06-01）：\n" +
            "饿了么太狠：面个高级Java，抖这多硬活、狠活\n" +
            "V69升级说明（2023-05-30）：\n" +
            "字节狂问1小时，小伙offer到手，太狠了！\n" +
            "V56升级说明（2023-03-03）：\n" +
            "收个滴滴Offer：从小伙三面经历，看看需要学点啥？\n" +
            "面试问题交流说明：  \n" +
            "如果遇到面试难题，或者职业发展问题， 或者中年危机问题，都可以来 疯狂创客圈社群交流， \n" +
            "加入交流群，加尼恩微信即可 \n" +
            " ";
    public static final String[] LINES_ALL = (TMP_FILTER+zhuanti41).split("\n");

    public static String outFilePath = "D:\\pdf2txt2\\";
    public static String orgFilePath = "D:\\txt2org2\\";
    public static String outFilePath2 = "D:\\text2text2\\";

    public static void main(String[] args) throws IOException {

        File folder = new File("D:\\baidunetdisk\\尼恩高并发三部曲__与__从菜鸟到大神视频\\尼恩Java硬核架构班\\尼恩Java面试宝典");
        Collection<File> files = FileUtils.listFiles(folder, null, true); // 递归遍历
        String tmp = "";
        for (File file : files) {
//            if (!file.getName().startsWith("专题41")) {
//                continue;
//            }
            System.out.println("文件: " + file.getAbsolutePath());
            tmp = parsePdfFile(file);
            writeTxt2File(outFilePath+file.getName()+".txt", tmp);

//            二次解析 txt再次解析生成org
            List <String> mylist = new ArrayList<>();
            parseTxtFile(Paths.get(outFilePath+file.getName()+".txt"),mylist);

            Path filePathT = Paths.get(outFilePath2+file.getName()+".txt");
            String textToAppend = "";

            if (filePathT.toFile().exists()) {
                filePathT.toFile().delete();
            }
            for (String tmpL:mylist) {
                textToAppend = tmpL;
                txt2AppendFile(filePathT, textToAppend+"\r\n");
            }
            Path filePath = Paths.get(orgFilePath+file.getName()+".org");
            if (filePath.toFile().exists()) {
                filePath.toFile().delete();
            }
            for (String tmpL:mylist) {
                textToAppend = tmpL;
                txt2AppendFile(filePath, textToAppend+"\r\n");
            }
//            return;
        }

//        File file = new File("d:\\example2.pdf");
//        file  = new File("D:\\baidunetdisk\\尼恩高并发三部曲__与__从菜鸟到大神视频\\尼恩Java硬核架构班\\尼恩Java面试宝典\\专题30：HR面试题：过五关斩六将后，小心阴沟翻船！（史上最全、避坑宝典）-V2-from-Java面试红宝书-release.pdf");


    }

    private static void txt2AppendFile(Path filePath, String textToAppend) {
        try {

            // 使用 StandardOpenOption.APPEND 打开文件并追加内容
            Files.write(filePath, textToAppend.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            System.out.println("文本通过 Files.write 追加成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void parseTxtFile(Path file,List<String> mylist) {
        // 读取文件
        try {
            List<String> lines = Files.readAllLines(file);
            String tmp = "";

            for (String line : lines) {
                int flag = 0;
                // 遍历每一行文本
                for (String lineT : LINES_ALL) {
                    // 如果该行不匹配正则表达式（即没有标点符号），就保留它
                    if (line.equals(lineT)) {
//                        filteredText.append(line).append("\n");
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    continue;
                }

                tmp = filterText2(line.trim());
//                System.out.println(line);
                if (tmp==null || "".equals(tmp.trim())) {
//                    System.out.println("去掉line："+line);
                } else {
                    System.out.println(line);
                    mylist.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeTxt2File(String writeFileStr, String content) {
        Path file = Paths.get(writeFileStr);
        // 写入文件
        try {
            Files.write(file, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String parsePdfFile(File file) throws IOException {
        PDDocument document = PDDocument.load(file);
        try {

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
//            System.out.println(cleanText(text));
            return cleanText(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return null;
    }

    // 过滤代码块、变量赋值、循环、条件语句等
    public static String filterText2(String text) {
        // 统一正则表达式
        String regex = "(\\b(public|private|class|void|int|String|for|if|return|System\\.out\\.println)\\b.*?\\{.*?\\})|([{}();=]+)|(\\b[a-zA-Z0-9]+\\s*=\\s*[^;]+;)|(for\\s*\\(.*?\\)\\s*\\{.*?\\})|(if\\s*\\(.*?\\)\\s*\\{.*?\\})|(^[a-zA-Z0-9\\s\\p{Punct}]+$)";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);

        // 替换掉匹配的内容
        String filteredText = matcher.replaceAll("");

        // 去除多余的空行
        filteredText = filteredText.replaceAll("(\n\\s*){2,}", "\n");

        filteredText = filterTextCode(filteredText);
        filteredText = filteredText.replaceAll("[0-9a-zA-Z  .<>+-\\[\\]:;_^&\\*%$#@!=\"|]*", "");
        filteredText = removeSpecificWhitespace(filteredText);

        return filteredText.trim();
    }

    public static String removeSpecificWhitespace(String input) {
        // 定义需要去除的空白字符
        char[] whitespaceChars = {' ', '\t', '\n', '\r', '\u00A0', '\u200B'};

        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            boolean isWhitespace = false;
            for (char ws : whitespaceChars) {
                if (c == ws) {
                    isWhitespace = true;
                    break;
                }
            }
            if (!isWhitespace) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 过滤以某些字符串开头的行
    public static List<String> filterLines(String line) {
        List<String> filteredLines = new ArrayList<>();

        // 配置需要过滤的字符串
        List<String> prefixes = new ArrayList<>();
        prefixes.add("#"); // 过滤以 # 开头的行
        prefixes.add("//"); // 过滤以 // 开头的行
        prefixes.add("TODO"); // 过滤以 TODO 开头的行
        prefixes.add("疯狂创客圈"); // 过滤以 TODO 开头的行
        prefixes.add("牛逼的职业发展之路");
        prefixes.add("史上最全");
        prefixes.add("牛逼的架构师哲学");


//        for (String line : lines) {
            boolean shouldRemove = false;
            for (String prefix : prefixes) {
                if (line.trim().startsWith(prefix)) {
                    shouldRemove = true;
                    break;
                }
            }
            if (!shouldRemove) {
                filteredLines.add(line);
            }
//        }
        return filteredLines;
    }


    // 过滤代码块、数字和英文行
    public static String filterText(String text) {
        // 统一正则表达式
        String regex = "(\\b(public|class|void|int|String|System\\.out\\.println)\\b.*?\\{.*?\\})|([{}();=]+)|(^[a-zA-Z0-9\\s\\p{Punct}]+$)";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);

        // 替换掉匹配的内容
        String filteredText = matcher.replaceAll("");

        // 去除多余的空行
        filteredText = filteredText.replaceAll("(\n\\s*){2,}", "\n");


        return filteredText.trim();
    }

    // 过滤掉包含英文字符、数字、空格等的行
    public static String filterTextCode(String text) {
        // 正则表达式：匹配包含英文字符、数字、空格等的行
        String regex = "^[a-zA-Z0-9\\s\\p{Punct}]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);

        // 替换掉匹配的行
        String filteredText = matcher.replaceAll("");

        // 去除多余的空行
        filteredText = filteredText.replaceAll("(\n\\s*){2,}", "\n");

        return filteredText.trim();
    }

    /**
     * 清理代码，去除注释、类声明、方法声明、变量声明等代码行
     * @param code 原始代码
     * @return 清理后的代码
     */
    public static String cleanCode(String code) {
        // 定义正则表达式
        String pattern = "(?m)^\s*//.*$|(?s)/\\*.*?\\*/|^\\s*(public|private|protected|static|final|void|class|interface|enum|\\w+)\\s+[A-Za-z0-9_]+(\\s*\\(.*\\))?\\s*(\\{.*\\})?;?|^\\s*[\\w\\d]+(\\s*=\\s*[^;]+)?\\s*;|^\\s*[A-Za-z0-9]+[ ]*$";

        // 用正则表达式去除不需要的部分
        code = code.replaceAll(pattern, "");

        // 去除多余的空行
        code = code.replaceAll("(?m)^[ \t]*\r?\n", "");

        return code;
    }

    /**
     * 清理文本，去除代码段及不适合朗读的部分
     * @param text 原始提取的文本
     * @return 过滤后的文本
     */
    private static String cleanText(String text) {
        // 正则表达式匹配代码行（如Java代码常见的格式）
        String codePattern = "(?m)^[\\s]*[a-zA-Z_0-9]+\\w*(\\s*\\(.*\\))?\\s*;?\r\n$";
        String commentPattern = "(?m)\\/\\/.*$";  // 单行注释
        String blockCommentPattern = "(?s)\\/\\*.*?\\*\\/";  // 多行注释

        // 过滤掉匹配到的代码和注释
        text = text.replaceAll(codePattern, "")          // 去除代码行
                .replaceAll(commentPattern, "")      // 去除单行注释
                .replaceAll(blockCommentPattern, ""); // 去除多行注释



        // 可以根据需要进一步处理，比如去除不必要的符号或特殊字符
//        text = text.replaceAll("[^\\x00-\\x7F]", "");  // 移除非ASCII字符

        return text;
    }


    /**
     * 清理文本，去除代码段、注解及不适合朗读的部分
     * @param text 原始提取的文本
     * @return 过滤后的文本
     */
    private static String cleanText2(String text) {
        // 正则表达式匹配 Java 注解（如 @Override, @Entity）
        String annotationPattern = "@\\w+";

        // 正则表达式匹配类声明（如 class MyClass {）
        String classPattern = "(?m)\\bclass\\s+\\w+\\s*\\{";

        // 正则表达式匹配方法声明（如 public void myMethod() {）
        String methodPattern = "(?m)\\b\\w+\\s+\\w+\\(.*\\)\\s*\\{";

        // 正则表达式匹配变量声明（如 int x = 5;）
        String variablePattern = "(?m)\\b\\w+\\s+\\w+\\s*;";

        // 正则表达式匹配 Java 单行注释（// 开头的行）
        String singleLineCommentPattern = "(?m)\\/\\/.*$";

        // 正则表达式匹配 Java 多行注释（/* */）
        String blockCommentPattern = "(?s)\\/\\*.*?\\*\\/";

        // 过滤掉注解
        text = text.replaceAll(annotationPattern, "");

        // 过滤掉类声明
        text = text.replaceAll(classPattern, "");

        // 过滤掉方法声明
        text = text.replaceAll(methodPattern, "");

        // 过滤掉变量声明
        text = text.replaceAll(variablePattern, "");

        // 过滤掉单行注释
        text = text.replaceAll(singleLineCommentPattern, "");

        // 过滤掉多行注释
        text = text.replaceAll(blockCommentPattern, "");

        // 可以根据需要进一步处理，比如去除不必要的符号或特殊字符
        text = text.replaceAll("[^\\x00-\\x7F]", "");  // 移除非ASCII字符

        return text;
    }
}