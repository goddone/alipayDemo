<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<meta name="viewport" content="width=device-width, user-scalable=yes" />
<title>支付宝-少卿外部户绑定页面</title>
</head>
<body>
   
     外部户绑定表单页面
     
     <form action="commitAuth.do" enctype="application/x-www-form-urlencoded" method="post">
         <p>姓名: <label><c:out value="${userName}"/></label></p>
 		 <p>支付宝账号: <label><c:out value="${loginId}"/></label></p>
   		 <p>卡号: <input type="text" name="cardno" /></p>
 		 <p>密码: <input type="text" name="password" /></p>
 		 <p><input type="hidden" name="userId"  value="${userId}" /></p>
 		 <input type="submit" value="Submit" />
     </form>

</body>
</html>