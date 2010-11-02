AuthModel.prototype = new Model();
AuthModel.prototype.constructor = AuthModel;

function AuthModel() {
	Model.call(this);
	var username;
	var password;
	
	var resourceType ='Auth';
	
	function getResourceType(){
		return resourceType;
	}
	
	var object = {
		username : username,
		password : password,
		getResourceType : getResourceType
	};
	
	return object;
}