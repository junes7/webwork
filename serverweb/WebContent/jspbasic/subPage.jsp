<%@page import="dept.DeptDTO"%>
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
		//서블릿이 공유한 데이터 꺼내오기
		//지금 아래와 같은 상태는 object상태이기 때문에 DeptDTO로 받을거면 (DeptDTO)로 캐스팅 해 주어야한다.
		//즉 아래의 아래는 형변환 에러이다.
		DeptDTO dept = (DeptDTO)request.getAttribute("mydata");
	%>
	<h1>요청재지정으로 실행될 페이지</h1>
	<hr/>
	<h2>공유데이터:<%= dept.getDeptName() %></h2>



</body>
</html>