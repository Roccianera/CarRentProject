-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: dbnoleggioauto
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto` (
  `id` int NOT NULL,
  `Targa` varchar(10) NOT NULL,
  `numPostiPasseggeri` int NOT NULL,
  `PriceDay` float NOT NULL,
  `TipoAlimentazione` varchar(20) NOT NULL,
  `PotenzaMotore` int NOT NULL,
  `inServizio` bit(1) NOT NULL,
  `segmento` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `targa_UNIQUE` (`Targa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,'AB 456CD',4,260,'benzina',69,_binary '',0),(2,'EW 902DZ',4,216,'benzina',82,_binary '',1),(3,'EX 180AY',4,270,'gasolio',100,_binary '',2);
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noleggiauto`
--

DROP TABLE IF EXISTS `noleggiauto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `noleggiauto` (
  `Id` int NOT NULL,
  `DataRitiroAuto` varchar(10) NOT NULL,
  `DataConsegnaAuto` varchar(10) NOT NULL,
  `PrezzoNoleggio` float NOT NULL,
  `Auto` int NOT NULL,
  `UtenteRegistrato` int NOT NULL,
  `GuidatoreSupplementare` int DEFAULT NULL,
  `ServizioAssicurativo` int DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_NoleggiAuto_Auto1_idx` (`Auto`),
  KEY `fk_NoleggiAuto_UtentiRegistrati1_idx` (`UtenteRegistrato`),
  KEY `fk_NoleggiAuto_UtentiRegistrati2_idx` (`GuidatoreSupplementare`),
  KEY `fk_NoleggiAuto_ServiziAssicurativi1_idx` (`ServizioAssicurativo`),
  CONSTRAINT `fk_NoleggiAuto_Auto1` FOREIGN KEY (`Auto`) REFERENCES `auto` (`id`),
  CONSTRAINT `fk_NoleggiAuto_ServiziAssicurativi1` FOREIGN KEY (`ServizioAssicurativo`) REFERENCES `serviziassicurativi` (`Id`),
  CONSTRAINT `fk_NoleggiAuto_UtentiRegistrati1` FOREIGN KEY (`UtenteRegistrato`) REFERENCES `utentiregistrati` (`Id`),
  CONSTRAINT `fk_NoleggiAuto_UtentiRegistrati2` FOREIGN KEY (`GuidatoreSupplementare`) REFERENCES `utentiregistrati` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noleggiauto`
--

LOCK TABLES `noleggiauto` WRITE;
/*!40000 ALTER TABLE `noleggiauto` DISABLE KEYS */;
/*!40000 ALTER TABLE `noleggiauto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `optionalauto`
--

DROP TABLE IF EXISTS `optionalauto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `optionalauto` (
  `Id` int NOT NULL,
  `descrizione` varchar(100) DEFAULT NULL,
  `prezzoPrefissato` float NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `optionalauto`
--

LOCK TABLES `optionalauto` WRITE;
/*!40000 ALTER TABLE `optionalauto` DISABLE KEYS */;
INSERT INTO `optionalauto` VALUES (1,'wifi in auto',20),(2,'cruise control adattivo',50),(3,'Fari Full LED',45),(4,'Connettività Bluetooth',20),(5,'Sistema Keyless',19.99),(6,'Sedili riscaldati',10.99);
/*!40000 ALTER TABLE `optionalauto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `optionalauto_has_noleggiauto`
--

DROP TABLE IF EXISTS `optionalauto_has_noleggiauto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `optionalauto_has_noleggiauto` (
  `OptionalAuto` int NOT NULL,
  `NoleggioAuto` int NOT NULL,
  PRIMARY KEY (`OptionalAuto`,`NoleggioAuto`),
  KEY `fk_OptionalAuto_has_NoleggiAuto_NoleggiAuto1_idx` (`NoleggioAuto`),
  KEY `fk_OptionalAuto_has_NoleggiAuto_OptionalAuto1_idx` (`OptionalAuto`),
  CONSTRAINT `fk_OptionalAuto_has_NoleggiAuto_NoleggiAuto1` FOREIGN KEY (`NoleggioAuto`) REFERENCES `noleggiauto` (`Id`),
  CONSTRAINT `fk_OptionalAuto_has_NoleggiAuto_OptionalAuto1` FOREIGN KEY (`OptionalAuto`) REFERENCES `optionalauto` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `optionalauto_has_noleggiauto`
--

LOCK TABLES `optionalauto_has_noleggiauto` WRITE;
/*!40000 ALTER TABLE `optionalauto_has_noleggiauto` DISABLE KEYS */;
/*!40000 ALTER TABLE `optionalauto_has_noleggiauto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviziassicurativi`
--

DROP TABLE IF EXISTS `serviziassicurativi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serviziassicurativi` (
  `Id` int NOT NULL,
  `descrizione` varchar(100) DEFAULT NULL,
  `prezzoPrefissato` float NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviziassicurativi`
--

LOCK TABLES `serviziassicurativi` WRITE;
/*!40000 ALTER TABLE `serviziassicurativi` DISABLE KEYS */;
INSERT INTO `serviziassicurativi` VALUES (1,'Polizza furto e incendio',140),(2,'Polizza cristalli',130),(3,'Polizza infortuni al conducente',150),(4,'Riduzione della franchigia',100),(5,'Polizza Kasko',159.99);
/*!40000 ALTER TABLE `serviziassicurativi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utentiregistrati`
--

DROP TABLE IF EXISTS `utentiregistrati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utentiregistrati` (
  `Id` int NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Cognome` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `AnnoConseguimentoPatente` int NOT NULL,
  `AnnoScadenzaPatente` int NOT NULL,
  `NumeroPatente` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `email_UNIQUE` (`Email`),
  UNIQUE KEY `NumeroPatente_UNIQUE` (`NumeroPatente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utentiregistrati`
--

LOCK TABLES `utentiregistrati` WRITE;
/*!40000 ALTER TABLE `utentiregistrati` DISABLE KEYS */;
INSERT INTO `utentiregistrati` VALUES (1,'Dominic','Toretto','fastandfurios@gmail.com',1999,2030,'U1H68I903B'),(2,'Valentino','Rossi','valerosso19@gmail.com',2000,2040,'X2Y18I802A'),(3,'Mario','Rossi','mariorossi@libero.it',1980,2025,'A5X19A213C');
/*!40000 ALTER TABLE `utentiregistrati` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-06  9:03:52
