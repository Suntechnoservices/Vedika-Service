package com.vedika.functionhall.controller;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vedika.functionhall.model.Amazonresponse;
import com.vedika.functionhall.model.GenericResponse;
import com.vedika.functionhall.model.PublishDetails;
import com.vedika.functionhall.service.AmazonClient;
import com.vedika.functionhall.service.PublishService;
@RestController
@RequestMapping("/api")
public class PublishController {
	private AmazonClient amazonClient;

	@Autowired
	private PublishService publishService;
	
	@Autowired
	PublishController(AmazonClient amazonClient) {
		this.amazonClient = amazonClient;
	}
	@RequestMapping(value = "/image", method = RequestMethod.POST)

	public ResponseEntity<Amazonresponse> image(@RequestParam(value = "file") MultipartFile file,
			String correlationid) throws IOException {

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("https://api.constantcontact.com/v2/library/files");
		httppost.addHeader("Content-type", "multipart/form-data");

		Amazonresponse response = new Amazonresponse();
		response.setMsg(" uploading request submitted successfully.");

		String imageUrl = amazonClient.uploadFile(file, correlationid);

		publishService.update(correlationid, imageUrl);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@PostMapping(value = "/publishListing")
	public ResponseEntity<GenericResponse<PublishDetails>> saveOrUpdatePublishDetails(@RequestBody PublishDetails publishDetails) {
		publishService.saveOrUpdatepublishListing(publishDetails);
		return new ResponseEntity("functionhall details added successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/publish/", method = RequestMethod.GET)
	public ResponseEntity<GenericResponse<List<PublishDetails>>> getAllPublishDetails()
	{

	  List<PublishDetails> publish =  publishService.getAllPublishDetails();
	  
	  PublishDetails publishRes=new PublishDetails();
	  publishRes.setOwnerId(publishRes.getOwnerId());
	  publishRes.setCorrelationid(publishRes.getCorrelationid());
	  publishRes.setLocation(publishRes.getLocation());
	  publishRes.setDetails(publishRes.getDetails());
	  publishRes.setSecurity(publishRes.getSecurity());
	  publishRes.setPaymentDetails(publishRes.getPaymentDetails());
	   
	  GenericResponse<List<PublishDetails>> response=new  GenericResponse<List<PublishDetails>>();
	  response.setData(publish);
		return new ResponseEntity<>(response,HttpStatus.OK);

	}
}



