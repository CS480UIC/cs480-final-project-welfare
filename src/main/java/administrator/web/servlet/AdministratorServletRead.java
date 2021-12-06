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

public class AdministratorServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorServletRead() {
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
		Administrator entity1 = null;
		AdministratorDao entity1Dao = new AdministratorDao();
		
		try {
			entity1 = entity1Dao.findByID(Integer.parseInt(request.getParameter("ID")));
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
					request.getRequestDispatcher("/jsps/administrator/administrator_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Administrator not found");
			request.getRequestDispatcher("/jsps/administrator/administrator_read_output.jsp").forward(request, response);
		}
	}
}



