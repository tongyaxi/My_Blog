/* 
 * AjaxObjectを取得する		
 * @returns {xmlhttp}
 */
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
 * いいね！のボタン実装関数
 * @param article_id
 */
function starArticle(article_id){
	var url = "/my_blog/starArticle?id=" + article_id ;		
	
	var xmlhttp = getXHR();	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var res = xmlhttp.responseText;			
			// JSONObjectをparseする
			var res = eval('(' + res + ')');			
			if (res.msg == "success") {
				document.getElementById("love").innerHTML= "&nbsp;"+ res.new_star+"&nbsp;";				
			}else{
				alert("Please do not submit again");
			}
		}
	}
	xmlhttp.open("POST", url, true);
	xmlhttp.send();		
}

/**
 * コメントをstarする
 */
function starComment(component , comm_id) {
	
	var url = "/my_blog/starComment?id="+comm_id ;		

	var xmlhttp = getXHR();	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var res = xmlhttp.responseText;			
			var res = eval('(' + res + ')');			
			if (res.msg == "success") {
				component.innerHTML = res.new_star;				
			}else{
				alert("Please do not submit again");
			}
		}
	}
	xmlhttp.open("POST", url, true);
	xmlhttp.send();	
}

/**
 * コメントをdissする
 */
function dissComment(component , comm_id) {
	
	var url = "/my_blog/dissComment?id="+comm_id;		
	var xmlhttp = getXHR();	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var res = xmlhttp.responseText;			
			var res = eval('(' + res + ')');			
			if (res.msg == "success") {
				component.innerHTML = res.new_diss;				
			}else{
				alert("Please do not submit again");
			}
		}
	}
	xmlhttp.open("POST", url, true);
	xmlhttp.send();	
}


/*
 *コメントを削除する
 */
function deleteComment(component,comm_id){
	var container = component.parentNode.parentNode;
	var url = "/my_blog/deleteComment?id="+comm_id ;		
	var xmlhttp = getXHR();	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var res = xmlhttp.responseText;			
			var res = eval('(' + res + ')');			
			if(res.msg == "success"){
				var p = container.parentNode;
				p.removeChild(container);
			}			
		}	
	}
	xmlhttp.open("POST", url, true);
	xmlhttp.send();	
}