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
	<div class="searchdiv">
		<form action="GetBorrowList" method="post">
			<table align="center">
				<tr>
					<th colspan="4" align="center"><h2>Borrow Search</h2></th>
				</tr>
				<tr>
					<td><select name="SearchOption" required="true">
						<option value="BorrowerAccount">Borrower Account</option>
						<option value="BookName">Book Name</option>
						<option value="AuthorName">Author</option>
						<option value="ID">Book ID</option>
					</select></td>
					<td><input type="text" name="InputValue" required="true"></td>
					<td><select name="ReturnOrNot">
						<option value="No">Not Return</option>
						<option value="Yes">Returned</option>
						<option value="All">All</option>
					</select></td>
					<td><select name="SearchMethod">
						<option value="FuzzySearch">Fuzzy Search</option>
						<option value="PreciseSearch">Precise Search</option>
					</select></td>
					<td><input class="button white medium" type="submit" value="Search"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>