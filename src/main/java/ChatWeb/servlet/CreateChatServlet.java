package ChatWeb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import ChatWeb.beans.Chat;
import ChatWeb.utils.DBUtils;
import ChatWeb.utils.MyUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/createChat"})
public class CreateChatServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
	public CreateChatServlet() {
		super();
	}
	
	//Show chat creating page
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	Connection conn = MyUtils.getStoredConnection(request);
	String content = request.getParameter("content");
	String userName = request.getParameter("userName");
	
	Chat chat = new Chat(content, userName);
	String errorString = null;
	String regex = "\\w+";
	if (content == null || !content.matches(regex)) {
		errorString = "Type message";
	}
	if (errorString == null) {
		try {
			DBUtils.insertChat(conn, chat);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

	}
	// Save info to REQUEST ATTRIBUTE before redirecting to VIEWS
	
	request.setAttribute("chat", chat);
	response.sendRedirect(request.getContextPath() + "/chatBox");
	

	

}
	
}
