<?php

require_once 'APIController.class.php';
//require_once 'ArticleHandler.class.php';

echo "<pre>";
var_dump($_GET);
echo "</pre>";


$ac = new APIController();
$ac->sendToHandler();



?>
