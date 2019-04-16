/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : ywt

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-04-16 15:30:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dibao_info
-- ----------------------------
DROP TABLE IF EXISTS `t_dibao_info`;
CREATE TABLE `t_dibao_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `FAMILT_NAME` varchar(100) DEFAULT NULL COMMENT '户名',
  `FAMILY_CODE` varchar(100) DEFAULT NULL COMMENT '户号',
  `USER_WATER_ADDRESS` varchar(20) DEFAULT NULL COMMENT '用水地址',
  `APPLY_TYPE` int(50) DEFAULT NULL COMMENT '办理类别  1 新增  2 复审',
  `FAMILY_MAIN_NAME` varchar(200) DEFAULT NULL COMMENT '低保户主名字',
  `THE_LINKMAN` varchar(10) DEFAULT '0' COMMENT '联系人',
  `MOBILE_PHONE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `IDENTITY_NUMBER` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `DIBAOTEKUN_URL` varchar(20) DEFAULT '1' COMMENT '低保金额领取证或特困供养证原件照片url  多个 url 用 , 号隔开',
  `IDENTITY_PICTURE_URL` varchar(10) DEFAULT NULL COMMENT '低保户身份证照片url  多张照片 url 用 , 号隔开',
  `TENANCY_AGREEMENT_FILE_URL` varchar(10) DEFAULT NULL COMMENT '保障性住房租房合同 url  多个 url 用 , 号隔开',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `LAST_UPDATE_TIME` datetime DEFAULT NULL COMMENT '数据的最后修改时间.',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '系统菜单描述',
  `ENABLED` int(10) NOT NULL DEFAULT '1' COMMENT '是否启用(1=启用，0=禁用)',
  `DEL_FLAG` int(10) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='低保优惠业务办理';
