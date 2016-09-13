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
		// ƴ��sql���
		String sql = "select * from user_info where username='"+username+"' ";
		
		// ִ��SQL��� ���ؽ���� ���д���
		List<User> list = dao.find(sql);
		// ���û�в鵽��˵�� ��Ҫ��ע����û��� ������ ����ע��
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
