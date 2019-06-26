package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public BookDAO() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	
	public int deleteBook(String BookID) throws SQLException{
		int res=0;
		
		String sql="delete from bookinfo where ID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, BookID);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		
		return res;
	}
	
	public int updateBookByBookID(String BookID, String BookName, String PublishingHouse, Date PublishingYear,  String StoragePlace, float price, int Amount, String Category, String BrefIntroduction) throws SQLException{
		int res=0;
		
		String sql="update bookinfo set BookName = ? , PublishingHouse = ? , PublishingYear = ?  , StoragePlace = ? , Price = ? , Amount = ? , Category = ? , BrefIntroduction = ? where ID = ? ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, BookName);
		pstmt.setString(2, PublishingHouse);
		pstmt.setDate(3, PublishingYear);
		pstmt.setString(4, StoragePlace);
		pstmt.setFloat(5, price);
		pstmt.setInt(6, Amount);
		pstmt.setString(7, Category);
		pstmt.setString(8, BrefIntroduction);
		pstmt.setString(9, BookID);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		
		return res;
	}
	
	public int updateBookAmountByBookIDWhenBorrowed(String BookID,String Method) throws SQLException{
		int res=0;
		rs=getBooks("ID", BookID, "PriciseSearch");
		rs.first();
		int amt=rs.getInt("Amount");
		if(Method.equals("sub")){
			amt--;
		}
		else if(Method.equals("add")){
			amt++;
		}
		System.out.println(amt);
		String sql="update bookinfo set Amount = ? where ID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, amt);
		pstmt.setString(2, BookID);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		return res;
	}
	
	public int updateBookAmountByBookIDWhenDonated(String BookID,int addAmount) throws SQLException{
		int res=0;
		rs=getBooks("ID", BookID, "PriciseSearch");
		rs.first();
		int amt=rs.getInt("Amount");
		amt=amt+addAmount;
		System.out.println(amt);
		String sql="update bookinfo set Amount = ? where ID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, amt);
		pstmt.setString(2, BookID);
		System.out.println(pstmt.toString());
		res=pstmt.executeUpdate();
		
		return res;
	}

	public int updateBookStateByBookIDWhenDonateNewBook(String BookID) throws SQLException{
		int res=0;
		String sql="update bookinfo set IsAbled = ? where ID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, 1);
		pstmt.setString(2, BookID);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		return res;
	}
	
	public ResultSet getBooks(String colName,String value,String Method) throws SQLException{
		String sql="";
		if(Method.equals("FuzzySearch")){
			sql="select ID,BookName,AuthorName,PublishingHouse,PublishingYear,StoragePlace,Price,Amount,Category,BrefIntroduction from (select BookID,GROUP_CONCAT(AuthorName SEPARATOR ', ') as AuthorName from bookauthor GROUP BY BookID) a INNER JOIN bookinfo on a.BookID=bookinfo.ID where "+colName+" like ? and IsAbled = 1 order by "+colName+" not in(?)";
			pstmt=con.prepareStatement(sql);
			String tmp="%"+value+"%";
			pstmt.setString(1, tmp);
			pstmt.setString(2, value);
			System.out.println(pstmt.toString());
		}else{
			sql="select ID,BookName,AuthorName,PublishingHouse,PublishingYear,StoragePlace,Price,Amount,Category,BrefIntroduction from (select BookID,GROUP_CONCAT(AuthorName SEPARATOR ', ') as AuthorName from bookauthor GROUP BY BookID) a INNER JOIN bookinfo on a.BookID=bookinfo.ID where "+colName+" = ? and IsAbled = 1 order by BookName";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, value);
			System.out.println(pstmt.toString());
		}
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public int insertBook(String BookID, String BookName, String PublishingHouse, Date PublishingYear, Date StorageTime, String StoragePlace, float price, int Amount, String Category, String BrefIntroduction ,int IsAbled) throws SQLException{
		int res=0;
		
		String sql="insert into bookinfo ( ID ,  BookName , PublishingHouse ,  PublishingYear , StoragePlace , StorageTime , Price , Amount , IsAbled , Category , BrefIntroduction ) values (?,?,?,?,?,?,?,?,?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, BookID);
		pstmt.setString(2, BookName);
		pstmt.setString(3, PublishingHouse);
		pstmt.setDate(4, PublishingYear);
		pstmt.setString(5, StoragePlace);
		pstmt.setDate(6, StorageTime);
		pstmt.setFloat(7, price);
		pstmt.setInt(8, Amount);
		pstmt.setInt(9, IsAbled);
		pstmt.setString(10, Category);
		pstmt.setString(11, BrefIntroduction);
		res=pstmt.executeUpdate();
		System.out.println(pstmt.toString());
		
		return res;
	}
	
	public int getAllDiffBookAmounts() throws SQLException{
		int i=0;
		String sql="select COUNT(BookName) as Amount from bookinfo ";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		rs.first();
		i=rs.getInt("Amount");
		System.out.println(pstmt.toString());
		return i;
	}
	
	public String getLargestBookNumber() throws SQLException{
		String res="";
		String sql="select ID from bookinfo order by ID desc limit 1";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		rs.first();
		res=rs.getString("ID");
		System.out.println(pstmt.toString());
		return res;
	}
	
	public ResultSet getNewBooks() throws SQLException{
		String sql="select ID,BookName,AuthorName,PublishingHouse,PublishingYear,StoragePlace,Price,Amount,Category,BrefIntroduction from (select BookID,GROUP_CONCAT(AuthorName SEPARATOR ', ') as AuthorName from bookauthor GROUP BY BookID) a INNER JOIN bookinfo on a.BookID=bookinfo.ID where IsAbled = 1 order by StorageTime desc , BookName asc limit 20";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		System.out.println(pstmt.toString());
		return rs;
		
	}
}
