
-- Table structure for table `juegos`


DROP TABLE IF EXISTS `juegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juegos` (
  `id_juego` int NOT NULL,
  `rank` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `platform` varchar(45) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `na_sales` double DEFAULT NULL,
  `eu_sales` double DEFAULT NULL,
  `jp_sales` double DEFAULT NULL,
  `other_sales` double DEFAULT NULL,
  `global_sales` double DEFAULT NULL,
  PRIMARY KEY (`id_juego`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `juegos`
--
