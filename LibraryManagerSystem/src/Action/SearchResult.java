package Action;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDAO;
import DAO.BorrowRulesDAO;
import DAO.LibraryDAO;
import DAO.LibraryRoomDAO;
import DAO.RecommendingReadingDAO;

/**
 * Servlet implementation class SearchResult
 */
@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println(request.getParameter("operationName"));
		request.setCharacterEncoding("UTF-8");
		String operationName="";
		operationName=request.getParameter("operationName");
		request.setAttribute("operationName", operationName);
		ResultSet rs=null;
		request.setAttribute("table", rs);
		switch(operationName){
		case "SearchBook":
			try {
				BookDAO bd=new BookDAO();
				String SearchOption=request.getParameter("SearchOption");
				String Value=request.getParameter("InputValue");
				String SearchMethod=request.getParameter("SearchMethod");
				if(SearchOption.equals("Author"))
					SearchMethod="FuzzySearch";
				rs=bd.getBooks(SearchOption,Value,SearchMethod);
				request.setAttribute("operationHead", "Book in Store");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Locations":
			try{
				LibraryRoomDAO ld=new LibraryRoomDAO();
				rs=ld.getLocations();
				request.setAttribute("operationHead", "Locations");
			}catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "BorrowRules":
			try{
				BorrowRulesDAO bd=new BorrowRulesDAO();
				rs=bd.getRules();
				request.setAttribute("operationHead", "Borrow Rules");
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			break;
		case "AboutUs":
			try{
				LibraryDAO ld=new LibraryDAO();
				rs=ld.getLocations();
				request.setAttribute("operationHead", "About Us");
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "RecommendedReading":
			try{
				RecommendingReadingDAO ld=new RecommendingReadingDAO();
				rs=ld.getRecommendingReading();
				request.setAttribute("operationHead", "Recommended Reading");
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			break;
		case "NewBooks":
			try{
				BookDAO db=new BookDAO();
				rs=db.getNewBooks();
				request.setAttribute("operationHead", "New Books");
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			break;
			default:
				request.setAttribute("operationHead", operationName);
		}
		request.setAttribute("table", rs);
		RequestDispatcher rd=request.getRequestDispatcher("searchresult.jsp");
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
