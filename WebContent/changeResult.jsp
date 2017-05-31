<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header2.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー情報の変更完了</title>
</head>
<body>
<h1>ユーザー情報の変更完了！</h1>
<h2><%=request.getAttribute("new") %>に変更されました！</h2>
<jsp:include page="footer.jsp" />
</body>
</html>