<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%
request.setCharacterEncoding("UTF-8");
ArrayList<String[]> al =(ArrayList<String[]>)session.getAttribute("monos");

String removeNum =request.getParameter("remove");

String tableData="";
String message ="";
int goukei=0;

if(removeNum != null){
	al.remove(Integer.parseInt(removeNum));
}
if (al != null && al.size()>0) {
	//tableData += "<table border=\"1\">";
	for (int i = 0; i < al.size(); i++) {
		String[] monoArray =(String[])al.get(i);

//tableの作成
		tableData += "<tr>";
		tableData += "<td>" + monoArray[0] + "</td>";
		tableData += "<td align=\"right\">" + monoArray[1] +" 円"+"</td>";
		tableData += "<td align=\"center\" width=\"120\" heght=\"100\"><img src=\"" + monoArray[2]+ "\" alt=\"" + monoArray[0] + "\" /></td>";
		tableData += "<td>";
		tableData += "<form action=\"cart.jsp\" method=\"post\">";
		tableData += "<input type=\"submit\" value=\"カートから削除する\" />";
		tableData += "<input type=\"hidden\" name=\"remove\" value=\"" + i + "\" />";
		tableData += "</form>";
		tableData += "</td>";
		tableData += "</tr>\n";
		goukei += Integer.parseInt(monoArray[1]);
	}
	//tableData += "</table>";
}
	if(goukei > 0){
		message = "合計は"+ goukei+"円です";
}else{
	message = "カートに商品が入っていません。";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-style-type" content="text/css" />
<style type="text/css">
td{width:100px;}
</style>
<title>カートの詳細</title>
</head>
<body background = "img/leo.jpg" text="ff0000">
		<h1>カートの詳細</h1>
		<table border="1" summary="兵器一覧" bgcolor="000000">
			<%=tableData%>
		</table>
		<font size=6><span style="background-color:#ffffff"><%=message%></span></font>
		<hr />
		<p><a href ="session.jsp">商品一覧に戻る</a></p>
</body>
</html>