package com.vedika.functionhall.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.vedika.functionhall.controller.OwnerController;
import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.FunctionHallUIResponse;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.Response;
import com.vedika.functionhall.repository.OwnerRepository;
import com.vedika.functionhall.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {
	
	Logger logger = LoggerFactory.getLogger(OwnerController.class);

    @Autowired
    private OwnerRepository ownerRepository;
   
    

    @Override
    public List<Owner> findAll() {
    	
        return ownerRepository.findAll();
    }


    @Override
    public List<Owner> findAllByOrderById() {
        return ownerRepository.findAllByOrderById();
    }
    
    
    @Override
    public void saveOrUpdateOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(String id) {
        ownerRepository.deleteById(id);
    }



	




	
	


	

	
}
