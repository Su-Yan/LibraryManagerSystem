package Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminDAO;
import DAO.BorrowerDAO;

/**
 * Servlet implementation class CheckAccountExist
 */
@WebServlet("/CheckAccountExist")
public class CheckAccountExist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAccountExist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String idd=request.getParameter("idd");
		if(idd.equals("borrower")){
			try {
				BorrowerDAO bd=new BorrowerDAO();
				if(bd.ckAccount(username)!=0){
					response.getWriter().print(true);
				}else{
					response.getWriter().print(false);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if(idd.equals("admin")){
			try {
				AdminDAO bd=new AdminDAO();
				if(bd.ckAccount(username)!=0){
					response.getWriter().print(true);
				}else{
					response.getWriter().print(false);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
