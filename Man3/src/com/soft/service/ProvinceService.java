package com.soft.service;

import java.util.List;

import com.soft.dao.ProvinceDao;
import com.soft.domain.Province;

public class ProvinceService {

	private ProvinceDao dao ;
	
	public ProvinceService(){
		dao = new ProvinceDao();
	}
	
	public void add(Province province){
		dao.add(province);
	}
	
	public void update(Province province){
		dao.update(province);
	}
	
	public void delete(Province province){
		dao.delete(province);
	}
	
	public List<Province> findAllProvinces(){
		String sql = "select * from bbs_province";
		List<Province> list = dao.find(sql);
		return list;
	}
	
	
	
}
