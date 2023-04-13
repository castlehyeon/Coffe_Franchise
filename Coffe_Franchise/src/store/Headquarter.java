package store;

import java.io.Serializable;
import java.util.List;

import member.Member;
import member.StoreAdmin;
import menu.Menu;


public class Headquarter implements Serializable {

	HeadquarterInfoManage headquarterInfoManage = new HeadquarterInfoManage();
	
	private String headquarterName;			//본사 이름
	//private static String headquarterPhoneNumber;		//본사 전화번호

	public String getHeadquarterName() {
		return headquarterName;
	}

	private List<Menu> menuList;				//메뉴
	//본사는 Store를 '리스트'로 갖고 있고, Store는 본사를 '멤버'로 갖게해서 상속을 지운다.
	private List<Store> storeList;//가맹점들

	private List<Member> memberList;

	private List<StoreAdmin> storeAdminList;

	public List<Menu> getMenuList() {
		return menuList;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public List<Member> getMemberList() { return memberList; }

	public List<StoreAdmin> getStoreAdminList() { return storeAdminList; }
  
	//생성자
	public Headquarter() {
		//	this.headquarterName = "DuzoneCoffe";
		//	this.headquarterPhoneNumber = "02-123-456";

		//Headquarter 객체들이 생성될 때마다 스태틱에 있는 리스트들의 정보를 받아서 초기화한다.
		HeadquarterInfoManage hm = new HeadquarterInfoManage();
		this.menuList = (List<Menu>) hm.getMenus();
		this.storeList = (List<Store>) hm.getStores();
		this.memberList = (List<Member>) hm.getMembers();
		this.storeAdminList = (List<StoreAdmin>) hm.getStoreAdmins();
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

	//아이디 중복검사
	public boolean duplicateId(String id) {
		boolean chkIdRun = false;
		List<Member> memberList = (List<Member>) headquarterInfoManage.getMembers();
		for(Member member : memberList) {
			if(id.equals(member.getID())) {
				chkIdRun = true;
				System.out.println("중복된 아이디가 있습니다. 다시 입력해주세요.");
			}
		}
		return chkIdRun;
	}
	
	//로그인
	public Member checkLogin(String id, String password) {
		Member loginMember = null;
		List<StoreAdmin> storeAdminList = (List<StoreAdmin>) headquarterInfoManage.getStoreAdmins();
		for(StoreAdmin storeAdmin : storeAdminList) {
			if(id.equals(storeAdmin.getID())) {
				if(password.equals(storeAdmin.getPassword())) {
					loginMember = storeAdmin;
				}else {
					System.out.println("비밀번호를 다시 확인해주세요.");
				}
			}else {
				System.out.println("아이디를 다시 확인해주세요.");
			}
		}

		List<Member> memberList = (List<Member>) headquarterInfoManage.getMembers();
		for(Member member : memberList) {
			if(id.equals(member.getID())) {
				if(password.equals(member.getPassword())) {
					loginMember = member;
				}else {
					System.out.println("비밀번호를 다시 확인해주세요.");
				}
			}else {
				System.out.println("아이디를 다시 확인해주세요.");
			}
		}
		
		return loginMember;
	}

}
