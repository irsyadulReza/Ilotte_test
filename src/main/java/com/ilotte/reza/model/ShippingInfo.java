package com.ilotte.reza.model;

public class ShippingInfo {
	
	private int shippingId;
	private int shippingType;
	private int shippingCost;
	private int shippingRegionid;
	
	public int getShippingId() {
		return shippingId;
	}
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}
	public int getShippingType() {
		return shippingType;
	}
	public void setShippingType(int shippingType) {
		this.shippingType = shippingType;
	}
	public int getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(int shippingCost) {
		this.shippingCost = shippingCost;
	}
	public int getShippingRegionid() {
		return shippingRegionid;
	}
	public void setShippingRegionid(int shippingRegionid) {
		this.shippingRegionid = shippingRegionid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + shippingCost;
		result = prime * result + shippingId;
		result = prime * result + shippingRegionid;
		result = prime * result + shippingType;
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
		ShippingInfo other = (ShippingInfo) obj;
		if (shippingCost != other.shippingCost)
			return false;
		if (shippingId != other.shippingId)
			return false;
		if (shippingRegionid != other.shippingRegionid)
			return false;
		if (shippingType != other.shippingType)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShippingInfo [shippingId=" + shippingId + ", shippingType=" + shippingType + ", shippingCost="
				+ shippingCost + ", shippingRegionid=" + shippingRegionid + "]";
	}
	
	
	
	

}
