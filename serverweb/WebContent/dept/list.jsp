<%@page import="dept.DeptDTO"%>
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
		ArrayList<DeptDTO> deptlist = (ArrayList<DeptDTO>)request.getAttribute("deptlist");
		int size = deptlist.size();
		//서블릿을 거치지 않고 들어오면 어디로 보내줄 지 모르기 때문에 null pointer exception이 발생한다.
		//500번은 run time 오류이다.
	%>
	
	<h1 align='center'>부서 목록 보기~~</h1>
	<hr/>
	<table border="1" align="center" width="500px" >
	<tr>
	<th>부서코드</th><th>부서명</th><th>위치</th>
	<th>전화번호</th><th>관리자</th><th>삭제</th>
	</tr>
	<%	for(int i=1; i< size; i++){ 
		DeptDTO dept = deptlist.get(i);
	%>
	<tr>
		<td><%= dept.getDeptNo() %></td>
		<td><a href="/serverweb/dept/read.do?deptNo=<%= dept.getDeptNo() %>&info=한글데이터"><%= dept.getDeptName() %></a>
		<%-- <td><%= dept.getDeptName() %></td> --%>
		<td><%= dept.getLoc() %></td>
		<td><%= dept.getTel() %></td>
		<td><%= dept.getMgr() %></td>
		<td><a href="/serverweb/delete.do?deptNo=<%= dept.getDeptNo()%>">삭제</a></td>
	</tr>
	<%	}	%>
	</table>
	
</body>
</html>