/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : ywt

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-04-18 13:45:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_my_record_info
-- ----------------------------
DROP TABLE IF EXISTS `t_my_record_info`;
CREATE TABLE `t_my_record_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `FAMILT_NAME` varchar(100) DEFAULT NULL COMMENT '户名',
  `FAMILY_CODE` varchar(100) DEFAULT NULL COMMENT '户号',
  `USER_WATER_ADDRESS` varchar(200) DEFAULT NULL COMMENT '用水地址',
  `WATER_METER_DIAMETER` varchar(50) DEFAULT NULL COMMENT '水表口径',
  `READ_METER_PERIOD` varchar(20) DEFAULT NULL COMMENT '抄表周期',
  `USE_WATER_TYPE` varchar(10) DEFAULT NULL COMMENT '用水类型',
  `WATER_UNIT_PRICE` decimal(50,2) DEFAULT NULL COMMENT '水费单价',
  `DRIT_WATER_TYPE` varchar(20) DEFAULT NULL COMMENT '污水类型',
  `DRIT_WATER_UNIT_PRICE` decimal(50,2) DEFAULT NULL COMMENT '污水单价',
  `PROPORTION` varchar(10) DEFAULT NULL COMMENT '占比',
  `GARBAGE_COST` decimal(50,2) DEFAULT NULL COMMENT '垃圾费',
  `AGENCY_DEDUCT_BACK` varchar(100) DEFAULT NULL COMMENT '代扣银行',
  `AGENCY_DEDUCT_ACCOUNT` varchar(100) DEFAULT NULL COMMENT '代扣账号',
  `MOBILE_PHONE` varchar(20) DEFAULT NULL COMMENT '短信定制手机',
  `SERVICE_STRUCTURE` varchar(20) DEFAULT NULL COMMENT '服务机构',
  `SALESMAN` varchar(20) DEFAULT NULL COMMENT '营销员',
  `SALESMAN_PHONE` varchar(20) DEFAULT NULL COMMENT '营销员手机',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime DEFAULT NULL COMMENT '数据的最后修改时间.',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '描述',
  `ENABLED` int(10) NOT NULL DEFAULT '1' COMMENT '是否启用(1=启用，0=禁用)',
  `DEL_FLAG` int(10) NOT '0' COMMENT '删除标记',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我的档案';
