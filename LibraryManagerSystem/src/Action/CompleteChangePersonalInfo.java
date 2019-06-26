package Action;

import java.io.IOException;

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
 * Servlet implementation class CompleteChangePersonalInfo
 */
@WebServlet("/CompleteChangePersonalInfo")
public class CompleteChangePersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteChangePersonalInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String URL="index.jsp";
		try{
			String Account=(String)request.getParameter("Account");
			String Password=(String) request.getParameter("Password");
			String Name=(String)request.getParameter("Name");
			String LiveAddress=(String)request.getParameter("LiveAddress");
			//String ID=(String)request.getParameter("IdentifyID");
			String Email=(String)request.getParameter("Email");
			String PhoneNumber=(String)request.getParameter("PhoneNumber");
			HttpSession session=request.getSession();
			String Identity=(String)session.getAttribute("Identity");
			switch(Identity){
			case"Borrower":
				String WorkAddress=(String)request.getParameter("WorkAddress");
				BorrowerDAO bd=new BorrowerDAO();
				int i=bd.updateBorrower(Account, Password, Name, LiveAddress, Email, PhoneNumber, WorkAddress);
				if(i==0){
					URL="ChangePersonalInformation";
				}else{
					URL="personalcenter.jsp";
				}
				
				break;
			case"Admin":
				AdminDAO ad=new AdminDAO();
				int j=ad.updateBorrower(Account, Password, Name, LiveAddress, Email, PhoneNumber);
				if(j==0){
					URL="ChangePersonalInformation";
				}else{
					URL="admincenter.jsp";
				}
				break;
			}
		}catch (Exception e) {
			// TODO: handle exception
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
