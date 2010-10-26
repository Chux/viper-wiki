<?php

require_once 'IResourceHandler.php';
require_once 'databaseConnector.class.php';
require_once 'Article.class.php';


class ArticleHandler implements IResourceHandler {

	
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

}

?>


