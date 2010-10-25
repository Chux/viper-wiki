-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Värd: localhost
-- Skapad: 22 oktober 2010 kl 15:02
-- Serverversion: 5.1.37
-- PHP-version: 5.2.11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databas: `viper_wiki`
--

-- --------------------------------------------------------

--
-- Struktur för tabell `articles`
--

CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `type` varchar(128) NOT NULL,
  `title` varchar(128) DEFAULT NULL,
  `content` varchar(128) DEFAULT NULL,
  `date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Data i tabell `articles`
--

INSERT INTO `articles` VALUES(1, 1, '', '===Once there was a hotdog===', 'this particular ''''''hotdog'''''' was ''''quite'''' hot and so it seemed that was its intention', '2010-10-22 14:50:44');
INSERT INTO `articles` VALUES(2, 2, '', 'hamburgers', 'I like hamburgers I think they all should be open source and exists a apps for you Iphone [[wiki page]]l 3 ===', '2010-10-22 14:50:44');
INSERT INTO `articles` VALUES(3, 3, '', 'wikitalk', 'I was thinking about wikis and wanted to talk about them in a recent article [[link to recent wikitalk]]', '2010-10-22 14:54:42');

-- --------------------------------------------------------

--
-- Struktur för tabell `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Data i tabell `users`
--

