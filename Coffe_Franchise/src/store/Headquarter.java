package store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import global.globalVariable;
import member.Member;
import menu.Menu;

public class Headquarter {

	private String headquarterName;				//본사 이름
	private String headquarterPhoneNumber;		//본사 전화번호
	private List<Menu> menuList;				//메뉴
	private List<Store> storeList;				//가맹점들
	private List<Member> memberList;			//회원리스트
	
	//생성자
	public Headquarter() {
		this.headquarterName = globalVariable.HeadquarterName;
		this.headquarterPhoneNumber = globalVariable.HeadquarterPhoneNum;
		this.menuList = new ArrayList<>();
		this.storeList = new ArrayList<>();
		this.memberList = new ArrayList<>();
	}

	public String getHeadquarterName() {
		return headquarterName;
	}

	public String getHeadquarterPhoneNumber() {
		return headquarterPhoneNumber;
	}

	//메인메뉴 
	public void headquarterMainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 가맹점관리 2. 메뉴관리 3. 회원관리 4. 스탬프관리 0. 종료");
		int menuNum = sc.nextInt();
		 
		switch (menuNum) {
			case 1 : manageStores();		break;//가맹점관리
			case 2 : manageMenu();			break;//메뉴관리
			case 3 : manageMembers();		break;//회원관리
			case 4 : System.out.println("스탬프관리 구현중...");		break;//스탬프관리
			case 0 : break;
			default : System.out.println("유효한 값을 입력해주세요."); headquarterMainMenu();
		}
	}
		
	/**
	 * 가맹점관리 
	 */
	//고유번호로 가명점 찾기
	public Store selectStore(int storeNum) {
		Store store = new Store(null, null, null);
		for(Store searchStore : storeList) {
			if (storeNum == searchStore.getStoreCode()) {
				store = searchStore;
			}
		}
		return store;
	}
		
	//가맹점 추가
	public void addStore() {	
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("가맹점 추가를 선택하셨습니다.");
			System.out.println("등록할 가맹점의 정보를 입력해주세요.");
			System.out.print("가맹점 이름 : ");
			String name  = sc.next();
			System.out.print("가명점 주소 : ");
			String address  = sc.next();
			System.out.print("가맹점 핸드폰 번호 : ");
			String phoneNumber  = sc.next();
			
			Store addStore = new Store(name, address, phoneNumber);
			storeList.add(addStore);
			
			System.out.println(addStore.toString());
			System.out.println("을 추가했습니다.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//가맹점 삭제
	public void removeStore() {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("가맹점 삭제를 선택하셨습니다.");
			System.out.println("삭제할 가맹점의 가맹점고유번호를 입력해주세요.");
			System.out.print("가맹점 고유번호 입력 : ");
			int storeNum  = sc.nextInt();
			
			Store removeStore = selectStore(storeNum);
			storeList.remove(removeStore);
			
			System.out.println(removeStore.toString());
			System.out.println("을 삭제했습니다.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//가맹점리스트 출력하기
	public void showStoreList() {
		System.out.println("=========가맹점 리스트===========");
		for(Store store : storeList) {
			System.out.println(store.getName());
		}
		System.out.println("============================");
	}
	

	/**
	 * 메뉴관리
	 */
	//메뉴관리 메뉴 선택 
	public void manageMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴관리를 선택하셨습니다.");
		System.out.println("1.메뉴생성 2.메뉴삭제 3.메뉴별 매출조회");
		int menuNum = sc.nextInt();
		 
		switch (menuNum) {
			case 1 : createMenu();		headquarterMainMenu(); break;//메뉴 생성
			case 2 : deleteMenu();		headquarterMainMenu(); break;//메뉴 삭제
			case 3 : System.out.println("메뉴별 매출조회 구현중..."); headquarterMainMenu(); break;//menuSalseList();	break; 메뉴별 매출조회
			case 0 : break;
			default : System.out.println("다시 선택해주세용"); manageStores();
		}
		
		System.out.println();
	}
	
	//메뉴번호로 메뉴 가져오기
	private Menu selectMenu(int menuCode) {
		Menu menu = new Menu(null, menuCode);
		for(Menu searchMenu : menuList) {
			if (menuCode == menu.getMenuCode()) {
				menu = searchMenu;
			}
		}
		return menu;
	}

	//메뉴 리스트
	public void showMenuList() {
		System.out.println("=========메뉴판===========");
		for(Menu menu : menuList) {
			System.out.println(menu.getMenuName());
		}
		System.out.println("========================");
	}

	//메뉴생성
	public void createMenu() {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("메뉴 생성을 선택하셨습니다.");
			System.out.println("등록할 메뉴의 정보를 입력해주세요.");
			System.out.print("메뉴이름 : ");
			String name  = sc.next();
			System.out.print("메뉴금액: ");
			int price  = sc.nextInt();
			
			Menu addMenu = new Menu(name, price);
			menuList.add(addMenu);
			
			System.out.println(addMenu.toString());
			System.out.println("을 추가했습니다.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//메뉴삭제
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("메뉴 삭제를 선택하셨습니다.");
			System.out.println("삭제할 메뉴의 가맹점고유번호를 입력해주세요.");
			System.out.print("가맹점 고유번호 입력 : ");
			int deleteMenuCode  = sc.nextInt();
			
			Menu deleteMenu = selectMenu(deleteMenuCode);
			menuList.remove(deleteMenu);
			System.out.println("삭제된 메뉴 : " + deleteMenu.toString());
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 가맹점관리
	 */
	//가맹점관리 메뉴 선택 
	public void manageStores() {
		System.out.println("가맹점관리를 선택하셨습니다.");
		
		System.out.println("1.가맹점생성 2.가맹점삭제 3.가맹점별 매출조회 4.가맹점 리스트");
		
		Scanner sc = new Scanner(System.in);
		int menuNum = sc.nextInt();
		 
		switch (menuNum) {
			case 1 : addStore();		headquarterMainMenu();break;//가맹점 생성
			case 2 : removeStore();		headquarterMainMenu();break;//가맹점 삭제
			case 3 : storeSalseList();	headquarterMainMenu();break;//가맹점별 매출조회
			case 4 : showStoreList(); 	headquarterMainMenu();break;//가맹점 리스트조회
			case 0 : break;
			default : System.out.println("다시 선택해주세용"); manageStores();
		}
		
		System.out.println();
	}
	
	//지점들 매출 리스트 뽑기
	public void storeSalseList(){
		for(Store store : storeList) {
			System.out.println(store.getName() + "지점 총 매출 : " + store.getTotalSales());
		}
	}
	
	//회원관리 메뉴 선택 
	public void manageMembers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("회원관리를 선택하셨습니다.");
		System.out.println("1. 회원 목록 2. 회원별 매출 순위 3. 회원별 스탬프 적립 현황 ");
		int menuNum = sc.nextInt();
		
		switch (menuNum) {
			case 1 : showMemeberList();		 	break;	//회원목록
			case 2 : rankByMember();		 	break;	//회원별 매출 순위
			case 3 : System.out.println("회원 별 스탬프 적립 현황 구현중...");break;
			case 0 : break;
			default : System.out.println("다시 선택해주세용"); manageStores();
		}
		
	}
	
	//회원목록
	public void showMemeberList() {
		System.out.println("회원목록을 선택하셨습니다.");
		System.out.println("========회원목록==========");
		for(Member member : memberList) {
			System.out.println(member.toString());
		}
		System.out.println("=======================");
	}

	//회원별 매출 순위
	public void rankByMember() {
		System.out.println("회원별 매출순위를 선택하셨습니다.");
		System.out.println("구현불가합니당");
	}
	
	//회원 추가
	public void addMember(Member newMember){
		memberList.add(newMember);
		System.out.println("회원가입이 완료되었습니다.");
	}
	
//	//스탬프관리 메뉴 선택 
//	public void manageStamps() {
//		System.out.println("스탬프관리를 선택하셨습니다.");
//		
//	}
	
	/**
	 * 로그인 & 회원가입 
	 */
	//아이디 중복검사
	public boolean duplicateId(String id) {
		boolean chkIdRun = false;
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
