<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理员页面</title>
</head>
<body>
	亲爱的: <strong>${user}</strong>, 欢迎登录管理员页面.
	<a href="<c:url value="/security/logout" />">Logout</a>
</body>
</html>