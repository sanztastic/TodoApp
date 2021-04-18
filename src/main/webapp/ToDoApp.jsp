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
  			<form action="/add" method="post">
  				<input type="text" id="myInput" placeholder="Title...">
  				<input type="submit" class="addBtn" value="Submit">
  			</form>
		</div>

		<ul id="myUL">
			<c:forEach items="${ todo_list }" var="item">
				<li>${ item }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>