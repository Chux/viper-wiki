ArticleModel.prototype = new Model();
ArticleModel.prototype.constructor = ArticleModel;

function ArticleModel() {
	Model.call(this);
	var resourceType = 'ArticleModel';
	var content;
	var title;
	var dateTime;
	var userId;
	
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