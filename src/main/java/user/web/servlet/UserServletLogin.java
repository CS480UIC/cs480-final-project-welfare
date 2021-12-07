package user.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.User;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

public class UserServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletLogin() {
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
		UserDao userdao = new UserDao();
		User user = null;
		String pwd=null;
		try {
			user = userdao.findByUsername(request.getParameter("username"));
			pwd = request.getParameter("password");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		UserService userservice = new UserService();		
		if(user.getUsername()!=null){
			// PASSWORD VALIDATION
			if(pwd.equals(user.getPassword()))
			{
				try {
					userservice.login(user);
					request.getSession().setAttribute("session_user", user);
					request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
				} catch (ClassNotFoundException | UserException e) {
					request.setAttribute("msg", e.getMessage());
				} catch (InstantiationException e) {
					request.setAttribute("msg", e.getMessage());
				} catch (IllegalAccessException e) {
					request.setAttribute("msg", e.getMessage());
				} 
			}
			else{
				request.setAttribute("msg", "invalid password");
				request.getRequestDispatcher("/jsps/user/login.jsp").forward(request, response);
			}
				
		}

			else{
			request.setAttribute("msg", "You need to register first");
			request.getRequestDispatcher("/jsps/user/login.jsp").forward(request, response);
		}
		
		
		
	}

}
