<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title>Insert title here</title>
</head>
<body>

<div align="center" class="searchdiv">
	<table text-align="center" cellpadding="5px" align="center">
		<tr>
			<th><a href="SearchResult?operationName=Locations"><img
					class="common_icon" src="./img/index/home.png"></a>&nbsp;&nbsp;</th>
			<th><a href="SearchResult?operationName=BorrowRules"><img
					class="common_icon" src="./img/index/regulation.png"></a>&nbsp;&nbsp;

			</th>
			<%
				String Identity=(String)session.getAttribute("Identity");
				
			%>
			<th><a href="BorrowHistory"><img class="common_icon"
					src="./img/index/borrowreturn.png"></a>&nbsp;&nbsp;</th>
			<th><a href="SearchResult?operationName=RecommendedReading"><img
					class="common_icon" src="./img/index/star.png"></a>&nbsp;&nbsp;</th>
			<th><a href="SearchResult?operationName=NewBooks"><img
					class="common_icon" src="./img/index/leaf.png"></a>&nbsp;&nbsp;</th>
		</tr>
		<tr>
			<td><a href="SearchResult?operationName=Locations">Locations</a>&nbsp;&nbsp;

			</td>
			<td><a href="SearchResult?operationName=BorrowRules">Borrow
					Rules</a>&nbsp;&nbsp;</td>
			<td><a href="BorrowHistory">Renewal/Return</a>&nbsp;&nbsp;</td>
			<td><a href="SearchResult?operationName=RecommendedReading">Recommended
					Reading</a>&nbsp;&nbsp;</td>
			<td><a href="SearchResult?operationName=NewBooks">New Books</a>&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td  colspan="5" align="center"><h3>Designed By ©Geo, Tanky, Libra 2019</h3></td>
		</tr>
	</table>
</div>

</body>
</html>