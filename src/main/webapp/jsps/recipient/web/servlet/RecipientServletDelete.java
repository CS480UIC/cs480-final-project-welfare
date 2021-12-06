package recipient.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipient.dao.RecipientDao;
import recipient.domain.Recipient;


/**
 * Servlet implementation class UserServlet
 */

public class RecipientServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipientServletDelete() {
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
		RecipientDao entity1Dao = new RecipientDao();
		Recipient entity1 = null;
		Integer userID = Integer.parseInt(request.getParameter("ID"));
		
		if(method.equals("search"))
		{
			try {
				
				entity1 = entity1Dao.findByID(userID);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(entity1.getID()!=null){
				System.out.println("HMMM");
						System.out.println(entity1);
						request.setAttribute("recipient", entity1);
						request.getRequestDispatcher("/jsps/recipient/recipient_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Recipient not found");
				request.getRequestDispatcher("/jsps/recipient/recipient_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.println("TESTING RECIP SERVLET");
				System.out.println(request.getParameter("ID"));
				entity1Dao.delete(request.getParameter("ID"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Recipient Deleted");
			request.getRequestDispatcher("/jsps/recipient/recipient_read_output.jsp").forward(request, response);
		}
	}
}



