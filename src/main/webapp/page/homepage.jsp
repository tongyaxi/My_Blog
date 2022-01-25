<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ホームページ</title>
<link	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="./css/homepage.css" />
<link type="text/css" rel="stylesheet" href="./css/public.css" />
<script src="./js/article.js"></script>
</head>
<body>
	<div class="head_line"></div>

	<div class="container" id="main">
	
		<div id="header"></div>

		<div class="row c_center">
			
			<div class="col-md-3" id="left_content">

				<div id="title">
					<h2>Ultra Man Blog</h2>
					<h5 class="text-muted">在日勤務3年間のITプログラマー</h5>
					<c:choose>
					<c:when test="${sessionScope.user!=null}">
						<p><a href="logout" id="common2">ログアウト</a></p>
					</c:when>
					<c:otherwise>
						<p><a href="/my_blog/login?login=isLogin" id="common2">ログイン</a></p>
					</c:otherwise>	
					</c:choose>				
				
				</div>

				<div class="c_center" id="person_info">
					<img src="/my_blog/img/github.jpg" height="130" width="130"  class="img-circle">
					<h4 class="text-muted">
						<a target="_blank" href="https://github.com/tongyaxi" id="common2">GitHub BY TONGYAXI.</a>
					</h4>
				</div>

				<div class="c_center">
					<ul class="nav  nav-stacked">
  						<li class="active"><a href="#" id="common2">記事<span class="badge">${getArticleCount}</span></a></li>

  						<li><a href="/my_blog/category?get=all" id="common2">分類<span class="badge">${getCategoryCount}</span></a></li>

  						<li><a href="/my_blog/tag?get=all" id="common2">タグ<span class="badge">${getTagCount}</span></a></li>
					</ul>
				</div>
				<br/>
				<c:if test="${sessionScope.user!=null}">
					<a href="/my_blog/add">
					<span class="glyphicon glyphicon-plus" id="common2">&nbsp;&nbsp;記事作成&nbsp;&nbsp;</span>
					</a>
					<br/><br/><br/>
					<a href="/my_blog/admin">
					<span class="glyphicon glyphicon-th-list" id="common2">&nbsp;&nbsp;記事管理&nbsp;&nbsp;</span>
					</a>
				</c:if>
				<br/><br/><br/>
				<form action="/my_blog/searchArticleByTitle" method="post">
					<div class="input-group">
  					<input type="text" class="form-control" placeholder="タイトルで曖昧検索" aria-describedby="basic-addon2" style="width:170px;" name="searchArticle">
  					<input class="btn btn-default" type="submit"  value="検索" style="background-color:#419e9e;color:#fff"/>
				</div>
				</form>
					
				<div class="sort">
					<div class="list-group">
						<span class="list-group-item active" id="common">分類</span>	
						<c:forEach var="entity"  items="${getCategoryAndCount}">
						 <a href="/my_blog/category?get=${entity.key}" class="list-group-item">${entity.key}&nbsp;&nbsp;&nbsp;&nbsp; (${entity.value})</a>						
						</c:forEach>						
					</div>
				</div>

				
				<div class="visit">
					<div class="list-group">
						<span class="list-group-item active" id="common">記事ランク</span>
						<c:forEach var="a"  items="${getVisitRank}">
						 <a href="/my_blog/article?id=${a.id}" class="list-group-item">${a.title}&nbsp;&nbsp; <span class="c_right">(${a.visit})</span></a>						
						</c:forEach>					
					</div>
				</div>
	

				<div id="tag">
					<div class="list-group">
						<span class="list-group-item active" id="common">タグ</span>					
						<br/>		
						<c:forEach var="t"  varStatus="status" items="${getAllTag}" >		
						<c:choose>
						<c:when test="${status.count%2==1}">
							<span class="label label-info"><a href="/my_blog/tag?get=${t.tag}">
							&nbsp;${t.tag}&nbsp;</a></span>							
						</c:when>
						<c:otherwise>
								<span class="label label-success"><a href="/my_blog/tag?get=${t.tag}">
								&nbsp;${t.tag}&nbsp;</a></span>						
						</c:otherwise>
						</c:choose>
					
						</c:forEach>						
					</div>
				</div>
			</div>
			
			<div class="col-md-2" id="center_content">		
			</div>
			<br />
			<br />
			
			<div  class="col-md-7 " id="right_Content">
				<div id="list">
					<ul class="nav nav-pills">
  						<li role="presentation" class="active"><a href="/my_blog/index.jsp"><span class="glyphicon glyphicon-home"></span>
  								&nbsp;&nbsp;ホーム</a></li>
  						<li role="presentation"><a href="/my_blog/category?get=all" id="common2"><span class="glyphicon glyphicon-list"></span>
								&nbsp;&nbsp;カテゴリー</a></li>
  						<li role="presentation"><a href="/my_blog/tag?get=all" id="common2"><span class="glyphicon glyphicon-tags"></span>
								&nbsp;&nbsp;タグ</a></li>
						<li role="presentation"><a href="/my_blog/timeline" id="common2"><span class="glyphicon glyphicon-time"></span>
								&nbsp;&nbsp;タイムライン</a></li>
						<li role="presentation"><a href="/my_blog/page/about.jsp" id="common2"><span class="glyphicon glyphicon-user"></span>
								&nbsp;&nbsp;その他</a></li>
					</ul>
				</div>
				<br/><br/>
				<div class="list-group">							
					<a href="#" class="list-group-item active">記事</a>
					
					<c:forEach var="article"   items="${getAllArticle}" >	
					<div  class="list-group-item">									
					<h4><a href="/my_blog/article?id=${article.id}" id="common2">${article.title}</a></h4>
					<br/>
					<span>${article.time}&nbsp;&nbsp;|</span>
					<a href="/my_blog/category?get=${article.category}"  id="common2">${article.category}</a>&nbsp;&nbsp;|
					<span>訪問数: ${article.visit}</span>
					<br/><br/>					
					<span>${article.content}</span>
					<br/><br/><br/>	
					<a href="/my_blog/article?id=${article.id}"  id="common2">もっと見る</a>
					<br/>			
					</div>
					</c:forEach>			
				</div>
			</div>
		</div>		
		<div class="foot_line"></div>
		
	</div>
	<div class="r_div">
		<a href="#"><input  class="btn btn-default" value="TOP" style="width:50%;"/></a>    
	</div>
</body>
</html>