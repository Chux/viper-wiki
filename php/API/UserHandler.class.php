<?php
require_once 'IResourceHandler.class.php';
require_once 'User.class.php';

class UserHandler implements IResourceHandler {

	private $method;
	private $data;
	
	function __construct($method, $data) {
		$this->method 	= $method;
		$this->data 	= $data;
	}

	public function getElement( $pIdentifier ) { 
		if( is_numeric( $pIdentifier ) ) {
			$tResult = databaseConnector::query( "SELECT * FROM users WHERE id={$pIdentifier} LIMIT 1");
		}
		else {
			$tResult = databaseConnector::query( "SELECT * FROM users WHERE username='{$pIdentifier}' LIMIT 1");
		}
		if( !$tResult ) {
			return false;
		}
		else {

			$tFetchedData = mysql_fetch_assoc( $tResult );
			if( $tFetchedData == false ) {
				return false;
			}	
			$tUser = new User( $tFetchedData['id'], $tFetchedData['username'], $tFetchedData['password'] );
			return $tUser;

		}
	}

	public function putElement( $pIdentifier ) { }
	public function postElement( $pIdentifier ) { }
	public function deleteElement( $pIdentifier ) { }

	public function getCollection() {

		$tResult = databaseConnector::query( "SELECT * FROM users");
		if( !$tResult ) {
			return false;
		}
		else {
			$tUsers = null;
			while( $tRow = mysql_fetch_assoc( $tResult ) ) {
				$tUsers[] = new User( $tRow['id'], $tRow['username'], $tRow['password'] );
			}	
			return $tUsers;

		}
		
	}


	public function putCollcetion() { }
	public function postCollection() { }
	public function deleteCollection() { }

}
