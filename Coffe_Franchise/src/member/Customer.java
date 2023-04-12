package member;

import java.util.ArrayList;
import java.util.List;

import menu.Menu;
import payment.Cash;
import payment.Credit;
import payment.Gifticon;
import payment.Payment;

public class Customer extends Member implements NoneAdmin {
	private int gifticon;
	private int stamp;
	private List<Order> orders;
	
	// 생성자
	Customer(String ID, String password, String memberType, String phoneNumber) {
		super(ID, password, memberType, phoneNumber);
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
	public void saveStamp() {
		int addStamp = this.orders.size();
		System.out.printf("현재 스탬프는 %d개 입니다.\n", this.stamp);
		this.stamp += addStamp;
		System.out.printf("총 %d개 적리되어 현재 스탬프는 %d개 입니다.\n", addStamp, this.stamp);
		this.createGifticon();
	}
	
	// 현재 보유중인 스탬프를 모두 기프티콘을 전환
	public void createGifticon() {
		while(this.stamp / 10 >= 1) {
			this.stamp -= 10;
			this.gifticon++;
		}
	}
	
	// 결제 진행
	public void payProducts(Payment payment) {
		int totalPrice = payment.getPaymetAmount();
		System.out.printf("총 결제금액은 %d원 입니다.\n", totalPrice);
		
		// 카드결제일 때
		if(payment instanceof Credit) {
			System.out.println("결제 완료");
			this.orders = new ArrayList<Order>();	// 장바구니 초기화
		} 
		
		// 현금결제일 때
		else if(payment instanceof Cash) {
			// 투입한 돈보다 결제금액이 작을 때
			if(payment.getPaymetAmount() <= ((Cash) payment).getInputMoney()) {
				System.out.println("결제 완료");
				this.orders = new ArrayList<Order>();	// 장바구니 초기화
				((Cash)payment).returnChange();	//거스름돈 반환
			} else {
				System.out.println("돈이 부족합니다.");
			}
			
		} 
		
		// 기프티콘 결제일 때
		else if(payment instanceof Gifticon) {
			if(this.gifticon>=1) {
				System.out.println("결제 완료");
				this.orders = new ArrayList<Order>();	// 장바구니 초기화
				this.gifticon--;
				System.out.printf("현재 잔여 기프티콘은 %d개 입니다.\n", gifticon);
			} else {
				System.out.println("잔여 기프티콘이 없습니다.");
			}
			
		}
	}
}