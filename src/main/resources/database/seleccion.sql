CREATE DATABASE  IF NOT EXISTS `seleccion` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `seleccion`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: seleccion
-- ------------------------------------------------------
-- Server version	5.1.67-community

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
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota` (
  `idpostulante` bigint(20) NOT NULL,
  `idprueba` bigint(20) NOT NULL,
  `nota` decimal(10,0) DEFAULT NULL,
  KEY `FK_postulante_idx` (`idpostulante`),
  KEY `FK_prueba_idx` (`idprueba`),
  CONSTRAINT `FK_prueba_nota` FOREIGN KEY (`idprueba`) REFERENCES `prueba` (`idprueba`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_postulante_nota` FOREIGN KEY (`idpostulante`) REFERENCES `postulante` (`idpostulante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peso`
--

DROP TABLE IF EXISTS `peso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peso` (
  `idpuesto` bigint(20) NOT NULL,
  `idprueba` bigint(20) NOT NULL,
  `peso` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idpuesto`,`idprueba`),
  KEY `FK_puesto_idx` (`idpuesto`),
  KEY `FK_prueba_idx` (`idprueba`),
  CONSTRAINT `FK_puesto_peso` FOREIGN KEY (`idpuesto`) REFERENCES `puesto` (`idpuesto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_prueba_peso` FOREIGN KEY (`idprueba`) REFERENCES `prueba` (`idprueba`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peso`
--

LOCK TABLES `peso` WRITE;
/*!40000 ALTER TABLE `peso` DISABLE KEYS */;
/*!40000 ALTER TABLE `peso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postulante`
--

DROP TABLE IF EXISTS `postulante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postulante` (
  `idpostulante` bigint(20) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idpostulante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postulante`
--

LOCK TABLES `postulante` WRITE;
/*!40000 ALTER TABLE `postulante` DISABLE KEYS */;
/*!40000 ALTER TABLE `postulante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prueba`
--

DROP TABLE IF EXISTS `prueba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prueba` (
  `idprueba` bigint(20) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idprueba`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prueba`
--

LOCK TABLES `prueba` WRITE;
/*!40000 ALTER TABLE `prueba` DISABLE KEYS */;
/*!40000 ALTER TABLE `prueba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puesto` (
  `idpuesto` bigint(20) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  `preferencia` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idpuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntaje`
--

DROP TABLE IF EXISTS `puntaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puntaje` (
  `idpostulante` bigint(20) NOT NULL,
  `idpuesto` bigint(20) NOT NULL,
  `puntaje` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idpostulante`,`idpuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntaje`
--

LOCK TABLES `puntaje` WRITE;
/*!40000 ALTER TABLE `puntaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `puntaje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-09  1:47:39
