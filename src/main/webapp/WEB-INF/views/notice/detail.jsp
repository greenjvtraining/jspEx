<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" >
<style>
	.del{
		cursor: pointer;
	}
</style>
</head>
<body>
<h1>Detail Notice</h1>
<hr>
<button onclick="location.href='/notice/list'">목록보기</button>
<table>
	<tr>
		<th>제목</th>
		<td>${notice.title }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${notice.content }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${notice.writer }</td>
	</tr>
	<tr>
		<th>작성일자</th>
		<td>${notice.regdate }</td>
	</tr>
</table>
<div>
	<span id="txt_reply">댓글작성</span>
</div>
<div id="reply_div">
	<c:set var="id" value="user01" />
	<input type="hidden" id="reply_nno" name="reply_nno" value="${notice.nno }">
	<input type="text" id="reply_comment" name="reply_comment">
	<input type="hidden" id="reply_writer" name="reply_writer" value="${id }">
	<input type="button" value="등록" onclick="reg_reply()">
</div>
<div id="demo">
	<table>
		<thead>
			<tr>
				<th>번호</th>	<th>comment</th><th>writer</th><th>regdate</th><th>del</th>
			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach var="reply" items="${replyList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${reply.comment }</td>
				<td>${reply.writer }</td>
				<td>${reply.regdate }<br>	
				
				<td>
				<c:if test="${id eq reply.writer }" >
					<a href="#" onclick='del_reply("${reply.rno}")'>X</a>
				</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script>
	const txt_reply = document.querySelector("#txt_reply");
	const reply_div = document.querySelector("#reply_div");
	const reply_nno = document.querySelector("#reply_nno");
	const reply_comment = document.querySelector("#reply_comment");
	const reply_writer = document.querySelector("#reply_writer");
	const tbody = document.querySelector("#tbody");
	
	reply_div.style.display = "none";
	txt_reply.addEventListener("click", function(){
		reply_div.style.display = "block";
	});
	
	function reg_reply(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
		    //document.getElementById("demo").innerHTML = this.responseText;
		    const objs = JSON.parse(this.responseText);
		    console.log(objs);
		    
		    showReplyList(objs);
		    
		}
		xhttp.open("post", "reg_reply", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("nno=" + reply_nno.value + "&comment=" + reply_comment.value + "&writer=" + reply_writer.value);
	}
	
	function del_reply(rno){
		alert("del..."  + rno);
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			  const objs = JSON.parse(this.responseText);
			  console.log(objs);
			  
			  showReplyList(objs);
			}
		console.log("del_reply?rno=" + rno);
		xhttp.open("GET", "del_reply?rno=" + rno + "&nno=" + reply_nno.value, true);
		xhttp.send();
	}
	
	function showReplyList(objs){
		tbody.innerHTML = "";
	    let str = "";
	    for(let i = 0; i < objs.length; i++){
	    	str += "<tr>";
	    	str += "<td>" + (i+1) + "</td>";
	    	str += "<td>" + objs[i].comment + "</td>";
	    	str += "<td>" + objs[i].writer + "</td>";
	    	str += "<td>" + objs[i].regdate + "</td>";
	    	console.log(objs[i].writer);
	    	console.log(reply_writer.value);
	    	console.log("${id}");
	    	if(objs[i].writer == reply_writer.value ){
		    	str += "<td><span class='del' onclick='del_reply(" + objs[i].rno + ")'>" + "X" + "</span></td>";
	    	}else{
	    		str += "<td><span>"+ "" +"</span></td>";		    		
	    	}
	    	str += "</tr>";
	    }
	    tbody.innerHTML = str;
	    reply_comment.value = "";
	}
</script>
</body>
</html>