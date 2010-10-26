function Model(){
	this.resourceType = 'Model';	

	getResourceType = function (){
		return this.resourceType;
	};
	
	return {
		getResourceType : getResourceType,
		test: test
	};
}

