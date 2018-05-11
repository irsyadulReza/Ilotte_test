package com.ilotte.reza.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ilotte.reza.model.DeliveryAddress;
import com.ilotte.reza.model.LogisticProvider;
import com.ilotte.reza.model.OrderDetails;
import com.ilotte.reza.model.PaymentMethode;
import com.ilotte.reza.model.ShoppingCart;

@Service("logisticProviderService")
public class LogisticProviderServiceImpl implements LogisticProviderService {
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<LogisticProvider> logisticProviders;
	private static Map<List<LogisticProvider>, List> mapProvicer;
	
	static{
		logisticProviders = populateDummyLogisticProvider();
		mapProvicer = providersLogistic();
	}

	@Override
	public List<LogisticProvider> findAllLogisticProvider() {
		return logisticProviders;
	}
	
	@Override
	public LogisticProvider findById(long id) {
		for(LogisticProvider provider: logisticProviders){
			if(provider.getOrderId() == id){
				return provider;
			}
		}
		return null;
	}

	@Override
	public Object findAllTrx(long id) {
		Iterator iterator = mapProvicer.keySet().iterator();
		for (Object object : mapProvicer.keySet()) {
			Object value = mapProvicer.get(object);
			return value;
		}
		
		return null;
	}

	
	@Override
	public void saveLogisticProvider(LogisticProvider provider) {
		provider.setId(counter.incrementAndGet());
		logisticProviders.add(provider);
	}

	@Override
	public void updateLogisticProvider(LogisticProvider provider) {
		int index = logisticProviders.indexOf(provider);
		logisticProviders.set(index, provider);
	}
	

//	@Override
//	public void deleteShoppingCarts(long id) {
//		
//		for (Iterator<ShoppingCart> iterator = shoppingCartsDetails.iterator(); iterator.hasNext(); ) {
//			ShoppingCart cart = iterator.next();
//		    if (cart.getCartId() == id) {
//		        iterator.remove();
//		    }
//		}
//	}

	@Override
	public boolean isOrderDetailsExist(LogisticProvider provider) {
		return findById(provider.getOrderId())!=null;	
		
	}
	
//	@Override
//	public void deleteShoppingCarts(){
//		shoppingCartsDetails.clear();
//	}
	
	
	private static List<LogisticProvider> populateDummyLogisticProvider(){
		
		List<LogisticProvider> providers = new ArrayList<LogisticProvider>();

		return providers ;
	}
	
	private static Map<List<LogisticProvider>, List> providersLogistic(){

		Map<List<LogisticProvider>, List> map = new HashMap<>();
		
		List<LogisticProvider> providers = new ArrayList<LogisticProvider>();
		List<OrderDetails> details = new ArrayList<OrderDetails>();
		List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
		List<DeliveryAddress> deliveryAddresses = new ArrayList<DeliveryAddress>();
		List<PaymentMethode> paymentMethodes = new ArrayList<PaymentMethode>();
		List<List<String>> strings = new ArrayList<List<String>>();
		
		List merged = new ArrayList<>(details);
		merged.addAll(shoppingCarts);
		merged.addAll(deliveryAddresses);
		merged.addAll(paymentMethodes);

		
		map.put(providers, merged);
		return map;

	}
	

}
