package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowerDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public BorrowerDAO() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	
	
	public ResultSet Borrower() throws SQLException{
		String sql="";
		sql="select * from borrower";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public ResultSet getSpecificBorrower(String Account) throws SQLException{
		String sql="select * from borrower where Account = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, Account);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public int ckAccount(String ac) throws SQLException{
		String sql="select Account from borrower where Account = ? ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, ac);
		System.out.println(pstmt.toString());
		rs=pstmt.executeQuery();
		int i=0;
		if(rs.first()){
			i++;
		}
		return i;
	}
	
	public String getPassword(String user) throws SQLException{
		String sql="select Password from borrower where Account = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user);
		System.out.println(pstmt.toString());
		rs=pstmt.executeQuery();
		String pw="";
		if(rs.first()){
			pw=rs.getString("Password");
		}
		return pw;
	}
	
	public int createBorrower(String account,String password,String name,String liveaddress,String email,String phonenumber,String identifyID,String wordaddress) throws SQLException{
		int result=0;
		String sql="insert into borrower ( Account , Password , Name , LiveAddress , Email , PhoneNumber , IdentifyID , WorkAddress ) value ( ?,?,?,?,?,?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, account);
		pstmt.setString(2, password);
		pstmt.setString(3, name);
		pstmt.setString(4, liveaddress);
		pstmt.setString(5, email);
		pstmt.setString(6, phonenumber);
		pstmt.setString(7, identifyID);
		pstmt.setString(8, wordaddress);
		System.out.println(pstmt.toString());
		result=pstmt.executeUpdate();
		return result;
	}
	
	public int updateBorrower(String account,String password,String name,String liveaddress,String email,String phonenumber,String wordaddress) throws SQLException{
		int res=0;
		
		String sql="update borrower set Password = ? , Name = ? , LiveAddress = ? , Email = ? , PhoneNumber = ? , WorkAddress = ? where Account = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setString(2, name);
		pstmt.setString(3, liveaddress);
		pstmt.setString(4, email);
		pstmt.setString(5, phonenumber);
		pstmt.setString(6, wordaddress);
		pstmt.setString(7, account);
		
//		String sql="update borrower set IdentifyID = ? , Password = ? , Name = ? , LiveAddress = ? , Email = ? , PhoneNumber = ? , WorkAddress = ? where Account = ?";
//		pstmt=con.prepareStatement(sql);
//
//		pstmt.setString(1, ID);
//		pstmt.setString(2, password);
//		pstmt.setString(3, name);
//		pstmt.setString(4, liveaddress);
//		pstmt.setString(5, email);
//		pstmt.setString(6, phonenumber);
//		pstmt.setString(7, wordaddress);
//		pstmt.setString(8, account);
		
		
		
		System.out.println(pstmt.toString());
		res=pstmt.executeUpdate();
		
		return res;
	}

}
