package com.vedika.functionhall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vedika.functionhall.model.Amazonresponse;
import com.vedika.functionhall.model.Bank;
import com.vedika.functionhall.model.BankData;
import com.vedika.functionhall.model.BankDetails;
import com.vedika.functionhall.model.Details;
import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.FunctionHallUIResponse;
import com.vedika.functionhall.model.GenericResponse;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.PublishDetails;
import com.vedika.functionhall.model.ResponseBankdetails;
import com.vedika.functionhall.model.ResponseBanksUI;
import com.vedika.functionhall.model.ResponseObject;
import com.vedika.functionhall.model.Responsebank;
import com.vedika.functionhall.service.AmazonClient;
import com.vedika.functionhall.service.BankService;
import com.vedika.functionhall.service.OwnerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@RequestMapping(value = "/functionhalls/", method = RequestMethod.GET)
	public ResponseEntity<GenericResponse<List<FunctionHallUIResponse>>> getAllFunctionHalls() {

		List<Owner> functionhallOwners = ownerService.findAll();

		List<FunctionHallUIResponse> functionhallsUI = new ArrayList<FunctionHallUIResponse>();

		if (null != functionhallOwners && !functionhallOwners.isEmpty()) {
			for (Owner owner : functionhallOwners) {

				List<FunctionHall> funtionhalls = owner.getFunctionhall();

				if (null != funtionhalls && !funtionhalls.isEmpty()) {

					for (FunctionHall functionHall : funtionhalls) {

						FunctionHallUIResponse response = new FunctionHallUIResponse();

						response.setName(functionHall.getName());
						response.setOwnerFirstName(owner.getFirstName());
						response.setOwnerLastName(owner.getLastName());
						response.setOwnerId(owner.getId());
						response.setCity(functionHall.getCity());
						response.setStreet(functionHall.getStreet());
						response.setFunctionhalldescription(functionHall.getFunctionhalldescription());
						response.setFunctionhalltype(functionHall.getFunctionhalltype());
						response.setMaximumguest(functionHall.getMaximumguest());
						response.setFoodtype(functionHall.getFoodtype());
						response.setRoomtype(functionHall.getRoomtype());
						response.setState(functionHall.getState());
						response.setZipcode(functionHall.getZipcode());
						response.setImageUrl(functionHall.getImageUrl());
						response.setCorelationid(functionHall.getCorelationId());
						response.setFunctionhallContactNumber(functionHall.getFunctionhallContactNumber());
						response.setOwnerContactNumber(owner.getOwnerContactNumber());

						functionhallsUI.add(response);
					}
				}
			}

		}

		GenericResponse<List<FunctionHallUIResponse>> response = new GenericResponse<List<FunctionHallUIResponse>>();
		response.setData(functionhallsUI);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@RequestMapping(value = "/functionhallsBy/", method = RequestMethod.GET)

	public ResponseEntity<GenericResponse<List<FunctionHallUIResponse>>> findFunctionhallByNameAndCity(@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "name", required = false) String name) {

		List<Owner> functionhallOwners = ownerService.findFunctionHallByNameAndCity(city, name);

		List<FunctionHallUIResponse> functionhallsUI = new ArrayList<FunctionHallUIResponse>();

		if (null != functionhallOwners && !functionhallOwners.isEmpty()) {
			for (Owner owner : functionhallOwners) {

				List<FunctionHall> funtionhalls = owner.getFunctionhall();

				if (null != funtionhalls && !funtionhalls.isEmpty()) {

					for (FunctionHall functionHall : funtionhalls) {

						FunctionHallUIResponse response = new FunctionHallUIResponse();
						response.setName(functionHall.getName());
						response.setOwnerFirstName(owner.getFirstName());
						response.setOwnerLastName(owner.getLastName());
						response.setOwnerId(owner.getId());
						response.setCity(functionHall.getCity());
						response.setStreet(functionHall.getStreet());
						response.setState(functionHall.getState());
						response.setZipcode(functionHall.getZipcode());
						response.setImageUrl(functionHall.getImageUrl());
						response.setCorelationid(functionHall.getCorelationId());
						response.setFunctionhallContactNumber(functionHall.getFunctionhallContactNumber());
						response.setOwnerContactNumber(owner.getOwnerContactNumber());

						functionhallsUI.add(response);
					}
				}
			}

		}

		GenericResponse<List<FunctionHallUIResponse>> response = new GenericResponse<List<FunctionHallUIResponse>>();
		response.setData(functionhallsUI);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}


	@PostMapping(value = "/functionhalls")
	public ResponseEntity<?> saveOrUpdateOwner(@RequestBody Owner owner) {
		ownerService.saveOrUpdateOwner(owner);
		return new ResponseEntity("functionhall details added successfully", HttpStatus.OK);
	}

	@PostMapping(value = "/functionhalls1")
	public ResponseEntity<?> saveOrUpdatePublishDetails(@RequestBody PublishDetails publishDetails) {
		ownerService.saveOrUpdatepublishListing(publishDetails);
		return new ResponseEntity("functionhall details added successfully", HttpStatus.OK);
	}


}


