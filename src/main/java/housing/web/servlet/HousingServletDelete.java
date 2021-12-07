package housing.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import housing.dao.HousingDao;
import housing.domain.Housing;


/**
 * Servlet implementation class UserServlet
 */

public class HousingServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HousingServletDelete() {
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
		HousingDao housingDao = new HousingDao();
		Housing housing = null;
		if(method.equals("search"))
		{
			try {
				housing = housingDao.findByProgramID(Integer.parseInt(request.getParameter("program_ID"))  );
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(housing.getProgram_ID()!=null){
						//System.out.println(housing);
						request.setAttribute("housing", housing);
						request.getRequestDispatcher("/jsps/housingprogram/housing_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Housing not found");
				request.getRequestDispatcher("/jsps/housingprogram/housing_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				housingDao.delete(Integer.parseInt(request.getParameter("program_ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Housing Program Deleted");
			request.getRequestDispatcher("/jsps/housingprogram/housing_read_output.jsp").forward(request, response);
		}
	}
}



