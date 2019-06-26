<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title>Login</title>
</head>
<body style="background-image: url(./img/login/LoginBackground.jpg);">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
<div class="searchdiv">
	<div align="center">
		<h1>Welcome to Neon Library!</h1>
	</div>
	<br/>
	<br/>
	<div align="center">
		<form action="Login" method="post">
			<table>
				<tr>
					<td>
						Account:
					</td>
					<td>
						<input type="text" name="Account" required="true">
						<%if(request.getAttribute("errorTip1")!=null){ %>
						<label style="color: red"><%=request.getAttribute("errorTip1")%></label>
						<%} %>
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
					<td>
						<input type="password" name="Password" required="true">
						<%if(request.getAttribute("errorTip2")!=null){ %>
						<label style="color: red"><%=request.getAttribute("errorTip2")%></label>
						<%} %>
					</td>
				</tr>
				<tr>
					<td>Identity:</td>
					<td><select name="Identity" required="true">
						<option value="borrower">Borrower</option>
						<option value="admindetails">Admin</option>
					</select></td>
				</tr>
				<tr>
					<td>
						<input class="button white medium" type="submit" value="Login">
					</td>
					<td>
						<a href="register.jsp">Do not have account? Register!</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>