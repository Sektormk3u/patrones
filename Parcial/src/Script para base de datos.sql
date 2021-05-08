CREATE SCHEMA `parcial`;
CREATE TABLE `parcial`.`ventas` (
  `idventas` INT NOT NULL,
  `litros` DOUBLE NULL,
  `monto` DOUBLE NULL,
  `fecha` DATETIME NULL,
  PRIMARY KEY (`idventas`));

