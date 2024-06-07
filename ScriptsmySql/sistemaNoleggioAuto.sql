-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbNoleggioAuto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbNoleggioAuto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbNoleggioAuto` DEFAULT CHARACTER SET utf8 ;
USE `dbNoleggioAuto` ;

-- -----------------------------------------------------
-- Table `dbNoleggioAuto`.`UtentiRegistrati`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbNoleggioAuto`.`UtentiRegistrati` (
  `Id` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Cognome` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `AnnoConseguimentoPatente` INT NOT NULL,
  `AnnoScadenzaPatente` INT NOT NULL,
  `NumeroPatente` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `email_UNIQUE` (`Email` ASC) VISIBLE,
  UNIQUE INDEX `NumeroPatente_UNIQUE` (`NumeroPatente` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbNoleggioAuto`.`Auto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbNoleggioAuto`.`Auto` (
  `id` INT NOT NULL,
  `Targa` VARCHAR(10) NOT NULL,
  `numPostiPasseggeri` INT NOT NULL,
  `PriceDay` FLOAT NOT NULL,
  `TipoAlimentazione` VARCHAR(20) NOT NULL,
  `PotenzaMotore` INT NOT NULL,
  `inServizio` BIT NOT NULL,
  `segmento` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `targa_UNIQUE` (`Targa` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbNoleggioAuto`.`ServiziAssicurativi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbNoleggioAuto`.`ServiziAssicurativi` (
  `Id` INT NOT NULL,
  `descrizione` VARCHAR(100) NULL,
  `prezzoPrefissato` FLOAT NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbNoleggioAuto`.`NoleggiAuto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbNoleggioAuto`.`NoleggiAuto` (
  `Id` INT NOT NULL,
  `DataRitiroAuto` VARCHAR(10) NOT NULL,
  `DataConsegnaAuto` VARCHAR(10) NOT NULL,
  `PrezzoNoleggio` FLOAT NOT NULL,
  `Auto` INT NOT NULL,
  `UtenteRegistrato` INT NOT NULL,
  `GuidatoreSupplementare` INT NULL,
  `ServizioAssicurativo` INT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_NoleggiAuto_Auto1_idx` (`Auto` ASC) VISIBLE,
  INDEX `fk_NoleggiAuto_UtentiRegistrati1_idx` (`UtenteRegistrato` ASC) VISIBLE,
  INDEX `fk_NoleggiAuto_UtentiRegistrati2_idx` (`GuidatoreSupplementare` ASC) VISIBLE,
  INDEX `fk_NoleggiAuto_ServiziAssicurativi1_idx` (`ServizioAssicurativo` ASC) VISIBLE,
  CONSTRAINT `fk_NoleggiAuto_Auto1`
    FOREIGN KEY (`Auto`)
    REFERENCES `dbNoleggioAuto`.`Auto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NoleggiAuto_UtentiRegistrati1`
    FOREIGN KEY (`UtenteRegistrato`)
    REFERENCES `dbNoleggioAuto`.`UtentiRegistrati` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NoleggiAuto_UtentiRegistrati2`
    FOREIGN KEY (`GuidatoreSupplementare`)
    REFERENCES `dbNoleggioAuto`.`UtentiRegistrati` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NoleggiAuto_ServiziAssicurativi1`
    FOREIGN KEY (`ServizioAssicurativo`)
    REFERENCES `dbNoleggioAuto`.`ServiziAssicurativi` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbNoleggioAuto`.`OptionalAuto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbNoleggioAuto`.`OptionalAuto` (
  `Id` INT NOT NULL,
  `descrizione` VARCHAR(100) NULL,
  `prezzoPrefissato` FLOAT NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbNoleggioAuto`.`OptionalAuto_has_NoleggiAuto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbNoleggioAuto`.`OptionalAuto_has_NoleggiAuto` (
  `OptionalAuto` INT NOT NULL,
  `NoleggioAuto` INT NOT NULL,
  PRIMARY KEY (`OptionalAuto`, `NoleggioAuto`),
  INDEX `fk_OptionalAuto_has_NoleggiAuto_NoleggiAuto1_idx` (`NoleggioAuto` ASC) VISIBLE,
  INDEX `fk_OptionalAuto_has_NoleggiAuto_OptionalAuto1_idx` (`OptionalAuto` ASC) VISIBLE,
  CONSTRAINT `fk_OptionalAuto_has_NoleggiAuto_OptionalAuto1`
    FOREIGN KEY (`OptionalAuto`)
    REFERENCES `dbNoleggioAuto`.`OptionalAuto` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OptionalAuto_has_NoleggiAuto_NoleggiAuto1`
    FOREIGN KEY (`NoleggioAuto`)
    REFERENCES `dbNoleggioAuto`.`NoleggiAuto` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
