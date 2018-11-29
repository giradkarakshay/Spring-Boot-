<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                                    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Employee List</title>
</head>
<body>
	<div style="text-align: center;">
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">NAME</th>
					<th scope="col">CTC</th>
					<th scope="col">SKILL</th>
					<th scope="col">DOMAIN</th>
					<th scope="col">LOCATION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listOfEmployees}" var="emp" />
				<tr>
					<th scope="row">${emp.id}</th>
					<td>${emp.name}</td>
					<td>${emp.ctc}</td>
					<td>${emp.skill}</td>
					<td>${emp.domain}</td>
					<td>${emp.location}</td>
				</tr>
			</tbody>

		</table>
	</div>
</body>

</html>
