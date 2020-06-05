package com.myapp.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myapp.dao.UserDao;
import com.myapp.model.User;

/**
 * Servlet implementation class HelloServlet
 */

@WebServlet(value = "/userdetail")
public class UserServlet extends HttpServlet {

    private UserDao userDao = new UserDao();
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	    String action = request.getParameter("action");
	    if ("detail".equals(action)) {
		String id = request.getParameter("id");
		User user = userDao.findUser(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("WEB-INF/pages/showUser.jsp").forward(request, response);

	    } else if ("list".equals(action)) {
		Collection<User> users = userDao.findAllList();
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/pages/showList.jsp").forward(request, response);

	    } else if ("add".equals(action)) {
		request.getRequestDispatcher("WEB-INF/pages/addUser.jsp").forward(request, response);
	    } else if ("createSession".equals(action)) {
		HttpSession session = request.getSession();
		session.setAttribute("user", "moi");

		request.getRequestDispatcher("WEB-INF/pages/addUser.jsp").forward(request, response);
	    }
	    else if ("resetSession".equals(action)) {
		HttpSession session = request.getSession();
		session.invalidate();

		request.getRequestDispatcher("WEB-INF/pages/addUser.jsp").forward(request, response);
	    }

	    else {
		String path = getServletContext().getContextPath();
		request.getRequestDispatcher("WEB-INF/pages/showError.jsp").forward(request, response);
	    }
	}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String firstname = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    String salary = request.getParameter("salary");
    userDao.addUser(new User(firstname, lastname, Integer.parseInt(salary)));

    request.getRequestDispatcher("/WEB-INF/pages/showList.jsp").forward(request, response);
}

}
