package eligibility.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eligibility.dao.EligibilityDao;
import eligibility.domain.Eligibility;

/**
 * Servlet implementation class UserServlet
 */

public class EligibilityServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EligibilityServletUpdate() {
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
		EligibilityDao eligibilitydao = new EligibilityDao();
		Eligibility eligibility = null;

		if(method.equals("search"))
		{
			System.out.println(Integer.parseInt(request.getParameter("recipient_ID")));
			try {
				eligibility = eligibilitydao.findByRecipientID(Integer.parseInt(request.getParameter("recipient_ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(eligibility.getRecipient_ID()!=null){
				request.setAttribute("eligibility", eligibility);
				request.getRequestDispatcher("/jsps/eligibility/eligibility_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Eligibility not found");
				request.getRequestDispatcher("/jsps/eligibility/eligibility_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Eligibility form = new Eligibility();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setRecipient_ID(Integer.parseInt(request.getParameter("recipientID")));
			form.setCitizenship(request.getParameter("citizenship"));
			form.setResidency(request.getParameter("residency"));
			form.setFamily(Integer.parseInt(request.getParameter("family")));

			try {
				eligibilitydao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Eligibility Updated");
			request.getRequestDispatcher("/jsps/eligibility/eligibility_read_output.jsp").forward(request, response);
		}
	}
}



