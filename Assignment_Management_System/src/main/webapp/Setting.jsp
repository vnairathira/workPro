<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<style>
.navbar a{
padding :14px 16px;
font-size:17px;
}
</style>
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
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
<div class="collapse navbar-collapse">
  <a class="active text-light" href="Home.jsp"><i class="fa fa-fw fa-home"></i>Home</a>
  <a class="active text-light" href="Logout"><i class="fa fa-sign-out"></i>Logout</a>
</div>
</nav>
	<div class="container">
		<div class="jumbotron">
			<h2 align="center">edit profile</h2><br>
			<div class="bs-example">
				<form action="setting" method="post" onsubmit="return validation()">
											
					<div class="form-group col-sm-10">
						<label for="fName">First Name</label> <input type="text"
							class="form-control" id="fName" name="fName" value="${user.fName }">
							<span id="firstName" class="text-danger font-weight-bold"></span>
					</div>
					
					<div class="form-group col-sm-10">
						<label for="lName">Last Name</label> <input type="text"
							class="form-control" id="lName" name="lName" value="${user.lName}" >
							<span id="lastName" class="text-danger font-weight-bold"></span>
					</div>
					
					<div class="form-group col-sm-10">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email" value="${user.email}" readonly="readonly">
					</div>
			
					<div class="form-group col-sm-10">
						<label for="phone">Phone</label> <input type="text"
							class="form-control" id="phone" name="phone" value="${user.phone}">
							<span id="phoneNo" class="text-danger font-weight-bold"></span>
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
	function validation(){
		var fName=document.getElementById('fName').value;
    	var lName=document.getElementById('lName').value;
    	var phone=document.getElementById('phone').value;
    	
    	if(fName==""){
    		document.getElementById('firstName').innerHTML="**please fill the First Name field";
    		return false;}
    	if(!isNaN(fName)){
    		document.getElementById('firstName').innerHTML="**only characters are allowed";
    		return false;}
    	else{document.getElementById('firstName').innerHTML=""}
    		
    	if(lName==""){
    		document.getElementById('lastName').innerHTML="**please fill the Last Name field";
    		return false;}
    	if(!isNaN(lName)){
    		document.getElementById('lastName').innerHTML="**only characters are allowed";
    		return false;}
    	else{document.getElementById('lastName').innerHTML=""}
    	
    	if(phone==""){
    		document.getElementById('phoneNo').innerHTML="**please fill the PhoneNo field";
    		return false;}
    	if(isNaN(phone)){
    		document.getElementById('phoneNo').innerHTML="**only numbers are allowed";
    		return false;}
    	if(phone.length!=10){
    		document.getElementById('phoneNo').innerHTML="**Mobile no should be 10 digits only";
    		return false;}
    	else{document.getElementById('phoneNo').innerHTML=""}
    		   	
	}
</script>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>