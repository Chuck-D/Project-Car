<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.carsales1.Car" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<% java.util.ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Cars</title>
<link rel="stylesheet" type="text/css" href="./Styles/styles3.css">
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
	</div>		
	
	<div class="row" style="margin: 30px 0 0 30px">
		<c:forEach items="${cars}"  var="car">
		
			<c:if test="${car.isNew== true}">
				<div class="col-md-4" style="margin-bottom: 30px">
					<img src="${car.carPhoto}" style="width:300px;height:250px"><br>
					<h3>
						${car.modelYear}
						${car.make}
						${car.model}
					</h3>
					<p>
						$${car.price}
					</p>
					
					<a href="DescriptionServlet?vinNumber=${car.vinNumber}">
						<button type="submit" class="btn btn-info">View Details</button>
					</a>
					
				</div>
			</c:if>
		</c:forEach>
	</div>

</body>
</html>