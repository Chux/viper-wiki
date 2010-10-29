$(document).ready( function() {
	var mLoggedIn = false; 
	ac = new ApiConnection();
	article = new ArticleModel();
	user = new UserModel();
	auth = new AuthModel();
	$("#article").html(start());	
	eventHandler();

});

//INIT
function start(){
	ac = new ApiConnection();
	var article = ac.get('Article', 1);
	if (ac.getStatus() != '200' ){
		handleError(ac.getStatus(),ac.getStatusText());
		console.log(window.defaultStatus);	
		return "";
	} else if (article != null){
		return articleDisplay(article);
	}
	return ""
	console.log(ac.getStatus());
	
}

//Event handlers
function eventHandler(){		
	//form submits
	$("#article #articleForm").live('submit', function() {
		article.title = $(this).find('#title').attr('value');
		article.content = $(this).find('#content').attr('value');
		if (article.id){
			ac.create(article);	//should be update
		} else { 
			ac.create(article);
		}
		console.log(ac.getStatus());
		$('#article').html(articleDisplay(article));
		return false;
	});
	
	$("header #search").live('submit', function(){
		ac = new ApiConnection();
		searchQuery = $(this).find('#search_text').attr('value');
		result = ac.search(searchQuery);
		if (result) {
			$('#article').html(displaySearchResults(result));
		} else {
			$('#article').html('<a href="" id="create" rel="">Create this article </a>');			
	    }
		console.log(ac.getStatus());
		return false;
	});
	
	$('#article #loginForm').live('submit',function(){
		auth.username = $(this).find('#username').attr('value');
		auth.password = $(this).find('#password').attr('value');
		result = ac.create(auth); 
		if (ac.getStatus() == 200) {
			mLoggedIn= true ;
		}
			
		if (result) {
			$('#article').html(displaySearchResults(result));
		} else {
			$('#article').html('<a href="" id="create" rel="">Create this article </a>');			
	    }
		
	});

	// link clicks
	$('#update').live('click', function(){
		var id = $(this).attr('rel');
		console.log(id);
		article = ac.get('Article',id);		
		$('#article').html(articleForm(article));
		console.log(ac.getStatus());
		return false;	
	});

	$('#create').live('click', function() {
		$('#article').html(articleForm());
		return false;
	});
	
	$('.get').live('click', function() {
		var id = $(this).attr('rel');
		article = ac.get('Article',1);
		$('#article').html(articleDisplay(article));
		console.log(ac.getStatus());
		return false;	
	});
	
	$('#loginLink').live('click', function() {
		$("article").html(displayLogin());
		return false;	
	});

}


// Display functions
function handleError(statusCode,statusText){
	$("#errormessages").html('<h1>' + statusCode +' '+ statusText + '</h1>');
	
}
function articleForm(article){
	var title = '';
	var content = '';
	if (article){
		title = article.title;
		content = article.content;
		id = article.userId;
	}
	var html = '<form id=articleForm>' +
	'<label for="title">Title</label><input type="text" name="title" id="title" value="'+title+'"/>'+
	'<label for="content">Content</label><textarea  name="content" id="content" >'+ content + '</textarea>'+
	'<input type="submit" id="submitArticle" />'+
	'</form>';
	
	return html;
}
function articleDisplay(article){
	var html = '<a href="" id="update" rel="' + article.id +'">Edit this artickel</a>'+  //TODO Implement access rules when user is not logged in
	'<header><h2>'+article.title+'</h2></header>' +
	'<div id="content">' + article.content + '</div>'+
	'<div id="userId">' + article.user_id + '</div>'+
	'<div id="dateTime">' + article.datetime + '</div>';
	return html;
	
}

function displaySearchResults(result){
	var html = '<h2> Search Result </h2>';
	for (var i in result){
		console.log(result[i]);
		html += '<a href="" class="get" rel="' + result[i].id +'">'+result[i].title+'</a>' +
		'<div id="userId">' + result[i].userId + '</div>'+
		'<div id="dateTime">' + result[i].dateTime + '</div>';
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