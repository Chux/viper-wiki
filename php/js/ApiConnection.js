function ApiConnection() { 
	var mStatus = '';
	var mStatusText = '' ;
	
	function get (object , id ) {
		$.ajax({
			url : '../php/jsTest/olle.php',//createUrl(object, id),
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
		return object;
	
	};
	
	function create(object , id ) {
		var tStatus,tStatusText;
		var object;
		$.ajax({
			url : '../php/jsTest/olle2.php',//createUrl(object, id),
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
		//status = xhr.status;
		//statusText = xhr.statusText;
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
			url = APIROOT + object.ResourceType + '/' + id + '/';
		} else {
			url = APIROOT + object.ResourceType + '/';
		}
		return url;
	};
	
	return {
		getStatus : getStatus,
		getStatusText : getStatusText,
		get : get,
		create : create
	};
}