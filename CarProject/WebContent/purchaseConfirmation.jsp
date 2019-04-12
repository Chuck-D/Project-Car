<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./Styles/styles.css">

<meta charset="UTF-8">
<title>Purchase Confirmation</title>
</head>
<body>
<nav class="navbar navbar-dark bg-light">
		<a href="home.jsp">Home</a>
		<a href="newCars.jsp">New Cars</a>
		<a href="usedCars.jsp">Used Cars</a>		
		<a href="index.jsp">Management Portal</a>
			
		
		<form class="form-inline" action="CarSearchServlet" method="post">
			<input class="form-control mr-sm-2 col-sm-0" type="search" name="modelSearch" placeholder="Search" aria-label="Search">
    		<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
    	</form>
	</nav>
	<div class="jumbotron text-center">
		<h1>Chuck's Cars</h1>
		<h5 style="color:#888">Checkout</h5>
	</div>
	
	<div class="row" style="margin: 30px 0 0 30px">
		<div class="col-md-4">
			<p>
				Thanks for your order, <c:out value="${firstName}"></c:out>! You ordered:
			</p>
				<h3>
				<span style="font-weight:bold;color:#888"><c:out value="${carToPurchase.modelYear}"/></span>
				<span><c:out value="${carToPurchase.make}"/></span>
				<span style="font-weight:lighter"><c:out value="${carToPurchase.model}"/></span>
			</h3>
			<a href="home.jsp">Go back to Home screen?</a>
			<p>${vinNumber}</p>			
		</div> 
	</div>
	
</body>
</html>