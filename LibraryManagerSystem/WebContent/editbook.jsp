<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.ResultSetMetaData" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<script type="text/javascript" src="./js/validate.js"></script>
<title>Insert title here</title>
</head>
<body style="background-image: url(./img/index/morning.jpg);">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
	<div  class="searchdiv" align="center">
		<h2>Edit:</h2>
		<%
			ResultSet rs=(ResultSet)request.getAttribute("table");
		%>
		<form action="EditConfirm?BookID=<%=rs.getString("ID") %>" method="post">
			<table >
				<tr>
					<td>Book Name:</td>
					<td><input type="text" name="BookName" value=<%=rs.getString("BookName") %> readonly="readonly" required="true"></td>
				</tr>
				<tr>
					<td>Author(Split by ","):</td>
					<td>
						<input type="text" name="Author" value=<%=rs.getString("AuthorName") %> required="true">
					</td>
					
				</tr>
				<tr>
					<td>Publishing House:</td>
					<td><input type="text" name="PublishingHouse" value=<%=rs.getString("PublishingHouse") %> required="true"></td>
				</tr>
				<tr>
					<td>Publishing Year:</td>
					<td><input type="date" name="PublishingYear" value=<%=rs.getString("PublishingYear") %> required="true"></td>
				</tr>
				<tr>
					<td>Storage Place:</td>
					<td><input type="text" name="StoragePlace" value=<%=rs.getString("StoragePlace") %> required="true"></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="text" name="Price" value=<%=rs.getString("Price") %> required="true"></td>
				</tr>
				<tr>
					<td>Amount:</td>
					<td><input type="text" name="Amount" onkeyup="checkBookAmount()" value=<%=rs.getString("Amount") %> required="true"></td>
					<td><label name="amtlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Category:</td>
					<td><input type="text" name="Category" value=<%=rs.getString("Category") %> required="true"></td>
				</tr>
				<tr>
					<td>Bref Introduction:</td>
					<td><input type="text" name="BrefIntroduction" value=<%=rs.getString("BrefIntroduction") %> required="true"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Donate" required="true"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>


</body>
</html>