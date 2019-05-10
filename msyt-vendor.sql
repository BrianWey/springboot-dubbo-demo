/*
Navicat MariaDB Data Transfer

Source Server         : test
Source Server Version : 100126
Source Host           : 172.16.50.242:15019
Source Database       : msyt-vendor

Target Server Type    : MariaDB
Target Server Version : 100126
File Encoding         : 65001

Date: 2019-05-10 10:00:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_purchase_order`;
CREATE TABLE `tb_purchase_order` (
  `idx` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '采购单ID',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号，乐观锁解决方案',
  `status` smallint(1) DEFAULT NULL COMMENT '状态，1:待确认、2:待审核、3:已推送、4:已完成',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `chlid_po_num` int(5) DEFAULT NULL COMMENT '采购子单数',
  `item_total` int(5) DEFAULT NULL COMMENT '采购商品数量总和',
  `total_money` int(10) DEFAULT NULL COMMENT '采购商品总金额（根据汇率转成RMB）,单位：分',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间，第一次创建时间，后续不可以修改时间##@EnYyyyMMddHHmmss##',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间，每一次修改都要更新时间##@EnYyyyMMddHHmmss##',
  `complete_time` timestamp NULL DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单采购表(采购部)，存储采购单相关数据';

-- ----------------------------
-- Records of tb_purchase_order
-- ----------------------------

-- ----------------------------
-- Table structure for tb_purchase_order_entry
-- ----------------------------
DROP TABLE IF EXISTS `tb_purchase_order_entry`;
CREATE TABLE `tb_purchase_order_entry` (
  `idx` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号，乐观锁解决方案',
  `status` smallint(1) DEFAULT NULL COMMENT '0：删除（软删除）， 1：可用 , 2: 未激活',
  `po_idx` bigint(20) DEFAULT NULL COMMENT '采购单ID',
  `category` varchar(10) DEFAULT NULL COMMENT '类目',
  `item_code` varchar(20) DEFAULT NULL COMMENT '商品货号',
  `brand` varchar(10) DEFAULT NULL COMMENT '品牌',
  `item_desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `bar_code` varchar(20) DEFAULT NULL COMMENT '条形码',
  `vendor_count` int(10) DEFAULT NULL COMMENT '供应商数量',
  `d_value` int(10) DEFAULT NULL COMMENT '距采购需求数量',
  `avg_purchase_price` int(10) DEFAULT NULL COMMENT '平均采购价，单位：分',
  `total_ship_day` int(10) DEFAULT NULL COMMENT '总运期',
  `total_purchase_count` int(10) DEFAULT NULL COMMENT '采购总数',
  `msg` varchar(20) DEFAULT NULL COMMENT '信息。供应商有修改、供应商已确认、商品部已修改',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='采购子单表，存储采购单关联的采购子单相关数据';

-- ----------------------------
-- Records of tb_purchase_order_entry
-- ----------------------------
INSERT INTO `tb_purchase_order_entry` VALUES ('12', null, null, '52', '1001', 'category1', 'brand1', 'barcode001', '非常的不错', '2', '40', '16', '5', '100', null, '2019-04-25 08:36:44', '2019-04-25 08:36:44');

-- ----------------------------
-- Table structure for tb_purchase_order_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_purchase_order_item`;
CREATE TABLE `tb_purchase_order_item` (
  `idx` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '子单ID',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号，乐观锁解决方案',
  `status` smallint(1) DEFAULT NULL COMMENT '0：删除（软删除）， 1：可用 , 2: 未激活',
  `po_idx` bigint(20) DEFAULT NULL COMMENT '采购单ID',
  `po_entry_idx` bigint(20) DEFAULT NULL COMMENT '采购子单ID',
  `item_code` varchar(20) DEFAULT NULL COMMENT '商品货号',
  `vendor_idx` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  `vendor_name` varchar(20) DEFAULT NULL COMMENT '供应商名称',
  `stock` int(10) DEFAULT NULL COMMENT '可供库存（快照）',
  `item_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `supply_price` int(10) DEFAULT NULL COMMENT '供货价（快照）',
  `currency` varchar(10) DEFAULT NULL COMMENT '币种',
  `exchange_rate` decimal(10,2) DEFAULT NULL COMMENT '汇率',
  `purchase_price` int(10) DEFAULT NULL COMMENT '采购价',
  `ship_day` int(10) DEFAULT NULL COMMENT '运期（快照）',
  `purchase_count` int(10) DEFAULT NULL COMMENT '采购数量',
  `ship_type` varchar(10) DEFAULT NULL COMMENT '货运方式',
  `contacts_idx` bigint(20) DEFAULT NULL COMMENT '联系人ID',
  `msg` varchar(20) DEFAULT NULL COMMENT '信息。供应商有修改、供应商已确认、商品部已修改',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='采购单商品表，存储采购单采购的商品相关数据';

-- ----------------------------
-- Records of tb_purchase_order_item
-- ----------------------------
INSERT INTO `tb_purchase_order_item` VALUES ('14', null, null, '52', '12', '1001', '1', '供应商A', '100', '非常的不错', null, 'RMB', '1.00', '15', '2', '30', '空运', '1', null, '2019-04-25 08:36:44', '2019-04-25 08:36:44');
INSERT INTO `tb_purchase_order_item` VALUES ('15', null, null, '52', '12', '1001', '2', '供应商B', '200', '非常的不错', null, 'RMB', '1.00', '17', '3', '30', '海运', '3', null, '2019-04-25 08:36:44', '2019-04-25 08:36:44');

-- ----------------------------
-- Table structure for tb_vendor
-- ----------------------------
DROP TABLE IF EXISTS `tb_vendor`;
CREATE TABLE `tb_vendor` (
  `idx` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '供应商ID',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号，乐观锁解决方案',
  `status` smallint(1) DEFAULT NULL COMMENT '0：删除（软删除）， 1：可用 , 2: 未激活',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `vendor_name` varchar(20) DEFAULT NULL COMMENT '供应商名称',
  `address` varchar(60) DEFAULT NULL COMMENT '供应商地址',
  `country` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COMMENT='供应商表，存储供应商基本信息';

-- ----------------------------
-- Records of tb_vendor
-- ----------------------------
INSERT INTO `tb_vendor` VALUES ('1', null, null, null, '供应商A', '广东省广州市天河区xxx号', '中国', '广州市', '2019-04-24 01:45:54', '2019-04-24 01:45:54');
INSERT INTO `tb_vendor` VALUES ('2', null, null, null, '供应商B', '广东省广州市天河区xxx号', '中国', '深圳市', '2019-04-24 03:23:45', '2019-04-24 03:23:45');

-- ----------------------------
-- Table structure for tb_vendor_contacts
-- ----------------------------
DROP TABLE IF EXISTS `tb_vendor_contacts`;
CREATE TABLE `tb_vendor_contacts` (
  `idx` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '联系人ID',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号，乐观锁解决方案',
  `status` smallint(1) DEFAULT NULL COMMENT '0：删除（软删除）， 1：可用 , 2: 未激活',
  `name` varchar(20) DEFAULT NULL COMMENT '联系人姓名',
  `phone_num` varchar(20) DEFAULT NULL COMMENT '联系人电话',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `vendor_idx` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COMMENT='供应商联系人表，存储供应商关联的联系人相关数据';

-- ----------------------------
-- Records of tb_vendor_contacts
-- ----------------------------
INSERT INTO `tb_vendor_contacts` VALUES ('1', null, null, 'aaa', '13915324561', 'aaa@qq.com', '1', '2019-04-24 03:24:48', '2019-04-24 03:24:48');
INSERT INTO `tb_vendor_contacts` VALUES ('2', null, null, 'bbb', '13915324562', 'bbb@qq.com', '1', '2019-04-24 03:24:56', '2019-04-24 03:24:56');
INSERT INTO `tb_vendor_contacts` VALUES ('3', null, null, 'ccc', '13915324563', 'ccc@qq.com', '2', '2019-04-24 03:25:16', '2019-04-24 03:25:16');
INSERT INTO `tb_vendor_contacts` VALUES ('4', null, null, 'ddd', '13915321564', 'ddd@qq.com', '2', '2019-04-24 03:25:17', '2019-04-24 03:25:17');

-- ----------------------------
-- Table structure for tb_vendor_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_vendor_item`;
CREATE TABLE `tb_vendor_item` (
  `idx` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号，乐观锁解决方案',
  `status` smallint(1) DEFAULT NULL COMMENT '0：删除（软删除）， 1：可用 , 2: 未激活',
  `item_code` varchar(20) DEFAULT NULL COMMENT '货号',
  `item_name` varchar(20) DEFAULT NULL COMMENT '商品名称',
  `supply_price` int(10) DEFAULT NULL COMMENT '供货价，单位：分',
  `stock` int(10) DEFAULT NULL COMMENT '可供库存',
  `currency` varchar(10) DEFAULT NULL COMMENT '币种',
  `ship_day` int(10) DEFAULT NULL COMMENT '运期',
  `category` varchar(20) DEFAULT NULL COMMENT '类目',
  `brand` varchar(10) DEFAULT NULL COMMENT '品牌',
  `item_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `bar_code` varchar(20) DEFAULT NULL COMMENT '条形码',
  `vendor_idx` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  `specs` varchar(10) DEFAULT NULL COMMENT '规格',
  `origin` varchar(10) DEFAULT NULL COMMENT '原产地',
  `expiry_time` timestamp NULL DEFAULT NULL COMMENT '保质期',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='供应商商品表，存储供应商关联的商品相关数据';

-- ----------------------------
-- Records of tb_vendor_item
-- ----------------------------
INSERT INTO `tb_vendor_item` VALUES ('1', null, null, '1001', '商品1', '15', '100', 'RMB', '2', 'category1', 'brand1', '非常的不错', 'barcode001', '1', '规格1', null, '2019-04-24 12:45:17', '2019-04-24 12:45:17', '2019-04-24 12:45:17');
INSERT INTO `tb_vendor_item` VALUES ('2', null, null, '1001', '商品11', '17', '200', 'RMB', '3', 'category1', 'brand1', '非常的不错', 'barcode001', '1', '规格2', null, '2019-04-24 12:45:16', '2019-04-24 12:45:16', '2019-04-24 12:45:16');
INSERT INTO `tb_vendor_item` VALUES ('3', null, null, '1002', '商品3', '16', '300', 'RMB', '4', 'category1', 'brand1', '非常的不错3', 'barcode002', '2', '规格3', '中国', '2019-04-24 12:44:23', '2019-04-24 12:44:23', '2019-04-24 12:44:23');

-- ----------------------------
-- Table structure for tb_vendor_purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_vendor_purchase_order`;
CREATE TABLE `tb_vendor_purchase_order` (
  `idx` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '供应商端采购单ID',
  `version` bigint(20) DEFAULT NULL,
  `status` smallint(1) DEFAULT NULL COMMENT '供应商端采购单状态',
  `po_idx` bigint(20) DEFAULT NULL COMMENT '商品部采购单ID',
  `vendor_idx` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  `item_range_count` int(10) DEFAULT NULL COMMENT '采购商品种数',
  `item_total` int(10) DEFAULT NULL COMMENT '采购总数',
  `total_money` int(10) DEFAULT NULL COMMENT '总金额，单位：分',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='供应商端采购单表，存储商品采购部推送相关数据';

-- ----------------------------
-- Records of tb_vendor_purchase_order
-- ----------------------------
INSERT INTO `tb_vendor_purchase_order` VALUES ('21', null, '0', null, '1', '1', '30', '450', '2019-04-25 19:27:03', null);
INSERT INTO `tb_vendor_purchase_order` VALUES ('22', null, '0', null, '2', '1', '30', '510', '2019-04-25 19:27:03', null);
