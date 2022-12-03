-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-12-2022 a las 04:52:34
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `bd_chat`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `ID` int(11) NOT NULL,
  `USUARIO` varchar(25) DEFAULT NULL,
  `CONTRASEÑA` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`ID`, `USUARIO`, `CONTRASEÑA`) VALUES
(1, 'juan', '12345678'),
(2, 'jose', '12345678'),
(4, 'josueAliaga', '12345678'),
(6, 'wilder', '12345678');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avatar`
--

CREATE TABLE `avatar` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(25) DEFAULT NULL,
  `URL` varchar(300) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `avatar`
--

INSERT INTO `avatar` (`ID`, `NOMBRE`, `URL`, `fecha_creacion`) VALUES
(1, 'foto', '#', '2022-11-28'),
(2, 'marco', '3', '2022-11-28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `ID` int(11) NOT NULL,
  `ASUNTO` varchar(300) DEFAULT NULL,
  `FECHA_ENVIO` date DEFAULT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  `ID_TIPO_MENSAJE` int(11) DEFAULT NULL,
  `ID_SALA` int(11) DEFAULT NULL,
  `ESTADO` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`ID`, `ASUNTO`, `FECHA_ENVIO`, `ID_USUARIO`, `ID_TIPO_MENSAJE`, `ID_SALA`, `ESTADO`) VALUES
(1, 'hola', '2022-11-24', 1, NULL, 1, '1'),
(2, 'como estas', '2022-11-24', 1, NULL, 1, '1'),
(3, 'bien y tu?', '2022-11-25', 3, 1, 1, 'activo'),
(4, 'HOLA', '2022-11-24', 1, 1, 3, 'activo'),
(5, 'igual', '2022-12-01', 1, 1, 1, 'ACTIVO'),
(6, 'hola', '2022-12-01', 1, 1, 4, 'activo'),
(7, 'como estas', '2022-12-01', 3, 1, 4, 'activo'),
(8, 'como estas', '2022-12-01', 1, 1, 3, 'activo'),
(9, 'bien', '2022-12-01', 3, 1, 3, 'activo'),
(10, 'bien y tu', '2022-12-02', 1, 1, 4, 'activo'),
(11, 'que bien', '2022-12-02', 3, 1, 4, 'activo'),
(12, 'como estam', '2022-12-02', 1, 1, 6, 'activo'),
(13, 'bieeeeen', '2022-12-02', 3, 1, 6, 'activo'),
(14, 'uno mas', '2022-12-02', 3, 1, 7, 'activo'),
(15, 'hola', '2022-12-02', 6, 1, 4, 'activo'),
(16, 'que miran', '2022-12-02', 6, 1, 6, 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte`
--

CREATE TABLE `reporte` (
  `ID` int(11) NOT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  `ID_REPORTE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reporte`
--

INSERT INTO `reporte` (`ID`, `ID_USUARIO`, `ID_REPORTE`) VALUES
(1, 3, 1),
(2, 5, 1),
(3, 1, 1),
(4, 3, 2),
(5, 1, 2),
(6, 1, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `ID` int(11) NOT NULL,
  `ID_TIPO_SALA` int(11) DEFAULT NULL,
  `FECHA_CREACION` date DEFAULT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `ID_AVATAR` int(11) DEFAULT NULL,
  `ESTADO` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`ID`, `ID_TIPO_SALA`, `FECHA_CREACION`, `NOMBRE`, `ID_AVATAR`, `ESTADO`) VALUES
(1, 1, '2022-11-24', 'contacto1', NULL, '1'),
(3, 1, '2022-11-24', 'dos', 1, 'activo'),
(4, 1, '2022-11-24', 'Chat General', 1, 'activo'),
(6, 2, '2022-12-02', 'Anime', 1, 'activo'),
(7, 3, '2022-12-02', 'musica', 1, 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_mensaje`
--

CREATE TABLE `tipo_mensaje` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(25) DEFAULT NULL,
  `URL` varchar(300) DEFAULT NULL,
  `ID_ADMINISTRADOR` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_mensaje`
--

INSERT INTO `tipo_mensaje` (`ID`, `NOMBRE`, `URL`, `ID_ADMINISTRADOR`) VALUES
(1, 'imagen', '1.jpg', 1),
(4, 'videos', 'vid.mp4', 1),
(5, 'musica', 'ConTigoEstare.mp3', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_reporte`
--

CREATE TABLE `tipo_reporte` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(25) DEFAULT NULL,
  `DESCRIPCION` varchar(300) DEFAULT NULL,
  `ID_ADMINISTRADOR` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_reporte`
--

INSERT INTO `tipo_reporte` (`ID`, `NOMBRE`, `DESCRIPCION`, `ID_ADMINISTRADOR`) VALUES
(1, 'spam', 'cuando incumple las normas de los mensajes', 1),
(2, 'inapropiado', 'mensajes inapropiado en el chat', 2),
(9, 'contenido +18', 'informacion prohibida', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_sala`
--

CREATE TABLE `tipo_sala` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(25) DEFAULT NULL,
  `DESCRIPCION` varchar(300) DEFAULT NULL,
  `ID_ADMINISTRADOR` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_sala`
--

INSERT INTO `tipo_sala` (`ID`, `NOMBRE`, `DESCRIPCION`, `ID_ADMINISTRADOR`) VALUES
(1, 'dual', 'para solo 2 personas', 1),
(2, 'grupal', 'chat para mas de 3 personas', 2),
(3, 'privado', 'sala privada ', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(25) DEFAULT NULL,
  `DESCRIPCION` varchar(300) DEFAULT NULL,
  `ID_ADMINISTRADOR` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`ID`, `NOMBRE`, `DESCRIPCION`, `ID_ADMINISTRADOR`) VALUES
(1, 'comun', 'usuario comun con el que comienza en la aplicacion', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL,
  `ALIAS` varchar(25) DEFAULT NULL,
  `NOMBRE` varchar(25) DEFAULT NULL,
  `DESCRIPCION` varchar(300) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `FECHA_REGISTRO` datetime DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `USUARIO` varchar(25) DEFAULT NULL,
  `CONTRASEÑA` varchar(30) DEFAULT NULL,
  `ID_AVATAR` int(11) DEFAULT NULL,
  `ID_TIPO_USUARIO` int(11) DEFAULT NULL,
  `ESTADO` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `ALIAS`, `NOMBRE`, `DESCRIPCION`, `EMAIL`, `FECHA_REGISTRO`, `FECHA_NACIMIENTO`, `USUARIO`, `CONTRASEÑA`, `ID_AVATAR`, `ID_TIPO_USUARIO`, `ESTADO`) VALUES
(1, 'juanito', 'juan', 'where what', 'juan.silva12121999@gmail.com', '2022-12-12 00:00:00', '1999-12-12', 'juan', '12345678', NULL, 1, 'Activo'),
(3, 'jose', 'jose', 'uno mas', 'jose@gmail.com', '2022-11-24 00:00:00', '2001-02-25', 'jose', '12345678', NULL, 1, 'Activo'),
(5, 'juan', 'juan alberto Silva Cayo', 'Fanta', 'juan@mail.com', '2022-11-29 00:00:00', '2022-11-29', 'jsilva', '12345678', NULL, 1, 'Activo'),
(6, 'yose', 'Jhoselin Adriana', 'Distraida', 'jhoselin@gmail.com', '2022-12-02 22:18:02', '2022-12-02', 'Jhoselin', '12345678', NULL, 1, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_sala`
--

CREATE TABLE `usuario_sala` (
  `ID` int(11) NOT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  `ID_SALA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_sala`
--

INSERT INTO `usuario_sala` (`ID`, `ID_USUARIO`, `ID_SALA`) VALUES
(2, 3, 1),
(4, 1, 1),
(11, 3, 4),
(12, 1, 4),
(14, 1, 3),
(15, 3, 3),
(16, 1, 6),
(18, 3, 6),
(19, 3, 7),
(22, 6, 4),
(24, 6, 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `avatar`
--
ALTER TABLE `avatar`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_id_us_men` (`ID_USUARIO`),
  ADD KEY `fk_id_ti_men` (`ID_TIPO_MENSAJE`),
  ADD KEY `fk_id_sa_men` (`ID_SALA`);

--
-- Indices de la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_id_us_re` (`ID_USUARIO`),
  ADD KEY `fk_id_re` (`ID_REPORTE`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_id_avartar` (`ID_AVATAR`),
  ADD KEY `fk_id_ti_sala` (`ID_TIPO_SALA`);

--
-- Indices de la tabla `tipo_mensaje`
--
ALTER TABLE `tipo_mensaje`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_id_administrador` (`ID_ADMINISTRADOR`);

--
-- Indices de la tabla `tipo_reporte`
--
ALTER TABLE `tipo_reporte`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_id_re_administrador` (`ID_ADMINISTRADOR`);

--
-- Indices de la tabla `tipo_sala`
--
ALTER TABLE `tipo_sala`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_id_sa_administrador` (`ID_ADMINISTRADOR`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_id_us_administrador` (`ID_ADMINISTRADOR`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_id_imagen` (`ID_AVATAR`),
  ADD KEY `fk_id_ti_usuario` (`ID_TIPO_USUARIO`);

--
-- Indices de la tabla `usuario_sala`
--
ALTER TABLE `usuario_sala`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_id_us_sa` (`ID_USUARIO`),
  ADD KEY `fk_id_sa` (`ID_SALA`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `avatar`
--
ALTER TABLE `avatar`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `reporte`
--
ALTER TABLE `reporte`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tipo_mensaje`
--
ALTER TABLE `tipo_mensaje`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tipo_reporte`
--
ALTER TABLE `tipo_reporte`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `tipo_sala`
--
ALTER TABLE `tipo_sala`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuario_sala`
--
ALTER TABLE `usuario_sala`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `fk_id_sa_men` FOREIGN KEY (`ID_SALA`) REFERENCES `sala` (`ID`),
  ADD CONSTRAINT `fk_id_ti_men` FOREIGN KEY (`ID_TIPO_MENSAJE`) REFERENCES `tipo_mensaje` (`ID`),
  ADD CONSTRAINT `fk_id_us_men` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`);

--
-- Filtros para la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD CONSTRAINT `fk_id_re` FOREIGN KEY (`ID_REPORTE`) REFERENCES `tipo_reporte` (`ID`),
  ADD CONSTRAINT `fk_id_us_re` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`);

--
-- Filtros para la tabla `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `fk_id_avartar` FOREIGN KEY (`ID_AVATAR`) REFERENCES `avatar` (`ID`),
  ADD CONSTRAINT `fk_id_ti_sala` FOREIGN KEY (`ID_TIPO_SALA`) REFERENCES `tipo_sala` (`ID`);

--
-- Filtros para la tabla `tipo_mensaje`
--
ALTER TABLE `tipo_mensaje`
  ADD CONSTRAINT `fk_id_administrador` FOREIGN KEY (`ID_ADMINISTRADOR`) REFERENCES `administrador` (`ID`);

--
-- Filtros para la tabla `tipo_reporte`
--
ALTER TABLE `tipo_reporte`
  ADD CONSTRAINT `fk_id_re_administrador` FOREIGN KEY (`ID_ADMINISTRADOR`) REFERENCES `administrador` (`ID`);

--
-- Filtros para la tabla `tipo_sala`
--
ALTER TABLE `tipo_sala`
  ADD CONSTRAINT `fk_id_sa_administrador` FOREIGN KEY (`ID_ADMINISTRADOR`) REFERENCES `administrador` (`ID`);

--
-- Filtros para la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD CONSTRAINT `fk_id_us_administrador` FOREIGN KEY (`ID_ADMINISTRADOR`) REFERENCES `administrador` (`ID`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_id_imagen` FOREIGN KEY (`ID_AVATAR`) REFERENCES `avatar` (`ID`),
  ADD CONSTRAINT `fk_id_ti_usuario` FOREIGN KEY (`ID_TIPO_USUARIO`) REFERENCES `tipo_usuario` (`ID`);

--
-- Filtros para la tabla `usuario_sala`
--
ALTER TABLE `usuario_sala`
  ADD CONSTRAINT `fk_id_sa` FOREIGN KEY (`ID_SALA`) REFERENCES `sala` (`ID`),
  ADD CONSTRAINT `fk_id_us_sa` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`);
COMMIT;