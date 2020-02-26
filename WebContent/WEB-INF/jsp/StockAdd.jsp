<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Stock Add</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding: 20px 10%">
	<h1>stock</h1>
	<h3 style="color: darkgray">[Info] Add Stock...</h3>
		<form>
			<div class="form-group">
				<label>Id</label>
				<input type="text" class="form-control" name="id" placeholder="default" disabled>
			</div>
			<div class="form-group">
				<label>Code</label>
				<input type="text" class="form-control" name="code" placeholder="Code">
			</div>
			<div class="form-group">
				<label>Name</label>
				<input type="text" class="form-control" name="name" placeholder="Name">
			</div>
			<button type="button" class="btn btn-outline-dark">Cancel</button>
			<button type="submit" class="btn btn-primary">Finish</button>
		</form>
</body>
</html>