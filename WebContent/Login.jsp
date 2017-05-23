<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="seikimatu.LoginUserBean" %>
    <%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"  href="sakana.css" type="text/css" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-style-type" content="text/css" />
<style type="text/css">
th{background-color:#ffff00;}
.message{color:#800000;}</style>
<title>ショッピングサイトへようこそ！</title>
</head>
<body style="background-image:url(img/umi.jpg);
background-repeat:no-repeat;
image-size:fd" >
<h1>ログインページ</h1>
<form action="LoginServlet" method="post">
<p>ログイン情報を入力してください</p>
<table class="1" border="1">
<tr><td>ログインID :<input type="text" name="userId" value=""/></td></tr>
<tr><td>password :<input type="text" name="password" value="" /></td></tr>
</table>
<p><input type="submit" name="btn" value="ログイン" /></p>
</form>
<form action ="LoginServlet" method="post">
<p><input type="submit" name="btn" value="新規登録" /></p>
</form>

<%if("Login".equals(session.getAttribute("login_db"))){ %>
<form action="LoginServlet" method="get">
<p><input type="submit" value="ログアウト" /></p>
<p><input type="hidden" name="out" value="Logout"/></p>
</form>
<%} %>
<%if(request.getAttribute("message") != null) {%>
<p class="message">${requestScope.message }</p>
<%} %>
<%ArrayList<LoginUserBean> empList=(ArrayList<LoginUserBean>)session.getAttribute("empList");
if(empList != null && !empList.isEmpty()){%>
<table border="1">
<%for(LoginUserBean lub :empList) {%>
<tr>
<td><%= lub.getUserId() %></td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>