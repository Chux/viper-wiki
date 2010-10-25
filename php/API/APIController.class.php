<?php

class APIController {

	function __construct() {
		$this->url = $this->getUrl();
		$this->handlerName = $this->processUrl();
	}
	
	
	function getUrl() {
		//$url = $_SERVER[ "REQUEST_URI" ] or $_SERVER[ "PATH_INFO" ] (?);
		
		// exempel att arbeta med
		$url = "/API/GET/Article/1"; 
		
		return $url;
	}
	
	
	function processUrl() {
	
		$urlArray[] = array();
		$urlArray = explode ("/", $this->url);
		$handlerName = $urlArray[3]; // i det här exemplet
		
		return $handlerName;		
	}
	
	
	function sendToHandler() {
		// if wrong send error (default)
		//else send to handler
		switch($this->handlerName) {
			case "User" :
				header("Location: UserHandler.class.php");
				break;
			case "Article" :
				header("Location: ArticleHandler.class.php");
				break;
			case "Tag" :
				header("Location: TagHandler.class.php");
				break;
			default :
				//error
				header("HTTP/1.0 404 Not Found");
		}		
	}
	
	
	
	

	
	
	
} 
 

?>