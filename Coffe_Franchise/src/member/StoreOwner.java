package member;

public class StoreOwner extends Member {
	//	private DuzoneFranchisee duzoneFranchisee;
	private String storeCode;

	public void showTotalSalesByTime() {}
	public void showTotalClientByTime() {}

	public StoreOwner(String ID, String password, String phoneNumber, String storeCode) {
		super(ID, password, phoneNumber);
		this.storeCode = storeCode;
	}

}