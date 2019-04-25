<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<script type="text/javascript">
function complete()
{
	var pass=document.getElementsByName("password")[0];
	var rpass=document.getElementsByName("rpass")[0];
	var text = document.getElementsByName("userName")[0];
	if(text.value=="")
	{
		alert("请输入用户名!");
		return false;
	}
	else if(pass.value=="")
	{
		alert("请输入密码！");
		return false;
	}
	else if(pass.value!=rpass.value)
	{
		alert("两次输入的密码不一样！请重新确认密码！");
			return false;
	}
	else
	{
		alert("注册成功！");
		return true;
	}
}
</script>
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
	padding-top:100px;
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
<form action="AddUserServlet" method="post" onsubmit="complete()">
		<table width="718" height="474" border="0" cellpadding="0" cellspacing="3">
		  <tr>
		    <td width="254" height="50">&nbsp;</td>
		    <td height="50"><h1>添加新用户</h1></td>
		    <td width="223" height="30">&nbsp;</td>
		  </tr>
		  <tr>
		    <td height="50" align="right" valign="middle">用户名：</td>
		    <td width="219" height="50"><input class="text" type="text" name="userName"/></td>
		    <td height="30">&nbsp;</td>
		  </tr>
		  
		  <tr>
		    <td height="50" align="right" valign="middle">密码：</td>
		    <td width="219" height="50"><input class="text" type="password" name="password" /></td>
		    <td height="30">&nbsp;</td>
		  </tr>
		  <tr>
		    <td height="50" align="right" valign="middle">确认密码：</td>
		    <td width="219" height="50"><input class="text" type="password" name="rpass" /></td>
		    <td height="30">&nbsp;</td>
		  </tr>
		  <tr>
		    <td height="50" align="right" valign="middle">性别：</td>
		    <td width="219" height="50"><input type="radio" name="sex" value="男"/>男&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女"/>女</td>
		    <td height="30">&nbsp;</td>
		  </tr>
		  <tr>
		    <td height="50" align="right" valign="middle">年龄：</td>
		    <td width="219" height="50"><input class="text" type="number"  max="200" min="1" name="age"/></td>
		    <td height="30">&nbsp;</td>
		  </tr>
		  <tr>
		    <td height="50" align="right" valign="middle">联系方式：</td>
		    <td width="219" height="50"><input class="text" type="number" name="telnum"/></td>
		    <td height="30">&nbsp;</td>
		  </tr>
		  <tr>
		    <td height="50" align="right" valign="middle">邮箱：</td>
		    <td width="219" height="50"><input class="text" type="email" name="mail"/></td>
		    <td height="30">&nbsp;</td>
		  </tr>
		  <tr>
		    <td height="44">&nbsp;</td>
		    <td width="219" height="44"><input class="button"type="submit" value="提交"/><input class="button" type="reset" value="重置"/></td>
		    <td height="44">&nbsp;</td>
		  </tr>
		</table>
	</form>
    </div>
</div>
</body>
</html>
