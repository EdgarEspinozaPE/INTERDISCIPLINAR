<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>CSID - Register Document</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
		<script src="validator.js"></script>
	</head>
	<body>
		<div class="container pt-5">
			<div class="text-center">
				<h1>Register Document</h1>
			</div>
			<div class="container p-3 my-3 bg-dark text-white">
				<form action="AdminDocumento?action=register&CUI=${CUI}" class="needs-validation" method="post" novalidate >
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="exampleFormControlSelect1">Category</label>
							<select class="form-control" id="exampleFormControlSelect1" name="categoria">
								<!--<option value="Matricula semestral">Matricula semestral</option>
								<option value="Matricula en curso de verano">Matricula en curso de verano</option>
								<option value="Rematricula">Rematricula</option>-->
								<c:forEach var="categorias" items="${lista}">
								<option value="${categorias}">${categorias}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomDate">Date</label>
							<input type="text" class="form-control" id="validationCustomDate" required name="fechadoc" >
							<div class="invalid-feedback">
								Please provide a valid date.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationSerialNumber">Serial number</label>
							<input type="text" class="form-control" id="validationSerialNumber" placeholder="Serial number" maxlength="45" required name="nroserie">
							<div class="invalid-feedback">
								Please provide a valid phone number.
							</div>
						</div>
					</div>
					<div class="col-md-4 mb-3">
							<label for="validationLink">Link</label>
							<input type="text" class="form-control" id="validationLink" placeholder="Link" maxlength="45" required name="direccionimagen">
							<div class="invalid-feedback">
								Please provide a valid phone number.
							</div>
						</div>

					<button class="btn btn-primary" type="submit">Register</button>
				</form>
			</div>
			
		</div>
	</body>
</html>