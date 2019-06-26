package Action;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BookBorrowedLog;

/**
 * Servlet implementation class BorrowHistory
 */
@WebServlet("/BorrowHistory")
public class BorrowHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			BookBorrowedLog bbl=new BookBorrowedLog();
			HttpSession session=request.getSession();
			String Identity=(String)session.getAttribute("Identity");
			String UserName=(String)session.getAttribute("UserName");
			ResultSet rs=null;
			if(Identity!=null){
				if(Identity.equals("Borrower")){
					rs=bbl.getBorrowHistory(UserName);
					
				}
				
			}
			request.setAttribute("operationName", "BorrowHistory");
			request.setAttribute("operationHead", "Borrow History");
			request.setAttribute("table", rs);
			RequestDispatcher rd=request.getRequestDispatcher("searchresult.jsp");
			rd.forward(request, response);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
