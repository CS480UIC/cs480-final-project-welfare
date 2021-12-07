package nutritionalsource.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nutritionalsource.dao.NutritionalSourceDao;
import nutritionalsource.domain.NutritionalSource;

/**
 * Servlet implementation class UserServlet
 */

public class NutritionalSourceServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NutritionalSourceServletUpdate() {
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
		NutritionalSourceDao entity1dao = new NutritionalSourceDao();
		NutritionalSource entity1 = null;

		if(method.equals("search"))
		{
			try {
				entity1 = entity1dao.findByID(Integer.parseInt(request.getParameter("program_ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(entity1.getProgram_ID()!=null){
				request.setAttribute("nutritionalsource", entity1);
				request.getRequestDispatcher("/jsps/nutritionalsource/nutritionalsource_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "NutritionalSource not found");
				request.getRequestDispatcher("/jsps/nutritionalsource/nutritionalsource_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			NutritionalSource form = new NutritionalSource();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setProgram_ID(Integer.parseInt(request.getParameter("program_ID")));
			form.setNutritionalsource_ID(Integer.parseInt(request.getParameter("nutritionalsource_ID")));
			form.setSource((request.getParameter("source")));

			try {
				entity1dao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "NutritionalSource Updated");
			request.getRequestDispatcher("/jsps/nutritionalsource/nutritionalsource_read_output.jsp").forward(request, response);
		}
	}
}



