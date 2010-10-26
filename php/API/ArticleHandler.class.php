<?php

require_once 'IResourceHandler.php';
require_once 'Db.class.php';
require_once 'Article.class.php';


class ArticleHandler implements IResourceHandler {

	
	function __construct() {
		//$this->data 	= $data;
	}

	
	function getElement($data) {
	
		$con = new Db("viper_wiki");
		$db = $con->getConnection();
		
		$query = $db->prepare("	SELECT articles.*
								FROM articles
								WHERE articles.id = ?
							");
		$query->bind_param("i", $data);
		$query->execute();
		$query->bind_result($id, $userId, $type, $title, $content, $datetime);

		//$article = array();
		while ($query->fetch()){
			$article = new Article($id, $userId, $type, $title, $content, $datetime);
		}
		$query->close();
		
		$article->printArticle();
		return $article;
	
	}

}

?>


