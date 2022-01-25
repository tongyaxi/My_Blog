<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>記事管理</title>
<link	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="./css/public.css" />
<link type="text/css" rel="stylesheet" href="./css/admin.css" />
<script src="./js/admin.js"></script>
</head>

<body>
	<div class="head_line"></div>
	<div class="container" id="main">
				
		<div id="header">
			<div>
				<h2><a href="/my_blog/index.jsp" id="common2">Ultra Man Blog Management</a></h2>
			</div>		
		</div>
		
		<div class="admin_div">
			<h4 class="btn btn-default">記事管理</h4>
			<c:forEach var="a" items="${articles}">				
			<div class="list-group-item">						
		    	<span>${a.title}</span>
				<div class="r_div">	
					<span>${a.time}</span>
					<a href="/my_blog/adminManagement?op=edit_article&&article_id=${a.id}">
						<button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-pencil" style="color:#5bc0de" >変更</span>&nbsp;</button>
					</a>
					<button class="btn btn-default">&nbsp;
						<span class="glyphicon glyphicon-trash" style="color:#d9534f" onclick="deleteArticle(this,'${a.id}')">削除</span>&nbsp;
					</button>
				</div>										 
			</div>							
			</c:forEach>					
		</div>

		<div class="foot_line"></div>		
	</div>	
	
</body>
</html>