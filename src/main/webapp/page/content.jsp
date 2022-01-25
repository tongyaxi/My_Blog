<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>

<link rel="stylesheet" href="./editormd/css/style.css" />
 <link rel="stylesheet" href="./editormd/css/editormd.preview.css" />

<script src="./editormd/js/zepto.min.js"></script>
<script src="./editormd/js/editormd.js"></script>

<script src="./editormd/js/jquery.min.js"></script>
<script src="./editormd/lib/marked.min.js"></script>
<script src="./editormd/lib/prettify.min.js"></script>
<script src="./editormd/lib/raphael.min.js"></script>
<script src="./editormd/lib/underscore.min.js"></script>
<script src="./editormd/lib/sequence-diagram.min.js"></script>
<script src="./editormd/lib/flowchart.min.js"></script>
<script src="./editormd/lib/jquery.flowchart.min.js"></script>
<script src="./editormd/editormd.js"></script>

<body style="background:#eee;">
 <div id="mdView"  style="background:#eee;">  	
 	<textarea id="article_content"  >${article.content}</textarea>   
 </div>  
<br />
<script type="text/javascript">
	$(function mdToHtml() {		
			
		editormd.markdownToHTML("mdView", {
			htmlDecode : "style,script,iframe", 
			emoji : true,
			taskList : true,
			tex : true,
			flowChart : true,
			sequenceDiagram : true,		
		});
	});	
</script>

</body>
</html>