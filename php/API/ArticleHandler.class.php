<?php

require_once 'IResourceHandler.class.php';
require_once 'DatabaseConnector.class.php';
require_once 'Article.class.php';


class ArticleHandler implements iResourceHandler {

	function __construct() {
		//$this->data 	= $data;
	}

	
	function getElement( $pIdentifier ) {

		if( is_numeric( $pIdentifier ) ) {
			$tResult = databaseConnector::query( "SELECT * FROM `articles` WHERE id = {$pIdentifier} LIMIT 1" );
		}
		else {
			$tResult = databaseConnector::query( "SELECT * FROM `articles` WHERE title = '{$pIdentifier}' LIMIT 1" );
		}

		$tFetchedData = mysql_fetch_assoc( $tResult );	
		if( !$tResult || $tFetchedData  == null) {
			return false;
		}

		$tArticle = new Article( $tFetchedData['id'], $tFetchedData['user_id'], $tFetchedData['type'], $tFetchedData['title'], $tFetchedData['content'], $tFetchedData['date_time'] );
		
		return $tArticle;
	
	}

	// These should be implemented... Soon ;)
	public function putElement( $pIdentifier ) {

		$tQuery = databaseConnector::query( "	UPDATE `articles` 
												SET `articles`.`title` = {$pIdentifier['title']} , 
													`articles`.`content` = {$pIdentifier['content']},
													`articles`.`date_time` = NOW()
												WHERE `articles`.`id` = {$pIdentifier['id']} 
											");
		return $pIdentifier['id'];

	}	
	
	public function postElement( $pIdentifier ) {
		$tQuery = databaseConnector::query(	"INSERT INTO `articles` ( id, user_id, type, title, content, date_time)
											VALUES ( null, null, null, {$pIdentifier['title']}, {$pIdentifier['content']}, NOW() ) ");
		$tArticleId = mysql_insert_id();
	
		return $tArticleId ;
	}
	
	
	
	public function deleteElement( $pIdentifier ) { }

	public function getCollection() { 
		$tResult = databaseConnector::query( "SELECT * FROM articles GROUP BY title" );
		if( !$tResult && mysql_num_rows( $tResult ) == 0 ) {
			return false;
		}
		else {
			$tArticles = null;
			while( $tRow =  mysql_fetch_assoc( $tResult ) ) {
				// Create'em without content..
				$tArticles[] = new Article( $tRow['id'], $tRow['user_id'], $tRow['type'], $tRow['title'], "", $tRow['date_time'] );
			}
			return $tArticles;
		}

	}

	public function putCollcetion() { }
	public function postCollection() { }
	public function deleteCollection() { }

}
