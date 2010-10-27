<?php
require('wikiSyntaxConverter.class.php');
require('Article.class.php');

$result = WikiSyntaxConverter::convertToHTML($_POST['wikisyntax']);
print_r($result); 


	
echo "<pre>";
var_dump($_GET);
echo "</pre>";

echo "<form name='wiki' action='' method='POST'>
	 wikiSomething:<textarea name='wikisyntax' COLS=40 ROWS=6></TEXTAREA>
	 <P><input type=submit value='submit'> 
	 </form>";

header("Status: 200 OK");
$now = time();
$svar1 = array (
	'title'=> 'kompis nu går det undan' , 
	'content'=>'dfhshdfs fdsgfds sgdfsgds gfsd dfsbdsfbdsf bdfs bdf sbfdsbfdsbfds ',
	'userId' => 'Olle',
	'dateTime' => $now,
	'id' => 10	
	);
$svar2 = array (
	'title'=> 'kompis storsädes i min ficka' , 
	'content'=>'dfhshdfs fdsgfds sgdfsgds gfsd dfsbdsfbdsf bdfs bdf sbfdsbfdsbfds ',
	'userId' => 'Per',
	'dateTime' => $now,
	'id' => 11	
	);

$search[] = $svar1;   
$search[] = $svar2;   

?>