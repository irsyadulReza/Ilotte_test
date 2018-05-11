package com.ilotte.reza.service;

import java.util.List;

import com.ilotte.reza.model.LogisticProvider;

public interface LogisticProviderService {

	List<LogisticProvider> findAllLogisticProvider();

	LogisticProvider findById(long id);

	void saveLogisticProvider(LogisticProvider provider);

	void updateLogisticProvider(LogisticProvider provider);

	boolean isOrderDetailsExist(LogisticProvider provider);

	Object findAllTrx(long id);

}
