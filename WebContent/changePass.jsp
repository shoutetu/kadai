<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='sakana.css' type='text/css' media='all'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パスワード変更</title>
</head>
<body>
<h1><%=request.getAttribute("userName") %>さんのパスワード変更</h1>
<form action="ChangeServlet" method="post">
<input type="text" name="changePass" value="" />
<input type="hidden" name="userId" value="<%=request.getAttribute("userId")%>"/>
<input type="submit" name="btn" value="変更"/>
</form>
<jsp:include page="footer.jsp" />
</body>
</html>