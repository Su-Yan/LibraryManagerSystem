package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class BookBorrowedLog {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public BookBorrowedLog() throws Exception{
		con=new DBConnectionUseType4().getConnection();
		rs=null;
		pstmt=null;
	}
	
	public ResultSet getAllFinedAccountHistory() throws SQLException{
		String sql="select * from bookborrowedlog where ReturnOrNot = ? and Fine > ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, "No");
		pstmt.setFloat(2, 0);
		rs=pstmt.executeQuery();
	
		
		
		return rs;
	}
	
	public ResultSet getBorrowHistory(String SearchOption, String InputValue, String ReturnOrNot, String SearchMethod) throws SQLException{
		String sql="";
		if(InputValue.equals("*")){
			if(ReturnOrNot.equals("All")){
				sql="SELECT ID,BookName,AuthorName,BorrowerAccount,BorrowDate,ReturnDateDeadLine,RenewalTime,Fine,ReturnOrNot,ReturnDateInFact from (select ID,BookName,AuthorName,PublishingHouse,PublishingYear,StoragePlace,Category,BrefIntroduction from (select BookID,GROUP_CONCAT(AuthorName SEPARATOR ', ') as AuthorName from bookauthor GROUP BY BookID) a INNER JOIN bookinfo on a.BookID=bookinfo.ID ) b INNER JOIN bookborrowedlog on b.ID=bookborrowedlog.BookID order by ReturnOrNot not in ('No') , ReturnDateDeadLine asc , BookName asc";
				pstmt=con.prepareStatement(sql);
			}else{
				sql="SELECT ID,BookName,AuthorName,BorrowerAccount,BorrowDate,ReturnDateDeadLine,RenewalTime,Fine,ReturnOrNot,ReturnDateInFact from (select ID,BookName,AuthorName,PublishingHouse,PublishingYear,StoragePlace,Category,BrefIntroduction from (select BookID,GROUP_CONCAT(AuthorName SEPARATOR ', ') as AuthorName from bookauthor GROUP BY BookID) a INNER JOIN bookinfo on a.BookID=bookinfo.ID ) b INNER JOIN bookborrowedlog on b.ID=bookborrowedlog.BookID where ReturnOrNot = ? order by ReturnDateDeadLine asc , BookName asc";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, ReturnOrNot);
				
			}
		}else{
			if(!ReturnOrNot.equals("All")){
				if(SearchMethod.equals("FuzzySearch")){
					sql="SELECT ID,BookName,AuthorName,BorrowerAccount,BorrowDate,ReturnDateDeadLine,RenewalTime,Fine,ReturnOrNot,ReturnDateInFact from (select ID,BookName,AuthorName,PublishingHouse,PublishingYear,StoragePlace,Category,BrefIntroduction from (select BookID,GROUP_CONCAT(AuthorName SEPARATOR ', ') as AuthorName from bookauthor GROUP BY BookID) a INNER JOIN bookinfo on a.BookID=bookinfo.ID ) b INNER JOIN bookborrowedlog on b.ID=bookborrowedlog.BookID where "+SearchOption+" like ? and ReturnOrNot = ? order by ReturnDateDeadLine asc , BookName asc";
					pstmt=con.prepareStatement(sql);
					String tmp="%"+InputValue+"%";
					pstmt.setString(1, tmp);
					pstmt.setString(2, ReturnOrNot);
					
				}else if(SearchMethod.equals("PreciseSearch")){
					sql="SELECT ID,BookName,AuthorName,BorrowerAccount,BorrowDate,ReturnDateDeadLine,RenewalTime,Fine,ReturnOrNot,ReturnDateInFact from (select ID,BookName,AuthorName,PublishingHouse,PublishingYear,StoragePlace,Category,BrefIntroduction from (select BookID,GROUP_CONCAT(AuthorName SEPARATOR ', ') as AuthorName from bookauthor GROUP BY BookID) a INNER JOIN bookinfo on a.BookID=bookinfo.ID ) b INNER JOIN bookborrowedlog on b.ID=bookborrowedlog.BookID where "+SearchOption+" = ? and ReturnOrNot = ? order by ReturnDateDeadLine asc , BookName asc";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, InputValue);
					pstmt.setString(2, ReturnOrNot);
					
				}
				
			}else{
				if(SearchMethod.equals("FuzzySearch")){
					sql="SELECT ID,BookName,AuthorName,BorrowerAccount,BorrowDate,ReturnDateDeadLine,RenewalTime,Fine,ReturnOrNot,ReturnDateInFact from (select ID,BookName,AuthorName,PublishingHouse,PublishingYear,StoragePlace,Category,BrefIntroduction from (select BookID,GROUP_CONCAT(AuthorName SEPARATOR ', ') as AuthorName from bookauthor GROUP BY BookID) a INNER JOIN bookinfo on a.BookID=bookinfo.ID ) b INNER JOIN bookborrowedlog on b.ID=bookborrowedlog.BookID where "+SearchOption+" like ? order by ReturnOrNot not in ('No') , ReturnDateDeadLine asc , BookName asc";
					pstmt=con.prepareStatement(sql);
					String tmp="%"+InputValue+"%";
					pstmt.setString(1, tmp);
					
				}else if(SearchMethod.equals("PreciseSearch")){
					sql="SELECT ID,BookName,AuthorName,BorrowerAccount,BorrowDate,ReturnDateDeadLine,RenewalTime,Fine,ReturnOrNot,ReturnDateInFact from (select ID,BookName,AuthorName,PublishingHouse,PublishingYear,StoragePlace,Category,BrefIntroduction from (select BookID,GROUP_CONCAT(AuthorName SEPARATOR ', ') as AuthorName from bookauthor GROUP BY BookID) a INNER JOIN bookinfo on a.BookID=bookinfo.ID ) b INNER JOIN bookborrowedlog on b.ID=bookborrowedlog.BookID where "+SearchOption+" = ? order by ReturnOrNot not in ('No') , ReturnDateDeadLine asc , BookName asc";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, InputValue);
					
				}
				
			}
			
		}
		System.out.println(pstmt.toString());
		
		rs=pstmt.executeQuery();
		return rs;
		
	}
	
	
	public ResultSet getBorrowHistory(String Account) throws SQLException{
		String sql="";
		sql="select * from bookborrowedlog where BorrowerAccount = ? order by ReturnOrNot not in ('No') , ReturnDateDeadLine asc";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, Account);
		System.out.println(pstmt.toString());
		rs=pstmt.executeQuery();
		return rs;
	}
	
	public int insertLog(String BookID,String BorrowerAccount,Date BorrowDate,Date ReturnDateDeadLine) throws SQLException{
		int res=0;
		
		String sql="insert into bookborrowedlog ( BookID , BorrowerAccount , BorrowDate , ReturnDateDeadLine  ) value ( ?,?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, BookID);
		pstmt.setString(2, BorrowerAccount);
		pstmt.setDate(3,BorrowDate);
		pstmt.setDate(4, ReturnDateDeadLine);
		res=pstmt.executeUpdate();
		
		return res;
	}
	
	public int updateLogWhenReturnBook(int LogID) throws SQLException{
		int res=0;
		
		String sql="select ReturnDateDeadLine  from bookborrowedlog where LogID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, LogID);
		rs=pstmt.executeQuery();
		rs.first();
//		Date ReturnDateDeadLine=rs.getDate("ReturnDateDeadLine");
		Calendar c=Calendar.getInstance();
		Date ReturnDate=new Date(c.getTimeInMillis());
//		float fine=0;
//		int days=differentDays(ReturnDateDeadLine, ReturnDate);
//		if(days>0){
//			fine=(float) (days*0.5);
//			System.out.println(ReturnDate);
//			System.out.println(ReturnDateDeadLine);
//			System.out.println(days);
//			System.out.println(fine);
//		}
//		sql="update bookborrowedlog set ReturnDateInFact = ? , Fine = ? ,ReturnOrNot = ? where LogID = ?";
		sql="update bookborrowedlog set ReturnDateInFact = ? ,ReturnOrNot = ? where LogID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setDate(1, ReturnDate);
//		pstmt.setFloat(2, fine);
//		pstmt.setString(3, "Yes");
//		pstmt.setInt(4, LogID);
		pstmt.setString(2, "Yes");
		pstmt.setInt(3, LogID);
		res=pstmt.executeUpdate();
		return res;
	}
	
	public int renewalBook(int LogID) throws SQLException{
		int res=0;
		
		String sql="select ReturnDateDeadLine , RenewalTime from bookborrowedlog where LogID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, LogID);
		rs=pstmt.executeQuery();
		rs.first();
		Date ReturnDateDeadLine =rs.getDate("ReturnDateDeadLine");
		int time =rs.getInt("RenewalTime");
		Calendar c=Calendar.getInstance();
		c.setTime(ReturnDateDeadLine);
		c.add(Calendar.DATE, 30);
		ReturnDateDeadLine.setTime(c.getTimeInMillis());
		time--;
		sql="update bookborrowedlog set ReturnDateDeadLine = ? , RenewalTime = ? where LogID = ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setDate(1, ReturnDateDeadLine);
		pstmt.setInt(2, time);
		pstmt.setInt(3, LogID);
		res=pstmt.executeUpdate();
		return res;
	}
	
	public int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
       int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }

}



