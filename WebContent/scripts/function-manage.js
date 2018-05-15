// JavaScript Document
//用户脚本区
function userDelete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "deletebyid_user_h?id=" + id;
	}
}
function userUpdate()
{
	var name=document.frm.name.value;
	var pwd=document.frm.password.value;
	var name1=document.getElementById("yz_user_name_update_h");
	var pwd1=document.getElementById("yz_user_password_update_h");
	if(name.trim().length==0){name1.innerHTML="姓名不能为空!";name1.className="error";return false;}
	if(pwd.trim().length==0){pwd1.innerHTML="密码不能为空!";pwd1.className="error";return false;}
}
function userAdd(){
		var id=document.frm.id.value;
		var name=document.frm.name.value;
		var pwd=document.frm.password.value;
		var id1 = document.getElementById("yz_user_id_h");
		var name1=document.getElementById("yz_user_name_h");
		var pwd1=document.getElementById("yz_user_password_h");
		if(id.trim().length==0){id1.innerHTML="用户名不能为空!";id1.className="error";return false;}
		if(name.trim().length==0){name1.innerHTML="姓名不能为空!";name1.className="error";return false;}
		if(pwd.trim().length==0){pwd1.innerHTML="密码不能为空!";pwd1.className="error";return false;}
}


///留言脚本区
function commentDelete(id){
	if(confirm("确定要删除吗？")) {
		location.href = "deletebyid_comment_h?id=" + id;
	}
}
///新闻脚本区
function newsDelete(id){
	if(confirm("确定要删除吗？")) {
		location.href = "deletebyid_news_h?id=" + id;
	}	
}
function newsUpdate(){
	var title=document.frm.title.value;
	var content=document.frm.content.value;
	if(title.trim().length==0||title=="新闻标题不能为空"){
		document.frm.title.value="新闻标题不能为空";
		return false;
	}
	if(content.trim().length==0||content=="新闻内容不能为空"){
		document.frm.content.value="新闻内容不能为空";
		return false;
	}
}
////订单脚本区
function orderDelete(id){
	if(confirm("确定要删除吗？")) {
		location.href = "deletebyid_order_h?id=" + id;
	}	
}

////商品分类管理区
function productClassDelete(id){
	if(confirm("确定要删除吗？")) {
		location.href = "deletebyid_productclass_h?id=" + id;
	}	
}
function productClassAdd(){
	var name=document.frm.name.value;
	if(name.trim().length==0||name.trim()=="不能为空"){
		document.frm.name.value="不能为空";
		return false;
	}
}
function productClassUpdate(){
	var parentid=document.frm.parentid.value;
	if(parentid=='0'){
		document.getElementById("parent").innerHTML="请选择父类";
		return false;
	}
	var name=document.frm.name.value;
	if(name.trim().length==0){
		document.getElementById("parentname").innerHTML="名称不能为空";
		return false;
	}
}
//商品脚本区
function productDelete(id){
	if(confirm("确定要删除吗？")) {
		location.href = "deletebyid_product_h?id=" + id;
	}	
}
function productAdd(){
	
	var name=document.frm.name.value;
	
	if(name.trim().length==0){
		document.getElementById("add_product_name_h").innerHTML="商品名不能为空！";
		document.getElementById("add_product_name_h").className = "error";
		return false;}
	var parentMaxId=document.frm.parentMaxId.value;
	var parentMinId=document.frm.parentMinId.value;
	if(parentMaxId==0||parentMinId==0){
		document.getElementById("add_product_parentid_h").innerHTML="请选择分类！";
		document.getElementById("add_product_parentid_h").className = "error";
		return false;}
	 var filename=document.frm.filename.value;
	    if(filename.trim().length==0){
			document.getElementById("add_product_filename_h").innerHTML="请选择图片！";
			document.getElementById("add_product_filename_h").className = "error";
			return false;}
    var price=document.frm.price.value;
    if(price.trim().length==0){
		document.getElementById("add_product_price_h").innerHTML="元          商品价格不能为空！";
		document.getElementById("add_product_price_h").className = "error";
		return false;}
    if(isNaN(price)){
		document.getElementById("add_product_price_h").innerHTML="元         只能为数字！";
		document.getElementById("add_product_price_h").className = "error";
		return false;}
    var stock=document.frm.stock.value;
    if(isNaN(stock)){
		document.getElementById("add_product_stock_h").innerHTML="只能为数字！";
		document.getElementById("add_product_stock_h").className = "error";
		return false;}
    if(stock.trim().length==0){
		document.getElementById("add_product_stock_h").innerHTML="库存不能为空！";
		document.getElementById("add_product_stock_h").className = "error";
		return false;}
}

function productUpdate(){
	
	var name=document.frm.name.value;
	
	if(name.trim().length==0){
		document.getElementById("update_product_name_h").innerHTML="商品名不能为空！";
		document.getElementById("update_product_name_h").className = "error";
		return false;}
	var parentMaxId=document.frm.parentMaxId.value;
	var parentMinId=document.frm.parentMinId.value;
	if(parentMaxId==0||parentMinId==0){
		document.getElementById("update_product_parentid_h").innerHTML="请选择分类！";
		document.getElementById("update_product_parentid_h").className = "error";
		return false;}
    var price=document.frm.price.value;
    if(price.trim().length==0){
		document.getElementById("update_product_price_h").innerHTML="元          商品价格不能为空！";
		document.getElementById("update_product_price_h").className = "error";
		return false;}
    if(isNaN(price)){
		document.getElementById("update_product_price_h").innerHTML="元         只能为数字！";
		document.getElementById("update_product_price_h").className = "error";
		return false;}
    var stock=document.frm.stock.value;
    if(isNaN(stock)){
		document.getElementById("update_product_stock_h").innerHTML="只能为数字！";
		document.getElementById("update_product_stock_h").className = "error";
		return false;}
    if(stock.trim().length==0){
		document.getElementById("update_product_stock_h").innerHTML="库存不能为空！";
		document.getElementById("update_product_stock_h").className = "error";
		return false;}
}
