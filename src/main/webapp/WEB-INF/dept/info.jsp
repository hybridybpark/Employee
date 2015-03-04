<%@page import="webapp.model.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>info.jsp</title>
</head>
<body>
<hr>
<h1>부서정보</h1>
<hr>
<%
Dept dept = (Dept)request.getAttribute("dept");
%>
deptno = <%=dept.getDeptno()%><br>
dname = <%=dept.getDname() %><br>
loc = <%=dept.getLoc() %><br>
<hr>
deptno = ${requestScope.dept.deptno}<br>
dname = ${requestScope.dept.dname}<br>
loc = ${requestScope.dept.loc}<br>
</body>
</html>