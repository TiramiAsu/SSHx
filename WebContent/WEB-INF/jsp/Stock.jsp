<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Stock Management</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding: 20px 10%">
	<h1>stock</h1>
	<h3 style="color: darkgray">[Info] ${ msg }</h3>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Code</th>
				<th>Name</th>
				<th>Operate</th>
			</tr>
			<tr>
				<th></th>
				<th>
					<input type="text" class="form-control" name="code">
				</th>
				<th></th>
				<th>
					<button type="button" class="btn btn-primary">Add</button>
					<button type="button" class="btn btn-outline-info">Search</button>
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stock" items="${ stockList }">
				<tr>
					<td>${ stock.getId() }</td>
					<td>${ stock.getCode() }</td>
					<td>${ stock.getName() }</td>
					<td>
						<button type="button" class="btn btn-outline-primary">Edit</button>
						<button type="button" class="btn btn-outline-danger">Remove</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>