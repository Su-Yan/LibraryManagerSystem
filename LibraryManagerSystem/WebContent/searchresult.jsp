<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.ResultSetMetaData" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<title><%=request.getAttribute("operationHead") %></title>
</head>
<body style="background-image: url(./img/index/morning.jpg);">
	<jsp:include page="./pagehead1.jsp"></jsp:include>
<div class="searchdiv">
	<div align="center">
		<h2><%=request.getAttribute("operationHead") %></h2>
	</div>
	<div>
		<%
			String operationName=(String)request.getAttribute("operationName");
			String Identity=(String)session.getAttribute("Identity");
			ResultSet rs=(ResultSet)request.getAttribute("table");
			if(rs!=null){
				if(rs.first()){
					rs.beforeFirst();
					ResultSetMetaData rsmd=rs.getMetaData();
					int col=rsmd.getColumnCount();
					out.println("<TABLE ALIGN=CENTER BORDER=1  frame=hsides cellpadding=0 rules=rows bordercolor=white>");
					out.println("<tr>");
					for(int i=1;i<=col;i++){
						out.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
					}
					if(Identity!=null){
						if(Identity.equals("Borrower")&&operationName.equals("SearchBook")){
							out.println("<th>Borrow</th>");
							System.out.println("Success");
						}else if(Identity.equals("Borrower")&&operationName.equals("BorrowHistory")){
							out.println("<th>Renewal</th><th>Return</th>");
						}
						else if(Identity.equals("Admin")){
							switch(operationName){
							case"SearchBook":
								out.println("<th>Edit</th><th>Delete</><th>Recommend</>");
								break;
							case"Locations":
								out.println("<th>Edit</th><th>Delete</>");
								break;
							case"RecommendedReading":
								out.println("<th>Delete</th>");
								break;
								
							}
						}
					}else{
						System.out.println("fail");
					}
					out.println("</tr>");
					while(rs.next()){
						out.println("<tr>");
						for(int i=1;i<=col;i++)
							out.println("<td>"+rs.getString(rsmd.getColumnLabel(i))+"</td>");
						if(Identity!=null){
							if(Identity.equals("Borrower")){
								switch(operationName){
								case"SearchBook":
									out.println("<td>");
									if(rs.getInt("Amount")==0)
										out.println("<a href=BorrowBook?BookID="+rs.getString("ID")+"&Method=Borrow><input type=button  disabled=disabled value=Borrow></a>");
									else if(rs.getInt("Amount")>0){
										out.println("<a href=BorrowBook?BookID="+rs.getString("ID")+"&Method=Borrow><input type=button value=Borrow></a>");
										
									}
									out.println("</td>");
									
									break;
								case"BorrowHistory":
									out.println("<td>");
									if(rs.getInt("RenewalTime")>0&&rs.getString("ReturnOrNot").equals("No"))
										out.println("<a href=BorrowBook?LogID="+rs.getString("LogID")+"&Method=Renewal><input type=button value=Renewal></a>");
										
									out.println("</td>");
									out.println("<td>");
									if(rs.getString("ReturnOrNot").equals("No"))
										out.println("<a href=BorrowBook?LogID="+rs.getString("LogID")+"&Method=Return&BookID="+rs.getString("BookID")+"><input type=button value=Return></a>");
										
									out.println("</td>");
									
									break;
								}
								
								
								
							}else if(Identity.equals("Admin")){
								switch(operationName){
								case"SearchBook":
									out.println("<td>");
									
									out.println("<a href=EditOrDelete?BookID="+rs.getString("ID")+"&method=Edit&about=Book><input type=button value=Edit></a>");
									
									out.println("</td>");
									out.println("<td>");
									
									out.println("<a href=EditOrDelete?BookID="+rs.getString("ID")+"&method=Delete&about=Book><input type=button value=Delete></a>");
									
									out.println("</td>");
									out.println("<td>");
									
									out.println("<a href=RecommendReason.jsp?BookID="+rs.getString("ID")+"&BookName="+rs.getString("BookName")+"><input type=button value=Recommend></a>");
									
									out.println("</td>");
									break;
								case"Locations":
									out.println("<td>");
									
									out.println("<a href=EditOrDelete?RoomName="+rs.getString("RoomName")+"&method=Edit&about=Locations><input type=button value=Edit></a>");
									
									out.println("</td>");
									out.println("<td>");
									
									out.println("<a href=EditOrDelete?RoomName="+rs.getString("RoomName")+"&method=Delete&about=Locations><input type=button value=Delete></a>");
									
									out.println("</td>");
									
									break;
								case"RecommendedReading":
									out.println("<td>");
									
									out.println("<a href=DeleteRecommend?BookID="+rs.getString("BookID")+"&Reason="+rs.getString("Reason")+"><input type=button value=Delete></a>");
									
									out.println("</td>");
									break;
								case"BorrowRules":
									out.println("<td>");
									
									out.println("<a href=editbook.jsp?ID="+rs.getInt("ID")+"&method=Edit&about=BorrowRules><input type=button value=Edit></a>");
									
									out.println("</td>");
									out.println("<td>");
									
									out.println("<a href=EditOrDelete?ID="+rs.getInt("ID")+"&method=Delete&about=BorrowRules><input type=button value=Delete></a>");
									
									out.println("</td>");
									
									break;
								}
								
							}
						}
						out.println("</tr>");
					}
					out.println("</table>");
					
				}else{
					out.println("Sorry, There is no data!");
				}
			}else{
				out.println("Sorry, There is no data!");
			}
		%>
	</div>
</div>
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>