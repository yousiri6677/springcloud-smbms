/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.28 : Database - decoratestate
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`decoratestate` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `decoratestate`;

/*Table structure for table `companyinfo` */

DROP TABLE IF EXISTS `companyinfo`;

CREATE TABLE `companyinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司信息Id',
  `userId` bigint(20) NOT NULL COMMENT '用户id',
  `companyProfile` varchar(225) COLLATE utf8mb4_bin NOT NULL COMMENT '公司简介',
  `companyLogo` bigint(20) NOT NULL COMMENT 'imgId',
  `regCapital` double NOT NULL COMMENT '注册资金',
  `address` varchar(225) COLLATE utf8mb4_bin NOT NULL COMMENT '公司住址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `companyinfo` */

/*Table structure for table `decoratecase` */

DROP TABLE IF EXISTS `decoratecase`;

CREATE TABLE `decoratecase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '装修案例ID',
  `companyId` bigint(20) NOT NULL COMMENT '所属公司ID',
  `imgId` bigint(20) NOT NULL COMMENT '图片库ID',
  `title` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `content` varchar(225) COLLATE utf8mb4_bin NOT NULL COMMENT '装修简介',
  `area` double DEFAULT NULL COMMENT '装修面积',
  `browseNum` int(11) NOT NULL COMMENT '浏览数',
  `demandTypeId` bigint(20) NOT NULL COMMENT '装修类型（风阁）Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `decoratecase` */

/*Table structure for table `demand` */

DROP TABLE IF EXISTS `demand`;

CREATE TABLE `demand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '需求id自增长',
  `title` varchar(225) COLLATE utf8mb4_bin NOT NULL COMMENT '需求标题',
  `content` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '需求具体内容',
  `releaseId` bigint(20) NOT NULL COMMENT '发布人Id',
  `demandTypeId` bigint(20) NOT NULL COMMENT '需求类型Id',
  `money` double NOT NULL COMMENT '需求金额（可能是范围）',
  `requirements` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '要求',
  `releaseTime` datetime NOT NULL COMMENT '发布时间',
  `acceptanceTime` datetime NOT NULL COMMENT '验收时间',
  `referenceDoc` varchar(225) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '参考文档（可选）',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '0:正在招标，1：已结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `demand` */

/*Table structure for table `demandbill` */

DROP TABLE IF EXISTS `demandbill`;

CREATE TABLE `demandbill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账单Id',
  `userId` bigint(20) NOT NULL COMMENT '用户id',
  `demand` bigint(20) NOT NULL COMMENT '需求id',
  `completionTime` datetime NOT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `demandbill` */

/*Table structure for table `demandtype` */

DROP TABLE IF EXISTS `demandtype`;

CREATE TABLE `demandtype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '装修需求类型ID',
  `typeName` varchar(25) COLLATE utf8mb4_bin NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `demandtype` */

/*Table structure for table `images` */

DROP TABLE IF EXISTS `images`;

CREATE TABLE `images` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `imgInfo` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '图片大概信息',
  `imgPath` varchar(225) COLLATE utf8mb4_bin NOT NULL COMMENT '图片路径',
  `imgState` int(11) NOT NULL DEFAULT '0' COMMENT '0:正常,1:默认',
  `userId` bigint(20) NOT NULL COMMENT '所属用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `images` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(25) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `account` varchar(25) COLLATE utf8mb4_bin NOT NULL COMMENT '账号',
  `passWord` varchar(25) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `idNumber` varchar(18) COLLATE utf8mb4_bin NOT NULL COMMENT '身份证号',
  `userTypeId` int(11) NOT NULL COMMENT '用户类型id',
  `address` varchar(225) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '住址',
  `userState` int(11) NOT NULL COMMENT '0:正常使用，-1：冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `user` */

/*Table structure for table `usertype` */

DROP TABLE IF EXISTS `usertype`;

CREATE TABLE `usertype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户类型Id',
  `userType` varchar(25) COLLATE utf8mb4_bin NOT NULL COMMENT '用户类型',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `usertype` */

insert  into `usertype`(`Id`,`userType`) values (1,'管理员'),(2,'商家'),(3,'公司'),(4,'普通用户');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
