<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- <link rel="stylesheet" href="style.css"> -->
    <title>assignment-management</title>
    
<style>
.container {
	padding: 20px;
	margin-top: 80px;
	height: 1000px;
}

.navbar a {
	padding: 14px 16px;
	font-size: 17px;
}
.form-group label,.input-group label{
margin:5px 10px 5px 0;
}
.form-group input,.input-group input,.form-group select{

vertical-align:middle;
margin:5px 10px 5px 0;
padding:10px;
border: 1px solid #ddd;
}


.jumbotron {
	padding: 20px;
	margin-top: 80px;
	height: 600px;
	
	 margin-left: auto;
  margin-right: auto;
  width: 40%;
}
</style>    
    
    </head>
<body onload="myfunction()">

<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
<div class="collapse navbar-collapse">
  <a class="active text-light" href="#"><i class="fa fa-fw fa-home"></i>Home</a>  
  <a  class="text-light" href="#"><i class="fa fa-fw fa-user"></i> Sign up</a>
  <a  class="text-light" href="#"><i class="fa fa-fw fa-sign-in"></i> Login</a>
</div>
</nav>


    	<!-- Demo Content -->
	<div class="container">
		<div class="jumbotron">
			<h2 align="center">Reset Password</h2><br>
			<div class="bs-example">
				<form action="changePwd" method="post" onsubmit="return validation()">
					<div class="form-group col-sm-10">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email"  value="${user.email}">
							<span id="emailId" class="text-danger font-weight-bold"></span>
						
					</div>
					<div class="form-group col-sm-10">
						<label for="oldPwd">Old password</label> <input type="password"
							class="form-control" id="oldPwd" name="oldPwd" placeholder="Old password" >
							<span id="oldPass" class="text-danger font-weight-bold"></span>
						
					</div>
					<div class="form-group col-sm-10">
						<label for="newPwd">New Password</label> <input type="password"
							class="form-control" id="newPwd" name="newPwd" placeholder="New Password">
							<span id="newPass" class="text-danger font-weight-bold"></span>
					</div>
					<div class="form-group col-sm-10">
						<label for="cnfrmPwd">Confirm Password</label> <input type="password"
							class="form-control" id="cnfrmPwd" name="cnfrmPwd" placeholder="Confirm Password">
							<span id="cnfrmPass" class="text-danger font-weight-bold"></span>
					</div>
					
					<input type="hidden" id="custId" name="custId" value="${msg}">
				<div class="form-group row">
								<div class="col-sm-10 offset-sm-2">
									<button type="submit" class="btn btn-primary">Change</button>
									<button type="reset" class="btn btn-outline-dark">Close</button>
								</div>
							</div>
				</form>

			</div>
		</div>

	</div>
   <nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-bottom">
        <div class="collapse navbar-collapse" id="navbarCollapse">
		   <div class="navbar-nav ">
				<p class="text-light col-md-6 text-md-left"><br>Copyright&copy;Assignment_management@2019</p>
			</div>
         </div>
             <div class="col-md-6 text-md-right">
			<a href="#" class="text-light">Terms of Use</a>
			<span class="text-muted mx-2">|</span>
			<a href="#" class="text-light">Privacy Policy</a>
		</div>
    </nav>

   

    <script type="text/javascript">
    function myfunction(){
    	var emailId=document.getElementById('email').value;
    	document.getElementById('email').innerHTML=emailId;
    }
    
    function validation(){
    	var email=document.getElementById('email').value;
    	var oldPwd=document.getElementById('oldPwd').value;
    	var newPwd=document.getElementById('newPwd').value;
    	var cnfrmPwd=document.getElementById('cnfrmPwd').value;
    	var custId=document.getElementById('custId').value;
    	
    	if(email==""){
    		document.getElementById('emailId').innerHTML="**please fill the email field";
    		return false;}else{document.getElementById('emailId').innerHTML=""}
    	
    	if(oldPwd==""){
    		document.getElementById('oldPass').innerHTML="**please fill the oldpwd field";
    		return false;}
    	  if(oldPwd!=custId){
    		document.getElementById('oldPass').innerHTML="**please check your password in mail ";
    		return false;}  
    	else{document.getElementById('oldPass').innerHTML=""}
    	
    	 if(newPwd==""){
    		document.getElementById('newPass').innerHTML="**please fill the newPwd field";
    		return false;} 
    	 if((newPwd.length<8) ||(newPwd.length>12)){
    		document.getElementById('newPass').innerHTML="**password length must be 8 to 12";
    		return false;}
    	if(newPwd.search(/[0-9]/)<0){
    		document.getElementById('newPass').innerHTML="**password must contain atleast 1 digit,1 small letter,1 capital letter,one special charecter";
		return false;}
    	if(newPwd.search(/[a-z]/)<0){
    		document.getElementById('newPass').innerHTML="**password must contain atleast 1 digit,1 small letter,1 capital letter,one special charecter";
    		return false;}
    	if(newPwd.search(/[@$,<>#:?_*&;]/)<0){
    		document.getElementById('newPass').innerHTML="**password must contain atleast 1 digit,1 small letter,1 capital letter,one special charecter";
    		return false;}
    	if(newPwd.search(/[A-Z]/)<0){
    		document.getElementById('newPass').innerHTML="**password must contain atleast 1 digit,1 small letter,1 capital letter,one special charecter";
    		return false;}
    	
    	else{document.getElementById('newPass').innerHTML=""}
    	
    	
    	if(cnfrmPwd==""){
    		document.getElementById('cnfrmPass').innerHTML="**please fill the cnfrmPwd field";
    		return false;}
    	if(newPwd!=cnfrmPwd){
    		document.getElementById('cnfrmPass').innerHTML="**passwords are not matching";
    		return false;}else{document.getElementById('cnfrmPass').innerHTML=""}
    }
    </script>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>