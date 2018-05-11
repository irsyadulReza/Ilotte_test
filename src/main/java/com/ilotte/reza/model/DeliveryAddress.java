package com.ilotte.reza.model;

public class DeliveryAddress {
	
	private long id;
	private String fullName;
	private String address;
	private String posCode;
	
	public DeliveryAddress() {
		// TODO Auto-generated constructor stub
		id=0;
	}
	
	public DeliveryAddress(long id, String fullName, String address, String posCode) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.posCode = posCode;
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosCode() {
		return posCode;
	}

	public void setPosCode(String posCode) {
		this.posCode = posCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((posCode == null) ? 0 : posCode.hashCode());
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
		DeliveryAddress other = (DeliveryAddress) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (posCode == null) {
			if (other.posCode != null)
				return false;
		} else if (!posCode.equals(other.posCode))
			return false;
		return true;
	}
	
	

}
