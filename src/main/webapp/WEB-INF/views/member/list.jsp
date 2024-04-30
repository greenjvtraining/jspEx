<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<h1>MemberList Page</h1>
<hr>
<div>
	<a href="/notice/regist">공지사항 작성하기</a>
</div>
<table>
	<thead>
		<tr>
			<th>번호</th><th>id</th><th>name</th><th>birth</th><th>phone</th><th>addr</th><th>role</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="member" items="${memberList }" varStatus="status">
		<tr>
			<td>${status.count }</td>
			<td><a href="detail?id=${member.id }">${member.id }</a></td>
			<td>${member.name }</td>
			<td>${member.birth }</td>
			<td>${member.phone }</td>
			<td>${member.addr }</td>
			<td>${member.role }</td>
		</tr>
		</c:forEach>
	</tbody>

</table>
</body>
</html>