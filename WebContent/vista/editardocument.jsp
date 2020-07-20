<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>CSID - Edit</title>
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
				<h1>Editar Documento</h1>
			</div>

			<div class="container p-3 my-3 bg-dark text-white">
				<form class="needs-validation" action="AdminDocumento?action=editar&id=${documento.id}" method="post" novalidate>
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="validationCustomCategory">Categoría</label>
							<input type="text" class="form-control" id="validationCustomCategory" placeholder="Category" maxlength="8" name="categoria" value="${documento.categoria}" required>
							<div class="invalid-feedback">
								Please provide a valid category.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomDate">Fecha</label>
							<input type="text" class="form-control" id="validationCustomDate" placeholder="Date" maxlength="45" name="fechadoc" value="${documento.fechadoc}" required>
							<div class="invalid-feedback">
								Please provide the date.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomSerial">N° de serie</label>
							<input type="text" class="form-control" id="validationCustomSerial" placeholder="Serial" maxlength="8" name="nroserie" value="${documento.nroserie}" required>
							<div class="invalid-feedback">
								Please provide a valid serial.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomLink">Link</label>
							<input type="text" class="form-control" id="validationCustomLink" placeholder="Link" maxlength="45" name="direccionimagen" value="${documento.direccionimagen}" required>
							<div class="invalid-feedback">
								Please provide a link.
							</div>
						</div>
					</div>

					<button class="btn btn-primary" type="submit">Guardar</button>
				</form>
			</div>
		</div>
	</body>
</html>