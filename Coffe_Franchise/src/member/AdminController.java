package member;

import java.util.Scanner;

import menu.Menu;
import store.Headquarter;
import store.HeadquarterInfoManage;
import store.Store;

public class AdminController {
    //어디서든지 하나의 Headquarter객체만을 사용할 수 있다.
    Headquarter headquarter = new Headquarter();
    HeadquarterInfoManage headquarterInfoManage = new HeadquarterInfoManage();
    public void start() {
        this.headquarterMainMenu();
    }

    //메인메뉴
    public void headquarterMainMenu() {
        System.out.println("1.가맹점관리 2.메뉴관리 3.회원관리 4.스탬프관리 0.종료");

        Scanner sc = new Scanner(System.in);
        int menuNum = sc.nextInt();

        switch (menuNum) {
            case 1 : manageStores();		break;//가맹점관리
            case 2 : manageMenu();			break;//메뉴관리
            case 3 : manageMembers();		break;//회원관리
            case 4 : manageStamps();		break;//스탬프관리
            case 0 : break;
            default : System.out.println("다시 선택해주세용"); headquarterMainMenu();
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
            case 3 : storeSalseList();	headquarterMainMenu();break;//가맹점별 매출조회
            case 4 : showStoreList(); 	headquarterMainMenu();break;//가맹점 리스트조회
            case 0 : break;
            default : System.out.println("다시 선택해주세용"); manageStores();
        }


        System.out.println();

    }

    //메뉴관리 메뉴 선택
    public void manageMenu() {
        System.out.println("메뉴관리를 선택하셨습니다.");

        System.out.println("1.메뉴생성 2.메뉴삭제 3.메뉴별 매출조회");

        Scanner sc = new Scanner(System.in);
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

    //회원관리 메뉴 선택
    public void manageMembers() {
        System.out.println("회원관리를 선택하셨습니다.");

    }

    //스탬프관리 메뉴 선택
    public void manageStamps() {
        System.out.println("스탬프관리를 선택하셨습니다.");

    }

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
            headquarter.getStoreList().add(addStore);

            System.out.println(addStore.toString());
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

    //가맹점들 출력하기
    public void showStoreList() {
        System.out.println("=========가맹점 리스트===========");
        for(Store store : headquarter.getStoreList()) {
            System.out.println(store.getName());
        }
        System.out.println("============================");
    }



    //메뉴번호로 메뉴 가져오기
    private Menu selectMenu(int menuCode) {
        Menu menu = new Menu(null, menuCode);
        for(Menu searchMenu : headquarter.getMenuList()) {
            if (menuCode == menu.getMenuCode()) {
                menu = searchMenu;
            }
        }
        return menu;
    }

    //메누생성
    public void createMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("메뉴 생성을 선택하셨습니다.");
        System.out.println("등록할 메뉴의 정보를 입력해주세요.");
        System.out.print("메뉴이름 : ");
        String name = sc.next();
        System.out.print("메뉴금액: ");
        int price = sc.nextInt();
        Menu addMenu = headquarterInfoManage.getMenu(name);
        //유효성 검사
        if(addMenu == null) {
            try {
                addMenu = new Menu(name, price);
                headquarterInfoManage.createMenu(name, price);

                headquarter.getMenuList().add(addMenu);
                System.out.println(addMenu);
                System.out.println("을 추가했습니다.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else System.out.println("동일한 메뉴가 존재합니다.");
    }

    //메뉴삭제
    public void deleteMenu() {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("메뉴 삭제를 선택하셨습니다.");
            System.out.println("삭제할 메뉴의 이름을 입력해주세요.");
            System.out.print("메뉴 이름 입력 : ");
            String name = sc.nextLine();

            Menu deleteMenu = headquarterInfoManage.getMenu(name);
            headquarter.getMenuList().remove(deleteMenu);
            System.out.println("삭제된 메뉴 : " + deleteMenu.toString());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //메뉴 보여주기
    public void showMenuList() {
        System.out.println("=========메뉴판===========");
        for(Menu menu : headquarter.getMenuList()) {
            System.out.println(menu.getMenuName());
        }
        System.out.println("========================");
    }

    //지점들 매출 리스트 뽑기
    public void storeSalseList(){
        for(Store store : headquarter.getStoreList()) {
            System.out.println(store.getName() + "지점 총 매출 : " + store.getTotalSales());
        }
    }
}