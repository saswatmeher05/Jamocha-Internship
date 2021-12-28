<%@page import="com.employee.model.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!Doctype html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EMS-Add Employee</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
</head>
<body>
	<nav class="navbar bg-primary text-white">
		<span class="navbar-brand h1 bold mb-0">Employee Management
			System</span>
	</nav>
	<div class="row my-4">
		<div class="col-6 float-left">
			<h1 class="text-dark ml-5 pl-5">Employee</h1>
		</div>
		<div class="col-6 pr-5">
			<a href="listOfEmployee" class="btn btn-secondary float-right mr-5">Back To Employee Table</a>
		</div>
	</div>
	<div class="container mt-5">

		<s:form id="frm" action="saveEmployee" method="post"
			modelAttribute="employee">
			
			<s:hidden path="id" />
			<s:hidden path="" value="${employee.skills}" id="skills" />
			<!-- First Name -->
			<div class="row my-1">
				<div class="col-3">
					<label for="fname" class="px-2">First Name:</label>
				</div>
				<div class="col-4">
					<s:input path="fname" type="text" name="fname" id="fname"
						class="form-control" />
				</div>
				<div class="col-5">
					<span id="fnameError"></span>
				</div>
			</div>

			<!-- Last Name -->
			<div class="row my-1">
				<div class="col-3">
					<label for="lname" class="px-2">Last Name:</label>
				</div>
				<div class="col-4">
					<s:input path="lname" type="text" name="lname" id="lname"
						class="form-control" />
				</div>
				<div class="col-5">
					<span id="lnameError"></span>
				</div>
			</div>

			<!-- Age -->
			<div class="row my-1">
				<div class="col-3">
					<label for="age" class="px-2">Age:</label>
				</div>
				<div class="col-4">
					<s:input path="age" type="text" name="age" id="age"
						class="form-control" />
				</div>
				<div class="col-5">
					<span id="ageError"></span>
				</div>
			</div>

			<!-- Gender -->
			<div class="row my-1">
				<div class="col-3">
					<label for="gender" class="px-2">Gender:</label>
				</div>
				<div class="col-4 text-center">
					<div class="form-check-inline">
						<s:radiobutton path="gender" value="male" name="gender" id="gender" class="form-check-input" />Male &nbsp;&nbsp;
						<s:radiobutton path="gender" value="female" name="gender" id="gender" class="form-check-input" />Female
					</div>
				</div>
				<div class="col-5">
					<span id="genderError"></span>
				</div>
			</div>

			<!-- Designation -->
			<div class="row my-1">
				<div class="col-3">
					<label for="desg" class="px-2">Designation:</label>
				</div>
				<div class="col-4">
					<s:input path="desg" type="text" name="desg" id="desg"
						class="form-control" />
				</div>
				<div class="col-5">
					<span id="desgError"></span>
				</div>
			</div>

			<!-- Skills -->
			<div class="row my-1">
				<div class="col-3">
					<label for="skills" class="px-2">Skills</label>
				</div>
				<div class="col-4">
				<s:checkbox path="skills" name="skills" value="java"/>Java &nbsp;
				<s:checkbox path="skills" name="skills" value="python"/>Python &nbsp;
				<s:checkbox path="skills" name="skills" value="php"/>PHP &nbsp;
				<s:checkbox path="skills" name="skills" value="oracle"/>Oracle &nbsp;
				<s:checkbox path="skills" name="skills" value="spring"/>Spring <br>
				<s:checkbox path="skills" name="skills" value="html"/>HTML &nbsp;
				<s:checkbox path="skills" name="skills" value="css"/>css &nbsp;
				<s:checkbox path="skills" name="skills" value="javascript"/>JavaScript &nbsp;
				<s:checkbox path="skills" name="skills" value="servlet"/>Servlet &nbsp;
				<s:checkbox path="skills" name="skills" value="jsp"/>JSP
				
					<%-- <s:select path="skills" multiple="true"
						class="form-control text-center" name="skills" id="skills">
						<s:option value="java">Java</s:option>
						<s:option value="python">Python</s:option>
						<s:option value="php">PHP</s:option>
						<s:option value="oracle">Oracle</s:option>
						<s:option value="spring">Spring</s:option>
						<s:option value="html">HTML</s:option>
						<s:option value="css">CSS</s:option>
						<s:option value="javascript">javascript</s:option>
						<s:option value="servlet">Servlet</s:option>
						<s:option value="jsp">JSP</s:option>
					</s:select> --%>
				</div>
				<div class="col-5">
					<span id="skillsError"></span>
				</div>
			</div>

			<!-- Date of Joining -->
			<div class="row my-1">
				<div class="col-3">
					<label for="doj" class="px-2">Date Of Joining:</label>
				</div>
				<div class="col-4">
					<s:input path="doj" type="date" name="doj" id="doj"
						class="form-control text-center" />
				</div>
				<div class="col-5">
					<span id="dojError"></span>
				</div>
			</div>

			<!-- City -->
			<div class="row my-1">
				<div class="col-3">
					<label for="city" class="px-2">City:</label>
				</div>
				<div class="col-4">
					<s:input path="city" type="text" name="city" id="city"
						class="form-control" />
				</div>
				<div class="col-5">
					<span id="cityError"></span>
				</div>
			</div>

			<!-- State -->
			<div class="row my-1">
				<div class="col-3">
					<label for="state" class="px-2">State:</label>
				</div>
				<div class="col-4">
					<!--- India states -->
					<s:select path="state" id="state" name="state"
						class="form-control text-center">
						<s:option value="">-select state-</s:option>
						<s:option value="Andaman and Nicobar Islands">Andaman and
							Nicobar Islands</s:option>
						<s:option value="Andhra Pradesh">Andhra Pradesh</s:option>
						<s:option value="Arunachal Pradesh">Arunachal Pradesh</s:option>
						<s:option value="Assam">Assam</s:option>
						<s:option value="Bihar">Bihar</s:option>
						<s:option value="Chandigarh">Chandigarh</s:option>
						<s:option value="Chhattisgarh">Chhattisgarh</s:option>
						<s:option value="Dadra Nagar Haveli">Dadra Nagar Haveli</s:option>
						<s:option value="Daman and Diu">Daman and Diu</s:option>
						<s:option value="Delhi">Delhi</s:option>
						<s:option value="Goa">Goa</s:option>
						<s:option value="Gujarat">Gujarat</s:option>
						<s:option value="Haryana">Haryana</s:option>
						<s:option value="Himachal Pradesh">Himachal Pradesh</s:option>
						<s:option value="Jammu and Kashmir">Jammu and Kashmir</s:option>
						<s:option value="Jharkhand">Jharkhand</s:option>
						<s:option value="Karnataka">Karnataka</s:option>
						<s:option value="Kerala">Kerala</s:option>
						<s:option value="Ladakh">Ladakh</s:option>
						<s:option value="Lakshadweep">Lakshadweep</s:option>
						<s:option value="Madhya Pradesh">Madhya Pradesh</s:option>
						<s:option value="Maharashtra">Maharashtra</s:option>
						<s:option value="Manipur">Manipur</s:option>
						<s:option value="Meghalaya">Meghalaya</s:option>
						<s:option value="Mizoram">Mizoram</s:option>
						<s:option value="Nagaland">Nagaland</s:option>
						<s:option value="Odisha">Odisha</s:option>
						<s:option value="Puducherry">Puducherry</s:option>
						<s:option value="Punjab">Punjab</s:option>
						<s:option value="Rajasthan">Rajasthan</s:option>
						<s:option value="Sikkim">Sikkim</s:option>
						<s:option value="Tamil Nadu">Tamil Nadu</s:option>
						<s:option value="Telangana">Telangana</s:option>
						<s:option value="Tripura">Tripura</s:option>
						<s:option value="Uttar Pradesh">Uttar Pradesh</s:option>
						<s:option value="Uttarakhand">Uttarakhand</s:option>
						<s:option value="West Bengal">West Bengal</s:option>
					</s:select>
				</div>
				<div class="col-5">
					<span id="stateError"></span>
				</div>
			</div>

			<input type="submit" value="Save" class="btn btn-primary px-5 mt-2">&nbsp;
			
		</s:form>
	</div>
	<!-- Container End -->

	<footer
		class="card-footer text-center bg-light text-muted fixed-bottom">
		@Copyright Employee Management System </footer>
		

	<script src="<c:url value="/resources/js/validate.js"/>"></script>
</body>
</html>