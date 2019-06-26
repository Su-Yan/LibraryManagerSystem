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
 * Servlet implementation class GetBorrowList
 */
@WebServlet("/GetBorrowList")
public class GetBorrowList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBorrowList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String SearchOption=request.getParameter("SearchOption");
		String InputValue=request.getParameter("InputValue");
		String ReturnOrNot=request.getParameter("ReturnOrNot");
		String SearchMethod=request.getParameter("SearchMethod");
		request.setAttribute("operationHead", "Borrow List");
		ResultSet rs=null;
		try{
			BookBorrowedLog bbl=new BookBorrowedLog();
			rs=bbl.getBorrowHistory(SearchOption, InputValue, ReturnOrNot, SearchMethod);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		request.setAttribute("table", rs);
		RequestDispatcher rd=request.getRequestDispatcher("borrowlist1.jsp");
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
