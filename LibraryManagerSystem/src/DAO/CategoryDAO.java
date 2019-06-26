package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public CategoryDAO() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	

	public int deleteCategory(String RoomName) throws SQLException{
		int res=0;
		
		String sql="delete from category where RoomName = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, RoomName);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		
		return res;
	}
	
	
	public int insertBookCategory(String []Category,String RoomName) throws SQLException{
		int res=0;
		
		String sql="insert into category ( RoomName , Category ) values (?,?)";
		int i=Category.length;
		for(int j=0;j<i;j++){
			res++;
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, RoomName);
			pstmt.setString(2, Category[j]);
			pstmt.executeUpdate();
			System.out.println(pstmt.toString());
			
		}
		
		
		return res;
	}

}
