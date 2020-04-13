-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `mybooksdb`.`author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybooksdb`.`author` ;

CREATE TABLE IF NOT EXISTS `mybooksdb`.`author` (
  `idauthor` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`idauthor`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `mybooksdb`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybooksdb`.`category` ;

CREATE TABLE IF NOT EXISTS `mybooksdb`.`category` (
  `idcategory` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL,
  `englishname` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`idcategory`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `mybooksdb`.`book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybooksdb`.`book` ;

CREATE TABLE IF NOT EXISTS `mybooksdb`.`book` (
  `idbook` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(256) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `subtitle` VARCHAR(256) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `synopsis` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `idauthor` INT(11) NOT NULL,
  `publicationdate` DATE NOT NULL,
  `idcategory` INT(11) NOT NULL,
  `image` VARCHAR(512) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `isbn10` BIGINT(20) NOT NULL,
  `isbn13` BIGINT(20) NOT NULL,
  `idgoogle` VARCHAR(30) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`idbook`),
  INDEX `idauthor` (`idauthor` ASC) VISIBLE,
  INDEX `idcategory` (`idcategory` ASC) VISIBLE,
  CONSTRAINT `book_ibfk_1`
    FOREIGN KEY (`idcategory`)
    REFERENCES `mybooksdb`.`category` (`idcategory`),
  CONSTRAINT `book_ibfk_2`
    FOREIGN KEY (`idauthor`)
    REFERENCES `mybooksdb`.`author` (`idauthor`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `mybooksdb`.`country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybooksdb`.`country` ;

CREATE TABLE IF NOT EXISTS `mybooksdb`.`country` (
  `idcountry` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`idcountry`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `mybooksdb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybooksdb`.`user` ;

CREATE TABLE IF NOT EXISTS `mybooksdb`.`user` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `password` VARCHAR(30) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `userstate` TINYINT(11) NOT NULL DEFAULT '1' COMMENT '1: Activo | 2: Inactivo',
  `creationdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `nameunico` (`username` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `mybooksdb`.`region`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybooksdb`.`region` ;

CREATE TABLE IF NOT EXISTS `mybooksdb`.`region` (
  `idregion` INT(11) NOT NULL AUTO_INCREMENT,
  `idcountry` INT(11) NOT NULL,
  `name` VARCHAR(256) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`idregion`),
  INDEX `country` (`idcountry` ASC) VISIBLE,
  CONSTRAINT `region_ibfk_1`
    FOREIGN KEY (`idcountry`)
    REFERENCES `mybooksdb`.`country` (`idcountry`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `mybooksdb`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybooksdb`.`person` ;

CREATE TABLE IF NOT EXISTS `mybooksdb`.`person` (
  `idperson` INT(11) NOT NULL AUTO_INCREMENT,
  `iduser` INT(11) NOT NULL,
  `name` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `lastname` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `birthdate` DATE NOT NULL,
  `idnativecountry` INT(11) NOT NULL,
  `idnativeregion` INT(11) NOT NULL,
  `idcurrentcountry` INT(11) NOT NULL,
  `idcurrentregion` INT(11) NOT NULL,
  `aboutme` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `photo` VARCHAR(256) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`idperson`),
  UNIQUE INDEX `iduser_2` (`iduser` ASC) VISIBLE,
  INDEX `iduser` (`iduser` ASC) VISIBLE,
  INDEX `idnativecountry` (`idnativecountry` ASC) VISIBLE,
  INDEX `idnativeregion` (`idnativeregion` ASC) VISIBLE,
  INDEX `idcurrentcountry` (`idcurrentcountry` ASC) VISIBLE,
  INDEX `idcurrentregion` (`idcurrentregion` ASC) VISIBLE,
  CONSTRAINT `person_ibfk_1`
    FOREIGN KEY (`iduser`)
    REFERENCES `mybooksdb`.`user` (`iduser`),
  CONSTRAINT `person_ibfk_2`
    FOREIGN KEY (`idnativecountry`)
    REFERENCES `mybooksdb`.`country` (`idcountry`),
  CONSTRAINT `person_ibfk_3`
    FOREIGN KEY (`idcurrentcountry`)
    REFERENCES `mybooksdb`.`country` (`idcountry`),
  CONSTRAINT `person_ibfk_4`
    FOREIGN KEY (`idnativeregion`)
    REFERENCES `mybooksdb`.`region` (`idregion`),
  CONSTRAINT `person_ibfk_5`
    FOREIGN KEY (`idcurrentregion`)
    REFERENCES `mybooksdb`.`region` (`idregion`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `mybooksdb`.`library`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybooksdb`.`library` ;

CREATE TABLE IF NOT EXISTS `mybooksdb`.`library` (
  `idperson` INT(11) NOT NULL,
  `idbook` INT(11) NOT NULL,
  `startdate` DATE NOT NULL,
  `enddate` DATE NOT NULL,
  `idinitialcountry` INT(11) NOT NULL,
  `idinitialregion` INT(11) NOT NULL,
  `idendcountry` INT(11) NOT NULL,
  `idendregion` INT(11) NOT NULL,
  `rating` DOUBLE NOT NULL,
  `note` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `creationdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idbook`, `idperson`),
  INDEX `idperson` (`idperson` ASC) VISIBLE,
  INDEX `idbook` (`idbook` ASC) VISIBLE,
  INDEX `idinitialcountry` (`idinitialcountry` ASC) VISIBLE,
  INDEX `idinitialregion` (`idinitialregion` ASC) VISIBLE,
  INDEX `idendcountry` (`idendcountry` ASC) VISIBLE,
  INDEX `idendregion` (`idendregion` ASC) VISIBLE,
  CONSTRAINT `library_ibfk_1`
    FOREIGN KEY (`idbook`)
    REFERENCES `mybooksdb`.`book` (`idbook`),
  CONSTRAINT `library_ibfk_2`
    FOREIGN KEY (`idperson`)
    REFERENCES `mybooksdb`.`person` (`idperson`),
  CONSTRAINT `library_ibfk_3`
    FOREIGN KEY (`idinitialcountry`)
    REFERENCES `mybooksdb`.`country` (`idcountry`),
  CONSTRAINT `library_ibfk_4`
    FOREIGN KEY (`idendcountry`)
    REFERENCES `mybooksdb`.`country` (`idcountry`),
  CONSTRAINT `library_ibfk_5`
    FOREIGN KEY (`idinitialregion`)
    REFERENCES `mybooksdb`.`region` (`idregion`),
  CONSTRAINT `library_ibfk_6`
    FOREIGN KEY (`idendregion`)
    REFERENCES `mybooksdb`.`region` (`idregion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
