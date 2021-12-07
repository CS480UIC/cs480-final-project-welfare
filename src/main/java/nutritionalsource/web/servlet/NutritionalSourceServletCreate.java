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

import nutritionalsource.domain.NutritionalSource;
import nutritionalsource.service.NutritionalSourceException;
import nutritionalsource.service.NutritionalSourceService;


/**
 * Servlet implementation class UserServlet
 */

public class NutritionalSourceServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NutritionalSourceServletCreate() {
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
		NutritionalSourceService entity1service = new NutritionalSourceService();
		Map<String,String[]> paramMap = request.getParameterMap();
		NutritionalSource form = new NutritionalSource();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setProgram_ID(Integer.parseInt(info.get(0)));
		form.setNutritionalsource_ID(Integer.parseInt(info.get(1)));
		form.setSource(info.get(2));
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | NutritionalSourceException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
