<%@ page import="DAO.*,Model.*,java.sql.*,java.util.*,Servlet.*"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="row">
				<div class="col-md-4">
					<%
						// 如果有内容，则修改变量i，如果没有，则根据i的值进行无内容提示  
						int i = 0;
						List<Guitar> all = null;
						all = (List<Guitar>) request.getAttribute("all");
					%>
					<form class="navbar-form navbar-left" role="search"
						action="GuitarServlet" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search"
								name="keyword">
						</div>
						<input type="hidden" name="status" value="selectbylike"> 
						<input type="submit" class="btn btn-default" value="search"><br>
						
					</form>
					<br> <br> <br>
					<blockquote>
						<p>Rick's Guitar</p>
						<small>ACOUSTIC & <cite>ELECTRIC</cite></small>
					</blockquote>
					<a href="insert.jsp" target="_blank"><button type="button" class="btn btn-primary">Insert NewGuitar +</button></a>
				</div>
				
				<div class="col-md-8">
					<table class="table">
						<thead>
							<tr>
								<th>serialNumber</th>
								<th>price</th>
								<th>builder</th>
								<th>model</th>
								<th>type</th>
								<th>backWood</th>
								<th>topWood</th>
								<th>delete</th>
							</tr>
						</thead>
						<%
							if (null != all) {
								Iterator iter = all.iterator();
								while (iter.hasNext()) {
									Map properties = new HashMap();
									Guitar guitar = (Guitar) iter.next();
									GuitarSpec spec = guitar.getSpec();
									i++;
									// 进行循环打印，打印出所有的内容，以表格形式  
									// 从数据库中取出内容  
									String serialNumber = guitar.getSerialNumber();
									Double price = guitar.getPrice();
									String builder =spec.getProperty("builder").toString();
									String model = spec.getProperty("model").toString();
									String type = spec.getProperty("type").toString();
									String backWood = spec.getProperty("backWood").toString();
									String topWood = spec.getProperty("topWood").toString();
									String keyword = request.getParameter("keyword")
											.toUpperCase();
									if (keyword != null) {
										builder = builder.replaceAll(keyword,
												"<font color=\"red\">" + keyword + "</font>");
										model = model.replaceAll(keyword,
												"<font color=\"red\">" + keyword + "</font>");
										type = type.replaceAll(keyword, "<font color=\"red\">"
												+ keyword + "</font>");
										backWood = backWood.replaceAll(keyword,
												"<font color=\"red\">" + keyword + "</font>");
										topWood = topWood.replaceAll(keyword,
												"<font color=\"red\">" + keyword + "</font>");
									}
						%>

						<tr>
							<td width="25%" bgcolor="#FFFFFF">
								<div align="center"><%=serialNumber%></div>
							</td>
							<td width="25%">
								<div align="center"><%=price%></div>
							</td>
							<td width="25%">
								<div align="center"><%=builder%></div>
							</td>
							<td width="25%">
								<div align="center"><%=model%></div>
							</td>
							<td width="25%">
								<div align="center"><%=type%></div>
							</td>
							<td width="25%">
								<div align="center"><%=backWood%></div>
							</td>
							<td width="25%">
								<div align="center"><%=topWood%></div>
							</td>
							<td width="25%">
								<div align="center"><a href="GuitarServlet?serialNumber=<%=serialNumber%>&status=delete">delete</a></div>
							</td>
						</tr>
						
						<%
							}
								// 判断i的值是否改变，如果改变，则表示有内容，反之，无内容
								if (i == 0) {
									// 进行提示
						%>
						<tr>
							<td colspan="8">没有任何内容！！！</td>
						</tr>
						<%
							}
							}
							
						%>
						
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
