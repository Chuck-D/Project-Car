<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.carsales1.Car" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Details</title>
<link rel="stylesheet" type="text/css" href="./Styles/styles.css">
<link rel="stylesheet" type="text/css" href="./Styles/styles3.css">
</head>
<body>
	 <nav class="navbar navbar-dark bg-light">
		<a href="home.jsp">Home</a>
		<a href="newCars.jsp">New Cars</a>
		<a href="usedCars.jsp">Used Cars</a>
		<c:if test="${manager eq true}">
			<a href="carManagement.jsp">Management</a>
		</c:if>
		
		<form class="form-inline" action="SearchServlet" method="post">
			<input class="form-control mr-sm-2 col-sm-0" name="modelSearch" type="search" placeholder="Search" aria-label="Search">
    		<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
    	</form>
	</nav>
	
	<div class="jumbotron text-center">
		<h1>Details</h1>
	</div>
	
	<div class="row">
		<div class="col-md-4" style="padding:80px 0 0 30px">
		 	<h1>
		<div class="col-md-8">
			<img src="${carInfo.carPhoto}" style="width:650px;height:500px">
		</div>
		 		<span style="color:#266;font-size:80px"><c:out value="${carInfo.modelYear}"/></span><br>
		 		<span style="font-weight:bold"><c:out value="${carInfo.make}"/></span>
		 		<span style="font-weight:lighter"><c:out value="${carInfo.model}"/></span>
		 	</h1>	
		 	<h4 style="color:aquamarine;background-color:#333;display:inline;padding:5px 15px 5px 15px">
		 	 	$<c:out value="${carInfo.price}"/>
		 	</h4>
		 	<br>
		 	<div id="info">
			 	<table>
			 
			 		<tr>
			 			<td>
			 				<p class="infoHeader">Mileage:</p>
			 			</td>
			 			<td>
			 				<p><c:out value="${carInfo.currentMileage}"/></p>
			 			</td>
			 		</tr>
			 		<tr>
			 			<td>
			 				<p class="infoHeader">MPG:</p>
			 			</td>
			 			<td>
			 				<p><c:out value="${carInfo.mpg}"/></p>
			 			</td>
			 		</tr>
			 		<tr>
			 			<td>
			 				<p class="infoHeader">Engine:</p>
			 			</td>
			 			<td>
			 				<p><c:out value="${carInfo.engineType}"/></p>
			 			</td>
			 		</tr>
			 		<tr>
			 			<td>
			 				<p class="infoHeader">Transmission:</p>
			 			</td>
			 			<td>
			 				<p><c:out value="${carInfo.transmissionType}"/></p>
			 			</td>
			 		</tr>
			 		
			
			 	</table>
		 	</div> 
		 	
		 	<br>
		 	<a href="CheckoutServlet?vinNumber=${carInfo.vinNumber}">
		 		<button class="btn btn-dark aquaHover" id="checkOutButton">Checkout</button>
		 	</a>		
		</div>
	
	</div>

 	
	<hr>
	
</body>
</html>