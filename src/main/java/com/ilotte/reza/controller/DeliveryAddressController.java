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
import com.ilotte.reza.model.DeliveryAddress;
import com.ilotte.reza.service.DeliveryAddressService;

@RestController
@RequestMapping("/apiservice")
public class DeliveryAddressController {

	public static final Logger logger = LoggerFactory.getLogger(DeliveryAddressController.class);

	@Autowired
	DeliveryAddressService deliveryAddressService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All DeliveryAddress---------------------------------------------

	@RequestMapping(value = "/DeliveryAddress/", method = RequestMethod.GET)
	public ResponseEntity<List<DeliveryAddress>> listAllDeliveryAddress() {
		List<DeliveryAddress> addresses = deliveryAddressService.findAllDeliveryAddress();
		if (addresses.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<DeliveryAddress>>(addresses, HttpStatus.OK);
	}

	// -------------------Retrieve Single DeliveryAddress------------------------------------------

	@RequestMapping(value = "/DeliveryAddress/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrderDeliveryAddress(@PathVariable("id") long id) {
		logger.info("Fetching DeliveryAddress with id {}", id);
		DeliveryAddress address = deliveryAddressService.findById(id);
		if (address == null) {
			logger.error("DeliveryAddress with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DeliveryAddress>(address, HttpStatus.OK);
	}

	// -------------------Create a DeliveryAddress-------------------------------------------

	@RequestMapping(value = "/DeliveryAddress/insert", method = RequestMethod.POST)
	public ResponseEntity<?> createDeliveryAddress(@RequestBody DeliveryAddress address, UriComponentsBuilder ucBuilder) {
		logger.info("Creating DeliveryAddress : {}", address);

		if (deliveryAddressService.isUserExist(address)) {
			logger.error("Unable to create. A DeliveryAddress with name {} already exist", address.getAddress());
			return new ResponseEntity(new CustomErrorType("Unable to create. A DeliveryAddress with DeliveryAddress name " + 
					address.getAddress() + " already exist."),HttpStatus.CONFLICT);
		}
		deliveryAddressService.saveDeliveryAddress(address);;

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/apiservice/DeliveryAddress/{id}").buildAndExpand(address.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a OrderDetails ------------------------------------------------

	@RequestMapping(value = "/DeliveryAddress/moddify/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDeliveryAddress(@PathVariable("id") long id, @RequestBody DeliveryAddress deliveryAddress) {
		logger.info("Updating DeliveryAddress with id {}", id);

		DeliveryAddress address = deliveryAddressService.findById(id);

		if (deliveryAddress == null) {
			logger.error("Unable to update. DeliveryAddress with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. DeliveryAddress with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		address.setFullName(deliveryAddress.getFullName());
		address.setAddress(deliveryAddress.getFullName());
		address.setPosCode(deliveryAddress.getPosCode());

		deliveryAddressService.updateDeliveryAddress(address);
		return new ResponseEntity<DeliveryAddress>(address, HttpStatus.OK);
	}


	
}