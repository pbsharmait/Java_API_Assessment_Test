<%@page import="com.bean.Author"%>
<%@page import="java.util.List"%>
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
<h1 align="center">List of Employee</h1>
<table width="100%" cellpadding="10px" cellspacing="10px">
<tr>
<th>ID</th>
<th>Title Name</th>
<th>Author Name</th>

</tr>

<%
   List<Author> list=(List<Author>)request.getAttribute("list");

for(Author a:list)
{
%>
<tr>
<td><%=a.getId()%></td>
<td><%=a.getTname()%></td>
<td><%=a.getAname()%></td>
<td>
<form name="edit" method="post" action="Authorcontroller">
<input type="hidden" name="eid" value="<%=a.getId()%>">
<input type="submit" name="action" value="EDIT" class="btn btn-primary" >
</form>
</td>
<td>
<form name="delete" method="post" action="Authorcontroller">
<input type="hidden" name="eid" value="<%=a.getId()%>">
<input type="submit" name="action" value="DELETE" class="btn btn-danger">
</form>
</td>
</tr>
<%
}



%>

</table>
</body>
</html>