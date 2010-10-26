<?php
require_once 'IResourceHandler.class.php';

class UserHandler implements IResourceHandler {

	private $method;
	private $data;
	
	function __construct($method, $data) {
		$this->method 	= $method;
		$this->data 	= $data;
	}

	// Implement this shiz
	public function getElement( $pIdentifier ) { }
	public function putElement( $pIdentifier ) { }
	public function postElement( $pIdentifier ) { }
	public function deleteElement( $pIdentifier ) { }
	public function getCollection() { }
	public function putCollcetion() { }
	public function postCollection() { }
	public function deleteCollection() { }

}
