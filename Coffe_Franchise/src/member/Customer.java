package member;

import java.util.ArrayList;
import java.util.List;

import menu.Menu;
import payment.Cash;
import payment.Credit;
import payment.Gifticon;
import payment.Payment;
import store.Sales;
import store.Store;

public class Customer extends Member implements NoneAdmin {
	private int gifticon;	// 기프티콘 개수
	private int stamp;		// 스탬프 개수
	private List<Order> orders;	// 장바구니
	private Store store;
	
	// 생성자
	Customer() {}
	public Customer(String ID, String password, String phoneNumber) {
		super(ID, password, phoneNumber);
		this.gifticon = 0;
		this.stamp = 0;
		this.orders = new ArrayList<Order>();
	}
	
	// 주문 수량과 메뉴를 받아 Customer의 장바구니에 저장
	public void orderMenu(int menuCount, Menu menu) {
		Order order = new Order(menuCount, menu);
		this.orders.add(order);
		System.out.printf("메뉴 %s %d개가 장바구니에 추가되었습니다.\n", menu.getMenuName(), menuCount);
	}
	
	// 주문 리스트에 있는 메뉴의 갯수만큼 스탬프 추가
	// 스탬프 추가는 결제 마지막에 진행
	public void saveStamp() {
		int addStamp = 0;
		for(Order order: orders) {
			addStamp += order.getMenuCount();
		}
		System.out.printf("현재 스탬프는 %d개, 기프티콘은 %d개 입니다.\n", this.stamp, this.gifticon);
		int currentStamp = this.stamp;
		this.stamp += addStamp;
		int currentGift = this.gifticon;
		System.out.printf("스탬프 총 %d개 적립되어 현재 스탬프는 %d개 입니다.\n", addStamp, this.stamp);
		System.out.println("잔여 스탬프를 기프티콘으로 변환합니다.");
		this.createGifticon();	// 스탬프 적립 후 기프티콘으로 전환
		System.out.printf("현재 스탬프는 %d개, 기프티콘은 %d개 입니다.\n", this.stamp, this.gifticon);
		this.orders = new ArrayList<Order>();	// 장바구니 초기화
		
	}
	
	// 현재 보유중인 스탬프를 모두 기프티콘을 전환
	public void createGifticon() {
		int temp = 0;
		while(this.stamp / 10 >= 1) {
			this.stamp -= 10;
			this.gifticon++;
			temp++;
		}
		System.out.printf("스탬프 %d개를 기프티콘 %d개로 변환했습니다.\n", temp*10, temp);
	}
	
	// 결제 진행
	public Sales payProducts(Payment payment, int totalPrice) {
		payment.setPaymetAmount(totalPrice);
		System.out.printf("총 결제금액은 %d원 입니다.\n", totalPrice);
		Sales sales = new Sales(this.store, this.orders, totalPrice, this);	// 주문내역 생성
		
		// 카드결제일 때
		if(payment instanceof Credit) {
			System.out.println("결제 완료");
			sales.setPayment(payment);
			this.saveStamp();
		} 
		
		// 현금결제일 때
		else if(payment instanceof Cash) {
			System.out.println("결제 완료");
			System.out.printf("거스름돈은 %d원 입니다.", ((Cash)payment).returnChange());
			sales.setPayment(payment);
			this.saveStamp();
		}
		
		// 기프티콘 결제일 때
		else if(payment instanceof Gifticon) {
			System.out.println("결제 완료");
			System.out.printf("현재 잔여 기프티콘은 %d개 입니다.\n", gifticon);
			sales.setPayment(payment);
		}
		
		return sales;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public int getGifticon() {
		return gifticon;
	}
	public void setGifticon(int gifticon) {
		this.gifticon = gifticon;
	}
	public int getStamp() {
		return stamp;
	}
	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
	
	
	
	
}