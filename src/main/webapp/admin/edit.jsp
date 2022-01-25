<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>記事変更</title>

<link	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="./css/add.css" />
<link rel="stylesheet" href="./editormd/css/style.css" />
<link rel="stylesheet" href="./editormd/css/editormd.css" />
<script src="./editormd/js/zepto.min.js"></script>
<script src="./editormd/js/editormd.js"></script>  
<script src="./js/add.js"></script>
</head>
<body>
	<div class="head_line"></div>
	<div class="container" id="main">
		<div id="title">
			<h2><a href="/my_blog/index.jsp" id="common2">Ultra Man Blog</a></h2>					
		</div>	
							
	   <form action="/my_blog/updateArticle" method="post">
	   		
	   		<div class="info" >
		   		<span class="help">ID</span>
		   		<input type="text" class="form-control" name="id"  value="${getArticle.id}" readonly="readonly">
		   		
		   		<span class="help">タイトル</span>
		   		<input type="text" class="form-control" name="title"  value="${getArticle.title}">
		   		
		   		<span class="help">作成日</span>
		   		<input type="text"  class="form-control" name="time" value="${getArticle.time}" >
		   		
		   		<span class="help">作成者</span>
		   		<input type="text" class="form-control" name="author" value="${getArticle.author}">	
		   					
		   		<span class="help">分類</span>
		   		<br/>
				<c:forEach var="s"  items="${getCategoryAndCount}">
					<input class="btn btn-default" type="button" value="${s.key}" onclick="category_click(this)"> &nbsp;					
				</c:forEach> 	 			
					<input type="text" class="form-control"  id="category" name="category" value="${getArticle.category}">		
					
		   		<span class="help">タグ</span><br/>
		   		<c:forEach var="tag" items="${getAllTag}">
		   		<input class="btn btn-default" type="button" value="${tag.tag}" onclick="tags_click(this)">&nbsp;
		   		</c:forEach>
		   		<input type="text" class="form-control" id="tags"  name="tags">	
	   		</div>   		
	   		
	   		
	   		<div class="foot_line"></div>
	   		
            <div class="editormd" id="mdView">                
                <textarea name="content">${getArticle.content}</textarea>
            </div>
            <br/>
            <input  class="btn btn-default"  type="submit"   value="変更" />
		</form>
		
		<div class="foot_line"></div>
	</div>
		
	<script type="text/javascript">
			var testEditor;
			var jQuery = Zepto;
            $(function() {
					testEditor = editormd("mdView", {
						width  : "90%",
						height : 720,
						path   : './editormd/lib/',
                        codeFold : true,
                        searchReplace : true,
                        saveHTMLToTextarea : true, 
                        htmlDecode : "style,script,iframe|on*",
                        emoji : true,
                        taskList : true,
                        tocm: true,      
                        tex : true,  
                        flowChart : true,  
                        sequenceDiagram : true,   
                        imageUpload : true,
				        imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],				        
				        imageUploadURL : "/Blog/UploadPic",			      
						onload : function() {
							console.log("onload =>", this, this.id, this.settings);
						}
					});				
					editor.setToolbarAutoFixed(false);           
            });
        </script>	
</body>
</html>