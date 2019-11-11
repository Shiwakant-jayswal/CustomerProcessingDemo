package com.viva.common;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.viva.CustomerProcessingDemoApplication;

@Service
public interface AddCustomerDetailsInterface {
	
	
	public void createFeeFile(String csv);
	public void insertAllCustosmerInfoFromFile(String file);
	public void insertFeeInfo(Set<String> newData);	 
}
