package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public AdminDAO() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	
	
	public ResultSet getallAdmin() throws SQLException{
		String sql="";
		sql="select * from admindetails";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public ResultSet getSpecificAdmin(String Account) throws SQLException{
		String sql="";
		sql="select * from admindetails where Account = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, Account);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public int updateBorrower(String account,String password,String name,String liveaddress,String email,String phonenumber) throws SQLException{
		int res=0;
		
		String sql="update admindetails set Password = ? , AdminName = ? , LiveAddress = ? , Email = ? , PhoneNumber = ?  where Account = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setString(2, name);
		pstmt.setString(3, liveaddress);
		pstmt.setString(4, email);
		pstmt.setString(5, phonenumber);
		pstmt.setString(6, account);
		
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
	
	public String getPassword(String user) throws SQLException{
		String sql="select Password from admindetails where Account = ?";
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
	
	public int ckAccount(String ac) throws SQLException{
		String sql="select Account from admindetails where Account = ? ";
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
	
	public String[] getAdminManagerRight(String user) throws SQLException{
		String sql="select AdminManager , UserManager , BookManager from admindetails where Account = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user);
		System.out.println(pstmt.toString());
		rs=pstmt.executeQuery();
		String []pw={"0","0","0"};
		if(rs.first()){
			pw[0]=rs.getString("AdminManager");
			pw[1]=rs.getString("UserManager");
			pw[2]=rs.getString("BookManager");
		}
		return pw;
	}
	
	public int createAdmin(String account,String password,String name,String liveaddress,String email,String phonenumber,String identifyID, String BookManager, String UserManager, String AdminManager) throws SQLException{
		int result=0;
		String sql="insert into admindetails ( Account , Password , AdminName , LiveAddress , Email , PhoneNumber , IdentifyID , BookManager , UserManager , AdminManager ) value ( ?,?,?,?,?,?,?,?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, account);
		pstmt.setString(2, password);
		pstmt.setString(3, name);
		pstmt.setString(4, liveaddress);
		pstmt.setString(5, email);
		pstmt.setString(6, phonenumber);
		pstmt.setString(7, identifyID);
		pstmt.setString(8, BookManager);
		pstmt.setString(9, UserManager);
		pstmt.setString(10, AdminManager);
		System.out.println(pstmt.toString());
		result=pstmt.executeUpdate();
		return result;
	}

	

}
