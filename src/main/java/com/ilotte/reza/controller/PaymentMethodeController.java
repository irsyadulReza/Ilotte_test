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
import com.ilotte.reza.model.PaymentMethode;
import com.ilotte.reza.service.PaymentMethodeService;

@RestController
@RequestMapping("/apiservice")
public class PaymentMethodeController {

	public static final Logger logger = LoggerFactory.getLogger(PaymentMethodeController.class);

	@Autowired
	PaymentMethodeService paymentMethodeService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All PaymentMethode---------------------------------------------

	@RequestMapping(value = "/PaymentMethode/", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentMethode>> listAllPaymentMethode() {
		List<PaymentMethode> methodes = paymentMethodeService.findAllPaymentMethode();
		if (methodes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<PaymentMethode>>(methodes, HttpStatus.OK);
	}

	// -------------------Retrieve Single PaymentMethode------------------------------------------

	@RequestMapping(value = "/PaymentMethode/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrderPaymentMethode(@PathVariable("id") long id) {
		logger.info("Fetching PaymentMethode with id {}", id);
		PaymentMethode methode = paymentMethodeService.findById(id);
		if (methode == null) {
			logger.error("PaymentMethode with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PaymentMethode>(methode, HttpStatus.OK);
	}

	// -------------------Create a PaymentMethode-------------------------------------------

	@RequestMapping(value = "/PaymentMethode/insert", method = RequestMethod.POST)
	public ResponseEntity<?> createPaymentMethode(@RequestBody PaymentMethode methode, UriComponentsBuilder ucBuilder) {
		logger.info("Creating PaymentMethode : {}", methode);

		if (paymentMethodeService.isUserExist(methode)) {
			logger.error("Unable to create. A PaymentMethode with name {} already exist", methode.getMethodePayment());
			return new ResponseEntity(new CustomErrorType("Unable to create. A PaymentMethode with PaymentMethode name " + 
					methode.getMethodePayment() + " already exist."),HttpStatus.CONFLICT);
		}
		paymentMethodeService.savePaymentMethode(methode);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/apiservice/shoppingcart/{id}").buildAndExpand(methode.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a PaymentMethode ------------------------------------------------

	@RequestMapping(value = "/PaymentMethode/moddify/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePaymentMethode(@PathVariable("id") long id, @RequestBody PaymentMethode methode) {
		logger.info("Updating PaymentMethode with id {}", id);

		PaymentMethode paymentMethode = paymentMethodeService.findById(id);

		if (methode == null) {
			logger.error("Unable to update. PaymentMethode with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. PaymentMethode with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		paymentMethode.setCardNo(methode.getCardNo());
		paymentMethode.setMethodePayment(methode.getMethodePayment());

		paymentMethodeService.updatePaymentMethode(paymentMethode);
		return new ResponseEntity<PaymentMethode>(paymentMethode, HttpStatus.OK);
	}


	
}