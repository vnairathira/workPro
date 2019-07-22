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
	height: 700px;
	width: 400px
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
<div class="collapse navbar-collapse">
  <a class="active text-light" href="Home.jsp"><i class="fa fa-fw fa-home"></i>Home</a> 
  <a  class="text-light" href="Logout"><i class="fa fa-sign-out"></i> Logout</a>
</div>
</nav>

	<!-- Demo Content -->
	<div class="container">
		<div class="jumbotron">
			<h1 align="center">Create Assignment</h1>
			<div class="bs-example">
				
				<form action="createAssignment"  method="post">
				
					<div class="form-group">
						<label for="course">Course</label>
						 <select  class="form-control" id="course" name="course" onchange="populate(this.id,'topic')">
						    <option value="">--Select--</option>
						    <option value="Java">Java</option>
						    <option value="Hibernate">Hibernate</option>
						    <option value="Spring">Spring</option>
						 </select>
					</div>
					<div class="form-group">
						<label for="topic">Topic</label>
						 <select class="form-control" id="topic" name="topic"></select>
					</div>
					<div class="form-group">
						<label for="description">Description</label>
						 <textarea rows="5" cols="5" class="form-control" id="description" name="description"></textarea>	
					</div>
					<div class="form-group">
						<label for="deadLine">Deadline</label>
						 <input type="date" class="form-control" id="deadLine" name="deadLine">	
					</div>
					<div class="form-group">
						<label for="uploadType">Upload Type</label>
						 <select class="form-control" id="uploadType" name="uploadType">
						 	<option value="">--Select--</option>
							<option value="zip">Zip</option>
							<option value="git">Git</option>
						 </select>
					</div>
					
										
					<div class="form-group row">
						<div class="col-sm-10 offset-sm-2">
							<button type="submit" class="btn btn-primary">Create</button>
							<button type="reset" class="btn btn-outline-dark">Clear</button>
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
		function populate(s1,s2){
			var s1=document.getElementById(s1);
			var s2=document.getElementById(s2);
			s2.innerHTML="";
			if(s1.value=="Java"){
				var optionArray=["|","oops|Oops","exception|Exception","thread|Thread","collection|Collection"];
			}else if(s1.value=="Hibernate"){
				var optionArray=["|","session|Session","sessionFactory|SessionFactory","query|Query","criteria|Criteria"];
			}else if(s1.value=="Spring"){
				var optionArray=["|","dependencyInjection|DependencyInjection","orm|Orm","springMVC|SpringMVC","springAOP|SpringAOP"];
			}
			for(var option in optionArray){
				var pair=optionArray[option].split("|");
				var newOption=document.createElement("option");
				newOption.value=pair[0];
				newOption.innerHTML=pair[1];
				s2.options.add(newOption);
			}
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