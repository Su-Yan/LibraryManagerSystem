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
import javax.servlet.http.HttpSession;

import DAO.BookAuthorDAO;
import DAO.BookDAO;
import DAO.DonateHistoryDAO;

/**
 * Servlet implementation class DonateConfirm
 */
@WebServlet("/DonateConfirm")
public class DonateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonateConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String preNumber ="";
		String BookName=request.getParameter("BookName");
		String user=(String) session.getAttribute("UserName");
		String []Author=request.getParameter("Author").split(",");
		String PublishingHouse=request.getParameter("PublishingHouse");
		Date PublishingYear=Date.valueOf(request.getParameter("PublishingYear"));
		String StoragePlace =request.getParameter("StoragePlace");
		float Price=Float.parseFloat(request.getParameter("Price"));
		int Amount=Integer.parseInt(request.getParameter("Amount"));
		String Category=request.getParameter("Category");
		String BrefIntroduction=request.getParameter("BrefIntroduction");
		Calendar c=Calendar.getInstance();
		Date DonateTime=new Date(c.getTimeInMillis());
		try {
			BookDAO bd=new BookDAO();
			DonateHistoryDAO dhd=new DonateHistoryDAO();
			ResultSet rs=bd.getBooks("BookName", BookName, "PreciseSearch");
			if(rs.first()){
				preNumber=rs.getString("ID");
				dhd.insertDonateHistory(preNumber, BookName, Amount, user, DonateTime, null, 0,"Old");
			}else{
				preNumber = bd.getLargestBookNumber();
				int n=Integer.parseInt(preNumber);
				n++;
				preNumber=String.format("%06d", n);
				BookAuthorDAO bad=new BookAuthorDAO();
				bad.insertBookAuthor(Author, preNumber);
				bd.insertBook(preNumber, BookName, PublishingHouse, PublishingYear, DonateTime, StoragePlace, Price, Amount, Category, BrefIntroduction, 0);
				dhd.insertDonateHistory(preNumber, BookName, Amount, user, DonateTime, null, 0,"New");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("personalcenter.jsp");
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
