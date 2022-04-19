-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: proyectofinal
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_alumno` varchar(4) NOT NULL,
  `contrasena` varchar(10) NOT NULL,
  `icono` varchar(300) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `puntos` int DEFAULT NULL,
  `profesor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a1sgf78hr7db1g176hmdct92y` (`codigo_alumno`),
  KEY `FKhff1gqa4109u95km9o4lsrxmc` (`profesor_id`),
  CONSTRAINT `FKhff1gqa4109u95km9o4lsrxmc` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'A001','flora123','/proyecto_final/resources/img/icono1.jpg','Marina Gonzalez Mora',0,1),(2,'B001','123','/proyecto_final/resources/img/icono2.jpg','Felisa Domenech',5,2),(3,'C001','a','/proyecto_final/resources/img/icono3.jpg','Lucas Jurado Arriba',10,3);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_mundos`
--

DROP TABLE IF EXISTS `alumno_mundos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_mundos` (
  `alumno_id` bigint NOT NULL,
  `mundos_id` bigint NOT NULL,
  PRIMARY KEY (`alumno_id`,`mundos_id`),
  KEY `FKoaxthda32flus3fi3keg38tcd` (`mundos_id`),
  CONSTRAINT `FKoaxthda32flus3fi3keg38tcd` FOREIGN KEY (`mundos_id`) REFERENCES `mundo` (`id`),
  CONSTRAINT `FKoqxoouytqqp76wmwcl3g04mgw` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_mundos`
--

LOCK TABLES `alumno_mundos` WRITE;
/*!40000 ALTER TABLE `alumno_mundos` DISABLE KEYS */;
INSERT INTO `alumno_mundos` VALUES (1,1),(2,1),(3,1),(2,2),(3,2),(3,3);
/*!40000 ALTER TABLE `alumno_mundos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leccion`
--

DROP TABLE IF EXISTS `leccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leccion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_lec` varchar(4) NOT NULL,
  `contenido` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8ugkx4foc3tx4lvm69es6okv` (`codigo_lec`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leccion`
--

LOCK TABLES `leccion` WRITE;
/*!40000 ALTER TABLE `leccion` DISABLE KEYS */;
INSERT INTO `leccion` VALUES (1,'HL01','Las etiquetas en HTML'),(2,'HL02','Encabezado HTML: &lt;head&gt;'),(3,'CL01','CSS: Cambiar estilos en tu página web');
/*!40000 ALTER TABLE `leccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mundo`
--

DROP TABLE IF EXISTS `mundo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mundo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_mun` varchar(2) NOT NULL,
  `dificultad` int NOT NULL,
  `puntos_desbloqueo` int NOT NULL,
  `tematica` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3yu5ks8vkb36tyn3epxgf3h2s` (`codigo_mun`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mundo`
--

LOCK TABLES `mundo` WRITE;
/*!40000 ALTER TABLE `mundo` DISABLE KEYS */;
INSERT INTO `mundo` VALUES (1,'H',1,0,'HTML'),(2,'C',2,5,'CSS'),(3,'J',3,10,'JAVA');
/*!40000 ALTER TABLE `mundo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivel`
--

DROP TABLE IF EXISTS `nivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nivel` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_nivel` varchar(4) NOT NULL,
  `dificultad` int NOT NULL,
  `puntos_desbloqueo` int NOT NULL,
  `puntuacion_max` int NOT NULL,
  `puntuacion_min` int NOT NULL,
  `leccion_id` bigint NOT NULL,
  `mundo_id` bigint NOT NULL,
  `recompensa_id` bigint DEFAULT NULL,
  `test_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a1lo1tj4wd8mqm2jgd214jd68` (`leccion_id`),
  UNIQUE KEY `UK_5nohqe7xt5cf6eytk8qofb3vw` (`test_id`),
  UNIQUE KEY `UK_smvu914go571gsnol2n6v84y3` (`codigo_nivel`),
  UNIQUE KEY `UK_bs1ll2exj37bulhc12byu3g16` (`recompensa_id`),
  KEY `FKo1rlotju7mcalmua38938bc2p` (`mundo_id`),
  CONSTRAINT `FK61rmokh9j34gs5jh3bkoirhbo` FOREIGN KEY (`recompensa_id`) REFERENCES `recompensa` (`id`),
  CONSTRAINT `FK93pwkxkc5je872n5n1gmalo02` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`),
  CONSTRAINT `FKg6gj7yfheim7u0a21fr6uiek8` FOREIGN KEY (`leccion_id`) REFERENCES `leccion` (`id`),
  CONSTRAINT `FKo1rlotju7mcalmua38938bc2p` FOREIGN KEY (`mundo_id`) REFERENCES `mundo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivel`
--

LOCK TABLES `nivel` WRITE;
/*!40000 ALTER TABLE `nivel` DISABLE KEYS */;
INSERT INTO `nivel` VALUES (1,'H01',1,0,10,5,1,1,NULL,1),(2,'H02',2,5,10,5,2,1,NULL,2),(3,'C01',1,5,10,5,3,2,NULL,3);
/*!40000 ALTER TABLE `nivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pregunta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_pregunta` varchar(6) NOT NULL,
  `imagen_pregunta` varchar(255) DEFAULT NULL,
  `texto_pregunta` varchar(300) NOT NULL,
  `test_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ponavu69mi72hw54otxxliqdj` (`codigo_pregunta`),
  KEY `FK6ln0gn1q6lmg25xx3g2vnojfv` (`test_id`),
  CONSTRAINT `FK6ln0gn1q6lmg25xx3g2vnojfv` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` VALUES (1,'HP01',NULL,'Pregunta 1: ¿Que etiqueta se usa para poner texto?',1),(2,'HP02',NULL,'Pregunta 2: ¿Donde se debe colocar el contenido que queremos enseñar en nuestra página web?',1),(3,'HP03',NULL,'Pregunta 3: De estas etiquetas, ¿cuál nos ayuda a crear un botón?',1),(4,'HP04',NULL,'Pregunta 4: Selecciona la que etiqueta que <strong>NO</strong> existe en lenguaje HTML',1),(5,'HP05',NULL,'Pregunta 5: ¿Podemos crear una etiqueta propia que no exita con anterioridad?',1),(6,'HP06',NULL,'Pregunta 1: La etiqueta &lt;title&gt;, ¿define el nombre del fichero que hemos creado?',2),(7,'HP07',NULL,'Pregunta 2: ¿Qué tipo de información debemos definir en esta parte del archivo?',2),(8,'HP08',NULL,'Pregunta 3: De las siguientes etiquetas, ¿cuál podemos usar dentro de &lt;head&gt;?',2),(9,'HP09',NULL,'Pregunta 4: Señala la etiqueta que nos ayuda a añadir estilos CSS en nuestra web:',2),(10,'HP10',NULL,'Pregunta 5: ¿Es visible la información que indicamos en esta etiqueta?',2),(11,'CP01',NULL,'Pregunta 1: ¿Dónde debemos incluir los estilos que queremos aplicar a nuestra web?',3),(12,'CP02','/proyecto_final/resources/img/preguntaCSS.png','Pregunta 2: Si queremos que una etiqueta &lt;p&gt; tenga color rojo, ¿qué deberiamos incluir en la imagen?',3),(13,'CP03',NULL,'Pregunta 3: ¿Con qué atributo añadimos un fondo de color?',3),(14,'CP04',NULL,'Pregunta 4: ¿Con que atributo añadimos un borde a nuestros elementos?',3),(15,'CP05',NULL,'Pregunta 5: ¿Existen colores predeterminados en CSS?',3);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_profesor` varchar(1) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rxmluhmk7ww0agwq2v8emrmlu` (`codigo_profesor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'A','Teresa Párraga Rodríguez'),(2,'B','Miguel García López'),(3,'C','Beatriz Rouco Pardo');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recompensa`
--

DROP TABLE IF EXISTS `recompensa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recompensa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `desbloqueada` bit(1) NOT NULL,
  `ruta_recompensa` varchar(300) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recompensa`
--

LOCK TABLES `recompensa` WRITE;
/*!40000 ALTER TABLE `recompensa` DISABLE KEYS */;
/*!40000 ALTER TABLE `recompensa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(6) NOT NULL,
  `correcta` bit(1) NOT NULL,
  `texto_respuesta` varchar(300) NOT NULL,
  `pregunta_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_91fs739cw6ra4yatlcojjpa20` (`codigo`),
  KEY `FKd9oyrwyjw1otr38btjeevanif` (`pregunta_id`),
  CONSTRAINT `FKd9oyrwyjw1otr38btjeevanif` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` VALUES (1,'HR01','','&lt;p&gt;',1),(2,'HR02','\0','&lt;h1&gt;',1),(3,'HR03','\0','&lt;text&gt;',1),(4,'HR04','\0','&lt;a&gt;',1),(5,'HR05','\0','Dentro de la etiqueta &lt;head&gt;',2),(6,'HR06','','Dentro de la etiqueta &lt;body&gt;',2),(7,'HR07','\0','El lugar no importa mientras esté dentro de la etiqueta  &lt;html&gt;',2),(8,'HR08','\0','Ninguna de las anteriores es correcta',2),(9,'HR09','','&lt;button&gt;',3),(10,'HR10','\0','&lt;boton&gt;',3),(11,'HR11','\0','No podemos hacer un botón con HTML',3),(12,'HR12','\0','&lt;select&gt;',3),(13,'HR13','\0','&lt;h5&gt;',4),(14,'HR14','\0','&lt;input&gt;',4),(15,'HR15','\0','&lt;span&gt;',4),(16,'HR16','','Todas las anteriores pertenecen al lenguaje HTML',4),(17,'HR17','','No, este lenguaje no permite crear etiquetas propias',5),(18,'HR18','\0','Si, podemos crear las etiquetas que queramos',5),(19,'HR19','\0','Depende de las palabras que usemos para definirlas',5),(20,'HR20','\0','Si, pero solo en dentro de la etiqueta &lt;body&gt;',5),(21,'HR21','\0','Sí, por eso es importante nombrar al fichero igual.',6),(22,'HR22','','No es necesario, no influye que sean distintos.',6),(23,'HR23','\0','No es neceario, pero es mejor que ambos se llamen igual.',6),(24,'HR24','\0','Ninguna de las respuestas anteriores es correcta.',6),(25,'HR25','','Se debe definir la información acerca del documento pero que no es necesario visualizar por pantalla.',7),(26,'HR26','\0','Se debe definir la información de el nombre y poco más.',7),(27,'HR27','\0','No es necesario su uso, solo si quieres definir información extra del documento.',7),(28,'HR28','\0','Solo se usa cuando queremos añadir estilos a nuestra web.',7),(29,'HR29','\0','&lt;span&gt;',8),(30,'HR30','\0','&lt;p&gt;',8),(31,'HR31','\0','&lt;body&gt;',8),(32,'HR32','','Ninguna de las anteriores.',8),(33,'HR33','\0','No ha una estiqueta que haga eso.',9),(34,'HR34','','&lt;link&gt;',9),(35,'HR35','\0','Solo se puede definir en el &lt;body&gt;',9),(36,'HR36','\0','&lt;meta&gt;',9),(37,'HR37','\0','Sí, es lo primero que nos muestra la web.',10),(38,'HR38','','Por lo general no, es información de metadatos que no es neceario mostrar',10),(39,'HR39','\0','Depende de si usamos esta etiqueta.',10),(40,'HR40','\0','Si ponemos la etiqueta &lt;visible&gt; sí.',10),(41,'CR01','\0','No importa donde lo hagamos.',11),(42,'CR02','\0','Tiene que ser después de la etiqueta &lt;body&gt;',11),(43,'CR03','\0','Tiene que ser dentro de &lt;head&gt;',11),(44,'CR04','','Tiene que ser dentro de &lt;head&gt; y dentro a su vez de &lt;style&gt;',11),(45,'CR05','\0','Un ¨.p¨ y un ¨color¨',12),(46,'CR06','','Un ¨p¨ y un ¨color¨',12),(47,'CR07','\0','Un ¨p¨ y un ¨text-color¨',12),(48,'CR08','\0','Un ¨.p¨ y un ¨text¨',12),(49,'CR09','','Con ¨background-color¨',13),(50,'CR10','\0','Con ¨background-style¨',13),(51,'CR11','\0','Con ¨background¨',13),(52,'CR12','\0','Con ¨color-fondo¨',13),(53,'CR13','\0','Con ¨border¨',14),(54,'CR14','\0','Con ¨bordes-estilo¨',14),(55,'CR15','','Con ¨border-style¨',14),(56,'CR16','\0','Con ¨style¨: border',14),(57,'CR17','\0','No, tenemos que agregarlos con un fichero.',15),(58,'CR18','\0','Sí, pero solo si nuestro fichero lo permite.',15),(59,'CR19','\0','No hace falta que los tenga porque HTML los tiene por defecto.',15),(60,'CR20','','Sí, disponemos de una gama de colores con nombre predeterminados para usar.',15);
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(4) NOT NULL,
  `terminado` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lgdjyivlgb8lsu0o0c66joyai` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'HT01','\0'),(2,'HT02','\0'),(3,'CT01','\0');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'proyectofinal'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-28 15:57:03
