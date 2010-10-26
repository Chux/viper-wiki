<?php

require_once 'IResourceHandler.class.php';
require_once 'DatabaseConnector.class.php';
require_once 'Article.class.php';


class ArticleHandler implements iResourceHandler {

	
	function __construct() {
		//$this->data 	= $data;
	}

	
	function getElement( $data ) {

		$tResult = databaseConnector::query( "SELECT * FROM articles WHERE id = $data" );
		if( !isset( $tResult ) ) {
			return false;
		}
		$tFetchedData = mysql_fetch_assoc( $tResult );	

		$tArticle = new Article( $tFetchedData['id'], $tFetchedData['user_id'], $tFetchedData['type'], $tFetchedData['title'], $tFetchedData['content'], $tFetchedData['date_time'] );
		
		$tArticle->printArticle();
		return $tArticle;
	
	}

	// These should be implemented... Soon ;)
	public function putElement( $pIdentifier ) { }
	public function postElement( $pIdentifier ) { }
	public function deleteElement( $pIdentifier ) { }
	public function getCollection() { }
	public function putCollcetion() { }
	public function postCollection() { }
	public function deleteCollection() { }

}
