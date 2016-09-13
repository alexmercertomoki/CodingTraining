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
	
	public void update(User user){
		dao.update(user);
	}
	
	public void delete(User user){
		dao.delete(user);
	}
	
	public boolean findUserByUserName(String username){
		// ƴ��sql���
		String sql = "select * from bbs_user where username='"+username+"' ";
		
		// ִ��SQL��� ���ؽ���� ���д���
		List<User> list = dao.find(sql);
		// ���û�в鵽��˵�� ��Ҫ��ע����û��� ������ ����ע��
		if(list!=null && list.size()==0){
			return false;
		}
		return true;
	}
	
	public List<User> findAllUsers(){
		String sql = "select * from bbs_user";
		List<User> list = dao.find(sql);
		return list;
	}
	
	public List<User> findUsersByPage(int start, int pagecount){
		String sql = "select * from bbs_user limit "+start+","+pagecount+"";
		List<User> list = dao.find(sql);
		return list;
	}
	
//	public List<User> findUsersAndProvinces(){
//		String sql = "select * from bbs_user u Left JOIN bbs_province p on u.provinceId = p.id ";
//		List<User> list = dao.find(sql);
//		return list;
//	}
	// DTO
	
	public User findUserById(String id){
		String sql = "select * from bbs_user where id='"+id+"'";
		List<User> list = dao.find(sql);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
	}
	
}
