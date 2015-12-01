
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head><title>注册</title></head>
<body>

<br />
<br />
<c:url var="saveUser1" value="/user/save.html" />
<form:form modelAttribute="user" method="POST" action="${login}">
	
	
	<form:label path="nickName">昵称：</form:label>
	<form:input path="nickName"></form:input>
	<br />
	<form:label path="password">密码：</form:label>
	<form:password path="password"></form:password>
	<br />
	
	
	<input type="submit" value="登录" />
	
</form:form>

</body>
</html>
\ No newline at end of file