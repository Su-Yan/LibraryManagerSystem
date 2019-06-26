package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class LibraryRoomDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public LibraryRoomDAO() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	

	public int deleteRoom(String RoomName) throws SQLException{
		int res=0;
		
		String sql="delete from libraryroom where RoomName = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, RoomName);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		
		return res;
	}
	
	public ResultSet getLocations() throws SQLException{
		String sql="";
		sql="select a.RoomName , RoomFloor , Category , Telephone , BrefIntroduction , OpenTime , CloseTime from (select RoomName ,GROUP_CONCAT(Category SEPARATOR ', ') as Category from category GROUP BY RoomName) a INNER JOIN libraryroom on a.RoomName=libraryroom.RoomName";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public ResultSet getLocations(String RoomName) throws SQLException{
		String sql="";
		sql="select a.RoomName , RoomFloor , Category , Telephone , BrefIntroduction , OpenTime , CloseTime from (select RoomName ,GROUP_CONCAT(Category SEPARATOR ', ') as Category from category GROUP BY RoomName) a INNER JOIN libraryroom on a.RoomName=libraryroom.RoomName where a.RoomName = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, RoomName);
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public int checkRoomExistOrNot(String RoomName) throws SQLException{
		int i=0;
		
		String sql="";
		sql="select * from libraryroom where RoomName = ? ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, RoomName);
		rs=pstmt.executeQuery();
		System.out.println(pstmt.toString());
		if(rs.first())
			i++;		
		return i;
	}
	
	public int insertRoomInfo(String RoomName, int RoomFloor, String Telephone, String BrefIntroduction, Time OpenTime, Time CloseTime) throws SQLException{
		int res=0;
		String sql="insert into libraryroom ( RoomName , RoomFloor , Telephone , BrefIntroduction , OpenTime , CloseTime ) value (?,?,?,?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, RoomName);
		pstmt.setInt(2, RoomFloor);
		pstmt.setString(3, Telephone);
		pstmt.setString(4, BrefIntroduction);
		pstmt.setTime(5, OpenTime);
		pstmt.setTime(6, CloseTime);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		return res;
	}
	
	public int updateRoomInfo(String RoomName, int RoomFloor, String Telephone, String BrefIntroduction, Time OpenTime, Time CloseTime) throws SQLException{
		int res=0;
		String sql="update libraryroom set RoomFloor = ? , Telephone = ? , BrefIntroduction = ? , OpenTime = ? , CloseTime = ? where RoomName = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, RoomFloor);
		pstmt.setString(2, Telephone);
		pstmt.setString(3, BrefIntroduction);
		pstmt.setTime(4, OpenTime);
		pstmt.setTime(5, CloseTime);
		pstmt.setString(6, RoomName);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		return res;
	}
	
	public int ckRoomExist(String RoomName) throws SQLException{
		int res=0;
		

		String sql="select * from libraryroom where RoomName = ? ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, RoomName);
		System.out.println(pstmt.toString());
		rs=pstmt.executeQuery();
		if(rs.first()){
			res++;
		}
		
		return res;
	}
	
}
