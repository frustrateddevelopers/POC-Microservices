package com.example.POCMicroserviceOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.POCMicroserviceOne.feign.MicroserviceTwoFeignClient;

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
	    private MicroserviceTwoFeignClient microOneFeignClient;
	 
	   
	    @Autowired
	    private Environment env; 
	    
	    @Autowired
	    RestTemplate restTemplate;

	    @GetMapping("/properties")
	    public String getProperties() {
	        return    "Parent Default ,\t Version:        		"+this.version+",\n"
	        		+ "Parent "+env.getProperty("spring.profiles.active")+" ,\t Database name:  		"+this.databasename+",\n"
	        		+ "Service Default	, \t service name:   		"+this.servicename+",\n "
	        		+ "Service "+env.getProperty("spring.profiles.active")+", \t password strategy:	"+this.passwordstrategy+"";
	    }	    	
	    
	    @GetMapping("/remote_service_properties")
	    @LoadBalanced
	    public String getServiceProperties(){
	    	System.out.println("Getting micro two properties");
	    	String response = restTemplate.exchange("http://microtwo/properties", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, "").getBody();
	    	System.out.println("Response Received as " + response);
	    	return response;
	    }
	    
	    @GetMapping("/remote_service_properties_feign")
	    @LoadBalanced
	    public String getServicePropertiesFeignClient(){
	    	System.out.println("Getting micro two properties using feign client");
	    	String response = microOneFeignClient.getRemoteProperties();
	    	System.out.println("Response Received as " + response);
	    	return response;
	    }
}
