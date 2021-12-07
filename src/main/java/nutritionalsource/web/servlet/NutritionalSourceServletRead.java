package nutritionalsource.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nutritionalsource.dao.NutritionalSourceDao;
import nutritionalsource.domain.NutritionalSource;


/**
 * Servlet implementation class UserServlet
 */

public class NutritionalSourceServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NutritionalSourceServletRead() {
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
		NutritionalSource entity1 = null;
		NutritionalSourceDao entity1Dao = new NutritionalSourceDao();
		
		try {
			entity1 = entity1Dao.findByID(Integer.parseInt(request.getParameter("program_ID")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(entity1.getProgram_ID()!=null){
					System.out.println(entity1);
					request.setAttribute("nutritionalsource", entity1);
					request.getRequestDispatcher("/jsps/nutritionalsource/nutritionalsource_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "NutritionalSource not found");
			request.getRequestDispatcher("/jsps/nutritionalsource/nutritionalsource_read_output.jsp").forward(request, response);
		}
	}
}



