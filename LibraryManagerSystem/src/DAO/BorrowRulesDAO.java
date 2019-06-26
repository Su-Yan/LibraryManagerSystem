package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowRulesDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public BorrowRulesDAO() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	
	
	public ResultSet getRules() throws SQLException{
		String sql="";
		sql="select * from borrowrules";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public int deleteRules(int ID) throws SQLException{
		int res=0;
		
		String sql="delete from borrowrules where ID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, ID);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		
		return res;
	}

	
	public int updateRules(int ID, String Rules) throws SQLException{
		int res=0;
		
		String sql="update borrowrules set Rules = ? where ID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, Rules);
		pstmt.setInt(2, ID);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		
		return res;
		
	}
	
	public int addRules(String Rules) throws SQLException{
		int res=0;
		
		String sql="insert into borrowrules (  Rules ) values ( ? )";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, Rules);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		
		return res;
		
	}
}
