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

public class NutritionalSourceServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NutritionalSourceServletDelete() {
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
		NutritionalSourceDao entity1Dao = new NutritionalSourceDao();
		NutritionalSource entity1 = null;
		Integer ProgramID = Integer.parseInt(request.getParameter("program_ID"));
		
		if(method.equals("search"))
		{
			try {
				
				entity1 = entity1Dao.findByID(ProgramID);
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
						request.getRequestDispatcher("/jsps/nutritionalsource/nutritionalsource_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "nutritionalsource not found");
				request.getRequestDispatcher("/jsps/nutritionalsource/nutritionalsource_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.println(request.getParameter("program_ID"));
				entity1Dao.delete(request.getParameter("program_ID"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "nutritionalsource Deleted");
			request.getRequestDispatcher("/jsps/nutritionalsource/nutritionalsource_read_output.jsp").forward(request, response);
		}
	}
}



