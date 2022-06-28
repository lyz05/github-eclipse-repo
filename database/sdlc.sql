use mysql;
CREATE DATABASE sdlc;
use sdlc;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sdlc
-- ------------------------------------------------------
-- Server version	5.5.60

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
-- Table structure for table `poem`
--

DROP TABLE IF EXISTS `poem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poem` (
  `id` int(11) NOT NULL,
  `content` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poem`
--

LOCK TABLES `poem` WRITE;
/*!40000 ALTER TABLE `poem` DISABLE KEYS */;
INSERT INTO `poem` (`id`, `content`) VALUES (1,'《南陵别儿童入京》<br /> <span style=\"font-size: 18px; color: grey\">[唐] 李白 </span><br /> <br /> 白酒新熟山中归，黄鸡啄黍秋正肥。<br /> 呼童烹鸡酌白酒，儿女嬉笑牵人衣。<br /> 高歌取醉欲自慰，起舞落日争光辉。<br /> 游说万乘苦不早，著鞭跨马涉远道。<br /> 会稽愚妇轻买臣，余亦辞家西入秦。<br /> 仰天大笑出门去，我辈岂是蓬蒿人。'),(2,'《诗词版\"流浪地球\"》<br /> <span style=\"font-size: 18px; color: grey\">-郭鹏 </span><br /> <br /> 西风吹皱东方河，万年地球白发多。 <br /> 流浪星际家何去，满船清梦出银河。');
/*!40000 ALTER TABLE `poem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-28 16:39:01
