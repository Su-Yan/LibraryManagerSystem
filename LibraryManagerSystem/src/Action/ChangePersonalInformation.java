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

import DAO.AdminDAO;
import DAO.BorrowerDAO;

/**
 * Servlet implementation class ChangePersonalInformation
 */
@WebServlet("/ChangePersonalInformation")
public class ChangePersonalInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePersonalInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String URL="index.jsp";
		try {
			HttpSession session=request.getSession();
			String Account=(String)session.getAttribute("UserName");
			String Identity=(String)session.getAttribute("Identity");
			ResultSet rs=null;
			if(Identity!=null){
				if(Identity.equals("Borrower")){
					BorrowerDAO bd=new BorrowerDAO();
					rs=bd.getSpecificBorrower(Account);
				}else if(Identity.equals("Admin")){
					AdminDAO ad=new AdminDAO();
					rs=ad.getSpecificAdmin(Account);
				}
				URL="changepersonalinformation.jsp";
			}
			
			
			request.setAttribute("table", rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(URL);
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
