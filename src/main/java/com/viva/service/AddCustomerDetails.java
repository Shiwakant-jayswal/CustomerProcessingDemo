package com.viva.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.viva.CustomerProcessingDemoApplication;
import com.viva.TestLogger;
import com.viva.common.AddCustomerDetailsInterface;
import com.viva.model.CustomerDetails;
import com.viva.model.FeeInformation;
import com.viva.repository.CustomerRepository;
import com.viva.repository.FeeInfoRepository;

@Service
public class AddCustomerDetails implements AddCustomerDetailsInterface {
	TestLogger logger = new TestLogger(CustomerProcessingDemoApplication.class);
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private FeeInfoRepository feeInfoRepository;
	
	@Value("${fee.amount}")
	private int feeAmount;
	
	public void createFeeFile(String csv) {
    	try {
    		
    		 CSVWriter writer = new CSVWriter(new FileWriter(csv));
    		 List<Object[]> lst = feeInfoRepository.calculateFee();
			 Iterator<Object[]> iterator = lst.iterator();
			 while(iterator.hasNext()) {
				Object []obj = iterator.next();
				for(int i=1;i<obj.length;i++) {
					String [] str = {obj[0].toString(),obj[1].toString()};
					writer.writeNext(str, true);
				}
			}
			writer.close();
			}
    		catch (IOException e) {
    			e.printStackTrace();
    		}
    }
    
    public void insertAllCustosmerInfoFromFile(String file) 
    { 
        try {  
            FileReader filereader = new FileReader(file);  
            CSVReader csvReader = new CSVReaderBuilder(filereader) 
                                      .withSkipLines(1) 
                                      .build(); 
            List<String[]> allData = csvReader.readAll(); 
            List<CustomerDetails> newData = new ArrayList<>(); 
            for (String[] row : allData) { 
            	CustomerDetails customerDetails = new CustomerDetails();
            	customerDetails.setFirstName(row[0]);
            	customerDetails.setMiddleName(row[1]);
            	customerDetails.setLastName(row[2]);
            	customerDetails.setContactNumber(row[5]);
            	customerDetails.setAddress(row[4]);
            	customerDetails.setCity(row[3]);
            	customerDetails.setCustomerStatus(true);
            	customerDetails.setCreationDate(new Date());
            	newData.add(customerDetails);
            } 
            
            List<CustomerDetails> oldData = customerRepository.findAll();
            Set<CustomerDetails> insertData = new HashSet<>();
            Set<String> feeContact = new HashSet<>();
			for(int i=0;i<newData.size();i++) { 
				boolean flag = true;
				for(int j=0;j<oldData.size();j++) {
					if(newData.get(i).getContactNumber().equals(oldData.get(j).getContactNumber())){
						flag=false;
						logger.info((i+1)+"---"+newData.get(i).getContactNumber()+"---Failed");
					} 
				} 
				if(flag==true) { 
					insertData.add(newData.get(i));
					feeContact.add(newData.get(i).getContactNumber());
					logger.info((i+1)+"---"+newData.get(i).getContactNumber()+"---Passed");
			   }
			}
            if(insertData.size()!=0) {
            	customerRepository.saveAll(insertData);
            	insertFeeInfo(feeContact);
            }
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        }   
    } 
    
    public void insertFeeInfo(Set<String> newData) {
    	Set<FeeInformation> insertFee = new HashSet<>();
    	Iterator<String> itr = newData.iterator();
    	while(itr.hasNext()) {
    		FeeInformation feeInformation = new FeeInformation();
    		feeInformation.setContactNumber(itr.next());
    		feeInformation.setCreationDate(new Date());
    		feeInformation.setFeeAmount(feeAmount);
    		insertFee.add(feeInformation);
    	}
    	feeInfoRepository.saveAll(insertFee);
    }
}
