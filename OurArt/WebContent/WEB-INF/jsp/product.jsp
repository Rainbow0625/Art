<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<th>序号</th>
		<th>名称</th>
		<th>种类</th>
		<th>价格</th>
		<th>简介</th>
	<tr/>
	<c:if test="${! empty product_list}">
	<c:forEach var="product" items="${product_list}">
		<tr>
			<td><c:out value="${product.productid}"/></td>
			<td><c:out value="${product.productname}"/></td>
			<td><c:out value="${product.productkind}"/></td>
			<td><c:out value="${product.productprice}"/></td>
			<td><c:out value="${product.productInformation}"/></td>
			<td><a href="product/del.html?id=${product.id}">删除</a></td>
		</tr>
	</c:forEach>
	</c:if>
</table>
</body>
</html>