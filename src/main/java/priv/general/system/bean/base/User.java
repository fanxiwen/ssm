package priv.general.system.bean.base;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1442932676055918117L;

	private String id;
	
	private String username;
	
	private String nickName;
	
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
