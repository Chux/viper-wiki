<?php

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

echo json_encode($search);
?>