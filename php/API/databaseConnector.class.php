<?php 
class databaseConnector {
		
  	static private $mDBHost = 'localhost'; //Most Likely localhost
  	static private $mDBUsername = 'viper'; //Your username
  	static private $mDBPassword = 'wiki'; //Your password
  	static private $mDBName = 'viper_wiki'; // Database Name

	public static function gotConnection() {
		if( !mysql_connect( 'localhost', 'viper', 'wiki' ) ) {
			return false;
		}
		mysql_select_db( 'viper_wiki' );
		return true;
	}

  	public static function query( $pSQL ) {
		self::gotConnection();
		return mysql_query( $pSQL );
	}

}
