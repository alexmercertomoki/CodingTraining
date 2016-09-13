package com.jp12.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jp12.domain.Company;

public class CompanyDao {

	
	/**
	 * 向数据库中添加一个用户
	 * 
	 * @param company
	 */
	public void add(Company company) {
		Connection conn = null;
		PreparedStatement ps = null;// 防止SQL注入

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 驱动
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// 设置不自动提交
			conn.setAutoCommit(false);

			String sql = "insert into mycompany (name) values(?) ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, company.getName());

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
	 * @param company
	 */
	public void update(Company company) {
		Connection conn = null;
		PreparedStatement ps = null;// 防止SQL注入

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 驱动
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// 设置不自动提交
			conn.setAutoCommit(false);

			String sql = "update mycompany set name=? where id=? ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, company.getName());
			ps.setLong(2, company.getId());

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
	 * @param company
	 */
	public void delete(Company company) {
		Connection conn = null;
		PreparedStatement ps = null;// 防止SQL注入

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 驱动
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// 设置不自动提交
			conn.setAutoCommit(false);

//			String sql = "delete from company where id='"+company.getId()+"'";
			
			String sql = "delete from mycompany where id=?";
			// delete from mycompany where id='1'
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, company.getId());

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
	
	
	public List<Company> findUsers(String sql){
		//	泛型
		List<Company> list = new ArrayList<Company>();
		
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
				Company jpuser = new Company();
				
				long id = rs.getLong("id");
				jpuser.setId(id);
				
				String name = rs.getString("name");
				jpuser.setName(name);
			
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
