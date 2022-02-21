package ChatWeb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import ChatWeb.beans.UserAccount;
import ChatWeb.utils.DBUtils;
import ChatWeb.utils.MyUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/createUserAccount" })
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateUserServlet() {
		super();
	}

//Show create userpage
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/createUserView.jsp");
		dispatcher.forward(request, response);
	}

//After submiting User's info'
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
	Connection conn = MyUtils.getStoredConnection(request);
	String userName =request.getParameter("userName");
	String gender =request.getParameter("gender");
	String password =request.getParameter("password");
 
	UserAccount userAccount = new UserAccount (userName, gender, password);
	String errorString = null;
	String regex = "\\w+";
	
	if(userName==null||!userName.matches(regex))
	{
		errorString = "User name invalid!";
	}

	if(errorString==null)
	{
		try {
			DBUtils.insertUser(conn, userAccount);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
	}

//Save data to request attribute
	request.setAttribute("errorString",errorString);
	request.setAttribute("userAccount",userAccount);

	if(errorString!=null)
	{
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/createUserView.jsp");
		dispatcher.forward(request, response);
	}

	else
	{
		response.sendRedirect(request.getContextPath() + "/chat");
	}
}
}