// JavaScript Document
function complete(pass,rpass,text)
{
	var pass=document.getElementsByName("pass")[0];
	var rpass=document.getElementsByName("rpass")[0];
	var text = document.getElementsByName("text")[0];
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

/*function checkForm(form)
{
	for(var i = 0;i<form.elements.length;i++){
		if(form.elements[i].type == "text" && form.elements[i].value == ""){
				alert("请输入用户名！");
				return false;
		}
		if(form.elements[i].type == "password" && form.elements[i].value == ""){
				alert("请输入密码！");
				return false;
		}
	}
	return true;
}
function a()
{
	alert("注册成功！");
}
*/