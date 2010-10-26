<?php

class Article {

	public $id;
	public $userId;
	public $type;
	public $title;
	public $content;
	public $datetime;


	function __construct($id, $userId, $type, $title, $content, $datetime) {
		$this->id			= $id;
		$this->userId 		= $userId;
		$this->type 		= $type;
		$this->title		= $title;
		$this->content		= $content;
		$this->datetime 	= $datetime;
	}
	
	function  printArticle(){
		echo "<h2>{$this->title}</h2>";
		echo "<p>{$this->content}</p>";
		echo "<span> {$this->datetime} </span>";
		echo "<span> {$this->userId} </span>";		
	}

}

?>