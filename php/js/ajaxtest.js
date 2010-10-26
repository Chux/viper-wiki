$(document).ready( function() {
	ac = new ApiConnection();
	article = new ArticleModel();
	$("#article").html(start());
	
// INIT
	function start(){
		ac = new ApiConnection();
		var article = ac.get('article',1);
		return articleDisplay(article);
		
	}

	
	
//Event handlers
	//form submits
	
	$("#article #articleForm").submit(function() {
		article.title = $(this).find('#title').attr('value');
		article.content = $(this).find('#content').attr('value');
		console.log("is it hapend");
		return false;
	});
	
	
	$("header #search").submit(function(){
		searchQuery = $(this).find('#search_text').attr('value');
		console.log(searchQuery);
		result = ac.search(searchQuery);
		if (result) {
			$('#article').html(displaySearchResult(result));
		} else {
			$('#article').html('<a id="edit" rel="">Create this artickle </a>');			
	    }
		return false;
	});

	// link clicks
	$('#update').click(function(){
		var id = $(this).attr('rel');
		$('#article').html(articleForm(id));
		return false;
	});

	$(".get").click(function(){
		console.log("hek");
		//		var id = $(this).attr('rel');
//		$('#article').html(articleForm(id));
//		return false;
	});
}); 

// Display functions

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
	var html = '<a href="#" id="update" rel="' + article.id +'">Edit this artickel</a>'+  //TODO Implement access rules when user is not logged in
	'<header><h2>'+article.title+'</h2></header>' +
	'<div id="content">' + article.content + '</div>'+
	'<div id="userId">' + article.userId + '</div>'+
	'<div id="dateTime">' + article.dateTime + '</div>';
	return html;
	
}

function displaySearchResult(result){
	var html = '<h2> Search Result </h2>';
	for (var i in result){
		console.log(result[i]);
		html += '<a href="#" class="get" rel="' + result[i].id +'">'+result[i].title+'</a>' +
		'<div id="userId">' + result[i].userId + '</div>'+
		'<div id="dateTime">' + result[i].dateTime + '</div>';
	}
	return html;
}