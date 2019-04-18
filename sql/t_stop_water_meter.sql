/*
 Navicat Premium Data Transfer

 Source Server         : 向珂的mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : ywt

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 18/04/2019 10:16:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_stop_water_meter
-- ----------------------------
DROP TABLE IF EXISTS `t_stop_water_meter`;
CREATE TABLE `t_stop_water_meter`  (
  `ID` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `FAMILY_NUMBER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户号',
  `OWNER_MOBILE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户主手机号码',
  `TRANSACTOR` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办理人',
  `TRANSACTOR_ID_CARD` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办理人身份证',
  `TRANSACTOR_MOBILE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办理人手机',
  `APPLY_REASON` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请原因',
  `ID_CARD_IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户主身份证',
  `TRANSACTOR_ID_CARD_IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办理人身份证',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '数据最后修改时间',
  `DESCRIPTION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统菜单描述',
  `ENABLED` int(10) NOT NULL COMMENT '是否启用（1=启用，0=禁用）',
  `DEL_FLAG` int(10) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
