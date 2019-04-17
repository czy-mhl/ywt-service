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

 Date: 17/04/2019 15:37:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_resident_transfer
-- ----------------------------
DROP TABLE IF EXISTS `t_resident_transfer`;
CREATE TABLE `t_resident_transfer`  (
  `ID` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `OLD_FAMILY_NUMBER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '旧户号',
  `NEW_FAMILY_NUMBER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新户号',
  `NEW_FAMILY_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新户名',
  `PROPERTY_ADDRESS` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产权地址',
  `NEW_OWNER_MOBILE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新联系电话',
  `ID_TYPE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件类型',
  `ID_CARD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证件号码',
  `OWNER_CERTIFICATENO` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产权证号',
  `OTHER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它说明',
  `ID_CARD_IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '有效身份证件正、反面（护照提供内页）',
  `OWNER_CERTIFICATE_IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '不动产完整内页图片',
  `MANAGER_ID_CARD_IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权委托、经办人有效身份证正、反（护照提供内页）',
  `MOBILE_CODE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机验证码',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '数据的最后修改时间.',
  `DESCRIPTION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统菜单描述',
  `ENABLED` int(10) NOT NULL COMMENT '是否启用(1=启用，0=禁用)',
  `DEL_FLAG` int(10) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
