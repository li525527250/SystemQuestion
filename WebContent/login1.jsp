<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>远大住工</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript"
	src="scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function validate() {
		//获取当前文本框的值
		var uname = document.regForm.userName.value;
		//alert(uname);
		if (uname != "") {//用户名不用空的需要验证
			//alert(uname)
		} else {
			//alert('用户名不能为空!');
			var span = document.getElementById("userspan");
			span.innerHTML = "用户名不能为空!";
			span.className = "error";
		}
	}
	var req;
	//页面加载的时候初始XMLHttpRequest对象
	function createRequest() {//非IE浏览器
		if (window.XMLHttpRequest) {
			req = new XMLHttpRequest();
		} else {//IE浏览器
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	window.onload = createRequest;
</script>
</head>
<body>
	<div id="register" class="wrap">
		<%
			Object date = request.getAttribute("error");
		%>
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>远大住工登录</h1>
				<form id="myForm" name="regForm" action="Selectuser1"
					onsubmit="return checkForm(this)">
					<table>
						<tr>
							<td class="field">用户名：</td>
							<td><input class="text" type="text" name="userName"
								onfocus="FocusItem(this)" onblur="validate();" /><span
								id="userspan"></span></td>
						</tr>
						<tr>
							<td class="field">登录密码：</td>
							<td><input class="text" type="password" id="passWord"
								name="passWord" onfocus="FocusItem(this)"
								onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"><input type="submit"
									id="button1" value="用户登录"></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2017 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>

