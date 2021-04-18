package com.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TodoDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/todo_app";
	private String jdbcUsername ="root";
	private String jdbcPassword ="password";
	private Connection jdbcConnection;
	
	public void connect() {
		try {
			if (jdbcConnection==null||jdbcConnection.isClosed()) {				
				Class.forName("com.mysql.cj.jdbc.Driver");
				jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			}
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection established");
	}
	
	public void disconnect() {
		try {
			if(jdbcConnection!=null&&!jdbcConnection.isClosed()) {
				jdbcConnection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ToDo> listAllTodos(){
		connect();
		ArrayList<ToDo> todoList = new ArrayList<ToDo>();
		
		try {
			Statement statement = jdbcConnection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM todo");
			while(result.next()) {
				ToDo todo = new ToDo(result.getString("item"),result.getBoolean("checked"));
				todo.setId(result.getInt("id"));
				todoList.add(todo);
			}
			
			result.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		disconnect();
		return todoList;
	}
	
	public boolean insertTodos(ToDo todoData) {
		connect();
		boolean result = false;
		
		try {
			String sql = "INSERT INTO todo(item, checked) VALUES(?,?)";
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, todoData.getTodoData());
			statement.setBoolean(2, todoData.isFinished());
			result = statement.executeUpdate()>0;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		return result;
		
	}
	
	public boolean updateTodos(int id,String operation) {
		connect();
		boolean result = false;
		String sql = "UPDATE todo SET checked = !checked WHERE id = ?";
		
		if(operation.equals("delete")) {
			sql = "DELETE FROM todo WHERE id = ?";
		}
		
		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeUpdate()>0;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		return result;
	}
}
