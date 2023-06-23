package com.java.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.java.DAO.TeacherDAO;
import com.java.persistence.Teacher;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
TeacherDAO teacherDAO = null;

	public TeacherServlet() {
		super();        
	}
	public void init() {
		teacherDAO = new TeacherDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		System.out.println(action);
		
		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertTeacher(request, response);
				break;
			case "delete":
				deleteTeacher(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateTeacher(request, response);
				break;
			default:
				listTeacher(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void listTeacher(HttpServletRequest request, HttpServletResponse response) {
		List<Teacher> listTeacher = teacherDAO.getTeacher();
		request.setAttribute("listTeacher", listTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-list.jsp");
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String name = request.getParameter("name");
		Teacher newTeacher = new Teacher();
		newTeacher.setTeacherName(name);
		
		
		teacherDAO.addTeacher(newTeacher);		
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println("ID:" + request.getParameter("id"));
		Teacher existingTeacher = teacherDAO.getTeacher(id);
		
		System.out.println("ID:" + existingTeacher.getTeacherId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
		request.setAttribute("Teacher", existingTeacher);		
		dispatcher.forward(request, response);	
		
	}
	
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
				
		Teacher newTeacher = new Teacher();
		newTeacher.setTeacherId(id);
		newTeacher.setTeacherName(name);
		
		
		//teacherDAO.(newTeacher);		
		response.sendRedirect("list");
	}
	
	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		teacherDAO.deleteTeacher(id);
		response.sendRedirect("list");
	}
		

}
