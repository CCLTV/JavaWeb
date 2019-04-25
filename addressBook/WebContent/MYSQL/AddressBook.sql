-- 创建电话薄数据库
CREATE DATABASE addressBook;
USE addressBook;

-- 创建表usetab
CREATE TABLE `usetab` (
  `uid` INT(4) NOT NULL,
  `userName` VARCHAR(10) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `sex` VARCHAR(2) DEFAULT NULL,
  `age` TINYINT(3) DEFAULT NULL,
  `tell` VARCHAR(12) DEFAULT NULL,
  `email` VARCHAR(20) DEFAULT NULL,
  `flag` INT(2) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=INNODB DEFAULT CHARSET=gbk

-- 创建addressbooktab表

CREATE TABLE `addressbooktab` (
  `eId` INT(3) UNSIGNED NOT NULL,
  `eName` VARCHAR(20) NOT NULL,
  `eSex` VARCHAR(2) DEFAULT NULL,
  `eAge` TINYINT(3) DEFAULT NULL,
  `eTell1` VARCHAR(12) NOT NULL,
  `eTell2` VARCHAR(12) DEFAULT NULL,
  `eTell3` VARCHAR(12) DEFAULT NULL,
  `eEmail` VARCHAR(20) DEFAULT NULL,
  `eAddress` VARCHAR(50) DEFAULT NULL,
  `flag` INT(2) DEFAULT NULL,
  PRIMARY KEY (`eId`)
) ENGINE=INNODB DEFAULT CHARSET=gbk


-- 创建表birthdaytab
CREATE TABLE `birthdaytab` (
  `bId` INT(3) UNSIGNED NOT NULL,
  `bName` VARCHAR(20) NOT NULL,
  `bSex` VARCHAR(2) DEFAULT NULL,
  `bAge` TINYINT(4) DEFAULT NULL,
  `bBirthday` VARCHAR(20) NOT NULL,
  `flag` INT(2) DEFAULT NULL,
  PRIMARY KEY (`bId`)
) ENGINE=INNODB DEFAULT CHARSET=gbk
