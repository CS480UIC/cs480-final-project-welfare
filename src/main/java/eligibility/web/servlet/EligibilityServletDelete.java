package eligibility.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eligibility.dao.EligibilityDao;
import eligibility.domain.Eligibility;


/**
 * Servlet implementation class UserServlet
 */

public class EligibilityServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EligibilityServletDelete() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		EligibilityDao eligibilityDao = new EligibilityDao();
		Eligibility eligibility = null;
		if(method.equals("search"))
		{
			try {
				eligibility = eligibilityDao.findByRecipientID(Integer.parseInt(request.getParameter("recipient_ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(eligibility.getRecipient_ID()!=null){
						System.out.println(eligibility);
						request.setAttribute("eligibility", eligibility);
						request.getRequestDispatcher("/jsps/eligibility/eligibility_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Eligibility not found");
				request.getRequestDispatcher("/jsps/eligibility/eligibility_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				eligibilityDao.delete(Integer.parseInt(request.getParameter("recipient_ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Eligibility Deleted");
			request.getRequestDispatcher("/jsps/eligibility/eligibility_read_output.jsp").forward(request, response);
		}
	}
}



