<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin:0 auto;
}
#main{
	margin-left:50px;
	margin-top:50px;
	background-image:url(page/images/bg.jpg);
}
.text{
	width:200px;
	height:25px;
	 -moz-appearance: textfield;
}
.button{
	width:100px;
	height:30px;
	text-align:center;
	font-size:18px;
}
</style>
</head>

<body>
<div id="main">
<form method="post" action="UpdateStudentServlet">
	<input type="hidden" name="eId" value="${ads.eId }">
  <table width="372" border="0" cellspacing="10">
  <tr><td><h3>更新通讯簿</h3></td></tr>
  <tr>
    <td colspan="2"><hr/></td>
    </tr>
  <tr>
  	<td width="103" align="right" style="padding-right:20px;">姓名</td>
  	<td width="235"><input type="text" name="eName" class="text" required="required" value="${ads.eName }"/></td> 
  </tr>
  <tr align="right">
    <td colspan="2"><hr/></td>
    </tr>
	<tr>
	<td align="right"style="padding-right:20px;">性别</td>
	<td><input type="radio" name="eSex" value="男" <c:if test="${ads.eSex == '男'}">checked</c:if>>男
		<input type="radio" name="eSex" value="女" <c:if test="${ads.eSex == '女'}">checked</c:if>>女</td>
  </tr>
  <tr align="right">
    <td colspan="2"><hr/></td>
    </tr>
  <tr>
	<td align="right"style="padding-right:20px;">年龄</td>
	<td>
		<input type="text" name="eAge" class="text" required="required"  value="${ads.eAge} " >
	</td>
  </tr>
  <tr align="right">
    <td colspan="2"><hr/></td>
    </tr>
  <tr>
	<td align="right"style="padding-right:20px;">tell1</td>
	<td><input type="text" name="eTell1" class="text" required="required" value="${ads.eTell1 }"></td>
  </tr>
  <tr align="right">
    <td colspan="2"><hr/></td>
    </tr>
  <tr>
	<td align="right"style="padding-right:20px;">tell2</td>
	<td><input type="text" name="eTell2" class="text" required="required" value="${ads.eTell2}"></td>
  </tr>
  <tr align="right">
    <td colspan="2"><hr/></td>
    </tr>
  <tr>
	<td align="right"style="padding-right:20px;">tell3</td>
	<td><input type="text" name="eTell3" class="text" required="required" value="${ads.eTell3 }">
    </td>
  </tr>
  <tr>
    <td colspan="2"><hr/></td>
    </tr>
   <tr>
	<td align="right"style="padding-right:20px;">eAddress</td>
	<td><input type="text" name="eAddress" class="text" required="required" value="${ads.eAddress }">
    </td>
  </tr>
  <tr>
    <td colspan="2"><hr/></td>
    </tr>
   <tr>
   <td></td>
	<td> <input type="submit" value="更新" class="button"> </td>
  </tr>
  </table>
</form>
</div>
</body>
</html>
