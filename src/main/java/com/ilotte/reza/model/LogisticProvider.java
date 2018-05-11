package com.ilotte.reza.model;

public class LogisticProvider {
	
	private long id;
	private int OrderId;
	private int logisticCode;
	private String logisticName;
	private double logisticPayment;
	
	public LogisticProvider() {
		// TODO Auto-generated constructor stub
		id=0;
	}
		
	public LogisticProvider(long id, int orderId, int logisticCode, String logisticName, double logisticPayment) {
		super();
		this.id = id;
		OrderId = orderId;
		this.logisticCode = logisticCode;
		this.logisticName = logisticName;
		this.logisticPayment = logisticPayment;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getLogisticCode() {
		return logisticCode;
	}
	public void setLogisticCode(int logisticCode) {
		this.logisticCode = logisticCode;
	}
	public String getLogisticName() {
		return logisticName;
	}
	public void setLogisticName(String logisticName) {
		this.logisticName = logisticName;
	}
	public double getLogisticPayment() {
		return logisticPayment;
	}
	public void setLogisticPayment(double logisticPayment) {
		this.logisticPayment = logisticPayment;
	}

	@Override
	public String toString() {
		return "LogisticProvider [id=" + id + ", OrderId=" + OrderId + ", logisticCode=" + logisticCode
				+ ", logisticName=" + logisticName + ", logisticPayment=" + logisticPayment + "]";
	}
	
	
	
	

}
