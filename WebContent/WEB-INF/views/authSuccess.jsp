<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>绑定提交结果页面</title>
</head>
<body>

   <h1>绑定成功页面</h1>
   <h2>
     协议号：<c:out value="${agreementId}"></c:out>
     消息发送结果:<c:out value="${pushMsg}"></c:out>
   </h2>
   

</body>
</html>