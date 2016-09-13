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
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "secret-root-password");	
			String sql="insert into bbs_user (username,password) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ps.executeUpdate();		
			System.out.println(sql);
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
			
	}
	public void delete(User user){
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "secret-root-password");	
			
			String sql="delete from bbs_user where id=?";
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, user.getId());
			
			ps.executeUpdate();
//			
			System.out.println(sql);
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
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "secret-root-password");	
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();			
			
			while(rs.next()){
				
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getLong("id"));
				
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
