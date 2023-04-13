package member;

import java.util.Scanner;

import store.Headquarter;
import store.HeadquarterInfoManage;

//가맹점주
public class StoreOwnerController {
    
	Headquarter headquarter = new Headquarter();
    HeadquarterInfoManage headquarterInfoManage = new HeadquarterInfoManage();
    
	public void start() {
        this.storeOwnerMainMenu();
    }

    //메인메뉴
    public void storeOwnerMainMenu() {
        System.out.println("1.매출보기 2.가맹점정보 변경 0.종료");

        Scanner sc = new Scanner(System.in);
        int menuNum = sc.nextInt();

        switch (menuNum) {
            case 1 : //showTotal();			break;//매출 보기
            case 2 : updateStoreInfo();		break;//개맹점 정보 변경
            case 0 : break;
            default : System.out.println("유효한 값을 입력해주세요."); storeOwnerMainMenu();
        }
    }
    
    //가맹점관리
//    public void showTotal() {
//    	System.out.println("매출보기를 선택하셨습니다.");
//    	System.out.println("1.시간대별 매출보기 2.기간별 매출보기");
//
//        Scanner sc = new Scanner(System.in);
//        int menuNum = sc.nextInt();
//
//        switch (menuNum) {
//            case 1 : showTotalSalesByTime();		break;//매출 보기
//            case 2 : showTotalClientByTime();		break;//개맹점 정보 변경
//            case 0 : break;
//            default : System.out.println("유효한 값을 입력해주세요."); showTotal();
//        }
//    }
    
	//가맹점 정보변경 
	public void updateStoreInfo() {
		System.out.println("가맹점 정보변경을 선택하셨습니다.");
		
	}
		
	//
	public void showTotalClientByTime() {
		
	}
}
