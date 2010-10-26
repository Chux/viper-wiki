<?php
//Supress all notice/warning messages
error_reporting(E_ALL ^ (E_NOTICE | E_WARNING));

require_once 'APIController.class.php';


echo "<pre>";
var_dump($_GET);
echo "</pre>";

$url = 	$_GET['request']; 
$ac = new APIController($url);
$ac->processUrl();





?>
