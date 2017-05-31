<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel='stylesheet' href='sakana.css' type='text/css' media='all'>
<jsp:useBean id="user_db" scope="session" class="seikimatu.LoginUserBean" />
</head>
<header class=headr>
<h1><span><img src="http://latale.wikiwiki.jp/?plugin=ref&page=Monster%2F%A5%B5%A5%D0%A5%F3%A5%CA&src=Monster_05_02.gif"></span>サバンナ！！<span><img src="http://latale.wikiwiki.jp/?plugin=ref&page=Monster%2F%A5%B5%A5%D0%A5%F3%A5%CA&src=Monster_04_01.gif"></span></h1>
<h3>ようこそ「<jsp:getProperty property="name" name="user_db" />」さん！<span id="RealtimeClockArea"></span></h3>
<script type="text/javascript">
function showClock1() {
   var nowTime = new Date();
   var nowHour = nowTime.getHours();
   var nowMin = nowTime.getMinutes();
   var nowSec = nowTime.getSeconds();
   var msg = "現在時刻は、" + nowHour + ":" + nowMin + ":" + nowSec + " です。";
   document.getElementById("RealtimeClockArea").innerHTML = msg;
}
setInterval('showClock1()',1000);
</script>
</header>
<body>
	<nav class="navbar navbar-default" style="color:black;">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">LOGO</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="http://localhost:8080/seikimatu/Login.jsp">TOPへ <span class="sr-only">(current)</span></a></li>
				</ul>
				<form action="ShoppingServlet" method="post">
					<div style="padding-top: 10px; text-align: center;">
						<input type="text" name="inputPrice1" value="" />円から
						<input type="text" name="inputPrice2" value="" />円までの商品
						<input type="submit" name="serch" value="検索" />
						<input type="submit" name="sort" value="並び替え（昇順）" />
					</div>
				</form>

			</div>
		</div>
	</nav>
	</body>
	</html>
