<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="seikimatu.LoginUserBean" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"  href="sakana.css" type="text/css" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録完了</title>
</head>
<body>
<h1>新規登録完了！！</h1>
		<table align="center">
				<tr style="text-align:center;">
					<th>ログインID</th>
					<th>password</th>
					<th>名前</th>
					<th>年齢</th>
					<th>住所</th>
				</tr>
				<tr>
					<td><%=request.getAttribute("new_id") %></td>
					<td><%=request.getAttribute("new_pass") %></td>
					<td><%=request.getAttribute("new_name") %></td>
					<td><%=request.getAttribute("new_age") %></td>
					<td><%=request.getAttribute("new_address") %></td>
					</tr>
					</table>
<a href="http://localhost:8080/seikimatu/Login.jsp" >TOPに戻る</a>
<jsp:include page="footer.jsp" />
</body>
</html>