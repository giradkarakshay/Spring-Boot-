<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<%@page import="java.sql.*,java.util.*"%>
	<%
		String id = request.getParameter("id");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetails", "root", "root");
			PreparedStatement st = con.prepareStatement("delete from employeeinfo where id = ? ");

			
			st.setInt(1, Integer.parseInt(id));

			int i = st.executeUpdate();

			out.println("Data is successfully deleted!");
		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
	%>
	<%
		out.print("Record Deleted Successfully");
	%>
</body>
</html>