CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Guilherme','Carvalho','gui@email.com'),
	(2,'Tanjiro','Kamado','tanjiro@dslayer.com'),
	(3,'Kamaboko','Kompachiro','othertanjiro@dslayer.com'),
	(4,'Gojo','Satoru','gojo@jujutsu.com'),
	(5,'Naruto','Uzumaki','naruto@konoha.com');

