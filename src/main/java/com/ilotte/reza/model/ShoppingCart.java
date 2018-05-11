package com.ilotte.reza.model;

import java.util.List;

public class ShoppingCart {
	
	private long cartId;
	private int productId;
	private String cartName;
	private int quantity;
	private String dateAdded;
	

	public ShoppingCart() {
		// TODO Auto-generated constructor stub
		cartId=0;
	}

	public ShoppingCart(long cartId, int productId, String cartName, int quantity, String dateAdded) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.cartName = cartName;
		this.quantity = quantity;
		this.dateAdded = dateAdded;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCartName() {
		return cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cartId ^ (cartId >>> 32));
		result = prime * result + ((cartName == null) ? 0 : cartName.hashCode());
		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + productId;
		result = prime * result + quantity;
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
		ShoppingCart other = (ShoppingCart) obj;
		if (cartId != other.cartId)
			return false;
		if (cartName == null) {
			if (other.cartName != null)
				return false;
		} else if (!cartName.equals(other.cartName))
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (productId != other.productId)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", productId=" + productId + ", cartName=" + cartName + ", quantity="
				+ quantity + ", dateAdded=" + dateAdded + "]";
	}

	
	


	
	
	

}
