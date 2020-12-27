  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NovelSearch</title>
<style>
<style type="text/css">
html{
	height: 100%;
}
p {font-family: Microsoft JhengHei;}
#all{
text-align:center;
}
body{
	background-image: url('img/background.jpg');
	background-repeat:no-repeat;
	background-size:cover;
}
#header{
	width:250px;
	text-align:center;
	margin:100px auto;
	font-size:40px;
	color:black;
	font-weight:600;
	background-color:white;
	border-radius: 100px;
}
#Body{
	text-align:center;
	margin:0px auto;
	line-height:30px;
	font-size:15px;
	color:#ffffff;
	font-weight:bold;
}
#footer{

	text-align:center;
	margin-top:200px;
	line-height:20px;
	font-size:13px;
	font-weight:bold;
	color:black;
}
#search{
	padding:10px 25px;
	border:10px black solid;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	font-family: Microsoft JhengHei;
	background-color:#fffaf3;
}
#submit{
	padding:5px 15px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	font-family: Microsoft JhengHei
}
#text{
	padding:10px 25px;
	border:1px black solid;
	-webkit-border-radius: 10px;
	border-radius: 10px;
	font-family: Microsoft JhengHei;
	background-color:white;
}
input {padding:5px 15px; background:grey; border:0 none;
cursor:pointer;
-webkit-border-radius: 5px;
border-radius: 5px; }


</style>
</head>
<body background="../img/background.jpg">
  
<div class="bg">

<div id="header"><font face='微軟正黑體'>小說搜尋器</font></div>

<div id="Body">
<form action='${requestUri}' method='get'>

<input type='text' style="font-size:25px" name='keyword' placeholder = '請輸入關鍵字'/>
<input type='submit' style="font-size:25px"  value="搜尋">
<input type="reset" style="font-size:25px" value="重設">
</form>
<div></div>
<img src="img/google.png" width="500" height="300" ></div>
<div id="footer">@Made by BeatGoogle Team.</div>
</div>

</body>
</html>