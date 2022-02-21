<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<form method="POST" action="${pageContext.request.contextPath}/createChat">

         <table border="0">
            <tr>
               <td>Message</td>
               <td><input type="text" name="content" value="${chat.content}" /></td>
              <td><input type = "text" name="userName" value = "${loginedUser.userName}" readonly/></td>
				
            </tr>
            
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
            
               </td>
            </tr>
         </table>
      </form>


