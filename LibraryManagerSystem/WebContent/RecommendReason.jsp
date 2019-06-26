<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title>Insert title here</title>
</head>
<body style="background-image: url(./img/index/morning.jpg);">
	<jsp:include page="./pagehead1.jsp"></jsp:include>
	<div class="searchdiv" align="center">
		<form action="AddRecommend" method="post">
		<table>
			<tr>
				<td>Book ID:</td>
				<td><input type="text" name="BookID" value="<%=request.getParameter("BookID") %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Book Name:</td>
				<td><input type="text" name="BookName" value="<%=request.getParameter("BookName") %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Recommend Reason:</td>
				<td><input type="text" name="RecommendReason" required="true"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
		
		
		</form>
	</div>
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>