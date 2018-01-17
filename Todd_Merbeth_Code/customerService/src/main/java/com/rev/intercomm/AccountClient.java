package com.rev.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rev.model.Account;

@FeignClient("accountService")
public interface AccountClient {
	
	@GetMapping("/customer/{id}")
	List<Account> findByCustomerId(@PathVariable("id") int id);
	
}
