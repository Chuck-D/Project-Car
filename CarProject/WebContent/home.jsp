<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.carsales1.Car" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.ArrayList" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="./Styles/styles3.css">
<title>Chuck's Cars</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
		<a id="logo" href="#">Chuck's Cars</a>
		<a href="home.jsp">Home</a>
		<a href="newCars.jsp">New Cars</a>
		<a href="usedCars.jsp">Used Cars</a>
		
		<form class="form-inline" action="CarSearchServlet" method="get">
			<input class="form-control mr-sm-2 col-sm-0" type="search" name="modelSearch" placeholder="Search" aria-label="Search">
    		<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
    	</form>
		
		</nav>
		<p>
		<% java.util.ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars"); %>
		
	<div class="jumbotron text-center">
		<h1>Welcome!! Chuck's Cars has the best deals around!!!!</h1>
	</div>
	<img src="Photos/jaguar.jpg" style="width:100%; height:auto;">
	
	
	
	
	
	<div class="row" style="margin: 30px 0 0 30px">
		<c:forEach var="car" items="${cars}">
			<div class="col-md-4" style="margin-bottom: 35px">
				<img src="${car.carPhoto}" style="width:340px;height:260px"><br>
				<h4>
					<c:out value="${car.modelYear}"/>
					<c:out value="${car.make}"/>
					<c:out value="${car.model}"/>
				</h4>
				<p>
					$<c:out value="${car.price}"/>
				</p>
				
				<a href="DescriptionServlet?vinNumber=${car.vinNumber}">
					<button type="submit" class="btn btn-info">View Details</button>
				</a>	
			</div>
		</c:forEach>
	</div>
</body>
</html>