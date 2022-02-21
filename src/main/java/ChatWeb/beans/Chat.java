package ChatWeb.beans;

public class Chat {

private String content;
private String userName;

public Chat() {}
public Chat(String content, String userName) {
	
	this.content=content;
	this.userName=userName;
	
}


public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}


public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
}
