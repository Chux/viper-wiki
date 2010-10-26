<?php

require_once 'IResourceHandler.php';

class TagHandler implements IResourceHandler {

	private $method;
	private $data;
	
	function __construct($method, $data) {
		$this->method 	= $method;
		$this->data 	= $data;
	}

}


?>