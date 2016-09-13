package com.jp12.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBCʾ������
 * @author bgy
 * @since 2013-9-17 ����01:04:52
 * @version 1.00 bgy ���� 2013-9-17 ����01:04:52
 */
public class JDBCSampleSQLServer2005{
	
	public static void main(String[] args){
		transaction1();
	}
	
	public static void transaction1(){
		// jar��
		Connection conn=null; // ���ݿ�����
		Statement statement=null; // ����SQL���
		ResultSet rs=null; // �����
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// ����
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; DatabaseName=master", "sa", "1234");
			// url �û��� ����
			statement=conn.createStatement();

			String sql=" select * from jp_user ";
			
			rs = statement.executeQuery(sql);	
			
			while(rs.next()){
				System.out.print(rs.getLong("id")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("password")+"\t");
				System.out.println();
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
	}
	
	public static void search1(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "hy");
			
			String sql=" select * from member order by salary ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();			
			
			while(rs.next()){
				System.out.print(rs.getString("id")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("sex")+"\t");
				System.out.print(rs.getInt("salary")+"\t");
				System.out.println();
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
	}
	
	public static void search2(){
		Connection conn=null;
		Statement statement=null;	
		ResultSet rs=null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "123456");			
			
			statement=conn.createStatement();			
			String sql=" select * from member order by salary desc";
			rs=statement.executeQuery(sql);		
			
			while(rs.next()){
				System.out.print(rs.getString("id")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("sex")+"\t");
				System.out.print(rs.getInt("salary")+"\t");
				System.out.println();
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
				statement.close();
				conn.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}