<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><base>
<link rel="stylesheet" href="css/index3.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<title>Insert title here</title>
</head>
<body>
 <form:form action="add.do" method="post" modelAttribute="cai">
   <table>
     <tr>
       <td>
       菜名
       </td>
       <td>
      <form:input path="name"/>
      <form:errors path="name"></form:errors>  
       </td>
     </tr>
     
     <tr>
       <td>
      价格
       </td>
       <td>
      <form:input path="price"/>
      <form:errors path="price"></form:errors>  
       </td>
     </tr>
     <tr>
      <td>
      <form:checkboxes items="${list }" path="lids" itemLabel="name" itemValue="lid"/>
      <form:errors path="lids"></form:errors>  
       
      </td>
     </tr>
   
   </table>
    
 <form:button>添加</form:button>
 </form:form>
  

</body>
</html>