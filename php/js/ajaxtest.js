$(document).ready(function() {
	
	art = new ArticleModel();
	art.title = 'Olle och Kim';
	art.content = 'Vist seru';
	
	ac = new ApiConnection();
	i = ac.get(art);
	console.log(ac.getStatus() + ac.getStatusText());
	console.log(i);
	ac.create(art);
	console.log(ac.getStatus() +  ac.getStatusText());
	console.log(art.getResourceType());
}); 