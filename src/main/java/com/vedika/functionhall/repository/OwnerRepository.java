package com.vedika.functionhall.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.FunctionHallUIResponse;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.Response;


public interface OwnerRepository extends MongoRepository<Owner, String> {

 
 List<Owner> findAllByOrderById();
 




}