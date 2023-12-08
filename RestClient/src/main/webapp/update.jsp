<%@page import="com.bean.Author"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Author a=(Author)request.getAttribute("a");
%>
<form name="frm" method="post" action="Authorcontroller">
<table>
<tr>
<td><input type="hidden" name="eid" value="<%=a.getId()%>"></td>
</tr>
<tr>
<td>Title Name</td>
<td><input type="text" name="fname" value="<%=a.getTname()%>"></td>
</tr>

<tr>
<td>Author Name</td>
<td><input type="text" name="lname" value="<%=a.getAname()%>"></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" name="action" value="UPDATE">
</td>
</tr>
</table>
</body>
</html>