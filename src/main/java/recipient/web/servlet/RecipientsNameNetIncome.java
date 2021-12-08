package recipient.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipient.service.RecipientService;

/**
 * Servlet implementation class findAll
 */

public class RecipientsNameNetIncome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecipientService recipientservice = new RecipientService();
		try {
			request.setAttribute("RecipientList", recipientservice.findRecipientNameNet());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			List<Object> li = recipientservice.findRecipientNameNet();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/user/q6_recipient_net_income.jsp").forward(request, response);
	}

}
