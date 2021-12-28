/*
 Navicat Premium Data Transfer

 Source Server         : shan
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 28/12/2021 15:07:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `price` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '高等元素论', '荧', '55');
INSERT INTO `book` VALUES (2, '普通破盾学', '空', '30');
INSERT INTO `book` VALUES (3, '伤害乘区论', '戴因', '68');
INSERT INTO `book` VALUES (4, '韧性力学', '钟离', '43');
INSERT INTO `book` VALUES (5, '反应详解', '行秋', '48');
INSERT INTO `book` VALUES (6, '基本音律入门', '温迪', '22');

SET FOREIGN_KEY_CHECKS = 1;
