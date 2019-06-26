package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BookBorrowedLog;
import DAO.BookDAO;
import DAO.BorrowerDAO;

/**
 * Servlet implementation class BorrowBook
 */
@WebServlet("/BorrowBook")
public class BorrowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			//response.setContentType("text/html");
			HttpSession session=request.getSession();
			String BookID=request.getParameter("BookID");
			String BorrowerAccount=(String)session.getAttribute("UserName");
			String Method=request.getParameter("Method");
			int k=0;
			switch(Method){
			case"Borrow":
		        Calendar c = Calendar.getInstance();
				Date BorrowDate=new Date(c.getTimeInMillis());
				c.add(Calendar.DATE, 90);
				Date ReturnDateDeadLine=new Date(c.getTimeInMillis());
				BookBorrowedLog bbl;
				bbl = new BookBorrowedLog();
				bbl.insertLog(BookID, BorrowerAccount, BorrowDate, ReturnDateDeadLine);
				BookDAO bd=new BookDAO();
				k=bd.updateBookAmountByBookIDWhenBorrowed(BookID,"sub");
				if(k==0){
					out.print("<script> alert(\"Borrow Failed!\"); </script>");
					System.out.println(k);
				}else{
					out.print("<script> alert(\"Borrow Successfully!\"); </script>");
					System.out.println(k);
				}
				break;
			
			case"Renewal":
				int LogID=Integer.parseInt(request.getParameter("LogID"));
				BookBorrowedLog bbll=new BookBorrowedLog();
				k=bbll.renewalBook(LogID);
				if(k==0){
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Renewal Failed!');");
					out.println("</script>");
				}else{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Renewal Successfully!');");
					out.println("</script>");
					
				}
				break;
				
			case"Return":
				int LogID1=Integer.parseInt(request.getParameter("LogID"));
				BookBorrowedLog bblll=new BookBorrowedLog();
				bblll.updateLogWhenReturnBook(LogID1);
				BookDAO bdd=new BookDAO();
				k=bdd.updateBookAmountByBookIDWhenBorrowed(BookID, "add");
				if(k==0){
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Return Failed!');");
					out.println("</script>");
				}else{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Return Successfully!');");
					out.println("</script>");
					
				}
				
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
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
