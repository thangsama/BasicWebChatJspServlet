<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<<<<<<< HEAD
   
   <!DOCTYPE html>
   <html>
   <head>
   	<meta charset="UTF-8">
   	<title>Login</title>
   </head>
   <body>
   <jsp:include page="_header.jsp"></jsp:include>
   <h3> Login Page</h3>
   <p style ="color:red;">${errorString}</p>
  <form method="POST" action ="${pageContext.request.contextPath}/login">
=======
<!DOCTYPE html>
<html>
<head>
<meta charset ="UTF-8">
<title>Login</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Login Page</h3>
<p style ="color:red;">${errorString}</p>
<form method="POST" action ="${pageContext.request.contextPath}/login">
>>>>>>> 3bfce8a5c839f280e55a409e51689ebfc9c5f900
	<table border="">
	<tr>
		<td>User Name</td>
		<td><input type="text" name ="userName" value = "${user.userName}"/></td>
	</tr>
	
	<tr>
	<td>Password</td>
	<td><input type="text" name = "password" value = "${user.password}"/></td>
	</tr>
	
	<tr>
<<<<<<< HEAD
	<td colspan ="2"> <input type = "submit" value ="Submit" />
   <a href = "${pageContext.request.contextPath}/createUserAccount">Register</a>
   <a href = "${pageContext.request.contextPath}/">Cancel</a>
   
   </td>
   </tr>
   </table>
   </form>
   
   </body>
   
   </html>	
   
   
   
   
=======
	<td colspan ="2"><input type ="submit" value="Submit"/><a href="${pageContext.request.contextPath}/"> Cancel</a>
	</td>
	</tr>
	
	</table>

</form>
<p style="color:blue;">User Name:tom, password: tom001 or jerry/jerry001</p>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
>>>>>>> 3bfce8a5c839f280e55a409e51689ebfc9c5f900
