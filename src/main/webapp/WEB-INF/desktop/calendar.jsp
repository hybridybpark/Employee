<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>calendar.jsp</title>
<script type="text/javascript">

	function showCalendar(y, m) {
	    var text = '<table>\n<tr>';	    
	    for (i = 0; i < 42; i++) {
	        if (i%7==0) text += '</tr>\n<tr>';
	        if (i < d1 || i >= d1+(m*9-m*9%8)/8%2+(m==2?y%4||y%100==0&&y%400?28:29:30)){
	            text += '<td> </td>';}
	        else{
	            text += '<td' + (i%7 ? '' : ' style="color:red;"') + '>' + (i+1-d1) + '</td>';}
	    }
	    document.getElementById('result').innerHTML = text + '</tr>\n</table>';
	}
 
	 
	function changeListener() {
		//alert(this.value);
		var d = new Date(year.value,month.value ,1);
		d.setDate(d.getDate()-1);		
		var options="";
		for(var i=0; i<d.getDate();i++){
			options += "<option>"+(i+1)+" 일</option> \n";
		}
		//alert(d);
		dateS.innerHTML = options;
		////
		var resultText = '<table>\n<tr>';
		d.setDate(1);
		var m = d.getMonth();
		var check=true;
		while(check){
			resultText += d.getDate();
			d.setDate(d.getDate()+1);			
			if(d.getMonth != m+1){
				check=false;
			}
		}
		
		result.innerText = d+"\n"+resultText;
		//showCalendar(year.value,month.value);
	};
	window.onload = function() {
		var year = document.querySelector("select[name=year]");
		var month = document.querySelector("select[name=month]");
		var date = document.querySelector("select[name=date]");
		
		year.onchange = changeListener;
		month.onchange = changeListener;
	};
</script>
</head>
<body>
<hr>
<h1>Calendar</h1>
<hr>
<input type="range" min="2000" max="2100" value="2015">

<input type="number" min="2000" max="2100" value="2015">

<hr>
<%
	Date current = new Date();
	pageContext.setAttribute("current", current);
%>
<select name="year">
	<c:forEach var="year" begin="2000" end="2100" >
		<c:if test="${year == current.year+1900}">
			<option value="${year}" selected="selected">${year} 년도</option>
		</c:if>
		<c:if test="${year != current.year+1900}">
			<option value="${year}">${year} 년도</option>
		</c:if>
	</c:forEach>
</select>
<select name="month">
	<c:forEach var="month" begin="1" end="12" >
		<c:if test="${month == current.month+1}">
			<option value="${month}" selected="selected">${month} 월</option>
		</c:if>
		<c:if test="${month != current.month+1}">
			<option value="${month}">${month} 월</option>
		</c:if>
	</c:forEach>
</select>

<select name="date" id="dateS">
	<c:forEach var="date" begin="1" end="31" >
		<c:if test="${date == current.date}">
			<option value="${month}" selected="selected">${date} 일</option>
		</c:if>
		<c:if test="${date != current.date}">
			<option value="${date}">${date} 일</option>
		</c:if>
	</c:forEach>
</select>

<div id="result" style="border: 1px solid red; height: 100px;">
	<p>년도 와 월을 선택해 주세요</p>
</div>
</body>
</html>