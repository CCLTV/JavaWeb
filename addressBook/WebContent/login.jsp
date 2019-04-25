<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通讯簿管理系统</title>
<style type="text/css">
*{
	margin:0 auto;
	padding:0 auto;
}
#main {
	height: 700px;
	width: 1800spx;
	margin-top:100px;
	background-image: url(page/images/timg2.jpg);
	position:relative;
	font-size:12px;
	background-repeat:no-repeat;
}
#footer {
	width: 1200px;
	margin:auto;
	padding-top:40px;
	font-size:14px;
	color:#666;
	line-height:30px;
}
a:link{
	text-decoration:none;
	color:#666;
	margin-left:10px;
	margin-right:10px;}
a:hover{
	color: #C30;
}
#denglu1 {
	position: absolute;
	width: 349px;
	height: 354px;
	z-index: 2;
	left: 1148px;
	top: 122px;
	background-color: #EDF4FA;
}
input{
	width:290px;
	height:40px;}
.username{
	background-image: url(page/images/user.PNG);
	background-repeat:no-repeat;
	padding-left:42px;
	box-sizing:border-box;}
.psd{
	background-image: url(page/images/mima.PNG);
	background-repeat:no-repeat;
	padding-left:44px;
	box-sizing:border-box;}
.button{
	background-color:#f40;
	font-size:16px;
	color:#FFF;
	font-weight:800;
	border-color:#f40;}

#apDiv1 {
	position: absolute;
	width: 454px;
	height: 115px;
	z-index: 2;
	left: 398px;
	top: 218px;
	font-family: "微软雅黑";
	font-weight: bold;
	font-size: 72px;
	color: #CCC;
	text-align: right;
}

</style>
<script type="text/javascript">
	function checkForm(){
			var username = document.getElementsByName("username")[0];
			var password = document.getElementsByName("password")[0];
			if(username.value=="")
			{
				alert("请输入账号！");
				return false;
			}
			else if(password.value=="")
			{
				alert("请输入密码！");
				return false;
			}
			else
			return true;
	}
			
</script>
</head>

<body>
<div id="main">
  <div id="denglu1">
    <form id="form1" name="form1" method="get" action="LoginServlet" onsubmit="checkForm(this)">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" height="337">
        <tr>
          <td height="60" align="center" valign="top">&nbsp;</td>
        </tr>
        <tr>
          <td align="center"><input type="text" name="username" id="username" class="username" placeholder="请输入用户名" value=""/></td>
        </tr>
        <tr>
          <td align="center"><input type="password" name="password" id="password" placeholder="请输入密码" class="psd" /></td>
        </tr>
        <tr>
          <td align="center"><input type="submit" name="button" id="button" value="登录" class="button" /></td>
        </tr>
        <tr>
          <td><a href="adduser.jsp" style="margin-left:30px;">点击注册新用户</a></td></tr>
      </table>
    </form>
  </div>
  <div id="apDiv1">
    <p style="text-align: center">通讯簿管理</p>
    <p style="text-align: center">系统 </p>
  </div>
</div>
</body>
</html>
