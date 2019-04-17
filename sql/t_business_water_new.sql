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

 Date: 17/04/2019 15:37:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_business_water_new
-- ----------------------------
DROP TABLE IF EXISTS `t_business_water_new`;
CREATE TABLE `t_business_water_new`  (
  `ID` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `CUSTOMER_TYPE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `BUSINESS_TYPE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务类型',
  `OWNER_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业主名称',
  `AREA` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属区域',
  `ADDRESS` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用水地址',
  `OWNER_MOBILE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业主手机',
  `COMPANY_TYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位证件类型',
  `CREDIT_CODE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '统一社会信用代码',
  `CORPORATE_REPRESEN_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人代表名称',
  `CORPORATE_REPRESEN_ID_CARD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人有效身份证件号码',
  `WATER_TYPE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用水性质',
  `MANAGER_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人姓名',
  `MANAGER_EMAIL` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  `MANAGER_MOBILE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人电话',
  `INVOICE_TYPE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开票类型',
  `BUSINESS_LICENSE_IMAGE` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照原件或复印件加盖公章（三证合一）',
  `CORPORATE_REPRESEN_ID_CARD_IMAGE` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人身份证正、反面或复印件加盖公章',
  `MANAGER_ID_CARD_IMAGE` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权委托、经办人有效身份证正、反（护照提供内页）',
  `OTHER_IMAGE` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它图片',
  `MOBILE_CODE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机验证码',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '数据最后修改时间',
  `DESCRIPTION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统菜单描述',
  `ENABLED` int(10) NOT NULL COMMENT '是否启用（1=启用，0=禁用）',
  `DEL_FLAG` int(10) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
