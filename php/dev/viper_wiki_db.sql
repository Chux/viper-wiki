-- phpMyAdmin SQL Dump
-- version 3.3.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 25, 2010 at 10:56 AM
-- Server version: 5.1.51
-- PHP Version: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

-- 
--
-- Database: `viper_wiki`
--
CREATE DATABASE `viper_wiki` DEFAULT CHARACTER SET utf8 COLLATE utf8_swedish_ci;
USE `viper_wiki`;

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE IF NOT EXISTS `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `type` varchar(128) NOT NULL,
  `title` varchar(128) DEFAULT NULL,
  `content` varchar(128) DEFAULT NULL,
  `date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`id`, `user_id`, `type`, `title`, `content`, `date_time`) VALUES
(1, 1, '', '===Once there was a hotdog===', 'this particular ''''''hotdog'''''' was ''''quite'''' hot and so it seemed that was its intention', '2010-10-22 14:50:44'),
(2, 2, '', 'hamburgers', 'I like hamburgers I think they all should be open source and exists a apps for you Iphone [[wiki page]]l 3 ===', '2010-10-22 14:50:44'),
(3, 3, '', 'wikitalk', 'I was thinking about wikis and wanted to talk about them in a recent article [[link to recent wikitalk]]', '2010-10-22 14:54:42');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'mrViper', 'wiki'),
(2, 'msWiper', 'fish');
