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
import com.ilotte.reza.model.LogisticProvider;
import com.ilotte.reza.service.LogisticProviderService;

@RestController
@RequestMapping("/apiservice")
public class LogisticProviderController {

	public static final Logger logger = LoggerFactory.getLogger(LogisticProviderController.class);

	@Autowired
	LogisticProviderService logisticProviderService ; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All logisticProviders---------------------------------------------

	@RequestMapping(value = "/logistic/", method = RequestMethod.GET)
	public ResponseEntity<List<LogisticProvider>> listAllShoppingCart() {
		List<LogisticProvider> logisticProviders = logisticProviderService.findAllLogisticProvider();
		if (logisticProviders.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<LogisticProvider>>(logisticProviders, HttpStatus.OK);
	}

	// -------------------Retrieve Single logisticProviders------------------------------------------

	@RequestMapping(value = "/logistic/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getlogisticProviders(@PathVariable("id") long id) {
		logger.info("Fetching logisticProviders with id {}", id);
		LogisticProvider provider = logisticProviderService.findById(id);
		if (provider == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LogisticProvider>(provider, HttpStatus.OK);
	}

	// -------------------Retrieve Single logisticProviders Submited------------------------------------------
	
	@RequestMapping(value = "/logistic/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getlogisticProviders_submited(@PathVariable("id") long id) {
		logger.info("Fetching logisticProviders with id {}", id);
		Object provider = logisticProviderService.findAllTrx(id);
		if (provider == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(provider, HttpStatus.OK);
	}

	// -------------------Create a logisticProviders-------------------------------------------

	@RequestMapping(value = "/logistic/insert", method = RequestMethod.POST)
	public ResponseEntity<?> createLogisticProvider(@RequestBody LogisticProvider provider, UriComponentsBuilder ucBuilder) {
		logger.info("Creating logisticProviders : {}", provider);

		if (logisticProviderService.isOrderDetailsExist(provider)) {
			logger.error("Unable to create. A logisticProviders with name {} already exist", provider.getLogisticName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A logisticProviders with logisticProviders name " + 
					provider.getLogisticName() + " already exist."),HttpStatus.CONFLICT);
		}
		logisticProviderService.saveLogisticProvider(provider);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/apiservice/logistic/{id}").buildAndExpand(provider.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a logisticProviders ------------------------------------------------

//	@RequestMapping(value = "/logistic/moddify/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<?> updateOrderDetails(@PathVariable("id") long id, @RequestBody ShoppingCart cart) {
//		logger.info("Updating OrderDetails with id {}", id);
//
//		ShoppingCart cartdetails = shoppingCartService.findById(id);
//
//		if (cart == null) {
//			logger.error("Unable to update. ShoppingCart with id {} not found.", id); 
//			return new ResponseEntity(new CustomErrorType("Unable to upate. ShoppingCart with id " + id + " not found."),
//					HttpStatus.NOT_FOUND);
//		}
//
//		cartdetails.setCartName(cart.getCartName());
//		cartdetails.setProductId(cart.getProductId());
//		cartdetails.setQuantity(cart.getQuantity());
//		cartdetails.setDateAdded(cart.getDateAdded());
//	
//
//		shoppingCartService.updateShoppingCarts(cartdetails);
//		return new ResponseEntity<ShoppingCart>(cartdetails, HttpStatus.OK);
//	}


	
}