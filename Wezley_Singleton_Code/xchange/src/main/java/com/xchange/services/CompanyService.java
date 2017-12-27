package com.xchange.services;

import java.util.List;

import com.xchange.models.Company;

public interface CompanyService {
	
	public List<Company> getAllCompanies();
	public Company getCompanyById(Long id);
	public Company getCompanyByName(String name);
	public Company getCompanyBySymbol(String symbol);
	public List<Company> getCompaniesBySector(String sector);
	public List<Company> getCompaniesByExchange(String exchange);
	public List<Company> getCompaniesByIndustry(String industry);

}
