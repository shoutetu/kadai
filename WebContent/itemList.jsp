<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="seikimatu.itemBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-style-type" content="text/css" />
<style type="text/css">
th {
	background-color: #ffff00;
}

.message {
	color: #800000;
}
</style>
<title>買い物</title>
</head>
<body>
	<jsp:include page="header.jsp" />
		<table>
			<tbody>
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>在庫数</th>
					<th>数量</th>
				</tr>
				<%
					ArrayList<itemBean> beanList = (ArrayList<itemBean>) request.getAttribute("itemBeanList");
				%>
				<%
					for (itemBean bean : beanList) {
				%>
				<tr>
					<td><%=bean.getItemid()%></td>
					<td><%=bean.getItemname()%></td>
					<td class="int"><%=bean.getItemprice()%></td>
					<td class="int"><%=bean.getItemQuantity()%></td>
					<form action ="BuyItemServlet" method="get">
					<%
						if (bean.getItemQuantity() != 0) {
					%>
					<td><select name="buyCount">
							<%
								for (int i = 0; i <= bean.getItemQuantity(); i++) {
							%>
							<option value=<%=i%>><%=i%></option>
							<%
								}
							%>
					</select></td>
					<td><input type="hidden" name="itemId"value="<%=bean.getItemid()%>" /></td>
					<td><input type="submit" name="btn" value="購入" /></td></tr>
					</form>
					<%
						}else {
					%>
					<td>売り切れ</td>
					<%
						}
					%>
					</tr>
					<%
						}
					%>

			</tbody>
		</table>
</body>
</html>