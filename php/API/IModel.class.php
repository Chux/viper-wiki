<?php

interface iModel {

	/*
	** @return (String) A string containing the SQL-query to delete the row from the DB .. or (False) if not applicable
	*/
	public function getDeleteSQL();

	/*
	** @return (String) A string containing the SQL-query make a new row in the DB with the data from the instance .. or (False) if not applicable
	*/
	public function getInsertSQL();

	/*
	** @return (String) A string containing the SQL-query to make changes on the row in the DB .. OR (False) if not applicable
	*/
	public function getUpdateSQL();

}
