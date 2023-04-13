package store;

import java.util.List;

import member.Member;
import member.Order;
import payment.Payment;

public class Sales {
	private int storeCode;
	private List<Order> orderList;
	private Payment payment;
	private int payMoney;
	private Member member;
	public Sales(){}
	public Sales(int storeCode, List<Order> orderList, Payment payment, int payMoney, Member member) {
		this.storeCode = storeCode;
		this.orderList = orderList;
		this.payment = payment;
		this.payMoney = payMoney;
		this.member = member;
	}
	public int getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public int getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
}