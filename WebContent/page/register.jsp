<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>远大 - 注册</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function.js"></script>
<script type="text/javascript"
	src="../scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function f() {
		var a = document.getElementById("veryCode");
		a.src = "VeryCodeServlet?" + Math.random();
	}
	function validate() {
	//获取当前文本框的值
		var uname = document.regForm.userName.value;
		if (uname != "") {//用户名不用空的需要验证
			//	    alert(uname);

			var url = "../ValidateUser?uname=" + uname + "&"
					+ new Date().getTime();
			//alert() 就不提交   true异步提交
			//用GET方式向url发送异步请求
			req.open("get", url, true);
			req.send(null); //发送请求
			//发送请求后，调用callback
			req.onreadystatechange = callback;
		} else {
			//	alert('用户名不能为空!');
			var span = document.getElementById("userspan");
			span.innerHTML = "用户名不能为空!";
			span.className = "error";

		}
	}
	//回调方法
	function callback() {
		//服务器成功处理并且响应内容已经传回浏览器
		if (req.readyState == 4) {
			if (req.status == 200) {
				//得到响应内容
				var msg = req.responseText;
				//	 	alert(msg); 
				//显示消息的层
				var span = document.getElementById("userspan");
				span.innerHTML = msg;
				span.className = "error";

			}
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
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>欢迎注册</h1>
				<ul class="steps clearfix">
					<li class="current"><em></em>填写注册信息</li>
					<li class="last"><em></em>注册成功</li>
				</ul>
				<form id="regForm" name="regForm" method="post"
					action="../RegisterServlet" onsubmit="return checkForm(this);">
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
							<td class="field">设置权限：</td>
							<td><input type="radio" value="guanli" name="quanxian"
								checked="checked">管理员 <input type="radio" value="putong"
									name="quanxian">普通用户<span></span></td>
						</tr>
						<tr>
							<td class="field">设置公司区域：</td>
							<td><select name="gongshi">
								<option value="上海公司" selected>上海公司
								<option value="京津冀公司">京津冀公司
								<option value="安徽公司">安徽公司
								<option value="岳阳公司">岳阳公司
								<option value="广东公司">广东公司
								<option value="杭州公司">杭州公司
								<option value="江苏公司">江苏公司
								<option value="郴州公司">郴州公司
								<option value="长沙公司">长沙公司
								<option value="远铃浴室">远铃浴室
								<option value="装备制造公司">装备制造公司
							</select></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"><input type="submit"
									name="submit" value="提交注册" /></label></td>
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
