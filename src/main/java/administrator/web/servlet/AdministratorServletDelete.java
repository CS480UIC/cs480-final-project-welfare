package administrator.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administrator.dao.AdministratorDao;
import administrator.domain.Administrator;


/**
 * Servlet implementation class UserServlet
 */

public class AdministratorServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorServletDelete() {
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
		AdministratorDao entity1Dao = new AdministratorDao();
		Administrator entity1 = null;
		Integer adminID = Integer.parseInt(request.getParameter("ID"));
		
		if(method.equals("search"))
		{
			try {
				
				entity1 = entity1Dao.findByID(adminID);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(entity1.getID()!=null){
						System.out.println(entity1);
						request.setAttribute("administrator", entity1);
						request.getRequestDispatcher("/jsps/administrator/administrator_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Administrator not found");
				request.getRequestDispatcher("/jsps/administrator/administrator_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				entity1Dao.delete(request.getParameter("ID"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Administrator Deleted");
			request.getRequestDispatcher("/jsps/administrator/administrator_read_output.jsp").forward(request, response);
		}
	}
}



