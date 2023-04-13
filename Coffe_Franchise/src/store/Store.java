package store;

import java.util.ArrayList;
import java.util.List;

public class Store {

	private int storeCode;		//가게코드
	private String name;		//지점이름
	private String address;		//주소
	private String phoneNumber;	//핸드폰번호
	private int totalSales;		//총 매출
	private List<Sales> salesList;	//주문 정보

	//상속관계를 지우기 위해 본사를 멤버필드로 갖는다. 본사의 메뉴리스트에 접근한다.
	private Headquarter headquarter;
	
	public Store() {}

	public Store(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.storeCode = storeCode + 1;
		this.salesList = new ArrayList<Sales>();
		this.headquarter = new Headquarter();
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
	

	public List<Sales> getSalesList() {
		return salesList;
	}


	public void setSalesList(List<Sales> salesList) {
		this.salesList = salesList;
	}


	@Override
	public String toString() {
		return " [ 가맹점 코드 : " + storeCode + ", 가맹점 명 : " + name + ", 주소 : " + address + ", 전화번호 : "
				+ phoneNumber + "]";
	}


	
}
