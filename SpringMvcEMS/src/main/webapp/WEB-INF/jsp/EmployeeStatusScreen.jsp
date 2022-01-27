<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<style type="text/css">
.container-fluid {
	width: 85%;
	text-align: left;
}

nav {
	width: 100%;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-xl navbar-dark bg-primary">
		<span class="navbar-brand h1 bold mb-0">Employee Management
			System</span>
	</nav>
	<div class="container-fluid mt-1 mb-5">

		<div class="d-flex justify-content-end">
			<!-- <div class="p-2 mt-1"></div> -->
			<div class="p-2 align-self-end mt-1 mb-2 m-auto">
				<c:if test="${not empty saveMsg}">
					<div class="text-success">
						<span id="saveMsg" class="h6">Employee Added Successfully</span>
					</div>
				</c:if>
				<c:remove var="saveMsg" scope="session" />
				
				<c:if test="${not empty expMsg}">
					<div class="text-success">
						<span id="expMsg" class="h6"><% out.print(session.getAttribute("expMsg")); %></span>
					</div>
				</c:if>
				<c:remove var="expMsg" scope="session" />

				<c:if test="${not empty updtMsg}">
					<div class="text-success">
						<span id="updtmsg" class="h6">Employee Updated Successfully</span>
					</div>
				</c:if>
				<c:remove var="updtMsg" scope="session" />

				<c:if test="${not empty delMsg}">
					<div class="text-success">
						<span id="delmsg" class="h6">Employee Deleted Successfully</span>
					</div>
				</c:if>
				<c:remove var="delMsg" scope="session" />

			</div>
			<div class="mt-4 mb-2">
				<a href="pdfexport" class="btn btn-success text-white btn-responsive float-right px-4 mr-2 font-weight-bold">EXPORT
				<i class="fa fa-file-pdf-o"></i>
				</a>
			</div>
			<div class="mt-4 mb-2">
				<a href="excelexport" class="btn btn-warning text-white btn-responsive float-right px-4 mr-2 font-weight-bold">EXPORT
				<i class="fa fa-file-excel-o"></i>
				</a>
			</div>
			<div class="mt-4 mb-2">
				<a href="showFormForAdd" class="btn btn-primary btn-responsive float-right px-4 font-weight-bold">ADD</a>
			</div>
		</div>

		<c:choose>
			<c:when test="${empty employeeList}">
				<div class="text-center">
					<span class="text-danger h6">no records found</span>
				</div>
			</c:when>
			<c:otherwise>
				<table class="table table-responsive-xl table-hover table-striped mb-2" id="table">
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
								<td class="text-nowrap">
									<a href="${updateLink}"> 
										<i class="fa fa-edit" style="font-size: 24px; color: rgb(0, 190, 127)"></i>
									</a> &nbsp;&nbsp; 
									<a href="${deleteLink}" onclick="if(!(confirm('Are you sure want to delete this Employee permanently?'))) return false">
										<i class="fa fa-trash" style="font-size: 24px; color:rgb(210, 8, 8)"></i>
									</a>
								</td>
								<td>${e.fname}</td>
								<td>${e.lname}</td>
								<td>${e.age}</td>
								<td>${e.gender}</td>
								<td>${e.desg}</td>
								<td>${e.skills}</td>
								<td class="text-nowrap">${e.doj}</td>
								<td>${e.city}</td>
								<td>${e.state}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
		<%-- <form action="${pageContext.request.contextPath}/ems/excelimport" enctype="multipart/form-data" method="post">
			<div class="d-flex justify-content-end mt-0 pt-0">
				<button class="btn btn-primary py-2">IMPORT
					<i class="fa fa-file-excel-o"></i>
				</button>
			</div>
		</form> --%>
	</div><!-- container end -->
	
	<footer class="card-footer text-center bg-light text-muted fixed-bottom py-0">
		@Copyright Employee Management System 
	</footer>
	<script type="text/javascript">
		$(document).ready(function() {

			/* var del = $("#del").val();
			if (del == "success") {
				$("#delmsg").show();
				$("#delmsg").html("Employee Deleted Successfully");
				$("#delmsg").css("color", "red");
			} else {
				$("#delmsg").hide();
			} */

			/* var updt = $("#updt").val();
			if (updt == "success") {
				$("#updtmsg").show();
				$("#updtmsg").html("Employee Updated Successfully");
				$("#updtmsg").css("color", "orange");
			} else {
				$("#updtmsg").hide();
			}

			var updt = $("#save").val();
			if (updt == "success") {
				$("#savemsg").show();
				$("#savemsg").html("Employee Added Successfully");
				$("#savemsg").css("color", "orange");
			} else {
				$("#savemsg").hide();
			} */

		});
	</script>
</body>
</html>