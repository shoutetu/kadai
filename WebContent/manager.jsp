<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@page import="seikimatu.itemBean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel='stylesheet'  href='sakana.css' type='text/css' media='all'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マネージャー(商品管理)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>商品在庫を補充する。</h1>
<table class="item">
			<tbody>
				<tr style="text-align:center;">
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>在庫数</th>
					<th>数量</th>
					<th> </th>
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
					<form action ="Add2ItemServlet" method="get">
					<%
						if (bean.getItemQuantity() != 0) {
					%>
					<td><select name="addCount">
							<%
								for (int i = 0; i <= bean.getItemQuantity(); i++) {
							%>
							<option value=<%=i%>><%=i%></option>
							<%
								}
							%>
					</select></td>
					<td>
					<input type="hidden" name="itemId"value="<%=bean.getItemid()%>" />
					<input type="submit" name="btn" value="追加" /></td></tr>
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