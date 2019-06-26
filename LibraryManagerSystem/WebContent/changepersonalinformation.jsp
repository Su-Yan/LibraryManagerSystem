<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<script type="text/javascript" src="./js/validate.js"></script>
<title>Insert title here</title>
</head>
<body style="background-image: url(./img/personalcenter/personalcenterbg.jpg);">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
	<%
		ResultSet rs=(ResultSet)request.getAttribute("table");
		rs.first();
	%>
	<div align="center" class="searchdiv">
		<form action="CompleteChangePersonalInfo" method="post">
		<table align="center">
				<tr>
					<td>Account:</td>
					<td><input  type="text" name="Account" readonly="readonly"  value=<%=rs.getString("Account") %>></td>
					<td><label id="aclb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="Password" required="true" onkeyup="confirmPassword()" value=<%=rs.getString("Password") %>></td>
					<td><label name="pwlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input type="password" name="ConfirmPassword" required="true" onkeyup="confirmPassword()" value=<%=rs.getString("Password") %>></td>
					<td><label name="cpwlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Your Real Name:</td>
					<td><input type="text" name="Name" required="true" value=<%=rs.getString("Account") %>></td>
					<td><label name="nmlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Identify ID:</td>
					<td><input type="text" name="IdentifyID" required="true" readonly="readonly" disabled="disabled" value=<%=rs.getString("IdentifyID") %>></td>
					<td><label name="idlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Live Address:</td>
					<td><input type="text" name="LiveAddress" required="true" value=<%=rs.getString("LiveAddress") %>></td>
					<td><label name="lalb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="Email" required="true" onkeyup="checkEmail()" value=<%=rs.getString("Email") %>></td>
					<td><label name="emlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input type="text" name="PhoneNumber" required="true" onkeyup="checkPhone()" value=<%=rs.getString("PhoneNumber") %>></td>
					<td><label name="pnlb" style="color: red"></label></td>
				</tr>
				<%
					String ID=(String)session.getAttribute("Identity");
					if(ID.equals("Borrower")){
				%>
				<tr>
					<td>Work Address:</td>
					<td><input type="text" name="WorkAddress" required="true" value=<%=rs.getString("WorkAddress") %>></td>
					<td><label name="walb" style="color: red"></label></td>
				</tr>
				<%} %>
				<tr>
					<td colspan="3"><input type="submit" value="Update" id="btnSubmit"></td>
				</tr>
		</table>
		</form>
	</div>
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>