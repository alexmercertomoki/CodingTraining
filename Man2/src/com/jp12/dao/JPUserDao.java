package com.jp12.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jp12.domain.JPUser;

public class JPUserDao {

	
	public static void main(String[] args) {
		
		// 链表 
		int[] arr = new int[10];
		arr[0] = 5;
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
			
		}
		System.out.println();
		
		
		List list2 = new ArrayList();
		list2.add(5);
		list2.add("4");
		list2.add(1.8);
		list2.add(new JPUser());
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i));
		}
		
		List<String> list = new ArrayList<String>();
		list.add("4");
		
	}
	
	/**
	 * 向数据库中添加一个用户
	 * 
	 * @param user
	 */
	public void add(JPUser user) {
		Connection conn = null;
		PreparedStatement ps = null;// 防止SQL注入

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 驱动
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// 设置不自动提交
			conn.setAutoCommit(false);

			String sql = "insert into myuser (name,password,companyId) values(?,?,?) ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getCompanyId());

			// 执行SQL语句
			int changedCount = ps.executeUpdate();

			// 提交
			conn.commit();
		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 数据库中更新一个用户
	 * 
	 * @param user
	 */
	public void update(JPUser user) {
		Connection conn = null;
		PreparedStatement ps = null;// 防止SQL注入

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 驱动
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// 设置不自动提交
			conn.setAutoCommit(false);

			String sql = "update myuser set name=?, password=?,companyId=? where id=? ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getCompanyId());
			ps.setLong(4, user.getId());

			// 执行SQL语句
			int changedCount = ps.executeUpdate();

			// 提交
			conn.commit();
		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 从数据库中删除一个雇员
	 * 
	 * @param user
	 */
	public void delete(JPUser user) {
		Connection conn = null;
		PreparedStatement ps = null;// 防止SQL注入

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 驱动
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// 设置不自动提交
			conn.setAutoCommit(false);

//			String sql = "delete from user where id='"+user.getId()+"'";
			
			String sql = "delete from myuser where id=?";
			// delete from myuser where id='1'
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, user.getId());

			// 执行SQL语句
			int changedCount = ps.executeUpdate();

			// 提交
			conn.commit();
		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	public List<JPUser> findUsers(String sql){
		//	泛型
		List<JPUser> list = new ArrayList<JPUser>();
		
		Connection conn=null; // 数据库连接
		Statement statement=null; // 发送SQL语句
		ResultSet rs=null; // 结果集
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 驱动
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// url 用户名 密码
			statement=conn.createStatement();

			// // String sql=" select * from jp_user ";
			
			rs = statement.executeQuery(sql);	
			
			while(rs.next()){
				JPUser jpuser = new JPUser();
				
				long id = rs.getLong("id");
				jpuser.setId(id);
				
				String name = rs.getString("name");
				jpuser.setName(name);
				
				String password = rs.getString("password");
				jpuser.setPassword(password);
				
				long companyId = rs.getLong("companyId");
				jpuser.setCompanyId(companyId);
				
				list.add(jpuser);

			}
								
			
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
			try{
				conn.rollback();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		catch(Exception e){
			try{
				conn.rollback();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		finally{
			try{
				statement.close();
				conn.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		return list;
		
		
	}
	
}
