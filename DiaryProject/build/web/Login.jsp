<%-- 
    Document   : Login
    Created on : Mar 6, 2023, 4:36:50 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MY STORY</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
    .back{
        background: url(https://marketplace.canva.com/EAFJVhDBObw/1/0/1600w/canva-blue-and-yellow-floral-pattern-desktop-wallpaper-JtylQxwr420.jpg);
        height: 100vh;
     
    }
    body{
        height:100vh;
        }
.login-form {
    padding-top: 150px;
    width: 340px;
    margin: auto auto;
  	font-size: 15px;
     
}
.login-form form {
     box-shadow: inset 0px 0px 4px rgba(0, 0, 0, 0.25);
    margin-bottom: 15px;
    background: #f7f7f7;
    
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
.title {
  text-align: center;
  margin-top: 50px;
  font-family: 'Helvetica Neue', sans-serif;
}

h1 {
  font-size: 48px;
  font-weight: bold;
  text-transform: uppercase;
}

span {
  font-size: 64px;
  color: #ff7f50;
  text-shadow: 2px 2px 0px #333;
}
.text-center a{
    
    color:white
}
</style>
</head>
<body>
    <div class="back">
    <div class="login-form">
        <div class="title">
  <h1>My <span>Story</span></h1>
</div>
    <form action="login" method="post">
        <h2 class="text-center">Log in</h2>    
        <p class="text-danger">${mess}</p>
        <div class="form-group">
            <input name="username" type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>       
    </form>
    
    <p class="text-center"><a href="Signup.jsp">Create an Account</a></p>
    </div>
    
</div>
</body>
</html>