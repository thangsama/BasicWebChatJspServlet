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
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	// show login page
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// forward to /WEB-INF/views/loginView.jsp
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		dispatcher.forward(request, response);
	}

	// After submiting userpassword
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rememberMeStr= request.getParameter("remeberMe");
		boolean remeber = "Y".equals(rememberMeStr);
		String errorString = null;
		
		UserAccount user =null;
		boolean hasError=false;
		
		if(userName == null|| password==null|| userName.length()==0) {
			hasError = true;
			errorString = "Required username and password!";
		}else {
			Connection conn=MyUtils.getStoredConnection(request);
			try {
				//find user in database
				user = DBUtils.findUser(conn, userName, password);
				if(user == null) {
					hasError =true;
					errorString = "User Name or password invalid";
				}}
				catch(SQLException e) {
					e.printStackTrace();
					hasError=true;
					errorString=e.getMessage();
					
				}
				
			}
			// If there's error, it will forward to /WEB-INF/views/login.jsp
			if(hasError) {
				user=new UserAccount();
				user.setUserName(userName);
				user.setPassword(password);
				errorString = "User Name or password invalid, if you are 1st time. Pls click Register to make new account";
				
				request.setAttribute("errorString", errorString);
				request.setAttribute("user", user);
				
				RequestDispatcher dispatcher =this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
				dispatcher.forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				MyUtils.storeLoginedUser(session, user);
				
				//If ticked "remember me"
				if(remeber) {
					MyUtils.storeUserCookie(response, user);
				}
				//if not ticked "remember me"
				else { MyUtils.deleteUserCookie(response);
					
					
				}
				
				response.sendRedirect(request.getContextPath()+"/chatBox");
				
			}	
			
			}

}