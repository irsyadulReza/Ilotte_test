package com.ilotte.reza.model;

public class PaymentMethode {
	
	private long id;
	private String methodePayment;
	private String cardNo;
	
	public PaymentMethode() {
		// TODO Auto-generated constructor stub
		id=0;
	}
	
	public PaymentMethode(long id, String methodePayment, String cardNo) {
		super();
		this.id = id;
		this.methodePayment = methodePayment;
		this.cardNo = cardNo;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMethodePayment() {
		return methodePayment;
	}
	public void setMethodePayment(String methodePayment) {
		this.methodePayment = methodePayment;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((methodePayment == null) ? 0 : methodePayment.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentMethode other = (PaymentMethode) obj;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (id != other.id)
			return false;
		if (methodePayment == null) {
			if (other.methodePayment != null)
				return false;
		} else if (!methodePayment.equals(other.methodePayment))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaymentMethode [id=" + id + ", methodePayment=" + methodePayment + ", cardNo=" + cardNo + "]";
	}
	
	

}
