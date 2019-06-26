package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public LibraryDAO() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	
	
	public ResultSet getLocations() throws SQLException{
		String sql="";
		sql="select * from library";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	

}
