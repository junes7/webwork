<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<a href ="/serverweb/list.do" target="_blank">부서목록출력</a><br/><br/>
	<div class="container-fluid">
			<form role="form" class="form-horizontal"
				action="/serverweb/deptinsert.do" method="POST">
				<fieldset>
					<div id="legend">
						<legend>아래 양식을 작성해주세요.</legend>
					</div>
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-2" for="orgcode">부서코드</label>
						<div class="col-sm-3">
							<input type="text" id="orgcode" name="deptNo"
								placeholder="부서코드" class="form-control"
								 required>
						</div>
					</div>

					
					
					<div class="form-group">
						<!-- 부서명-->
						<label class="control-label col-sm-2" for="orgname">부서명</label>
						<div class="col-sm-3">
							<input type="text" id="orgname" name="deptName"
								placeholder="부서명" class="form-control" minlength="4" required>

						</div>
					</div>
					
					<div class="form-group">
						<!-- 부서위치-->
						<label class="control-label col-sm-2" for="orgloc">부서위치</label>
						<div class="col-sm-3">
							<input type="text" id="orgloc" name="loc"
								placeholder="부서위치" class="form-control" minlength="4" >

						</div>
					</div>
					<div class="form-group">
						<!-- 전화번호-->
						<label class="control-label col-sm-2" for="orgtel">전화번호</label>
						<div class="col-sm-3">
							<input type="text" id="orgtel" name="tel" 
							placeholder="전화번호"
								class="form-control" minlength="4" required>

						</div>
					</div>
					<div class="form-group">
						<!-- 매니저-->
						<label class="control-label col-sm-2" for="orgtel">관리자</label>
						<div class="col-sm-3">
							<input type="text" id="orgtel" name="mgr" 
							placeholder="관리자"
								class="form-control" minlength="4" required>

						</div>
					</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="가입하기" class="btn btn-success"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>