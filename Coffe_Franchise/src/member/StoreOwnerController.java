package member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import global.Controller;
import store.Headquarter;
import store.HeadquarterInfoManage;
import store.Sales;
import store.Store;

//가맹점주
public class StoreOwnerController {
    
	Headquarter headquarter = new Headquarter();
    Controller controller;
    HeadquarterInfoManage headquarterInfoManage = new HeadquarterInfoManage();
    StoreOwner storeOwner;
    private Store myStore;

	public void setStoreOwner(StoreOwner storeOwner) {
		this.storeOwner = storeOwner;
		this.myStore = headquarterInfoManage.setMyStore(storeOwner);
	}
	
	public void start() {
        this.storeOwnerMainMenu();
    }

    //메인메뉴
    public void storeOwnerMainMenu() {
        System.out.println("1.매출보기 2.가맹점정보 변경 0.종료");

        Scanner sc = new Scanner(System.in);
        int menuNum = sc.nextInt();

        switch (menuNum) {
            case 1 : showTotalSalesByTime();	break;//매출 보기
            case 2 : updateStoreInfo();			break;//개맹점 정보 변경
            case 0 : this.controller.start(); 	break;
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
//            case 1 : showTotalSalesByTime();						break;//시간대별 매출보기
//            case 2 : System.out.println("기간별 매출보기 구현중...");		break;//기간별 매출보기
//            case 0 : break;
//            default : System.out.println("유효한 값을 입력해주세요."); showTotal();
//        }
//    }
    
	//가맹점 정보변경 
	public void updateStoreInfo() {
		System.out.println("가맹점 정보변경을 선택하셨습니다.");
		System.out.println("나의 가맹점 정보");
		System.out.println(myStore.toString());
		
	}
		
	//시간대별 매출보기
	public void showTotalSalesByTime() {
		System.out.println("시간대별 매출보기를 선택하셨습니다.");
		
		this.myStore = headquarterInfoManage.setMyStore(storeOwner);
		
		int todayTotalSales = 0;
		List<Sales> todaySalesList = new ArrayList<>();
		LocalDate today = LocalDate.now();
		Map<Integer,Integer> timeTotalPay = new HashMap();
		
		for(Sales sales : myStore.getSalesList()) {
			if(today.isEqual(sales.getPayment().getPaymentTime().toLocalDate())) {
				todaySalesList.add(sales);
				todayTotalSales += sales.getPayment().getPaymetAmount();
			}
		}	
    	
		for(Sales s : todaySalesList) {
			if(timeTotalPay.containsKey(s.getPayment().getPaymentTime().getHour())) {
				int totalpay = timeTotalPay.get(s.getPayment().getPaymentTime().getHour());
				totalpay += s.getPayMoney();
				timeTotalPay.put(s.getPayment().getPaymentTime().getHour(),totalpay);
			}else {
				timeTotalPay.put(s.getPayment().getPaymentTime().getHour(),s.getPayMoney());
			}
    	}
    	
    	//map value의 내림차순대로 뽑기!
    	List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(timeTotalPay.entrySet());
    	entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
    	    @Override
    	    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
    		return o2.getValue() - o1.getValue();
    	    }
    	});
    	
    	//오늘 하루 총매출 구하기
    	System.out.println();
    	System.out.println("==========================");
    	System.out.println(today);
    	System.out.println("총 매출 : " + todayTotalSales);
    	System.out.println("시간대별 매출 기록");
    	for(Map.Entry<Integer, Integer> entry : entryList){
    		System.out.println("시간 : " + entry.getKey() + " 매출액 : " + entry.getValue());
    	}
    	System.out.println("==========================");
		
	}
	
	
	//총 매출 구하기
	public List<Sales> totalSales() {
		this.myStore = headquarterInfoManage.setMyStore(storeOwner);
		
		int todayTotalSales = 0;
		List<Sales> todaySalesList = null;
		LocalDate today = LocalDate.now();
		
		for(Sales sales : myStore.getSalesList()) {
			if(today.isEqual(sales.getPayment().getPaymentTime().toLocalDate())) {
				todaySalesList.add(sales);
				todayTotalSales += sales.getPayment().getPaymetAmount();
			}
		}
		
		return todaySalesList;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
}
