<?php
require_once('IModel.class.php');


class Article implements IModel {

	public $mId;
	public $mUserId;
	public $mType;
	public $mTitle;
	public $mContent;
	public $mDatetime;


	public function __construct( $pId, $pUserId, $pType, $pTitle, $pContent, $pDatetime ) {
		$this->mId		= $pId;
		$this->mUserId 		= $pUserId;
		$this->mType 		= $pType;
		$this->mTitle		= $pTitle;
		$this->mContent		= $pContent;
		$this->mDatetime 	= $pDatetime;
	}
	
	public function printArticle() {
		echo "<h2>{$this->mTitle}</h2>";
		echo "<p>{$this->mContent}</p>";
		echo "<span> {$this->mDatetime} </span>";
		echo "<span> {$this->mUserId} </span>";
	}

	public function getDeleteSQL() {
		// Since we want to keep track of all articles and their history, we dont actually delete it, but we change its `type` column to 'deleted'
		if( $this->mId != null ) {
			return false; // It doesnt exist in the database, can't do this!
		}
		return	"UPDATE `articles`
			 SET `type` = 'deleted'
			 WHERE id = { $this->mId }";
	}

	public function getInsertSQL() {
		// to be implemented..
	}

	public function getUpdateSQL() {
		// to be implemented..
		// Notice that we shouldnt really UPDATE.. we should insert a new row( maybe put getInsertSQL() to use again)!!! / Viktor
	}

}
