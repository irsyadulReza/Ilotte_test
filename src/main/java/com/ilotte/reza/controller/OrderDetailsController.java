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
import com.ilotte.reza.model.OrderDetails;
import com.ilotte.reza.service.OrderDetailsService;

@RestController
@RequestMapping("/apiservice")
public class OrderDetailsController {

	public static final Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);

	@Autowired
	OrderDetailsService orderDetailsService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All ShoppingCart---------------------------------------------

	@RequestMapping(value = "/OrderDetails/admin", method = RequestMethod.GET)
	public ResponseEntity<List<OrderDetails>> listAllShoppingCart() {
		List<OrderDetails> details = orderDetailsService.findAllpopulateDummyOrderDetails();
		if (details.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<OrderDetails>>(details, HttpStatus.OK);
	}

	// -------------------Retrieve Single ShoppingCart------------------------------------------

	@RequestMapping(value = "/OrderDetails/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrderShoppingCart(@PathVariable("id") long id) {
		logger.info("Fetching orderDetails with id {}", id);
		OrderDetails details = orderDetailsService.findById(id);
		if (details == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OrderDetails>(details, HttpStatus.OK);
	}

	// -------------------Create a ShoppingCart-------------------------------------------

	@RequestMapping(value = "/OrderDetails/insert", method = RequestMethod.POST)
	public ResponseEntity<?> createOrderDetails(@RequestBody OrderDetails details, UriComponentsBuilder ucBuilder) {
		logger.info("Creating ShoppingCart : {}", details);

		if (orderDetailsService.isOrderDetailsExist(details)) {
			logger.error("Unable to create. A ShoppingCart with name {} already exist", details.getOrderId());
			return new ResponseEntity(new CustomErrorType("Unable to create. A ShoppingCart with ShoppingCart name " + 
					details.getOrderId() + " already exist."),HttpStatus.CONFLICT);
		}
		orderDetailsService.saveOrderDetails(details);;

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/apiservice/OrderDetails/{id}").buildAndExpand(details.getOrderId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a OrderDetails ------------------------------------------------

	@RequestMapping(value = "/OrderDetails/moddify/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateOrderDetails(@PathVariable("id") long id, @RequestBody OrderDetails details) {
		logger.info("Updating OrderDetails with id {}", id);

		OrderDetails orderDetails  = orderDetailsService.findById(id);

		if (orderDetails == null) {
			logger.error("Unable to update. ShoppingCart with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. ShoppingCart with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		orderDetails.setAddresses(details.getAddresses());
		orderDetails.setShoppingCarts(details.getShoppingCarts());
		orderDetails.setPaymentMethodes(details.getPaymentMethodes());
		orderDetails.setSubTotal(details.getSubTotal());
		orderDetails.setUnitCost(details.getUnitCost());

		orderDetailsService.updateOrderDetails(orderDetails);;
		return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);
	}


	
}