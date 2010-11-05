ArticleModel.prototype = new Model();
ArticleModel.prototype.constructor = ArticleModel;

function ArticleModel() {
	Model.call(this);
	var resourceType = 'article';
	var content;
	var title;
	var dateTime;
	var userId;
	var id;
	
	function getResourceType(){
		return resourceType;
	}
	
	var object = {
		content : content,
		dateTime : dateTime,
		userId : userId,
		getResourceType:getResourceType 
	};
	
	return object;
}