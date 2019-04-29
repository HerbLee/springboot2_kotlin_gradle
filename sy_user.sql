/*
 Navicat MySQL Data Transfer

 Source Server         : echo
 Source Server Version : 50726
 Source Host           : 139.196.141.131
 Source Database       : sy_user

 Target Server Version : 50726
 File Encoding         : utf-8

 Date: 04/30/2019 00:22:27 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user_base`
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base` (
  `uid` varchar(32) NOT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(240) DEFAULT NULL,
  `t_create` datetime NOT NULL,
  `t_modify` datetime NOT NULL,
  `t_delete` datetime DEFAULT NULL,
  `gender` int(1) DEFAULT '1' COMMENT '性别 0 女 1 男',
  `birthday` date DEFAULT NULL COMMENT '出生年月日',
  `t_last` datetime DEFAULT NULL,
  `last_ip` varchar(64) DEFAULT NULL,
  `addr` varchar(64) DEFAULT NULL,
  `id_card` varchar(64) DEFAULT NULL,
  `id_type` int(3) DEFAULT NULL COMMENT '证件类型：1 身份证，2 军官证，3 护照',
  `is_delete` int(11) NOT NULL COMMENT '0未删除 1已删除',
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `user_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE `user_login_log` (
  `id` int(11) NOT NULL,
  `t_create` datetime NOT NULL,
  `ip` varchar(100) NOT NULL,
  `addr` varchar(200) NOT NULL,
  `login_oauth` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `user_oauth`
-- ----------------------------
DROP TABLE IF EXISTS `user_oauth`;
CREATE TABLE `user_oauth` (
  `uid` varchar(32) NOT NULL,
  `t_create` datetime NOT NULL,
  `t_modify` datetime NOT NULL,
  `t_delete` datetime DEFAULT NULL,
  `is_delete` int(1) NOT NULL,
  `user_uid` varchar(32) NOT NULL,
  `unionid` varchar(50) DEFAULT NULL COMMENT '用户在各第三方平台的唯一id',
  `openid` varchar(50) DEFAULT NULL COMMENT '用户在各第三方平台下各应用的id',
  `oauth_type` int(5) NOT NULL COMMENT '第三方登录标示',
  PRIMARY KEY (`uid`),
  KEY `oauth_type` (`oauth_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `user_oauth_type`
-- ----------------------------
DROP TABLE IF EXISTS `user_oauth_type`;
CREATE TABLE `user_oauth_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `descriptioin` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
