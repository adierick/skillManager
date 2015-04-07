-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema skillmanager
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema skillmanager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `skillmanager` DEFAULT CHARACTER SET utf8 ;
USE `skillmanager` ;

-- -----------------------------------------------------
-- Table `skillmanager`.`bu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`bu` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `label` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL DEFAULT NULL,
  `trs_label_key` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`cv_cptsmetier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`cv_cptsmetier` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `job` VARCHAR(255) NULL DEFAULT NULL,
  `specificities` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`cv_cptstech`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`cv_cptstech` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `technologies` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`cv_exppro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`cv_exppro` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `client` VARCHAR(255) NULL DEFAULT NULL,
  `activityclient` VARCHAR(255) NULL DEFAULT NULL,
  `place` VARCHAR(255) NULL DEFAULT NULL,
  `fonction` VARCHAR(255) NULL DEFAULT NULL,
  `datebegin` DATETIME NULL DEFAULT NULL,
  `dateend` DATETIME NULL DEFAULT NULL,
  `summarymission` TEXT NULL DEFAULT NULL,
  `detailsmission` VARCHAR(255) NULL DEFAULT NULL,
  `activitymission` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`cv_expsign`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`cv_expsign` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `client` VARCHAR(255) NULL DEFAULT NULL,
  `mission` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`cv_school`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`cv_school` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `title` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`cv_personfields`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`cv_personfields` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `age` TINYINT(4) NULL DEFAULT NULL,
  `function` VARCHAR(255) NULL DEFAULT NULL,
  `yearsexp` TINYINT(4) NULL DEFAULT NULL,
  `datedispo` DATETIME NULL DEFAULT NULL,
  `lastschool` VARCHAR(255) NULL DEFAULT NULL,
  `id_expsign` INT(11) NULL DEFAULT NULL,
  `id_cptstech` INT(11) NULL DEFAULT NULL,
  `id_cptsmetier` INT(11) NULL DEFAULT NULL,
  `id_school` INT(11) NULL DEFAULT NULL,
  `id_exppro` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `personcv_id_idx` (`id_expsign` ASC),
  INDEX `cptstech_id_idx` (`id_cptstech` ASC),
  INDEX `cptsmetier_id_idx` (`id_cptsmetier` ASC),
  INDEX `school_id_idx` (`id_school` ASC),
  INDEX `exppro_id_idx` (`id_exppro` ASC),
  CONSTRAINT `cptsmetier_id`
    FOREIGN KEY (`id_cptsmetier`)
    REFERENCES `skillmanager`.`cv_cptsmetier` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `cptstech_id`
    FOREIGN KEY (`id_cptstech`)
    REFERENCES `skillmanager`.`cv_cptstech` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `exppro_id`
    FOREIGN KEY (`id_exppro`)
    REFERENCES `skillmanager`.`cv_exppro` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `expsign_id`
    FOREIGN KEY (`id_expsign`)
    REFERENCES `skillmanager`.`cv_expsign` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `school_id`
    FOREIGN KEY (`id_school`)
    REFERENCES `skillmanager`.`cv_school` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`file`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`file` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `type` VARCHAR(30) NULL DEFAULT NULL,
  `size` INT(11) NULL DEFAULT NULL,
  `content` MEDIUMBLOB NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL DEFAULT NULL,
  `trs_label_key` VARCHAR(45) NULL DEFAULT NULL,
  `category_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `category_id` (`category_id` ASC),
  CONSTRAINT `category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `skillmanager`.`category` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`person` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `matricule` VARCHAR(45) NULL DEFAULT NULL,
  `id_bu` INT(11) NULL DEFAULT NULL,
  `admin` TINYINT(1) NULL DEFAULT NULL,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `id_cv_personfields` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `bu_id_idx` (`id_bu` ASC),
  INDEX `cv_personfields_id_idx` (`id_cv_personfields` ASC),
  CONSTRAINT `bu_id`
    FOREIGN KEY (`id_bu`)
    REFERENCES `skillmanager`.`bu` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `cv_personfields_id`
    FOREIGN KEY (`id_cv_personfields`)
    REFERENCES `skillmanager`.`cv_personfields` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`picture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`picture` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `picture_name` VARCHAR(45) NULL DEFAULT NULL,
  `picture_data` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillmanager`.`skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillmanager`.`skill` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `person_id` INT(11) NOT NULL,
  `level` INT(11) NULL DEFAULT NULL,
  `item_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `person_id_idx` (`person_id` ASC),
  INDEX `item_id_idx` (`item_id` ASC),
  CONSTRAINT `item_id`
    FOREIGN KEY (`item_id`)
    REFERENCES `skillmanager`.`item` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `person_id`
    FOREIGN KEY (`person_id`)
    REFERENCES `skillmanager`.`person` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
