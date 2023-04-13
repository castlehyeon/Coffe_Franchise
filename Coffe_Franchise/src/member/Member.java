package member;

import java.io.Serializable;

public abstract class Member implements Serializable {
	private String ID;
	private String password;
	private String phoneNumber;
	
	// 생성자
	Member() {}
	Member(String ID, String password, String phoneNumber) {
		this.ID = ID;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
