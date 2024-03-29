package Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RecommendingReadingDAO;

/**
 * Servlet implementation class DeleteRecommend
 */
@WebServlet("/DeleteRecommend")
public class DeleteRecommend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRecommend() {
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
			String BookID=request.getParameter("BookID");
			String Reason=request.getParameter("Reason");
			RecommendingReadingDAO rrd=new RecommendingReadingDAO();
			rrd.deleteRecommendBook(BookID, Reason);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		response.sendRedirect("SearchResult?operationName=RecommendedReading");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
