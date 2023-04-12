package store;

import java.util.List;

import member.Member;
import menu.Menu;
import payment.Payment;

public class Sales {
	private int storeCode;
	private List<Menu> orderList;
	private Payment payment;
	private int payMoney;
	private Member member;
	
	Sales(int storeCode, List<Menu> orderList, Payment payment, int payMoney, Member member) {
		this.storeCode = storeCode;
		this.orderList = orderList;
		this.payment = payment;
		this.payMoney = payMoney;
		this.member = member;
	}
}

