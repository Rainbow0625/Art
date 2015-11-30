<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
		<th>序号</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>性别</th>
		<th>生日</th>
	<tr/>
	<c:if test="${! empty user_list}">
	<c:forEach var="user" items="${user_list}">
		<tr>
			<td><c:out value="${user.id}"/></td>
			<td><c:out value="${user.username}"/></td>
			<td><c:out value="${user.age}"/></td>
			<td><c:out value="${user.sex}"/></td>
			<td><c:out value="${user.birthday}"/></td>
			<td><a href="user/del.html?id=${user.id}">删除</a></td>
		</tr>
	</c:forEach>
	</c:if>
</table>

</body>
</html>