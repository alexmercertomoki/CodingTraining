package com.soft.service;

import java.util.List;

import com.soft.dao.UserDao;
import com.soft.domain.User;

public class UserService {

	private UserDao dao ;
	
	public UserService(){
		dao = new UserDao();
	}
	
	public void add(User user){
		dao.add(user);
	}
	
	public void delete(User user){
		dao.delete(user);
	}
	
	public boolean findUserByUserName(String username){
		// 拼接sql语句
		String sql = "select * from user_info where username='"+username+"' ";
		
		// 执行SQL语句 返回结果， 进行处理
		List<User> list = dao.find(sql);
		// 如果没有查到，说明 将要的注册的用户名 不存在 可以注册
		if(list!=null && list.size()==0){
			return false;
		}
		return true;
	}
	
	public List<User> findAllUsers(){
		String sql = "select * from user_info";
		List<User> list = dao.find(sql);
		return list;
	}
	
		
}
