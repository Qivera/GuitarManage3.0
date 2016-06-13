<%@ page import="DAO.*,Model.*,java.sql.*,java.util.*,Servlet.*"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert New Guitar</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<div class="container-fluid">
	<div style="margin-top: 10%;">
		<div class="row-fluid">
			<div class="col-md-6 col-sm-6 col-xs-10 col-xs-offset-1 col-sm-offset-3 col-md-offset-3 well">
				<form class="horizontal" action="GuitarServlet" method="post">
					<div class="form-group">
						<div class="col-md-3 col-xs-3">
							<label class="control-label">serialNumber</label>
						</div>
						<div class="col-md-8 col-xs-8">
							<input type="text" class="form-control" placeholder="请输入序列号"
								name="serialNumber">
						</div>
					</div><br>
 
					<div class="form-group">
						<div class="col-md-3 col-xs-3">
							<label class="control-label">price</label>
						</div>
						<div class="col-md-8 col-xs-8">
							<input name="price" class="form-control" type="text"
								placeholder="请输入价格" />
						</div>
					</div><br>

					<div class="form-group">
						<div class="col-md-3 col-xs-3">
							<label class="control-label">builder</label>
						</div>
						<div class="col-md-8 col-xs-8">
							<select class="form-control" name="builder">
								<option>FENDER</option>
								<option>MARTIN</option>
								<option>GIBSON</option>
								<option>COLLINGS</option>
								<option>OLSON</option>
								<option>RYAN</option>
								<option>PRS</option>
								<option>ANY</option>
							</select>
						</div>
					</div><br>


					<div class="form-group">
						<div class="col-md-3 col-xs-3">
							<label class="control-label">model</label>
						</div>
						<div class="col-md-8 col-xs-8">
						<input name="model" class="form-control" placeholder="请输入型号"
							type="text" />
							</div>
					</div><br>

					<div class="form-group">
						<div class="col-md-3 col-xs-3">
							<label class="control-label">type</label>
						</div>
						<div class="col-md-8 col-xs-8">
							<select class="form-control" name="type">
								<option>ACOUSTIC</option>
								<option>ELECTRIC</option>

							</select>
						</div>
					</div><br>

					<div class="form-group">
						<div class="col-md-3 col-xs-3">
							<label class="control-label">backWood</label>
						</div>
						<div class="col-md-8 col-xs-8">
							<select class="form-control" name="backWood">
								<option>INDIAN_ROSEWOOD</option>
								<option>BRAZILIAN_ROSEWOOD</option>
								<option>MAHOGANY</option>
								<option>MAPLE</option>
								<option>COCOBOLO</option>
								<option>CEDAR</option>
								<option>ADIRONDACK</option>
								<option>ALDER</option>
								<option>SITKA</option>
							</select>
						</div>
					</div><br>

					<div class="form-group">
						<div class="col-md-3 col-xs-3">
							<label class="control-label">topWood</label>
						</div>
						<div class="col-md-8 col-xs-8">
							<select class="form-control" name="topWood">
								<option>INDIAN_ROSEWOOD</option>
								<option>BRAZILIAN_ROSEWOOD</option>
								<option>MAHOGANY</option>
								<option>MAPLE</option>
								<option>COCOBOLO</option>
								<option>CEDAR</option>
								<option>ADIRONDACK</option>
								<option>ALDER</option>
								<option>SITKA</option>
							</select>
						</div>
					</div><br>

					<div class="form-group">
								<div class="col-md-2 col-xs-2"></div>
								<div class="col-md-10  col-xs-10 ">
					<input name="status" type="hidden" value="insert" /> <input
						class="btn btn-default" type="submit" value="增加吉他" /></div></div>
				</form>

			</div>
		</div>
	</div>
</div>
<script src="js/bootstrap.js"></script>
<script src="js/jQuery.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
</body>
</html>