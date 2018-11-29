<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String id = request.getParameter("id");
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "employeedetails";
	String userid = "root";
	String password = "root";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<div style="text-align: center;">
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">NAME</th>
					<th scope="col">CTC</th>
					<th scope="col">SKILL</th>
					<th scope="col">DOMAIN</th>
					<th scope="col">LOCATION</th>
					<th scope="col">UPDATE</th>
				</tr>
			</thead>
			<%
			try {
				connection = DriverManager.getConnection(connectionUrl + database, userid, password);
				statement = connection.createStatement();
				String sql = "select * from employeeinfo";
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
		%>
			<tbody>
				<tr>
					<th scope="row"><%=resultSet.getString("name")%></th>
					<td><%=resultSet.getString("ctc")%></td>
					<td><%=resultSet.getString("skill")%></td>
					<td><%=resultSet.getString("domain")%></td>
					<td><%=resultSet.getString("location")%></td>
					<td><a href="update.jsp?id=<%=resultSet.getString("id")%>">
							update</a></td>

				</tr>

				<%
			}
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
			
		</table><%@page import="java.sql.*,java.util.*"%>
		</div>
</body>


</html>