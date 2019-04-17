/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : ywt

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-04-17 11:58:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_water_bill
-- ----------------------------
DROP TABLE IF EXISTS `t_water_bill`;
CREATE TABLE `t_water_bill` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `FAMILY_CODE` varchar(100) DEFAULT NULL COMMENT '户号',
  `BILL_MONTH` int(20) DEFAULT NULL COMMENT '账单月份',
  `LAST_READ_DATE` date DEFAULT NULL COMMENT '上次抄表日期',
  `THIS_READ_DATE` date DEFAULT NULL COMMENT '本次抄表日期',
  `LAST_ARRIVAL` int(20) DEFAULT '0' COMMENT '上次到度',
  `THIS_ARRIVAL` int(20) DEFAULT '0' COMMENT '本次到度',
  `READ_SITUATION` varchar(20) DEFAULT '正常' COMMENT '抄表情况',
  `WATER_CONSUMPTION` int(20) DEFAULT '0' COMMENT '用水量',
  `WATER_COST` decimal(50,2) DEFAULT NULL COMMENT '自来水费',
  `DIRT_WATER_COST` decimal(50,2) DEFAULT NULL COMMENT '污水费',
  `GARBAGE_COST` decimal(50,2) DEFAULT NULL COMMENT '垃圾费',
  `PENALTY` decimal(50,2) DEFAULT NULL COMMENT '违约金',
  `TOTAL_MONEY` decimal(50,2) DEFAULT NULL COMMENT '合计金额',
  `PAYMENT_STATUS` varchar(50) DEFAULT NULL COMMENT '缴费状态',
  `PAYMENT_DATE` datetime DEFAULT NULL COMMENT '缴费日期',
  `PAYMENT_URL` varchar(50) DEFAULT NULL COMMENT '缴费渠道',
  `PAYMENT_WAY` varchar(50) DEFAULT NULL COMMENT '缴费方式',
  `USE_WATER_TYPE` varchar(50) DEFAULT NULL COMMENT '用水类型  工商用水  居民用水',
  `WATER_UNIT_PRICE` decimal(50,2) DEFAULT NULL COMMENT '水费单价',
  `DIRT_WATER_TYPE` varchar(50) DEFAULT NULL COMMENT '污水费类型 居民污水  非居民污水',
  `DIRT_WATER_UNIT_PRICE` decimal(50,2) DEFAULT NULL COMMENT '污水单价',
  `INVOICE_TYPE` varchar(50) DEFAULT NULL COMMENT '发票类型',
  `INVOICE_STATUS` varchar(50) DEFAULT NULL COMMENT '发票状态 已开 未开',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime DEFAULT NULL COMMENT '数据的最后修改时间.',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '系统菜单描述',
  `ENABLED` int(10) NOT NULL DEFAULT '1' COMMENT '是否启用(1=启用，0=禁用)',
  `DEL_FLAG` int(10) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='水费账单';

-- ----------------------------
-- Records of t_water_bill
-- ----------------------------
INSERT INTO `t_water_bill` VALUES ('1', '1800908647', '201904', '2019-03-01', '2019-04-03', '56732', '59186', '正常', '2454', '10674.90', '3067.50', '666.00', '0.00', '14408.40', '已交费', '2019-04-12 11:55:01', '经开区营业厅', '柜台缴费', '工业用水', '4.35', '非居民污水费', '1.25', '专票', '已开票', '2019-04-17 11:58:19', '2019-04-17 11:58:23', '正常计费', '1', '0');
INSERT INTO `t_water_bill` VALUES ('2', '1800908647', '201903', '2019-03-01', '2019-04-03', '56732', '59186', '正常', '2454', '10674.90', '3067.50', '666.00', '0.00', '14408.40', '已交费', '2019-04-12 11:55:01', '经开区营业厅', '柜台缴费', '工业用水', '4.35', '非居民污水费', '1.25', '专票', '已开票', '2019-04-17 11:58:19', '2019-04-17 11:58:23', '正常计费', '1', '0');
INSERT INTO `t_water_bill` VALUES ('3', '1800908647', '201902', '2019-03-01', '2019-04-03', '56732', '59186', '正常', '2454', '10674.90', '3067.50', '666.00', '0.00', '14408.40', '已交费', '2019-04-12 11:55:01', '经开区营业厅', '柜台缴费', '工业用水', '4.35', '非居民污水费', '1.25', '专票', '已开票', '2019-04-17 11:58:19', '2019-04-17 11:58:23', '正常计费', '1', '0');
INSERT INTO `t_water_bill` VALUES ('4', '1800908647', '201901', '2019-03-01', '2019-04-03', '56732', '59186', '正常', '2454', '10674.90', '3067.50', '666.00', '0.00', '14408.40', '已交费', '2019-04-12 11:55:01', '经开区营业厅', '柜台缴费', '工业用水', '4.35', '非居民污水费', '1.25', '专票', '已开票', '2019-04-17 11:58:19', '2019-04-17 11:58:23', '正常计费', '1', '0');
INSERT INTO `t_water_bill` VALUES ('5', '1800908647', '201812', '2019-03-01', '2019-04-03', '56732', '59186', '正常', '2454', '10674.90', '3067.50', '666.00', '0.00', '14408.40', '已交费', '2019-04-12 11:55:01', '经开区营业厅', '柜台缴费', '工业用水', '4.35', '非居民污水费', '1.25', '专票', '已开票', '2019-04-17 11:58:19', '2019-04-17 11:58:23', '正常计费', '1', '0');
INSERT INTO `t_water_bill` VALUES ('6', '1800908647', '201811', '2019-03-01', '2019-04-03', '56732', '59186', '正常', '2454', '10674.90', '3067.50', '666.00', '0.00', '14408.40', '已交费', '2019-04-12 11:55:01', '经开区营业厅', '柜台缴费', '工业用水', '4.35', '非居民污水费', '1.25', '专票', '已开票', '2019-04-17 11:58:19', '2019-04-17 11:58:23', '正常计费', '1', '0');
