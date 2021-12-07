package medicalfacility.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medicalfacility.dao.MedicalFacilityDao;
import medicalfacility.domain.MedicalFacility;

/**
 * Servlet implementation class UserServlet
 */

public class MedicalFacilityServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MedicalFacilityServletUpdate() {
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
		MedicalFacilityDao medicalfacilitydao = new MedicalFacilityDao();
		MedicalFacility medicalfacility = null;

		if(method.equals("search"))
		{
			try {
				medicalfacility = medicalfacilitydao.findByProgramID(Integer.parseInt(request.getParameter("program_ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(medicalfacility.getProgram_ID()!=null){
				request.setAttribute("medicalfacility", medicalfacility);
				request.getRequestDispatcher("/jsps/medicalfacility/medicalfacility_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Medical Facility entity not found");
				request.getRequestDispatcher("/jsps/medicalfacility/medicalfacility_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			MedicalFacility form = new MedicalFacility();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setProgram_ID(Integer.parseInt(info.get(1)));
			form.setMedicalfacility_ID(Integer.parseInt(info.get(2)));
			form.setFacility(info.get(3));

			try {
				medicalfacilitydao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Medical Facility Entity Updated");
			request.getRequestDispatcher("/jsps/medicalfacility/medicalfacility_read_output.jsp").forward(request, response);
		}
	}
}



