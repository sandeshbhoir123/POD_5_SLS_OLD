<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<meta name="viewport" content= "width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css/">
		<title>TSD Home</title>
		<link rel="stylesheet" type="text/css" href="/The-School-Directory/resources/CSS/style.css">
		<link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
</head>
<body>
<header>
			<div id="header-container">
				<div class ="col-3">
					<img class="logo" src="/The-School-Directory/resources/Images/TSDLogo.png" height="50" width="135">
				</div>
				<div class="col-3">
				<nav>
				<!--Navbar startshere,-if needed uncomment the below -->
					<ul class="menu">
						<!-- <li>Home</li>
						<li>Features</li>
						<li>About</li>
						<li>Contact Us</li> -->
					</ul>
				</nav>
				</div>
				<!-- Divided the navbar into 3 columns.
				One is icon,second is for class menu,third is for login and suggestion buttons -->
				<div class="col-3">
					<!-- THIS IS FOR LOGIN BUTTON -->
					<a href="<c:url value="/login"/>" class="loginBTN">Login</a>
					<!-- THIS IS FOR SUGGESTION BUTTON ,BUT NAMED IT AS SEARCH-->
					<a href="<c:url value="/suggestion"/>" class="SearchBTN">Suggestions</a>
				</div>
				<!--Header-Container Ends Here-->
		</header>
		<div class="main-container">
			<div id="top-section-main">
				<div id="top-section-content">
					<h1>Find Your Future</h1>
					<p>Get the latest school updates here!!</p>
					<h3>LIFE IS A JOURNEY...CHOOSE YOUR PATH WISELY!!</h3>
					</br>
					</br>
					<!-- Buttons for School listing and searching options -->
					<div class="main-form">
						<div id="buttons">
							<a href="<c:url value="/signUp"/>">
								<button  class="btn1">Lookup a School you are interested in<span></span></button>
							</a>
							<a href="<c:url value="/school/search"/>">
								<button  class="btn2">Search for Schools that we have for you<span></span></button>
							</a>
						</div>
					</div>
				</div>
			</div> 
		</div>
		<!--End main-container-->
	</body>
</body>
</html>