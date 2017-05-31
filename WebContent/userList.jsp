<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="seikimatu.LoginUserBean" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録ユーザー一覧</title>
</head>
<body>
<jsp:include page="manageHeader.jsp" />
<a href="http://localhost:8080/seikimatu/ManagerManage.jsp" >TOPに戻る</a>
<h3 style="color:red" align="center"><%=request.getAttribute("message") %></h3>
<table align="center">
<tr style="background-color:pink">
<th><h4>ログインID</h4></th>
<th><h4>Pass</h4></th>
<th><h4>名前</h4></th>
<th><h4>年齢</h4></th>
<th><h4>住所</h4></th>
<th style="background-color:yellow"></th>
<th style="background-color:red"><h4>入力情報変更(変更したい項目にチェックを入れてください)</h4></th>
<th style="background-color:yellow"></th>
</tr>
<%ArrayList<LoginUserBean> lbean =  (ArrayList<LoginUserBean>)request.getAttribute("userList");  %>
<%for(LoginUserBean bean:lbean) { %>
<tr>
<td><%=bean.getUserId() %></td>
<td><%=bean.getPassword() %></td>
<td><%=bean.getName() %></td>
<td><%=bean.getAge() %></td>
<td><%=bean.getAddress() %></td>
<form action="ManageServlet" method="get">
<td>
<input type="hidden" name="userId" value="<%=bean.getUserId() %>" />
<input type="hidden" name="userName" value="<%=bean.getName() %>"/>
<input type="submit" name="btn" value="削除" /></td>
<td>
<select name= "check">
<option value="password">パスワード</option>
<option value="名前">名前</option>
<option value="年齢">年齢</option>
<option value="住所">住所</option>
</select></td>
<td><input type="submit" name="change" value="変更"/></td>
</form>
</tr>
<%} %>
</table>
<jsp:include page="footer.jsp" />
</body>
</html>