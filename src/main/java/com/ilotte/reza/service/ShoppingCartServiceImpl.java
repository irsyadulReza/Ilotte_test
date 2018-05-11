package com.ilotte.reza.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ilotte.reza.model.PaymentMethode;
import com.ilotte.reza.model.ShoppingCart;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<ShoppingCart> shoppingCartsDetails;
	private static List<PaymentMethode> paymentMethodes;
	
	static{
		shoppingCartsDetails= populateDummyshoppingCartsDetails();
		paymentMethodes = populateDummyPaymentMethode();
	}

	@Override
	public List<ShoppingCart> findAllshoppingCarts() {
		return shoppingCartsDetails;
	}
	
	@Override
	public ShoppingCart findById(long id) {
		for(ShoppingCart cart : shoppingCartsDetails){
			if(cart.getCartId() == id){
				return cart;
			}
		}
		return null;
	}
	
	@Override
	public ShoppingCart findByName(String name) {
		for(ShoppingCart cart : shoppingCartsDetails){
			if(cart.getCartName().equalsIgnoreCase(name)){
				return cart;
			}
		}
		return null;
	}
	
	@Override
	public void saveShoppingCarts(ShoppingCart cart) {
		cart.setCartId(counter.incrementAndGet());
		shoppingCartsDetails.add(cart);
	}

	@Override
	public void updateShoppingCarts(ShoppingCart cart) {
		int index = shoppingCartsDetails.indexOf(cart);
		shoppingCartsDetails.set(index, cart);
	}
	
	public void updatePaymentMethode(PaymentMethode paymentMethode) {
		int index = paymentMethodes.indexOf(paymentMethode);
		paymentMethodes.set(index, paymentMethode);
	}

	@Override
	public void deleteShoppingCarts(long id) {
		
		for (Iterator<ShoppingCart> iterator = shoppingCartsDetails.iterator(); iterator.hasNext(); ) {
			ShoppingCart cart = iterator.next();
		    if (cart.getCartId() == id) {
		        iterator.remove();
		    }
		}
	}

	@Override
	public boolean isUserExist(ShoppingCart cart) {
		return findByName(cart.getCartName())!=null;
	}
	
	@Override
	public void deleteShoppingCarts(){
		shoppingCartsDetails.clear();
	}
	
	
	private static List<ShoppingCart> populateDummyshoppingCartsDetails(){
		List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
		shoppingCarts.add(new ShoppingCart(1, 1, "buku", 10, "10-02-2018"));
		shoppingCarts.add(new ShoppingCart(2, 2, "meja", 13, "11-02-2018"));
		shoppingCarts.add(new ShoppingCart(3, 3, "bangku", 15, "12-02-2018"));
		return shoppingCarts;
	}
	
	private static List<PaymentMethode> populateDummyPaymentMethode(){
		List<PaymentMethode> methodes = new ArrayList<PaymentMethode>();
		methodes.add(new PaymentMethode(1, "Transfer", "123456789"));
		methodes.add(new PaymentMethode(1, "Credit Card", "987654322"));
		return methodes;
	}

}
