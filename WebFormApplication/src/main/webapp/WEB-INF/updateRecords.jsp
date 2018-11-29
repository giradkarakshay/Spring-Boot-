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
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from empwb where id="+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
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
<form method="post" action="updateSuccess.jsp">
<div class="form-group">
<input type="hidden" name="id" value="<%=resultSet.getString("id") %>">
<br>
Employee_Name:<br>
<input type="text" class="form-control" name="name" value="<%=resultSet.getString("name") %>">
<br>
CTC:<br>
<input type="text" class="form-control" name="ctc" value="<%=resultSet.getString("ctc") %>">
<br>
Skills:<br>
<input type="text"  class="form-control" name="skill" value="<%=resultSet.getString("skill") %>">
<br>
Domain:<br>
<input type="text" class="form-control" name="domain" value="<%=resultSet.getString("domain") %>">
<br>
Location:<br>
<input type="text" class="form-control" name="location" value="<%=resultSet.getString("location") %>">
<br>
<input type="submit" value="submit">
</div>
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>