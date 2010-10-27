function ApiConnection() { 
	var mStatus = '';
	var mStatusText = '' ;
	
	function get ( resourceType, id ) {
		$.ajax({
			url : createUrlFromResourceType(resourceType, id),
			type : 'get',
			dataType : 'json',
			async: false,
			complete : function (transport, textstatus) {
				object = transport.responseText;
				tStatusText = transport.statusText; 
				tStatus = transport.status; 
			}
		});
		setStatus(tStatus);
		setStatusText(tStatusText);
		try {
			object = $.parseJSON(object);
		}
		catch (e) {
			console.log('trassigt');
			object = null;
		}

		return object;
	
	};
	
	function create(object , id ) {
		var tStatus,tStatusText;
		var object;
		$.ajax({
			url : createUrl(object, id),
			type : 'post',
			dataType : 'json',
			async: false,
			complete : function (transport, textstatus) {
				object=transport.responseText;
				tStatusText = transport.statusText; 
				tStatus = transport.status; 
			}
		});
		setStatus(tStatus);
		setStatusText(tStatusText);
		return object;
	}
	
	function search(string){
		$.ajax({
			url : APIROOT + 'search' ,
			type : 'get',
			data: string,
			dataType : 'json',
			async: false,
			complete : function (transport, textstatus) {
				object = transport.responseText;
				tStatusText = transport.statusText; 
				tStatus = transport.status; 
			}
		});
		setStatus(tStatus);
		setStatusText(tStatusText);
		try {
			object = $.parseJSON(object);
		}
		catch (e) {
			console.log('trassigt');
			object = null;
		}
		return object;
	}

	
	
	function setStatus(pStatus){
		mStatus = pStatus; 
	}

	function setStatusText(pStatusText){
		mStatusText = pStatusText; 
	}
	
	function getStatus(){
		return mStatus;
	}
	function getStatusText(){
		return mStatusText;
	}
	
	function createUrl(object , id) {
		var url;
		if (id !=null){
			url = APIROOT + PREFIX + object.getResourceType() + '/' + id + '/'; 
		} else {
			url = APIROOT + PREFIX + object.getResourceType() + '/';
		}
		return url;
	};
	
	function createUrlFromResourceType(resourceType , id) {
		var url;
		if (id !=null){
			url = APIROOT + PREFIX + resourceType + '/' + id + '/';
		} else {
			url = APIROOT + PREFIX  + resourceType + '/';
		}
		return url;
	};
	
	
	return {
		getStatus : getStatus,
		getStatusText : getStatusText,
		get : get,
		create : create,
		search :search
	};
}