package com.ilotte.reza.model;

import java.util.List;

public class OrderDetails {
	
	private long orderId;
	private double unitCost;
	private double subTotal;
	private List<ShoppingCart> shoppingCarts;
	private List<PaymentMethode> paymentMethodes;
	private List<DeliveryAddress> addresses;
	
	public OrderDetails() {
		// TODO Auto-generated constructor stub
		orderId=0;
	}
	
	public OrderDetails(long orderId, double unitCost, double subTotal, List<ShoppingCart> shoppingCarts,
			List<PaymentMethode> paymentMethodes, List<DeliveryAddress> addresses) {
		super();
		this.orderId = orderId;
		this.unitCost = unitCost;
		this.subTotal = subTotal;
		this.shoppingCarts = shoppingCarts;
		this.paymentMethodes = paymentMethodes;
		this.addresses = addresses;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}
	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}
	public List<PaymentMethode> getPaymentMethodes() {
		return paymentMethodes;
	}
	public void setPaymentMethodes(List<PaymentMethode> paymentMethodes) {
		this.paymentMethodes = paymentMethodes;
	}
	public List<DeliveryAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<DeliveryAddress> addresses) {
		this.addresses = addresses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + ((paymentMethodes == null) ? 0 : paymentMethodes.hashCode());
		result = prime * result + ((shoppingCarts == null) ? 0 : shoppingCarts.hashCode());
		long temp;
		temp = Double.doubleToLongBits(subTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(unitCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", unitCost=" + unitCost + ", subTotal=" + subTotal
				+ ", shoppingCarts=" + shoppingCarts + ", paymentMethodes=" + paymentMethodes + ", addresses="
				+ addresses + "]";
	}
	
	
	 
	

}
