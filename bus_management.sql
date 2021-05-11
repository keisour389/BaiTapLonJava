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
INSERT INTO `account_info` VALUES ('1','1',1,1,NULL,NULL,NULL),('2','2',2,2,NULL,NULL,NULL),('5','5',5,5,NULL,NULL,NULL),('6','6',6,6,NULL,NULL,NULL),('7','7',7,7,NULL,NULL,NULL),('8','8',8,8,NULL,NULL,NULL),('string','473287f8298dba7163a897908958f7c0eae733e25d2e027992ea2edc9bed2fa8',0,0,'2021-05-07 10:23:06','2021-05-07 10:23:06','string'),('string1','473287f8298dba7163a897908958f7c0eae733e25d2e027992ea2edc9bed2fa8',0,0,'2021-05-07 10:23:06','2021-05-07 10:23:06','string'),('string5','2cae428fbbaa3e5f551f7d60ca74722d811f63399457f600b8516cfa2e18469c',0,0,'2021-05-07 17:21:42','2021-05-07 17:21:42','string'),('testy','testy',0,0,'2021-03-30 16:30:54','2021-03-30 16:30:54',NULL),('testyy','$2a$10$.ncUyYh5LYyZGzjUWm/Zw.1fCOm5ZzohteiKJIRdFxM3kl1yWmcyK',0,0,'2021-03-30 16:34:21','2021-03-30 16:34:21',NULL),('testyyy','$2a$10$IUoXhS9GURK5/8hiDgOvQOLAI7sLALB7EBMA4A//65AOQyKF5K6uK',0,0,'2021-03-30 17:06:23','2021-03-30 17:06:23',NULL),('testyyyy','$2a$10$iffqlM1zLuEuDwiIymVCeekNaxT5aLHZ21KbNZzncWsTzCH/GuK36',0,0,'2021-03-30 17:19:32','2021-03-30 17:19:32',NULL),('testyyyyy','$2a$10$6xDtT2As/b0sB6iootXyUu6knitTAP/oj.AlUyG3XBx9wszJy47W6',0,0,'2021-03-30 17:20:24','2021-03-30 17:20:24',NULL),('tri','$2a$10$f5SyeD691ZlPcAheTseitOvRHdaRbORJByPEALuKoSyvJFKkxdOd2',0,0,'2021-04-16 17:48:25','2021-04-16 17:48:25',NULL),('tri2','61b747cc5c4c81ae214a01f1834562b1ae73f5d305ca927d076b26efb19f92ab',0,0,'2021-05-09 16:55:14','2021-05-09 16:55:14','string');
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
INSERT INTO `bus_schedules` VALUES ('trip1','string5','tri2','tri2','string5','string6','2021-05-09 19:31:17',10,0,'2',40,0,'2021-05-09 19:31:17','2021-05-09 19:31:17','string','tri2'),('trip2','test','tri2','tri2','string','string','2021-05-10 10:18:13',0,0,'5',0,0,'2021-05-10 10:18:13','2021-05-10 10:18:13','string','tri2');
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
INSERT INTO `cus_info` VALUES ('1','1','1','1','1','2021-01-01 00:00:00','Nam','2021-01-01 00:00:00','2021-01-01 00:00:00','1','string');
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
INSERT INTO `emp_info` VALUES ('1','1','1','','1','2021-01-01 00:00:00','1','','',0,NULL,NULL,NULL,''),('2','2','2','','2','2021-01-01 00:00:00','1','','',0,NULL,NULL,NULL,''),('3','3','3','','3','2021-01-01 00:00:00','1','','',0,NULL,NULL,NULL,''),('8','8','8','','8','2021-01-01 00:00:00','1','','',0,NULL,NULL,NULL,''),('tri2','string','string','string','string','2021-05-10 00:00:00','string','string','string',0,'2021-05-10 09:19:55','2021-05-10 09:19:55','string','tri2');
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
  `CONTENT` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `STATUS` int NOT NULL,
  `NOTE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `CUS_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `EMP_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`FEEDBACK_ID`),
  KEY `fk_feedback_cus_info1_idx` (`CUS_ID`),
  KEY `fk_feedback_emp_info1_idx` (`EMP_ID`),
  CONSTRAINT `fk_feedback_cus_info1` FOREIGN KEY (`CUS_ID`) REFERENCES `cus_info` (`USER_ID`),
  CONSTRAINT `fk_feedback_emp_info1` FOREIGN KEY (`EMP_ID`) REFERENCES `emp_info` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
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
  `CUS_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
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

-- Dump completed on 2021-05-11 22:35:40
