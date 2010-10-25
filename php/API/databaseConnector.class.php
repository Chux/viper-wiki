<?php 
	class databaseConnector {

	public $mysql;
  	private $mDbHost = 'localhost'; //Most Likely localhost
  	private $DbUsername = 'viper'; //Your username
  	private $DbPassword = 'wiki'; //Your password
  	private $DbName = 'viper_wiki'; // Database Name

  	function __construct(){
  		//Start the Connection
 	 	$this->mysql = new mysqli($this->dbHost, $this->dbUsername, $this->dbPassword, $this->dbName);
  		if (mysqli_connect_errno()){
        	printf("Connect failed: %s\n", mysqli_connect_error());
        exit();
    	} else {
     	  echo 'connection made';
    	}
  	}
  	
  	public function query($sql){
    	$query = $sql;
    	self::preparedStatement($query);
	}

	public function preparedStatement($query) { ### parameter $query added
    	if ($stmt = $this->db->prepare($query)) { 
        /* execute statement */
        $stmt->execute();

        /* bind result variables */
        $stmt->bind_result($name, $code);

        /* fetch values */
        while ($stmt->fetch()) {
            printf ("%s (%s)\n", $name, $code);
        }

        /* close statement */
        $stmt->close();	    
   	 	}
	}

	public function __destruct(){
		
	}

}

$db = new DatabaseConnector();
?>