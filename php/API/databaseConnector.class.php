<?php 
	class databaseConnector {
		
  	private $mDbHost = 'localhost'; //Most Likely localhost
  	private $DbUsername = 'root'; //Your username
  	private $DbPassword = 'root'; //Your password
  	private $DbName = 'viper_wiki'; // Database Name

  	function __construct(){
  		//Start the Connection
 	 	$mysql = new mysqli($this->dbHost, $this->dbUsername, $this->dbPassword, $this->dbName)
  		or die ('Could not connect to the database server : ' . $mysql->connect_error);
  			
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

?>