-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 16, 2018 at 06:12 PM
-- Server version: 5.6.38
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `weather_logs`
--
CREATE DATABASE IF NOT EXISTS `weather_logs` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `weather_logs`;

-- --------------------------------------------------------

--
-- Table structure for table `chanthaburi_aws`
--

DROP TABLE IF EXISTS `chanthaburi_aws`;
CREATE TABLE IF NOT EXISTS `chanthaburi_aws` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `of_date` date NOT NULL,
  `at_date` varchar(8) NOT NULL,
  `at_time` varchar(8) NOT NULL,
  `wind_speed` float NOT NULL,
  `wind_direction` float NOT NULL,
  `wind_direction_text` varchar(16) NOT NULL,
  `gust_wind_speed` float NOT NULL,
  `gust_wind_direction` float NOT NULL,
  `gust_wind_direction_text` varchar(16) NOT NULL,
  `temperature` float NOT NULL,
  `precipitation` float NOT NULL,
  `pressure` float NOT NULL,
  `humidity` float NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
