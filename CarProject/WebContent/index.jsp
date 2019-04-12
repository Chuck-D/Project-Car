<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chuck's Cars</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./Styles/styles.css">
</head>
<body>
<div class="wrapper fadeInDown">


  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
    Please login
    
    </div>
    <div id = "pic1"><img src="Photos/jaguar.jpg" style="width:100%; height:auto;"></div>

    <!-- Login Form -->
    <form action = "LoginServlet1" method = "post">
      <input type="text" id="login" class="fadeIn second" name="loginName" placeholder="Manager's ID" required>
      <input type="text" id="password" class="fadeIn third" name="password" placeholder="password" required>
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>

    <!--Password assistance -->
    <div id="formFooter">
      <a class="underlineHover">Forgot Password?  Please contact Administrator</a>
    </div>

  </div>
</div>
</body>
</html>