<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表页面</title>
<script> 
function Page(iAbsolute,sTableId,sTBodyId,page) 
{ 
    this.absolute = iAbsolute; //每页最大记录数 
    this.tableId = sTableId; 
    this.tBodyId = sTBodyId; 
    this.rowCount = 0;//记录数 
    this.pageCount = 0;//页数 
    this.pageIndex = 0;//页索引 
    this.__oTable__ = null;//表格引用 
    this.__oTBody__ = null;//要分页内容 
    this.__dataRows__ = 0;//记录行引用 
    this.__oldTBody__ = null; 
    this.__init__(); //初始化; 
}; 
/**//* 
初始化 
*/ 
Page.prototype.__init__ = function(){ 
this.__oTable__ = document.getElementById(this.tableId);//获取table引用 
this.__oTBody__ = this.__oTable__.tBodies[this.tBodyId];//获取tBody引用 
this.__dataRows__ = this.__oTBody__.rows; 
this.rowCount = this.__dataRows__.length; 
try{ 
this.absolute = (this.absolute <= 0) || (this.absolute>this.rowCount) ? this.rowCount : this.absolute; 
this.pageCount = parseInt(this.rowCount%this.absolute == 0 ? this.rowCount/this.absolute : this.rowCount/this.absolute+1); }catch(exception){} 
this.__updateTableRows__(); 
}; 
Page.prototype.GetBar=function(obj) 
{ 
var bar= document.getElementById(obj.id); 
bar.innerHTML= "每页"+this.absolute+"条/共"+this.rowCount+"条";// 第2页/共6页 首页 上一页 1 2 3 4 5 6 下一页 末页 
} 
/**//* 
下一页 
*/ 
Page.prototype.nextPage = function(){ 
if(this.pageIndex + 1 < this.pageCount){ 
this.pageIndex += 1; 
this.__updateTableRows__(); 
} 
}; 
/**//* 
上一页 
*/ 
Page.prototype.prePage = function(){ 
if(this.pageIndex >= 1){ 
this.pageIndex -= 1; 
this.__updateTableRows__(); 
} 
}; 
/**//* 
首页 
*/ 
Page.prototype.firstPage = function(){ 
if(this.pageIndex != 0){ 
this.pageIndex = 0; 
this.__updateTableRows__(); 
} 
}; 
/**//* 
尾页 
*/ 
Page.prototype.lastPage = function(){ 
if(this.pageIndex+1 != this.pageCount){ 
this.pageIndex = this.pageCount - 1; 
this.__updateTableRows__(); 
} 
}; 
/**//* 
页定位方法 
*/ 
Page.prototype.aimPage = function(){ 
var abc = document.getElementById("pageno"); 
var iPageIndex = abc.value; 
var iPageIndex = iPageIndex*1; 
if(iPageIndex > this.pageCount-1){ 
this.pageIndex = this.pageCount -1; 
}else if(iPageIndex < 0){ 
this.pageIndex = 0; 
}else{ 
this.pageIndex = iPageIndex-1; 
} 
this.__updateTableRows__(); 
}; 
/**//* 
执行分页时，更新显示表格内容 
*/ 
Page.prototype.__updateTableRows__ = function(){ 
var iCurrentRowCount = this.absolute * this.pageIndex; 
var iMoreRow = this.absolute+iCurrentRowCount > this.rowCount ? this.absolute+iCurrentRowCount - this.rowCount : 0; 
var tempRows = this.__cloneRows__(); 
var removedTBody = this.__oTable__.removeChild(this.__oTBody__); 
var newTBody = document.createElement("TBODY"); 
newTBody.setAttribute("id", this.tBodyId); 
for(var i=iCurrentRowCount; i < this.absolute+iCurrentRowCount-iMoreRow; i++){ 
newTBody.appendChild(tempRows[i]); 
} 
this.__oTable__.appendChild(newTBody); 
this.__dataRows__ = tempRows; 
this.__oTBody__ = newTBody; 
//页脚显示分 
var divFood = document.getElementById("divFood");//分页工具栏 
divFood.innerHTML=""; 
var rightBar = document.createElement("divFood"); 
rightBar.setAttribute("display",""); 
rightBar.setAttribute("float","left"); 
rightBar.innerHTML="第"+(this.pageIndex+1)+"页/共"+this.pageCount+"页"; 
var isOK="Y"; 
var cssColor=""; 
divFood.appendChild(rightBar); 
////页脚显示分页结 
}; 
/**//* 
克隆原始操作行集合 
*/ 
Page.prototype.__cloneRows__ = function(){ 
var tempRows = []; 
for(var i=0; i<this.__dataRows__.length; i++){ 
tempRows[i] = this.__dataRows__[i].cloneNode(1); 
} 
return tempRows; 
}; 
</script> 
<script type="text/javascript" language="javascript"> 
window.onload = function(){ 
page = new Page(5,'senfe','group_one'); }; 
</script> 

 <script type="text/javascript">

	function doDelete(eId) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			//window.location.href="DeleteServlet?sid="+sid;
			location.href="DeleteStudentServlet?eId="+eId;
		}
	}
</script> 
<style type="text/css">
.tab{
	
	padding-top:5px;
}
td{
	text-align:center;
	vertical-align:middle;
}
a:link {
	color: #306;
	text-decoration: none;
	display:inline-block;
	-moz-box-shadow: -4px -4px 10px #333333;
	-webkit-box-shadow: -4px -4px 10px #333333;
	box-shadow: -4px -4px 10px #333333;
	font-family:"微软雅黑";
	background-color:#288be3;
	padding:3px;
}
a:visited {
	text-decoration: none;
	color: #306;
	background-color:#288be3;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
</style>
</head>
<body>

<form action="SearchStudentServlet" method="post">
		<table width="1040" border="0" cellspacing="10" class="tab" id="senfe">
		<thead>
		<tr >
			<td colspan = "8"style="text-align:left; background-color:#1285ec; padding-left:10px;">
				按姓名查询:<input type="text" name="eName"/>
				&nbsp;
				按性别查询:<select name="eSex">
							<option value="">--请选择--
							<option value="男">男
							<option value="女">女
						  </select>
				&nbsp;&nbsp;&nbsp;
				<input type="submit" value="刷新/查询">
				&nbsp;&nbsp;&nbsp;
			<a href="add.jsp"  style="margin-top:5px;">添加</a>
			</td>
		</tr> 
			 <tr align="center">
			<td width="110" style="background-color:#288be3;">编号</td>
			<td  width="110" style="background-color:#288be3;">姓名</td>
			<td  width="110" style="background-color:#288be3;">性别</td>
			<td  width="110" style="background-color:#288be3;">年龄</td>
			<td width="110" style="background-color:#288be3;">电话1	</td>
			<td width="110" style="background-color:#288be3;">电话2</td>
			<td  width="110" style="background-color:#288be3;">电话3</td>
			<td  width="110" style="background-color:#288be3;">地址</td>
			<td  width="110" style="background-color:#288be3;">操作</td>
		  </tr>
		  </thead> 
		  <tbody id="group_one"> 
		 <c:forEach items="${list }" var="ads">
				  <tr align="center">
					<td>${ads.eId }</td>
					<td>${ads.eName }</td>
					<td>${ads.eSex }</td>
					<td>${ads.eAge }</td>
					<td>${ads.eTell1 }</td>
					<td>${ads.eTell2 }</td>
					<td>${ads.eTell3 }</td>
					<td>${ads.eAddress }</td>
				  <td> <table width="148" align="center" cellspacing="10">
                   <tr><td width="47" class="mbbutton"><a href="EditStudentServlet?eId=${ads.eId }"><strong>更新</strong></a> </td> 
                   <td width="42" class="mbbutton"><a href="#" onclick="doDelete(${ads.eId})">删除</a></td></tr>
                    </table>
                 </td> 
				  </tr>
		 	</c:forEach>
		 	</tbody> 
		  </table>
	  </form>
	  
	  <div><a href="#" onclick="page.firstPage();">首 页</a>/
	  <a href="#" onclick="page.prePage();">上一页</a>/
	  <a href="#" onclick="page.nextPage();">下一页</a>/
	  <a href="#" onclick="page.lastPage();">末 页</a><span id="divFood"> 
</span> 
/第 
<input id="pageno" value="1" style="width:20px"/>页/<a href="#" onclick="page.aimPage();">跳转</a></div> 
	  
</body>
</html>