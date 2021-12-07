package nutritional.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nutritional.dao.NutritionalDao;
import nutritional.domain.Nutritional;

/**
 * Servlet implementation class UserServlet
 */

public class NutritionalServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NutritionalServletUpdate() {
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
		NutritionalDao entity1dao = new NutritionalDao();
		Nutritional entity1 = null;

		if(method.equals("search"))
		{
			try {
				entity1 = entity1dao.findByProgram_ID(Integer.parseInt(request.getParameter("program_ID")));
				System.out.print(Integer.parseInt(request.getParameter("program_ID")));
				} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(entity1.getProgram_ID()!=null){
				request.setAttribute("nutritional", entity1);
				request.getRequestDispatcher("/jsps/nutritionalprogram/nutritional_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Program not found");
				request.getRequestDispatcher("/jsps/nutritionalprogram/nutritional_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Nutritional form = new Nutritional();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setProgram_name(request.getParameter("program_name"));
			form.setProgram_ID(Integer.parseInt(request.getParameter("programID")));
			form.setAdministrator_ID(Integer.parseInt(request.getParameter("administrator_ID")));
			form.setFunds(Integer.parseInt(request.getParameter("funds")));

			try {
				entity1dao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Nutritional Updated");
			request.getRequestDispatcher("/jsps/nutritionalprogram/nutritional_read_output.jsp").forward(request, response);
		}
	}
}



