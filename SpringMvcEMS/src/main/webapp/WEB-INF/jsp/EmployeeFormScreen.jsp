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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/icheck-bootstrap@3.0.1/icheck-bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	
<style type="text/css">
.container-fluid {
	width: 85%;
}
</style>
</head>

<body>
	<nav class="navbar navbar-expand-xl navbar-dark bg-primary">
		<span class="navbar-brand h1 bold mb-0">Employee Management
			System</span>
	</nav>
	<div class="container-fluid mb-5">
		<div class="d-flex">
			<div class="mr-auto p-2 mt-2">
				<h1>Employee</h1>
			</div>
			<div class="p-2 align-self-end mb-1">
				<a href="employeeList" class="btn btn-secondary px-4 font-weight-bold">BACK</a>
			</div>
		</div>
		<s:form id="frm" action="saveEmployee" method="post"
			modelAttribute="employee">

			<s:hidden path="id" />
			<s:hidden path="" value="${employee.skills}" id="skills" />

			<table class="table table-responsive-xl">
				<!-- First Name -->
				<tr>
					<td class="col-md-2">
						<label for="fname">First Name:</label>
					</td>
					<td>
						<s:input path="fname" type="text" name="fname" id="fname" class="form-control" /> 
						<span id="fnameError"></span>
					</td>
				</tr>

				<!-- Last Name -->
				<tr>
					<td>
						<label for="lname">Last Name:</label>
					</td>
					<td>
						<s:input path="lname" type="text" name="lname" id="lname" class="form-control" /> 
						<span id="lnameError"></span></td>
				</tr>

				<!-- Last Name -->
				<tr>
					<td>
						<label for="age">Age:</label>
					</td>
					<td>
						<s:input path="age" type="text" name="age" id="age" class="form-control" /> 
						<span id="ageError"></span>
					</td>
				</tr>


				<!-- Gender -->
				<tr>
					<td>
						<label for="gender">Gender:</label>
					</td>
					<td>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:radiobutton path="gender" id="mgender" name="gender"
								value="male" />
							<label for="mgender">Male</label>
						</div>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:radiobutton path="gender" id="fgender" name="gender"
								value="female" />
							<label for="fgender">Female</label>
						</div> 
						<span id="genderError"></span>
					</td>
				</tr>

				<!-- Designation -->
				<tr>
					<td>
						<label for="desg">Designation:</label>
					</td>
					<td>
						<s:input path="desg" type="text" name="desg" id="desg" class="form-control" /> 
						<span id="desgError"></span>
					</td>
				</tr>

				<!-- Skills -->
				<tr>
					<td><label for="skills">Skills:</label></td>
					<td>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:checkbox path="skills" class="form-check-input" id="java"
								name="skills" value="java" />
							<label for="java">Java</label>
						</div>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:checkbox path="skills" class="form-check-input" id="php"
								name="skills" value="php" />
							<label for="php">PHP</label>
						</div>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:checkbox path="skills" class="form-check-input" id="python"
								name="skills" value="python" />
							<label for="python">Python</label>
						</div>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:checkbox path="skills" class="form-check-input" id="oracle"
								name="skills" value="oracle" />
							<label for="oracle">Oracle</label>
						</div>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:checkbox path="skills" class="form-check-input" id="spring"
								name="skills" value="spring" />
							<label for="spring">Spring</label>
						</div>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:checkbox path="skills" class="form-check-input" id="html"
								name="skills" value="html" />
							<label for="html">HTML</label>
						</div>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:checkbox path="skills" class="form-check-input" id="css"
								name="skills" value="css" />
							<label for="css">CSS</label>
						</div>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:checkbox path="skills" class="form-check-input"
								id="javascript" name="skills" value="javascript" />
							<label for="javascript">JavaScript</label>
						</div>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:checkbox path="skills" class="form-check-input" id="servlet"
								name="skills" value="servlet" />
							<label for="servlet">Servlet</label>
						</div>
						<div class="icheck-primary icheck-inline icheck-info">
							<s:checkbox path="skills" class="form-check-input" id="jsp"
								name="skills" value="jsp" />
							<label for="jsp">JSP</label>
						</div> <span id="skillsError"></span>
					</td>
				</tr>

				<!-- Date of Joining -->
				<tr>
					<td>
						<label for="doj">Date Of Joining:</label>
					</td>
					<td>
						<s:input path="doj" type="date" name="doj" id="doj" class="form-control w-25" placeholder=" " /> 
						<span id="dojError"></span>
					</td>
				</tr>

				<!-- State -->
				<tr>
					<td><label for="state">State:</label></td>
					<td>
						<!--- India states --> <s:select path="state" id="state"
							name="state" class="form-control w-25">
							<s:option value=""></s:option>
							<s:option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</s:option>
							<s:option value="Andhra Pradesh">Andhra Pradesh</s:option>
							<s:option value="Arunachal Pradesh">Arunachal Pradesh</s:option>
							<s:option value="Assam">Assam</s:option>
							<s:option value="Bihar">Bihar</s:option>
							<s:option value="Chandigarh">Chandigarh</s:option>
							<s:option value="Chhattisgarh">Chhattisgarh</s:option>
							<s:option value="Dadra Nagar Haveli">Dadra Nagar Haveli</s:option>
							<s:option value="Daman and Diu">Daman and Diu</s:option>
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
						</s:select> <span id="stateError"></span>
					</td>
				</tr>

				<!-- City -->
				<tr>
					<td>
						<label for="city">City:</label>
					</td>
					<td>
						<s:input path="city" type="text" name="city" id="city" class="form-control w-25" /> 
						<span id="cityError"></span>
					</td>
				</tr>

				<!-- Submit & Reset Button -->
				<tr>
					<td></td>
					<td>
						<input type="submit" id="smtb" value="SAVE" class="btn btn-primary mt-2 mx-2 px-4 font-weight-bold"> 
						<input type="reset" id="reset" value="CLEAR" class="btn btn-light mt-2 mx-2 px-4 font-weight-bold">
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	<!-- container end -->
	<footer class="card-footer text-center bg-light text-muted fixed-bottom py-0">
		@Copyright Employee Management System 
	</footer>
		
	<script src="<c:url value="/resources/js/validate.js"/>"></script>
</body>
</html>