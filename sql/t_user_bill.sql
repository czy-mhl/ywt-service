/*
 Navicat Premium Data ResidentTransfer

 Source Server         : 向珂的mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : ywt

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 16/04/2019 10:03:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user_bill
-- ----------------------------
DROP TABLE IF EXISTS `t_user_bill`;
CREATE TABLE `t_user_bill`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USER_ID` bigint(10) NOT NULL COMMENT 'USER_ID账单',
  `BILL_MONTH` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账单月份',
  `LAST_READ` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上次抄表',
  `THIS_READ` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本次抄表',
  `LAST_ARRIVAL` bigint(20) NULL DEFAULT NULL COMMENT '上次到度',
  `THIS_ARRIVAL` bigint(20) NULL DEFAULT NULL COMMENT '本次到度',
  `READ_SITUATION` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抄表情况',
  `WATER_CONSUMPTION` bigint(15) NULL DEFAULT NULL COMMENT '用水量',
  `WATER_RATES` decimal(10, 2) NULL DEFAULT NULL COMMENT '自来水费',
  `SEWAGE_CHARGE` decimal(10, 2) NULL DEFAULT NULL COMMENT '污水费',
  `GARBAGE_CHARGE` decimal(10, 2) NULL DEFAULT NULL COMMENT '垃圾费',
  `PENALTY` decimal(10, 2) NULL DEFAULT NULL COMMENT '违约金',
  `NON_RESIDENT_PRICE` decimal(10, 2) NULL DEFAULT NULL COMMENT '非居名污水费单价',
  `BUSINESS_CIRCLES_PRICE` decimal(10, 2) NULL DEFAULT NULL COMMENT '工商用水单价',
  `MOUTH_TOTAL` decimal(10, 2) NULL DEFAULT NULL COMMENT '当月总额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
