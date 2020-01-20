<%@page import="member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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
		//서블릿이 공유해준 ArrayList<DeptDTO>객체 가져오기
		ArrayList<MemberDTO> memberlist = (ArrayList<MemberDTO>)request.getAttribute("memberlist");
		int size = memberlist.size();
		//서블릿을 거치지 않고 들어오면 어디로 보내줄 지 모르기 때문에 null pointer exception이 발생한다.
		//500번은 run time 오류이다.
	%>
	
	<h1 align='center'>부서 목록 보기~~</h1>
	<hr/>
	<table border="1" align="center" width="500px" >
	<tr>
	<th>ID</th><th>PASS</th><th>이름</th>
	<th>주소</th><th>부서번호</th><th>등급</th>
	<th>포인트</th><th>삭제</th>
	</tr>
	<%	for(int i=0; i< size; i++){ 
		MemberDTO member = memberlist.get(i);
	%>	
	<tr>
		<td><%= member.getId() %></td>
		<td><%= member.getPass() %></td>
		<td><a href="/serverweb/member/read.do?id=<%= member.getId() %>"><%= member.getName() %></a></td>
		<td><%= member.getAddr() %></td>
		<td><%= member.getDeptno() %></td>
		<td><%= member.getGrade() %></td>
		<td><%= member.getPoint() %></td>
		<td><a href="/serverweb/member/delete.do?id=<%= member.getId() %>">삭제</a></td>
	</tr>
	<%	}	%>
	</table>
	
</body>
</html>