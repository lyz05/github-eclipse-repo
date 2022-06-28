use mysql;
CREATE DATABASE BookDB;
use BookDB;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: BookDB
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
-- Table structure for table `AdminUsers`
--

DROP TABLE IF EXISTS `AdminUsers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AdminUsers` (
  `username` char(8) NOT NULL,
  `password` char(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AdminUsers`
--

LOCK TABLES `AdminUsers` WRITE;
/*!40000 ALTER TABLE `AdminUsers` DISABLE KEYS */;
INSERT INTO `AdminUsers` (`username`, `password`) VALUES ('admin','');
/*!40000 ALTER TABLE `AdminUsers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Book`
--

DROP TABLE IF EXISTS `Book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Book` (
  `bookNO` char(10) NOT NULL,
  `bookName` char(40) NOT NULL,
  `authorName` char(20) NOT NULL,
  `publishingName` char(30) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `publishingDate` date NOT NULL,
  `shopNum` int(11) NOT NULL,
  PRIMARY KEY (`bookNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Book`
--

LOCK TABLES `Book` WRITE;
/*!40000 ALTER TABLE `Book` DISABLE KEYS */;
INSERT INTO `Book` (`bookNO`, `bookName`, `authorName`, `publishingName`, `price`, `publishingDate`, `shopNum`) VALUES ('B200101001','政治经济学','宋涛','中国人民大学出版社',31.80,'1991-01-01',5),('B200101002','微观经济学','张蕊','高等教育出版社',41.80,'1991-01-02',2),('B200101003','宏观经济学','袁明圣','中国财经经济出版社',51.80,'1991-01-03',2),('B200201001','大学英语','郑树棠','外语教学与研究出版社',35.20,'1992-01-01',3),('B200201002','商务英语','马升烨','上海外语学院出版社',45.20,'1992-01-02',5),('B200201003','商务英语2','江宇佳','西安交通大学出版社',55.20,'1992-01-03',3),('B200301001','数据库系统原理','吴京慧','清华大学出版社',58.20,'1993-01-01',3),('B200301002','组网技术','万征','浙江大学出版社',38.20,'1993-01-02',1),('B200301003','人工智能','费翔林','电子工业出版社',43.20,'1993-01-03',5),('B200301004','算法设计与分析','陈慧南','科学出版社',58.20,'1993-01-04',10);
/*!40000 ALTER TABLE `Book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Borrow`
--

DROP TABLE IF EXISTS `Borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Borrow` (
  `readerNO` char(8) DEFAULT NULL,
  `bookNO` char(10) DEFAULT NULL,
  `borrowDate` date NOT NULL,
  `shouldDate` date NOT NULL,
  `returnDate` date DEFAULT NULL,
  KEY `bookNO` (`bookNO`),
  KEY `readerNO` (`readerNO`),
  CONSTRAINT `Borrow_ibfk_1` FOREIGN KEY (`bookNO`) REFERENCES `Book` (`bookNO`),
  CONSTRAINT `Borrow_ibfk_2` FOREIGN KEY (`readerNO`) REFERENCES `Reader` (`readerNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Borrow`
--

LOCK TABLES `Borrow` WRITE;
/*!40000 ALTER TABLE `Borrow` DISABLE KEYS */;
INSERT INTO `Borrow` (`readerNO`, `bookNO`, `borrowDate`, `shouldDate`, `returnDate`) VALUES ('R2005001','B200101001','2011-09-01','2011-10-01',NULL),('R2006001','B200101001','2011-09-07','2011-10-07','2011-10-05'),('R2007001','B200201001','2011-09-13','2011-10-13','2011-10-10'),('R2008001','B200301001','2011-09-15','2011-10-15','2011-10-13'),('R2009001','B200301001','2011-09-18','2011-10-18',NULL),('R2005001','B200101002','2011-09-02','2011-10-02',NULL),('R2005001','B200101003','2011-09-03','2011-10-03',NULL),('R2005002','B200101001','2011-09-04','2011-10-04','2011-10-03'),('R2005002','B200101002','2011-09-05','2011-10-05',NULL),('R2005002','B200101003','2011-09-06','2011-10-06','2011-10-08'),('R2006001','B200101002','2011-09-08','2011-10-08','2011-10-06'),('R2006001','B200101003','2011-09-09','2011-10-09',NULL),('R2009002','B200201001','2011-09-10','2011-10-10','2011-10-08'),('R2006002','B200201002','2011-09-11','2011-10-11','2011-10-08'),('R2006002','B200201003','2011-09-12','2011-10-12','2011-10-08'),('R2007001','B200201002','2011-09-14','2011-10-14',NULL),('R2007001','B200201003','2011-09-15','2011-10-15','2011-10-10'),('R2009002','B200201001','2011-09-16','2011-10-16','2011-10-14'),('R2007002','B200201002','2011-09-17','2011-10-17','2011-10-14'),('R2007002','B200201003','2011-09-17','2011-10-17','2011-10-14'),('R2005002','B200101001','2020-03-10','2020-04-10',NULL);
/*!40000 ALTER TABLE `Borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reader`
--

DROP TABLE IF EXISTS `Reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Reader` (
  `readerNO` char(8) NOT NULL,
  `readerName` char(8) NOT NULL,
  `sex` char(2) NOT NULL,
  `identitycard` char(18) NOT NULL,
  `workUnit` char(50) NOT NULL,
  `password` char(255) NOT NULL,
  PRIMARY KEY (`readerNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reader`
--

LOCK TABLES `Reader` WRITE;
/*!40000 ALTER TABLE `Reader` DISABLE KEYS */;
INSERT INTO `Reader` (`readerNO`, `readerName`, `sex`, `identitycard`, `workUnit`, `password`) VALUES ('R2005001','张小娟','女','412723199001014321','统一股份有限公司',''),('R2005002','张露','女','412723199002014321','兴隆股份有限公司',''),('R2006001','刘凤','女','412723199003014321','联合股份有限公司',''),('R2006002','喻自强','男','412723199004014321','万事达股份有限公司',''),('R2007001','高代鹏','男','412723199005014321','洪都股份有限公司',''),('R2007002','张晓梅','女','412723199112014321','世界技术开发公司',''),('R2008001','陈辉','男','412723199111014321','南昌市电脑研制公司',''),('R2008002','张良','男','412723199110014321','上海生物研究室',''),('R2009001','李虹冰','女','412723199208014321','富士康科技集团',''),('R2009002','韩福平','男','412723199209014321','合生元有限公司','');
/*!40000 ALTER TABLE `Reader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `View_Book`
--

DROP TABLE IF EXISTS `View_Book`;
/*!50001 DROP VIEW IF EXISTS `View_Book`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `View_Book` AS SELECT 
 1 AS `图书编号`,
 1 AS `图书名称`,
 1 AS `作者`,
 1 AS `出版社`,
 1 AS `出版日期`,
 1 AS `入库数量`,
 1 AS `在库数量`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `View_Book_Admin`
--

DROP TABLE IF EXISTS `View_Book_Admin`;
/*!50001 DROP VIEW IF EXISTS `View_Book_Admin`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `View_Book_Admin` AS SELECT 
 1 AS `图书编号`,
 1 AS `图书名称`,
 1 AS `作者`,
 1 AS `出版社`,
 1 AS `价格`,
 1 AS `出版日期`,
 1 AS `入库数量`,
 1 AS `在库数量`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `View_Borrow`
--

DROP TABLE IF EXISTS `View_Borrow`;
/*!50001 DROP VIEW IF EXISTS `View_Borrow`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `View_Borrow` AS SELECT 
 1 AS `读者编号`,
 1 AS `姓名`,
 1 AS `图书编号`,
 1 AS `图书名称`,
 1 AS `作者`,
 1 AS `出版社`,
 1 AS `借书时间`,
 1 AS `应归还日期`,
 1 AS `归还日期`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `View_Borrow_Not_Return`
--

DROP TABLE IF EXISTS `View_Borrow_Not_Return`;
/*!50001 DROP VIEW IF EXISTS `View_Borrow_Not_Return`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `View_Borrow_Not_Return` AS SELECT 
 1 AS `readerNO`,
 1 AS `bookNO`,
 1 AS `borrowDate`,
 1 AS `shouldDate`,
 1 AS `returnDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `View_Reader`
--

DROP TABLE IF EXISTS `View_Reader`;
/*!50001 DROP VIEW IF EXISTS `View_Reader`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `View_Reader` AS SELECT 
 1 AS `读者编号`,
 1 AS `姓名`,
 1 AS `性别`,
 1 AS `身份证号`,
 1 AS `工作单位`,
 1 AS `总借书数量`,
 1 AS `未归还数量`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `View_Book`
--

/*!50001 DROP VIEW IF EXISTS `View_Book`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `View_Book` AS select `Book`.`bookNO` AS `图书编号`,`Book`.`bookName` AS `图书名称`,`Book`.`authorName` AS `作者`,`Book`.`publishingName` AS `出版社`,`Book`.`publishingDate` AS `出版日期`,`Book`.`shopNum` AS `入库数量`,(`Book`.`shopNum` - count(`View_Borrow_Not_Return`.`bookNO`)) AS `在库数量` from ((`Book` left join `View_Borrow_Not_Return` on((`View_Borrow_Not_Return`.`bookNO` = `Book`.`bookNO`))) left join `Reader` on((`View_Borrow_Not_Return`.`readerNO` = `Reader`.`readerNO`))) group by `Book`.`bookNO`,`Book`.`bookName`,`Book`.`authorName`,`Book`.`publishingName`,`Book`.`publishingDate`,`Book`.`shopNum` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `View_Book_Admin`
--

/*!50001 DROP VIEW IF EXISTS `View_Book_Admin`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `View_Book_Admin` AS select `Book`.`bookNO` AS `图书编号`,`Book`.`bookName` AS `图书名称`,`Book`.`authorName` AS `作者`,`Book`.`publishingName` AS `出版社`,`Book`.`price` AS `价格`,`Book`.`publishingDate` AS `出版日期`,`Book`.`shopNum` AS `入库数量`,(`Book`.`shopNum` - count(`View_Borrow_Not_Return`.`bookNO`)) AS `在库数量` from ((`Book` left join `View_Borrow_Not_Return` on((`View_Borrow_Not_Return`.`bookNO` = `Book`.`bookNO`))) left join `Reader` on((`View_Borrow_Not_Return`.`readerNO` = `Reader`.`readerNO`))) group by `Book`.`bookNO`,`Book`.`bookName`,`Book`.`authorName`,`Book`.`publishingName`,`Book`.`publishingDate`,`Book`.`shopNum`,`Book`.`price` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `View_Borrow`
--

/*!50001 DROP VIEW IF EXISTS `View_Borrow`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `View_Borrow` AS select `Borrow`.`readerNO` AS `读者编号`,`Reader`.`readerName` AS `姓名`,`Borrow`.`bookNO` AS `图书编号`,`Book`.`bookName` AS `图书名称`,`Book`.`authorName` AS `作者`,`Book`.`publishingName` AS `出版社`,`Borrow`.`borrowDate` AS `借书时间`,`Borrow`.`shouldDate` AS `应归还日期`,`Borrow`.`returnDate` AS `归还日期` from ((`Borrow` join `Book`) join `Reader`) where ((`Borrow`.`bookNO` = `Book`.`bookNO`) and (`Borrow`.`readerNO` = `Reader`.`readerNO`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `View_Borrow_Not_Return`
--

/*!50001 DROP VIEW IF EXISTS `View_Borrow_Not_Return`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `View_Borrow_Not_Return` AS select `Borrow`.`readerNO` AS `readerNO`,`Borrow`.`bookNO` AS `bookNO`,`Borrow`.`borrowDate` AS `borrowDate`,`Borrow`.`shouldDate` AS `shouldDate`,`Borrow`.`returnDate` AS `returnDate` from `Borrow` where isnull(`Borrow`.`returnDate`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `View_Reader`
--

/*!50001 DROP VIEW IF EXISTS `View_Reader`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `View_Reader` AS select `Reader`.`readerNO` AS `读者编号`,`Reader`.`readerName` AS `姓名`,`Reader`.`sex` AS `性别`,`Reader`.`identitycard` AS `身份证号`,`Reader`.`workUnit` AS `工作单位`,count(`Borrow`.`readerNO`) AS `总借书数量`,(count(`Borrow`.`readerNO`) - count(`Borrow`.`returnDate`)) AS `未归还数量` from ((`Reader` left join `Borrow` on((`Borrow`.`readerNO` = `Reader`.`readerNO`))) left join `Book` on((`Borrow`.`bookNO` = `Book`.`bookNO`))) group by `Reader`.`readerNO`,`Borrow`.`readerNO`,`Reader`.`readerName`,`Reader`.`sex`,`Reader`.`identitycard`,`Reader`.`workUnit` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-28 16:35:49
