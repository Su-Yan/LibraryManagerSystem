package filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AllPagesFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, 
		urlPatterns = { 
				"/AllPagesFilter", 
				"/addlibraryroom.jsp", 
				"/addrules.jsp", 
				"/admincenter.jsp", 
				"/borrowlist.jsp", 
				"/borrowlist1.jsp", 
				"/changepersonalinformation.jsp", 
				"/createadmin.jsp", 
				"/donate.jsp", 
				"/donatemanager.jsp", 
				"/editbook.jsp", 
				"/editborrowrules.jsp", 
				"/editlibraryroom.jsp", 
				"/libraryroommanager.jsp", 
				"/personalcenter.jsp", 
				"/RecommendReason.jsp"
		}, 
		servletNames = { 
				"AddLibraryRoom", 
				"AddRecommend", 
				"AddRules", 
				"AdminConfirmDonate", 
				"BorrowBook", 
				"BorrowHistory", 
				"ChangeLibraryInfo", 
				"ChangePersonalInformation", 
				"CompleteChangePersonalInfo", 
				"DeleteRecommend", 
				"DonateConfirm", 
				"DonateManager", 
				"EditConfirm", 
				"EditOrDelete", 
				"EditRoomConfirm", 
				"EditRulesConfirm", 
				"GetAllFinedNotReturnAccount", 
				"GetBorrowList", 
				"Logout"
		})
public class AllPagesFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AllPagesFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		HttpSession session=req.getSession();
		String Identity=(String) session.getAttribute("Identity");
		System.out.println("AllPagesFilter");
		if(Identity==null||Identity==""){
			res.sendRedirect("Login.jsp");
		}else{
			chain.doFilter(request, response);
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
