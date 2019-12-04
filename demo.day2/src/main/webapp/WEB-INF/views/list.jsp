<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/index3.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
  function fenye(currentPage) {
	  
	  $("[name='currentPage']").val(currentPage);
	  
	  $("form").submit();
}
function toadd() {
	location="toadd.do";
	
}
function bian(id) {
	location="toUpdate.do?id="+id;
}
function shan(id) {
	if(confirm("确定删除吗")){
	$.post("delete.do",{ids:id},function(arr){
		if(arr){
			alert("删除成功");
			location="list.do"
		}
	},"json")
	}
}
function quan(own){
	$("[name=aa]").attr("checked",own.checked);	
}

function dels() {
	
	var ids=$("[name=aa]").map(function(){
		 return this.value
	 }).get().join();
	if(confirm("确定删除吗")){
	$.post("delete.do",{ids:ids},function(arr){
		if(arr){
			alert("删除成功");
			location="list.do";
		}
	},"json")	
	}
}
function look(id) {
	window.open("look.do?id="+id);
}
</script>
</head>
<body>
<input type="button" value="添加" onclick="toadd()">
<form action="list.do" method="post">
 <input type="hidden" name="currentPage">
 <input type="text" name="mohu" value="${mohu}">
  <button>搜索</button>
</form>
   <table>
       <tr>
          <td>
          <input type="checkbox" onclick="quan(this)">全选
          </td>
          <td>ID</td>
          <td>名称</td>
          <td>主料</td>
          <td>价格</td>
          <td>操作</td>      
       </tr>
       <c:forEach items="${list }" var="li">
       <tr>
         <td><input type="checkbox" name="aa" value="${li.cid }"></td>
         <td>${li.cid }</td>
         <td>${li.name }</td>
         <td>
         <c:forEach items="${li.liao}" var="l">
         ${l.name }
         </c:forEach>
         </td>
         <td>${li.price }</td>
         <td>
          <input type="button" value="查看" onclick="look(${li.cid})">
          <input type="button" value="编辑" onclick="bian(${li.cid})">
          <input type="button" value="删除" onclick="shan(${li.cid})">
         </td>
       
       
       </tr>
       </c:forEach>
       <tr>
    
		<td colspan="10">
			<button onclick="fenye(1)">首页</button>
			<button onclick="fenye(${pageInfo.prePage==0?1:pageInfo.prePage})">上一页</button>
			<button onclick="fenye(${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage})">下一页</button>
			<button onclick="fenye(${pageInfo.pages})">尾页</button>  &nbsp;&nbsp;&nbsp;&nbsp;
			第${pageInfo.pageNum}/${pageInfo.pages},共${pageInfo.total}条	
			<input type="button" value="批量删除"  onclick="dels()">
					
		</td>
	</tr>

   </table>

</body>
</html>