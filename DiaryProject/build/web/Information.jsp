<%-- 
    Document   : Signup
    Created on : Mar 6, 2023, 11:09:57 PM
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
.login-form {
    width: 340px;
    margin: 50px auto;
  	font-size: 15px;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
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
</style>
</head>
<body>
<div class="login-form">
    <form action="information" method="post">
        <h2 class="text-center">Who am i?</h2>    
        <p class="text-danger">${mess}</p>
        <div class="form-group">
            <input name="name" value='${data.getName()}' type="text" class="form-control" placeholder="Name" required="required">
                     
        </div>
        <div class="form-group">          
            <select name="gender" value='${data.getGender()}'class="form-control" required="required">
                <option>Male</option>
                <option>Female</option>
            </select>          
        </div>
       
        <div class="form-group">          
            <input type="date" name="dob" id="birthdate" value='${data.getDob()}' class="form-control" value="0000-00-00"  onchange="checkAge()" required="required">
             <span id="ageMsg"></span>
        </div>
        <div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">SAVE</button>
        </div>      
    </form>
    
</div>
<script>
  function checkAge() {
    var birthdate = new Date(document.getElementById("birthdate").value);
    var today = new Date();
    var age = today.getFullYear() - birthdate.getFullYear();
    var monthDiff = today.getMonth() - birthdate.getMonth();
    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthdate.getDate())) {
        age--;
    }
    if (age < 16) {
      document.getElementById("ageMsg").innerHTML = "You must be at least 16 years old.";
    
    } else {
      document.getElementById("ageMsg").innerHTML = "";
    }
  }
</script>
</body>
</html>