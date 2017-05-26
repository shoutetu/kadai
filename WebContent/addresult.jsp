<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel='stylesheet'  href='sakana.css' type='text/css' media='all'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>追加完了</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>追加しました。</h1>
<form action="ManagerServlet" method="get">
 <input type="submit" value="一覧に戻る">
</form>
</body>
</html>