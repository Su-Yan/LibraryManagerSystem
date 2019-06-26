<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title>Neon Library</title>
<style type="text/css">
</style>
</head>
<body style="background-image: url(./img/index/morning.jpg);">
	<jsp:include page="./pagehead1.jsp"></jsp:include>
	<div class="searchdiv1">
		<form action="SearchResult?operationName=SearchBook" method="post">
			<table align="center">
				<tr>
					<th colspan="3" align="center"><h2>Neon Search</h2></th>
				</tr>
				<tr>
					<td><select name="SearchOption" required="true">
						<option value="BookName">Book Name</option>
						<option value="AuthorName">Author</option>
						<option value="BrefIntroduction">Description</option>
						<option value="BookID">Book ID</option>
						<option value="Category">Category</option>
						<option value="StoragePlace">Storage Room</option>
						<option value="PublishingHouse">Publishing House</option>
					</select></td>
					<td><input type="text" name="InputValue" required="true"></td>
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