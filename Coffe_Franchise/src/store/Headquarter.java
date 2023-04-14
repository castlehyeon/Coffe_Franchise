package store;

import java.io.Serializable;
import java.util.List;

import member.Member;
import member.StoreAdmin;
import menu.Menu;


public class Headquarter implements Serializable {

	private String headquarterName;			//본사 이름
	//private static String headquarterPhoneNumber;		//본사 전화번호

	public String getHeadquarterName() {
		return headquarterName;
	}

	public List<Menu> getMenuList() {
		return (List<Menu>) new HeadquarterInfoManage().getMenus();
	}

	public List<Store> getStoreList() {
		return (List<Store>) new HeadquarterInfoManage().getStores();
	}

	public List<Member> getMemberList() { 
		return (List<Member>) new HeadquarterInfoManage().getMembers();
	
	}

	public List<StoreAdmin> getStoreAdminList() {
		
		return (List<StoreAdmin>) new HeadquarterInfoManage().getStoreAdmins();
		
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
		return "본사의 메뉴리스트" + this.getMenuList().toString() + "\n 가맹점 리스트" + this.getStoreList().toString();
	}

	//아이디 중복검사
	public boolean duplicateId(String id) {
		boolean chkIdRun = false;
		List<Member> memberList = this.getMemberList();
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
		boolean isStoreAdmin = false;
		boolean isCustomer = false;
		
		List<StoreAdmin> storeAdminList = this.getStoreAdminList();
		for (StoreAdmin storeAdmin : storeAdminList) {
			if (id.equals(storeAdmin.getID())) {
				if (password.equals(storeAdmin.getPassword())) {
					isStoreAdmin = true;
					loginMember = storeAdmin;
				}
			}
		}
		
		List<Member> memberList = this.getMemberList();
		
		for(Member member : memberList) {
			if(id.equals(member.getID())) {
				if(password.equals(member.getPassword())) {
					isCustomer = true;
					loginMember = member;
				}
			}
		}
		if(isStoreAdmin) System.out.println("본사 관리자로 로그인합니다.");
		if(isCustomer) System.out.println("가맹점점주로 로그인합니다.");
		if (isStoreAdmin == false && isCustomer == false) System.out.println("일치하는 회원정보가 없습니다.");
		
		
		return loginMember;
	}

}
