<?php
// Uncomment to get all warnings, errors, notices and stuff
// ini_set('display_errors', 1); ini_set('log_errors', 1); ini_set('error_log', dirname(__FILE__) . '/error_log.txt'); error_reporting(E_ALL);

//Supress all notice/warning messages
error_reporting( E_ALL ^ (E_NOTICE | E_WARNING ) );

require_once 'APIController.class.php';


echo "<pre>";
	var_dump($_GET);
echo "</pre>";

$url = 	$_GET['request']; 
$ac = new APIController($url);
$ac->processUrl();
