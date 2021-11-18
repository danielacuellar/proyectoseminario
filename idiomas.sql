-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2021 a las 21:33:12
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `idiomas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicio`
--

CREATE TABLE `ejercicio` (
  `IdEjercicio` int(11) NOT NULL,
  `Pregunta` varchar(200) NOT NULL,
  `Respuesta` varchar(200) NOT NULL,
  `URL` varchar(200) NOT NULL,
  `IdLeccion` int(11) NOT NULL,
  `Activo` int(11) NOT NULL,
  `IdTipoEjercicio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ejercicio`
--

INSERT INTO `ejercicio` (`IdEjercicio`, `Pregunta`, `Respuesta`, `URL`, `IdLeccion`, `Activo`, `IdTipoEjercicio`) VALUES
(10, 'hola', 'Nina', 'C:\\xampp\\htdocs\\Idiomas\\Idioma\\queqchi\\Basico\\Personas\\', 2, 1, 0),
(11, 'cual de estos es Hombre', 'Hombre', 'C:\\xampp\\htdocs\\Idiomas\\Idioma\\queqchi\\Basico\\Personas\\', 2, 1, 0),
(12, 'cual de estos es Hombre prueba', 'Hombre', 'C:\\xampp\\htdocs\\Idiomas\\Idioma\\queqchi\\Basico\\Personas\\', 4, 1, 0),
(13, 'hola prueba', 'Nina', 'C:\\xampp\\htdocs\\Idiomas\\Idioma\\queqchi\\Basico\\Personas\\', 5, 1, 0),
(14, 'Cual es uno', 'Hombre', 'C:\\xampp\\htdocs\\Idiomas\\Idioma\\queqchi\\Basico\\Personas\\', 7, 1, 0),
(15, 'cual es dos', 'Hombre', 'C:\\xampp\\htdocs\\Idiomas\\Idioma\\queqchi\\Basico\\Personas\\', 7, 1, 0),
(18, 'cual es dos', 'Hombre', 'C:\\xampp\\htdocs\\Idiomas\\Idioma\\queqchi\\Basico\\Personas\\', 2, 1, 1),
(19, 'Cual es uno', 'Hombre', 'C:\\xampp\\htdocs\\Idiomas\\Idioma\\queqchi\\Basico\\Personas\\', 2, 1, 2),
(22, 'elote', 'elote', 'C:xampphtdocsGuatidiIdiomasMamBasicoprueba 1Imagenes', 2, 1, 1),
(23, 'brocoli', 'brocoli', 'C:xampphtdocsGuatidiIdiomasMamBasicoprueba 1Imagenes', 2, 1, 1),
(24, 'qwe', 'qwe', 'C:xampphtdocsGuatidiIdiomas\\Mam\\Basico\\prueba 1\\Imagenes', 2, 1, 1),
(25, 'qwer', 'qwer', 'C:\\xampphtdocsGuatidiIdiomas\\Mam\\Basico\\prueba 1\\Imagenes', 2, 1, 1),
(26, '', '', 'C:\\xampphtdocsGuatidiIdiomas\\Mam\\Basico\\prueba 1\\Dibujos', 2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idiomas`
--

CREATE TABLE `idiomas` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Activo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `idiomas`
--

INSERT INTO `idiomas` (`id`, `Nombre`, `Activo`) VALUES
(1, 'Mam', 0),
(5, 'Ingles', 1),
(6, 'pokomchi', 1),
(7, 'Prueba', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lecciones`
--

CREATE TABLE `lecciones` (
  `IdLeccion` int(11) NOT NULL,
  `NombreLeccion` varchar(50) NOT NULL,
  `IdNivel` int(11) NOT NULL,
  `Activo` int(11) NOT NULL,
  `Orden` int(11) NOT NULL,
  `Imagen` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lecciones`
--

INSERT INTO `lecciones` (`IdLeccion`, `NombreLeccion`, `IdNivel`, `Activo`, `Orden`, `Imagen`) VALUES
(2, 'prueba 1', 1, 0, 1, '1.png'),
(4, 'Prueba 3', 1, 1, 2, '1.png'),
(5, 'Prueba 4', 1, 1, 3, '1.png'),
(6, 'Prueba 5', 1, 1, 4, '1.png'),
(7, 'Numeros', 1, 1, 5, '1.png'),
(9, 'Personas', 1, 1, 6, 'C:\\xampp\\htdocs\\Idiomas\\Lecciones\\1.png'),
(15, 'Animales', 1, 1, 7, 'C:\\xampp\\htdocs\\Idiomas\\Lecciones\\1.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `niveles`
--

CREATE TABLE `niveles` (
  `idNivel` int(11) NOT NULL,
  `NombreNivel` varchar(50) DEFAULT NULL,
  `IdIdioma` int(11) NOT NULL,
  `Activo` int(11) NOT NULL,
  `Orden` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `niveles`
--

INSERT INTO `niveles` (`idNivel`, `NombreNivel`, `IdIdioma`, `Activo`, `Orden`) VALUES
(1, 'Basico', 1, 1, 1),
(61, 'Intermedio', 1, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

CREATE TABLE `resultados` (
  `IdResultados` int(11) NOT NULL,
  `IdEjercicio` int(11) NOT NULL,
  `IdUsuario` int(11) NOT NULL,
  `Completado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `resultados`
--

INSERT INTO `resultados` (`IdResultados`, `IdEjercicio`, `IdUsuario`, `Completado`) VALUES
(1, 10, 4, 1),
(2, 10, 4, 1),
(3, 10, 4, 1),
(8, 11, 4, 1),
(9, 11, 4, 1),
(10, 11, 4, 1),
(18, 10, 11, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoejercicios`
--

CREATE TABLE `tipoejercicios` (
  `IdTipoEjercicio` int(11) NOT NULL,
  `TipoEjercicio` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipoejercicios`
--

INSERT INTO `tipoejercicios` (`IdTipoEjercicio`, `TipoEjercicio`) VALUES
(1, 'Dibujos'),
(2, 'Imagen_Idioma'),
(3, 'Imagen_Esp'),
(4, 'Texto'),
(5, 'Audio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `NombreUsuario` varchar(50) NOT NULL,
  `ApellidoUsuario` varchar(50) NOT NULL,
  `CorreoUsuario` varchar(50) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `ContrasenaUsuario` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `NombreUsuario`, `ApellidoUsuario`, `CorreoUsuario`, `Usuario`, `ContrasenaUsuario`) VALUES
(2, 'Daniela', 'Cuellar', 'daniela', 'dcuellar', '1234'),
(3, 'prueba', 'prueba', 'prueba', 'prueba', '1234'),
(4, 'Prueba', 'Prueba', 'Prueba', 'Prueballave', 'c893bad68927b457dbed39460e6afd62'),
(5, 'hola', 'hola', 'hola', 'hola', '4d186321c1a7f0f354b297e8914ab240'),
(6, 'HOLA1', 'HOLA1', 'HOLA1', 'HOLA1', 'HOLA1'),
(7, 'HOLA12', 'HOLA12', 'HOLA12', 'HOLA12', 'HOLA12'),
(8, 'HOLA12', 'HOLA12', 'HOLA12', 'HOLA123', 'HOLA12'),
(9, 'HOLA12', 'HOLA12', 'HOLA12', 'HOLA1234', 'HOLA12'),
(10, 'HOLA12', 'HOLA12', 'HOLA12', 'HOLA12345', 'HOLA12'),
(11, 'asd', 'asd', 'asd', 'asd', '7815696ecbf1c96e6894b779456d330e');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_admin`
--

CREATE TABLE `usuario_admin` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `Contrasena` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_admin`
--

INSERT INTO `usuario_admin` (`id`, `Nombre`, `Apellido`, `Usuario`, `Contrasena`) VALUES
(1, 'Administrador', 'Administrador', 'admin', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejercicio`
--
ALTER TABLE `ejercicio`
  ADD PRIMARY KEY (`IdEjercicio`),
  ADD KEY `IdLeccion` (`IdLeccion`),
  ADD KEY `IdTipoEjercicio` (`IdTipoEjercicio`);

--
-- Indices de la tabla `idiomas`
--
ALTER TABLE `idiomas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `lecciones`
--
ALTER TABLE `lecciones`
  ADD PRIMARY KEY (`IdLeccion`),
  ADD UNIQUE KEY `Orden` (`Orden`),
  ADD KEY `IdNivel` (`IdNivel`);

--
-- Indices de la tabla `niveles`
--
ALTER TABLE `niveles`
  ADD PRIMARY KEY (`idNivel`),
  ADD UNIQUE KEY `Orden` (`Orden`),
  ADD KEY `IdIdioma` (`IdIdioma`);

--
-- Indices de la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD PRIMARY KEY (`IdResultados`),
  ADD KEY `IdEjercicio` (`IdEjercicio`),
  ADD KEY `IdUsuario` (`IdUsuario`);

--
-- Indices de la tabla `tipoejercicios`
--
ALTER TABLE `tipoejercicios`
  ADD PRIMARY KEY (`IdTipoEjercicio`),
  ADD KEY `IdTipoEjercicio` (`IdTipoEjercicio`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario_admin`
--
ALTER TABLE `usuario_admin`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ejercicio`
--
ALTER TABLE `ejercicio`
  MODIFY `IdEjercicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `idiomas`
--
ALTER TABLE `idiomas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `lecciones`
--
ALTER TABLE `lecciones`
  MODIFY `IdLeccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `niveles`
--
ALTER TABLE `niveles`
  MODIFY `idNivel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT de la tabla `resultados`
--
ALTER TABLE `resultados`
  MODIFY `IdResultados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `tipoejercicios`
--
ALTER TABLE `tipoejercicios`
  MODIFY `IdTipoEjercicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejercicio`
--
ALTER TABLE `ejercicio`
  ADD CONSTRAINT `ejercicio_ibfk_1` FOREIGN KEY (`IdLeccion`) REFERENCES `lecciones` (`IdLeccion`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `lecciones`
--
ALTER TABLE `lecciones`
  ADD CONSTRAINT `lecciones_ibfk_1` FOREIGN KEY (`IdNivel`) REFERENCES `niveles` (`idNivel`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `niveles`
--
ALTER TABLE `niveles`
  ADD CONSTRAINT `niveles_ibfk_1` FOREIGN KEY (`IdIdioma`) REFERENCES `idiomas` (`id`);

--
-- Filtros para la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD CONSTRAINT `resultados_ibfk_1` FOREIGN KEY (`IdEjercicio`) REFERENCES `ejercicio` (`IdEjercicio`) ON UPDATE CASCADE,
  ADD CONSTRAINT `resultados_ibfk_2` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
