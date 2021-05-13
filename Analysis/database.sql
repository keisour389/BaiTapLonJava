-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: bus_management
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account_info`
--

DROP TABLE IF EXISTS `account_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_info` (
  `USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `PASSWORD` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `TYPE` int NOT NULL,
  `STATUS` int NOT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `NOTE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_info`
--

LOCK TABLES `account_info` WRITE;
/*!40000 ALTER TABLE `account_info` DISABLE KEYS */;
INSERT INTO `account_info` VALUES ('1','string',0,0,'2021-05-10 03:17:02','2021-05-10 03:17:02','string'),('123','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1,1,'2021-05-11 03:41:00','2021-05-11 03:41:00',NULL),('1234','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1,1,'2021-05-11 03:41:00','2021-05-11 03:41:00',NULL),('12345','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1,1,'2021-05-11 05:55:29',NULL,NULL),('123456','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',2,1,'2021-05-11 06:56:00',NULL,NULL),('1234567','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1,1,'2021-05-11 09:40:57',NULL,NULL),('132','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',2,1,'2021-05-11 07:03:23',NULL,NULL),('2','ef2d127de37b942baad06145e54b0c619a1f22327b2ebbcfbec78f5564afe39d',0,0,'2021-05-10 03:43:35','2021-05-10 03:43:35','string'),('3','473287f8298dba7163a897908958f7c0eae733e25d2e027992ea2edc9bed2fa8',0,0,'2021-05-11 03:41:00','2021-05-11 03:41:00','string'),('5','5',5,5,NULL,NULL,NULL),('6','6',6,6,NULL,NULL,NULL),('7','7',7,7,NULL,NULL,NULL),('8','8',8,8,NULL,NULL,NULL),('dssadsa','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',2,1,'2021-05-11 06:56:49',NULL,NULL),('sdasdad','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',2,1,'2021-05-11 07:07:40',NULL,NULL),('test','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1,1,'2021-05-11 03:41:00','2021-05-11 03:41:00',NULL),('testing','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1,1,'2021-05-11 03:41:00','2021-05-11 03:41:00',NULL),('testingg','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',2,1,'2021-05-11 09:26:36',NULL,NULL),('testinggg','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1,1,'2021-05-11 09:28:04',NULL,NULL),('testy','testy',0,0,'2021-03-30 16:30:54','2021-03-30 16:30:54',NULL),('testyy','$2a$10$.ncUyYh5LYyZGzjUWm/Zw.1fCOm5ZzohteiKJIRdFxM3kl1yWmcyK',0,0,'2021-03-30 16:34:21','2021-03-30 16:34:21',NULL),('testyyy','$2a$10$IUoXhS9GURK5/8hiDgOvQOLAI7sLALB7EBMA4A//65AOQyKF5K6uK',0,0,'2021-03-30 17:06:23','2021-03-30 17:06:23',NULL),('testyyyy','$2a$10$iffqlM1zLuEuDwiIymVCeekNaxT5aLHZ21KbNZzncWsTzCH/GuK36',0,0,'2021-03-30 17:19:32','2021-03-30 17:19:32',NULL),('testyyyyy','$2a$10$6xDtT2As/b0sB6iootXyUu6knitTAP/oj.AlUyG3XBx9wszJy47W6',0,0,'2021-03-30 17:20:24','2021-03-30 17:20:24',NULL),('tri','$2a$10$f5SyeD691ZlPcAheTseitOvRHdaRbORJByPEALuKoSyvJFKkxdOd2',0,0,'2021-04-16 17:48:25','2021-04-16 17:48:25',NULL);
/*!40000 ALTER TABLE `account_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus_schedules`
--

DROP TABLE IF EXISTS `bus_schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bus_schedules` (
  `TRIP_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `LICENSE_PLATES` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `MAIN_DRIVER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `SUB_DRIVER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `START` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `DESTINATION` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `DEPARTURE_DAY` datetime NOT NULL,
  `TOTAL_TIME` int NOT NULL,
  `STATUS` int NOT NULL,
  `VEHICLE_TYPE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `TOTAL_SEATS` int NOT NULL,
  `PRICE` decimal(45,0) NOT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `NOTE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `MANAGER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`TRIP_ID`),
  KEY `fk_bus_schedules_emp_info1_idx` (`MAIN_DRIVER`),
  KEY `fk_bus_schedules_emp_info2_idx` (`SUB_DRIVER`),
  KEY `fk_bus_schedules_emp_info3_idx` (`MANAGER`),
  CONSTRAINT `fk_bus_schedules_emp_info1` FOREIGN KEY (`MAIN_DRIVER`) REFERENCES `emp_info` (`USER_ID`),
  CONSTRAINT `fk_bus_schedules_emp_info2` FOREIGN KEY (`SUB_DRIVER`) REFERENCES `emp_info` (`USER_ID`),
  CONSTRAINT `fk_bus_schedules_emp_info3` FOREIGN KEY (`MANAGER`) REFERENCES `emp_info` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus_schedules`
--

LOCK TABLES `bus_schedules` WRITE;
/*!40000 ALTER TABLE `bus_schedules` DISABLE KEYS */;
INSERT INTO `bus_schedules` VALUES ('1','1','string4','string4','1','1','2021-01-01 00:00:00',1,1,'1',1,0,'2021-01-01 00:00:00','2021-01-01 00:00:00','1','string4'),('2','string','string4','string4','string','string','2021-05-08 11:09:47',0,0,'string',0,0,'2021-05-08 11:09:47','2021-05-08 11:09:47','string','string3'),('string6','string','string1','string1','string','string','2021-05-08 14:07:53',0,0,'string',0,0,'2021-05-08 14:07:53','2021-05-08 14:07:53','string','string1');
/*!40000 ALTER TABLE `bus_schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cancel_history`
--

DROP TABLE IF EXISTS `cancel_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cancel_history` (
  `CANCEL_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `REASON` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `NOTE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `CUS_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `EMP_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `TICKET_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`CANCEL_ID`),
  KEY `fk_cancel_history_cus_info1_idx` (`CUS_ID`),
  KEY `fk_cancel_history_emp_info1_idx` (`EMP_ID`),
  KEY `fk_cancel_history_ticket_management1_idx` (`TICKET_ID`),
  CONSTRAINT `fk_cancel_history_cus_info1` FOREIGN KEY (`CUS_ID`) REFERENCES `cus_info` (`USER_ID`),
  CONSTRAINT `fk_cancel_history_emp_info1` FOREIGN KEY (`EMP_ID`) REFERENCES `emp_info` (`USER_ID`),
  CONSTRAINT `fk_cancel_history_ticket_management1` FOREIGN KEY (`TICKET_ID`) REFERENCES `ticket_management` (`TICKET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancel_history`
--

LOCK TABLES `cancel_history` WRITE;
/*!40000 ALTER TABLE `cancel_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `cancel_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cus_info`
--

DROP TABLE IF EXISTS `cus_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cus_info` (
  `USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `FIRST_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `LAST_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `DISPLAY_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `PHONE_NUMBER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `DOB` datetime NOT NULL,
  `GENDER` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `NOTE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `USERNAME` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `fk_cus_info_account_info1_idx` (`USER_ID`),
  KEY `fk_cus_info_account_info1_idx1` (`USERNAME`),
  CONSTRAINT `fk_cus_info_account_info1` FOREIGN KEY (`USERNAME`) REFERENCES `account_info` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cus_info`
--

LOCK TABLES `cus_info` WRITE;
/*!40000 ALTER TABLE `cus_info` DISABLE KEYS */;
INSERT INTO `cus_info` VALUES ('1234','Fname','sdad','Fname sdad','0704617688','2021-05-01 07:00:00','Nam','2021-05-11 05:04:06','2021-05-11 05:04:06',NULL,'1234'),('12345','Fname','sdad','Fname sdad','0704617688','2021-04-30 07:00:00','Khác','2021-05-11 05:55:29',NULL,NULL,'12345'),('1234567','Fname','sdad','Fname sdad','0704617688','2021-05-11 07:00:00','Nam','2021-05-11 09:40:57',NULL,NULL,'1234567'),('string','string','string','string','string','2021-05-10 11:09:38','string','2021-05-10 04:09:38','2021-05-10 04:09:38','string','1'),('string1','string','string','string','string','2021-05-11 21:41:20','string','2021-05-11 14:41:20','2021-05-11 14:41:20','string','1'),('string11','string','string','string','string','2021-05-08 15:00:33','string','2021-05-08 08:00:33','2021-05-08 08:00:33','string','testy'),('string3','string','string','string','string','2021-05-08 15:46:27','string','2021-05-08 08:46:27','2021-05-08 08:46:27','string','testyyy'),('testinggg','Fname','sdad','Fname sdad','0704617688','2021-05-11 07:00:00','Nam','2021-05-11 09:28:04',NULL,NULL,'testinggg');
/*!40000 ALTER TABLE `cus_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_info`
--

DROP TABLE IF EXISTS `emp_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_info` (
  `USER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `FIRST_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `LAST_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `DISPLAY_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `PHONE_NUMBER` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `DOB` datetime NOT NULL,
  `ADDRESS` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `ID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `GENDER` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `TYPE` int NOT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `NOTE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `USERNAME` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `fk_emp_info_account_info1_idx` (`USERNAME`),
  CONSTRAINT `fk_emp_info_account_info1` FOREIGN KEY (`USERNAME`) REFERENCES `account_info` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci COMMENT='Employees information table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_info`
--

LOCK TABLES `emp_info` WRITE;
/*!40000 ALTER TABLE `emp_info` DISABLE KEYS */;
INSERT INTO `emp_info` VALUES ('1','string','string','string','string','2021-05-10 00:00:00','string','string','string',0,'2021-05-10 04:28:30','2021-05-10 04:28:30','string',''),('132','Test','Test','Test Test','0704617688','2021-05-11 00:00:00','test','11231313','Nam',0,'2021-05-11 07:03:23',NULL,NULL,'132'),('2','2','2','','2','2021-01-01 00:00:00','1','','',0,NULL,NULL,NULL,''),('3','3','3','','3','2021-01-01 00:00:00','1','','',0,NULL,NULL,NULL,''),('8','8','8','','8','2021-01-01 00:00:00','1','','',0,NULL,NULL,NULL,''),('sdasdad','Test','Test','Test Test','0704617688','2021-05-10 00:00:00','test','11231313','Nam',0,'2021-05-11 07:07:40',NULL,NULL,'sdasdad'),('string','string','string','string','string','2021-05-08 00:00:00','string','string','string',0,'2021-05-08 04:30:16','2021-05-08 04:30:16','string','1'),('string1','string','string','string','string','2021-05-08 00:00:00','string','string','string',0,'2021-05-08 08:08:39','2021-05-08 08:08:39','string','testy'),('string3','string','string','string','string','2021-05-08 00:00:00','string','string','string',0,'2021-05-08 08:08:39','2021-05-08 08:08:39','string','testyy'),('string4','string','string','string','string','2021-05-08 00:00:00','string','string','string',0,'2021-05-08 11:02:30','2021-05-08 11:02:30','string','testyyy'),('string5','string','string','string','string','2021-05-08 00:00:00','string','string','string',0,'2021-05-08 11:24:20','2021-05-08 11:24:20','string','testyyyy'),('testingg','Test','Test','Test Test','0704617688','2021-05-11 00:00:00','test','11231313','Nam',0,'2021-05-11 09:26:36',NULL,NULL,'testingg');
/*!40000 ALTER TABLE `emp_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `FEEDBACK_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `FULLNAME` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `PHONE_NUMBER` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `TYPE` varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `CONTENT` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `STATUS` int NOT NULL,
  `CREATED_ON` varchar(45) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `NOTE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `EMP_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`FEEDBACK_ID`),
  KEY `fk_feedback_emp_info1_idx` (`EMP_ID`),
  CONSTRAINT `fk_feedback_emp_info1` FOREIGN KEY (`EMP_ID`) REFERENCES `emp_info` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES ('1','string','string','string','2',0,'2021-05-11 14:07:52.625','string','1'),('fbt','Nguyen Van A','0704617688','Chất lượng dịch vụ','test',0,'2021-05-12 04:50:39.347',NULL,NULL),('ltp','Nguyen Van A','0704617688','Chất lượng dịch vụ','test',0,'2021-05-11 14:41:42.633',NULL,NULL),('string','','','','string',0,'','string','string'),('string1','','','','string',0,'','string','string'),('string12','string','string','string','string',0,'2021-05-11 14:34:48.208','string',NULL),('string231','string','string','string','string',0,'2021-05-13 04:08:58.233','string',NULL),('y8','Nguyen Van A','0704617688','Tài xế và dịch vụ','test',0,'2021-05-12 08:49:53.537',NULL,NULL);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_management`
--

DROP TABLE IF EXISTS `ticket_management`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_management` (
  `TICKET_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `SEAT_ID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `STATUS` int NOT NULL,
  `PAYMENT` int DEFAULT NULL,
  `PAYMENT_DATE` datetime DEFAULT NULL,
  `BOOKING_DATE` datetime DEFAULT NULL,
  `NOTE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `TRIP_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `CUS_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`TICKET_ID`),
  KEY `fk_ticket_management_bus_schedules1_idx` (`TRIP_ID`),
  KEY `fk_ticket_management_cus_info1_idx` (`CUS_ID`),
  CONSTRAINT `fk_ticket_management_bus_schedules1` FOREIGN KEY (`TRIP_ID`) REFERENCES `bus_schedules` (`TRIP_ID`),
  CONSTRAINT `fk_ticket_management_cus_info1` FOREIGN KEY (`CUS_ID`) REFERENCES `cus_info` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_management`
--

LOCK TABLES `ticket_management` WRITE;
/*!40000 ALTER TABLE `ticket_management` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_management` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-13 11:22:02
