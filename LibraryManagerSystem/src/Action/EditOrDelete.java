package Action;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookAuthorDAO;
import DAO.BookBorrowedLog;
import DAO.BookDAO;
import DAO.BorrowRulesDAO;
import DAO.CategoryDAO;
import DAO.LibraryRoomDAO;

/**
 * Servlet implementation class EditOrDelete
 */
@WebServlet("/EditOrDelete")
public class EditOrDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String Method=request.getParameter("method");
		String About=request.getParameter("about");
		ResultSet rs=null;
		System.out.println(Method);
		System.out.println(About);
		String URL="index.jsp";
		try{
			if(Method!=null){
				if(Method.equals("Edit")){
					switch(About){
					case"Book":
						String BookID=request.getParameter("BookID");
						BookDAO bd=new BookDAO();
						rs=bd.getBooks("BookID", BookID, "PreciseSearch");
						request.setAttribute("table", rs);
						URL="editbook.jsp";
						break;
					case"Locations":
						String RoomName=request.getParameter("RoomName");
						LibraryRoomDAO lrd=new LibraryRoomDAO();
						rs=lrd.getLocations(RoomName);
						request.setAttribute("table", rs);
						URL="editlibraryroom.jsp";
						break;
					case"BorrowRules":
						
						break;
					}
				}else if(Method.equals("Delete")){
					switch(About){
					case"Book":
						String BookID=request.getParameter("BookID");
						BookBorrowedLog bbl=new BookBorrowedLog();
						rs=bbl.getBorrowHistory("ID", BookID, "No", "PreciseSearch");
						if(rs.first()){
							
						}else{
							BookDAO bd=new BookDAO();
							bd.deleteBook(BookID);
							BookAuthorDAO bad=new BookAuthorDAO();
							bad.deleteAuthor(BookID);
							URL="index.jsp";
							System.out.println("Delete function");
						}
						break;
					case"Locations":
						String RoomName=request.getParameter("RoomName");
						LibraryRoomDAO lrd=new LibraryRoomDAO();
						lrd.deleteRoom(RoomName);
						CategoryDAO cd=new CategoryDAO();
						cd.deleteCategory(RoomName);
						URL="SearchResult?operationName=Locations";
						break;
					case"BorrowRules":
						int ID=Integer.parseInt(request.getParameter("ID"));
						BorrowRulesDAO brd=new BorrowRulesDAO();
						brd.deleteRules(ID);
						URL="SearchResult?operationName=BorrowRules";
						break;
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
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
