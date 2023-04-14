package store;

import java.io.Serializable;
import java.util.List;

import member.Member;
import member.Order;
import payment.Payment;

public class Sales implements Serializable {
	private Store store;
	private List<Order> orderList;
	private Payment payment;
	private int payMoney;
	private Member member;
	public Sales(){}
	public Sales(Store store, List<Order> orderList, int payMoney, Member member) {
		this.store = store;
		this.orderList = orderList;
		this.payMoney = payMoney;
		this.member = member;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
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