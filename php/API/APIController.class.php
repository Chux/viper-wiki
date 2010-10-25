<?php

require_once 'ArticleHandler.class.php';

class APIController {

	function __construct() {
		$this->url = $this->getUrl();
		$this->handlerName = $this->processUrl();
	}
	
	
	function getUrl() {
		//med Viktors mod_rewrite
		$url = $_GET['request']; 
		return $url;
	}
	
	
	function processUrl() {
		$urlArray = Array();
		$urlArray = explode ("/", $this->url);
		$handlerName = $urlArray[1];
		
		return $handlerName;		
	}
	
	
	function sendToHandler() {
		if ($this->handlerName != null) {
			// if ok send to handler
			//else send error
			switch($this->handlerName) {
				case "User" :
					//send to getUser();
					//break;
				case "Article" :
					ArticleHandler::getArticle();
					break;
				case "Tag" :
					//send to getTag();
					//break;
			}
		}else{
			echo "Skriv t.ex. GET/Article/2 i adressfältet";
		}
	}
		
} 
 

?>