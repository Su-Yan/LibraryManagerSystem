package Action;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookBorrowedLog;

/**
 * Servlet implementation class GetAllFinedNotReturnAccount
 */
@WebServlet("/GetAllFinedNotReturnAccount")
public class GetAllFinedNotReturnAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllFinedNotReturnAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ResultSet rs=null;
		try{
			BookBorrowedLog bbl=new BookBorrowedLog();
			rs=bbl.getAllFinedAccountHistory();
		}catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("operationHead", "All Fined Account");
		request.setAttribute("operationName", "GetAllFinedAccount");
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
