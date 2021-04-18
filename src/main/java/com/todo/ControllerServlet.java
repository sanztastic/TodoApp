package com.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/todo/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoDAO todoDAO;

    /**
     * Default constructor. 
     */
    public ControllerServlet() {
    	todoDAO = new TodoDAO();
    	todoDAO.connect();
    	todoDAO.disconnect();
    	
//    	todoList.add("Get the groceries");
//    	todoList.add("Make a todo app using JavaEE servlet and jsp");
//    	todoList.add("Start learning more advance JavaEE");
//    	todoList.add("Start working on Spring");
//    	todoList.add("Time for Spring boot babyy");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		if(action.equals("/check")) {
			String id = request.getParameter("id");
			todoDAO.updateTodos(Integer.parseInt(id),"check");
			response.sendRedirect("*");
		}
		else if(action.equals("/delete")) {
			String id = request.getParameter("id");
			todoDAO.updateTodos(Integer.parseInt(id),"delete");
			response.sendRedirect("*");
		}
		else {			
			ArrayList<ToDo> todoList = todoDAO.listAllTodos();
			request.setAttribute("todo_list", todoList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ToDoApp.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		String value = request.getParameter("todoValue");
		ToDo todoData = new ToDo(value, false);
		todoDAO.insertTodos(todoData);
		response.sendRedirect("*");
	}

}
