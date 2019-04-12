<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.carsales1.Car" %>
<%@ page import="com.carsales1.CarPurchase" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./Styles/styles.css">

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
			<h3 style="padding:3px 15px 3px 15px;display:inline-block">
				<span style="font-weight:bold;color:#888"><c:out value="${carToPurchase.modelYear}"/></span>
				<span><c:out value="${carToPurchase.make}"/></span>
				<span style="font-weight:lighter"><c:out value="${carToPurchase.model}"/></span>
			</h3>
			<p style="margin-left:30px;color:#777">
				$<c:out value="${carToPurchase.price}"/>
			</p>	
			<img src="${carToPurchase.carPhoto}" style="width:200px;height:150px"><br>
		</div> <!-- End col -->
		
		<div class="col-md-8">
		<h3>Enter Customer Information</h3>
			<form id="checkoutForm" action="PurchaseServlet" method="get">
				<c:if test="${carToPurchase.isMoreThan120Days()}">
					<label for="bid">Lower Bid</label>
					<input type="text" name="bid" id="bid">
					<c:if test="${lowBid eq true}">
						<span class="error">Max discount exceeded</span>
					</c:if>
					<br>
				</c:if>
							
				<label for="firstName">First Name</label>
				<input type="text" name="firstName" id="firstName" required>
				<br>
								
				<label for="lastName">Last Name</label>
				<input type="text" name="lastName" id="lastName">
				<br>
				
				<label for="address">Address</label>
				<input type="text" name="address" id="address">
				<br>
				
				<label for="cardNum">Credit Card Number</label>
				<input type="text" name="cardNum" id="cardNum" required>
				<br>
				
			  	<input type="hidden" value="${carToPurchase.vinNumber}" name="vinNumber" id="firstName">
								
				<button type="submit" id="buyButton" class="btn btn-dark aquaHover">Buy</button>
			</form>
		</div>	

	</div> 
	
</body>
</html>