<%@page import="webapp.model.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>infoAllWithEmps.jsp</title>
<style type="text/css">
	table{
		border: 1px solid red;
		border-collapse: collapse;
		width: 50%; 
	}
	th,td{
		border: 1px dotted blue;
		padding: 2px;
		text-align: center;
	}
</style>
</head>
<body>
<hr>
<h1>부서정보</h1>
<hr>

<c:forEach var="dept" items="${requestScope.deptList }">
	<h3>DNAME = ${dept.dname}</h3><br>
	DEPTNO = ${dept.deptno}<br>	
	LOC = ${dept.loc}<br>	
	
	<table>
		<tr><th>EMPNO</th><th>ENAME</th><th>JOB</th><th>MGR</th><th>HIREDATE</th><th>SAL</th><th>COMM</th></tr>
		
			<c:forEach var="emp" items="${dept.emps}">
				<tr>
					<td>${emp.empno}</td><td>${emp.ename}</td><td>${emp.job}</td><td>${emp.mgr }</td><td>${emp.hiredate }</td><td>${emp.sal }</td><td>${emp.comm}</td>		
				</tr>
			</c:forEach>			
	</table>	
	<hr>
</c:forEach>
</body>
</html>