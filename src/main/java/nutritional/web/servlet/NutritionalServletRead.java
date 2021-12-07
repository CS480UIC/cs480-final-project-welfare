package nutritional.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nutritional.dao.NutritionalDao;
import nutritional.domain.Nutritional;


/**
 * Servlet implementation class UserServlet
 */

public class NutritionalServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NutritionalServletRead() {
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
		Nutritional entity1 = null;
		NutritionalDao nutritionalDao = new NutritionalDao();
		
		try {
			entity1 = nutritionalDao.findByProgram_ID(Integer.parseInt(request.getParameter("program_ID")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(entity1.getProgram_ID()!=null){
					System.out.println(entity1);
					request.setAttribute("nutritional", entity1);
					request.getRequestDispatcher("/jsps/nutritionalprogram/nutritional_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "nutritional not found");
			request.getRequestDispatcher("/jsps/nutritionalprogram/nutritional_read_output.jsp").forward(request, response);
		}
	}
}



