<?php

require_once 'APIController.class.php';

$a = new APIController();
$a->sendToHandler();

$s = $_SERVER[ 'REQUEST_URI' ];
print_r($s);


?>