<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title>Insert title here</title>
</head>
<body style="background-image: url(./img/personalcenter/personalcenterbg.jpg);">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
	<div class="searchdiv" align="center">
		<table>
			<tr>
				<td><a href="index.jsp"><input class="button white size" type="button" value="Borrow Book"></a></td>
			</tr>
			<tr>
				<td><a href="BorrowHistory"><input class="button white size" type="button" value="Borrow History"></a></td>
			</tr>
			<tr>
				<td><a href="DonateManager"><input class="button white size" type="button" value="Donate History"></a></td>
			</tr>
			<tr>
				<td><a href="ChangePersonalInformation"><input class="button white size" type="button" value="Change Personal Information"></a></td>
			</tr>
		</table>
	</div>
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>