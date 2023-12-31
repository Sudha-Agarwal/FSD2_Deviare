package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {	
	UserDao userDAO;
	
	public void init() {
		userDAO = new UserDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
		switch(action) {
		case "/new":
			showNewForm(request,response);		
			break;
		case "/insert":
			insertUser(request,response);
			break;
		case "/delete":
			deleteUser(request,response);
			break;
		case "/edit":
			showEditForm(request,response);
			break;
		case "/update":
			updateUser(request, response);
			break;
		default:
			listUser(request, response);
			break;			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		User newUser = new User();
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setCountry(country);
		
		userDAO.insertUser(newUser);		
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println("ID:" + request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		
		System.out.println("ID:" + existingUser.getId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);		
		dispatcher.forward(request, response);	
		
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");		
		User newUser = new User();
		newUser.setId(id);
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setCountry(country);
		
		userDAO.updatetUser(newUser);		
		response.sendRedirect("list");
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");
	}
		
		
		
	
	

}
