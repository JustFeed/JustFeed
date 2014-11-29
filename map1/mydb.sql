-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 08, 2014 at 07:51 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorieën`
--

CREATE TABLE IF NOT EXISTS `categorieën` (
  `id` int(11) NOT NULL,
  `naam` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `categorieën_has_takeaway`
--

CREATE TABLE IF NOT EXISTS `categorieën_has_takeaway` (
  `categorieën_id` int(11) NOT NULL,
  `Takeaway_id` int(11) NOT NULL,
  PRIMARY KEY (`categorieën_id`,`Takeaway_id`),
  KEY `fk_categorieën_has_Takeaway_Takeaway1_idx` (`Takeaway_id`),
  KEY `fk_categorieën_has_Takeaway_categorieën1_idx` (`categorieën_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `gerecht`
--

CREATE TABLE IF NOT EXISTS `gerecht` (
  `id` int(11) NOT NULL,
  `naam` varchar(100) DEFAULT NULL,
  `prijs` double DEFAULT NULL,
  `takeaway_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_gerecht_takeaway1_idx` (`takeaway_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `gerecht_has_order`
--

CREATE TABLE IF NOT EXISTS `gerecht_has_order` (
  `gerecht_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `aantal` int(11) DEFAULT NULL,
  PRIMARY KEY (`gerecht_id`,`order_id`),
  KEY `fk_gerecht_has_order_order1_idx` (`order_id`),
  KEY `fk_gerecht_has_order_gerecht1_idx` (`gerecht_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `klant`
--

CREATE TABLE IF NOT EXISTS `klant` (
  `id` int(11) NOT NULL,
  `naam` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `adres` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `emailadres` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `login` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kortingscode`
--

CREATE TABLE IF NOT EXISTS `kortingscode` (
  `id` int(11) NOT NULL,
  `percentvastbedrag` tinyint(1) DEFAULT NULL,
  `waarde` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `kortingscode_has_order`
--

CREATE TABLE IF NOT EXISTS `kortingscode_has_order` (
  `kortingscode_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`kortingscode_id`,`order_id`),
  KEY `fk_kortingscode_has_order_order1_idx` (`order_id`),
  KEY `fk_kortingscode_has_order_kortingscode1_idx` (`kortingscode_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) NOT NULL,
  `tijd` datetime DEFAULT NULL,
  `klant_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_klant1_idx` (`klant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `takeaway`
--

CREATE TABLE IF NOT EXISTS `takeaway` (
  `id` int(11) NOT NULL,
  `naam` varchar(45) DEFAULT NULL,
  `gratisleveringvanaf` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `vestiging`
--

CREATE TABLE IF NOT EXISTS `vestiging` (
  `id` int(11) NOT NULL,
  `naam` varchar(45) DEFAULT NULL,
  `postcode` int(11) DEFAULT NULL,
  `bezorgkosten` double DEFAULT NULL,
  `Takeaway_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Vestiging_Takeaway_idx` (`Takeaway_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `categorieën_has_takeaway`
--
ALTER TABLE `categorieën_has_takeaway`
  ADD CONSTRAINT `fk_categorieën_has_Takeaway_categorieën1` FOREIGN KEY (`categorieën_id`) REFERENCES `categorieën` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_categorieën_has_Takeaway_Takeaway1` FOREIGN KEY (`Takeaway_id`) REFERENCES `takeaway` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `gerecht`
--
ALTER TABLE `gerecht`
  ADD CONSTRAINT `fk_gerecht_takeaway1` FOREIGN KEY (`takeaway_id`) REFERENCES `takeaway` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `gerecht_has_order`
--
ALTER TABLE `gerecht_has_order`
  ADD CONSTRAINT `fk_gerecht_has_order_gerecht1` FOREIGN KEY (`gerecht_id`) REFERENCES `gerecht` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_gerecht_has_order_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `kortingscode_has_order`
--
ALTER TABLE `kortingscode_has_order`
  ADD CONSTRAINT `fk_kortingscode_has_order_kortingscode1` FOREIGN KEY (`kortingscode_id`) REFERENCES `kortingscode` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_kortingscode_has_order_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_order_klant1` FOREIGN KEY (`klant_id`) REFERENCES `klant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `vestiging`
--
ALTER TABLE `vestiging`
  ADD CONSTRAINT `fk_Vestiging_Takeaway` FOREIGN KEY (`Takeaway_id`) REFERENCES `takeaway` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
