<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="seikimatu.itemBean" %>
 <% itemBean bean= (itemBean)request.getAttribute("itemList"); %>
 <jsp:useBean id="itemBean" scope="request" class="seikimatu.itemBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入確認</title>
</head>
<body>
<jsp:include page="header.jsp"/>
 <h1>購入確認</h1>
    <p style="color:blue">次の商品を購入しますか？</p>

    <form action="ResultServlet" method="post">
        <table align="center">
            <tbody>
                <tr style="background-color:pink">
                    <th>商品ID</th>
                    <th>商品名</th>
                    <th>価格</th>
                    <th>在庫数</th>
                    <th>購入数</th>
                    <th></th>
                </tr>
                <tr>
                    <td><%=bean.getItemid() %></td>
					<td><%=bean.getItemname() %></td>
                    <td><%=bean.getItemprice() %></td>
                    <td><%=bean.getItemQuantity() %></td>
                    <td class="int"><%=request.getAttribute("buyCount")%></td>
                    <td>
                        <input type="submit" name="buy" value="購入する" >
 						<input type="hidden" name="item_id" value="<%=bean.getItemid() %>">
 						<input type="hidden" name="quantity" value="<%= request.getAttribute("buyCount") %>" >
                    </td>
                </tr>
            </tbody>
            <h2 align="center">合計金額：<%=request.getAttribute("totalPrice") %>円です！</h2>
         </table>
    </form>
    <form action="ShoppingServlet" method="post">
        <input type="submit" value="一覧に戻る">
    </form>
    <jsp:include page="footer.jsp" />
</body>
</html>