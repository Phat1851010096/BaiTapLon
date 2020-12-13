CREATE DATABASE  IF NOT EXISTS `qlcafe` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `qlcafe`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: qlcafe
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
-- Table structure for table `ban`
--

DROP TABLE IF EXISTS `ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ban` (
  `MaBan` int NOT NULL AUTO_INCREMENT,
  `SucChua` int NOT NULL DEFAULT '0',
  `TinhTrang` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Trong',
  PRIMARY KEY (`MaBan`,`SucChua`),
  UNIQUE KEY `MaBan_UNIQUE` (`MaBan`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ban`
--

LOCK TABLES `ban` WRITE;
/*!40000 ALTER TABLE `ban` DISABLE KEYS */;
INSERT INTO `ban` VALUES (1,2,'Trong'),(2,2,'Trong'),(3,2,'Trong'),(4,2,'Trong'),(5,2,'Trong'),(6,2,'Trong'),(7,2,'Trong'),(8,2,'Trong'),(9,4,'Trong'),(10,4,'Day'),(11,4,'Trong'),(12,4,'Trong'),(13,8,'Day'),(14,8,'Trong'),(15,8,'Trong'),(16,12,'Day'),(17,12,'Trong'),(18,20,'Trong'),(19,20,'Trong'),(20,7,'Day'),(21,2,'Trong'),(22,11,'Trong'),(24,4,'Trong'),(25,12,'Trong'),(26,25,'Trong'),(27,4,'Trong');
/*!40000 ALTER TABLE `ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bophantructhuoc`
--

DROP TABLE IF EXISTS `bophantructhuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bophantructhuoc` (
  `MaBoPhan` int NOT NULL AUTO_INCREMENT,
  `TenBoPhan` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaBoPhan`),
  UNIQUE KEY `TenBoPhan_UNIQUE` (`TenBoPhan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bophantructhuoc`
--

LOCK TABLES `bophantructhuoc` WRITE;
/*!40000 ALTER TABLE `bophantructhuoc` DISABLE KEYS */;
INSERT INTO `bophantructhuoc` VALUES (4,'Bao ve'),(1,'Pha che'),(2,'Phuc vu'),(5,'Rua chen'),(3,'Tiep tan');
/*!40000 ALTER TABLE `bophantructhuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiethoadon` (
  `stt` int NOT NULL AUTO_INCREMENT,
  `idMonAn` int NOT NULL,
  `TenMon` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DonGia` double NOT NULL,
  `SoLuong` int NOT NULL,
  `ThanhTien` double NOT NULL,
  `idHD` char(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`stt`),
  KEY `fk_chitiethoadon_monan_idx` (`idMonAn`),
  KEY `fk_chitiethoadon_hoadon_idx` (`idHD`),
  CONSTRAINT `fk_chitiethoadon_hoadon` FOREIGN KEY (`idHD`) REFERENCES `hoadon` (`idHoaDon`),
  CONSTRAINT `fk_chitiethoadon_monan` FOREIGN KEY (`idMonAn`) REFERENCES `monan` (`IdMonAn`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES (1,15,'Hu tieu',20000,4,80000,'200612-120006-9'),(2,4,'Tra sua truyen thong',25000,2,50000,'200612-120006-9'),(3,8,'Pepsi',12000,1,12000,'200612-120006-9'),(4,11,'Sinh to nha dam',39000,1,39000,'200612-120006-9'),(5,32,'Sting dau',12000,3,36000,'200612-155853-20'),(6,8,'Pepsi',12000,2,24000,'200612-155853-20'),(7,24,'Mi xao bo',33000,1,33000,'200612-155853-20'),(8,21,'Bun dau mam tom',20000,1,20000,'200612-155853-20'),(9,16,'Hu tieu bo vien',27000,2,54000,'200612-155853-20'),(10,20,'Bun cha gio',30000,1,30000,'200612-155853-20'),(11,29,'Bun them',5000,2,10000,'200612-155853-20'),(12,3,'Cafe den da',22000,1,22000,'200612-161844-13'),(13,1,'Cafe sua',25000,2,50000,'200612-161844-13'),(14,5,'Tra sua tran chau duong den',35000,1,35000,'200612-161844-13'),(15,7,'Tra sua socola',25000,2,50000,'200612-161844-13'),(16,19,'Bun bo Hue',30000,2,60000,'200612-161844-13'),(17,22,'Com chien trung',30000,1,30000,'200612-161844-13'),(18,24,'Mi xao bo',33000,2,66000,'200612-161844-13'),(19,1,'Cafe sua',25000,1,25000,'200612-162844-16'),(20,2,'Cafe nong',20000,2,40000,'200612-162844-16'),(21,5,'Tra sua tran chau duong den',35000,1,35000,'200612-162844-16'),(22,9,'CocaCola',12000,1,12000,'200612-162844-16'),(23,13,'Tra lipton nong',20000,2,40000,'200612-162844-16'),(24,11,'Sinh to nha dam',39000,3,117000,'200612-162844-16'),(25,1,'Cafe sua',25000,2,50000,'200612-225731-10'),(26,6,'Tra sua matcha',30000,1,30000,'200612-225731-10'),(27,17,'Hu tieu chay',20000,1,20000,'200612-225731-10'),(28,29,'Bun them',5000,1,5000,'200612-225731-10'),(29,9,'CocaCola',12000,2,24000,'200612-225731-10'),(30,1,'Cafe sua',25000,2,50000,'200612-230351-22'),(31,5,'Tra sua tran chau duong den',35000,3,105000,'200612-230351-22'),(32,8,'Pepsi',12000,3,36000,'200612-230351-22'),(33,14,'Tra dao cao sa',33000,1,33000,'200612-230351-22'),(34,18,'Bun reu',20000,2,40000,'200612-230351-22'),(35,18,'Bun reu',20000,3,60000,'200612-230351-22'),(36,24,'Mi xao bo',33000,3,99000,'200612-230351-22'),(37,23,'Mi tom trung',20000,1,20000,'200612-230351-22'),(38,30,'Rau luoc',10000,2,20000,'200612-230351-22'),(39,4,'Tra sua truyen thong',25000,1,25000,'200612-230351-22'),(40,1,'Cafe sua',25000,5,125000,'200612-233905-20'),(41,17,'Hu tieu chay',20000,2,40000,'200612-233905-20'),(42,24,'Mi xao bo',33000,1,33000,'200612-233905-20'),(43,27,'Canh nam dau hu',50000,3,150000,'200612-233905-20'),(44,1,'Cafe sua',25000,3,75000,'200613-142922-13');
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhmuc`
--

DROP TABLE IF EXISTS `danhmuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhmuc` (
  `idDanhMuc` int NOT NULL AUTO_INCREMENT,
  `TenDanhMuc` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idDanhMuc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmuc`
--

LOCK TABLES `danhmuc` WRITE;
/*!40000 ALTER TABLE `danhmuc` DISABLE KEYS */;
INSERT INTO `danhmuc` VALUES (1,'Thuc an'),(2,'Thuc uong');
/*!40000 ALTER TABLE `danhmuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `idHoaDon` char(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaBan` int NOT NULL,
  `ThanhTien` double DEFAULT NULL,
  `NgayTao` date NOT NULL,
  PRIMARY KEY (`idHoaDon`),
  KEY `fk_hoadon_ban_idx` (`MaBan`),
  CONSTRAINT `fk_hoadon_ban` FOREIGN KEY (`MaBan`) REFERENCES `ban` (`MaBan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES ('200612-120006-9',9,181000,'2020-06-12'),('200612-155853-20',20,207000,'2020-06-12'),('200612-161844-13',13,313000,'2020-06-12'),('200612-162844-16',16,NULL,'2020-06-12'),('200612-225731-10',10,NULL,'2020-06-12'),('200612-230351-22',22,488000,'2020-06-12'),('200612-233905-20',20,NULL,'2020-06-12'),('200613-142922-13',13,NULL,'2020-06-13');
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monan`
--

DROP TABLE IF EXISTS `monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monan` (
  `IdMonAn` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GiaBan` double NOT NULL,
  `TinhTrang` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ThoiDiemBan` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DanhMuc` int NOT NULL,
  `ThongTinThem` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`IdMonAn`),
  KEY `Fk_monan_danhmuc_idx` (`DanhMuc`),
  CONSTRAINT `fk_monan_danhmuc` FOREIGN KEY (`DanhMuc`) REFERENCES `danhmuc` (`idDanhMuc`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan`
--

LOCK TABLES `monan` WRITE;
/*!40000 ALTER TABLE `monan` DISABLE KEYS */;
INSERT INTO `monan` VALUES (1,'Cafe sua',25000,'Con','Sang, Toi',2,'Co da'),(2,'Cafe nong',20000,'Con','Sang, Toi',2,NULL),(3,'Cafe den da',22000,'Con','Sang, Toi',2,'Co da'),(4,'Tra sua truyen thong',25000,'Con','Trua, Toi',2,'Co da'),(5,'Tra sua tran chau duong den',35000,'Con','Trua, Toi',2,'Co da'),(6,'Tra sua matcha',30000,'Con','Trua, Toi',2,'Co da'),(7,'Tra sua socola',25000,'Con','Trua, Toi',2,'Co da'),(8,'Pepsi',12000,'Con','Sang, Trua, Toi',2,'Co da'),(9,'CocaCola',12000,'Con','Sang, Trua, Toi',2,'Co da'),(10,'Sinh to dau',39000,'Con','Toi',2,NULL),(11,'Sinh to nha dam',39000,'Con','Toi',2,NULL),(12,'Sinh to thap cam',45000,'Con','Toi',2,NULL),(13,'Tra lipton nong',20000,'Con','Sang, Toi',2,NULL),(14,'Tra dao cao sa',33000,'Con','Sang, Toi',2,'Co da'),(15,'Hu tieu',20000,'Con','Sang',1,NULL),(16,'Hu tieu bo vien',27000,'Con','Sang',1,NULL),(17,'Hu tieu chay',20000,'Con','Sang',1,'Mon chay'),(18,'Bun reu',20000,'Con','Sang, Trua',1,NULL),(19,'Bun bo Hue',30000,'Con','Sang, Trua',1,NULL),(20,'Bun cha gio',30000,'Con','Sang, Trua',1,NULL),(21,'Bun dau mam tom',20000,'Con','Sang, Trua, Toi',1,NULL),(22,'Com chien trung',30000,'Con','Sang, Trua, Toi',1,NULL),(23,'Mi tom trung',20000,'Con','Sang, Trua, Toi',1,NULL),(24,'Mi xao bo',33000,'Con','Sang, Trua, Toi',1,NULL),(25,'Rau muong xao',12000,'Con','Sang, Trua',1,'Mon chay'),(26,'Dau hu chien',12000,'Con','Sang, Trua, Toi',1,'Mon chay'),(27,'Canh nam dau hu',50000,'Con','Sang',1,'Mon chay'),(28,'Com them',5000,'Con','Sang, Trua',1,'Mon chay'),(29,'Bun them',5000,'Con','Sang, Trua, Toi',1,'Mon chay'),(30,'Rau luoc',10000,'Het','Sang, Toi',1,'Mon chay'),(31,'Banh mi',20000,'Con','Sang',1,'Mon chay'),(32,'Sting dau',12000,'Con','Sang, Trua, Toi',2,'Co da'),(33,'Com suon',25000,'Con','Sang, Trua',1,'');
/*!40000 ALTER TABLE `monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNhanVien` int NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GioiTinh` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `QueQuan` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NgaySinh` date NOT NULL,
  `NgayVaoLam` date NOT NULL,
  `BoPhanTrucThuoc_id` int NOT NULL,
  PRIMARY KEY (`MaNhanVien`),
  KEY `fk_nhanvien_bophantructhuoc_idx` (`BoPhanTrucThuoc_id`),
  CONSTRAINT `fk_nhanvien_bophantructhuoc` FOREIGN KEY (`BoPhanTrucThuoc_id`) REFERENCES `bophantructhuoc` (`MaBoPhan`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Donald Trump','Nam','USA','1990-12-12','2014-12-11',4),(2,'Wibu','Nam','Japan','2000-12-12','2019-12-11',5),(3,'Cao Ba Giang','Nam','Dong Nai','1997-03-03','2019-05-04',4),(4,'Do Vo Anh Khoa','Nam','TP.HCM','1996-05-02','2018-05-06',2),(5,'Vo Dinh Huy','Nam','Dak Lak','1993-12-04','2018-06-07',5),(6,'Bui Xuan Hieu','Nu','Dong Nai','1998-09-12','2019-12-01',5),(7,'Truong Hao Quy','Nam','TP.HCM','1990-04-05','2018-07-08',1),(8,'Tran Thanh Bao Dang','Nu','Soc Trang','1999-03-12','2020-01-05',5),(9,'Dinh Ngoc An','Nam','Binh Dinh','1996-05-25','2019-01-07',3),(10,'Huy Vo','Nam','Dak Lak','1998-05-15','2017-03-04',5),(11,'Giang Cao','Nu','Dong Nai','2000-07-07','2020-02-06',3),(12,'Hieu Bui','Nam','An Giang','2001-01-01','2017-04-05',1),(13,'Hao Quy','Nam','Ha Noi','1999-05-02','2018-08-07',4),(14,'Ngoc Hieu','Nu','Bac Ninh','2000-07-06','2019-09-15',2),(15,'Tran Thanh Thao','Nu','An Giang','1990-02-07','2018-08-06',3),(16,'Nguyen Anh Vinh','Nam','Tay Ninh','1996-09-18','2018-12-11',2),(17,'Tran Van Anh','Nu','Phu Yen','1999-08-07','2018-10-11',4),(18,'Le Thi Thanh Thu','Nu','Nghe An','1997-06-05','2016-05-01',2),(19,'Tran Thanh Bao','Nam','Ha Noi','1998-08-14','2018-09-13',2),(20,'Le Thanh Hang','Nu','Quang Ngai','2000-02-23','2020-01-02',2),(21,'Tran Van Thanh','Nam','Quang Ngai','1991-04-01','2014-06-29',3),(22,'Son Tung','Nam','Khanh Hoa','1998-05-01','2018-06-23',4),(23,'Le Trung Hieu','Nam','Bac Ninh','2000-07-08','2019-08-27',3),(24,'Nguyen Nhu Yen','Nu','Soc Trang','1995-10-04','2018-06-02',2),(25,'Le Thi Thu Uyen','Nu','An Giang','1996-05-06','2020-05-23',1),(26,'Le Van Thanh','Nam','TP.HCM','1992-07-26','2017-09-10',3),(27,'Tran Duc Nhan','Nam','Ha Noi','1999-06-11','2018-05-03',2),(28,'Tran Van Tuyet','Nu','Phu Yen','1993-06-25','2015-07-17',4),(29,'Le Hong Hanh','Nu','Nghe An','1999-11-23','2018-11-25',1),(30,'Tran Le Bao','Nam','Ha Noi','1998-12-24','2018-11-25',4),(33,'Barack Obama','Nam','USA','1970-12-13','2020-06-07',2),(35,'Napoleon','Nam','France','1769-08-15','2020-06-07',1),(36,'Luu Bi','Nam','China','0123-01-15','2020-06-07',4),(37,'Quan Vu','Nam','China','0123-01-01','2020-06-07',5),(38,'Ly Tieu Long','Nam','China','1930-01-01','2020-06-07',2),(39,'Ton Ngo Khong','Nam','Dak Lak','1997-06-15','2020-06-08',5),(41,'Hoang Chau Cach Cach','Nu','China','1234-01-01','2020-06-13',1);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'qlcafe'
--

--
-- Dumping routines for database 'qlcafe'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-13 12:46:44
