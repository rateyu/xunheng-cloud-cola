/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : xhcc-generator

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 06/07/2023 18:06:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for g_gen_config
-- ----------------------------
DROP TABLE IF EXISTS `g_gen_config`;
CREATE TABLE `g_gen_config` (
  `type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `domain_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `author` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `table_prefix` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `table_alias` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `service_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of g_gen_config
-- ----------------------------
BEGIN;
INSERT INTO `g_gen_config` (`type`, `name`, `domain_name`, `description`, `author`, `table_prefix`, `table_alias`, `service_name`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('COLA', 'Test', 'test', '测试类', 'hhqkkr', 't_', 'te', 'test', '1676148128937164801', '682265633886208', '2023-07-04 16:37:10', '682265633886208', '2023-07-06 18:00:08', '999', '999', '999');
COMMIT;

-- ----------------------------
-- Table structure for g_gen_field_config
-- ----------------------------
DROP TABLE IF EXISTS `g_gen_field_config`;
CREATE TABLE `g_gen_field_config` (
  `field_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `default_val` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `cindex` int(11) DEFAULT NULL,
  `not_null` int(11) DEFAULT NULL,
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of g_gen_field_config
-- ----------------------------
BEGIN;
INSERT INTO `g_gen_field_config` (`field_name`, `description`, `type`, `default_val`, `cindex`, `not_null`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('name', '名字', 'String', NULL, 0, 1, '1676505804527484929', '682265633886208', '2023-07-05 16:18:27', NULL, NULL, '999', '999', '999');
INSERT INTO `g_gen_field_config` (`field_name`, `description`, `type`, `default_val`, `cindex`, `not_null`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('age', '年龄', 'Integer', NULL, 0, 1, '1676505805815136258', '682265633886208', '2023-07-05 16:18:27', NULL, NULL, '999', '999', '999');
INSERT INTO `g_gen_field_config` (`field_name`, `description`, `type`, `default_val`, `cindex`, `not_null`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('birthday', '生日', 'Date', NULL, 0, 1, '1676505807153119234', '682265633886208', '2023-07-05 16:18:27', NULL, NULL, '999', '999', '999');
INSERT INTO `g_gen_field_config` (`field_name`, `description`, `type`, `default_val`, `cindex`, `not_null`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('companyId', '公司id', 'String', NULL, 1, 1, '1676505808923115521', '682265633886208', '2023-07-05 16:18:28', NULL, NULL, '999', '999', '999');
INSERT INTO `g_gen_field_config` (`field_name`, `description`, `type`, `default_val`, `cindex`, `not_null`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('status', '状态', 'Integer', '1', 0, 0, '1676505809824890881', '682265633886208', '2023-07-05 16:18:28', NULL, NULL, '999', '999', '999');
COMMIT;

-- ----------------------------
-- Table structure for g_gen_front_field_config
-- ----------------------------
DROP TABLE IF EXISTS `g_gen_front_field_config`;
CREATE TABLE `g_gen_front_field_config` (
  `field_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `col_width` int(11) DEFAULT NULL,
  `dict_type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `api` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `searchable` int(11) DEFAULT NULL,
  `search_type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of g_gen_front_field_config
-- ----------------------------
BEGIN;
INSERT INTO `g_gen_front_field_config` (`field_name`, `description`, `type`, `col_width`, `dict_type`, `api`, `searchable`, `search_type`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('name', '名字', 'text', 100, '', '', 1, 'text', '1676893782210850818', '682265633886208', '2023-07-06 18:00:08', NULL, NULL, '999', '999', '999');
INSERT INTO `g_gen_front_field_config` (`field_name`, `description`, `type`, `col_width`, `dict_type`, `api`, `searchable`, `search_type`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('age', '年龄', 'number', 100, '', '', 0, '', '1676893782491869186', '682265633886208', '2023-07-06 18:00:08', NULL, NULL, '999', '999', '999');
INSERT INTO `g_gen_front_field_config` (`field_name`, `description`, `type`, `col_width`, `dict_type`, `api`, `searchable`, `search_type`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('company', '所属公司', 'dict', 100, 'resourceType', '', 1, 'dict', '1676893782764498945', '682265633886208', '2023-07-06 18:00:08', NULL, NULL, '999', '999', '999');
INSERT INTO `g_gen_front_field_config` (`field_name`, `description`, `type`, `col_width`, `dict_type`, `api`, `searchable`, `search_type`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('birthDay', '生日', 'date', 100, '', '', 1, 'daterange', '1676893783058100225', '682265633886208', '2023-07-06 18:00:08', NULL, NULL, '999', '999', '999');
INSERT INTO `g_gen_front_field_config` (`field_name`, `description`, `type`, `col_width`, `dict_type`, `api`, `searchable`, `search_type`, `id`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sub_company_id`, `department_id`) VALUES ('department', '部门', 'api', 100, '', 'system.department.getSelectItem', 1, 'api', '1676893783330729985', '682265633886208', '2023-07-06 18:00:08', NULL, NULL, '999', '999', '999');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='AT transaction mode undo table';

-- ----------------------------
-- Records of undo_log
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
