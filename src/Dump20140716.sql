CREATE DATABASE  IF NOT EXISTS `test3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	5.6.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_table`
--

DROP TABLE IF EXISTS `app_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_table` (
  `app_id` int(11) NOT NULL AUTO_INCREMENT,
  `reason` varchar(500) DEFAULT NULL,
  `result` bit(1) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `attend_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`app_id`),
  KEY `type_id_idx` (`type_id`),
  KEY `attend_id_idx` (`attend_id`),
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `type_table` (`type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `attend_id` FOREIGN KEY (`attend_id`) REFERENCES `attend_table` (`attend_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_table`
--

LOCK TABLES `app_table` WRITE;
/*!40000 ALTER TABLE `app_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attend_table`
--

DROP TABLE IF EXISTS `attend_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attend_table` (
  `attend_id` int(11) NOT NULL AUTO_INCREMENT,
  `duty_day` varchar(50) DEFAULT NULL,
  `punch_time` date DEFAULT NULL,
  `isCome` bit(1) NOT NULL DEFAULT b'0',
  `type_id` int(11) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`attend_id`),
  KEY `emp_id_idx` (`emp_id`),
  KEY `type_id_idx` (`type_id`),
  CONSTRAINT `emp_id` FOREIGN KEY (`emp_id`) REFERENCES `emp_table` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION, 
  CONSTRAINT `type_id2` FOREIGN KEY (`type_id`) REFERENCES `type_table` (`type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attend_table`
--

LOCK TABLES `attend_table` WRITE;
/*!40000 ALTER TABLE `attend_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `attend_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `check_table`
--

DROP TABLE IF EXISTS `check_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `check_table` (
  `check_id` int(11) NOT NULL AUTO_INCREMENT,
  `check_reason` varchar(50) DEFAULT NULL,
  `check_result` bit(1) DEFAULT NULL,
  `app_id` int(11) DEFAULT NULL,
  `mgr_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`check_id`),
  KEY `app_id_idx` (`app_id`),
  KEY `mgr_id_idx` (`mgr_id`),
  CONSTRAINT `mgr_id` FOREIGN KEY (`mgr_id`) REFERENCES `mgr_table` (`mgr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `app_id` FOREIGN KEY (`app_id`) REFERENCES `app_table` (`app_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `check_table`
--

LOCK TABLES `check_table` WRITE;
/*!40000 ALTER TABLE `check_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `check_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_table`
--

DROP TABLE IF EXISTS `emp_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_table` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) NOT NULL,
  `emp_pass` varchar(50) NOT NULL,
  `emp_salary` double DEFAULT NULL,
  `mgr_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `mgr_id_idx` (`mgr_id`),  
  CONSTRAINT `mgr_id_emp` FOREIGN KEY (`mgr_id`) REFERENCES `mgr_table` (`mgr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_table`
--

LOCK TABLES `emp_table` WRITE;
/*!40000 ALTER TABLE `emp_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `emp_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mgr_table`
--

DROP TABLE IF EXISTS `mgr_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mgr_table` (
  `mgr_id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(50) NOT NULL,
  PRIMARY KEY (`mgr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mgr_table`
--

LOCK TABLES `mgr_table` WRITE;
/*!40000 ALTER TABLE `mgr_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mgr_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_table`
--

DROP TABLE IF EXISTS `pay_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_table` (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_mouth` varchar(50) NOT NULL,
  `pay_amount` double NOT NULL,
  `pay_tablecol` varchar(45) DEFAULT NULL,
  `emp_id` int(11) NOT NULL,
  PRIMARY KEY (`pay_id`),
  KEY `emp_id_idx` (`emp_id`),  
  CONSTRAINT `emp_id_pay` FOREIGN KEY (`emp_id`) REFERENCES `emp_table` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_table`
--

LOCK TABLES `pay_table` WRITE;
/*!40000 ALTER TABLE `pay_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `pay_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_table`
--

DROP TABLE IF EXISTS `type_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_table` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  `amerce_amount` double DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_table`
--

LOCK TABLES `type_table` WRITE;
/*!40000 ALTER TABLE `type_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-16  0:12:54
