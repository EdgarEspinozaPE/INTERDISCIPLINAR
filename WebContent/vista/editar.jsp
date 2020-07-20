<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<h1>Editar Estudiante</h1>
			</div>

			<div class="container p-3 my-3 bg-dark text-white">
				<form action="AdminAlumno?action=editar&id=<c:out value="${alumno.id}" />" class="needs-validation" method="post" novalidate>
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="validationCustomCUI">CUI</label>
							<input type="text" class="form-control" id="validationCustomCUI" placeholder="CUI" maxlength="8" name="CUI" value='<c:out value="${alumno.CUI}"></c:out>' required>
							<div class="invalid-feedback">
								Please provide a valid CUI.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomDNI">DNI</label>
							<input type="text" class="form-control" id="validationCustomDNI" placeholder="DNI" maxlength="8" name="DNI" value='<c:out value="${alumno.DNI}"></c:out>' required>
							<div class="invalid-feedback">
								Please provide a valid DNI.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomFathersSurname">Father's surname</label>
							<input type="text" class="form-control" id="validationCustomFathersSurname" placeholder="Father's surname" maxlength="45" name ="apellido_paterno" value='<c:out value="${alumno.paterno}"></c:out>' required>
							<div class="invalid-feedback">
								Please type the student's first surname.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomMothersSurname">Mother's surname</label>
							<input type="text" class="form-control" id="validationCustomMothersSurname" placeholder="Mother's surname" maxlength="45" name= "apellido_materno" value='<c:out value="${alumno.apellidomaterno}"></c:out>' required>
							<div class="invalid-feedback">
								Please type the student's second surname.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomBirthday">Fecha Nacimiento</label>
							<input type="text" class="form-control" id="validationCustomBirthday" placeholder="Birthday" maxlength="45" name="fecha_nacimiento" value='<c:out value="${alumno.fechanacimiento}"></c:out>' required>
							<div class="invalid-feedback">
								Please type the student's birthday.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomDirection">Direccion</label>
							<input type="text" class="form-control" id="validationCustomDirection" placeholder="Direction" maxlength="45" name="direccion" value='<c:out value="${alumno.direccion}"></c:out>' required>
							<div class="invalid-feedback">
								Please type the student's birthday.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomPhone">Telefono</label>
							<input type="text" class="form-control" id="validationCustomPhone" placeholder="Phone" maxlength="45" name="telefono" value='<c:out value="${alumno.telefono}"></c:out>' required>
							<div class="invalid-feedback">
								Please type the student's birthday.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomLevel">Nivel</label>
							<input type="text" class="form-control" id="validationCustomLevel" placeholder="Level" maxlength="45" name="nivel" value='<c:out value="${alumno.nivel}"></c:out>' required>
							<div class="invalid-feedback">
								Please type the student's birthday.
							</div>
						</div>
					</div>

					<button class="btn btn-primary" type="submit">Guardar</button>
				</form>
			</div>
		</div>
	</body>
</html>