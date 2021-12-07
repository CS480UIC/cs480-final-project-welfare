package medicalfacility.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medicalfacility.dao.MedicalFacilityDao;
import medicalfacility.domain.MedicalFacility;


/**
 * Servlet implementation class UserServlet
 */

public class MedicalFacilityServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicalFacilityServletDelete() {
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
		MedicalFacilityDao medicalfacilityDao = new MedicalFacilityDao();
		MedicalFacility medicalfacility = null;
		if(method.equals("search"))
		{
			try {
				medicalfacility = medicalfacilityDao.findByProgramID(Integer.parseInt(request.getParameter("program_ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(medicalfacility.getProgram_ID()!=null){
						System.out.println(medicalfacility);
						request.setAttribute("medicalfacility", medicalfacility);
						request.getRequestDispatcher("/jsps/medicalfacility/medicalfacility_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Medical facility not found");
				request.getRequestDispatcher("/jsps/medicalfacility/medicalfacility_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				medicalfacilityDao.delete(Integer.parseInt(request.getParameter("recipient_ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Medical Facility Deleted");
			request.getRequestDispatcher("/jsps/medicalfacility/medicalfacility_read_output.jsp").forward(request, response);
		}
	}
}



