<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>road map</title>

<style type="text/css">
#back {
	width: 300px;
	height: 380px;
	background-color: #5b9bd5;
}

#menu {
	padding-top: 5%;
	text-align: center;
}

#content {
	background-color: white;
	width: 90%;
	margin-left: 5%
}
</style>
</head>
<body>
	<div id="back">
		<div id="menu">
			<b>경로 검색</b>
			<form action="" method="get" style="background-color: gray;">
				<input type="text" name="departure" placeholder="출발" style="width: 70%;" /><br /> <input
					type="text" name="arrive" placeholder="도착" style="width: 70%;" /><br /> 
					<input type="reset" value="다시입력" />&emsp;&emsp; <input type="submit"
					value="길찾기" />
			</form>
		</div>
		<br />
		<div id="content">
			<b>자주가는 장소</b> <br /> <em>집 등록:</em><br /> 래미안 <br /> <em>회사/학교
				등록:</em><br /> 멀티캠퍼스 <br /> <br /> <b>최근 검색</b><br /> 최근 검색 기록이 없습니다.
			<br /> <br /> <b>즐겨찾기</b><br /> 즐겨찾기 기록이 없습니다.
		</div>
	</div>
</body>
</html>