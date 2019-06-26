<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.ResultSetMetaData" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title>Insert title here</title>
</head>
<body style="background-image: url(./img/index/morning.jpg);">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
	<div  class="searchdiv" align="center">
		<h2>Edit:</h2>
		<%
			ResultSet rs=(ResultSet)request.getAttribute("table");
		%>
		<form action="EditRoomConfirm" method="post">
			<table>
				<tr>
					<td>Room Name:</td>
					<td><input type="text" name="RoomName" value=<%=rs.getString("RoomName") %> readonly="readonly" required="true"></td>
				</tr>
				<tr>
					<td>Room Floor:</td>
					<td><input type="text" name="RoomFloor" value=<%=rs.getString("RoomFloor") %> required="true"></td>
				</tr>
				<tr>
					<td>Book Category:</td>
					<td><input type="text" name="Category" value=<%=rs.getString("Category") %> required="true"></td>
				</tr>
				<tr>
					<td>Telephone:</td>
					<td><input type="text" name="Telephone" value=<%=rs.getString("Telephone") %> required="true"></td>
				</tr>
				<tr>
					<td>Brief Introduction:</td>
					<td><input type="text" name="BrefIntroduction" value=<%=rs.getString("BrefIntroduction") %> required="true"></td>
				</tr>
				<tr>
					<td>Open Time:</td>
					<td><input type="time" name="OpenTime" value=<%=rs.getString("OpenTime") %> required="true"></td>
				</tr>
				<tr>
					<td>Close Time:</td>
					<td><input type="time" name="CloseTime" value=<%=rs.getString("CloseTime") %> required="true"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>


</body>
</html>