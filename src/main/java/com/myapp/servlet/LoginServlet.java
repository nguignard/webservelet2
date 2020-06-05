package com.myapp.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myapp.dao.LoginDao;
import com.myapp.model.Login;

/**
 * Servlet implementation class HelloServlet
 */

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private LoginDao loginDao = new LoginDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
	  
	    if ("add".equals(action)) {
		request.getRequestDispatcher("WEB-INF/pages/login/addLogin.jsp").forward(request, response);

	    } else if ("login".equals(action)) {
//		String login = request.getParameter("id");
//		Login password = loginDao.findbyId("password");
//		request.setAttribute("user", login);
		request.getRequestDispatcher("WEB-INF/pages/showUser.jsp").forward(request, response);
		
		
		// SeesionScope.logged
		
		
		Collection<Login> users = loginDao.findAllList();
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/pages/showList.jsp").forward(request, response);

	    } else if ("remove".equals(action)) {
		request.getRequestDispatcher("WEB-INF/pages/addUser.jsp").forward(request, response);
	    } else if ("list".equals(action)) {
		request.getRequestDispatcher("WEB-INF/pages/addUser.jsp").forward(request, response);
	    }
	    else if ("logout".equals(action)) {
		request.getRequestDispatcher("WEB-INF/pages/addUser.jsp").forward(request, response);
	    }
	    
	    else if ("createSession".equals(action)) {
		HttpSession session = request.getSession();
		session.setAttribute("user", "moi");

		request.getRequestDispatcher("WEB-INF/pages/addUser.jsp").forward(request, response);
	    }
	    else if ("resetSession".equals(action)) {
		HttpSession session = request.getSession();
		session.invalidate();

		String path = getServletContext().getContextPath();
		request.getRequestDispatcher("WEB-INF/pages/addUser.jsp").forward(request, response);
	    }

	    else {
		request.getRequestDispatcher("WEB-INF/pages/showError.jsp").forward(request, response);
	    }
	}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    loginDao.addLogin(new Login(login, password));

    request.getRequestDispatcher("/WEB-INF/pages/showList.jsp").forward(request, response);
}

}
