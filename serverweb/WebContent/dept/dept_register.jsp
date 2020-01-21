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
	<a href ="/serverweb/list.do" target="_blank">�μ�������</a><br/><br/>
	<div class="container-fluid">
			<form role="form" class="form-horizontal"
				action="/serverweb/deptinsert.do" method="POST">
				<fieldset>
					<div id="legend">
						<legend>�Ʒ� ����� �ۼ����ּ���.</legend>
					</div>
					<div class="form-group">
						<!-- �μ��ڵ� -->
						<label class="control-label col-sm-2" for="orgcode">�μ� ��Ϻ���</label>
						<div class="col-sm-3">
							<input type="text" id="orgcode" name="deptNo"
								placeholder="�μ��ڵ�" class="form-control"
								 required>
						</div>
					</div>

					
					
					<div class="form-group">
						<!-- �μ���-->
						<label class="control-label col-sm-2" for="orgname">�μ���</label>
						<div class="col-sm-3">
							<input type="text" id="orgname" name="deptName"
								placeholder="�μ���" class="form-control" minlength="4" required>

						</div>
					</div>
					
					<div class="form-group">
						<!-- �μ���ġ-->
						<label class="control-label col-sm-2" for="orgloc">�μ���ġ</label>
						<div class="col-sm-3">
							<input type="text" id="orgloc" name="loc"
								placeholder="�μ���ġ" class="form-control" minlength="4" >

						</div>
					</div>
					<div class="form-group">
						<!-- ��ȭ��ȣ-->
						<label class="control-label col-sm-2" for="orgtel">��ȭ��ȣ</label>
						<div class="col-sm-3">
							<input type="text" id="orgtel" name="tel" 
							placeholder="��ȭ��ȣ"
								class="form-control" minlength="4" required>

						</div>
					</div>
					<div class="form-group">
						<!-- �Ŵ���-->
						<label class="control-label col-sm-2" for="orgtel">������</label>
						<div class="col-sm-3">
							<input type="text" id="orgtel" name="mgr" 
							placeholder="������"
								class="form-control" minlength="4" required>

						</div>
					</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="�����ϱ�" class="btn btn-success"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>