package member;

import java.util.Scanner;

import store.Headquarter;
import store.Store;

public class MemberController {
	Scanner sc = new Scanner(System.in);
    public void start() {
    	System.out.println("고객으로 접속합니다");
    	boolean stop = false;
    	while(stop) {
    		System.out.println("로그인이 필요합니다");
    		System.out.println("ID를 입력하세요");
    		String tempID = sc.nextLine();
    		System.out.println("비밀번호를 입력하세요");
    		String tempPW = sc.nextLine();
    		/*
    		 * ID와 PW를 비교해서 로그인 여부 판단한다.    		 * 
    		 * 
    		 */
    	}
    	
    }
    
    // 접속할 가맹점을 선택한다
	public void selectStore() {
		/////////////////////////////
		Headquarter head = new Headquarter();
		/////////////////////////////
		boolean stop = false;
		while (stop) {
			try {
				System.out.println("접속할 가맹점을 선택하세요");
				for (Store store : head.getStoreList()) {
					System.out.println(store.getStoreCode() + "." + store.getName());
				}
				int tempStoreCode = sc.nextInt();
				String storeName = head.getStoreList().get(tempStoreCode).getName();
				System.out.println(storeName + "을 선택하셨습니다.");
			} catch (Exception e) {

			}
		}

	}
    
    
    // 메뉴를 선택하고 장바구니에 추가한다.
    public void addToCart() {
    	
    }
    
    
    //결제한다.
    public void purchase() {
    	
    }

}
