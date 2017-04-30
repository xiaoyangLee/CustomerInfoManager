/*
Navicat MySQL Data Transfer

Source Server         : JavaMySQL
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : db_customerinfomanager

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2017-01-03 13:42:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` int(255) NOT NULL auto_increment,
  `companyName` varchar(255) NOT NULL,
  `companyTel` varchar(255) default NULL,
  `companyEmail` varchar(255) default NULL,
  `companyAddress` varchar(255) default NULL,
  `companyDesc` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES ('1', '微软', '+0010648712', 'Microsoft@outlook.com', '美国华盛顿州雷德蒙德', '巨硬啊！微软');
INSERT INTO `t_company` VALUES ('3', '苹果', '+001043546536', 'apple@apple.com', '美国圣弗朗西斯科', '教主！');
INSERT INTO `t_company` VALUES ('4', '百度', '48579248', 'baidu@baidu.com', '北京市百度大厦', '百度是全球最大的中文搜索公司');
INSERT INTO `t_company` VALUES ('5', '阿里巴巴', '438579560', 'alibaba@aliyun.com', '杭州市阿里巴巴', '中国最大的电子商务公司，旗下淘宝、天猫、支付宝');
INSERT INTO `t_company` VALUES ('6', 'Yahoo', '+00104246523', 'yahoo@yahoo.com', '美国旧金山', '由两个中国人最初于硅谷创办');
INSERT INTO `t_company` VALUES ('7', '腾讯', '845728496', 'tencent@qq.com', '深圳市腾讯计算机公司', '中国最顶尖的IT公司之一，坑了无数人的钱');

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(255) NOT NULL auto_increment,
  `customerName` varchar(255) NOT NULL,
  `sex` char(2) default NULL,
  `customerTel` varchar(255) default NULL,
  `customerEmail` varchar(255) default NULL,
  `customerDesc` varchar(255) default NULL,
  `companyId` int(255) NOT NULL,
  `productId` int(255) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `customer_fk1` (`companyId`),
  KEY `customer_fk2` (`productId`),
  CONSTRAINT `customer_fk1` FOREIGN KEY (`companyId`) REFERENCES `t_company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `customer_fk2` FOREIGN KEY (`productId`) REFERENCES `t_product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', '比尔盖茨', '男', '18437920001', 'bill@outlook.com', '创始人，世界首富', '1', '1');
INSERT INTO `t_customer` VALUES ('2', '保罗艾伦', '男', '18077367832', 'poral@outlook.com', '微软创始人之一', '1', '2');
INSERT INTO `t_customer` VALUES ('3', '乔布斯', '男', '13289080893', 'jobs@apple.com', '苹果教父', '3', '4');
INSERT INTO `t_customer` VALUES ('4', '库克', '男', '13240495894', 'kuke@apple.com', '现任的苹果CEO', '3', '5');
INSERT INTO `t_customer` VALUES ('5', '鲍尔默', '男', '18234454556', 'baoermo@outlook.com', '苹果现任CEO', '1', '3');
INSERT INTO `t_customer` VALUES ('8', '纳德拉', '男', '+001023555445', 'nadela@outlook.com', '纳德拉是微软的CEO，他与Nokia联手推出Window Phone，坑了队友也坑了自己', '1', '12');
INSERT INTO `t_customer` VALUES ('10', '玛丽莎·梅耶尔', '女', '+0010563563', 'marisya@yahoo.com', 'yahoo的女CEO，IT界的人才啊', '6', '10');
INSERT INTO `t_customer` VALUES ('11', '马云', '男', '34856986234', 'mayun@aliyun.com', '马云，全中国都知道他有钱！', '5', '9');
INSERT INTO `t_customer` VALUES ('14', '马化腾', '男', '5354667', 'mahuateng@qq.com', '小马哥是腾讯的CEO，一手创办了Tencent', '7', '8');
INSERT INTO `t_customer` VALUES ('15', '李彦宏', '男', '535466753', 'liyanhong@baidu.com', '百度创始人CEO', '4', '11');
INSERT INTO `t_customer` VALUES ('16', '鲍尔默1', '', '+00105454545', 'baoermo@outlook.com', '', '1', '3');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(255) NOT NULL auto_increment,
  `productName` varchar(255) NOT NULL,
  `companyId` int(255) NOT NULL,
  `productDesc` varchar(255) default NULL,
  `productPrice` float(255,0) default NULL,
  PRIMARY KEY  (`id`),
  KEY `product_fk1` (`companyId`),
  CONSTRAINT `product_fk1` FOREIGN KEY (`companyId`) REFERENCES `t_company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', 'Surface Pro', '1', '微软旗舰级平板电脑', '9000');
INSERT INTO `t_product` VALUES ('2', 'Surface', '1', '微软平板电脑，普通版', '3000');
INSERT INTO `t_product` VALUES ('3', 'Windows 10', '1', 'Windows10是微软新一代操作系统', '889');
INSERT INTO `t_product` VALUES ('4', 'Mac book', '3', '苹果公司的笔记本电脑', '7889');
INSERT INTO `t_product` VALUES ('5', 'IPhone', '3', '苹果公司的手机，风靡全球', '5000');
INSERT INTO `t_product` VALUES ('6', 'iMac', '3', '苹果公司的电脑，桌面一体机', '3501');
INSERT INTO `t_product` VALUES ('8', 'QQ', '7', 'QQ是腾讯最核心的产品，他是不会卖的！', '10000000000');
INSERT INTO `t_product` VALUES ('9', '支付宝', '5', '阿里巴巴旗下的产品', '19000000');
INSERT INTO `t_product` VALUES ('10', 'Yahoo搜索', '6', 'yahoo搜索', '56738');
INSERT INTO `t_product` VALUES ('11', '百度搜索', '4', '全球最大的中文搜索引擎', '56738');
INSERT INTO `t_product` VALUES ('12', 'Window Phone', '1', 'Nokia找到微软的那刻，就悲剧了', '3000');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL,
  `userName` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `role` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'root', '123456', '管理员');
INSERT INTO `t_user` VALUES ('2', 'lxy', '123456', '普通用户');
INSERT INTO `t_user` VALUES ('3', 'ord', '123456', '普通用户');
