<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CSID - Student</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">		
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>

<body>
		<div class="container pt-5">
			<div class="text-center">
				<h1>Student</h1>
			</div>
			
			<div class="container p-3 my-3 bg-dark">
				<h2>Card Image</h2>
				<p>Image at the top (card-img-top):</p>
				<div class="card" style="width:400px">
					<img class="card-img-top" src="sho.jpg" alt="Card image" style="width:100%">
					<div class="card-body">
						<h4 class="card-title text-black"><c:out value="${alumno.paterno}"></c:out><c:out value="${alumno.apellidomaterno}"></c:out></h4>
						<p class="card-text text-black"><c:out value="${alumno.CUI}"></c:out></p>
						<a href="#" class="btn btn-primary">See Profile</a>
					</div>
				</div>
			</div>
		</div>
</body>
</html>