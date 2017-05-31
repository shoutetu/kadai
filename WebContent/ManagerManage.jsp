<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="seikimatu.LoginUserBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者専用</title>
</head>
<jsp:include page="manageHeader.jsp" />
<body>
<h3>お疲れ様です。</h3>
<h1>管理者専用ページ</h1>
<form action="ManageServlet" method="post">
<h1><input type="submit" name="userList" value="ユーザー一覧"/>
<input type="submit" name="itemList" value="商品一覧"/></h1>
</form>
<body>
<jsp:include page="footer.jsp" />
</body>
</html>