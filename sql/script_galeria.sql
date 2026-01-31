CREATE SCHEMA IF NOT EXISTS `GaleriaDeArte` DEFAULT CHARACTER SET utf8;
USE `GaleriaDeArte`;

CREATE TABLE IF NOT EXISTS `critico` (
  `rut` VARCHAR(12) NOT NULL,
  `nombre_critico` VARCHAR(100) NOT NULL,
  `especialidad` VARCHAR(50) NOT NULL,
  `anios_experiencia` INT NOT NULL,
  PRIMARY KEY (`rut`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `galeria` (
  `id_galeria` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `ciudad` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_galeria`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `cuadro` (
  `id_cuadro` VARCHAR(10) NOT NULL,
  `titulo_cuadro` VARCHAR(150) NOT NULL,
  `anio_creacion` INT NULL,
  `autor` VARCHAR(100) NULL,
  `id_galeria` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_cuadro`), -- CORREGIDO: PK propia del cuadro
  CONSTRAINT `fk_cuadro_galeria`
    FOREIGN KEY (`id_galeria`) -- CORREGIDO: Apunta a la galería
    REFERENCES `galeria` (`id_galeria`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `evaluacion` (
  `id_evaluacion` INT NOT NULL AUTO_INCREMENT,
  `calificacion` INT NOT NULL,
  `id_cuadro` VARCHAR(10) NOT NULL, -- CORREGIDO
  `critico_rut` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id_evaluacion`),
  CONSTRAINT `fk_evaluacion_critico`
    FOREIGN KEY (`critico_rut`)
    REFERENCES `critico` (`rut`),
  CONSTRAINT `fk_evaluacion_cuadro`
    FOREIGN KEY (`id_cuadro`) -- CORREGIDO
    REFERENCES `cuadro` (`id_cuadro`)
) ENGINE = InnoDB;
