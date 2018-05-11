package com.ilotte.reza.service;

import java.util.List;

import com.ilotte.reza.model.OrderDetails;

public interface OrderDetailsService {

	List<OrderDetails> findAllpopulateDummyOrderDetails();

	OrderDetails findById(long id);

	void saveOrderDetails(OrderDetails details);

	void updateOrderDetails(OrderDetails details);

	boolean isOrderDetailsExist(OrderDetails details);

}
