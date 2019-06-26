<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title>Insert title here</title>
</head>
<body style="background-image: url(./img/index/morning.jpg);">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
	<div class="searchdiv" align="center">
		<form action="EditRulesConfirm" method="post">
			<table>
				<tr>
					<td>ID:</td>
					<td><input type="text" value=<%=request.getParameter("ID") %> name="ID" readonly="readonly" required="true"></td>
				</tr>
				<tr>
					<td>Rules:</td>
					<td><input type="text" value=<%=request.getParameter("Rules") %> name="Rules" required="true"></td>
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