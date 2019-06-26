package Action;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDAO;
import DAO.DonateHistoryDAO;

/**
 * Servlet implementation class AdminConfirmDonate
 */
@WebServlet("/AdminConfirmDonate")
public class AdminConfirmDonate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminConfirmDonate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AdminConfirmDonate");
		try{
			request.setCharacterEncoding("UTF-8");
			DonateHistoryDAO dhd=new DonateHistoryDAO();
			BookDAO bd=new BookDAO();
			
			Calendar c=Calendar.getInstance();
			Date ConfirmDate=new Date(c.getTimeInMillis());
			
			String BookID=request.getParameter("BookID");
			ResultSet rs=dhd.getHistoryByBookID(BookID);
			rs.first();
			System.out.println(rs.getString("NewOrOld"));
			
			if(rs.getString("NewOrOld").equals("Old")){
				int i=rs.getInt("DonateAmount");
				bd.updateBookAmountByBookIDWhenDonated(BookID, i);
				dhd.updateBookStateByBookIDWhenDonateNewBook(BookID,ConfirmDate);
				
			}else if(rs.getString("NewOrOld").equals("New")){
				bd.updateBookStateByBookIDWhenDonateNewBook(BookID);
				dhd.updateBookStateByBookIDWhenDonateNewBook(BookID,ConfirmDate);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			
		}
		RequestDispatcher rd=request.getRequestDispatcher("admincenter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
