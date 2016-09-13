package com.soft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.domain.Province;

public class ProvinceDao {

	public void add(Province province){
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "12345");			
			
			
			String sql="insert into bbs_province (name) values(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, province.getName());
			
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
	public void update(Province province){
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "12345");			
			
			
			String sql="update bbs_province set name=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, province.getName());
			ps.setLong(2, province.getId());
			
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
	public void delete(Province province){
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "12345");			
			
			
			String sql="delete from bbs_province where id=?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, province.getId());
			
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
	
	public List<Province> find(String sql){
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Province> list = new ArrayList<Province>();
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs_user", "root", "12345");
			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();			
			
			while(rs.next()){
				
				Province province = new Province();
				province.setName(rs.getString("name"));
				province.setId(rs.getLong("id"));
				
				list.add(province);
				
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
