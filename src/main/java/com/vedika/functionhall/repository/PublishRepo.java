package com.vedika.functionhall.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedika.functionhall.model.Bank;
import com.vedika.functionhall.model.PublishDetails;

@Repository
public interface PublishRepo extends MongoRepository<PublishDetails, String> {

	PublishDetails save(PublishDetails publishDetails);

}
