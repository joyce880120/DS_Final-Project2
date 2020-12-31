 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>NovelSearch</title>

<style>
<style type="text/css">
html{
 height: 100%;
}
p {font-family: Microsoft JhengHei;}
body{
text-align:center;
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
#footer{

 text-align:center;
 margin-top:200px;
 line-height:20px;
 font-size:13px;
 font-weight:bold;
 color:black;
}
.submit{
}
#input[type=submit] {
  width: 10%;
  background-color: #4CAF50;
  color: #E0E0E0;
  padding: 14px 20px;
  margin: 8px 0;
  border-top:1px black solid;
  border-radius: 4px;
  cursor: pointer;
}
.progress{
visibility: hidden; display: none;
}
.col-sm-6{text-align:center; left:24.5%}
</style>

</head>
<body >
<br>
<br>
<br>
<br>
<div>
<a href="http://localhost:8080/DS_HTML/TestProject"><img src="img/google1.png" alt="Google" width="270" height="140"></a>
</div>
<br>
<form action='${requestUri}' method='get' action="/action_page.php" >

<div class="col-sm-6">
 <input type='text' class="form-control" style="font-size:20px;border-radius: 20px;" name='keyword'>
 <span class="validity"></span>
</div>
<br>
<br>
<br>
<div class="submit" onclick="listBtn()">
 <input type='submit' class="btn btn-defaultt" style="font-size:20px;border:1px black solid;"  value="search" >
</div>
<script>
$(document).ready(function(){
  $(".btn").click(function(){
    $(this).button('loading');
  });   
});
</script>
</form>


<div id="footer">@Made by BeatGoogle Team.</div>

</body>
</html>