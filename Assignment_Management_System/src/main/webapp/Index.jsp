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
 * {
	box-sizing: border-box;
}
 .navbar a {
	padding: 14px 16px;
	font-size: 17px;
}
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.container {
	padding: 20px;
	margin-top: 80px;
	height: 1000px;
}
@media (max-width:800px){
.form-group input,.input-group input,.form-group select{
margin:10px 0;
}
}
 </style>
    
    
    </head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
<div class="collapse navbar-collapse">
  <a  class="text-light" href="SignUp.jsp"><i class="fa fa-fw fa-user"></i> Sign up</a>
  <a  class="text-light" href="AdminSignIn.jsp"><i class="fa fa-fw fa-sign-in"></i> SignIn</a>
</div>
</nav>


    <div class="container">
		<div class="jumbotron">
        	<h2 align="center">Assignment management</h2>
        	<h3> ${msg}</h3>
        	
        	
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
    

    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>