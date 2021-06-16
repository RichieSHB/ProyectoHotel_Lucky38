-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-06-2021 a las 02:39:10
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitaciones`
--

CREATE TABLE `habitaciones` (
  `num_habitacion` int(10) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `fecha_llegada` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `tipo_habitacion` varchar(45) NOT NULL,
  `num_piso` int(11) NOT NULL,
  `Ocupado` tinyint(1) NOT NULL,
  `Extras` int(10) NOT NULL,
  `huespedes` int(10) NOT NULL,
  `ingreso` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `habitaciones`
--

INSERT INTO `habitaciones` (`num_habitacion`, `nombre`, `ciudad`, `fecha_llegada`, `fecha_salida`, `tipo_habitacion`, `num_piso`, `Ocupado`, `Extras`, `huespedes`, `ingreso`) VALUES
(1, 'Ayaye', 'Runaterra', '2021-06-12', '2021-06-13', 'Sencilla', 1, 1, 2, 0, 1200),
(2, 'Roy', 'Aguascalientes', '2021-05-31', '2021-06-05', 'Sencilla', 1, 1, 0, 0, 0),
(3, 'Rafael', 'Aguascalientes', '2021-05-31', '2021-06-04', 'Sencilla', 1, 1, 0, 0, 0),
(4, 'Alex popo', 'Aguascalientes', '2021-05-31', '2021-06-05', 'Sencilla', 1, 1, 2, 0, 0),
(5, 'Coincidencia', 'Aguascalientes', '2021-06-09', '2021-06-19', 'Sencilla', 1, 1, 1, 1, 0),
(6, '', '', '0000-00-00', '0000-00-00', 'Doble', 1, 0, 0, 0, 0),
(7, 'Quin bb', 'Lagos de Moreno', '2021-06-01', '2021-06-14', 'Doble', 1, 1, 2, 0, 0),
(8, 'Ricardo Leshuga', 'Aguascalientes', '2021-06-01', '2021-06-07', 'Doble', 1, 1, 1, 0, 0),
(9, 'Jesse', 'Aguascalientes', '2021-06-02', '2021-06-07', 'Doble', 1, 1, 1, 0, 0),
(10, 'Ticket', 'TicketLandia', '2021-06-09', '2021-06-14', 'Doble', 1, 1, 2, 2, 0),
(11, 'Mimir', 'Mimir', '2021-06-02', '2021-06-09', 'Triple', 1, 1, 0, 0, 0),
(12, '', '', '0000-00-00', '0000-00-00', 'Triple', 1, 0, 0, 0, 0),
(13, '', '', '0000-00-00', '0000-00-00', 'Triple', 1, 0, 0, 0, 0),
(14, '', '', '0000-00-00', '0000-00-00', 'Triple', 1, 0, 0, 0, 0),
(15, 'Klee', 'Mondstad', '2021-06-02', '2021-06-28', 'Triple', 1, 1, 0, 0, 0),
(16, 'a', 'b', '2021-06-09', '2021-06-12', 'Sencilla', 2, 1, 2, 1, 0),
(17, 'Roysencillonew', 'Ags', '2021-06-11', '2021-06-12', 'Sencilla', 2, 1, 2, 0, 2850),
(18, 'RoyTriple', 'Ags', '2021-06-10', '2021-06-12', 'Triple', 2, 0, 2, 0, 0),
(19, 'RoyDoble', 'Ags', '2021-06-10', '2021-06-11', 'Doble', 2, 0, 2, 0, 0),
(20, 'Roydoble2', 'Ags', '2021-06-10', '2021-06-11', 'Doble', 2, 0, 2, 0, 0),
(21, 'Roy21', 'Ags', '2021-06-10', '2021-06-11', 'Doble', 2, 0, 2, 0, 0),
(22, '', '', '0000-00-00', '0000-00-00', 'Doble', 2, 0, 0, 0, 0),
(23, 'Yisus', 'Calvillo', '2021-06-09', '2021-06-16', 'Doble', 2, 1, 1, 7, 0),
(24, 'olis', 'muy lejos', '2021-06-09', '2021-06-12', 'Doble', 2, 1, 0, 2, 0),
(25, 'Angel Ernesto Max', 'Ags', '2021-06-12', '2021-06-13', 'Triple', 2, 1, 2, 0, 950),
(26, '', '', '0000-00-00', '0000-00-00', 'Triple', 2, 0, 0, 0, 0),
(27, '', '', '0000-00-00', '0000-00-00', 'Triple', 2, 0, 0, 0, 0),
(28, '', '', '0000-00-00', '0000-00-00', 'Triple', 2, 0, 0, 0, 0),
(29, 'Ganyu', 'LIyue', '2021-06-02', '2021-06-15', 'Triple', 2, 1, 1, 0, 0),
(30, '', '', '0000-00-00', '0000-00-00', 'Triple', 2, 0, 0, 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitaciones`
--
ALTER TABLE `habitaciones`
  ADD PRIMARY KEY (`num_habitacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
