/*
 Navicat Premium Data Transfer

 Source Server         : LinuxExam
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 180.76.172.205:3306
 Source Schema         : bookdemo

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 30/12/2021 23:29:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '高等元素论', '荧');
INSERT INTO `book` VALUES (2, '普通破盾学', '空');
INSERT INTO `book` VALUES (3, '伤害乘区论', '戴因');
INSERT INTO `book` VALUES (4, '韧性力学', '钟离');
INSERT INTO `book` VALUES (5, '反应详解', '行秋');

SET FOREIGN_KEY_CHECKS = 1;
