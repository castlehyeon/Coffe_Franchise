package member;

import java.util.List;
import java.util.Scanner;

import menu.Menu;
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
    	
//        System.out.println("아이디와 비밀번호 입력하기");
//        System.out.println("테스트 진행 id: aaa / pw: 1234 / phone: 0000");
//        Customer customer = new Customer("aaa","1234","0000");
//        customer.customerMainmenu();

    }
    
    // 접속할 가맹점을 선택한다
	public void selectStore() {
		/////////////////////////////
		Headquarter head = new Headquarter();
		/////////////////////////////
		boolean stop = false;
		try {
			System.out.println("접속할 가맹점을 선택하세요");
			for (Store store : head.getStoreList()) {
				System.out.println(store.getName());
			}
			int tempStoreCode = sc.nextInt();
			String storeName = head.getStoreList().get(tempStoreCode).getName();
			System.out.println(storeName + "을 선택하셨습니다.");
			this.addToCart();
		} catch (Exception e) {
			System.out.println("다시 선택하세요");
			this.selectStore();
		}

	}
    
    
	// 메뉴를 선택하고 장바구니에 추가한다.
	public void addToCart() {
		/////////////////////////////
		Headquarter head = new Headquarter();
		/////////////////////////////
		head.getMenuList();
		for(Menu menu: head.getMenuList()) {
			System.out.println();
		}

	}
    
    
    //결제한다.
    public void purchase() {
    	
    }
    
    public int binarySearch(List<Store> storeList, int keyIndex) {
    	int temp = storeList.get(keyIndex).getStoreCode();
    	while(true) {
    		
    	}
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 62203aa911804b9723d42d942bcafe66a52e3e1f
