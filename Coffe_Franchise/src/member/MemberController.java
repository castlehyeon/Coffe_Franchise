package member;

import java.util.List;
import java.util.Scanner;

import menu.Menu;
import payment.Cash;
import payment.Credit;
import payment.Gifticon;
import store.Headquarter;
import store.HeadquarterInfoManage;
import store.Sales;
import store.Store;

public class MemberController {
	Scanner sc = new Scanner(System.in);
	Headquarter head = new Headquarter();
	HeadquarterInfoManage headInfoManager = new HeadquarterInfoManage();
	Customer customer;
	Store store;
    public void start(Customer customer) {
    	System.out.println("고객으로 접속합니다");
    	this.customer = customer;
    	this.selectStore();
    }
    
    
    // 접속할 가맹점을 선택한다
	public void selectStore() {
		boolean stop = false;
		try {
			System.out.println("접속할 가맹점 번호를 선택하세요");
			for (int i=0; i<head.getStoreList().size(); i++) {
				System.out.println(i+". "+head.getStoreList().get(i).getName());
			}
			int index = sc.nextInt();
			Store store = head.getStoreList().get(index);
			String storeName = store.getName();
			System.out.println(storeName + "을 선택하셨습니다.");
			this.customer.setStore(store);
			this.addToCart();
		} catch (NullPointerException e) {
			System.out.println("가맹점 정보가 없습니다.");
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("올바른 값을 입력하세요");
			this.selectStore();
		}

	}
    
    
	// 메뉴를 선택하고 장바구니에 추가한다.
	public void addToCart() {
		System.out.println("메뉴를 선택하십시오");
		try {
			for (int i = 0; i < head.getMenuList().size(); i++) {
				System.out.println(i + ". " + head.getMenuList().get(i).getMenuName());
			}
			int index = sc.nextInt();
			Menu menu = head.getMenuList().get(index);
			System.out.println("주문 수량을 입력해 주세요.");
			int menuCount = sc.nextInt();
//			sc.nextLine();
			customer.orderMenu(menuCount, menu);
			boolean stop = false;
			while (stop) {
				System.out.println("계속 하시겠습니까? (y/n)");
				String addMore = sc.next();
				if (addMore.equals("y")) {
					stop = true;
					this.addToCart();
				} else if (addMore.equals("n")) {
					stop = true;
					this.purchase();
				} else {
					System.out.println("y 또는 n만 입력하십시오");
				}
			}
		} catch (Exception e) {
			System.out.println("올바른 값을 입력하십시오");
			this.addToCart();
		}
	}
    
    
    //결제한다.
    public void purchase() {
    	System.out.println("결제 방법을 선택하십시오");
    	System.out.println("1.카드	2.현금	3.기프티콘");
    	int select = sc.nextInt();
    	List<Sales> sales = store.getSalesList();
		switch (select) {
		case 1:
			sales.add(customer.payProducts(new Credit()));
			store.setSalesList(sales);
			break;
		case 2:
			sales.add(customer.payProducts(new Cash()));
			store.setSalesList(sales);
			break;
		case 3:
			sales.add(customer.payProducts(new Gifticon()));
			store.setSalesList(sales);
			break;
		default:
			System.out.println("올바른 결제 방법을 선택하십시오");
			this.purchase();
		}
    }
    

}
