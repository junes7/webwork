<%@page import="dept.DeptDAOImpl"%>
<%@page import="dept.DeptDAO"%>
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
	request.setCharacterEncoding("euc-kr");
	int result=0;
	String deptNo = request.getParameter("deptNo");
	String deptName = request.getParameter("deptName");
	String loc = request.getParameter("loc");
	String tel = request.getParameter("tel");
	String mgr = request.getParameter("mgr");
	
	//2.�����Ͻ� �޼ҵ� call
	DeptDTO dept1 = new DeptDTO(deptNo,deptName,loc,tel,mgr);
	DeptDAO dao = new DeptDAOImpl();
	result = dao.insert(dept1);
	
	%>
		
		<h1>�Է� ����</h1>
		<hr/>
		<h1><%= result %>�� �� ���� ����</h1>

</body>
</html>