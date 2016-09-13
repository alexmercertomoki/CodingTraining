package com.jp12.service;

import java.util.List;

import com.jp12.dao.CompanyDao;
import com.jp12.domain.Company;

public class CompanyService {

	private CompanyDao dao ;
	
	public CompanyService(){
		dao = new CompanyDao();
	}
	
	public List<Company> findAllCompany(){
		String sql = "select * from mycompany";
		List<Company> list = dao.findUsers(sql);
		return list;
	}
}
