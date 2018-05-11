package com.ilotte.reza.service;

import java.util.List;

import com.ilotte.reza.model.DeliveryAddress;

public interface DeliveryAddressService {

	List<DeliveryAddress> findAllDeliveryAddress();

	DeliveryAddress findById(long id);

	DeliveryAddress findByName(String name);

	void saveDeliveryAddress(DeliveryAddress address);

	void updateDeliveryAddress(DeliveryAddress address);

	boolean isUserExist(DeliveryAddress address);

}
