<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>支付宝-少卿消息发送页面</title>
</head>
<body>
   
     消息发送表单页面
     
     <form action="push.do" enctype="application/x-www-form-urlencoded" method="post">
 		 <p>消息内容: <input type="text" name="content" /></p>
 		 <input type="submit" value="Submit" />
     </form>

</body>
</html>