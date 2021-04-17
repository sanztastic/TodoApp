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
		<h1>TODO Application</h1>
		<ul class="navigation">
			<li><a href="all">All</a></li>
			<li><a href="pending">Pending</a></li>
			<li><a href="completed">done</a></li>
		</ul>
		<h2>List of ToDo's</h2>
		<ul class="list-todo">
			<li>TO DO Whatever</li>
		</ul>
	</div>
</body>
</html>