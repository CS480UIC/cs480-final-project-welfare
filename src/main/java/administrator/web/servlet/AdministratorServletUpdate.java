package administrator.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administrator.dao.AdministratorDao;
import administrator.domain.Administrator;

/**
 * Servlet implementation class UserServlet
 */

public class AdministratorServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdministratorServletUpdate() {
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
		AdministratorDao entity1dao = new AdministratorDao();
		Administrator entity1 = null;

		if(method.equals("search"))
		{
			try {
				entity1 = entity1dao.findByID(Integer.parseInt(request.getParameter("ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(entity1.getID()!=null){
				request.setAttribute("administrator", entity1);
				request.getRequestDispatcher("/jsps/administrator/administrator_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Administrator not found");
				request.getRequestDispatcher("/jsps/administrator/administrator_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Administrator form = new Administrator();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setFirst_name(request.getParameter("first_name"));
			form.setLast_name(request.getParameter("last_name"));
			form.setTitle(request.getParameter("title"));
			form.setID(Integer.parseInt(request.getParameter("ID")));

			try {
				entity1dao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Administrator Updated");
			request.getRequestDispatcher("/jsps/administrator/administrator_read_output.jsp").forward(request, response);
		}
	}
}



