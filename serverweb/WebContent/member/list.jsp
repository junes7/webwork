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
		//������ �������� ArrayList<DeptDTO>��ü ��������
		ArrayList<MemberDTO> memberlist = (ArrayList<MemberDTO>)request.getAttribute("memberlist");
		int size = memberlist.size();
		//������ ��ġ�� �ʰ� ������ ���� ������ �� �𸣱� ������ null pointer exception�� �߻��Ѵ�.
		//500���� run time �����̴�.
	%>
	
	<h1 align='center'>�μ� ��� ����~~</h1>
	<hr/>
	<table border="1" align="center" width="500px" >
	<tr>
	<th>ID</th><th>PASS</th><th>�̸�</th>
	<th>�ּ�</th><th>�μ���ȣ</th><th>���</th>
	<th>����Ʈ</th><th>����</th>
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
		<td><a href="/serverweb/member/delete.do?id=<%= member.getId() %>">����</a></td>
	</tr>
	<%	}	%>
	</table>
	
</body>
</html>