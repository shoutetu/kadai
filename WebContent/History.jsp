<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="seikimatu.HistoryBean" %>
    <%@page import="java.util.ArrayList" %>
    <jsp:useBean id="user_db" scope="session" class="seikimatu.LoginUserBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-style-type" content="text/css" />
<style type="text/css">
th {
	text-align:center;
	background-color:pink;
}
</style>
<title>ショッピングサイト</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1><jsp:getProperty property="name" name="user_db"/>さんの購入履歴</h1>
 <% ArrayList<HistoryBean> historyList = (ArrayList<HistoryBean>) session.getAttribute("buyHistory"); %>
        <table align="center">
            <tbody>
                <tr style="backgroud-color:pink;">
                    <th>商品ID</th>
                    <th>商品名</th>
                    <th>購入数</th>
                </tr>
                <% for (HistoryBean bean : historyList) {%>
                <tr>
                    <td><%= bean.getItemid()%></td>
                    <td><%= bean.getItemName()%></td>
                    <td><%= bean.getItemByQuantity()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>

        <form action="ShoppingServlet" method="post">
            <input type="submit" value="一覧に戻る">
        </form>
    </body>
</html>