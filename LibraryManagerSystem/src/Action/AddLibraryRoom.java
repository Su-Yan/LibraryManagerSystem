package Action;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import DAO.LibraryDAO;
import DAO.LibraryRoomDAO;

/**
 * Servlet implementation class AddLibraryRoom
 */
@WebServlet("/AddLibraryRoom")
public class AddLibraryRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLibraryRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		try{
			String RoomName=request.getParameter("RoomName");
			int RoomFloor=Integer.parseInt(request.getParameter("RoomFloor"));
			String Telephone=request.getParameter("Telephone");
			String []Category=request.getParameter("Category").split(",");
			String BrefIntroduction=request.getParameter("BrefIntroduction");
			String openTime=request.getParameter("OpenTime");
			String closeTime=request.getParameter("CloseTime");
			openTime=openTime+":00";
			closeTime=closeTime+":00";
			System.out.println(openTime);
			System.out.println(closeTime);
			Time OpenTime=Time.valueOf(openTime);
			Time CloseTime=Time.valueOf(closeTime);
			System.out.println("success");
			LibraryRoomDAO lrd=new LibraryRoomDAO();
			lrd.insertRoomInfo(RoomName, RoomFloor, Telephone, BrefIntroduction, OpenTime, CloseTime);
			CategoryDAO cd=new CategoryDAO();
			cd.insertBookCategory(Category, RoomName);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		RequestDispatcher rd=request.getRequestDispatcher("admincenter.jsp");
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
