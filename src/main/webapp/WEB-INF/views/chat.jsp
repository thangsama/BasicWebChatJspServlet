<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset = "UTF-8">
<title> Chat </title>
 <script src="https://code.jquery.com/jquery-3.5.0.js"></script>

</head>
<body>

<div id="boxChat">
<script>
setInterval(loadBoxchat, 1000);
function loadBoxchat(){
$("#boxChat").load( "chat");}
</script>
 
<jsp:include page ="_header.jsp"></jsp:include>
<h3>Chat box</h3>
<p style = "color:red;">${errorString}</p>
<table>
<tr>
<th>UserName</th>
<th>-</th>
</tr>
<c:forEach items ="${chatList}" var ="chat">
<tr>
<td>${chat.userName}</td>
<td>${chat.content}</td>
</tr>
</c:forEach>

</table>
</div>




</body>


</html>