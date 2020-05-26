package com.vedika.functionhall.service;

import java.util.List;
import java.util.Optional;


import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.FunctionHallUIResponse;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.Response;


public interface OwnerService {

    List<Owner> findAll();

  
    List<Owner> findAllByOrderById();
    
    void saveOrUpdateOwner(Owner owner);

    void deleteOwner(String id);


	


	


	


   


	


	


	

	

}