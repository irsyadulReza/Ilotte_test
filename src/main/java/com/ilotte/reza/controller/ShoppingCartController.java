package com.ilotte.reza.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.com.ilotte.reza.util.CustomErrorType;
import com.ilotte.reza.model.ShoppingCart;
import com.ilotte.reza.service.ShoppingCartService;

@RestController
@RequestMapping("/apiservice")
public class ShoppingCartController {

	public static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

	@Autowired
	ShoppingCartService shoppingCartService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All ShoppingCart---------------------------------------------

	@RequestMapping(value = "/shoppingcart/", method = RequestMethod.GET)
	public ResponseEntity<List<ShoppingCart>> listAllShoppingCart() {
		List<ShoppingCart> carts = shoppingCartService.findAllshoppingCarts();
		if (carts.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<ShoppingCart>>(carts, HttpStatus.OK);
	}

	// -------------------Retrieve Single ShoppingCart------------------------------------------

	@RequestMapping(value = "/shoppingcart/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrderShoppingCart(@PathVariable("id") long id) {
		logger.info("Fetching orderDetails with id {}", id);
		ShoppingCart cart = shoppingCartService.findById(id);
		if (cart == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
	}

	// -------------------Create a ShoppingCart-------------------------------------------

	@RequestMapping(value = "/shoppingcart/insert", method = RequestMethod.POST)
	public ResponseEntity<?> createOrderDetails(@RequestBody ShoppingCart cart, UriComponentsBuilder ucBuilder) {
		logger.info("Creating ShoppingCart : {}", cart);

		if (shoppingCartService.isUserExist(cart)) {
			logger.error("Unable to create. A ShoppingCart with name {} already exist", cart.getCartName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A ShoppingCart with ShoppingCart name " + 
					cart.getCartName() + " already exist."),HttpStatus.CONFLICT);
		}
		shoppingCartService.saveShoppingCarts(cart);;

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/apiservice/shoppingcart/{id}").buildAndExpand(cart.getCartId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a OrderDetails ------------------------------------------------

	@RequestMapping(value = "/shoppingcart/moddify/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateOrderDetails(@PathVariable("id") long id, @RequestBody ShoppingCart cart) {
		logger.info("Updating OrderDetails with id {}", id);

		ShoppingCart cartdetails = shoppingCartService.findById(id);

		if (cart == null) {
			logger.error("Unable to update. ShoppingCart with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. ShoppingCart with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		cartdetails.setCartName(cart.getCartName());
		cartdetails.setProductId(cart.getProductId());
		cartdetails.setQuantity(cart.getQuantity());
		cartdetails.setDateAdded(cart.getDateAdded());
	

		shoppingCartService.updateShoppingCarts(cartdetails);
		return new ResponseEntity<ShoppingCart>(cartdetails, HttpStatus.OK);
	}


	
}