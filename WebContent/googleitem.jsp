<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NovelSearch</title>
<style>
<style type="text/css">
#sidebar{
	text-align:center;
	border:1px gray solid;
}
#search{
	margin-left:10px; 
	padding:5px 15px;
	border:1px black solid;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	font-family: Microsoft JhengHei;
	background-color:#fffaf3;
}
#submit{
	padding:5px 15px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	font-family: Microsoft JhengHei;
}
</style>
</head>
<body>
<div id="Header" style="height:10%;">
<a href="http://localhost:8080/DS_HTML/TestProject" style="padding:5px 15px;text-decoration:none;font-family: Microsoft JhengHei;text-align:center;height:100%;width:10%; float:left;color:white;border-radius: 5px;background-color:black;">小說搜尋器</a>


<form action='${requestUri}' method='get'>
<input id='search' type='text' name='keyword' placeholder = '請輸入關鍵字'/>
<input id='submit' type='submit' value='搜尋' />
<br>
<br>
</form>
</div>
<div id="content" style="height:80%;width:55%;float:left;margin-left:160px">
<%
String[][] orderList = (String[][])  request.getAttribute("query");
for(int i =0 ; i < orderList.length;i++){%>
	<a href='<%= orderList[i][1] %>'><%= orderList[i][0] %></a><br><h style="font-size:10px ;"><%= orderList[i][1] %></h><br><br>
<%
}
%>
</div>
</body>
</html>