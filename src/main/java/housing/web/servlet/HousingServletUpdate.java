package housing.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import housing.dao.HousingDao;
import housing.domain.Housing;

/**
 * Servlet implementation class UserServlet
 */

public class HousingServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HousingServletUpdate() {
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
		HousingDao housingdao = new HousingDao();
		Housing housing = null;

		if(method.equals("search"))
		{
			try {
				housing = housingdao.findByProgramID(Integer.parseInt(request.getParameter("program_ID")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(housing.getProgram_ID()!=null){
				request.setAttribute("housing", housing);
				request.getRequestDispatcher("/jsps/housingprogram/housing_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Housing not found");
				request.getRequestDispatcher("/jsps/housingprogram/housing_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Housing form = new Housing();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}

			form.setProgram_name(request.getParameter("program_name"));
			form.setProgram_ID(Integer.parseInt(request.getParameter("programID")));
			form.setAdministrator_ID(Integer.parseInt(request.getParameter("administrator_ID")));
			form.setHousing_size(Integer.parseInt(request.getParameter("housing_size")));
			form.setFunds(Integer.parseInt(request.getParameter("funds")));
			
			try {
				housingdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Housing Updated");
			request.getRequestDispatcher("/jsps/housingprogram/housing_read_output.jsp").forward(request, response);
		}
	}
}



