package com.ilotte.reza.model;

public class Orders {
	
	private int id;
	private int orderId;
	private String dateShipped;
	private String customerName;
	private String customerId;
	private String status;
	private String shippingId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDateShipped() {
		return dateShipped;
	}
	public void setDateShipped(String dateShipped) {
		this.dateShipped = dateShipped;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShippingId() {
		return shippingId;
	}
	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((dateShipped == null) ? 0 : dateShipped.hashCode());
		result = prime * result + id;
		result = prime * result + orderId;
		result = prime * result + ((shippingId == null) ? 0 : shippingId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Orders other = (Orders) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (dateShipped == null) {
			if (other.dateShipped != null)
				return false;
		} else if (!dateShipped.equals(other.dateShipped))
			return false;
		if (id != other.id)
			return false;
		if (orderId != other.orderId)
			return false;
		if (shippingId == null) {
			if (other.shippingId != null)
				return false;
		} else if (!shippingId.equals(other.shippingId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderId=" + orderId + ", dateShipped=" + dateShipped + ", customerName="
				+ customerName + ", customerId=" + customerId + ", status=" + status + ", shippingId=" + shippingId
				+ "]";
	}
	
	
	

}
