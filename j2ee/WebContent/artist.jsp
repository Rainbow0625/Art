<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<table border="1" >
     <tr>
       <th>Name</th>
       <th>password</th>
       <th>IDNumber</th>
     </tr>
     <tr>
       <td>${user.userName}</td>
       <td>${user.password}</td>
       <td>${user.IDNumber}</td>
     </tr>
  </table>
</body>
</html>