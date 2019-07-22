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
<title>assignment-management</title>
<script type="text/javascript">
	var jsonData;
	var sd;
	function fetchCountryDetails() {
		sd = document.getElementById("selectName");
		//var countryName = document.getElementById("countryName").value;
		var url = "https://restcountries.eu/rest/v2/all";
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					jsonData = JSON.parse(xmlHttp.responseText);
					/* document.getElementById("selectCode").innerHTML = "countries : "
							+ jsonData[0].callingCodes; */
					var i;
					for (i = 0; i < jsonData.length; i++) {
						sd.options.add(new Option(jsonData[i].name));
					}
				} else if (xmlHttp.status == 404) {
					alert("Not valid country ");
				}
			}
		}
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
	}
	function selectCode() {
		var index = selectName.selectedIndex - 1;
		var cd = document.getElementById("cc");
		//cd.options.add(new Option(jsonData[index].callingCodes));
		code.value = jsonData[index].callingCodes;
	}
	
	function validation(){
		var fName=document.getElementById('fName').value;
    	var lName=document.getElementById('lName').value;
    	var email=document.getElementById('email').value;
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
    	
    	if(email==""){
    		document.getElementById('emailId').innerHTML="**please fill the email field";
    		return false;}
    	if(email.indexOf('@')<=0){
    		document.getElementById('emailId').innerHTML="** @ at invalid position ";
    		return false;}
    	if((email.charAt(email.length-4)!='.') && (email.charAt(email.length-3)!='.')){
    		document.getElementById('emailId').innerHTML="** invalid email ";
    		return false;}
    	
    	else{document.getElementById('emailId').innerHTML=""}
    	
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

.main {
	 padding: 20px;
	margin-left:350px;
	margin-top: 80px;
	height: 1000px;
}

.form-group, .input-group {
	dispaly: flex;
	flex-flow: row wrap;
	align-items: center;
}

.form-group label, .input-group label {
	margin: 5px 10px 5px 0;
}

.form-group input, .input-group input, .form-group select {
	vertical-align: middle;
	margin: 5px 10px 5px 0;
	padding: 10px;
	border: 1px solid #ddd;
}

@media ( max-width :800px) {
	.form-group input, .input-group input, .form-group select {
		margin: 10px 0;
	}
	.form-group, .input-group {
		flex-direction: column;
		align-items: stretch;
	}
}
</style>
</head>
<body onload="fetchCountryDetails()">
	<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
		<div class="collapse navbar-collapse">
			<a class="active text-light" href="Index.jsp"><i
				class="fa fa-fw fa-home"></i>Home</a> <a class="text-light"
				href="SignUp.jsp"><i class="fa fa-fw fa-user"></i> Sign up</a> <a
				class="text-light" href="AdminSignIn.jsp"><i
				class="fa fa-fw fa-sign-in"></i> SignIn</a>
		</div>
	</nav>
	<div class="main" align="center">
		<form action="signUp" method="post"  onsubmit="return validation()">
			<div class="container-fluid">
				<div class="row">
					<div class="jumbotron">
						<h1 class="text-center">Sign Up</h1>
						<br>

						<div class="input-group">
							<div class="input-group">
								<label class="input-group">Name</label>
							</div>
							
							<input type="text" class="form-control col-sm-5" placeholder="First name" name="fName" id="fName"> 
								<input type="text" class="form-control col-sm-5" placeholder="Last name" name="lName" id="lName">
							</div>
								<span id="firstName" class="text-danger font-weight-bold"></span>
								<span id="lastName" class="text-danger font-weight-bold"></span>
						<div class="form-group row">
							<label for="email" class="col-sm-2 col-form-label">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="EmailId@gmail.com">
							</div>
							<span id="emailId" class="text-danger font-weight-bold"></span>
						</div>
						
						<div class="form-group row">
								<label for="country" class="col-sm-2 col-form-label">Country</label> 
								<div class="col-sm-10">
								<select class=" form-control" name="country" id="selectName" onchange="selectCode()" >
									<option value="null">--Select--</option>
								</select>
								</div>
							</div>
						<div class="form-row">

							<div class="form-group col-sm-3">
								<label for="code">Code</label> <input type="text"
									class="form-control" id="code" name="code">
							</div>

							<div class="form-group col-sm-7">
								<label for="phone">Phone</label> <input type="text"
									class="form-control" id="phone" name="phone"
									placeholder="Phone">
							</div>
							<span id="phoneNo" class="text-danger font-weight-bold"></span>
						</div>

						<div class="form-group row">
							<div class="col-sm-10 offset-sm-2">
								<button type="submit" class="btn btn-primary">Sign Up</button>
								<button type="reset" class="btn btn-outline-dark">Close</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
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