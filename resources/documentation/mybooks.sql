-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 21-01-2019 a las 05:20:56
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `misbooks`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `author`
--

CREATE TABLE `author` (
  `idauthor` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `region`
--

CREATE TABLE `region` (
  `idregion` int(11) NOT NULL,
  `idcountry` int(11) NOT NULL,
  `name` varchar(256) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `idcategory` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `englishname` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `library`
--

CREATE TABLE `library` (
  `idlibrary` int(11) NOT NULL,
  `idperson` int(11) NOT NULL,
  `idbook` int(11) NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  `idinitialcountry` int(11) NOT NULL,
  `idinitialregion` int(11) NOT NULL,
  `idendcountry` int(11) NOT NULL,
  `idendregion` int(11) NOT NULL,
  `rating` double NOT NULL,
  `note` text COLLATE utf8_spanish_ci NOT NULL,
  `creationdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book`
--

CREATE TABLE `book` (
  `idbook` int(11) NOT NULL,
  `title` varchar(256) COLLATE utf8_spanish_ci NOT NULL,
  `subtitle` varchar(256) COLLATE utf8_spanish_ci NOT NULL,
  `synopsis` text COLLATE utf8_spanish_ci NOT NULL,
  `idauthor` int(11) NOT NULL,
  `publicationdate` date NOT NULL,
  `idcategory` int(11) NOT NULL,
  `image` varchar(256) COLLATE utf8_spanish_ci NOT NULL,
  `isbn10` bigint(20) NOT NULL,
  `isbn13` bigint(20) NOT NULL,
  `idgoogle` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `country`
--

CREATE TABLE `country` (
  `idcountry` int(11) NOT NULL,
  `name` varchar(256) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `idperson` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `lastname` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `birthdate` date NOT NULL,
  `idnativecountry` int(11) NOT NULL,
  `idnativeregion` int(11) NOT NULL,
  `idcurrentcountry` int(11) NOT NULL,
  `idcurrentregion` int(11) NOT NULL,
  `aboutme` text COLLATE utf8_spanish_ci NOT NULL,
  `photo` varchar(256) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `nameuser` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `userstate` tinyint(11) NOT NULL DEFAULT '1' COMMENT '1: Activo | 2: Inactivo',
  `creationdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`idauthor`);

--
-- Indices de la tabla `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`idregion`),
  ADD KEY `country` (`idcountry`);

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`idcategory`);

--
-- Indices de la tabla `library`
--
ALTER TABLE `library`
  ADD PRIMARY KEY (`idlibrary`),
  ADD KEY `idperson` (`idperson`),
  ADD KEY `idbook` (`idbook`),
  ADD KEY `idinitialcountry` (`idinitialcountry`),
  ADD KEY `idinitialregion` (`idinitialregion`),
  ADD KEY `idendcountry` (`idendcountry`),
  ADD KEY `idendregion` (`idendregion`);

--
-- Indices de la tabla `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`idbook`),
  ADD KEY `idauthor` (`idauthor`),
  ADD KEY `idcategory` (`idcategory`);

--
-- Indices de la tabla `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`idcountry`);

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`idperson`),
  ADD UNIQUE KEY `iduser_2` (`iduser`),
  ADD KEY `iduser` (`iduser`),
  ADD KEY `idnativecountry` (`idnativecountry`),
  ADD KEY `idnativeregion` (`idnativeregion`),
  ADD KEY `idcurrentcountry` (`idcurrentcountry`),
  ADD KEY `idcurrentregion` (`idcurrentregion`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`),
  ADD UNIQUE KEY `nameunico` (`nameuser`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `author`
--
ALTER TABLE `author`
  MODIFY `idauthor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `region`
--
ALTER TABLE `region`
  MODIFY `idregion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `idcategory` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `library`
--
ALTER TABLE `library`
  MODIFY `idlibrary` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `book`
--
ALTER TABLE `book`
  MODIFY `idbook` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `country`
--
ALTER TABLE `country`
  MODIFY `idcountry` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `person`
--
ALTER TABLE `person`
  MODIFY `idperson` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `region`
--
ALTER TABLE `region`
  ADD CONSTRAINT `region_ibfk_1` FOREIGN KEY (`idcountry`) REFERENCES `country` (`idcountry`);

--
-- Filtros para la tabla `library`
--
ALTER TABLE `library`
  ADD CONSTRAINT `library_ibfk_1` FOREIGN KEY (`idbook`) REFERENCES `book` (`idbook`),
  ADD CONSTRAINT `library_ibfk_2` FOREIGN KEY (`idperson`) REFERENCES `person` (`idperson`),
  ADD CONSTRAINT `library_ibfk_3` FOREIGN KEY (`idinitialcountry`) REFERENCES `country` (`idcountry`),
  ADD CONSTRAINT `library_ibfk_4` FOREIGN KEY (`idendcountry`) REFERENCES `country` (`idcountry`),
  ADD CONSTRAINT `library_ibfk_5` FOREIGN KEY (`idinitialregion`) REFERENCES `region` (`idregion`),
  ADD CONSTRAINT `library_ibfk_6` FOREIGN KEY (`idendregion`) REFERENCES `region` (`idregion`);

--
-- Filtros para la tabla `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`idcategory`) REFERENCES `category` (`idcategory`),
  ADD CONSTRAINT `book_ibfk_2` FOREIGN KEY (`idauthor`) REFERENCES `author` (`idauthor`);

--
-- Filtros para la tabla `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `person_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`),
  ADD CONSTRAINT `person_ibfk_2` FOREIGN KEY (`idnativecountry`) REFERENCES `country` (`idcountry`),
  ADD CONSTRAINT `person_ibfk_3` FOREIGN KEY (`idcurrentcountry`) REFERENCES `country` (`idcountry`),
  ADD CONSTRAINT `person_ibfk_4` FOREIGN KEY (`idnativeregion`) REFERENCES `region` (`idregion`),
  ADD CONSTRAINT `person_ibfk_5` FOREIGN KEY (`idcurrentregion`) REFERENCES `region` (`idregion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
