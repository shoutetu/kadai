<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"  href="sakana.css" type="text/css" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録ページ</title>
</head>
<body>
<h1>新規登録</h1>
<h2>登録するあなたの情報を入力してください</h2>
<form action="LoginServlet" method="post">
<table border="2" align="left">
<tr>
<td>新たに登録するID</td>
<td><input type="text" name="new_id" value="" /></td></tr>
<tr>
<td>新たに登録するPASS</td>
<td><input type="text" name="new_pass" value="" /></td></tr>
<tr>
<td>新たに登録する名前</td>
<td><input type="text" name="new_name" value="" /></td></tr>
<tr>
<td>新たに登録する年齢</td>
<td><input type="text" name="new_age" value="" /></td></tr>
</table>
<table>
<tr><td><%=session.getAttribute("message1") %></td></tr>
<tr><td><%=session.getAttribute("message2") %></td></tr>
<tr><td><%=session.getAttribute("message3") %></td></tr>
</table>
<div class="btn1">
<table class="btn1">
<p><input type="submit"  name="tr" value="登録" /></p>
<a href="http://localhost:8080/seikimatu/Login.jsp" >TOPに戻る</a>
</table>
</div>
</form>
</body>
</html>