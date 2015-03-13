<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>weather.jsp</title>
<style type="text/css">
	table{
		border: 1px solid red;
		border-collapse: collapse; 
		width: 50%;
	}
	th,td{
		border: 1px dotted blue;
		padding: 2px;
		text-transform: uppercase;
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
<h1>날씨 정보 조회 결과</h1>
<hr>
${requestScope.weather.forecasts[0].low }<br>
${requestScope.weather.forecasts[0].high }<br>
${requestScope.weather.forecasts[0].date}<br>

<h1>WEATHER</h1>
<hr>
<h3>Current Weather</h3>
<table>
	<tr>
		<th>temperature</th><th>skycode</th><th>skytext</th><th>date</th>
		<th>observationtime</th><th>observationpoint</th><th>feelslike</th>
		<th>humidity</th><th>winddisplay</th><th>day</th><th>shortday</th>
		<th>windspeed</th>
	</tr>
	<tr>
		<td>	${	weather.	current.	 temperature 	}	</td>
		<td>	${	weather.	current.	 skycode 	}	</td>
		<td>	${	weather.	current.	 skytext	}	</td>
		<td>	${	weather.	current.	 date	}	</td>
		<td>	${	weather.	current.	observationtime	}	</td>
		<td>	${	weather.	current.	 observationpoint	}	</td>
		<td>	${	weather.	current.	 feelslike	}	</td>
		<td>	${	weather.	current.	 humidity	}	</td>
		<td>	${	weather.	current.	 winddisplay 	}	</td>
		<td>	${	weather.	current.	 day	}	</td>
		<td>	${	weather.	current.	 shortday	}	</td>
		<td>	${	weather.	current.	 windspeed	}	</td>		
	</tr>
</table>
<hr>
<h3>Forecasts</h3>
<c:forEach var="forecast" items="${weather.forecasts}">
	${forecast.date }<br>
	<table>
	<tr>
	<th>	 low	</th>
	<th>	 high 	</th>
	<th>	 skycodeday 	</th>
	<th>	 skytextday 	</th>
	<th>	 date 	</th>
	<th>	 day 	</th>
	<th>	 shortday 	</th>
	<th>	 precip	</th>	
	</tr>
	<tr>	
	<td>	${forecast.	 low	}	</td>
	<td>	${forecast.	 high 	}	</td>
	<td>	${forecast.	 skycodeday 	}	</td>
	<td>	${forecast.	 skytextday 	}	</td>
	<td>	${forecast.	 date 	}	</td>
	<td>	${forecast.	 day 	}	</td>
	<td>	${forecast.	 shortday 	}	</td>
	<td>	${forecast.	 precip	}	</td>
	</tr>
	</table>	
</c:forEach>
</body>
</html>