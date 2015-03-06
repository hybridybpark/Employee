<%@page import="webapp.model.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>infoAll.jsp</title>
<style type="text/css">
	table{
		border: 1px solid red;
		border-collapse: collapse; 
		width: 50%;
	}
	th,td{
		border: 1px dotted blue;
		padding: 2px;
	}
	td:HOVER {
		background-color: orange;
	}
</style>

<script type="text/javascript">
	window.onload = function() {
		var tds = document.querySelectorAll("td");
		for(var i=0;i<tds.length;i++){
			tds[i].onclick = function() {
				if(this.style.color != "red"){
					this.style.color = "red"					
				}else{
					this.style.color = "black"
				}
				
			}
		}
	}
</script>

</head>
<body>
<hr>
<h1>부서정보</h1>
<hr>

<table>
	<tr><th>DEPTNO</th><th>DNAME</th><th>LOC</th></tr>
	<c:forEach var="dept" items="${requestScope.deptList }">
		<tr>
			<td>${dept.deptno}</td><td>${dept.dname}</td><td>${dept.loc}</td>
		</tr>			
	</c:forEach>	
</table>	
</body>
</html>