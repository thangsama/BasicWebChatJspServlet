package ChatWeb.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/chatBox" })
public class ChatBoxServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
	public ChatBoxServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/chatBox.jsp");
		dispatcher.forward(request, response);
		}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
		response.sendRedirect(request.getContextPath() + "/chatBox");
	}
}
