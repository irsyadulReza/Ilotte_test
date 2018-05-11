package com.ilotte.reza.service;

import java.util.List;

import com.ilotte.reza.model.PaymentMethode;

public interface PaymentMethodeService {

	List<PaymentMethode> findAllPaymentMethode();

	PaymentMethode findById(long id);

	PaymentMethode findByName(String name);

	void savePaymentMethode(PaymentMethode methode);

	void updatePaymentMethode(PaymentMethode methode);

	boolean isUserExist(PaymentMethode methode);

	

}
