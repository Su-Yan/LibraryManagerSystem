package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DonateHistoryDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public DonateHistoryDAO() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	
	public ResultSet getHistoryByBookID(String BookID) throws SQLException{
		String sql="";
		sql="select * from donatehistory where BookID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, BookID);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public ResultSet getDonateHistory(String Account) throws SQLException{
		String sql="";
		if(Account!="*"){
			sql="select * from donatehistory where Borrower = ? order by IsAbled asc , DonateTime asc , BookID asc";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, Account);
		}else if(Account=="*"){
			sql="select * from donatehistory order by IsAbled asc , DonateTime asc , BookID asc ";
			pstmt=con.prepareStatement(sql);
		}
		rs=pstmt.executeQuery();
		System.out.println(pstmt.toString());
		return rs;
	}
	

	public int updateBookStateByBookIDWhenDonateNewBook(String BookID, Date ConfirmDate) throws SQLException{
		int res=0;
		String sql="update donatehistory set IsAbled = ? , ConfirmTime = ? where BookID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, 1);
		pstmt.setDate(2, ConfirmDate);
		pstmt.setString(3, BookID);
		res=pstmt.executeUpdate();
		
		return res;
	}
	
	public int insertDonateHistory(String BookID, String BookName, int DonateAmount, String Borrower, Date DonateTime, Date ConfirmTime, int IsAbled, String NewOrOld) throws SQLException{
		int res=0;
		
		String sql="insert into donatehistory ( BookID , BookName , DonateAmount , Borrower , DonateTime , ConfirmTime , IsAbled , NewOrOld) values ( ?,?,?,?,?,?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, BookID);
		pstmt.setString(2, BookName);
		pstmt.setInt(3, DonateAmount);
		pstmt.setString(4, Borrower);
		pstmt.setDate(5, DonateTime);
		pstmt.setDate(6, ConfirmTime);
		pstmt.setInt(7, IsAbled);
		pstmt.setString(8, NewOrOld);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		return res;
	}
	
}
