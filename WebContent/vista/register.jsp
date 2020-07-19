<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<title>CSID - Register</title>
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
				<h1>Register</h1>
			</div>
			<!--p>In this example, we use <code>.needs-validation</code>, which will add the validation effect AFTER the form has been submitting (if there's anything missing).</p>
			<p>Try to submit this form before filling out the input fields, to see the effect.</p-->
			<div class="container p-3 my-3 bg-dark text-white">
				<!--form class="needs-validation" novalidate>
					<div class="form-row justify-content-center align-items-center">
						<div class="col-md-4 mb-3">
							<label for="validationCustomEmail">E-mail</label>
							<div class="input-group">
								<input type="text" class="form-control" id="validationCustomEmail" placeholder="E-mail"aria-describedby="inputGroupPrepend" required>
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroupPrepend">@unsa.edu.pe</span>
								</div>
								<div class="invalid-feedback">
								Please type type E-mail.
								</div>
							</div>
						</div>
					</div>
					<div class="form-row justify-content-center align-items-center">
						<div class="col-md-4 mb-3">
							<label for="validationCustomPassword">Password</label>
								<input type="password" class="form-control" id="validationCustomPassword" placeholder="Password" required>
								<div class="invalid-feedback">
								Please type your password.
								</div>
						</div>
					</div>
					<div class="d-flex justify-content-center pt-5">
						<button class="btn btn-primary col-md-4 mb-3" type="submit">Login</button>
					</div>
				</form-->
				<!--h1>My First Bootstrap Page</h1>
				<p>This container has a blue background color and a white text, and some extra padding and margins.</p-->

				<form action="AdminAlumno?action=register" class="needs-validation" novalidate method="post">
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="validationCustomFirstName">Name</label>
							<input type="text" class="form-control" id="validationCustomFirstName" placeholder="First name" maxlength="45" required>
							<!--div class="valid-feedback">
									Looks good!
							</div-->
							<div class="invalid-feedback">
								Please type the student's name.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomFathersSurname">Father's surname</label>
							<input type="text" class="form-control" id="validationCustomFathersSurname" placeholder="Father's surname" maxlength="45" required name="apellido_paterno">
							<!--div class="valid-feedback">
									Looks good!
							</div-->
							<div class="invalid-feedback">
								Please type the student's first surname.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomMothersSurname">Mother's surname</label>
							<input type="text" class="form-control" id="validationCustomMothersSurname" placeholder="Mother's surname" maxlength="45" required name="apellido_materno">
							<div class="valid-feedback">
								Looks good!
							</div>
							<div class="invalid-feedback">
								Please type the student's second surname.
							</div>
						</div>
						<!--div class="col-md-4 mb-3">
							<label for="validationCustomUsername">Username</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroupPrepend">@</span>
								</div>
								<input type="text" class="form-control" id="validationCustomUsername" placeholder="Username" aria-describedby="inputGroupPrepend" required>
								<div class="invalid-feedback">
									Please choose a username.
								</div>
							</div>
						</div-->
					</div>

					<div class="form-row">
						<div class="col-md-4 mb-3">
							<!--label for="validationCustomCUI">CUI</label>
							<input type="text" class="form-control" id="validationCustomCUI" placeholder="CUI" maxlength="8" required>
							<div class="invalid-feedback">
								Please provide a valid CUI.
							</div-->
							<label for="validationCustomEmail">E-mail</label>
							<div class="input-group">
								<input type="text" class="form-control" id="validationCustomEmail" placeholder="E-mail"aria-describedby="inputGroupPrepend" required>
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroupPrepend">@unsa.edu.pe</span>
								</div>
								<div class="invalid-feedback">
									Please type type E-mail.
								</div>
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<!--input type="text" name="date" id="date" class="form-control datepicker" value="" required />
							<label for="date">Date</label>
							<div class="invalid-feedback">
								Please select a valid date.
							</div-->
							<!--label for="validationCustomDate">Birthday</label>
							<input type="text" class="form-control" id="validationCustomDate" placeholder="Birthday" maxlength="45" required>
							<div class="valid-feedback">
								Looks good!
							</div>
							<div class="invalid-feedback">
								Please type the student's birthday.
							</div-->
							<label for="validationCustomDate">Date</label>
							<input type="text" class="form-control" id="validationCustomDate" required name="fecha_nacimiento">
							<div class="invalid-feedback">
								Please provide a valid date.
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomPhone">Phone</label>
							<input type="text" class="form-control" id="validationCustomPhone" placeholder="Phone 123-456-789" pattern="[0-9]{3}-[0-9]{3}-[0-9]{3}" maxlength="11" required name="telefono">
							<div class="invalid-feedback">
								Please provide a valid phone number.
							</div>
						</div>
					</div>

					<div class="form-row">
						<div class="col-md-2 mb-3">
							<label for="validationCustomCUI">CUI</label>
							<input type="text" class="form-control" id="validationCustomCUI" placeholder="CUI" maxlength="8" required name="CUI">
							<div class="invalid-feedback">
								Please provide a valid CUI.
							</div>
						</div>
						<div class="col-md-2 mb-3">
							<label for="validationCustomDNI">DNI</label>
							<input type="text" class="form-control" id="validationCustomDNI" placeholder="DNI" maxlength="8" required name = "DNI">
							<div class="invalid-feedback">
								Please provide a valid DNI.
							</div>
						</div>
						<div class="col-md-8 mb-3">
							<label for="validationCustom05">Address</label>
							<input type="text" class="form-control" id="validationCustom05" placeholder="Address" required name="direccion">
							<div class="invalid-feedback">
								Please provide a valid Address. 
							</div>
						</div>
					</div>

					<div class="form-row">
						<div class="col-md-2 mb-3">
							<label for="validationCustomLevel">Level</label>
							<input type="text" class="form-control" id="validationCustomLevel" placeholder="Level" maxlength="20" required name="nivel">
							<div class="invalid-feedback">
								Please provide a valid Level.
							</div>
						</div>
						<div class="col-md-2 mb-3">
							<label for="validationCustomYearOfEntering">Year of entering</label>
							<input type="text" class="form-control" id="validationCustomYearOfEntering" placeholder="Year of entering" maxlength="4" required>
							<div class="invalid-feedback">
								Please provide a valid year.
							</div>
						</div>
					</div>

					<!--div class="form-row">
						<div class="col-md-6 mb-3">
							<label for="validationCustom03">City</label>
							<input type="text" class="form-control" id="validationCustom03" placeholder="City" required>
							<div class="invalid-feedback">
								Please provide a valid city.
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="validationCustom04">State</label>
							<input type="text" class="form-control" id="validationCustom04" placeholder="State" required>
							<div class="invalid-feedback">
								Please provide a valid state.
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="validationCustom05">Zip</label>
							<input type="text" class="form-control" id="validationCustom05" placeholder="Zip" required>
							<div class="invalid-feedback">
								Please provide a valid zip.
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
							<label class="form-check-label" for="invalidCheck">
								Agree to terms and conditions
							</label>
							<div class="invalid-feedback">
								You must agree before submitting.
							</div>
						</div>
					</div-->
					<button class="btn btn-primary" type="submit">Register</button>
				</form>
			</div>
			
		</div>
	</body>
</html>