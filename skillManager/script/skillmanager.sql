-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 29 Août 2014 à 15:15
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `skillmanager`
--

-- --------------------------------------------------------

--
-- Structure de la table `bu`
--

CREATE TABLE IF NOT EXISTS `bu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `bu`
--

INSERT INTO `bu` (`id`, `label`) VALUES
(1, 'JAVA'),
(2, 'MICROSOFT'),
(3, 'BI'),
(4, 'MOBILITE');

-- --------------------------------------------------------

--
-- Structure de la table `file`
--

CREATE TABLE IF NOT EXISTS `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `content` mediumblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

-- --------------------------------------------------------
--
-- Structure de la table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `trs_label_key` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Structure de la table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `trs_label_key` varchar(45) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

ALTER TABLE `item`
  ADD CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
--
-- Contenu de la table `item`
--

INSERT INTO `item` (`id`, `code`, `trs_label_key`) VALUES
(1, 'SPRING', 'item.fwk.spring'),
(2, 'JAVA', 'item.java'),
(3, 'PHP', 'item.php'),
(4, 'SYMFONY2', 'item.fwk.symfony'),
(6, 'MySQL', 'MySQL'),
(7, 'BIRT', 'Birt'),
(8, 'MAVEN', 'Maven'),
(9, 'HIBERNATE', 'Hibernate'),
(10, 'ANDROID', 'Android');

-- --------------------------------------------------------




--
-- Structure de la table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `matricule` varchar(45) DEFAULT NULL,
  `id_bu` int(11) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bu_id_idx` (`id_bu`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `person`
--

INSERT INTO `person` (`id`, `firstname`, `lastname`, `matricule`, `id_bu`, `admin`, `login`, `password`) VALUES
(1, 'Francois-Xavier', 'DE WEVER', '00112', 3, 1, 'fdewever', '-5537611252501867718'),
(4, 'Antoine', 'BOURRE', '11234', 1, 0, 'abourre', '-5537611252501867718'),
(7, 'Sebastien', 'VANOUTRYVE', '164834', 1, 0, 'svanoutryve', '1234'),
(9, 'Admin', 'ADMIN', '1111', NULL, 1, 'admin', 'admin'),
(10, 'Thierry', 'CHEVALIER', '123456', 3, 1, 'tchevalier', '1234'),
(11, 'Guillaume', 'LHOMME', '23659', 1, 1, 'glhomme', '-1542838503490473174');

-- --------------------------------------------------------

--
-- Structure de la table `skill`
--

CREATE TABLE IF NOT EXISTS `skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `item_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `person_id_idx` (`person_id`),
  KEY `item_id_idx` (`item_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `skill`
--

INSERT INTO `skill` (`id`, `person_id`, `level`, `item_id`) VALUES
(1, 1, 5, 1),
(2, 1, 5, 2),
(4, 1, 4, 3),
(5, 4, 5, 2),
(6, 4, 4, 1),
(7, 1, 4, 10),
(8, 1, 5, 7),
(9, 1, 4, 9),
(10, 1, 4, 8),
(11, 1, 4, 6),
(12, 1, 0, 4),
(13, 11, 3, 10),
(14, 11, 5, 2);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `bu_id` FOREIGN KEY (`id_bu`) REFERENCES `bu` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
  
ALTER TABLE `person` ADD COLUMN `email` varchar(45) DEFAULT NULL;

--
-- Contraintes pour la table `skill`
--
ALTER TABLE `skill`
  ADD CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
