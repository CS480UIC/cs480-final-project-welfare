package income.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import income.service.IncomeService;

/**
 * Servlet implementation class findAll
 */

public class RecipientIncomes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IncomeService incomeservice = new IncomeService();
		try {
			request.setAttribute("IncomeList", incomeservice.findRecipientIncome());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			List<Object> li = incomeservice.findRecipientIncome();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/user/q3_recipient_income_search.jsp").forward(request, response);
	}

}
