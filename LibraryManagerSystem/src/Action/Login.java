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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		session.setAttribute("UserName", "");
		session.setAttribute("Identity", "");
		String UserName=request.getParameter("Account");
		String Password=request.getParameter("Password");
		String Identity=request.getParameter("Identity");
		String URL="Login.jsp";
		String ckPassword="";
		try {
			if(Identity!=null){
				if(Identity.equals("borrower")){
					BorrowerDAO bd=new BorrowerDAO();
					ckPassword=bd.getPassword(UserName);
				}else{
					AdminDAO ad=new AdminDAO();
					ckPassword=ad.getPassword(UserName);
				}
			if(ckPassword.equals(null)||ckPassword.equals("")){
				request.setAttribute("errorTip1", "User is not exist!");
			}else if(ckPassword.equals(Password)){
				session.setAttribute("UserName", UserName);
				if(Identity.equals("admindetails")){
					AdminDAO ad1=new AdminDAO();
					String []AdminManagerRights=ad1.getAdminManagerRight(UserName);
					String AdminRight=AdminManagerRights[0];
					String UserRight=AdminManagerRights[1];
					String BookRight=AdminManagerRights[2];
					URL="admincenter.jsp";
					session.setAttribute("AdminRight", AdminRight);
					session.setAttribute("UserRight", UserRight);
					session.setAttribute("BookRight", BookRight);
					session.setAttribute("Identity", "Admin");
				}else{
					URL="personalcenter.jsp";
					session.setAttribute("Identity", "Borrower");
				}
			}else{
				request.setAttribute("errorTip2", "Password is Wrong!");
			}
			
		}
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
