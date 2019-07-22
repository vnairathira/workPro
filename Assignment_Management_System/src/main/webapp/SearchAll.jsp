
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
.table {
	border: 3px solid;
	border-collapse: collapse;
	font-size: 16px;
	font-weight: bold;
	fonr-style: italic;
	/* color: blue; */
	align: left;
}

.container {
	padding: 20px;
	margin-top: 80px;
	height: 1000px;
}

.navbar a {
	padding: 14px 16px;
	font-size: 17px;
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

* {
	box-sizing: border-box;
}

/* Style the search field */
form.example input[type=text] {
	padding: 10px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	width: 30%;
	background: #f1f1f1;
	margin-left: 400px;
}

/* Style the submit button */
form.example button {
	float: left;
	width: 5%;
	padding: 10px;
	background: #2196F3;
	color: white;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none; /* Prevent double borders */
	cursor: pointer;
}

form.example button:hover {
	background: #0b7dda;
}

/* Clear floats */
form.example::after {
	content: "";
	clear: both;
	display: table;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
		<div class="collapse navbar-collapse">
			<a class="active text-light" href="Index.jsp"><i
				class="fa fa-fw fa-home"></i>Home</a> <a class="text-light" href="#"><i
				class="fa fa-fw fa-upload"></i> Upload</a> <a class="text-light"
				href="SignUp.jsp"><i class="fa fa-fw fa-user"></i> Sign up</a> <a
				class="text-light" href="AdminSignIn.jsp"><i
				class="fa fa-fw fa-sign-in"></i> SignIn</a>
		</div>
	</nav>


	<div class="container">
		<div class="bs-example">
			<h3 align="center">search here</h3>

			<input type="text" placeholder="Search.." name="search" id=searchId>
			<input type="button" class="fa fa-search" onclick="loadSearchData()"
				value="Search">
		</div>

	</div>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-bottom">
        <div class="collapse navbar-collapse" id="navbarCollapse">
<div class="navbar-nav ">
				<p class="text-light">Copyright &copy; assignment-management@2019</p>
			</div>
             </div>
             <div class="col-md-6 text-md-right">
			<a href="#" class="text-light">Terms of Use</a>
			<span class="text-muted mx-2">|</span>
			<a href="#" class="text-light">Privacy Policy</a>
			</div>
    </nav>
    	<script type="text/javascript">
		var pin = document.getElementById("searchId").value;
		//var pin=parseInt(id,10);
		var baseurl = "http://localhost:8080/Assignment_Management_System/searchAllPin/"
				+ pin + "/";
		function loadSearchData() {

			console.log("Hello world");
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.open("GET", baseurl + "/all", true);
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

					console.log(xmlhttp.responseText);
					var searchData = JSON.parse(xmlhttp.responseText);
					/*  var tbltop = `<table> */
					<tr><th>Course</th><th>Deadline</th><th>Description</th><th>Topic</th><th>Upload
					type</th></tr>;
					for (i = 0; i < searchData.length; i++) {
						main += "<tr><td>" + searchData[i].course + "</td><td>"
								+ searchData[i].deadLine + "</td><td>"
								+ searchData[i].description + "</td><td>"
								+ searchData[i].topic + "</td><td>"
								+ searchData[i].uploadType + "</td></tr>";
					}
					var tblbottom = "</table>";
					/* var tbl = tbltop + main + tblbottom; */
					var tbl = main + tblbottom;
					document.getElementById("table").innerHTML = tbl;
				}
			}
			xmlhttp.open("GET", baseurl, true);
			xmlhttp.send();
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