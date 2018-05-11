package com.ilotte.reza.model;

public class Customer {
	
	private int id;
	private String customerName;
	private String address;
	private String emil;
	private String creaditCardInfo;
	private String shippingInfo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmil() {
		return emil;
	}
	public void setEmil(String emil) {
		this.emil = emil;
	}
	public String getCreaditCardInfo() {
		return creaditCardInfo;
	}
	public void setCreaditCardInfo(String creaditCardInfo) {
		this.creaditCardInfo = creaditCardInfo;
	}
	public String getShippingInfo() {
		return shippingInfo;
	}
	public void setShippingInfo(String shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((creaditCardInfo == null) ? 0 : creaditCardInfo.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((emil == null) ? 0 : emil.hashCode());
		result = prime * result + id;
		result = prime * result + ((shippingInfo == null) ? 0 : shippingInfo.hashCode());
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
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (creaditCardInfo == null) {
			if (other.creaditCardInfo != null)
				return false;
		} else if (!creaditCardInfo.equals(other.creaditCardInfo))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (emil == null) {
			if (other.emil != null)
				return false;
		} else if (!emil.equals(other.emil))
			return false;
		if (id != other.id)
			return false;
		if (shippingInfo == null) {
			if (other.shippingInfo != null)
				return false;
		} else if (!shippingInfo.equals(other.shippingInfo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", address=" + address + ", emil=" + emil
				+ ", creaditCardInfo=" + creaditCardInfo + ", shippingInfo=" + shippingInfo + "]";
	}
	
	
	
	

}
