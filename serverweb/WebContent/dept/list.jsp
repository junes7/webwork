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
		//�������� �������� ArrayList<DeptDTO>��ü ��������
		ArrayList<DeptDTO> deptlist = (ArrayList<DeptDTO>)request.getAttribute("deptlist");
		int size = deptlist.size();
		//�������� ��ġ�� �ʰ� ������ ���� ������ �� �𸣱� ������ null pointer exception�� �߻��Ѵ�.
		//500���� run time �����̴�.
	%>
	
	<h1 align='center'>�μ� ��� ����~~</h1>
	<hr/>
	<table border="1" align="center" width="500px" >
	<tr>
	<th>�μ��ڵ�</th><th>�μ���</th><th>��ġ</th>
	<th>��ȭ��ȣ</th><th>������</th><th>����</th>
	</tr>
	<%	for(int i=1; i< size; i++){ 
		DeptDTO dept = deptlist.get(i);
	%>
	<tr>
		<td><%= dept.getDeptNo() %></td>
		<td><a href="/serverweb/dept/read.do?deptNo=<%= dept.getDeptNo() %>&info=�ѱ۵�����"><%= dept.getDeptName() %></a>
		<%-- <td><%= dept.getDeptName() %></td> --%>
		<td><%= dept.getLoc() %></td>
		<td><%= dept.getTel() %></td>
		<td><%= dept.getMgr() %></td>
		<td><a href="/serverweb/delete.do?deptNo=<%= dept.getDeptNo()%>">����</a></td>
	</tr>
	<%	}	%>
	</table>
	
</body>
</html>