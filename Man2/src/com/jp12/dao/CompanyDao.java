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
	 * �����ݿ������һ���û�
	 * 
	 * @param company
	 */
	public void add(Company company) {
		Connection conn = null;
		PreparedStatement ps = null;// ��ֹSQLע��

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// ����
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// ���ò��Զ��ύ
			conn.setAutoCommit(false);

			String sql = "insert into mycompany (name) values(?) ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, company.getName());

			// ִ��SQL���
			int changedCount = ps.executeUpdate();

			// �ύ
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
	 * ���ݿ��и���һ���û�
	 * 
	 * @param company
	 */
	public void update(Company company) {
		Connection conn = null;
		PreparedStatement ps = null;// ��ֹSQLע��

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// ����
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// ���ò��Զ��ύ
			conn.setAutoCommit(false);

			String sql = "update mycompany set name=? where id=? ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, company.getName());
			ps.setLong(2, company.getId());

			// ִ��SQL���
			int changedCount = ps.executeUpdate();

			// �ύ
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
	 * �����ݿ���ɾ��һ����Ա
	 * 
	 * @param company
	 */
	public void delete(Company company) {
		Connection conn = null;
		PreparedStatement ps = null;// ��ֹSQLע��

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// ����
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// ���ò��Զ��ύ
			conn.setAutoCommit(false);

//			String sql = "delete from company where id='"+company.getId()+"'";
			
			String sql = "delete from mycompany where id=?";
			// delete from mycompany where id='1'
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, company.getId());

			// ִ��SQL���
			int changedCount = ps.executeUpdate();

			// �ύ
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
		//	����
		List<Company> list = new ArrayList<Company>();
		
		Connection conn=null; // ���ݿ�����
		Statement statement=null; // ����SQL���
		ResultSet rs=null; // �����
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// ����
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// url �û��� ����
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
