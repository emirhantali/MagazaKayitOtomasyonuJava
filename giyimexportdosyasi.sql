CREATE DATABASE  IF NOT EXISTS `magaza` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `magaza`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: magaza
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `siparisler`
--

DROP TABLE IF EXISTS `siparisler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `siparisler` (
  `StokNo` int NOT NULL,
  `ÜrünAdi` varchar(100) NOT NULL,
  `Beden` varchar(100) NOT NULL,
  `Renk` varchar(100) NOT NULL,
  `Cinsiyet` varchar(100) NOT NULL,
  `SiparisAdedi` varchar(100) NOT NULL,
  KEY `StokNo_fk` (`StokNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siparisler`
--

LOCK TABLES `siparisler` WRITE;
/*!40000 ALTER TABLE `siparisler` DISABLE KEYS */;
INSERT INTO `siparisler` VALUES (1,'MONT','S','SARI','ERKEK','1111'),(1,'MONT','S','SARI','ERKEK','5'),(1,'MONT','S','SARI','ERKEK','100'),(3,'GÖMLEK','L','TURUNCU','KADIN','10'),(5,'KABAN','XL','ALTIN','UNİSEX','10000'),(7,'CEKET','M','KOBALT MAVİSİ','UNİSEX','10'),(1,'YELEK','S','SARI','ERKEK','10'),(8,'CROP','XS','KAHVERENGİ','UNİSEX','10'),(9,'TAYT','S','SİYAH','KADIN','100'),(10,'SWEATSHIRT','L','YEŞİL','UNİSEX','40'),(11,'TAYT','M','KAHVERENGİ','KADIN','500'),(10,'SWEATSHIRT','L','YEŞİL','UNİSEX','4000'),(9,'TAYT','S','SİYAH','KADIN','200'),(12,'TAYT','XS','KIRMIZI','ERKEK','10'),(12,'TAYT','XS','KIRMIZI','ERKEK','10'),(12,'TAYT','XS','KIRMIZI','ERKEK','20'),(14,'PANTOLON','L','KOBALT MAVİSİ','KADIN','30'),(9,'TAYT','S','SİYAH','KADIN','5'),(9,'TAYT','S','SİYAH','KADIN','5'),(9,'TAYT','S','SİYAH','KADIN','5'),(9,'TAYT','S','SİYAH','KADIN','5'),(9,'TAYT','S','SİYAH','KADIN','5'),(9,'TAYT','S','SİYAH','KADIN','5'),(9,'TAYT','S','SİYAH','KADIN','5'),(9,'TAYT','S','SİYAH','KADIN','5'),(15,'HIRKA','XL','ALTIN','KADIN','20'),(10,'SWEATSHIRT','L','YEŞİL','UNİSEX','6'),(3,'GÖMLEK','L','TURUNCU','KADIN','10'),(3,'GÖMLEK','L','TURUNCU','KADIN','10'),(15,'HIRKA','XL','ALTIN','KADIN','10'),(3,'GÖMLEK','L','TURUNCU','KADIN','10'),(15,'HIRKA','XL','ALTIN','KADIN','10'),(15,'HIRKA','XL','ALTIN','KADIN','10'),(16,'T-SHIRT','M','KOBALT MAVİSİ','KADIN','50'),(3,'GÖMLEK','L','TURUNCU','KADIN','10'),(11,'TAYT','M','KAHVERENGİ','KADIN','10'),(3,'GÖMLEK','L','TURUNCU','KADIN','10'),(11,'TAYT','M','KAHVERENGİ','KADIN','10');
/*!40000 ALTER TABLE `siparisler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yöneticiler`
--

DROP TABLE IF EXISTS `yöneticiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `yöneticiler` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `KullaniciAdi` varchar(50) NOT NULL,
  `Şifre` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yöneticiler`
--

LOCK TABLES `yöneticiler` WRITE;
/*!40000 ALTER TABLE `yöneticiler` DISABLE KEYS */;
INSERT INTO `yöneticiler` VALUES (1,'emirhantali','1234'),(2,'yagizbektas','1234'),(3,'cebrailergin','1234');
/*!40000 ALTER TABLE `yöneticiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ürünler`
--

DROP TABLE IF EXISTS `ürünler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ürünler` (
  `StokNo` int NOT NULL AUTO_INCREMENT,
  `ÜrünAdi` varchar(50) NOT NULL,
  `Beden` varchar(50) NOT NULL,
  `Renk` varchar(50) NOT NULL,
  `Cinsiyet` varchar(50) NOT NULL,
  `StokAdedi` int NOT NULL,
  PRIMARY KEY (`StokNo`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ürünler`
--

LOCK TABLES `ürünler` WRITE;
/*!40000 ALTER TABLE `ürünler` DISABLE KEYS */;
INSERT INTO `ürünler` VALUES (3,'GÖMLEK','L','TURUNCU','KADIN',395),(4,'TAYT','M','SARI','KADIN',455),(8,'CROP','XS','KAHVERENGİ','UNİSEX',500),(9,'TAYT','S','SİYAH','KADIN',9660),(10,'SWEATSHIRT','L','YEŞİL','UNİSEX',980),(11,'TAYT','M','KAHVERENGİ','KADIN',480),(12,'TAYT','XS','KIRMIZI','ERKEK',760),(14,'PANTOLON','L','KOBALT MAVİSİ','ERKEK',5000),(15,'HIRKA','XL','ALTIN','KADIN',100);
/*!40000 ALTER TABLE `ürünler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-28 22:53:03
