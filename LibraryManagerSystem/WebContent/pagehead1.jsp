<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title>Insert title here</title>
</head>
<body>
	<div align="right" class="pageheaddiv">
		<%!String url="index.jsp"; 
		%>
		<%
		String UserName=(String)session.getAttribute("UserName");
		String Identity=(String)session.getAttribute("Identity");
		if(UserName==""||UserName==null){ %>
		<a href="Login.jsp">Log in</a>
		<%}else{ 
			if(Identity!=null){
				if(Identity.equals("Admin")){
					url="admincenter.jsp";
				}else{
					url="personalcenter.jsp";
				}
			}
		%>
		Hi, <a href=<%=url%>><%=session.getAttribute("UserName") %></a>, 
		<a href="Logout">Log out</a>
		<%} %>|
		<a href="SearchResult?operationName=Locations" >Open Time</a><label name="OpenTime"></label>|
		<%if(Identity!="Admin"){%>
			<a href="donate.jsp">Donate</a>
		<%} else { %>
			<a href="DonateManager">Donate Manager</a><%} %>
			|
		<a href="SearchResult?operationName=AboutUs">Consult</a>
	</div>
	<div align="left">
		<a href="index.jsp"><img class="library_icon" src="./img/library.png"></a>
	</div>
</body>
</html>