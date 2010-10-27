<?php
require_once('IModel.class.php');


class User implements IModel {

	public $mId;
	public $mUsername;
	private $mPassword;

	public function __construct( $pId, $pUsername, $pPassword ) {
		$this->mId		= $pId;
		$this->mUsername	= $pUsername;
		$this->mPassword	= $pPassword;
	}
	
	public function getDeleteSQL() {
		return "DELETE FROM `users`
			WHERE id = { $this->mId }";
	}

	public function getInsertSQL() {
		return "INSERT INTO `users`
			( `username`, `password` )
			VALUES ( { $this->mUsername }, { $this->mPassword } )";
	}

	public function getUpdateSQL() {
		// to be implemented..
		// Notice that we shouldnt really UPDATE.. we should insert a new row( maybe put getInsertSQL() to use again)!!! / Viktor
	}

}
