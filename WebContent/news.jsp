
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>News</title>
<style>
/* < style type="text /css "> */
#sidebar {
	text-align: center;
	border: 1px gray solid;
}

#search {
	margin-left: 10px;
	padding: 5px 15px;
	border: 1px black solid;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	font-family: Microsoft JhengHei;
	background-color: #fffaf3;
}

#submit {
	padding: 5px 15px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	font-family: Microsoft JhengHei;
}

* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #e9e9e9;
}

.topnav a {
	float: left;
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #2196F3;
	color: white;
}

.topnav input[type=text] {
	float: right;
	padding: 6px;
	margin-top: 8px;
	margin-right: 16px;
	border: none;
	font-size: 17px;
}

@media screen and (max-width: 600px) {
	.topnav a, .topnav input[type=text] {
		float: none;
		display: block;
		text-align: left;
		width: 100%;
		margin: 0;
		padding: 14px;
	}
	.topnav input[type=text] {
		border: 1px solid #ccc;
	}
}

.inputbox {
	font-size: 15px;
	padding: 10px;
	position: relative;
	top: -60px;
	left: 180px;
	height: 40px;
	border-radius: 20px;
	border-color: rgb(189, 189, 189);
}

input:focus {
	outline: none;
	border-color: #84b9ff;
	box-shadow: 0 0 10px #9dd3ff;
}

.img {
	padding: 10px;
}

.result {
	font-size: 15px;
	padding-left: 20px;
	padding-right: 60px;
}

.normal {
	font-size: 20px;
}
</style>

<div class="img">
	<a href="http://localhost:8080/DS_HTML/TestProject"> <img
		src="img/p2.jpg" width=10%;></a>

	<form action='${requestUri}' method='get'>
		<input class="inputbox" type="text" placeholder="Search.." size="70">
	</form>
</div>

<div class="topnav">
	<a href="http://localhost:8080/DS_HTML/googleitem.jsp">全部</a><a
		href="http://localhost:8080/DS_HTML/picture.jsp">圖片</a> <a
		href="http://localhost:8080/DS_HTML/video.jsp">影片</a> <a
		class="active" href="http://localhost:8080/DS_HTML/news.jsp">新聞</a> <a
		href="http://localhost:8080/DS_HTML/map.jsp">地圖</a> <a
		href="http://localhost:8080/DS_HTML/more.jsp">更多</a>
</div>
<br>
<br>
</head>

<body>
	<div class="result">
		www.facebook.com › people › 詹又霓<br> <a class="normal"
			href="https://www.facebook.com/profile.php?id=100003167146300">詹又霓|
			Facebook</a><br>
		詹又霓，正在就讀政治大學企管系三年級。在行銷方面有優異的天份，不僅如此，又霓今年也在資訊公司實習，磨練寫程式的能力！根據消息指出她還很會跳舞，真是個多才多藝的斜槓青年！
		創意滿滿的她負責我們搜尋結果的美化以及專案內容的發想，是個活潑的點子王！Watch more ...<br> <br>
		www.facebook.com › people › 蘇奕丞<br> <a class="normal"
			href="https://www.facebook.com/profile.php?id=100002725239569">蘇奕丞|
			Facebook</a><br>
		蘇奕丞，正在就讀政治大學會計系四年級，並即將去台大當快樂資管人。人稱卷哥中的卷哥，大學四年已經不知道拿了幾個書卷獎，即便已有研究所成績依然優異的很是猖狂。
		不僅如此，霸氣扛起專案後端重責大任，屬於團隊中超偉大人物！Watch more ...<br> <br>
		www.facebook.com › people › 何季蓉<br> <a class="normal"
			href="https://www.facebook.com/profile.php?id=100004054816133 ">何季蓉|
			Facebook</a><br>
		何季蓉，正在就讀政治大學統計系四年級，英文溜到爆，並即將出國就讀研究所，每天都說好累好想睡，但對於各種課業報告或是工作永遠能夠輕輕鬆鬆極有效率的完事。
		並為團隊肩負起全英文報告的偉大使命，屬於團隊中幕前幕後功臣！Watch more ...<br> <br>
		www.facebook.com › people › 許祐齊<br> <a class="normal"
			href="https://www.facebook.com/profile.php?id=100002148912929">許祐齊|
			Facebook</a><br>
		許祐齊，正在就讀政治大學會計系四年級。靦腆的外表背後藏著的是澎派熱情。祐齊總是默默地把自己的工作做到最好！俗話說的好，祐齊辦事你放心！細心認真的他是前端網頁好夥伴，屬於團隊中負責任代表！Watch
		more ...<br> <br>
	</div>
</body>

</html>