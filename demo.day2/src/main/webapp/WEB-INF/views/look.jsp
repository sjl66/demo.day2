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
</head>
<body>
  <table>
    <tr>
          
          <td>ID</td>
          <td>名称</td>
          <td>主料</td>
          <td>价格</td>
             
       </tr>
       
       <tr>
      
         <td>${list.cid }</td>
         <td>${list.name }</td>
         <td>
         <c:forEach items="${list.liao}" var="l">
         ${l.name }
         </c:forEach>
         </td>
         <td>${list.price }</td>
     
       </tr>
       
       <tr>
    
		
	</tr>
  </table>
   




</body>
</html>