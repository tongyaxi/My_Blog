<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${article.title} | Ultra Man Blog</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="./css/article.css" />
<link type="text/css" rel="stylesheet" href="./css/comment.css" />
<link type="text/css" rel="stylesheet" href="./css/public.css" />
<link rel="stylesheet" href="./editormd/css/style.css" />
<link rel="stylesheet" href="./editormd/css/editormd.css" />
<script src="./editormd/js/zepto.min.js"></script>
<script src="./editormd/js/editormd.js"></script> 
<script src="./js/article.js"></script>

</head>
<body>
	<div class="head_line"></div>
	<div class="container" id="main">

		<div class="head">
			<div id="title">
				<a href="/my_blog/index.jsp"><h2>Ultra Man Blog</h2></a>
			</div>
		</div>

		<div id="article">

			<div id="a_head ">
				<h3>${article.title}</h3>
				<br/>
				<div>
					<h5>
						<span>${article.time}</span> <a href="/my_blog/category?get=${article.category}" id="common2">${article.category}</a>
					${article.author}
					</h5>
				</div>
				<div class="r_div">
					<h5>
						<span class="glyphicon glyphicon-eye-open">&nbsp;${article.visit}&nbsp;</span>						
						<span class="glyphicon glyphicon-heart" id="love">&nbsp;${article.star}&nbsp;</span> 
						<span class="glyphicon glyphicon-comment">&nbsp;${article.comment}&nbsp; </span>
					</h5>
				</div>
				<div id="tag">
				<c:forEach var="t" items="${getTagsByArticleId}">
					<a href="/my_blog/tag?get=${t.tag}" id="common2">${t.tag}&nbsp;</a>
				</c:forEach>
				</div>
			</div>
		</div>
		<div class="line"></div>
		
		<div id="a_content">
			<jsp:include page="/page/content.jsp"/>			
		</div>

		<div>
			<div class="f_div">
				<span class="glyphicon glyphicon-chevron-left"></span>
				<c:choose>
					<c:when test="${getPreviousArticle!=null}">
						<a href="/my_blog/article?id=${getPreviousArticle.id}">&nbsp;前の記事:${getPreviousArticle.title}</a>
					</c:when>					
					<c:otherwise>
						&nbsp;他の記事はありません。
					</c:otherwise>					
				</c:choose>
				
			</div>				
			<div class="r_div">
					<c:choose>
					<c:when test="${getNextArticle!=null}">
						<a href="/my_blog/article?id=${getNextArticle.id}">次の記事:&nbsp;${getNextArticle.title}</a>
					</c:when>					
					<c:otherwise>
						&nbsp;他の記事はありません。
					</c:otherwise>					
				</c:choose>
				<span class="glyphicon glyphicon-chevron-right"></span>
			</div>
			
			<div>			
			<span class="btn btn-default" style="color:#d9534f;"  onclick="starArticle(${article.id})" >いいね！</span>
			</div>						
			<br/>
		</div>
			
		<div class="line"></div>
							
		<div class="comment"> 
			
			<div class="r_div">
				<a href="#comment"><span class="glyphicon glyphicon-pencil">&nbsp;コメントする</span></a>
			</div>
					
			<c:if test="${comment!=null}">
			<c:forEach var="comm" varStatus="status" items="${comment}">
			<div class="row" >
				<div class="f_div">		
					<img src="/my_blog/img/comment.jpg" height="50" width="50"  class="img-circle"/>
					&nbsp;&nbsp;			
					<span style="color: #428bca"> ${comm.nickname}</span>					
					<span>&nbsp;&nbsp;${comm.time}</span>
				</div>			
				<div  id="c_content" class="c_left">						
					<pre>${comm.content }</pre>			
				</div>			
				<div class="r_div">			
					<a><span class="glyphicon glyphicon-thumbs-up"  onclick="starComment(this,${comm.id})">${comm.star}</span></a>
					&nbsp;
					<a><span class="glyphicon glyphicon-thumbs-down" onclick="dissComment(this,${comm.id})">${comm.diss}</span></a>
					&nbsp;	
					
					<c:if test="${sessionScope.user!=null}">	
					<span class="btn btn-default" style="color:red;" onclick="deleteComment(this,${comm.id})">削除する</span>
					&nbsp;		
					</c:if>		
				</div>			
				<div class="line"></div>
			</div>
			</c:forEach>
			</c:if>
		</div>
			
		<div id="comment">
			<form action="/my_blog/addComment?id=${article.id}" method="post">
				<input  style="width:30%" class="form-control" type="text" name="w_nickname" value="匿名"  >
				<br/>							
				<textarea style="resize:none; width:100%; height:180px;" name="w_content"></textarea>
				<br/>
				<br/>			
				<input  class="btn btn-default"  type="submit"   value="コメント" onclick="onclick"/>	
				<br/>						
			</form>			
		</div>			
		<div class="line"></div>
			 	
	</div>
</body>
</html>