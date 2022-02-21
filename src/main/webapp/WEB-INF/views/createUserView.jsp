<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset ="UTF-8">
<title> Register</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>

<h3>Register new account</h3>
<p style="color:red;">${errorString}</p>
<form method ="POST" action ="${pageContext.request.contextPath}/createUserAccount">
<table border = "0">
<tr>
<td> User Name</td>
<td><input type="text" name ="userName" value = "${userAccount.userName}"/></td>
</tr>

<tr>
<td>Password</td>
<td><input type ="text" name ="password" value = "${userAccount.password}"/></td>

<tr>
<td>Gender</td>
<td><input type ="text" name ="gender" value = "${userAccount.gender}"/></td>
<td colspan = "2">
<input type = "submit" value = "Submit"/>
<a href="login">Cancel</a>
</td>
</tr>

</table>



</form>

</body>


</html>