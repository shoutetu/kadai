<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' href='sakana.css' type='text/css' media='all'>
<jsp:useBean id="user_db" scope="session" class="seikimatu.LoginUserBean" />
</head>
<header class=headr>
<h1>サバンナ！！</h1>
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
<a href="http://localhost:8080/seikimatu/ManagerManage.jsp" >TOPに戻る</a>
	</body>
	</html>