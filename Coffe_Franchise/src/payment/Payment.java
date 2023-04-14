package payment;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Payment implements Serializable{
	private int PaymetAmount;
	private LocalDateTime PaymentTime;

	Payment() {
		PaymentTime = LocalDateTime.now();
	}

	public int getPaymetAmount() {
		return PaymetAmount;
	}

	public void setPaymetAmount(int paymetAmount) {
		PaymetAmount = paymetAmount;
	}

	public LocalDateTime getPaymentTime() {
		return PaymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		PaymentTime = paymentTime;
	}

}
