package income.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import income.dao.IncomeDao;
import income.domain.Income;

/**
 * Servlet implementation class UserServlet
 */

public class IncomeServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IncomeServletUpdate() {
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
		IncomeDao incomedao = new IncomeDao();
		Income income = null;

		if(method.equals("search"))
		{
			try {
				income = incomedao.findByRecipientID(Integer.parseInt(request.getParameter("ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(income.getRecipient_ID()!=null){
				request.setAttribute("income", income);
				request.getRequestDispatcher("/jsps/income/income_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Income not found");
				request.getRequestDispatcher("/jsps/income/income_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Income form = new Income();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
//			form.setPassword(info.get(2));
//			form.setEmail(info.get(3));
//			form.setUsername(request.getParameter("username"));

			//TODO fix
			form.setRecipient_ID(Integer.parseInt(request.getParameter("recipientID")));
			form.setTotal_gross(Integer.parseInt(request.getParameter("grossIncome")));
			form.setTotal_net(Integer.parseInt(request.getParameter("netIncome")));	
			form.setInvestments(Integer.parseInt(request.getParameter("investments")));	
			
			try {
				incomedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Income Updated");
			request.getRequestDispatcher("/jsps/income/income_read_output.jsp").forward(request, response);
		}
	}
}



