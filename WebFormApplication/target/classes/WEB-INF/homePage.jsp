<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>YASH TECHNOLOGIES PRIVATE LIMITED</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
	&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
	&nbsp;&nbsp; &nbsp; &nbsp;

	<div>
		<button class="btn btn-dark btn-lg">
			<a href="/registerEmployee" >REGISTER EMPLOYEE</a>
		</button>
		&nbsp; &nbsp; &nbsp;
		<button class="btn btn-dark btn-lg">
			<a href="/viewEmployee">VIEW EMPLOYEE DETAILS</a>
		</button>
		&nbsp; &nbsp; &nbsp;
		<button class="btn btn-dark btn-lg" data-toggle="modal"
			data-target=".bd-example-modal-lg">
			<a href="/deleteEmployeeById">
			DELETE </a>
		</button>
		&nbsp; &nbsp; &nbsp;
		<button class="btn btn-dark btn-lg">
			<a href="updateRecords">UPDATE </a>
		</button>
	</div>

	<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="input-group col-sm-9">
					<input type="text" class="form-control"
						placeholder="Enter Employee ID To Delete" aria-label="Employee ID"
						aria-describedby="button-addon2">
						<button class="btn btn-outline-black" type="button"
							id="button-addon2" onclick="">Delete</button>

				</div>
			</div>
		</div>
	</div>

</body>
</html>
