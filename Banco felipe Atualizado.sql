CREATE DATABASE  IF NOT EXISTS `db_felipe_ronceti` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `db_felipe_ronceti`;
-- MariaDB dump 10.19  Distrib 10.4.28-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: db_felipe_ronceti
-- ------------------------------------------------------
-- Server version	10.4.28-MariaDB

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
-- Table structure for table `cliente_fgv`
--

DROP TABLE IF EXISTS `cliente_fgv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_fgv` (
  `idcliente_fgv` int(11) NOT NULL,
  `nome_fgv` varchar(20) DEFAULT NULL,
  `cpf_fgv` varchar(15) DEFAULT NULL,
  `rg_fgv` varchar(30) DEFAULT NULL,
  `cep_fgv` varchar(10) DEFAULT NULL,
  `endereco_fgv` varchar(60) DEFAULT NULL,
  `telefone_fgv` varchar(14) DEFAULT NULL,
  `bairro_fgv` varchar(100) DEFAULT NULL,
  `estadocivil_fgv` varchar(20) DEFAULT NULL,
  `sexo_fgv` varchar(15) DEFAULT NULL,
  `apelido_fgv` varchar(50) DEFAULT NULL,
  `cnpj_fgv` varchar(18) DEFAULT NULL,
  `email_fgv` varchar(80) DEFAULT NULL,
  `uf_fgv` varchar(15) DEFAULT NULL,
  `nacionalidade_fgv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcliente_fgv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_fgv`
--

LOCK TABLES `cliente_fgv` WRITE;
/*!40000 ALTER TABLE `cliente_fgv` DISABLE KEYS */;
INSERT INTO `cliente_fgv` VALUES (1,'Maria','111.111.111-11','111111','11111','ferrebulo','363463565','cnhbxnnx','Solteiro','dcndcv','mama','436565','fcjmnfv@fjfkjhk','fh','fgmnfmn'),(3,'luiz','344.444.444-44','355555554','344444444','fdhz','43333333333','gfffffh','Casado','dxfffffffh','dxhffff','333333','zdhgndffffffffffhjn','chhgf','fdhdxhsz'),(5,'A','000.000.000-00','A','A','A','A','A','A','A','A','A','A','A','A'),(6,'Felipe','333.333.333-33','333333','44532','sdaghbv','55555555','fsadd','Solteiro','Masculino','sdhb','5555','shgsdhs','fd','sggedh');
/*!40000 ALTER TABLE `cliente_fgv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_fgv`
--

DROP TABLE IF EXISTS `compra_fgv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra_fgv` (
  `idcompra_fgv` int(11) NOT NULL,
  `datadaCompra_fgv` date NOT NULL,
  `valorTotal_fgv` decimal(10,2) NOT NULL,
  `fk_cliente_fgv` int(11) NOT NULL,
  `fk_vendedor_fgv` int(11) NOT NULL,
  PRIMARY KEY (`idcompra_fgv`),
  KEY `fk_cliente_fgv` (`fk_cliente_fgv`),
  KEY `fk_vendedor_fgv` (`fk_vendedor_fgv`),
  CONSTRAINT `fk_cliente_fgv` FOREIGN KEY (`fk_cliente_fgv`) REFERENCES `cliente_fgv` (`idcliente_fgv`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vendedor_fgv` FOREIGN KEY (`fk_vendedor_fgv`) REFERENCES `vendedor_fgv` (`idvendedor_fgv`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_fgv`
--

LOCK TABLES `compra_fgv` WRITE;
/*!40000 ALTER TABLE `compra_fgv` DISABLE KEYS */;
INSERT INTO `compra_fgv` VALUES (1,'2022-12-12',1711.00,1,2),(2,'2023-12-12',7577.00,1,1),(3,'2022-12-12',21144.00,1,1);
/*!40000 ALTER TABLE `compra_fgv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compraproduto_fgv`
--

DROP TABLE IF EXISTS `compraproduto_fgv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compraproduto_fgv` (
  `idcompraproduto_fgv` int(11) NOT NULL AUTO_INCREMENT,
  `compra_fgv` int(11) NOT NULL,
  `produto_fgv` int(11) NOT NULL,
  `quantidade_fgv` int(11) DEFAULT NULL,
  `valorUnitario_fgv` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idcompraproduto_fgv`),
  KEY `compra_fgv` (`compra_fgv`),
  KEY `produto_fgv` (`produto_fgv`),
  CONSTRAINT `fk_compra_fgv` FOREIGN KEY (`compra_fgv`) REFERENCES `compra_fgv` (`idcompra_fgv`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_fgv` FOREIGN KEY (`produto_fgv`) REFERENCES `produto_fgv` (`idproduto_fgv`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compraproduto_fgv`
--

LOCK TABLES `compraproduto_fgv` WRITE;
/*!40000 ALTER TABLE `compraproduto_fgv` DISABLE KEYS */;
INSERT INTO `compraproduto_fgv` VALUES (12,1,1,1,567.00),(14,2,1,1,567.00),(15,2,2,1,7000.00),(17,3,3,1,20000.00),(18,3,1,1,567.00);
/*!40000 ALTER TABLE `compraproduto_fgv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_fgv`
--

DROP TABLE IF EXISTS `produto_fgv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto_fgv` (
  `idproduto_fgv` int(11) NOT NULL,
  `nome_fgv` varchar(20) NOT NULL,
  `marca_fgv` varchar(45) NOT NULL,
  `cor_fgv` varchar(45) NOT NULL,
  `precoproduto_fgv` decimal(10,2) NOT NULL,
  `quantidade_fgv` int(20) NOT NULL,
  PRIMARY KEY (`idproduto_fgv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_fgv`
--

LOCK TABLES `produto_fgv` WRITE;
/*!40000 ALTER TABLE `produto_fgv` DISABLE KEYS */;
INSERT INTO `produto_fgv` VALUES (1,'Galaxy','Samsung','Amarelo',567.00,6),(2,'Iphone Max','Apple','Preto',7000.00,7),(3,'Tablet g1','Samsung','Preta',20000.00,50);
/*!40000 ALTER TABLE `produto_fgv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_fgv`
--

DROP TABLE IF EXISTS `usuario_fgv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_fgv` (
  `idusuario_fgv` int(11) NOT NULL,
  `nome_fgv` varchar(45) NOT NULL,
  `apelido_fgv` varchar(45) NOT NULL,
  `cpf_fgv` varchar(15) NOT NULL,
  `datanascimento_fgv` date NOT NULL,
  `senha_fgv` varchar(45) NOT NULL,
  `nivel_fgv` varchar(20) NOT NULL,
  `ativo_fgv` varchar(45) NOT NULL,
  PRIMARY KEY (`idusuario_fgv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_fgv`
--

LOCK TABLES `usuario_fgv` WRITE;
/*!40000 ALTER TABLE `usuario_fgv` DISABLE KEYS */;
INSERT INTO `usuario_fgv` VALUES (1,'Paul','pinga','111.111.111-11','1111-11-11','12345','Admin','S'),(2,'Christiane','Cricri','999.999.999-99','1975-11-26','123','adm','S'),(3,'Felipe','lipe','222.222.222.22','2005-12-13','1234','Admin','S');
/*!40000 ALTER TABLE `usuario_fgv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor_fgv`
--

DROP TABLE IF EXISTS `vendedor_fgv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendedor_fgv` (
  `idvendedor_fgv` int(11) NOT NULL,
  `nome_fgv` varchar(20) NOT NULL,
  `cpf_fgv` varchar(15) NOT NULL,
  `telefone_fgv` varchar(14) NOT NULL,
  `email_fgv` varchar(18) NOT NULL,
  PRIMARY KEY (`idvendedor_fgv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor_fgv`
--

LOCK TABLES `vendedor_fgv` WRITE;
/*!40000 ALTER TABLE `vendedor_fgv` DISABLE KEYS */;
INSERT INTO `vendedor_fgv` VALUES (1,'Lucas','555.555.555.55','(67)88888-8888','lucas@gmail.com'),(2,'Marina','777.777.777.77','(67)44444-4444','marina@gmail.com');
/*!40000 ALTER TABLE `vendedor_fgv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_felipe_ronceti'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-18 16:19:56
