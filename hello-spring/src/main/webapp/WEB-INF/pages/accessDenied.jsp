<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>拒绝权限页面</title>
</head>
<body>
	对不起: <strong>${user}</strong>, 你无权访问这个页面
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>