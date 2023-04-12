package payment;

import java.time.LocalDateTime;

public abstract class Payment {
	private int PaymentAmount;
	private LocalDateTime PaymentTime;
	
	Payment(){
		this.PaymentTime = LocalDateTime.now();
	}
	Payment(int paymentAmount) {
		this.PaymentAmount = paymentAmount;
		this.PaymentTime = LocalDateTime.now();
	}
	public int getPaymetAmount() {
		return PaymentAmount;
	}

	public void setPaymetAmount(int paymentAmount) {
		PaymentAmount = paymentAmount;
	}
	public LocalDateTime getPaymentTime() {
		return PaymentTime;
	}
	public void setPaymentTime(LocalDateTime paymentTime) {
		PaymentTime = paymentTime;
	}
	
}
