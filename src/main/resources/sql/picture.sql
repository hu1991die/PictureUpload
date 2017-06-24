/*
Navicat MySQL Data Transfer

Source Server         : loclahost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : picturedb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-06-24 19:15:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户id',
  `pic_name` varchar(80) DEFAULT NULL COMMENT '上传后的图片名称',
  `pic_type` varchar(20) DEFAULT NULL COMMENT '图片的分类类型',
  `pic_url` varchar(100) DEFAULT NULL COMMENT '图片上传路径',
  `pic_details` varchar(100) DEFAULT NULL COMMENT '图片的补充说明',
  `create_time` datetime DEFAULT NULL COMMENT '图片上传日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='上传图片表';
