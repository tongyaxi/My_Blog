<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ultra Man Blog</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="./css/login.css" rel="stylesheet" type="text/css" charset="utf-8"/>
<link href="./css/public.css" rel="stylesheet" type="text/css" charset="utf-8"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
</head>

<body>
	<div class="container">
		<form action="login" method="post">
			<h1>Ultra Man Blog</h1>
			
			<div class ="input-group input-group-lg">
            	<span class ="input-group-addon">
            		<span class ="glyphicon glyphicon-user"></span>
            	</span>
                <input type="text" id="input" class="form-control" placeholder="ユーザー名:m21w0b16" name="username" >
            </div>
            
            <br>
            <div class ="input-group input-group-lg">
            	<span class ="input-group-addon">
            		<span class ="glyphicon glyphicon-lock"></span>
            	</span>
            	<input type="password" id="inputPassword" class="form-control" placeholder="パスワード:m21w0b16" name="password">
            </div>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit" id="submit">ログイン</button>
			</br></br>
			<a class="visitor" href="/my_blog/index.jsp" id="common2">ログインしないままでブログに訪問</a>
			
			<% String errorMessage = (String) request.getAttribute("errorMessage");%>
			<% if(errorMessage != "" && errorMessage != null){ %>
				<p><%= errorMessage%></p>
			<%} %>
		</form>
	</div>
</body>
</html>