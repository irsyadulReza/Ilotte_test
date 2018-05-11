package com.ilotte.reza.service;

import java.util.List;

import com.ilotte.reza.model.ShoppingCart;

public interface ShoppingCartService {

	List<ShoppingCart> findAllshoppingCarts();

	ShoppingCart findById(long id);

	ShoppingCart findByName(String name);

	void saveShoppingCarts(ShoppingCart cart);

	void updateShoppingCarts(ShoppingCart cart);

	void deleteShoppingCarts(long id);

	boolean isUserExist(ShoppingCart cart);

	void deleteShoppingCarts();

}
