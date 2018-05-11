package com.ilotte.reza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ilotte.reza.model.PaymentMethode;

@Service("paymentMethodeService")
public class PaymentMethodeServiceImpl implements PaymentMethodeService{
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<PaymentMethode> paymentMethodes;
	
	static{
		paymentMethodes = populateDummyPaymentMethode();
	}


	@Override
	public List<PaymentMethode> findAllPaymentMethode() {
		return paymentMethodes;
	}
	
	@Override
	public PaymentMethode findById(long id) {
		for(PaymentMethode methode : paymentMethodes){
			if(methode.getId() == id){
				return methode;
			}
		}
		return null;
	}
	
	@Override
	public PaymentMethode findByName(String name) {
		for(PaymentMethode methode : paymentMethodes){
			if(methode.getMethodePayment().equalsIgnoreCase(name)){
				return methode;
			}
		}
		return null;
	}
	
	@Override
	public void savePaymentMethode(PaymentMethode methode) {
		methode.setId(counter.incrementAndGet());
		paymentMethodes.add(methode);
	}

	@Override
	public void updatePaymentMethode(PaymentMethode methode) {
		int index = paymentMethodes.indexOf(methode);
		paymentMethodes.set(index, methode);
	}


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
	public boolean isUserExist(PaymentMethode methode) {
		return findByName(methode.getMethodePayment())!=null;
	}
	

//	public void deleteShoppingCarts(){
//		shoppingCartsDetails.clear();
//	}
	

	private static List<PaymentMethode> populateDummyPaymentMethode(){
		List<PaymentMethode> methodes = new ArrayList<PaymentMethode>();
		methodes.add(new PaymentMethode(1, "Transfer", "123456789"));
		methodes.add(new PaymentMethode(1, "Credit Card", "987654322"));
		return methodes;
	}

}
