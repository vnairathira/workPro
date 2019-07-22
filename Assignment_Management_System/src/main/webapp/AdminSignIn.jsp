<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" href="style.css"> -->
<title>assignment-management</title>
<style>
.container {
	padding: 20px;
	margin-left:450px;
	margin-top: 25px;
	height: 1000px;
}

.navbar a {
	padding: 14px 16px;
	font-size: 17px;
}

.jumbotron {
	padding: 20px;
	margin-top: 80px;
	height: 400px;
	width: 400px
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
<div class="collapse navbar-collapse">
  <a class="active text-light" href="Index.jsp"><i class="fa fa-fw fa-home"></i>Home</a>  
  <a  class="text-light" href="SignUp.jsp"><i class="fa fa-fw fa-user"></i> Sign up</a>
  <a  class="text-light" href="AdminSignIn.jsp"><i class="fa fa-fw fa-sign-in"></i> SignIn</a>
</div>
</nav>

	<!-- Demo Content -->
	<div class="container">
		<div class="jumbotron">
			<h1 align="center">SignIn</h1>
			<div class="bs-example">
				<form action="adminSignIn" method="post"  onsubmit="return validation()">
					<div class="form-group col-sm-10">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email" placeholder="abcd@gmail.com">
							<span id="emailId" class="text-danger font-weight-bold"></span>
					</div>
					<div class="form-group col-sm-10">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password" placeholder="Password">
							<span id="pwd" class="text-danger font-weight-bold"></span>
					</div>
					<input type="hidden" id="eValid" name="eValid" value="${user.email}">
					<input type="hidden" id="pValid" name="pValid" value="${msg}">
					
					<div class="form-group row">
								<div class="col-sm-10 offset-sm-2">
									<button type="submit" class="btn btn-primary">Sign in</button>
									<button type="reset" class="btn btn-outline-dark">Close</button>
								</div>
								<!-- <span id="emsg" class="text-danger font-weight-bold"></span> -->
							</div>
							
				</form>
				  <p class="text-danger font-weight-bold text-md-center">${msg }<p>

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
    function validation(){
    	var email=document.getElementById('email').value;
    	var password=document.getElementById('password').value;
    	/* var eValid=document.getElementById('eValid').value;
    	String pValid=document.getElementById('pValid').value;
    	document.getElementById('emsg').innerHTML=pValid; */
    	
    	if(email==""){
    		document.getElementById('emailId').innerHTML="**please fill the email field";
    		return false;}
    	 /* if(eValid!=email){
    		document.getElementById('emailId').innerHTML="**please check your emailId ";
    		return false;}   */
    	else{document.getElementById('emailId').innerHTML=""}
    	
    	if(password==""){
    		document.getElementById('pwd').innerHTML="**please fill the password field";
    		return false;}
    	    /* if(password!=pValid){
    		document.getElementById('pwd').innerHTML="**please check your password in mail ";
    		return false;}  */ 
    	else{document.getElementById('pwd').innerHTML=""}
    	    	
    	
    	    }

    </script>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>