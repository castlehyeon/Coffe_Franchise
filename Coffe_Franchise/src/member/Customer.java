package member;

import java.util.List;

public class Customer extends Member implements NoneAdmin {
	private int gifticon;
	private int stamp;
	private List<Order> orders;
	
	public void orderMenu() {}
	public void savsStamp() {}
	public void createGifticon() {}
}
