package com.viva.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.viva.service.AddCustomerDetails;

@RestController
public class ApplicationController {
	
	
	 @Autowired AddCustomerDetails addCustomerDetails;
	  
	 @PostConstruct public void display(){ 
		 
		 addCustomerDetails.insertAllCustosmerInfoFromFile("C:\\Users\\comviva\\Desktop\\result1.csv");
		 addCustomerDetails.createFeeFile("C:\\Users\\comviva\\Desktop\\worldcupwrite.csv");
	}
}
