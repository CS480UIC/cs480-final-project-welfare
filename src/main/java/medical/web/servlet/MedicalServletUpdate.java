package medical.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.dao.MedicalDao;
import medical.domain.Medical;

/**
 * Servlet implementation class UserServlet
 */

public class MedicalServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MedicalServletUpdate() {
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
		MedicalDao medicaldao = new MedicalDao();
		Medical medical = null;

		if(method.equals("search"))
		{
			try {
				medical = medicaldao.findByProgramID(Integer.parseInt(request.getParameter("program_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(medical.getProgram_ID()!=null){
				request.setAttribute("medical", medical);
				request.getRequestDispatcher("/jsps/medical/medical_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Medical not found");
				request.getRequestDispatcher("/jsps/medical/medical_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Medical form = new Medical();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setProgram_ID(Integer.parseInt(info.get(1)));
			form.setProgram_name(info.get(2));
			form.setAdministrator_ID(Integer.parseInt(info.get(3)));
			form.setFunds(Integer.parseInt(info.get(4)));

			try {
				medicaldao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Medical Updated");
			request.getRequestDispatcher("/jsps/medical/medical_read_output.jsp").forward(request, response);
		}
	}
}



