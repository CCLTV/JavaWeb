<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表页面</title>

<script type="text/javascript">

	function doDelete(eId) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			//window.location.href="DeleteServlet?sid="+sid;
			location.href="DeleteServletStudent?eId="+eId;
		}
	}
</script>

</head>
<body>
	<form action="SearchStudentServlet" method="post">
		<table border="1" width="700">
		
			<tr >
				<td colspan="8">
					
					按姓名查询:<input type="text" name="eName"/>
					&nbsp;
					按性别查询:<select name="eSex">
								<option value="">--请选择--
								<option value="男">男
								<option value="女">女
							  </select>
					&nbsp;&nbsp;&nbsp;
					<input type="submit" value="查询">
					&nbsp;&nbsp;&nbsp;
					<a href="add.jsp">添加</a>
				</td>
			</tr>
		
		  <tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		  </tr>
		  
			  <c:forEach items="${pageBean.list }" var="ads">
				  <tr align="center">
					<td>${ads.eId }</td>
					<td>${ads.eName }</td>
					<td>${ads.eSex }</td>
					<td>${ads.eAge }</td>
					<td>${ads.eTell1 }</td>
					<td>${ads.eTell2 }</td>
					<td>${ads.eTell3 }</td>
					<td>${ads.eAddress }</td>
					<td><a href="EditServletStudent?sid=${ads.eId }">更新</a>   <a href="#" onclick="doDelete(${ads.eId})">删除</a></td>
				  </tr>
			  </c:forEach>
			  
			  <tr>
			  	<td colspan="8">
			  		第 ${pageBean.currentPage } / ${pageBean.totalPage }
			  		&nbsp;&nbsp;
			  		每页显示${pageBean.pageSize }条  &nbsp;&nbsp;&nbsp;
			  		总的记录数${pageBean.totalSize } &nbsp;&nbsp;&nbsp;
			  		<c:if test="${pageBean.currentPage !=1 }">
			  			<a href="StudentListPageServlet?currentPage=1">首页</a>
						| <a href="StudentListPageServlet?currentPage=${pageBean.currentPage-1 }">上一页</a>
			  		</c:if>
			  		
			  		<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
			  			<c:if test="${pageBean.currentPage == i }">
			  				${i }
			  			</c:if>
			  			<c:if test="${pageBean.currentPage != i }">
			  				<a href="StudentListPageServlet?currentPage=${i }">${i }</a>
			  			</c:if>
			  		
			  		</c:forEach>
			  		
			  		
			  		<c:if test="${pageBean.currentPage !=pageBean.totalPage }">
			  			<a href="StudentListPageServlet?currentPage=${pageBean.currentPage+1 }">下一页</a> | 
			  			<a href="StudentListPageServlet?currentPage=${pageBean.totalPage }">尾页</a>
			  		</c:if>
			  	</td>
			  </tr>
		  </table>
	  </form>
</body>
</html>