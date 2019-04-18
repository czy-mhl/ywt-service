/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : ywt

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-04-18 18:09:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_my_billing_information
-- ----------------------------
DROP TABLE IF EXISTS `t_my_billing_information`;
CREATE TABLE `t_my_billing_information` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `FAMILY_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '户名',
  `FAMILY_CODE` varchar(100) DEFAULT NULL COMMENT '户号',
  `USER_WATER_ADDRESS` varchar(200) DEFAULT NULL COMMENT '用水地址',
  `BILLING_INFORMATION_TYPE` varchar(20) DEFAULT NULL COMMENT '开票类型',
  `TAXPAYERS_REGISTRATION_NUMBER` varchar(100) DEFAULT NULL COMMENT '纳税人识别号码',
  `REGISTER_ADDRESS` varchar(100) DEFAULT NULL COMMENT '注册地址',
  `TEL` varchar(50) DEFAULT NULL COMMENT '企业电话 座机电话',
  `OPEN_BACK` varchar(50) DEFAULT NULL COMMENT '开户银行',
  `BACK_ACCOUNT` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `BILLING_INFORMATION_ACCOUNT` varchar(100) DEFAULT NULL COMMENT '发票通账号',
  `RESERVED_PHONE` varchar(50) DEFAULT NULL COMMENT '预留手机',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime DEFAULT NULL COMMENT '数据的最后修改时间.',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '描述',
  `ENABLED` int(10) NOT NULL DEFAULT '1' COMMENT '是否启用(1=启用，0=禁用)',
  `DEL_FLAG` int(10) NOT '0' COMMENT '删除标记',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='我的开票信息';

-- ----------------------------
-- Records of t_my_billing_information
-- ----------------------------
INSERT INTO `t_my_billing_information` VALUES ('1', '成至纸质品包装有限公司', '1800908647', '王家营大冲工业区', '增值税电子普通发票', '91535135135131', '省市工业区2-2-3地块', '0871-555555', '信用合作社', '165135315', 'cai_ziyong@163.com', '888888888', null, '2019-04-18 17:18:42', '2019-04-18 17:47:12', '的', '1', '0');
