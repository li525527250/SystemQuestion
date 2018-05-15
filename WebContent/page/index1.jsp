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
	font-size: ， 16px
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
						<a href="page/register.jsp" class="easyui-linkbutton"
							iconAlign="right" data-options="iconCls:'icon-search'">注册用户</a>
					</c:when>
					<c:when test="${user.uauthorityid!=1}"></c:when>
				</c:choose>
				<a href="KeynoteQuestionServlet" class="easyui-linkbutton"
					iconAlign="right" data-options="iconCls:'icon-search'">查看公开问题</a> <a
					href="page/askaQuestion.jsp" class="easyui-linkbutton"
					iconAlign="right" data-options="iconCls:'icon-search'">用户提交问题</a>
				<div class="demo-info" style="margin-bottom: 10px">
					<div class="demo-tip icon-tip">&nbsp;</div>
					<div>您的意见将是我们前进的动力</div>
				</div>
			</div>
			<div class="center1">
				<form method="get" id="form3" action="FuzzyQueryQuestion">
					<table border=1 class="altrowstable" style="width: 100%;">
						<th colspan="2"><h2>按条件查询问题</h2></th>
						<tr>
							<td align="center">提问内容</td>
							<td colspan="2"><input type="text" id="neiron" name="neiron"></td>
						</tr>
						<tr>
							<td align="center">提问时间</td>
							<td colspan="2"><input id="dd" name="dd" type="text"
								class="easyui-datebox" required="required">至<input
								id="ds" name="ds" type="text" class="easyui-datebox"
								required="required"></td>
						</tr>
						<tr>
							<td align="center">提问人</td>
							<td colspan="2"><input type="text" id="tiwenren"
								name="tiwenren"></td>
						</tr>
						<tr>
							<td align="center">是否解决</td>
							<td colspan="2"><select name="jiejue">
									<option value="请选择" selected>请选择
									<option value="已解决">已解决
									<option value="未解决">未解决
							</select></td>
						</tr>
						<tr>
							<td colspan="3" align="center"><input type="button"
								value="查询问题" onclick="f3()"></td>
						</tr>
					</table>
				</form>
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
				<div>
					<div class="demo-info" style="margin-bottom: 10px"></div>
				</div>
			</div>
</body>
<script>
      //图片上传预览    IE是用了滤镜。
        function previewImage(file)
        {
          var MAXWIDTH  = 90; 
          var MAXHEIGHT = 90;
          var div = document.getElementById('preview');
          if (file.files && file.files[0])
          {
              div.innerHTML ='<img id=imghead onclick=$("#previewImg").click()>';
              var img = document.getElementById('imghead');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);
          }
          else //兼容IE
          {
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            //alert(src);
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight ){
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;
                
                if( rateWidth > rateHeight ){
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else{
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

