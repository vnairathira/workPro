<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	height: 1000px;
	justify-content: center;
}

.form-group, .input-group {
	dispaly: flex;
	flex-flow: row wrap;
	align-items: center;
}

.form-group label, .input-group label {
	margin: 80px 100px 30px 0; 
}

.form-group input, .input-group input, .form-group select {
	vertical-align: middle;
	margin: 5px 10px 5px 0;
	padding: 10px;
	border: 1px solid #ddd;
}
.mytable{
margin-top:100px;
}
@media ( max-width :800px) {
	.form-group input, .input-group input, .form-group select {
		margin: 10px 0;
	}
	.form-group, .input-group {
		flex-direction: column;
		align-items: stretch;
	}
}</style>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
		<div class="collapse navbar-collapse">
			<a class="active text-light" href="Home.jsp"><i class="fa fa-fw fa-home"></i>Home</a>
				<a  class="text-light" href="Logout"><i class="fa fa-sign-out"></i>  Logout</a> 
		</div>
	</nav>
	<div class="container">
		<div class="bs-example">
		<h3 align="center"></h3>
			<form class="example" action="search" method="post">
			<div class="input-group">
							<div class="input-group">
							<h3>	<label class="input-group">search here</label></h3>
							</div>
							
							<input type="text" class="form-control col-sm-3" placeholder="Cource" name="course" id="cource"> 
								<input type="text" class="form-control col-sm-3" placeholder="Topic" name="topic" id="topic">
								<button type="submit" class="btn btn-primary">Search</button>
							</div>
			
			</form>
		</div><br>
	<div class="mytable">
	  <table class="table">
    <thead>
      <tr>
        <th>Course Name</th>
        <th>Topic Name</th>
        <th>Description</th>
        <th>Deadline</th>
         <th>Upload type</th>
         <th>Generated Pin</th>
      </tr>
    </thead>
    <tbody>  
     <c:forEach var="user" items="${user}">  
      <tr class="success">
        <td>${user.course}</td>
        <td>${user.topic}</td>
        <td>${user.description}</td>
        <td>${user.deadLine}</td>
		<td>${user.uploadType}</td>
		<td>${user.generatedPin}</td>
      </tr>
     </c:forEach> 
   </tbody>
  </table>	
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