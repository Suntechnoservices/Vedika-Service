package com.vedika.functionhall.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.MongoException;
import com.mongodb.client.result.UpdateResult;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.PublishDetails;
import com.vedika.functionhall.repository.PublishRepo;
@Service
public class PublishServiceImpl implements PublishService{
	@Autowired
	private PublishRepo publishRepo;
	@Autowired
	private MongoTemplate mongoTemplate;
	
    @Override
	public void update(String correlationid, String imageUrl) throws FileNotFoundException, RuntimeException {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("correlationid").is(correlationid));
			PublishDetails ownerref = mongoTemplate.findOne(query, PublishDetails.class);
			System.out.println(ownerref);
			UpdateResult update = mongoTemplate.updateMulti(query,
					new Update().addToSet("details.$.imageUrl", imageUrl), PublishDetails.class);
			System.out.println(update);
		} catch (MongoException e) {
			System.out.println("nessary file not present" + e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    @Override
	public PublishDetails saveOrUpdatepublishListing(PublishDetails publishDetails) {
		return publishRepo.save(publishDetails);
	}

	@Override
	public List<PublishDetails> getAllPublishDetails() {
		// TODO Auto-generated method stub
		return publishRepo.findAll();
	}

}
