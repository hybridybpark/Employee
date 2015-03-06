<%@page import="webapp.model.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<hr>
deptno = ${requestScope.dept.deptno}<br>
dname = ${requestScope.dept.dname}<br>
loc = ${requestScope.dept.loc}<br>
<hr>
<c:forEach var="e" items="${requestScope.dept.emps}">
	Empno = ${pageScope.e.empno}<br>
	Ename = ${pageScope.e.ename}<br>
</c:forEach>
</body>
</html>