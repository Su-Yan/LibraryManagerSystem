<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/icon.css?v=<%= System.currentTimeMillis()%>">
<script type="text/javascript" src="./js/validate.js"></script>
<title>Register</title>
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
        document.getElementById("aclb").innerHTML="This account has been created!"; 
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
var url="CheckAccountExist?" + new Date().getTime();
//定义对应的URL，为了避免浏览器的缓存造成干扰，加上时间戳
xmlHttp.open(method, url, true);
xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
var username = document.getElementById("username").value;
xmlHttp.send("username=" + username+"&idd=borrower"); //发送信息
}
</script>
</head>
<body style="background-image: url(./img/register/welcome.jpg);">
	<jsp:include page="./pagehead1.jsp" flush="true"></jsp:include>
	<div align="center" class="searchdiv">
		<form action="Register?create=borrower" method="post">
			<table>
				<tr>
					<td>Account:</td>
					<td><input type="text" name="Account" required="true" id="username" onkeyup="send()" ></td>
					<td><label id="aclb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="Password" required="true" onkeyup="confirmPassword()"></td>
					<td><label name="pwlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input type="password" name="ConfirmPassword" required="true" onkeyup="confirmPassword()"></td>
					<td><label name="cpwlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Your Real Name:</td>
					<td><input type="text" name="Name" required="true"></td>
					<td><label name="nmlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Identify ID:</td>
					<td><input type="text" name="IdentifyID" required="true" onkeyup="checkIdentifyID()"></td>
					<td><label name="idlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Live Address:</td>
					<td><input type="text" name="LiveAddress" required="true"></td>
					<td><label name="lalb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="Email" required="true" onkeyup="checkEmail()"></td>
					<td><label name="emlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input type="text" name="PhoneNumber" required="true" onkeyup="checkPhone()"></td>
					<td><label name="pnlb" style="color: red"></label></td>
				</tr>
				<tr>
					<td>Work Address:</td>
					<td><input type="text" name="WorkAddress" required="true"></td>
					<td><label name="walb" style="color: red"></label></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Register!" id="btnSubmit"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="./pagefoot1.jsp" flush="true"></jsp:include>
</body>
</html>