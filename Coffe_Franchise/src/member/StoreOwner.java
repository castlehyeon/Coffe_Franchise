package member;

public class StoreOwner extends Member {
	private String storeCode;
	
	public StoreOwner(String ID, String password, String phoneNumber, String storeCode) {
		super(ID, password, phoneNumber);
		this.storeCode = storeCode;
	}
}	
