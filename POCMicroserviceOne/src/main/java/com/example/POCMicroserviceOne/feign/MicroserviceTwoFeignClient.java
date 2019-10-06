package com.example.POCMicroserviceOne.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "microtwo")
//@FeignClient(value = "two", url = "http://localhost:8083")
public interface MicroserviceTwoFeignClient {

	@GetMapping("/properties")
	public String getRemoteProperties();
}
