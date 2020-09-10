package com.vedika.functionhall.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.PublishDetails;
@Service
public interface PublishService {
	PublishDetails saveOrUpdatepublishListing(PublishDetails publishDetails);
	
	void update(String correlationid, String imageUrl) throws FileNotFoundException, RuntimeException;

	List<PublishDetails> getAllPublishDetails();
}
