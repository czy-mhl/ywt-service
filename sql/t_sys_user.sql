/*
Navicat MySQL Data ResidentTransfer

Source Server         : 本地mysql
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : ywt

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-04-11 15:01:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `MOBILE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户手机号码',
  `PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统用户密码',
  `WX_OPEN_ID` varchar(100) DEFAULT NULL COMMENT '微信ID',
  `INVITE_CODE` varchar(100) DEFAULT NULL COMMENT '推荐编码',
  `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `ROLE_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色姓名',
  `ROLE_ID` bigint(20)  DEFAULT NULL COMMENT '角色id',
  `TYPE` int(4) DEFAULT NULL COMMENT '用户类型（申报用户1=组织用户，2=个人用户，管理员用户0=管理员用户，专家用户：10=专家）',
  `ENABLED` int(1) DEFAULT '0' COMMENT '是否启用(1=启用，0=禁用)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime DEFAULT NULL COMMENT '数据的最后修改时间',
  `DEL_FLAG` int(1) DEFAULT NULL COMMENT '删除标记',
  `DESCRIPTION` varchar(200)  DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=431 DEFAULT CHARSET=utf8 COMMENT='系统用户信息表';

-- ----------------------------
-- Table structure for t_user_family_number
-- ----------------------------
DROP TABLE IF EXISTS `t_user_family_number`;
CREATE TABLE `t_user_family_number` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户ID',
  `FAMILY_NUMBER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '户号',
  `FAMILY_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '户名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime DEFAULT NULL COMMENT '数据的最后修改时间',
  `DEL_FLAG` int(1) DEFAULT NULL COMMENT '删除标记',
  `DESCRIPTION` varchar(200)  DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=431 DEFAULT CHARSET=utf8 COMMENT='用户绑定户号表';
