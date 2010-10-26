<?php 
class databaseConnector {
		
  	private $mDBHost = 'localhost'; //Most Likely localhost
  	private $mDBUsername = 'viper'; //Your username
  	private $mDBPassword = 'wiki'; //Your password
  	private $mDBName = 'viper_wiki'; // Database Name

	public function gotConnection() {
		if(!mysql_connect( $this->mDBHost, $this->mDBUsername, $this->mDBPassword )) {
			return false;
		}
		mysql_select_db( $this->mDBName );
		return true;
	}

  	public function query( $pSQL ) {
		$this->gotConnection();
		return mysql_query( $pSQL );
	}

}
