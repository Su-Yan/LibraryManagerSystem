package DAO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

public class test {
	
	public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
       int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //ͬһ��
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //����            
                {
                    timeDistance += 366;
                }
                else    //��������
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }
        else    //��ͬ��
        {
            System.out.println("�ж�day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		����DBConnectionUseType4
//		Connection conn=DBConnectionUseType4.getConnection();
//		ResultSet rs=null;
//		String sql="select * from BookInfo";
//		PreparedStatement pstmt=null;
//		
//		pstmt=conn.prepareStatement(sql);
//		rs=pstmt.executeQuery();
//		ResultSetMetaData rsmd=rs.getMetaData();
//		int col=rsmd.getColumnCount();
//		System.out.println(col);
//		conn.close();
//		rs.close();
//		pstmt.close();
		
		
		//����BookDAO
//		BookDAO bd=new BookDAO();
//		ResultSetMetaData rsmd=null;
//		ResultSet rs=null;
//		int row1=0,row2=0;
//		rs=bd.getBooks("StoragePlace", "Ro", "PreciseSearch");
//		rsmd=rs.getMetaData();
//		int col=rsmd.getColumnCount();
//		while(rs.next()){
//			row1++;
//		}
//		System.out.println(row1);
//		System.out.println(col);
//		
//		
//		rs=bd.getBooks("StoragePlace", "Ro", "FuzzySearch");
//		rsmd=rs.getMetaData();
//		col=rsmd.getColumnCount();
//		while(rs.next()){
//			row2++;
//		}
//		System.out.println(row2);
//		System.out.println(col);

 
//         c.add(Calendar.DATE,30);
// 
//         Date dd = new Date(c.getTimeInMillis());
// 
//         System.out.println(dd); 
		//��0
//		String a="000005";
//		int b=Integer.parseInt(a);
//		String c=String.format("%06d", b);
//		System.out.println(c);
		
		//ָ�����ڼ�ָ��ʱ��
//		Calendar c = Calendar.getInstance();  
//        c.setTime(cur);   //����ʱ��
//        c.add(Calendar.MINUTE, 1); //���ڷ��Ӽ�1,Calendar.DATE(��),Calendar.HOUR(Сʱ)  
//        Date date = c.getTime(); //���
		
		//ʱ���
//		Calendar c=Calendar.getInstance();
//		c.set(2019, 5, 22, 0, 0, 0);
//		Calendar c2=Calendar.getInstance();
//		c2.set(2019, 5, 1, 0, 0, 0);
//		Date d=new Date(c.getTimeInMillis());
//		Date d2=new Date(c2.getTimeInMillis());
//		
//		System.out.println(d);
//		System.out.println(d2);
//		System.out.println(c.getTimeInMillis());
//		System.out.println(c2.getTimeInMillis());
//		double days=Math.ceil((c.getTimeInMillis()-c2.getTimeInMillis())/(1000.0*3600*24));
//		System.out.println(days);
//		System.out.println(d.compareTo(d2));
		
//		int days=differentDays(d2, d);
//		System.out.println(days);
		
		//��������
//		String a="asd,asdw,fae,feesf";
//		String []b=a.split(",");
//		System.out.println(b.length);
//		int i=b.length;
//		for(int j=0;j<i;j++){
//			System.out.println(b[j]);
//		}
		
//		BookDAO bd=new BookDAO();
//		String i=bd.getLargestBookNumber();
//		System.out.println(i);
//		
		
		
	}

}
