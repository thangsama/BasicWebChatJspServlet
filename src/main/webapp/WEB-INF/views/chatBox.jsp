

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset = "UTF-8">
<title> Chat </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>


<jsp:include page ="_header.jsp"></jsp:include>
<div id="boxChat">
<script type="text/javascript" language="javascript">
setInterval(loadBoxchat, 100);
function loadBoxchat(){
$("#boxChat").load( "chat");}
      </script>
</div>


<div id="typeBox">
  <jsp:include page="_createChat.jsp"></jsp:include>
</div>



</body>


</html>
