<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="seikimatu.LoginUserBean" %>
<%
	request.setCharacterEncoding("UTF-8");

	String mono = request.getParameter("mono");
	String nedan = request.getParameter("nedan");
	String img = request.getParameter("img");
	String clear = request.getParameter("clear");

	String message = "";

	ArrayList<String[]> al = (ArrayList<String[]>) session.getAttribute("monos");
	//カートを空にするを押したら
	if (clear != null) {
		session.invalidate();
		message = "カートを空にしました";
	} else if (mono == null) {
		if (al == null || al.size() == 0) {
			message = "商品を選んでください。";
	//カートに商品が入っていたら
		} else {
			message = "カートに" + al.size() + "個の兵器が入っています。";
		}
	} else {
		if (al == null) {
			al = new ArrayList<String[]>();
		}
		String[] item = { mono, nedan, img };
		al.add(item);
		session.setAttribute("monos", al);
		message = "カートに" + al.size() + "個の兵器が入っています。";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-style-type" content="text/css">
<style type="text/css">
td {
	width: 100px;
}
</style>
<title>ショッピング</title>
</head>
<body background="img/leo.jpg" text="ff0000">

	<h1>ショッピング</h1>
	<table border="1" bgcolor="000000" summary="一覧">
		<tr>
			<td>カラパイア</td>
			<td><img src="img/karapaia.jpg" height="150" width="200"
				alt="カラパイア" /></td>
			<td>二億四千万円</td>
			<td>
				<form action="session.jsp" method="post">
					<input type="submit" value="カートに入れる" /> <input type="hidden"
						name="mono" value="カラパイア" /> <input type="hidden" name="nedan"
						value="240000000" /> <input type="hidden" name="img"
						value="img/karapaia.jpg" />
				</form>
			</td>
		</tr>
		<tr>
			<td>スホーイ</td>
			<td><img src="img/suhoi.jpg" height="150" width="200" alt="スホーイ" /></td>
			<td>一億六千万円</td>
			<td>
				<form action="session.jsp" method="post">
					<input type="submit" value="カートに入れる" /> <input type="hidden"
						name="mono" value="スホーイ" /> <input type="hidden" name="nedan"
						value="160000000" /> <input type="hidden" name="img"
						value="img/suhoi.jpg" />
				</form>
			</td>
		</tr>
		<tr>
			<td>ギガント</td>
			<td><img src="img/giganto.jpg" height="150" width="200"
				alt="ギガント" /></td>
			<td>三億円</td>
			<td><form action="session.jsp" method="post">
					<input type="submit" value="カートに入れる" /> <input type="hidden"
						name="mono" value="ギガント" /> <input type="hidden" name="nedan"
						value="300000000" /> <input type="hidden" name="img"
						value="img/giganto.jpg" />
				</form></td>
		</tr>
		<tr>
			<td>ミズーリ</td>
			<td><img src="img/mizuri.jpg" height="150" width="200"
				alt="ミズーリ" /></td>
			<td>五億円</td>
			<td>
				<form action="session.jsp" method="post">
					<input type="submit" value="カートに入れる" /> <input type="hidden"
						name="mono" value="ミズーリ" /> <input type="hidden" name="nedan"
						value="500000000" /> <input type="hidden" name="img"
						value="img/mizuri.jpg" />
				</form>
			</td>
		</tr>
		<tr>
			<td>デンドロビウム</td>
			<td><img src="img/dendorobiumu.jpg" height="150" width="200"
				alt="デンドロビウム" /></td>
			<td>二億二千万円</td>
			<td>
				<form action="session.jsp" method="post">
					<input type="submit" value="カートに入れる" /> <input type="hidden"
						name="mono" value="デンドロビウム" /> <input type="hidden" name="nedan"
						value="220000000" /> <input type="hidden" name="img"
						value="img/dendorobiumu.jpg" />
				</form>
			</td>
		</tr>
	</table>
	<form action="session.jsp" method="post">
		<div>
			<input type="submit" value="カートを空にする" /> <input type="hidden"
				name="clear" value="clear" />
		</div>
	</form>
	<%=message%>
	<p>
		<a href="cart.jsp">カートの中身を見る</a>
</body>
</html>