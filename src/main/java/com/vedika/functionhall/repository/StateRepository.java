package com.vedika.functionhall.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.vedika.functionhall.model.Details;
import com.vedika.functionhall.model.ResponseForStates;
import com.vedika.functionhall.model.States;

public interface StateRepository extends MongoRepository<Details, String> {

	Details save(Details details);

	@Query(value = "{ 'countryDetails.name' : ?0 }",fields="{'countryDetails.name':1,'countryDetails.states.code':1,'countryDetails.states.name':1}")
	List<Details> findByName(String name);

	@Query(value = "{ 'countryDetails.states.name' : ?0 }",fields="{'countryDetails.states.$':1,'countryDetails.name':1}")
	List<Details> findByStateName(String name);
}
