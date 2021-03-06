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

<title>用户意见页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="jquery,ui,easy,easyui,web">
<meta name="description"
	content="easyui help you build your web page easily!">
<title>DataGrid Virtual Scrolling - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css" href="css/easyui.css">
<link rel="stylesheet" type="text/css" href="css/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript">
	function altRows(id) {
		if (document.getElementsByTagName) {
			var table = document.getElementById(id);
			var rows = table.getElementsByTagName("tr");
			for (i = 0; i < rows.length; i++) {
				if (i % 2 == 0) {
					rows[i].className = "evenrowcolor";
				} else {
					rows[i].className = "oddrowcolor";
				}
			}
		}
	}

	window.onload = function() {
		altRows('alternatecolor');
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
<style>
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
	.
	datagrid-header-rownumber
	,.datagrid-cell-rownumber{
	width
	:
	40px;
}
</style>

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/datagrid-scrollview.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="divBox">
		<div class="center">
			<h2>欢迎对金蝶ESA系统提出宝贵意见</h2>
			<div class="demo-info" style="margin-bottom: 10px">
				<div class="demo-tip icon-tip">&nbsp;</div>
				<div>您的意见将是我们前进的动力</div>
			</div>
			<div style="margin-bottom: 10px"></div>
			</table>
			</form>
			<div class="demo-info" style="margin-bottom: 10px">
				<h2>查看以下问题详情</h2>
				<div class="demo-tip icon-tip">&nbsp;</div>
				<form method="post" action="UpdQuestion">
					<table class="altrowstable" id="alternatecolor">
						<c:forEach items="${list1}" var="item" varStatus="status">
							<tr>
								<td class="td"><h3>问题描述</h3></td>
								<td class="td"><textarea name="" rows="8" cols="50"
										readonly="readonly">${item.bdescribe}</textarea></td>
							</tr>
							<tr>
								<td class="td"><h3>问题图片</h3></td>
								<td class="td"><a href="${item.bquestionImg}"
									target="_blank"><img src="${item.bquestionImg}" id="img5"
										height="100" width="100" /></a></td>
							</tr>
							<tr>
								<td class="td"><h3>解决方案</h3></td>
								<td class="td"><c:if test="${item.banswerScheme == null}">亲！！！您所提出的问题暂时还未能解决,请等待管理员提出解决方案。</c:if>
									<c:if test="${item.banswerScheme != null}">
										<textarea name="" rows="8" cols="50" readonly="readonly">${item.banswerScheme}</textarea>
									</c:if></td>
							</tr>
							<tr>
								<td class="td"><h3>解决方案图片描述</h3></td>
								<td class="td"><c:if test="${item.banswerImg == null}">亲！！！问题没解决，木有图片。。</c:if>
									<c:if test="${item.banswerImg != null}">
										<a href="${item.banswerImg}" target="_blank"><img
											src="${item.banswerImg}" id="img5" height="100" width="100" /></a>
									</c:if></td>
							</tr>
						</c:forEach>
					</table>
					<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
				</form>
			</div>
		</div>
	</div>
</body>
<script>
	//图片上传预览    IE是用了滤镜。
	function previewImage(file) {
		var MAXWIDTH = 90;
		var MAXHEIGHT = 90;
		var div = document.getElementById('preview');
		if (file.files && file.files[0]) {
			div.innerHTML = '<img id=imghead onclick=$("#previewImg").click()>';
			var img = document.getElementById('imghead');
			img.onload = function() {
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT,
						img.offsetWidth, img.offsetHeight);
				img.width = rect.width;
				img.height = rect.height;
				//                 img.style.marginLeft = rect.left+'px';
				img.style.marginTop = rect.top + 'px';
			}
			var reader = new FileReader();
			reader.onload = function(evt) {
				img.src = evt.target.result;
			}
			reader.readAsDataURL(file.files[0]);
		}

		else //兼容IE
		{
			var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
			file.select();
			var src = document.selection.createRange().text;
			div.innerHTML = '<img id=imghead>';
			var img = document.getElementById('imghead');
			img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
			alert(src);
			var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
					img.offsetHeight);
			status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width
					+ ',' + rect.height);
			div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
		}
	}
	function clacImgZoomParam(maxWidth, maxHeight, width, height) {
		var param = {
			top : 0,
			left : 0,
			width : width,
			height : height
		};
		if (width > maxWidth || height > maxHeight) {
			rateWidth = width / maxWidth;
			rateHeight = height / maxHeight;

			if (rateWidth > rateHeight) {
				param.width = maxWidth;
				param.height = Math.round(height / rateWidth);
			} else {
				param.width = Math.round(width / rateHeight);
				param.height = maxHeight;
			}
		}
		param.left = Math.round((maxWidth - param.width) / 2);
		param.top = Math.round((maxHeight - param.height) / 2);
		return param;
	}
</script>

</html>