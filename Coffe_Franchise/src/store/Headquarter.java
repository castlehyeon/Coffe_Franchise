package store;

import menu.Menu;

import java.util.ArrayList;
import java.util.List;


public class Headquarter {
	//프로그램은 하나의 본사 객체만을 사용한다.
	private static Headquarter instance = null;



	private String headquarterName;			//본사 이름
	//private static String headquarterPhoneNumber;		//본사 전화번호

	public String getHeadquarterName() {
		return headquarterName;
	}

	private List<Menu> menuList;				//메뉴
	private List<Store> storeList;				//가맹점들

	public List<Menu> getMenuList() {
		return menuList;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	//private으로 선언하여 객체생성 방지
	private Headquarter() {
	//	this.headquarterName = "DuzoneCoffe";
	//	this.headquarterPhoneNumber = "02-123-456";
		
		this.menuList = new ArrayList();
		this.storeList = new ArrayList();

	}
	//같은 클래스 내에서는 접근 가능하므로 기본생성자로 객체생성이 가능하다.
	public static Headquarter getInstance() {
		//	this.headquarterName = "DuzoneCoffe";
		//	this.headquarterPhoneNumber = "02-123-456";
		if (instance == null) {
			instance = new Headquarter();
		}
		return instance;

	}

	protected Headquarter(String args){
		super();
	}
	
//	public static String getHeadquarterName() {
//		return headquarterName;
//	}
//
//	public static String getHeadquarterPhoneNumber() {
//		return headquarterPhoneNumber;
//	}


	//본사는 가맹점을 추가할 수 있다.

		
	
	@Override
	public String toString() {
		return "본사의 메뉴리스트" + menuList.toString() + "\n 가맹점 리스트" + storeList.toString();
	}
	

}
