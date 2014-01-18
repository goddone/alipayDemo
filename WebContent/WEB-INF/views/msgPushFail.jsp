<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>消息推送失败</title>
</head>
<body>

  <h1>推送信息失败,失败原因：</h1><br>
  <h2>
   <c:out value="${errorCode}" />
   <c:out value="${errorMsg}"></c:out><br>
  </h2>
</body>
</html>