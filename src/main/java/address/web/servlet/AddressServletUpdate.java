package address.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import address.dao.AddressDao;
import address.domain.Address;

/**
 * Servlet implementation class UserServlet
 */

public class AddressServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddressServletUpdate() {
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
		AddressDao addressDao = new AddressDao();
		Address address = null;

		if(method.equals("search"))
		{
			try {
				address = addressDao.findByRecipientID(Integer.parseInt(request.getParameter("ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(address.getRecipient_ID()!=null){
				request.setAttribute("address", address);
				request.getRequestDispatcher("/jsps/address/address_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Address not found");
				request.getRequestDispatcher("/jsps/address/address_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Address form = new Address();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setRecipient_ID(Integer.parseInt(request.getParameter("recipientID")));
			form.setCity(request.getParameter("city"));
			form.setState(request.getParameter("state"));	
			form.setStreet(request.getParameter("street"));	

			try {
				addressDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Address Updated");
			request.getRequestDispatcher("/jsps/address/address_read_output.jsp").forward(request, response);
		}
	}
}



