<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSetMetaData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="./css/icon.css?v=<%=System.currentTimeMillis()%>">
</head>
<body
	style="background-image: url('./img/admincenter/admincenter.jpg');">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
	<div class="searchdiv" align="center">

		<%
			String Identity = (String) session.getAttribute("Identity");
			ResultSet rs = (ResultSet) request.getAttribute("table");
			if (rs != null) {
				if (rs.first()) {
					rs.beforeFirst();
					ResultSetMetaData rsmd = rs.getMetaData();
					int col = rsmd.getColumnCount();
					out.println(
							"<TABLE ALIGN=CENTER BORDER=1  frame=hsides cellpadding=0 rules=rows bordercolor=white>");
					out.println("<tr>");
					for (int i = 1; i <= col; i++) {
						out.println("<th>" + rsmd.getColumnLabel(i) + "</th>");
					}
					out.println("</tr>");
					while (rs.next()) {
						out.println("<tr>");
						for (int i = 1; i <= col; i++)
							out.println("<td>" + rs.getString(rsmd.getColumnLabel(i)) + "</td>");
					}
					out.println("</tr>");
					out.println("</table>");
				}

			} else {
				out.println("Sorry, There is no data!");
			}
		%>
	</div>


	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>