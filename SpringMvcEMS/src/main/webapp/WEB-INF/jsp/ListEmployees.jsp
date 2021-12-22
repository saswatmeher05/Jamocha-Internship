<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EMS</title>
</head>

<body>
	<nav class="navbar bg-primary text-white"> <span
		class="navbar-brand h1 bold mb-0">Employee Management System</span> </nav>
	<div class="container-fluid mt-5">
		<div>
			<a href="showFormForAdd" class="btn btn-success float-right">Add
				Employee</a>
		</div>

		<div>
			<table class="table table-hover table-striped">
				<thead class="bg-primary text-white">
					<tr>
						<th>Action</th>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
						<th>Gender</th>
						<th>Designation</th>
						<th>Skills</th>
						<th>DOJ</th>
						<th>City</th>
						<th>State</th>

					</tr>
				</thead>
				<c:forEach items="${employeeList}" var="e">
					<c:url var="updateLink" value="/ems/displayUpdateForm">
						<c:param name="id" value="${e.id}" />
					</c:url>

					<c:url var="deleteLink" value="/ems/displayDeleteForm">
						<c:param name="id" value="${e.id}" />
					</c:url>
					<tbody>
						<tr>
							<td><a href="${updateLink}"><i class="fa fa-edit"
									style="font-size: 24px; color: orange"></i></a> &nbsp; <a
								href="${deleteLink}"
								onclick="if(!(confirm('Are you sure want to delete this Employee permanently?'))) return false">
									<i class="fa fa-trash" style="font-size: 24px; color: red"></i>
							</a></td>
							<td>${e.id}</td>
							<td>${e.fname}</td>
							<td>${e.lname}</td>
							<td>${e.age}</td>
							<td>${e.gender}</td>
							<td>${e.desg}</td>
							<td>${e.skills}</td>
							<td>${e.doj}</td>
							<td>${e.city}</td>
							<td>${e.state}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>

	</div>



</body>
</html>
<jsp:include page="common.jsp"/>