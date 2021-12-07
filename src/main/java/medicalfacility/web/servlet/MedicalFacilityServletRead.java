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

public class MedicalFacilityServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicalFacilityServletRead() {
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
		MedicalFacility medicalfacility = null;
		MedicalFacilityDao entity1Dao = new MedicalFacilityDao();
		
		try {
			medicalfacility = entity1Dao.findByProgramID(Integer.parseInt(request.getParameter("program_ID")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(medicalfacility.getProgram_ID()!=null){
					System.out.println(medicalfacility);
					request.setAttribute("medical", medicalfacility);
					request.getRequestDispatcher("/jsps/medicalfacility/medicalfacility_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Medical Facility entity not found");
			request.getRequestDispatcher("/jsps/medicalfacility/medicalfacility_read_output.jsp").forward(request, response);
		}
	}
}



