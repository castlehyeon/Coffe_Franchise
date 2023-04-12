package member;

import java.util.List;

import menu.Menu;

public class Customer extends Member implements NoneAdmin {
	private int gifticon;
	private int stamp;
	private List<Order> orders;
	
	public void orderMenu(int menuCount, Menu menu) {
		Order order = new Order(menuCount, menu);
		this.orders.add(order);
	}
	public void savsStamp() {
		
	}
	public void createGifticon() {
		
	}
}
