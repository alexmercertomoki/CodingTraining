<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单</title>
<script src="ckeditor/ckeditor.js"></script>
<link href="ckeditor/samples/sample.css" rel="stylesheet">
</head>
<body>

<form action="AddTopic" method="post">
	<table>
		<tr>
			<td>标题</td>
			<td><input type="text" name="title" value="" /></td>
		</tr>
		<tr>
			<td>内容</td>
			<td><textarea id="content01" name="content01" cols="40" rows="10"></textarea></td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="提交" /></td>
		</tr>
	</table>
</form>
		<script>

			CKEDITOR.replace( 'content01' );

		</script>
</body>
</html>