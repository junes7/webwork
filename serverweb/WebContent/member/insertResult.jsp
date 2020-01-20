<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<% 
		//서블릿이 공유한 데이터 꺼내기
		int result = (int)request.getAttribute("insertResult");
	%>
	<h1><%= result %>개 삽입 성공!!</h1>
</body>
</html>