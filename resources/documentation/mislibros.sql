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
-- Base de datos: `mybooks`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `idautor` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `idestado` int(11) NOT NULL,
  `idpais` int(11) NOT NULL,
  `nombre` varchar(256) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `idgenero` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nombreingles` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libreria`
--

CREATE TABLE `libreria` (
  `idlibreria` int(11) NOT NULL,
  `idpersona` int(11) NOT NULL,
  `idlibro` int(11) NOT NULL,
  `fechainicio` date NOT NULL,
  `fechafin` date NOT NULL,
  `idpaisinicio` int(11) NOT NULL,
  `idestadoinicio` int(11) NOT NULL,
  `idpaisfin` int(11) NOT NULL,
  `idestadofin` int(11) NOT NULL,
  `valoracion` double NOT NULL,
  `nota` text COLLATE utf8_spanish_ci NOT NULL,
  `fechacreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `idlibro` int(11) NOT NULL,
  `titulo` varchar(256) COLLATE utf8_spanish_ci NOT NULL,
  `subtitulo` varchar(256) COLLATE utf8_spanish_ci NOT NULL,
  `sinopsis` text COLLATE utf8_spanish_ci NOT NULL,
  `idautor` int(11) NOT NULL,
  `fechapublicacion` date NOT NULL,
  `idgenero` int(11) NOT NULL,
  `imagen` varchar(256) COLLATE utf8_spanish_ci NOT NULL,
  `isbn10` bigint(20) NOT NULL,
  `isbn13` bigint(20) NOT NULL,
  `idgoogle` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `idpais` int(11) NOT NULL,
  `nombre` varchar(256) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `fechanacimiento` date NOT NULL,
  `idpaisnacimiento` int(11) NOT NULL,
  `idestadonacimiento` int(11) NOT NULL,
  `idpaisactual` int(11) NOT NULL,
  `idestadoactual` int(11) NOT NULL,
  `sobremi` text COLLATE utf8_spanish_ci NOT NULL,
  `foto` varchar(256) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombreusuario` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `contrasena` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `estadousuario` tinyint(11) NOT NULL DEFAULT '1' COMMENT '1: Activo | 2: Inactivo',
  `fechacreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`idautor`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idestado`),
  ADD KEY `pais` (`idpais`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`idgenero`);

--
-- Indices de la tabla `libreria`
--
ALTER TABLE `libreria`
  ADD PRIMARY KEY (`idlibreria`),
  ADD KEY `idpersona` (`idpersona`),
  ADD KEY `idlibro` (`idlibro`),
  ADD KEY `idpaisinicio` (`idpaisinicio`),
  ADD KEY `idestadoinicio` (`idestadoinicio`),
  ADD KEY `idpaisfin` (`idpaisfin`),
  ADD KEY `idestadofin` (`idestadofin`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`idlibro`),
  ADD KEY `idautor` (`idautor`),
  ADD KEY `idgenero` (`idgenero`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`idpais`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`),
  ADD UNIQUE KEY `idusuario_2` (`idusuario`),
  ADD KEY `idusuario` (`idusuario`),
  ADD KEY `idpaisnacimiento` (`idpaisnacimiento`),
  ADD KEY `idestadonacimiento` (`idestadonacimiento`),
  ADD KEY `idpaisactual` (`idpaisactual`),
  ADD KEY `idestadoactual` (`idestadoactual`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD UNIQUE KEY `nombreunico` (`nombreusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `idautor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `idestado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `idgenero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `libreria`
--
ALTER TABLE `libreria`
  MODIFY `idlibreria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `idlibro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `idpais` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estado`
--
ALTER TABLE `estado`
  ADD CONSTRAINT `estado_ibfk_1` FOREIGN KEY (`idpais`) REFERENCES `pais` (`idpais`);

--
-- Filtros para la tabla `libreria`
--
ALTER TABLE `libreria`
  ADD CONSTRAINT `libreria_ibfk_1` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`),
  ADD CONSTRAINT `libreria_ibfk_2` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`),
  ADD CONSTRAINT `libreria_ibfk_3` FOREIGN KEY (`idpaisinicio`) REFERENCES `pais` (`idpais`),
  ADD CONSTRAINT `libreria_ibfk_4` FOREIGN KEY (`idpaisfin`) REFERENCES `pais` (`idpais`),
  ADD CONSTRAINT `libreria_ibfk_5` FOREIGN KEY (`idestadoinicio`) REFERENCES `estado` (`idestado`),
  ADD CONSTRAINT `libreria_ibfk_6` FOREIGN KEY (`idestadofin`) REFERENCES `estado` (`idestado`);

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`idgenero`) REFERENCES `genero` (`idgenero`),
  ADD CONSTRAINT `libro_ibfk_2` FOREIGN KEY (`idautor`) REFERENCES `autor` (`idautor`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`),
  ADD CONSTRAINT `persona_ibfk_2` FOREIGN KEY (`idpaisnacimiento`) REFERENCES `pais` (`idpais`),
  ADD CONSTRAINT `persona_ibfk_3` FOREIGN KEY (`idpaisactual`) REFERENCES `pais` (`idpais`),
  ADD CONSTRAINT `persona_ibfk_4` FOREIGN KEY (`idestadonacimiento`) REFERENCES `estado` (`idestado`),
  ADD CONSTRAINT `persona_ibfk_5` FOREIGN KEY (`idestadoactual`) REFERENCES `estado` (`idestado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
