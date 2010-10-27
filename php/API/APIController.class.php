<?php
require_once 'ArticleHandler.class.php';
require_once 'UserHandler.class.php';
require_once 'Article.class.php';

class APIController {

	public $mURL;

	function __construct( $pURL ) {
		$this->mURL = $pURL;
	}
	
	
	function processUrl() {
		$tURLArray 		= Array();
		$tURLArray 		= explode ( "/", $this->mURL );
		$tMethod 		= strtolower( $_SERVER['REQUEST_METHOD'] );
		$tHandlerName 		= $tURLArray[1];
		$tData 			= $tURLArray[2];

		// if ok send to handler else send error
		if ( isset( $tHandlerName ) ) {

			// if not empty send to getElement else send to getCollection
			if ( isset( $tData ) ) {
			
				switch( $tHandlerName ) {
					case "User" :
						switch( $tMethod ) {
							case "get" :
								$tResource = UserHandler::getElement( $tData );
								if( $tResource == false ) {
									// Give 204 - no content
								}
								break;
							case "post" :
								UserHandler::postElement( $tData );
								break;
							case "put" :
								UserHandler::putElement( $tData );
								break;
							case "delete" :
								UserHandler::deleteElement( $tData );
								break;
							default:
								// Give 404 - not found
								break;
						}
					break;
					
					case "Article" :
						switch( $tMethod ) {
							case "get" :
								$tResource = ArticleHandler::getElement( $tData );
								if( $tResource == false ) {
									// Give 204 - no content
									header('HTTP/1.1 204 No Content');
									exit;
								}
								else {
									echo json_encode( $tResource->toArray() );
									exit;
								}
								break;
							case "post" :
								ArticleHandler::postElement( $tData );
								break;
							case "put" :
								ArticleHandler::putElement( $tData );
								break;
							case "delete" :
								ArticleHandler::deleteElement( $tData );
								break;
							default:
								// Give 404 - not found
								break;
						}
					break;
					
					case "Tag" :
						// TagHandler::getElement($tData);
						// break;
				}
				
			} else {
			
				switch($tHandlerName) {
					case "User" :
						UserHandler::getCollection();
						break;
					case "Article" :
						ArticleHandler::getCollection();
						break;
					case "Tag" :
						TagHandler::getCollection();
						break;
				}

			}
		} else {
			echo "Skriv t.ex. GET/Article/2 i adressfältet";
		}
		
	}
	
	//comming next: implementing error function
	/*public static function getStatusCodeMessage($status) {

		$codes = Array(
		    100 => 'Continue',
		    101 => 'Switching Protocols',
		    200 => 'OK',
		    201 => 'Created',
		    202 => 'Accepted',
		    203 => 'Non-Authoritative Information',
		    204 => 'No Content',
		    205 => 'Reset Content',
		    206 => 'Partial Content',
		    300 => 'Multiple Choices',
		    301 => 'Moved Permanently',
		    302 => 'Found',
		    303 => 'See Other',
		    304 => 'Not Modified',
		    305 => 'Use Proxy',
		    306 => '(Unused)',
		    307 => 'Temporary Redirect',
		    400 => 'Bad Request',
		    401 => 'Unauthorized',
		    402 => 'Payment Required',
		    403 => 'Forbidden',
		    404 => 'Not Found',
		    405 => 'Method Not Allowed',
		    406 => 'Not Acceptable',
		    407 => 'Proxy Authentication Required',
		    408 => 'Request Timeout',
		    409 => 'Conflict',
		    410 => 'Gone',
		    411 => 'Length Required',
		    412 => 'Precondition Failed',
		    413 => 'Request Entity Too Large',
		    414 => 'Request-URI Too Long',
		    415 => 'Unsupported Media Type',
		    416 => 'Requested Range Not Satisfiable',
		    417 => 'Expectation Failed',
		    500 => 'Internal Server Error',
		    501 => 'Not Implemented',
		    502 => 'Bad Gateway',
		    503 => 'Service Unavailable',
		    504 => 'Gateway Timeout',
		    505 => 'HTTP Version Not Supported'
		);

		return (isset($codes[$status])) ? $codes[$status] : '';
	}*/
		
} 
 

?>
