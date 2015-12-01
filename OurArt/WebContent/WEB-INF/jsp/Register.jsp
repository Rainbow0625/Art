
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
<form:form modelAttribute="user" method="POST" action="${saveUser1}">
	
	<form:label path="realName">真实姓名：</form:label>
	<form:input path="realName"></form:input>
	<br />
	<form:label path="nickName">昵称：</form:label>
	<form:input path="nickName"></form:input>
	<br />
	<form:label path="password">密码：</form:label>
	<form:password path="password"></form:password>
	<br />
	<form:radiobutton checked="checked"  path="gender" value="male"/>男
	<form:radiobutton  path="gender" value="female"/>女
	<br />
	<form:label path="birthday">生日：</form:label>
	<form:input path="birthday"></form:input>
	<br />
	<form:label path="tel">手机号码：</form:label>
	<form:input path="tel" />
	<br />
	<form:label path="email">邮编：</form:label>
	<form:input path="email" />
	<br />
	
	<input type="submit" value="注册" />
	
</form:form>

</body>
</html>
\ No newline at end of file