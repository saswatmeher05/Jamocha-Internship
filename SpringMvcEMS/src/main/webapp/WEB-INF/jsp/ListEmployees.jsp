<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EMS</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<nav class="navbar bg-primary text-white">
		<span class="navbar-brand h1 bold mb-0">Employee Management
			System</span>
	</nav>
	<div class="container-fluid mt-5">
		<h2 id="deleteMsg">${delMsg}</h2>
		<div>
			<a href="showFormForAdd" class="btn btn-success float-right">Add
				Employee</a>
		</div>

		<div>
			<table class="table table-hover table-striped">
				<thead class="bg-primary text-white">
					<tr>
						<th>Action</th>
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
							<td>
							<a href="${updateLink}"><i class="fa fa-edit" style="font-size: 24px; color: orange"></i></a> &nbsp;&nbsp; 
							<a href="${deleteLink}" onclick="if(!(confirm('Are you sure want to delete this Employee permanently?'))) return false">
								<i class="fa fa-trash" style="font-size: 24px; color: red"></i>
							</a>
							</td>
							<td>${e.fname}</td>
							<td>${e.lname}</td>
							<td>${e.age}</td>
							<td>${e.gender}</td>
							<td>${e.desg}</td>
							<td>${e.skills}</td>
							<%-- <c:set var="dd" value="${fn:substring(e.doj,8,10)}"></c:set>
							<c:set var="mm" value="${fn:substring(e.doj,5,7)}"></c:set>
							<c:set var="yyyy" value="${fn:substring(e.doj,0,4)}"></c:set>
							<td>
							${dd}-${mm}-${yyyy}
							</td> --%>
							<td>${e.doj}</td>
							<td>${e.city}</td>
							<td>${e.state}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>

	</div>

	<footer
		class="card-footer text-center bg-light text-muted fixed-bottom">
		@Copyright Employee Management System </footer>
	<script type="text/javascript">
		$(document).ready(function () {
			var val=$("#deleteMsg").val();
			if(val!=null){
				$("#deleteMsg").show();
			}else{
				$("#deleteMsg").hide();
			}
		});
	</script>
</body>
</html>