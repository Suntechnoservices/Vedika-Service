package com.vedika.functionhall.controller;



import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.FunctionHallUIResponse;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.Response;
import com.vedika.functionhall.service.OwnerService;
@CrossOrigin(origins = "http://localhost:4200")
//Required imports
@RestController
@RequestMapping("/api")
public class OwnerController  {
	Logger logger = LoggerFactory.getLogger(OwnerController.class);





	@Autowired
	private OwnerService ownerService;

	@GetMapping(value = "/functionhalls")
	public Response getAllFunctionHalls() {


		logger.info("Entered into the Functionhalls");



		List<Owner> functionhallOwners = ownerService.findAll();

		List<FunctionHallUIResponse> functionhallsUI = new ArrayList<FunctionHallUIResponse>();

		if(null != functionhallOwners && !functionhallOwners.isEmpty()) {
			for(Owner owner : functionhallOwners) {

				List<FunctionHall> funtionhalls = owner.getFunctionhall();

				if(null != funtionhalls && !funtionhalls.isEmpty()) {

					for(FunctionHall functionHall : funtionhalls) {

						FunctionHallUIResponse response = new FunctionHallUIResponse();
						response.setOwnerFirstName(owner.getFirstName());
						response.setOwnerLastName(owner.getLastName());
						response.setFunctionHallName(functionHall.getName());
						response.setStreet(functionHall.getStreet());
						response.setCity(functionHall.getCity());
						response.setOwnerId(owner.getId());
						response.setState(functionHall.getState());
						response.setZipcode(functionHall.getZipcode());
						response.setImageurl(functionHall.getImageurl());

						functionhallsUI.add(response);
						/*try {
					            MDC.put("Id",owner.getId());
					            logger.info("staring at the screen");

					        } finally {
					            MDC.remove("username");
					        }
					        logger.info("browsing done");
						 */

					}
				}
			}

		}
		/*
		try {
			MDC.put("CorrelationId", getCorrelationId());
			logger.info("User Enters in");

		} finally {
			MDC.remove("CorrelationId");
		}
		logger.info("Exited the user");


		 */
		Response response = new Response();
		response.setFunctionHalls(functionhallsUI);
		return response;



	}






}

