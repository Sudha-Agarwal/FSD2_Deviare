package DAO;

import java.sql.*;

import Classes.Employee;

public class EmployeeDAO {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//registering DB driver
			con = DriverManager.getConnection("jdbc:mysql://localhost/simplilearn2","root","root");
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return con;
	}
	
	public static void insertEmployee() {
		String query = "INSERT INTO employee (id,first_name) values(3,'ABC')";
		
		Connection con = EmployeeDAO.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			stmt.execute(query);
			con.close();
			//System.out.println("Is record inserted " + res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	
	public static int registerEmployee(Employee emp) {
		String query = "INSERT INTO EMPLOYEE (first_name,last_name,username,password,address,contact) values(?,?,?,?,?,?)";
		int result = 0;
		Connection con = EmployeeDAO.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, emp.firstName);
			stmt.setString(2, emp.lastName);
			stmt.setString(3, emp.userName);
			stmt.setString(4, emp.password);
			stmt.setString(5, emp.address);
			stmt.setString(6, emp.contact);
			
			result = stmt.executeUpdate();
			con.close();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;	
		
	}
	
	public static void main(String[] args) {
		insertEmployee();
	}

}
