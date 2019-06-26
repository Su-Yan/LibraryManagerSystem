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

import DAO.DonateHistoryDAO;

/**
 * Servlet implementation class DonateManager
 */
@WebServlet("/DonateManager")
public class DonateManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonateManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			
		ResultSet rs=null;
		HttpSession session=request.getSession();
		String UserName=(String) session.getAttribute("UserName");
		String Identity=(String) session.getAttribute("Identity");
		DonateHistoryDAO dhd=new DonateHistoryDAO();
		if(Identity!=null){
			if(Identity.equals("Admin")){

				rs=dhd.getDonateHistory("*");
			}else if(Identity.equals("Borrower")){
				rs=dhd.getDonateHistory(UserName);
				
			}
		}
		
		request.setAttribute("table", rs);
		RequestDispatcher rd=request.getRequestDispatcher("donatemanager.jsp");
		rd.forward(request, response);
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
