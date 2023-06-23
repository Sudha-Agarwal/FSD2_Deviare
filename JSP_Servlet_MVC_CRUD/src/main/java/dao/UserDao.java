package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/simplilearn2?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public List<User> selectAllUsers(){

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from users");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new User(id, name, email, country));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;



	}

	public void insertUser(User user) throws SQLException {
		String INSERT_USER_QUERY = "INSERT INTO users (name,email,country) values(?,?,?);";

		try(Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(INSERT_USER_QUERY)){
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getCountry());
			System.out.println(stmt);
			stmt.executeUpdate();		
		}
		catch(SQLException e) {
			e.printStackTrace();

		}		
	}
	
	public User selectUser(int id) {
		User user = null;
		String SELECT_USER_QUERY = "select id,name,email,country from users where id = ?;";
		
		try(Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(SELECT_USER_QUERY)){
			stmt.setInt(1, id);			
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery()	;
			
			while(rs.next()) {
				
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				
				user = new User();
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setCountry(country);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();

		}		
		
		return user;
	}
	
	public boolean updatetUser(User user) {
		boolean rowUpdated = false;
		String UPDATE_USER_QUERY = "update users set name = ?,email = ?,country =? where id = ?;";
		
		try(Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(UPDATE_USER_QUERY)){
			stmt.setString(1, user.getName());	
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getCountry());
			stmt.setInt(4, user.getId());
			
			System.out.println(stmt);
			rowUpdated = stmt.executeUpdate() > 0;			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		
		return rowUpdated;
	}
	
	public boolean deleteUser(int id) {
		boolean rowUpdated = false;
		String DELETE_USER_QUERY = "delete from users where id = ?;";
		
		try(Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(DELETE_USER_QUERY)){
			stmt.setInt(1, id);			
			
			System.out.println(stmt);
			rowUpdated = stmt.executeUpdate() > 0;			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		
		return rowUpdated;
		
	}




}
