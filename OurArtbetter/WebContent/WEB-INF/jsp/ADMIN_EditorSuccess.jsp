<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${message==1}">
	保存 成功!
</c:if>
<c:if test="${message==2}">
	修改更新成功!
</c:if>
<c:if test="${message==3}">
	删除 成功!
</c:if>

<a href="/OurArtbetter/ADMIN_infolist">返回</a>

</body>
</html>