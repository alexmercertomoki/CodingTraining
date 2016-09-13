package com.jp12.service;

import java.util.List;

import com.jp12.dao.JPUserDao;
import com.jp12.domain.JPUser;

public class JPUserService {

	private JPUserDao dao ;
	
	public JPUserService(){
		dao = new JPUserDao();
	}
	
	public List<JPUser> findAllUser(){
		
		String sql = "select * from myuser";
		
		List<JPUser> list = dao.findUsers(sql);
		
		return list;
		
	}
	
	public boolean findUserByName(String name){
		
		String sql = "select * from myuser where name='"+name+"'";
		
		List<JPUser> list = dao.findUsers(sql);
		if(list!=null && list.size()>0){
			return true;
		}
		
		return false;
		
	}
	
	public boolean findUserForLogin(String username, String password){
		
		String sql = "select * from myuser " +
				" where name='"+username+"' and password='"+password+"'";
		
		List<JPUser> list = dao.findUsers(sql);
		if(list!=null && list.size()==1){
			return true;
		}
		
		return false;
		
	}
	
	public JPUser findUserById(String id){
		
		String sql = "select * from myuser where id='"+id+"'";
		
		List<JPUser> list = dao.findUsers(sql);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
		
	}
	
	
	
	public void delete(JPUser user){
		dao.delete(user);
	}
	
	public void add(JPUser user){
		dao.add(user);
	}
	
	public void update(JPUser user){
		dao.update(user);
	}
	
	
	
}
