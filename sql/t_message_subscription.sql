/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : ywt

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-04-16 15:30:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_message_subscription
-- ----------------------------
DROP TABLE IF EXISTS `t_message_subscription`;
CREATE TABLE `t_message_subscription` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `FAMILY_CODE` varchar(100) DEFAULT NULL COMMENT '户号',
  `MOBILE_PHONE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime DEFAULT NULL COMMENT '数据的最后修改时间.',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '系统菜单描述',
  `ENABLED` int(10) NOT NULL DEFAULT '1' COMMENT '是否启用(1=启用，0=禁用)',
  `DEL_FLAG` int(10) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='短信订阅';
