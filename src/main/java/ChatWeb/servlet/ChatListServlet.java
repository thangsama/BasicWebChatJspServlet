package ChatWeb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ChatWeb.beans.Chat;
import ChatWeb.utils.DBUtils;
import ChatWeb.utils.MyUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/chat" })
public class ChatListServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
	public ChatListServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		Connection conn= MyUtils.getStoredConnection(request);
		String errorString = null;
		List<Chat> list = null;
		try {
			list = DBUtils.queryChat(conn);
			
		}catch(SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
			
		}
		// Save info to " Request ATTRIBUTE " before forwarding to Views
		request.setAttribute("errorString", errorString);
		request.setAttribute("chatList", list);
		
		//Forward to /web-inf/views/chat.jsp
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/chat.jsp");
		dispatcher.forward(request, response);
		}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
