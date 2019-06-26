package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class RecommendingReadingDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public RecommendingReadingDAO() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	
	
	public ResultSet getRecommendingReading() throws SQLException{
		String sql="";
		sql="select * from recommendingreading order by RecommendingTime desc , BookName limit 10";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public ResultSet getRecommendingReading(String BookID) throws SQLException{
		String sql="";
		sql="select * from recommendingreading where BookID = ? ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, BookID);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public int insertRecommendBook(String BookID, String BookName, String Reason) throws SQLException{
		int res=0;
		String sql="insert into recommendingreading ( BookID , BookName , Reason , RecommendingTime ) values ( ? , ? , ? , ? )";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, BookID);
		pstmt.setString(2, BookName);
		pstmt.setString(3, Reason);
		Calendar c=Calendar.getInstance();
		Date rt=new Date(c.getTimeInMillis());
		pstmt.setDate(4, rt);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		return res;
	}
	
	public int deleteRecommendBook(String BookID, String Reason) throws SQLException{
		int res=0;
		String sql="delete from recommendingreading where BookID = ? and Reason = ? ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, BookID);
		pstmt.setString(2, Reason);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		return res;
	}
	

}
