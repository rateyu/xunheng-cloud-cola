/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50730 (5.7.30-0ubuntu0.18.04.1)
 Source Host           : 127.0.0.1:3306
 Source Schema         : xhcc-wechat

 Target Server Type    : MySQL
 Target Server Version : 50730 (5.7.30-0ubuntu0.18.04.1)
 File Encoding         : 65001

 Date: 17/01/2024 16:05:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
-- Table structure for wc_wechat_account
-- ----------------------------
DROP TABLE IF EXISTS `wc_wechat_account`;
CREATE TABLE `wc_wechat_account` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(10) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `app_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `app_secret` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `token` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `aes_key` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mpe_idx_app_id` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for wc_wechat_official_account_fans
-- ----------------------------
DROP TABLE IF EXISTS `wc_wechat_official_account_fans`;
CREATE TABLE `wc_wechat_official_account_fans` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `open_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `app_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `city` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `province` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `head_img_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `subscribe_time` date DEFAULT NULL,
  `subscribe` int(11) DEFAULT NULL,
  `union_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `tag_id_list` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `subscribe_scene` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `qr_scene_str` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `actable_idx_open_id` (`open_id`),
  KEY `actable_idx_app_id` (`app_id`),
  KEY `actable_idx_union_id` (`union_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for wc_wechat_qr_code
-- ----------------------------
DROP TABLE IF EXISTS `wc_wechat_qr_code`;
CREATE TABLE `wc_wechat_qr_code` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(10) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `app_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `scene_str` int(10) DEFAULT NULL,
  `ticket` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `expire_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mpe_idx_app_id` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for wc_wechat_user
-- ----------------------------
DROP TABLE IF EXISTS `wc_wechat_user`;
CREATE TABLE `wc_wechat_user` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(10) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `open_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `app_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sex` int(10) DEFAULT NULL,
  `city` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `province` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `head_img_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `subscribe_time` date DEFAULT NULL,
  `subscribe` int(10) DEFAULT NULL,
  `union_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `tag_id_list` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `subscribe_scene` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `qr_scene_str` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mpe_idx_app_id` (`app_id`),
  KEY `mpe_idx_open_id` (`open_id`),
  KEY `mpe_idx_union_id` (`union_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for wc_woa_article
-- ----------------------------
DROP TABLE IF EXISTS `wc_woa_article`;
CREATE TABLE `wc_woa_article` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(10) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `tags` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `summary` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `category` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_category` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `open_count` int(10) DEFAULT NULL,
  `target_link` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for wc_woa_msg
-- ----------------------------
DROP TABLE IF EXISTS `wc_woa_msg`;
CREATE TABLE `wc_woa_msg` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(10) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `app_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `open_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `in_out` int(10) DEFAULT NULL,
  `msg_type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `detail` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mpe_idx_app_id` (`app_id`),
  KEY `mpe_idx_open_id` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for wc_woa_msg_feed_record
-- ----------------------------
DROP TABLE IF EXISTS `wc_woa_msg_feed_record`;
CREATE TABLE `wc_woa_msg_feed_record` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(10) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `app_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `open_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `template_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `data` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `mini_program` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `feed_result` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mpe_idx_app_id` (`app_id`),
  KEY `mpe_idx_open_id` (`open_id`),
  KEY `mpe_idx_template_id` (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for wc_woa_msg_template
-- ----------------------------
DROP TABLE IF EXISTS `wc_woa_msg_template`;
CREATE TABLE `wc_woa_msg_template` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(10) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `app_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `template_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `data` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `mini_program` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mpe_idx_app_id` (`app_id`),
  KEY `mpe_idx_template_id` (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for wc_woa_reply_rule
-- ----------------------------
DROP TABLE IF EXISTS `wc_woa_reply_rule`;
CREATE TABLE `wc_woa_reply_rule` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(10) DEFAULT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sub_company_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `app_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `rule_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `match_value` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `exact_match` int(10) DEFAULT NULL,
  `reply_type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `reply_content` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `priority` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mpe_idx_app_id` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
