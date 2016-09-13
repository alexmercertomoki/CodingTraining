package com.soft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.domain.User;

public class UserDao {

	public void add(User user){
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "12345");			
			
			
			String sql="insert into bbs_user (username,password,provinceId,filepath,interest) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getProvinceId());
			ps.setString(4, user.getFilepath());
			ps.setString(5, user.getInterest());
			
			
			ps.executeUpdate();
//			
			// delete from member where id=5;
			
			
		}
		catch(SQLException se){
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
				conn.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		
	}
	public void update(User user){
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "12345");			
			
			
			String sql="update bbs_user set username=?,password=?,provinceId=?,filepath=?,interest=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getProvinceId());
			ps.setString(4, user.getFilepath());
			ps.setString(5, user.getInterest());
			ps.setLong(6, user.getId());
			
			ps.executeUpdate();
//			
		}
		catch(SQLException se){
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
				conn.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	public void delete(User user){
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "12345");			
			
			
			String sql="delete from bbs_user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, user.getId());
			
			ps.executeUpdate();
//			
			// delete from member where id=5;
			
			
		}
		catch(SQLException se){
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
				conn.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public List<User> find(String sql){
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> list = new ArrayList<User>();
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "12345");
			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();			
			
			while(rs.next()){
				
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getLong("id"));
				user.setProvinceId(rs.getLong("provinceId"));
				user.setFilepath(rs.getString("filepath"));
				user.setInterest(rs.getString("interest"));
				list.add(user);
				
//				System.out.print(rs.getString("id")+"\t");
//				System.out.print(rs.getString("name")+"\t");
//				System.out.print(rs.getString("sex")+"\t");
//				System.out.print(rs.getInt("salary")+"\t");
//				System.out.println();
			}
		}
		catch(SQLException se){
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
				rs.close();
				ps.close();
				conn.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		
		return list;
	}
	
}
