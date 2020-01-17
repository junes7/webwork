<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">				
	<%	for(int i=1; i<=10; i++){%>
	<tr>
		<td>
			<h1><%= i %></h1>
		</td>
	</tr>
	<%	}	%>
		
	</table>
</body>
</html>