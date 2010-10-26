$(document).ready( function() {
	ac = new ApiConnection();
	article = new ArticleModel();
	$("#article").html(start());
	//$("#article").html(article());
	$("#article #articleForm").submit(function() {
		article.title = $(this).find('#title').attr('value');
		article.content = $(this).find('#content').attr('value');
		
		
		console.log(article.title);
		console.log(article.content);
		return false;
	});
}); 

function start(){
	ac = new ApiConnection();
	var article = ac.get(1);
	
	return articleDisplay(article);
	
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
	var html = '<header><h2>'+article.title+'</h2></header>' +
	'<div id="content">' + article.content + '</div>'+
	'<div id="userId">' + article.userId + '</div>'+
	'<div id="dateTime">' + article.dateTime + '</div>';
	return html;
	
}