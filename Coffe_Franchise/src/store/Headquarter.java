package store;

import member.Member;
import menu.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Headquarter {

	private String headquarterName;			//본사 이름
	//private static String headquarterPhoneNumber;		//본사 전화번호

	public String getHeadquarterName() {
		return headquarterName;
	}

	private List<Menu> menuList;				//메뉴
	//본사는 Store를 '리스트'로 갖고 있고, Store는 본사를 '멤버'로 갖게해서 상속을 지운다.
	private List<Store> storeList;//가맹점들

	private List<Member> memberList;

	public List<Menu> getMenuList() {
		return menuList;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public List<Member> getMemberList() { return memberList; }
	//생성자
	public Headquarter() {
		//	this.headquarterName = "DuzoneCoffe";
		//	this.headquarterPhoneNumber = "02-123-456";

		//Headquarter 객체들이 생성될 때마다 스태틱에 있는 리스트들의 정보를 받아서 초기화한다.
		HeadquarterInfoManage hm = new HeadquarterInfoManage();
		this.menuList = (List<Menu>) hm.getMenus();
//		this.storeList = (List<Store>) hm.getStores();
//		this.memberList = (List<Member>) hm.getMembers();

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
