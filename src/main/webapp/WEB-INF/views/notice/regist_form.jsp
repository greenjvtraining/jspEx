<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<h1>Regist Form</h1>
<hr>
<form action="regist" method="post">
	<input type="text" name="title" placeholder="Input title..."><br>
	<input type="text" name="content" placeholder="Input content..."><br>
	<input type="text" name="writer" value="${id }"><br>
	<input type="submit" value="regist"><br>
</form>
</body>
</html>