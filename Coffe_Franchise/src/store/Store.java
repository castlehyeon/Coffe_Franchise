package store;

import java.util.List;

import menu.Menu;

public class Store extends Headquarter{
	
	public String storeCode;	//가게코드
	public String name;			//지점이름
	public String address;		//주소
	public String phoneNumber;	//핸드폰번호
	public int totalSales;		//총 매출
	
	public Store(String storeCode, String name, String address, String phoneNumber, int totalSales) {
		this.storeCode = storeCode;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.totalSales = totalSales;
	}
	
	
}
