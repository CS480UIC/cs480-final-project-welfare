package income.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import income.dao.IncomeDao;
import income.domain.Income;


/**
 * Servlet implementation class UserServlet
 */

public class IncomeServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeServletDelete() {
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
		IncomeDao incomeDao = new IncomeDao();
		Income income = null;
		if(method.equals("search"))
		{
			try {
				income = incomeDao.findByRecipientID(Integer.parseInt(request.getParameter("ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(income.getRecipient_ID()!=null){
						System.out.println(income);
						request.setAttribute("income", income);
						request.getRequestDispatcher("/jsps/income/income_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "income not found");
				request.getRequestDispatcher("/jsps/income/income_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				incomeDao.delete(request.getParameter("recipient_ID"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Income Deleted");
			request.getRequestDispatcher("/jsps/income/income_read_output.jsp").forward(request, response);
		}
	}
}



