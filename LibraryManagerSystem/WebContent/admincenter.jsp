<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title>Insert title here</title>
</head>
<body style="background-image: url('./img/admincenter/admincenter.jpg');">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
	<div class="searchdiv" align="center">
		<table>
		<%
		String AdminRight=(String)session.getAttribute("AdminRight");
		String UserRight= (String)session.getAttribute("UserRight");
		String BookRight=(String)session.getAttribute("BookRight");
		if(AdminRight.equals("1")){ %>
			<tr>
				<td><a href="createadmin.jsp"><input class="button white size" type="button" value="New Librarian"></a></td>
			</tr>
		<%}%>
		
			<%if(BookRight.equals("1")){ %>
			<tr>
				<td><a href="DonateManager"><input class="button white size" type="button" value="Donate Manager"></a></td>
			</tr>
			<%} %>
			<tr>
				<td><a href="libraryroommanager.jsp"><input class="button white size" type="button" value="Library Room Manager"></a></td>
			</tr>
			<tr>
				<td><a href="borrowlist.jsp"><input class="button white size" type="button" value="Check Borrow Information"></a></td>
			</tr>
			<tr>
				<td><a href=GetAllFinedNotReturnAccount><input class="button white size" type="button" value="Get All Fined And Not Returned Account"></a></td>
			</tr>
			<tr>
				<td><a href=addrules.jsp><input class="button white size" type="button" value="Add New Rules"></a></td>
			</tr>
		</table>
	</div>
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>

</body>
</html>