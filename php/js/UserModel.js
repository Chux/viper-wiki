UserModel.prototype = new Model();
UserModel.prototype.constructor = UserModel;

function UserModel() {
	Model.call(this);
	var username;
	var password;
	
	var resourceType ='User';
	
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