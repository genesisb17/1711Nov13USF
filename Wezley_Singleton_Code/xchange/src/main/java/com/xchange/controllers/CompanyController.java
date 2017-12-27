package com.xchange.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xchange.models.Company;
import com.xchange.services.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	@Autowired
	CompanyService service;
	
	@RequestMapping(value="/GetCompanyByID", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Company getCompanyById(@RequestBody long id) {
		return service.getCompanyById(id);
	}
	
	@RequestMapping(value="/GetCompanyBySymbol", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Company getCompanyBySymbol(@RequestBody String symbol) {
		return service.getCompanyByName(symbol);
	}
	
	@RequestMapping(value="/GetCompanyByName", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Company getCompanyByName(@RequestBody String name) {
		return service.getCompanyByName(name);
	}
	
	@RequestMapping(value="/GetAllCompanies", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Company> getAllCompanies() {
		return service.getAllCompanies();
	}
	
	@RequestMapping(value="/GetCompaniesByExchange", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Company> getCompaniesByExchange(@RequestBody String exchange) {
		return service.getCompaniesByExchange(exchange);
	}
	
	@RequestMapping(value="/GetCompaniesBySector", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Company> getCompaniesBySector(@RequestBody String sector) {
		return service.getCompaniesBySector(sector);
	}
	
	@RequestMapping(value="/GetCompaniesByIndustry", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Company> getCompaniesByIndustry(@RequestBody String industry) {
		return service.getCompaniesByIndustry(industry);
	}
	
}
