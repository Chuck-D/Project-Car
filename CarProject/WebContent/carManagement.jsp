<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="com.carsales1.CarPurchase" %>
<%@ page import="java.util.ArrayList" %>
<% java.util.ArrayList<CarPurchase> salesHistory = (ArrayList<CarPurchase>) session.getAttribute("salesHistory"); %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Management Tools</title>
 <link rel="stylesheet" type="text/css" href="./Styles/styles2.css">
<link rel="stylesheet" type="text/css" href="./Styles/styles.css">


</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<a id="logo" href="#">Chuck's Cars</a>
		<a href="home.jsp">Home</a>
		<a href="newCars.jsp">New Cars</a>
		<a href="usedCars.jsp">Used Cars</a></nav>
	
	<div class="jumbotron text-center">
		<h1>Welcome Managers</h1>
		<h5>Administrative Options</h5>	
		
	</div>
	<div class="bg-img">
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<h3 style="margin-top:30px">Add New Vehicle</h3>
				<form id="carAddForm" action="AddCarServlet" method="post">
					<label for="modelYear">Year</label>
					<input type="text" name="modelYear" id="year">
					<br>
					
					<label for="make">Make</label>
					<input type="text" name="make" id="make">
					<br>
					
					<label for="model">Model</label>
					<input type="text" name="model" id="model">
					<br>
					
					<label for="price">Price</label>				
					<input type="text" name="price" id="price">
					<br>
					
					<label for="currentMileage">Mileage</label>
					<input type="text" name="currentMileage" id="mileage">
					<br>
					
					<label for="mpg">MPG</label>
					<input type="text" name="mpg" id="mpg">
					<br>
					
					<label for="engineType">Engine</label>
					<input type="text" name="engineType" id="engine">
					<br>
	
					<label for="transmissionType">Transmission</label>				
					<input type="text" name="transmissionType" id="transmission">
					<br>
	
					<label for="isNew">New Car (true/false)</label>				
					<input type="text" name="isNew" id="isNew">
					<br>
					
					<label for="carPhoto">Image Link</label>				
					<input type="text" name="carPhoto" id="photo">
					<br>				
					<button type="submit" class="btn btn-dark aquaHover">Submit</button>
				</form>
			</div>
			
			<div class="col-md-7">
				<h3 style="margin-top:30px">Sales History Report</h3>
				<table class="table table-bordered table-striped table-hover table-dark">
					<thead>
					
						<th>Name</th>
						<th>Make</th>
						<th>Model</th>
						<th>Purchase Date</th>
					</thead>
					<c:forEach var="purchase" items="${salesHistory}">
					
						<tr>
							<td>
								<c:out value="${purchase.firstName}"/>
								<c:out value="${purchase.lastName}"/>
							</td>
							<td>	
	 							<c:out value="${purchase.carPurchased.make}"/>
							</td>
							<td>	
								<c:out value="${purchase.carPurchased.model}"/>
							</td>
							<td>	
								<c:out value="${purchase.dateCustomerPurchased}"/>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			</div>
		</div> <!-- End row --> 
	</div> <!-- End container -->
	<hr>
</body>
</html>