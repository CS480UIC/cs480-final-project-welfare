package nutritional.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nutritional.service.NutritionalService;

/**
 * Servlet implementation class findAll
 */

public class NutritionalFunds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NutritionalService nutritionalservice = new NutritionalService();
		try {
			request.setAttribute("NutritionalList", nutritionalservice.findNutritionalFund()); //TODO
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			List<Object> li = nutritionalservice.findNutritionalFund();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/user/q2_nutritional_funds.jsp").forward(request, response);
	}

}
