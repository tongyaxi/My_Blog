function getXHR(){	
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;	
}

/**
 * 記事を削除する
 * @param article_id
 */
function deleteArticle(hod , article_id){
	var recorder = hod.parentNode.parentNode.parentNode;	
	var recorder_parent = recorder.parentNode;
	recorder_parent.removeChild(recorder);
	var url = "/my_blog/adminManagement?op=delete_article"+"&&article_id="+article_id;
	sendURL(url);
}

function sendURL(url){	

	var xmlhttp = getXHR();		
	xmlhttp.onreadystatechange = function() {

	}
	xmlhttp.open("POST", url, true);
	xmlhttp.send();		
}