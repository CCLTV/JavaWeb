<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin:0 auto;
	padding:0 auto;
}
.text{
	width:200px;
	height:30px;
	font-size:20px;
	border: #0C9 solid 1px;
}
#apdiv1{
	background-image: url(page/images/timg2.jpg);
	background-repeat:no-repeat;
	width:1024px;
	height:770px;
	
	padding-top:150px;
}
#apdiv2{
	color:#CCC;
}
.button{
	width:70px;
	height:30px;
	font-size:14px;
}
input[type="number"] {
    -moz-appearance: textfield;
}
</style>

</head>
<body>
<div id="apdiv1">
<div id="apdiv2">
<form action="UpdateUserServlet" method="post">
<table>
	<tr><td colspan="3"><h1>修改密码</h1></td></tr>
	<tr>
		    <td height="50" align="right" valign="middle">用户名：</td>
		    <td width="219" height="50"><input class="text" type="text" name="userName"/></td>
		    <td height="30">&nbsp;</td>
		  </tr>
	<tr>
		    <td height="50" align="right" valign="middle">原始密码：</td>
		    <td width="219" height="50"><input class="text" type="password" name="password" /></td>
		    <td height="30">&nbsp;</td>
		  </tr>
	<tr>
		    <td height="50" align="right" valign="middle">新密码：</td>
		    <td width="219" height="50"><input class="text" type="password" name="password" /></td>
		    <td height="30">&nbsp;</td>
		  </tr>
	
	<tr>
		    <td height="44">&nbsp;</td>
		    <td width="219" height="44"><input class="button"type="submit" value="提交"/></td>
		    <td height="44">&nbsp;</td>
		  </tr>
</table>
	
	
</form>
</div>
</div>


</body>
</html>