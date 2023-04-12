package member;

public abstract class Member {
	private String ID;
	private String password;
	private String memberType; 
	private String phoneNumber;
	
	// 생성자
	Member() {}
	Member(String ID, String password, String memberType, String phoneNumber) {
		this.ID = ID;
		this.password = password;
		this.memberType = memberType;
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
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	} 
	
	
}
