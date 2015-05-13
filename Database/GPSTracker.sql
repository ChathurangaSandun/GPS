SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `a6853605_gps` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `a6853605_gps` ;

-- -----------------------------------------------------
-- Table `a6853605_gps`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `a6853605_gps`.`Person` (
  `imeiNumber` VARCHAR(45) NOT NULL,
  `personName` VARCHAR(45) NULL,
  PRIMARY KEY (`imeiNumber`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `a6853605_gps`.`Location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `a6853605_gps`.`Location` (
  `imeiNumber` VARCHAR(45) NOT NULL,
  `latitude` FLOAT NOT NULL,
  `longitude` FLOAT NOT NULL,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  PRIMARY KEY (`imeiNumber`, `latitude`, `longitude`, `date`, `time`),
  CONSTRAINT `imeiNumber`
    FOREIGN KEY (`imeiNumber`)
    REFERENCES `a6853605_gps`.`Person` (`imeiNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
