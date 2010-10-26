<?php
	require_once('wikiSyntaxConverter.class.php');

$wsc = new WikiSyntaxConverter();
print_r($wsc);

echo "<pre>";
var_dump($_GET);
echo "</pre>";

echo "<form name='wiki' action='wikiSyntaxConverter.class.php' method='get'>
	 wikiSomething:<textarea name='wiki' COLS=40 ROWS=6></TEXTAREA>
	 <P><input type=submit value='submit'> 
	 </form>"

?>