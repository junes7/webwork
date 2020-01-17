<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/serverweb/jspbasic/requestObjTest.jsp">
	<!-- 여기 경로를 잡아줄 때 절대경로로 설정을 해 주어야 한다. -->
		아이디: <input type="text" name="id" /><br/>
		패스워드: <input type="password" name="pass" /><br/>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>