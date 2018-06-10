/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : db2

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-06-10 12:53:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bookinfo`
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `author` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `orderinfo`
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `addressId` bigint(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0' COMMENT '0待发货,1已发货,2已签收,3退款,4退货,5已完成,6作废',
  `payStatus` tinyint(1) DEFAULT '0' COMMENT '0未支付,1已支付',
  `payno` varchar(100) DEFAULT NULL COMMENT '支付单号',
  `expressNo` varchar(50) DEFAULT NULL COMMENT '快递单号',
  `express` varchar(50) DEFAULT NULL COMMENT '快递公司code',
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `spec` varchar(50) DEFAULT NULL,
  `orderId` bigint(20) DEFAULT NULL,
  `num` int(5) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` tinyint(2) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'iphonex', '1', 'iphone x全新设计');
INSERT INTO `product` VALUES ('2', 'iphone8', '1', 'iphone 8全新设计');

-- ----------------------------
-- Table structure for `productitem`
-- ----------------------------
DROP TABLE IF EXISTS `productitem`;
CREATE TABLE `productitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spec` varchar(50) DEFAULT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `productId` bigint(20) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of productitem
-- ----------------------------
INSERT INTO `productitem` VALUES ('1', '红色', 'iphonex', '1', '台', '1000000');
INSERT INTO `productitem` VALUES ('2', '黑色', 'iphonex', '1', '台', '1100000');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `author` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005551268527214593 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1005551268527214592', '广州', '李四', '95', null);
