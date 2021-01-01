<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NovelSearch</title>
<style>
<
style type ="text /css ">#sidebar {
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
	top: -55px;
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
	margin-top: 30px;
	margin-left: 20px;
}
</style>

<div class="img">
	<a href="http://localhost:8080/DS_HTML/TestProject"> <img
		src="img/p2.jpg" width=150 height=70;></a>

	<form action='${requestUri}' method='get'>
		<input class="inputbox" type="text" placeholder="Search.." size="70">
		
	</form>
</div>

<div class="topnav">
	<a class="active" href="http://localhost:8080/DS_HTML/googleitem.jsp">全部</a><a
		href="http://localhost:8080/DS_HTML/picture.jsp">圖片</a> <a
		href="http://localhost:8080/DS_HTML/video.jsp">影片</a> <a
		href="http://localhost:8080/DS_HTML/news.jsp">新聞</a> <a
		href="http://localhost:8080/DS_HTML/map.jsp">地圖</a> <a
		href="http://localhost:8080/DS_HTML/more.jsp">更多</a>
</div>
<br>
<br>
</head>
<body>

	<div id="content"
		style="height: 80%; width: 55%; float: left; margin-left: 160px">
		<%
		String[][] orderList = (String[][]) request.getAttribute("query");
		for (int i = 0; i < orderList.length; i++) {
		%>
		<a href='<%=orderList[i][1]%>'><%=orderList[i][0]%></a><br>
		<h style="font-size:10px ;"><%=orderList[i][1]%></h>
		<br> <br>
		<%
			}
		%>
	</div>
</body>
</html>