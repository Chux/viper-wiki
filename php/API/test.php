<?php

require('wikiSyntaxConverter.class.php');

$result = WikiSyntaxConverter::convertToHTML($_POST['wikisyntax']);
print_r($result); 

	
echo "<pre>";
var_dump($_GET);
echo "</pre>";

echo "<form name='wiki' action='' method='POST'>
	 wikiSomething:<textarea name='wikisyntax' COLS=40 ROWS=6></TEXTAREA>
	 <P><input type=submit value='submit'> 
	 </form>"

?>