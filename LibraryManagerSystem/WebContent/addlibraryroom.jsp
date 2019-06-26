<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<script type="text/javascript" src="./js/validate.js"></script>
<title>Insert title here</title>
<script type="text/javascript">



function createXMLHttpRequest() { //创建XMLHttpRequest
    try {
        return new XMLHttpRequest(); //直接创建对象，不适用与IE5,IE6
    } catch (e) {
        try {
            return new ActiveXObject("Msxml2.XMLHTTP");//对于不适用的，创建合适的对象
        } catch (e) {
            return new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
}

function send() {
	var xmlHttp = createXMLHttpRequest();

	xmlHttp.onreadystatechange = function () {
		if (xmlHttp.readyState === 4 && xmlHttp.status == 200) { //判断xmlHttp的状态是否完毕
    	if(xmlHttp.responseText == "true") { 
    	//判断ajax从Servlet中返回的信息，即判断用户名是否存在。
    	icac++;
        document.getElementById("aclb").innerHTML="This room has been created!"; 
        //弹出警告信息，告知不可适用该用户名
        disableSubmitButton();
    	}else {
    		icac=0;
            document.getElementById("aclb").innerHTML=""; 
            enableSubmitButton();
    }
}
};
var method = "POST"; //定义传输方式
var url="CheckLibraryRoomExist?" + new Date().getTime();
//定义对应的URL，为了避免浏览器的缓存造成干扰，加上时间戳
xmlHttp.open(method, url, true);
xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
var username = document.getElementById("username").value;
xmlHttp.send("username=" + username); //发送信息
}
</script>
</head>
<body style="background-image: url('./img/admincenter/admincenter.jpg');">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>

	<div class="searchdiv" align="center">
		<form action="AddLibraryRoom" method="post">
			<table>
				<tr>
					<td>Room Name:</td>
					<td><input type="text" name="RoomName" required="true" onkeyup="send()" id="username"></td>
					<td><label id="aclb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Room Floor:</td>
					<td><input type="text" name="RoomFloor" required="true"></td>
				</tr>
				<tr>
					<td>Book Category:</td>
					<td><input type="text" name="Category" required="true"></td>
				</tr>
				<tr>
					<td>Telephone:</td>
					<td><input type="text" name="Telephone" required="true"></td>
				</tr>
				<tr>
					<td>Brief Introduction:</td>
					<td><input type="text" name="BrefIntroduction" required="true"></td>
				</tr>
				<tr>
					<td>Open Time:</td>
					<td><input type="time" name="OpenTime" required="true"></td>
				</tr>
				<tr>
					<td>Close Time:</td>
					<td><input class="button white medium" type="time" name="CloseTime" required="true"></td>
				</tr>
				<tr>
					<td><input class="button white medium" type="submit" id="btnSubmit" value="add"></td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>