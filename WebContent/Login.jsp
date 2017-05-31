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
<body>
<h1 class="title">サバンナ！！</h1>
<h1 align="center"><span><img src="http://latale.wikiwiki.jp/?plugin=ref&page=Monster%2F%A5%B5%A5%D0%A5%F3%A5%CA&src=Monster_05_02.gif"></span>ログインページ<span><img src="http://latale.wikiwiki.jp/?plugin=ref&page=Monster%2F%A5%B5%A5%D0%A5%F3%A5%CA&src=Monster_05_02.gif"></span></h1>
<form action="LoginServlet" method="post">
<h3 style="color:red">ログイン情報を入力してください</h3>
<table class="1" border="1">
<tr><td>ログインID :<input type="text" name="userId" maxlength='5' placeholder='名前を入力' value=""/></td></tr>
<tr><td>password :<input type="text" name="password" maxlength='10'placeholder='パスワードを入力' value="" /></td></tr>
</table>
<p><input type="submit" name="btn" value="ログイン" /></p>
</form>
<form action ="LoginServlet" method="post">
<p><input type="submit" name="btn" value="新規登録" /></p>
</form>
<img src="http://latale.wikiwiki.jp/?plugin=ref&page=Monster%2F%A5%B5%A5%D0%A5%F3%A5%CA&src=Monster_05_02.gif">
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