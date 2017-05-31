<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="seikimatu.itemBean" %>
    <% itemBean bean= (itemBean)request.getAttribute("itemList"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel='stylesheet'  href='sakana.css' type='text/css' media='all'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入確認画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
 <h1>補充確認</h1>
    <p>次の商品を補充しますか？</p>
    <form action="AddResultServlet" method="post">
        <table align="center">
            <tbody>
                <tr>
                    <th>商品ID</th>
                    <th>商品名</th>
                    <th>価格</th>
                    <th>在庫数</th>
                    <th>追加数</th>
                    <th></th>
                </tr>
                <tr>
                    <td><%=bean.getItemid() %></td>
					<td><%=bean.getItemname() %></td>
                    <td><%=bean.getItemprice() %></td>
                    <td><%=bean.getItemQuantity() %></td>
                    <td class="int"><%=request.getAttribute("addCount")%></td>
                    <td>
                        <input type="submit" name="add" value="補充する" >
 						<input type="hidden" name="item_id" value="<%=bean.getItemid() %>">
 						<input type="hidden" name="quantity" value="<%= request.getAttribute("addCount") %>" >
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <form action="ManagerServlet" method="get">
        <input type="submit" value="一覧に戻る">
    </form>
</body>
</html>