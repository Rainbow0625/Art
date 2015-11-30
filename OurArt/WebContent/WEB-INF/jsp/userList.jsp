<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>

<table>
		<th>序号</th>
		<th>真实姓名</th>
		<th>昵称</th>
		<th>性别</th>
		<th>电话</th>
		<th>邮箱</th>
		<th>生日</th>
		<th>密码</th>
	<tr/>
	<c:if test="${! empty user_list}">
	<c:forEach var="user" items="${user_list}">
		<tr>
			<td><c:out value="${user.id}"/></td>
			<td><c:out value="${user.realName}"/></td>
			<td><c:out value="${user.nickName}"/></td>
			<td><c:out value="${user.gender}"/></td>
			<td><c:out value="${user.tel}"/></td>
			<td><c:out value="${user.email}"/></td>
			<td><c:out value="${user.birthday}"/></td>
			<td><c:out value="${user.password}"/></td>
		</tr>
	</c:forEach>
	</c:if>
</table>
<a href="user/add.html">注册</a>
</body>
</html>