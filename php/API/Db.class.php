<?php

Class Db {

	public $database;
	

	function __construct($database){		
		$this->database = $database; 	
	}
	
	function getConnection(){
	
		$conn = mysqli_connect("localhost" ,"root","" );
		$db_handle = mysqli_select_db($conn, $this->database);
		if (mysqli_connect_errno()) {
			printf("Connect failed: %s\n", mysqli_connect_error());
			exit();
		}
		return $conn;
	}

	

}
?>