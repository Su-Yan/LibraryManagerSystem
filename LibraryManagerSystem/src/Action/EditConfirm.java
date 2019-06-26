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
 * Servlet implementation class EditConfirm
 */
@WebServlet("/EditConfirm")
public class EditConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String preNumber =request.getParameter("BookID");
		String BookName=request.getParameter("BookName");
		String []Author=request.getParameter("Author").split(",");
		String PublishingHouse=request.getParameter("PublishingHouse");
		Date PublishingYear=Date.valueOf(request.getParameter("PublishingYear"));
		String StoragePlace =request.getParameter("StoragePlace");
		float Price=Float.parseFloat(request.getParameter("Price"));
		int Amount=Integer.parseInt(request.getParameter("Amount"));
		String Category=request.getParameter("Category");
		String BrefIntroduction=request.getParameter("BrefIntroduction");
		try {
			BookDAO bd=new BookDAO();
			BookAuthorDAO bad=new BookAuthorDAO();
			bad.deleteAuthor(preNumber);
			bad.insertBookAuthor(Author, preNumber);
			bd.updateBookByBookID(preNumber, BookName, PublishingHouse, PublishingYear, StoragePlace, Price, Amount, Category, BrefIntroduction);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
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
