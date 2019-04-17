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

 Date: 17/04/2019 08:58:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_temporary_water
-- ----------------------------
DROP TABLE IF EXISTS `t_temporary_water`;
CREATE TABLE `t_temporary_water`  (
  `ID` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `CUSTOMER_TYPE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `OWNER_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业主名称',
  `OWNER_MOBILE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业主手机',
  `AREA` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属区域',
  `ADDRESS` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用水地址',
  `COMPANY_TYPE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位证件类型',
  `CREDIT_CODE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '统一社会信用代码',
  `CORPORATE_REPRESEN_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人代表名称',
  `CORPORATE_REPRESEN_ID_CARD` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人证件号码',
  `MANAGER_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人',
  `MANAGER_MOBILE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人电话',
  `MANAGER_EMAIL` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  `INVOICE_TYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票类型',
  `BUSINESSLICENSE_IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照原件或复印件加盖公章（三证合一）',
  `CORPORATE_REPRESEN_ID_CARD_IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人身份证正、反面或复印件加盖公章',
  `LAND_OWNERSHIP_IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用水地块的土地归属相关文件原件或复印件加盖公章',
  `MANAGER_ID_CARD_IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权委托、经办人有效身份证正、反（护照提供内页）',
  `OTHER_IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它图片',
  `MOBILE_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机验证码',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '数据的最后修改时间',
  `DESCRIPTION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统菜单描述',
  `ENABLED` int(10) NOT NULL COMMENT '是否启用（1=启用，0=禁用）',
  `DEL_FLAG` int(10) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
