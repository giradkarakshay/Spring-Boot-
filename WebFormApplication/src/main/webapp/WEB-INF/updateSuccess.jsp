<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/webformdb";%>
<%!String user = "root";%>
<%!String psw = "root";%>
<%
String id = request.getParameter("id");
String name=request.getParameter("name");
String ctc=request.getParameter("ctc");
String skill=request.getParameter("skill");
String domain=request.getParameter("domain");
String location=request.getParameter("location");
if(id != null)
{
Connection con = null;
PreparedStatement ps = null;
int personID = Integer.parseInt(id);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update empwb set id=?,name=?,ctc=?,skill=?,domain=?,location=? where id="+id;
ps = con.prepareStatement(sql);
ps.setString(1,id);
ps.setString(2, name);
ps.setString(3, ctc);
ps.setString(4, skill);
ps.setString(5, domain);
ps.setString(6, location);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
} 
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>