/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : xhcc-file

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 15/07/2023 22:23:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for f_catalogue
-- ----------------------------
DROP TABLE IF EXISTS `f_catalogue`;
CREATE TABLE `f_catalogue` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `dir` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parent_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sort_order` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of f_catalogue
-- ----------------------------
BEGIN;
INSERT INTO `f_catalogue` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `title`, `dir`, `status`, `parent_id`, `sort_order`) VALUES ('1481560276232994817', '682265633886208', '2022-01-13 17:34:31', '682265633886208', '2022-01-13 17:34:59', 0, '999', '999', '999', '系统目录', 'system', 0, NULL, 0.00);
INSERT INTO `f_catalogue` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `title`, `dir`, `status`, `parent_id`, `sort_order`) VALUES ('1481560405920874497', '682265633886208', '2022-01-13 17:35:01', '682265633886208', '2023-07-13 13:05:28', 0, '999', '999', '999', '用户附件', 'user', 0, '1481560276232994817', 1.00);
INSERT INTO `f_catalogue` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `title`, `dir`, `status`, `parent_id`, `sort_order`) VALUES ('1481562896586657793', '682265633886208', '2022-01-13 17:44:55', '682265633886208', '2022-01-13 17:45:13', 0, '999', '999', '999', '其他目录', 'other', 0, NULL, 1.00);
COMMIT;

-- ----------------------------
-- Table structure for f_file
-- ----------------------------
DROP TABLE IF EXISTS `f_file`;
CREATE TABLE `f_file` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `setting_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `main_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `catalogue_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `f_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of f_file
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for f_upload_setting
-- ----------------------------
DROP TABLE IF EXISTS `f_upload_setting`;
CREATE TABLE `f_upload_setting` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `max_size` int(11) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `code` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `catalogue_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `location` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of f_upload_setting
-- ----------------------------
BEGIN;
INSERT INTO `f_upload_setting` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `max_size`, `title`, `code`, `catalogue_id`, `location`) VALUES ('1481575297063247874', '682265633886208', '2022-01-13 18:34:12', '682265633886208', '2022-01-13 18:53:31', 0, '999', '999', '999', 5, '用户头像上传', 'system:user:avatar', '1481560405920874497', 'local');
INSERT INTO `f_upload_setting` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `tenant_id`, `sub_company_id`, `department_id`, `max_size`, `title`, `code`, `catalogue_id`, `location`) VALUES ('1481869783572033537', '682265633886208', '2022-01-14 14:04:23', NULL, NULL, 0, '999', '999', '999', 99, '其他文件上传', 'file:file:other', '1481562896586657793', 'local');
COMMIT;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
