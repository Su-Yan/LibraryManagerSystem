package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookAuthorDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public BookAuthorDAO() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	
	public int deleteAuthor(String BookID) throws SQLException{
		int res=0;
		
		String sql="delete from bookauthor where BookID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, BookID);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		
		return res;
	}
	
	public int insertBookAuthor(String []Author,String BookID) throws SQLException{
		int res=0;
		
		String sql="insert into bookauthor ( AuthorName , BookID ) values (?,?)";
		int i=Author.length;
		for(int j=0;j<i;j++){
			res++;
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, Author[j]);
			pstmt.setString(2, BookID);
			pstmt.executeUpdate();
			System.out.println(pstmt.toString());
			
		}
		
		
		return res;
	}

}
