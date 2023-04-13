package member;

public class StoreOwner extends Member {
	private int storeCode;
	
	public StoreOwner(String ID, String password, String phoneNumber, int storeCode) {
		super(ID, password, phoneNumber);
		this.storeCode = storeCode;
	}

	public int getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}
	
}	
