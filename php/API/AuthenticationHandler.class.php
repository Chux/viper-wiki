<?php
require_once 'DatabaseConnector.class.php';

// I hate this very non-REST class ;) -Viktor
class AuthenticationHandler implements IResourceHandler {

	private $mAuthenticated;

	public function __construct( ) {

		session_start();
		if( isset( $_SESSION['userId']) ) {
			$this->mAuthenticated = "true";
		}
		else {
			$this->mAuthenticated = "false";
		}

	}

	private function logIn( $pUsername, $pPassword ) {

		$pUsername = mysql_escape_string( $pUsername );
		$pPassword = mysql_escape_string( $pPassword );
		$tResult = databaseConnector::query(	"SELECT id FROM users
							WHERE username = '$pUsername'
							AND password = '$pPassword'
							LIMIT 1" );
		if( $tResult ) {
		  	if( mysql_num_rows( $tResult ) == 1 ) {
				$tRow = mysql_fetch_assoc( $tResult );
				$_SESSION['userId'] = $tRow['id'];
				return true;		
			}
		}
		echo 'fail';
		return false;

	}

	private function isAuthenticated() {
		return $this->mAuthenticated;
	}

	private function logOut() {
		session_unset();
		return session_destroy();
	}

	
	public function getElement( $bleh ) {
		$tArray['loggedIn'] = $this->isAuthenticated(); 
		return $tArray;	
	}

	public function putElement( $bleh ) { }

	public function postElement( $pData ) { 
		return $this->logIn( $pData['username'], $pData['password'] );
	}

	public function deleteElement( $bleh ) {
		return $this->logOut();		
	}

	// These doesnt have to be implemented damn it...
	public function getCollection( ) {}
	public function putCollection( ) {}
	public function postCollection( ) {}
	public function deleteCollection( ) {}

}
