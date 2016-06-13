<%@ page import="DAO.*,Model.*,java.sql.*,java.util.*,Servlet.*"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
<center>
	<hr>
	<br>
	<%
		// 进行乱码处理
		request.setCharacterEncoding("GB2312") ;
	%>
	
	<%
			response.setHeader("refresh","2;URL=GuitarServlet?status=selectall") ;
			boolean b = ((Boolean)request.getAttribute("flag")).booleanValue() ;
			if(b)
			{
	%>
				添加成功，两秒后跳转到列表页！！！<br>
				如果没有跳转，请按<a href="GuitarServlet?status=selectall">这里</a>！！！
	<%
			}
			else
			{
	%>
				添加失败，两秒后跳转到列表页！！！<br>
				如果没有跳转，请按<a href="GuitarServlet?status=selectall">这里</a>！！！
	<%
			}
	%>
	
</center>
</body>
</html>