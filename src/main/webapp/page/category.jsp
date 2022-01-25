<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分類</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="./css/public.css" />
<link type="text/css" rel="stylesheet" href="./css/category.css" />

</head>
<body>
	<div class="head_line"></div>

	<div class="container" id="main">

		<div id="header"></div>

		<div class="row c_center">
			<div class="col-md-3" id="left_content">

				<div id="title">
					<h2>
						<a href="/my_blog/index.jsp" id="common2">Ultra Man Blog</a>
					</h2>
				</div>

				<div class="c_center" id="person_info">
					<img src="/my_blog/img/github.jpg" height="130" width="130"  class="img-circle">
					<h5 class="text-muted">
						<a target="_blank" href="https://github.com/tongyaxi" id="common2">GitHub BY TONGYAXI.</a>
					</h5>
				</div>
				<br/>
			</div>
			
			<div class="col-md-2" id="center_content"></div>

			<div class="col-md-7 " id="right_Content">
			<br /><br />	
				<div id="list">
					<ul class="nav nav-pills">
  						<li role="presentation"><a href="/my_blog/index.jsp" id="common2"><span class="glyphicon glyphicon-home"></span>
  								&nbsp;&nbsp;ホーム</a></li>
  						<li role="presentation" class="active"><a href="/my_blog/category?get=all"><span class="glyphicon glyphicon-list"></span>
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
					<a href="#" class="list-group-item active">分類</a>
									
					<c:forEach var="map" items="${getCategoryAndAirticle}">					
						<div class="sort_name">
							<span class="glyphicon glyphicon-triangle-bottom" id="common2"></span>	&nbsp;	&nbsp;${map.key}					
						</div>
						
						<div>
							<ul class="list-group">
								<c:forEach var="list" items="${map.value}">
								<li class="list-group-item">
									<div>
										<div>
											<a href="/my_blog/article?id=${list.id}" id="common2">${list.title}</a>
										</div>
										<div class="c_right">
											<img src="/my_blog/img/time.png">${list.time}&nbsp;&nbsp; 
											<span class="visit"><img src="/my_blog/img/visit.png">${list.visit}</span>
										</div>
									</div>
								</li>
								</c:forEach>					
							</ul>
						</div>								
					</c:forEach>
				</div>
			</div>
		</div>

		<div class="foot_line"></div>
	</div>

</body>
</html>