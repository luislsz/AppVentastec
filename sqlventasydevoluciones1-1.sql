SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `dbventastec` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `dbventastec`;

-- -----------------------------------------------------
-- Table `dbventastec`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbventastec`.`producto` ;

CREATE  TABLE IF NOT EXISTS `dbventastec`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `descripcion` VARCHAR(300) NOT NULL ,
  `stock` INT NOT NULL ,
  `valor` DECIMAL(11,2) NOT NULL ,
  `marca` VARCHAR(45) NOT NULL ,
  `modelo` VARCHAR(45) NOT NULL ,
  `tipo` VARCHAR(45) NOT NULL ,
  `gama` VARCHAR(45) NOT NULL ,
  `procesador` VARCHAR(45) NULL ,
  `memoriaInterna` VARCHAR(45) NULL ,
  `memoriaExterna` VARCHAR(45) NULL ,
  PRIMARY KEY (`idproducto`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbventastec`.`tipoUsuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbventastec`.`tipoUsuario` ;

CREATE  TABLE IF NOT EXISTS `dbventastec`.`tipoUsuario` (
  `idtipoUsuario` INT NOT NULL ,
  `nombreTU` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idtipoUsuario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbventastec`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbventastec`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `dbventastec`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT ,
  `codigo` VARCHAR(45) NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `tipoUsuario_idtipoUsuario` INT NOT NULL ,
  PRIMARY KEY (`idusuario`) ,
  CONSTRAINT `fk_usuario_tipoUsuario1`
    FOREIGN KEY (`tipoUsuario_idtipoUsuario` )
    REFERENCES `dbventastec`.`tipoUsuario` (`idtipoUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuario_tipoUsuario1` ON `dbventastec`.`usuario` (`tipoUsuario_idtipoUsuario` ASC) ;


-- -----------------------------------------------------
-- Table `dbventastec`.`compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbventastec`.`compra` ;

CREATE  TABLE IF NOT EXISTS `dbventastec`.`compra` (
  `codigoCompra` VARCHAR(45) NOT NULL ,
  `total` DECIMAL(13,2) NOT NULL ,
  `fechaCompra` DATETIME NOT NULL ,
  PRIMARY KEY (`codigoCompra`) ,
  CONSTRAINT `fk_compra_usuario1`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `dbventastec`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_compra_usuario1` ON `dbventastec`.`compra` (`usuario_idusuario` ASC) ;


-- -----------------------------------------------------
-- Table `dbventastec`.`proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbventastec`.`proveedor` ;

CREATE  TABLE IF NOT EXISTS `dbventastec`.`proveedor` (
  `idproveedor` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `concepto` VARCHAR(300) NOT NULL ,
  PRIMARY KEY (`idproveedor`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbventastec`.`detalleCompra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbventastec`.`detalleCompra` ;

CREATE  TABLE IF NOT EXISTS `dbventastec`.`detalleCompra` (
  `iddetalleCompra` INT NULL AUTO_INCREMENT ,
  `cantidadDetalle` INT NOT NULL ,
  `subtotal` DECIMAL(13,2) NOT NULL ,
  `almacenadoEn` VARCHAR(45)  ,
  `producto_idproducto` INT NOT NULL ,
  `compra_codigoCompra` VARCHAR(45) NOT NULL ,
  `proveedor_idproveedor` INT NOT NULL ,
  PRIMARY KEY (`iddetalleCompra`) ,
  CONSTRAINT `fk_detalleCompra_producto1`
    FOREIGN KEY (`producto_idproducto` )
    REFERENCES `dbventastec`.`producto` (`idproducto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleCompra_compra1`
    FOREIGN KEY (`compra_codigoCompra` )
    REFERENCES `dbventastec`.`compra` (`codigoCompra` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleCompra_proveedor1`
    FOREIGN KEY (`proveedor_idproveedor` )
    REFERENCES `dbventastec`.`proveedor` (`idproveedor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_detalleCompra_producto1` ON `dbventastec`.`detalleCompra` (`producto_idproducto` ASC) ;

CREATE INDEX `fk_detalleCompra_compra1` ON `dbventastec`.`detalleCompra` (`compra_codigoCompra` ASC) ;

CREATE INDEX `fk_detalleCompra_proveedor1` ON `dbventastec`.`detalleCompra` (`proveedor_idproveedor` ASC) ;


-- -----------------------------------------------------
-- Table `dbventastec`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbventastec`.`cliente` ;

CREATE  TABLE IF NOT EXISTS `dbventastec`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT ,
  `cedula` VARCHAR(45) NOT NULL ,
  `correo` VARCHAR(100) NOT NULL ,
  `nombres` VARCHAR(100) NOT NULL ,
  `apellidos` VARCHAR(100) NOT NULL ,
  `telefono` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idcliente`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbventastec`.`ventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbventastec`.`ventas` ;

CREATE  TABLE IF NOT EXISTS `dbventastec`.`ventas` (
  `codigoVentas` VARCHAR(45) NOT NULL ,
  `total` DECIMAL(13,2) NOT NULL ,
  `fechaVenta` DATETIME NOT NULL ,
  `consignacionCliente` DECIMAL(13,2) NOT NULL ,
  `devolucionRestantes` DECIMAL(13,2) NOT NULL ,
  `cliente_idcliente` INT NOT NULL ,
  PRIMARY KEY (`codigoVentas`) ,
  CONSTRAINT `fk_ventas_cliente1`
    FOREIGN KEY (`cliente_idcliente` )
    REFERENCES `dbventastec`.`cliente` (`idcliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_ventas_cliente1` ON `dbventastec`.`ventas` (`cliente_idcliente` ASC) ;


-- -----------------------------------------------------
-- Table `dbventastec`.`detalleVenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbventastec`.`detalleVenta` ;

CREATE  TABLE IF NOT EXISTS `dbventastec`.`detalleVenta` (
  `iddetalleVenta` INT NOT NULL AUTO_INCREMENT ,
  `cantidadDetalle` INT NOT NULL ,
  `subtotal` DECIMAL(13,2) NOT NULL ,
  `producto_idproducto` INT NOT NULL ,
  `ventas_codigoVentas` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`iddetalleVenta`) ,
  CONSTRAINT `fk_detalleVenta_producto1`
    FOREIGN KEY (`producto_idproducto` )
    REFERENCES `dbventastec`.`producto` (`idproducto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleVenta_ventas1`
    FOREIGN KEY (`ventas_codigoVentas` )
    REFERENCES `dbventastec`.`ventas` (`codigoVentas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_detalleVenta_producto1` ON `dbventastec`.`detalleVenta` (`producto_idproducto` ASC) ;

CREATE INDEX `fk_detalleVenta_ventas1` ON `dbventastec`.`detalleVenta` (`ventas_codigoVentas` ASC) ;


-- -----------------------------------------------------
-- Table `dbventastec`.`contabilizarSalidaProducto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbventastec`.`contabilizarSalidaProducto` ;

CREATE  TABLE IF NOT EXISTS `dbventastec`.`contabilizarSalidaProducto` (
  `iddetalleSalidaProducto` INT NOT NULL ,
  `cantsp` INT NOT NULL ,
  `fechasp` DATETIME NOT NULL ,
  `producto_idproducto` INT NOT NULL ,
  `usuario_idusuario` INT NOT NULL ,
  PRIMARY KEY (`iddetalleSalidaProducto`) ,
  CONSTRAINT `fk_contabilizarSalidaProducto_producto1`
    FOREIGN KEY (`producto_idproducto` )
    REFERENCES `dbventastec`.`producto` (`idproducto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contabilizarSalidaProducto_usuario1`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `dbventastec`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_contabilizarSalidaProducto_producto1` ON `dbventastec`.`contabilizarSalidaProducto` (`producto_idproducto` ASC) ;

CREATE INDEX `fk_contabilizarSalidaProducto_usuario1` ON `dbventastec`.`contabilizarSalidaProducto` (`usuario_idusuario` ASC) ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
