-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: 2005_group_project_v2
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB

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
-- Current Database: `2005_group_project_v2`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `2005_group_project_v2` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `2005_group_project_v2`;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `prod_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'This is Product ID',
  `name` varchar(100) NOT NULL COMMENT 'This is Product Name',
  `quantity` int(10) NOT NULL COMMENT 'This is Product Quantity',
  `price` double(8,2) DEFAULT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Sekiro: Shadows  Die Twice',28,55.00),(2,'Zelda: Twilight Princess',28,30.00),(3,'Just Cause 4 Bundle',-5,40.00),(4,'Zelda: Breath of the Wild',50,45.70),(5,'Muramasa: The Demon Blade',4,12.00),(6,'Okami HD',9,25.80),(7,'Super Mario Galaxy Bundle',4,60.00),(8,'Super Smash Brothers Ultimate',44,57.00),(9,'Persona 5: The Royal',44,55.00),(10,'Skullgirls 2nd Encore',10,32.00),(11,'Pokemon Sword and Shield Bundle',3,75.95);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_details`
--

DROP TABLE IF EXISTS `sales_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_details` (
  `invoice` int(10) NOT NULL COMMENT 'This is the invoice number',
  `P_ID` int(10) unsigned NOT NULL COMMENT 'This is the product id',
  `quantity_sold` int(10) unsigned NOT NULL COMMENT 'This is the number of the given product sold',
  `sub_total` decimal(8,2) unsigned NOT NULL COMMENT 'This is the amount paid for an item given its quantity',
  PRIMARY KEY (`invoice`,`P_ID`),
  KEY `P_ID` (`P_ID`),
  CONSTRAINT `sales_details_ibfk_1` FOREIGN KEY (`P_ID`) REFERENCES `products` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sales_details_ibfk_2` FOREIGN KEY (`invoice`) REFERENCES `sales_summary` (`invoice`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_details`
--

LOCK TABLES `sales_details` WRITE;
/*!40000 ALTER TABLE `sales_details` DISABLE KEYS */;
INSERT INTO `sales_details` VALUES (1,1,2,110.00),(1,2,2,60.00),(2,6,1,26.00);
/*!40000 ALTER TABLE `sales_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER transaction BEFORE  INSERT ON sales_details FOR EACH ROW
     BEGIN


     if exists (select invoice from sales_summary where invoice=new.invoice) THEN
     UPDATE sales_summary SET total_revenue=total_revenue+new.sub_total;
        UPDATE sales_summary SET items_sold=items_sold+new.quantity_sold;

     ELSE
     insert into sales_summary (invoice, items_sold, total_revenue, DOS) values (new.invoice,new.quantity_sold, new.sub_total,CURDATE());

     END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `sales_summary`
--

DROP TABLE IF EXISTS `sales_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_summary` (
  `invoice` int(10) NOT NULL AUTO_INCREMENT,
  `items_sold` int(10) NOT NULL,
  `total_revenue` decimal(8,2) NOT NULL,
  `DOS` date DEFAULT NULL,
  PRIMARY KEY (`invoice`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_summary`
--

LOCK TABLES `sales_summary` WRITE;
/*!40000 ALTER TABLE `sales_summary` DISABLE KEYS */;
INSERT INTO `sales_summary` VALUES (1,4,170.00,'2020-05-29'),(2,1,26.00,'2020-05-29');
/*!40000 ALTER TABLE `sales_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `user_password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` char(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` char(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Smith1','pass1',NULL,NULL),(3,'Smith2','pass1',NULL,NULL),(4,'Jones1','pass',NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-29 18:08:54
