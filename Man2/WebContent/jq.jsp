<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery</title>
<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
			//alert("引入JQuery脚本成功!");
			// 修改img src属性 替换成另外一个图片
			$("#deskimg").attr("src", "img/jingdong/winter.jpg");
			$("#deskimg").attr("width", 200);
			$("#deskimg").attr("height", 100);
		});
		
	function addsth(){
		
		var name = $("#name").val();
		$("#name").val("");
		
		var price = $("#price").val();
		$("#price").val("");

		var count = $("#count").val();
		$("#count").val("");

		var total = $("#total").val();
		$("#total").val("");
		
		var today = new Date();
		var id = today.getTime();
		
		var appendStr = "";
		appendStr = appendStr + "<tr id="+id+">";
		appendStr = appendStr + "<td>"+name+"</td>";
		appendStr = appendStr + "<td>"+price+"</td>";
		appendStr = appendStr + "<td>"+count+"</td>";
		appendStr = appendStr + "<td>"+total+"</td>";
		appendStr = appendStr + "<td><input type='button' name='button' value='修改' onclick='updatesth("+id+")'/>&nbsp;";
		appendStr = appendStr + "<input type='button' name='button' value='删除' onclick='delsth("+id+")'/></td>";
		appendStr = appendStr + "</tr>";
		
		$("#mylist tbody").append(appendStr); // label name: no #
		
	}
	
	function delsth(id){
		$("#"+id).remove(); 
	}
	
	/**
	*修改数据的方法
	**/
	function updatesth(id){
		// var tds = $("#"+id).children("td:first").text();
		
		// 获取tr下的td的文本
		var name = $("#"+id+" td:nth-child(1)").text();
		var price = $("#"+id+" td:nth-child(2)").text();
		var count = $("#"+id+" td:nth-child(3)").text();
		var total = $("#"+id+" td:nth-child(4)").text();
		
		// 向修改的表格中 逐一赋值
		$("#uname").val(name);
		$("#uprice").val(price);
		$("#ucount").val(count);
		$("#utotal").val(total);
		$("#uid").val(id);
		
	}
	
	/**
	**执行修改的方法
	**/
	function doupdatesth(){
		var id = $("#uid").val();
		
		// 获取修改后的数据
		var name = $("#uname").val();
		var price = $("#uprice").val();
		var count = $("#ucount").val();
		var total = $("#utotal").val();
		
		// 给列表中，对应的行 进行赋值
		$("#"+id+" td:nth-child(1)").text(name);
		$("#"+id+" td:nth-child(2)").text(price);
		$("#"+id+" td:nth-child(3)").text(count);
		$("#"+id+" td:nth-child(4)").text(total);
		
		// 清空修改表格中的文本框
		$("#uname").val("");
		$("#uprice").val("");
		$("#ucount").val("");
		$("#utotal").val("");
	}
	
	/**
	*
	*
	* 添加菜品时，自动计算总价
	**/
	function getTotalForAdd(){
		var price = $("#price").val();
		var count = $("#count").val();
		// 判断输入的字符是否是数字 只有满足都是数字的情况下，才进行计算
		if($.isNumeric(price) && $.isNumeric(count)){
			var total = parseFloat(price) * parseFloat(count);
			$("#total").val(total);
			return;
		}
	}
	
	/**
	*
	*
	* 修改菜品时，自动计算总价
	**/
	function getTotalForUpdate(){
		var uprice = $("#uprice").val();
		var ucount = $("#ucount").val();
		// 判断输入的字符是否是数字 只有满足都是数字的情况下，才进行计算
		if($.isNumeric(uprice) && $.isNumeric(ucount)){
			var utotal = parseFloat(uprice) * parseFloat(ucount);
			$("#utotal").val(utotal);
			return;
		}
	}
	
	function getname(){
		var username = $("#name").val();
		alert(username);
		/**
			$("#name").val("两只老虎");
			
		
		**/
	}
		
</script>
</head>
<body>
<h3>JQuery示例页面</h3>

<img id="deskimg" src="img/jingdong/logo-201305-jingdong2.png">
<input type="button" name="button" id="button" onclick="getname()" value="获取name的值" />
<table id="myform" border="1px">
		<caption>菜品添加</caption>
	<thead>
		<tr>
			<td>名称</td>
			<td>单价</td>
			<td>数量</td>
			<td>总价</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><input type="text" name="name" id="name" value="" /></td>
			<td><input type="text" name="price" id="price" value="" onkeypress="getTotalForAdd()" /></td>
			<td><input type="text" name="count" id="count" value="" onkeypress="getTotalForAdd()" /></td>
			<td><input type="text" name="total" id="total" value="" readonly="readonly" /></td>
		</tr>
	</tbody>
		<tr>
			<td colspan="10"><input type="button" name="button" id="button" onclick="addsth()" value="添加" /></td>
		</tr>
</table>

<br />
<hr />
<br />

<table id="myupdate" border="1px">
	<caption>菜品修改</caption>
	<thead>
		<tr>
			<td>名称</td>
			<td>单价</td>
			<td>数量</td>
			<td>总价</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><input type="text" name="uname" id="uname" value="" /></td>
			<td><input type="text" name="uprice" id="uprice" value="" onchange="getTotalForUpdate()"/></td>
			<td><input type="text" name="ucount" id="ucount" value="" onchange="getTotalForUpdate()"/></td>
			<td><input type="text" name="utotal" id="utotal" value="" readonly="readonly" /></td>
		</tr>
		<input type="hidden" name="uid" id="uid" value="" />
	</tbody>
		<tr>
			<td colspan="10"><input type="button" name="button" id="button" onclick="doupdatesth()" value="修改" /></td>
		</tr>
</table>

<br />
<hr />
<br />

<table id="mylist" border="1px">
	<thead>
		<tr>
			<td>名称</td>
			<td>单价</td>
			<td>数量</td>
			<td>总价</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>糯米香红豆粥</td>
			<td>6.00</td>
			<td>1</td>
			<td>6.00</td>
			<td>&nbsp;</td>
		</tr>
	</tbody>
</table>


</body>
</html>