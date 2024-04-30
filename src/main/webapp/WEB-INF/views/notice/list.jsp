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
<h1>List Page</h1>
<hr>
<div>
	<a href="regist">공지사항 작성하기</a>
</div>
<table>
	<thead>
		<tr>
			<th>번호</th><th>제목</th><th>작성자</th><th>작성일자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="notice" items="${noticeList }" varStatus="status">
		<tr>
			<td>${status.count }</td>
			<td><a href="detail?nno=${notice.nno }">${notice.title }(${notice.replyCnt })</a></td>
			<td>${notice.writer }</td>
			<td>${notice.regdate }</td>
		</tr>
		</c:forEach>
	</tbody>

</table>
</body>
</html>