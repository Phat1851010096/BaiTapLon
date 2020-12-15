CREATE DATABASE  IF NOT EXISTS `qlthuvien` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `qlthuvien`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: qlthuvien
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authors` (
  `AuthorID` int NOT NULL AUTO_INCREMENT,
  `AuthorName` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`AuthorID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Hồ Chí Minh'),(2,'Chế Lan Viên'),(3,'Huy Cận'),(4,'Phùng Quán'),(5,'Xuân Quỳnh'),(6,'Tố Hữu'),(7,'Tô Hoài'),(8,'Bà Huyện Thanh Quan'),(9,'Dương Hữu Thành'),(10,'Võ Thị Hồng Tuyết'),(11,'Quốc Khánh'),(12,'Hạo Nhiên'),(13,'Đoàn Giỏi');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `BookID` int NOT NULL AUTO_INCREMENT,
  `BookName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Category` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Description` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `PublishYear` date DEFAULT NULL,
  `PublishCompany` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `EntryDate` date DEFAULT NULL,
  `BookPosition` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`BookID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (9,'Nhà giả kim','Văn học',NULL,NULL,NULL,NULL,NULL),(10,'Lập trình Java','Kỹ thuật','Đọc xong cuốn sách này sẽ qua môn','2019-09-09','NXB Thông Tin Và Truyền Thông','2019-10-10','130'),(11,'Dế mèn phiêu lưu kí','Thiếu nhi','Quyển sách nói về 1 con dế','1941-05-21','NXB Báo Tân Dân','2016-07-21','140'),(12,'Tuổi thơ dữ dội','Tiểu thuyết','Tuổi thơ dữ dội là một tác phẩm truyện dài tám phần của nhà văn Phùng Quán.','1988-07-30','NXB Văn học','2016-05-07','140'),(13,'Đất rừng phương nam','Tiểu thuyết','Đây là 1 quyển sách','2015-04-15','NXB Văn học','2016-05-07','140'),(14,'Đất rừng phương nam 2','Tiểu thuyết','Đây là 1 quyển sách','2016-02-15','NXB Văn học','2016-05-07','140'),(15,'Think and grow rich','Kinh tế','Đây là một cuốn sách kinh tế giá 110k',NULL,NULL,NULL,NULL),(16,'Think and grow rich','Kinh tế','Đây là một cuốn sách kinh tế giá 110k','1976-03-14','Nhà xuất bản Lao Động','2018-06-05','123'),(17,'Think and grow rich 2','Kinh tế','Đây là một cuốn sách kinh tế giá 110k','1976-03-14','Nhà xuất bản Lao Động','2018-06-05','123'),(18,'Kiếm Sĩ Bắt Ruồi','Kinh tế','Kiếm Sĩ Bắt Ruồi là quyển sách chứa đựng suy nghĩ riêng về các sự việc xảy ra trong cuộc sống','2017-01-10','NXB Kinh Tế TPHCM','2018-12-11','130');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_authors`
--

DROP TABLE IF EXISTS `books_authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books_authors` (
  `AuthorID` int NOT NULL,
  `BookID` int NOT NULL,
  `AuthorName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BookName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`AuthorID`,`BookID`),
  KEY `fk_authors_books_idx` (`AuthorID`),
  KEY `fk_books_authors_idx` (`BookID`),
  CONSTRAINT `fk_authors_books` FOREIGN KEY (`AuthorID`) REFERENCES `authors` (`AuthorID`),
  CONSTRAINT `fk_books_authors` FOREIGN KEY (`BookID`) REFERENCES `books` (`BookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_authors`
--

LOCK TABLES `books_authors` WRITE;
/*!40000 ALTER TABLE `books_authors` DISABLE KEYS */;
INSERT INTO `books_authors` VALUES (4,12,'Phùng Quán','Tuổi thơ dữ dội'),(7,11,'Tô Hoài','Dế mèn phiêu lưu kí'),(9,10,'Dương Hữu Thành','Lập Trình Java'),(11,18,'Quốc Khánh','Kiếm Sĩ Bắt Ruồi'),(12,18,'Hạo Nhiên','Kiếm Sĩ Bắt Ruồi'),(13,13,'Đoàn Giỏi','Đất rừng phương nam');
/*!40000 ALTER TABLE `books_authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `CategoryID` int NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`CategoryID`),
  UNIQUE KEY `CategoryName_UNIQUE` (`CategoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readers`
--

DROP TABLE IF EXISTS `readers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `readers` (
  `Username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Sex` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `ExpirationDate` date NOT NULL,
  `Email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Address` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Faculty` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Object` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Username`),
  CONSTRAINT `fk_reader_account` FOREIGN KEY (`Username`) REFERENCES `user_account` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `readers`
--

LOCK TABLES `readers` WRITE;
/*!40000 ALTER TABLE `readers` DISABLE KEYS */;
INSERT INTO `readers` VALUES ('dang','Trần Thanh Bảo Đăng','Nam','2000-05-25','2022-10-01','dang@email.com','371 Nguyễn Kiệm Gò Vấp','012345678','Công nghệ thông tin','Sinh viên'),('dung','Mạnh Thế Dũng',NULL,NULL,'2020-12-01','','123 Nguyễn Kiệm HCM',NULL,'Luật',NULL),('phat','Nguyễn Tấn Phát','Nam',NULL,'2022-12-28','phat@yaho.com',NULL,'123123123','Tài chính ngân hàngg',NULL),('thanh','Dương Hữu Thành','Nam',NULL,'2025-12-03','thanh.dh@ou.edu.vn',NULL,NULL,'Công nghệ thông tin','Giảng viên'),('tu','Huỳnh Tấn Tú',NULL,NULL,'2019-05-06',NULL,NULL,NULL,'Kế toán kiểm toán','Sinh viên');
/*!40000 ALTER TABLE `readers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readers_books`
--

DROP TABLE IF EXISTS `readers_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `readers_books` (
  `Username` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ReaderID` int NOT NULL,
  `BookID` int NOT NULL,
  `BookName` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Status` int NOT NULL DEFAULT '0',
  `dateStart` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `dateEnd` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  ` fine` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`Username`),
  KEY `fk_RB_books_idx` (`BookID`),
  CONSTRAINT `fk_RB_account` FOREIGN KEY (`Username`) REFERENCES `user_account` (`Username`),
  CONSTRAINT `fk_RB_books` FOREIGN KEY (`BookID`) REFERENCES `books` (`BookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `readers_books`
--

LOCK TABLES `readers_books` WRITE;
/*!40000 ALTER TABLE `readers_books` DISABLE KEYS */;
/*!40000 ALTER TABLE `readers_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp`
--

DROP TABLE IF EXISTS `temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temp` (
  `BookID` int NOT NULL AUTO_INCREMENT,
  `BookName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Category` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `PublishYear` date DEFAULT NULL,
  PRIMARY KEY (`BookID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp`
--

LOCK TABLES `temp` WRITE;
/*!40000 ALTER TABLE `temp` DISABLE KEYS */;
/*!40000 ALTER TABLE `temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_account` (
  `Username` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES ('dang','123'),('dung','123'),('phat','123'),('qwe','123'),('thanh','123'),('tu','123');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'qlthuvien'
--

--
-- Dumping routines for database 'qlthuvien'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-13 14:00:47
