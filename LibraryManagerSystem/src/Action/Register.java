package Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminDAO;
import DAO.BorrowerDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String createWho=request.getParameter("create");
		String URL="register.jsp";
		if(createWho!=null){
			if(createWho.equals("borrower")){

				try {
					BorrowerDAO bd=new BorrowerDAO();
					String Account=request.getParameter("Account");
					String Password=request.getParameter("Password");
					String Name=request.getParameter("Name");
					String IdentifyID=request.getParameter("IdentifyID");
					String LiveAddress=request.getParameter("LiveAddress");
					String Email=request.getParameter("Email");
					String PhoneNumber=request.getParameter("PhoneNumber");
					String WorkAddress=request.getParameter("WorkAddress");
					int res=bd.createBorrower(Account, Password, Name, LiveAddress, Email, PhoneNumber, IdentifyID, WorkAddress);
					if(res!=0){
						URL="Login.jsp";
					}else{
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{

				try {
					AdminDAO bd=new AdminDAO();
					String Account=request.getParameter("Account");
					String Password=request.getParameter("Password");
					String Name=request.getParameter("Name");
					String IdentifyID=request.getParameter("IdentifyID");
					String LiveAddress=request.getParameter("LiveAddress");
					String Email=request.getParameter("Email");
					String PhoneNumber=request.getParameter("PhoneNumber");
					String BookManager=request.getParameter("BookManager");
					String UserManager=request.getParameter("UserManager");
					String AdminManager=request.getParameter("AdminManager");
					int res=bd.createAdmin(Account, Password, Name, LiveAddress, Email, PhoneNumber, IdentifyID, BookManager, UserManager, AdminManager);
					if(res!=0){
						URL="admincenter.jsp";
					}else{
						URL="createadmin.jsp";
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
