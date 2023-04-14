package member;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import global.Controller;
import menu.Menu;
import store.Headquarter;
import store.HeadquarterInfoManage;
import store.Sales;
import store.Store;

public class AdminController {
    //어디서든지 하나의 Headquarter객체만을 사용할 수 있다.
    Headquarter headquarter = new Headquarter();
    HeadquarterInfoManage headquarterInfoManage = new HeadquarterInfoManage();
    
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        this.headquarterMainMenu();
    }

    //메인메뉴
    public void headquarterMainMenu() {
        System.out.println("1.가맹점관리 2.메뉴관리 3.회원관리 0.종료");

        Scanner sc = new Scanner(System.in);
        int menuNum = sc.nextInt();

        switch (menuNum) {
            case 1 : manageStores();		break;//가맹점관리
            case 2 : manageMenu();			break;//메뉴관리
            case 3 : manageMembers();		break;//회원관리
            case 0 : this.controller.start(); break;
            default : System.out.println("유효한 값을 입력해주세요."); headquarterMainMenu();
        }
    }


    //가맹점관리 메뉴 선택
    public void manageStores() {
        System.out.println("가맹점관리를 선택하셨습니다.");

        System.out.println("1.가맹점생성 2.가맹점삭제 3.가맹점별 매출조회 4.가맹점 리스트");

        Scanner sc = new Scanner(System.in);
        int menuNum = sc.nextInt();

        switch (menuNum) {
            case 1 : addStore();		headquarterMainMenu();break;//가맹점 생성
            case 2 : removeStore();		headquarterMainMenu();break;//가맹점 삭제
            case 3 : showStoreList(); 	headquarterMainMenu();break;//가맹점 리스트조회
            case 0 : break;
            default : System.out.println("유효한 값을 입력해주세요."); manageStores();
        }


        System.out.println();

    }

    //메뉴관리 메뉴 선택
    public void manageMenu() {
        System.out.println("메뉴관리를 선택하셨습니다.");
        showMenuList();
        System.out.println("1.메뉴생성 2.메뉴삭제 3.메뉴 수정");

        Scanner sc = new Scanner(System.in);
        int menuNum = sc.nextInt();

        switch (menuNum) {
            case 1 : createMenu();		headquarterMainMenu(); break;	//메뉴 생성
            case 2 : deleteMenu();		headquarterMainMenu(); break;	//메뉴 삭제
            case 3 : updateMenu();		headquarterMainMenu(); break;	//메뉴 수정
            case 0 : break;
            default : System.out.println("유효한 값을 입력해주세요."); manageStores();
        }

        System.out.println();

    }

    //메뉴수정
    public void updateMenu() {
    	Scanner sc = new Scanner(System.in);
    	int temp = 0;
    	
    	System.out.println("메뉴수정을 선택하셨습니다.");
    	System.out.println("현재 메뉴");
    	for(Menu menu : headquarter.getMenuList()) {
    		System.out.println(menu.toString());
    	}
    	
    	System.out.println("변경할 메뉴의 코드를 입력해주세요.");
    	int menuCode = sc.nextInt();
    	Menu menu = headquarterInfoManage.getMenu(menuCode);
        
        System.out.println("변경할 항목을 선택해주세요.");
        System.out.println("1. 메뉴이름 2. 메뉴가격");
        temp = sc.nextInt();
        
        switch (temp) {
			case 1: System.out.printf("메뉴이름 입력 : ");
					String menuName = sc.nextLine();
					menu.setMenuName(menuName);
					headquarterInfoManage.setMenu(menu);
					break;
			case 2: System.out.printf("메뉴가격 입력 : ");
					int menuPrice = sc.nextInt();
					menu.setMenuPrice(menuPrice);
					headquarterInfoManage.setMenu(menu);
					break;
			default:
		}
    	
    }
    
    //회원관리 메뉴 선택
    public void manageMembers() {
    	System.out.println("회원관리를 선택하셨습니다.");
        System.out.println("1.회원리스트 조회 2.가맹점주 등록하기 3.회원별 매출순위 ");
        
        Scanner sc = new Scanner(System.in);
        int menuNum = sc.nextInt();

        switch (menuNum) {
            case 1 : showMemberList();	headquarterMainMenu(); 	break;	//회원리스트
            case 2 : transformMember();	headquarterMainMenu();  break;	//가앰점주 등록하기
            case 3 : rankSalesMembers(); headquarterMainMenu(); break;	//회원별 매출순위
            case 0 : break;
            default : System.out.println("다시 선택해주세용"); manageStores();
        }

        System.out.println();    
    }
    
    //회원별 매출순위
    public void rankSalesMembers() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("회원별 매출순위를 선택하셨습니다.");
    	
    	Map<String,Integer> idTotalPay = new HashMap();
    	for(Store m : headquarter.getStoreList()) {
    		for(Sales s : m.getSalesList()) {
    			if(idTotalPay.containsKey(s.getMember().getID())) {//1회이상 결재내역이 있을때!
    				int totalpay = idTotalPay.get(s.getMember().getID());
    				totalpay += s.getPayMoney();
    				idTotalPay.put(s.getMember().getID(),totalpay);
    			}else {
    				idTotalPay.put(s.getMember().getID(),s.getPayMoney());
    			}
    		}
    	}
    	
    	//map value의 내림차순대로 뽑기!
    	List<Map.Entry<String, Integer>> entryList = new LinkedList<>(idTotalPay.entrySet());
    	entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
    	    @Override
    	    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
    		return o2.getValue() - o1.getValue();
    	    }
    	});
    	
    	for(Map.Entry<String, Integer> entry : entryList){
    		System.out.println("ID : " + entry.getKey() + ", 구매총액 : " + entry.getValue());
    	}
    }
    
    
    //가앰점주 등록하기
    public void transformMember(){
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("가맹점주 등록하기를 선택하셨습니다.");
    	System.out.println("예비 가맹점주의 아이디를 입력해주세요.");
    	System.out.print("ID : ");
    	String id = sc.next();
    	System.out.println("가맹점주와 연결할 매장코드를 입력해주세요.");
    	int storeCode = sc.nextInt();
    	
    	for(Member m : headquarter.getMemberList()) {
    		if (m.getID().equals(id)) {
				StoreOwner storeAdmin = new StoreOwner(m.getID(), m.getPassword(), m.getPhoneNumber(), storeCode);
				
    		}
    	}
    }

    public void addStore() {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("가맹점 추가를 선택하셨습니다.");
            System.out.println("등록할 가맹점의 정보를 입력해주세요.");
            System.out.print("가맹점 이름 : ");
            String name  = sc.nextLine();
            System.out.print("가명점 주소 : ");
            String address  = sc.nextLine();
            System.out.print("가맹점 핸드폰 번호 : ");
            String phoneNumber  = sc.nextLine();

            Store addStore = new Store(name, address, phoneNumber);
            headquarter.getStoreList().add(addStore);

            System.out.print("가맹점 ");
            System.out.print(addStore.toString());
            System.out.println("을 추가했습니다.");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //고유번호로 가명점 찾기
    public Store selectStore(int storeNum) {
        Store store = new Store(null, null, null);
        for(Store searchStore : headquarter.getStoreList()) {
            if (storeNum == searchStore.getStoreCode()) {
                store = searchStore;
            }
        }
        return store;
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
            headquarter.getStoreList().remove(removeStore);

            System.out.println(removeStore.toString());
            System.out.println("을 삭제했습니다.");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    //메누생성
    public void createMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.print("메뉴 생성을 선택하셨습니다.");
        System.out.println("등록할 메뉴의 정보를 입력해주세요.");
        System.out.print("메뉴이름 : ");
        String name = sc.next();
        System.out.print("메뉴금액: ");
        int price = sc.nextInt();
        Menu newMenu = new Menu(name,price);
        headquarter.getMenuList().add(newMenu);
        System.out.println("메뉴 " + newMenu.toString() + "를 추가했습니다.");
        System.out.println();	
    }

    //메뉴삭제
    public void deleteMenu() {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("메뉴 삭제를 선택하셨습니다.");
            System.out.println("삭제할 메뉴의 이름을 입력해주세요.");
            System.out.print("메뉴 코드 입력 : ");
            int menuCode = sc.nextInt();

            Menu deleteMenu = headquarterInfoManage.getMenu(menuCode);
            headquarter.getMenuList().remove(deleteMenu);
            System.out.println("삭제된 메뉴 : " + deleteMenu.toString());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //메뉴 보여주기
    public void showMenuList() {
    	if(headquarter.getMenuList().size()==0){
    		System.out.println("등록된 메뉴가 없습니다.");
    	}else{
    		System.out.println();
	        System.out.println("=============메뉴리스트==============");
	        for(Menu menu : headquarter.getMenuList()) {
	            System.out.println(menu.toString());
	        }
	        System.out.println("===============================");
    	}
    }

    //회원목록
    public void showMemberList() {
    	if(headquarter.getMemberList().size()==0){
    		System.out.println("회원 목록이 없습니다.");
    	}else{
    		System.out.println();
	        System.out.println("=============회원리스트==============");
	        for(Member member : headquarter.getMemberList()) {
	            System.out.println(member.toString());
	        }
	        System.out.println("===============================");
    	}
    }
    
    //가맹점목록
    public void showStoreList() {
    	if(headquarter.getStoreList().size()==0) {
    		System.out.println("가맹점 목록이 없습니다.");
    	}else{
	        System.out.println("=========가맹점 리스트===========");
	        for(Store store : headquarter.getStoreList()) {
	            System.out.println(store.toString());
	        }
	        System.out.println("============================");
    	}
    }
    
    
    
}
