package com.example.POCMicroserviceOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MicroserviceOneRestController {

		
		@Value("${version}")
	    private String version;
		
	
	    @Value("${databasename}") private String databasename;
	 
	
		@Value("${servicename}")
	    private String servicename;
		
	
	    @Value("${passwordstrategy}") private String passwordstrategy;
	 
	   
	    @Autowired
	    private Environment env; 

	    @GetMapping("/properties")
	    public String getProperties() {
	        return    "Parent Default ,\t Version:        		"+this.version+",\n"
	        		+ "Parent "+env.getProperty("spring.profiles.active")+" ,\t Database name:  		"+this.databasename+",\n"
	        		+ "Service Default	, \t service name:   		"+this.servicename+",\n "
	        		+ "Service "+env.getProperty("spring.profiles.active")+", \t password strategy:	"+this.passwordstrategy+"";
	    }	    	    	
}
