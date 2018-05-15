<%@page import="entity.Question"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>重点问题页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="jquery,ui,easy,easyui,web">
<meta name="description"
	content="easyui help you build your web page easily!">
<link rel="stylesheet" type="text/css" href="css/easyui.css">
<link rel="stylesheet" type="text/css" href="css/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<style type="text/css">
.datagrid-header-rownumber, .datagrid-cell-rownumber {
	width: 40px;
}

* {
	margin: 0px;
	padding: 0px;
}

.divBox {
	background: #e0e0e0;
	height: 900px;
}

.center {
	background: #ffffff;
	height: 900px;
	width: 70%;
	margin: 0 auto;
}

.top {
	background: #ccffcc;
	float: right;
	width: 100%;
	height: 140px;
}

.center1 {
	background: #ffffff;
	float: right;
	width: 100%;
	height: 400px;
}

div a {
	font-size: 16px
}

div a:link {
	color: blue;
	text-decoration: none;
}

//
未访问：蓝色、无下划线 
div a:active: {
	color: red;
}

//
激活：红色 
div a:visited {
	color: purple;
	text-decoration: none;
}

//
已访问：purple、无下划线 
div a:hover {
	color: red;
	text-decoration: underline;
}
//
鼠标移近：红色、下划线
</style>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="http://www.w3cschool.cc/try/jeasyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="http://www.w3cschool.cc/try/jeasyui/datagrid-scrollview.js"></script>


<script type="text/javascript">
	
	function altRows(id){
		if(document.getElementsByTagName){  
			var table = document.getElementById(id);  
			var rows = table.getElementsByTagName("tr"); 
			 
			for(i = 0; i < rows.length; i++){          
				if(i % 2 == 0){
					rows[i].className = "evenrowcolor";
				}else{
					rows[i].className = "oddrowcolor";
				}      
			}
		}
	}
	window.onload=function(){
		altRows('alternatecolor');
	}
			var array = new Array();  
			for(var i=0; i<rows.length; i++){
			   	 ids.push(rows[i].itemid);
					}
					alert(ids.join(''));
					function load(){
						var myselect = document.getElementById("jiejue");
						var index=myselect.selectedIndex ;
					 $("#form").submit();	
					}
					function f(a){
						 $.ajax({  
			             type: "GET",  
			             url: "SelectOneQuestion",  
			             data: {quid:a},
			              success: function() {
			              var uid="${user.uid}"
			              if(uid=="1"){
			              	window.location.href= "page/managePage.jsp";
			              }else{
			              	window.location.href= "page/userPage.jsp";
			              } 
			           }
			         });  
					}
		function f3(){
			document.getElementById("form3").submit();
				 
			}
		function f1(){
		var wenti=document.getElementsByName("wenti").value;
			 
		}
	   	</script>
<style type="text/css">
table.altrowstable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}

table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

.oddrowcolor {
	background-color: #ffffcc;
}

.evenrowcolor {
	background-color: #d9ffd9;
}
</style>

</head>
<body>
	<div class="divBox">
		<div class="center">
			<div class="top">
				<h2>欢迎对金蝶ESA系统提出宝贵意见</h2>
				<c:choose>
					<c:when test="${user.uauthorityid==1}">
						<a href="page/register.jsp" class="easyui-linkbutton" iconAlign="right"
							data-options="iconCls:'icon-search'">注册用户</a>
					</c:when>
					<c:when test="${user.uauthorityid!=1}"></c:when>
				</c:choose>
				<div class="demo-info" style="margin-bottom: 10px">
					<div class="demo-tip icon-tip">&nbsp;</div>
					<div>您的意见将是我们前进的动力</div>
				</div>
			</div>
			<div class="center1">
				<form method="post" id="form1" name="xianzhe1">
					<div id="list"
						style="overflow-x: hidden; width: 100%; height: 300px;">
						<table class="altrowstable" id="alternatecolor" border="1" id="tt"
							style="width: 100%;" title="意见及建议">
							<thead>
								<tr height="40">
									<th align="center" field="inv" width="80">问题ID</th>
									<th align="center" field="date" width="100">问题描述</th>
									<th align="center" field="name" width="80">提问人</th>
									<th align="center" field="amount" width="80" align="right">提问时间</th>
									<th align="center" field="price" width="80" align="right">是否解决</th>
									<th align="center" field="price1" width="80" align="right">所在公司</th>
									<th align="center" field="cost" width="100" align="right">查看详情</th>
								</tr>
							<thead>
							<tbody>
								<c:forEach items="${list}" var="item" varStatus="status">
									<tr height="30">
										<td field="inv" width="80"><input type="hidden"
											value="${item.bquestionid}"> ${item.bquestionid} <input
											type="hidden" name="uid" value="${item.bquestionUid}"></td>
										<td field="date" width="100">${item.bdescribe}</td>
										<td field="name" width="80">${item.bquestionUname}</td>
										<td field="amount" width="80" align="right">${item.bdate}</td>
										<td field="price" width="80" align="right"><c:if
												test="${item.banswerOrNo == 0}">未解决</c:if> <c:if
												test="${item.banswerOrNo == 1}">已解决</c:if></td>
										<td field="price1">${item.company}</td>
										<td field="cost" width="100" align="right"><input
											type="button" value="查看问题" onclick="f(${item.bquestionid})" />
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</form>
			</div>
		</div>
</body>


</html>

