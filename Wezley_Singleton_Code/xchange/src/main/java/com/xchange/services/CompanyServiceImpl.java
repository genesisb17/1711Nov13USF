package com.xchange.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xchange.models.Company;
import com.xchange.repositories.CompanyRepository;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository repo;
	
	@Override
	public List<Company> getAllCompanies() {
		return repo.findAll();
	}

	@Override
	public Company getCompanyById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public Company getCompanyByName(String name) {
		return repo.getCompanyByName(name);
	}

	@Override
	public Company getCompanyBySymbol(String symbol) {
		return repo.getCompanyBySymbol(symbol);
	}

	@Override
	public List<Company> getCompaniesBySector(String sector) {
		return repo.getCompaniesBySector(sector);
	}

	@Override
	public List<Company> getCompaniesByExchange(String exchange) {
		return repo.getCompaniesByExchange(exchange);
	}

	@Override
	public List<Company> getCompaniesByIndustry(String industry) {
		return repo.getCompaniesByIndustry(industry);
	}

}
