<?php

Class Db {

 	private $host = "localhost";
    private $username = "root";
    private $password = "root";
    private $database = "viper_wiki";
    
   public function __construct() {
       $this->connect();
   }

   private function connect() {
       mysql_connect($this->host, $this->username, $this->password);
       mysql_select_db($this->database);
   }
   
   public function executeQuery($SQL) {
     $success = TRUE;
     if(!$this->Connection) {
        $success = FALSE;
        return $success;
     }
     $query = mysql_query($SQL);
     if(!$query) {
        $this->SetErrorMessage();
        $success = FALSE;
     }
     else {
        $this->affectedRows = mysql_affected_rows();
     }
     return $success;
  }
  

	

}
?>