<?php

require_once('Db.class.php');

$database = new Db();

$result = mysql_query("SELECT * FROM articles");

print_r($result);


