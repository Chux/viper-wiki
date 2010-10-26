<?php

interface IResourceHandler {
	
	/*
	** @param $pIdentifier Identifier for the object that should be fetched. In the case of articles it may be an Id or Title corresponding to a row in the DB
	*/
	public function getElement( $pIdentifier );

	/*
	** @param $pIdentifier Identifier for the object that should be updated or created. Look at comments on "getElement()" above to see what identifier might be
	*/
	public function putElement( $pIdentifier );

	/*
	** The real diffrence of putElement and postElement in our implementation of REST is yet to be discovered :D
	*/
	public function postElement( $pIdentifier );

	/*
	** @param $pIdentifier Identifier for the object that should be deleted. ... Look at comments on "getElement()" above to see what identifier might be
	*/
	public function deleteElement( $pIdentifier );




	/*
	** "List the URIs and perhaps other details of the collection's members." - WikiPedia 26oct2010
	*/
	public function getCollection();

	/*
	** "Replace the entire collection with another collection." - WikiPedia 26oct2010
	*/
	public function putCollcetion();

	/*
	** "Create a new entry in the collection. The new entry's URL is assigned automatically and is usually returned by the operation." - WikiPedia 26oct2010
	*/
	public function postCollection();

	/*
	** "Delete the entire collection." - WikiPedia 26oct2010
	*/
	public function deleteCollection();

}
