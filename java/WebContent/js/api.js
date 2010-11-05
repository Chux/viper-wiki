$(document).ready( function() {

	var mLoggedIn = false; 
	tApiConnection = new ApiConnection();
	tUser = new UserModel();
	tAuth = new AuthModel();
	eventHandler( tApiConnection, tAuth );
	tArticle = tApiConnection.get( 'article', 1 );

	if ( tApiConnection.getStatus() != '200' ) {
		handleError( tApiConnection.getStatus(), tApiConnection.getStatusText() );
	} else if ( tArticle != null ) {
		$("#article").html( articleDisplay( tArticle ) );
	}

});

//Event handlers
function eventHandler( pApiConnection, pAuth ) {		

	//form submits
	$("#article #articleForm").live( 'submit', function() {
		var tArticle = new ArticleModel();
		tArticle.title = $(this).find( '#title' ).attr( 'value' );
		tArticle.content = $(this).find( '#content' ).attr( 'value' );
		if ( tArticle.id ) {
			pApiConnection.create( tArticle );	//should be update
		} else {
			pApiConnection.create( tArticle );	
		}
		$('#article').html( articleDisplay( tArticle ) );
		
		return false;

	});
	
	$("header #search").live( 'submit', function() {

		tSearchQuery = $(this).find( '#search_text' ).attr( 'value' );
		tArticle= pApiConnection.get( 'article/' + tSearchQuery );
		if( tArticle) {
			$("#article").html( articleDisplay( tArticle ) );
		} else {
			$('#article').html( '<a href="" id="create" rel="">Create this article </a>' );
		}
		return false;

	});
	
	$('#article #loginForm').live( 'submit', function() {

		pAuth.username = $(this).find( '#username' ).attr( 'value' );
		pAuth.password = $(this).find( '#password' ).attr( 'value' );
		tResult = pApiConnection.create( pAuth ); 
		if ( pApiConnection.getStatus() == 200 ) {
			mLoggedIn = true; // ... This is not good.. Let ApiConnection take care of this member in the future..
		}
			
		if ( tResult ) {
			$('#article').html( displaySearchResults( tResult ) );
		} else {
			$('#article').html( '<a href="" id="create" rel="">Create this article </a>' );
		}
		
	});

	// link clicks
	$('#update').live( 'click', function(){

		var tId = $(this).attr('rel');
		tArticle = pApiConnection.get( 'article' , tId );		
		$('#article').html( articleForm( tArticle ) );
		return false;	

	});

	$('#create').live( 'click', function() {

		$('#article').html( articleForm() );
		return false;

	});
	
	$('.get, article#article div#content a').live( 'click', function() {

		var tId = $(this).attr( 'href' );
		tArticle = pApiConnection.get( 'article' , tId );
		$('#article').html( articleDisplay( tArticle ) );
		return false;	

	});
	
	$('#loginLink').live( 'click', function() {

		$("article").html( displayLogin() );
		return false;	

	});

}


// Display functions
function handleError(statusCode,statusText){

	$("#errormessages").html('<h1>' + statusCode +' '+ statusText + '</h1>');
	
}
function articleForm( pArticle ){

	var tTitle = '';
	var tContent = '';
	if ( pArticle ) {
		tTitle = pArticle.mTitle;
		tContent = pArticle.mContent;
		tId = pArticle.mUserId;
	}
	var html = '<form id=\"articleForm\" method=\"post\" action=\"#notImplemented\">' +
	'<label for="title">Title</label><input type="text" name="title" id="title" value="' + tTitle + '"/>'+
	'<label for="content">Content</label><textarea  name="content" id="content" >'+ tContent + '</textarea>'+
	'<input type="submit" id="submitArticle" />'+
	'</form>';
	
	return html;
}
function articleDisplay( pArticle ) {

	var html = '<a href="" id="update" rel="' + pArticle.mId +'">Edit this article</a>'+  //TODO Implement access rules when user is not logged in
	'<header><h2>' + pArticle.mTitle + '</h2></header>' +
	'<div id="content">' + pArticle.mContent + '</div>'+
	'<div id="userId">' + pArticle.mUserId + '</div>'+
	'<div id="dateTime">' + pArticle.mDatetime + '</div>';
	return html;
	
}

function displaySearchResults( pResult ) {

	var html = '<h2>Search Result</h2>';
	for (var i in result){
		html += '<a href="" class="get" rel="' + result[i].id +'">' + pResult[i].title + '</a>' +
		'<div id="userId">' + pResult[i].userId + '</div>'+
		'<div id="dateTime">' + pResult[i].dateTime + '</div>';
	}
	return html;

}

function displayLogin(){

	var html = '<form id=loginForm>' +
	'<label for="username">Username</label><input type="text" name="username" id="username" />'+
	'<label for="password">Password</label><input  name="password" id="password" type="text" />'+
	'<input type="submit" id="submitArticle" value="Log In"/>'+
	'</form>';
	
	return html;

}
