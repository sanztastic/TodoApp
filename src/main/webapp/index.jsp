<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO Application</title>
<link rel="stylesheet" type="text/css" href="/ToDoApp/css/style.css">
</head>
<body>
	<div class="container">
		<div id="myDIV" class="header">
  			<h2>My To Do List</h2>
  			<input type="text" id="myInput" placeholder="Title...">
  			<span onclick="newElement()" class="addBtn">Add</span>
		</div>

		<ul id="myUL">
  			<li>Hit the gym</li>
  			<li class="checked">Pay bills</li>
  			<li>Meet George</li>
  			<li>Buy eggs</li>
  			<li>Read a book</li>
  			<li>Organize office</li>
		</ul>
	</div>
</body>
</html>