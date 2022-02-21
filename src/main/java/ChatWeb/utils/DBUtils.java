package ChatWeb.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ChatWeb.beans.Chat;
import ChatWeb.beans.UserAccount;

public class DBUtils {
	//Find user
	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " + " where a.User_Name=? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}
		public static UserAccount findUser(Connection conn, String userName) throws SQLException {
		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " + " where a.User_Name=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static List<Chat> queryChat(Connection conn) throws SQLException {
		String sql = "Select a.content, a.User_Name from chat a ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Chat> list = new ArrayList<Chat>();
		while (rs.next()) {
			String idChat = rs.getString("Id_Chat");
			String content = rs.getString("content");
			String userName = rs.getString("User_Name");
			Chat chat = new Chat();
			
			chat.setContent(content);
			chat.setUserName(userName);
			list.add(chat);
		}
		return list;

	}

		
	//Add Chat
	public static void insertChat(Connection conn, Chat chat) throws SQLException{
		String sql = "Insert into Chat(Content, User_Name) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
	
		pstm.setString(2, chat.getContent());
		pstm.setString(3, chat.getUserName());
		pstm.executeUpdate();
		
		
	}
	
	//Create userAccount
	public static void insertUser(Connection conn, UserAccount userAccount) throws SQLException{
		String sql = "Insert into User_Account(User_Name, Gender, PASSWORD) values (?,?,?) ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userAccount.getUserName());
		pstm.setString(2, userAccount.getGender());
		pstm.setString(3, userAccount.getPassword());
		pstm.executeUpdate();
		
		
	}
	


}
