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
		<th>真实姓名</th>
		<th>昵称</th>
		<th>头像</th>
		<th>性别</th>
		<th>生日</th>
		<th>电话 </th>		
		<th>邮箱</th>	
		<th>艺术家种类</th>
		<th>个人介绍</th>
	<tr/>
	<c:if test="${! empty artist_list}">
	<c:forEach var="artist" items="${artist_list}">
		<tr>
			<td><c:out value="${artist.id}"/></td>
			<td><c:out value="${artist.realName}"/></td>
			<td><c:out value="${artist.nickName}"/></td>
			<td><c:out value="${artist.photo}"/></td>
			<td><c:out value="${artist.gender}"/></td>
			<td><c:out value="${artist.birthday}"/></td>
			<td><c:out value="${artist.tel}"/></td>
			<td><c:out value="${artist.email}"/></td>
			<td><c:out value="${artist.artistType}"/></td>
			<td><c:out value="${artist.introduction}"/></td>
		</tr>
	</c:forEach>
	</c:if>
</table>
</body>
</html>