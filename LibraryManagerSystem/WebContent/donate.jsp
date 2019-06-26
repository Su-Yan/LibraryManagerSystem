<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<script type="text/javascript" src="./js/validate.js"></script>
<title>Insert title here</title>
</head>
<body style="background-image: url(./img/index/morning.jpg);">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
	<div  class="searchdiv" align="center">
		<h2>Donate:</h2>
		<form action="DonateConfirm" method="post">
			<table >
				<tr>
					<td>Book Name:</td>
					<td><input type="text" name="BookName" required="true"></td>
				</tr>
				<tr>
					<td>Author(Split by ","):</td>
					<td>
						<input type="text" name="Author" required="true">
					</td>
					
				</tr>
				<tr>
					<td>Publishing House:</td>
					<td><input type="text" name="PublishingHouse" required="true"></td>
				</tr>
				<tr>
					<td>Publishing Year:</td>
					<td><input type="date" name="PublishingYear" required="true"></td>
				</tr>
				<tr>
					<td>Storage Place:</td>
					<td><input type="text" name="StoragePlace" required="true"></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="text" name="Price" required="true"></td>
				</tr>
				<tr>
					<td>Amount:</td>
					<td><input type="text" name="Amount" onkeyup="checkBookAmount()" required="true"></td>
					<td><label name="amtlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Category:</td>
					<td><input type="text" name="Category" required="true"></td>
				</tr>
				<tr>
					<td>Bref Introduction:</td>
					<td><input type="text" name="BrefIntroduction" required="true"></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button white medium" type="submit" value="Donate" id="btnSubmit" required="true"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>