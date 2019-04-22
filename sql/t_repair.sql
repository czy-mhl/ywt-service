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

 Date: 22/04/2019 19:34:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_repair
-- ----------------------------
DROP TABLE IF EXISTS `t_repair`;
CREATE TABLE `t_repair`  (
  `ID` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `FAMILY_NUMBER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户号',
  `REPORT_LEAK_AREA` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报漏报修区域',
  `REPORT_LEAK_ADDRESS` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报漏报修地址',
  `TRANSACTOR_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人姓名',
  `TRANSACTOR_MOBILE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人手机',
  `TRANSACTOR_PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人电话（选填）',
  `DESCRIPTION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体情况',
  `ID_CARD_IMAGE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '有效身份证件正、反面（护照提供内页）',
  `PICTURE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现场照片',
  `REPAIR_TYPE` int(10) NOT NULL COMMENT '报修类别（0=>非户主，1=>户主）',
  `MOBILE_CODE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机验证码（户主）',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `ENABLED` int(10) NOT NULL COMMENT '是否启用（1=启用，0=禁用）',
  `DEL_FLAG` int(10) NULL DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报漏报修' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
