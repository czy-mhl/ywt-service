/*
Navicat MySQL Data ResidentTransfer

Source Server         : 本地mysql
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : ywt

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-04-16 15:30:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_file_error_info
-- ----------------------------
DROP TABLE IF EXISTS `t_file_error_info`;
CREATE TABLE `t_file_error_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `FAMILY_CODE` varchar(100) DEFAULT NULL COMMENT '户号',
  `USER_WATER_ADDRESS` varchar(200) DEFAULT NULL COMMENT '用水地址',
  `THE_LINKMAN` varchar(10) DEFAULT NULL COMMENT '联系人',
  `MOBILE_PHONE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `ERROR_DESCRIPTION_ACCESSORY_URL` varchar(500) DEFAULT NULL COMMENT '差错说明附件  多个 url 用 , 号隔开',
  `PAPER_ACCESSORY_URL` varchar(500) DEFAULT NULL COMMENT '证件附件  多个 url 用 , 号隔开',
  `OTHER_ACCESSORY_URL` varchar(500) DEFAULT NULL COMMENT '其他附件 url  多个 url 用 , 号隔开',
  `CHECK_CODE` varchar(10) DEFAULT NULL COMMENT '验证吗',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime DEFAULT NULL COMMENT '数据的最后修改时间.',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '系统菜单描述',
  `ENABLED` int(10) NOT NULL DEFAULT '1' COMMENT '是否启用(1=启用，0=禁用)',
  `DEL_FLAG` int(10) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='档案错误申报';
