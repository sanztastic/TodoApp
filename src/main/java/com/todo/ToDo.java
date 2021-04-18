package com.todo;

public class ToDo {
	private int id;
	private String todoData;
	private boolean finished;
	
	public ToDo(String todoData, boolean finished) {
		this.todoData = todoData;
		this.finished = finished;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTodoData() {
		return todoData;
	}

	public void setTodoData(String todoData) {
		this.todoData = todoData;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	
	
}
