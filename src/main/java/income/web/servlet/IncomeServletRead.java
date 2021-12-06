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

public class IncomeServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeServletRead() {
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
		Income income = null;
		IncomeDao incomeDao = new IncomeDao();
		
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
					request.setAttribute("income", income);
					request.getRequestDispatcher("/jsps/income/income_read_output.jsp").forward(request, response);
			}
			else{
				System.out.println("hello");
			request.setAttribute("msg", "Income not found");
			request.getRequestDispatcher("/jsps/income/income_read_output.jsp").forward(request, response);
		}
	}
}



