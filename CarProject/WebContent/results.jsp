<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.carsales1.Car" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
</head>
<body>
<nav class="navbar navbar-dark bg-light">
		<a href="home.jsp">Home</a>
		<a href="newCars.jsp">New Cars</a>
		<a href="usedCars.jsp">Used Cars</a>
		<a href="index.jsp">Management Portal</a>
		
		<form class="form-inline" action="SearchServlet" method="post">
			<input class="form-control mr-sm-2 col-sm-0" type="search" name="modelSearch" placeholder="Search" aria-label="Search">
    		<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
    	</form>
		
		</nav>
		<div class="jumbotron text-center">
		<h1>Chuck's Cars</h1>
		<h5 style="color:#888">Search Results</h5>
	</div>
	
	<div style="margin: 30px 0 0 30px">
		<h4><span style="color:gray;margin-right:7px">Search results for:</span><c:out value="${modelSearch}"/></h4>
	</div>
	
	<div class="row" style="margin: 30px 0 0 30px">
		<c:forEach var="car" items="${searchResults}">
			<div class="col-md-4" style="margin-bottom: 30px">
				<img src="${car.carPhoto}" style="width:300px;height:250px"><br>
				<h3>
					<c:out value="${car.modelYear}"/>
					<c:out value="${car.make}"/>
					<c:out value="${car.model}"/>
				</h3>
				<p>
					$<c:out value="${car.carPrice}"/>
				</p>
				
				<a href="DescriptionServlet?vinNumber=${car.vinNumber}">
					<button type="submit" class="btn btn-info">View Details</button>
				</a>	
			</div>	
		</c:forEach>
	</div>
	
</body>
</html>