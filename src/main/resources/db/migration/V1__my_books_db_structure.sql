-- -----------------------------------------------------
-- DATABASE mybooksdb
-- -----------------------------------------------------

--
-- Table structure for table `author`
--
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `author_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`author_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


--
-- Table structure for table `category`
--
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(256) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


--
-- Table structure for table `country`
--
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `country_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(256) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


--
-- Table structure for table `region`
--
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `region_id` int NOT NULL AUTO_INCREMENT,
  `country_id` int NOT NULL,
  `name` varchar(256) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`region_id`),
  KEY `country` (`country_id`),
  CONSTRAINT `region_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2204 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


--
-- Table structure for table `book`
--
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(256) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `subtitle` varchar(256) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_spanish_ci,
  `publication_date` date DEFAULT NULL,
  `image` varchar(512) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `isbn10` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `isbn13` varchar(13) COLLATE utf8_spanish_ci DEFAULT NULL,
  `google_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


--
-- Table structure for table `categorize`
--
DROP TABLE IF EXISTS `categorize`;
CREATE TABLE `categorize` (
  `book_id` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`book_id`,`category_id`),
  KEY `categoryid_idx` (`category_id`),
  CONSTRAINT `bookid_fk` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `categoryid_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `user_state` tinyint NOT NULL DEFAULT '1' COMMENT '1: Activo | 2: Inactivo',
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `nameunico` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


--
-- Table structure for table `person`
--
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `person_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `last_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `birthdate` date NOT NULL,
  `native_country_id` int NOT NULL,
  `native_region_id` int NOT NULL,
  `current_country_id` int NOT NULL,
  `current_region_id` int NOT NULL,
  `about_me` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `photo` varchar(256) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `iduser_2` (`user_id`),
  KEY `iduser` (`user_id`),
  KEY `idnativecountry` (`native_country_id`),
  KEY `idnativeregion` (`native_region_id`),
  KEY `idcurrentcountry` (`current_country_id`),
  KEY `idcurrentregion` (`current_region_id`),
  CONSTRAINT `person_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `person_ibfk_2` FOREIGN KEY (`native_country_id`) REFERENCES `country` (`country_id`),
  CONSTRAINT `person_ibfk_3` FOREIGN KEY (`current_country_id`) REFERENCES `country` (`country_id`),
  CONSTRAINT `person_ibfk_4` FOREIGN KEY (`native_region_id`) REFERENCES `region` (`region_id`),
  CONSTRAINT `person_ibfk_5` FOREIGN KEY (`current_region_id`) REFERENCES `region` (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


--
-- Table structure for table `library`
--
DROP TABLE IF EXISTS `library`;
CREATE TABLE `library` (
  `person_id` int NOT NULL,
  `book_id` int NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `initial_country_id` int NOT NULL,
  `initial_region_id` int NOT NULL,
  `end_country_id` int NOT NULL,
  `end_region_id` int NOT NULL,
  `rating` double NOT NULL,
  `note` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`book_id`,`person_id`),
  KEY `idperson` (`person_id`),
  KEY `idbook` (`book_id`),
  KEY `idinitialcountry` (`initial_country_id`),
  KEY `idinitialregion` (`initial_region_id`),
  KEY `idendcountry` (`end_country_id`),
  KEY `idendregion` (`end_region_id`),
  CONSTRAINT `library_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `library_ibfk_2` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `library_ibfk_3` FOREIGN KEY (`initial_country_id`) REFERENCES `country` (`country_id`),
  CONSTRAINT `library_ibfk_4` FOREIGN KEY (`end_country_id`) REFERENCES `country` (`country_id`),
  CONSTRAINT `library_ibfk_5` FOREIGN KEY (`initial_region_id`) REFERENCES `region` (`region_id`),
  CONSTRAINT `library_ibfk_6` FOREIGN KEY (`end_region_id`) REFERENCES `region` (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


--
-- Table structure for table `written`
--
DROP TABLE IF EXISTS `written`;
CREATE TABLE `written` (
  `book_id` int NOT NULL,
  `author_id` int NOT NULL,
  PRIMARY KEY (`book_id`,`author_id`),
  KEY `authorid_idx` (`author_id`),
  CONSTRAINT `authorid` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`),
  CONSTRAINT `bookid` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

