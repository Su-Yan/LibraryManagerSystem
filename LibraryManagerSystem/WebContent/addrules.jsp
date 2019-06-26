<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title>Insert title here</title>
</head>
<body style="background-image: url('./img/admincenter/admincenter.jpg');">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
	
	<div  class="searchdiv" align="center">
	<form action="AddRules" method="post">
		<table>
			<tr>
				<td>Rules:</td>
				<td><input class="button white medium" type="text" name="Rules"></td>
			</tr>
			<tr>
				<td><input class="button white medium" type="submit" value="Add"></td>
			</tr>
		</table>
	</form>
	</div>

	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>