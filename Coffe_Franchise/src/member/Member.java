package member;

public abstract class Member {
	protected String ID;
	protected String password;
	protected String phoneNumber;
//	
//	// 생성자
//	Member(String ID, String password, String phoneNumber) {
//		this(ID, password, "storekeeper", phoneNumber);
//	}
//	
//	Member(String ID, String password, String memberType, String phoneNumber) {
//		this.ID = ID;
//		this.password = password;
//		this.memberType = memberType;
//		this.phoneNumber = phoneNumber;
//	}
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
