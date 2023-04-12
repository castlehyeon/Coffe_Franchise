package store;

public class Store extends Headquarter{
	
	private int storeCode;		//가게코드
	private String name;		//지점이름
	private String address;		//주소
	private String phoneNumber;	//핸드폰번호
	private int totalSales;		//총 매출
	
	public Store(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.storeCode = storeCode + 1;
	}


	public int getStoreCode() {
		return storeCode;
	}


	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getTotalSales() {
		return totalSales;
	}


	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}


	@Override
	public String toString() {
		return "Store [storeCode=" + storeCode + ", name=" + name + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", totalSales=" + totalSales + "]";
	}


	
}