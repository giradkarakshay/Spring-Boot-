<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<form action="deleteEmployeeById">

		<div class="input-group col-md-5">
			<input type="text" name="id" class="form-control"
				placeholder="Enter Employee ID To Delete" aria-label="Employee ID"
				aria-describedby="button-addon2">
			<div class="input-group-append col-sm-3">
				<button class="btn btn-outline-black" type="submit"
					id="button-addon2">Delete</button>
			</div>
		</div>
	</form>
	<%@page import="java.sql.*,java.util.*"%>

</body>
</html>