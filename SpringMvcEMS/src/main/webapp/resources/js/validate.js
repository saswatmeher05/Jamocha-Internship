$(document).ready(function() {
	$("#frm").bind("submit", function() {
		//get input values
		var fname = $("#fname").val();
		var lname = $("#lname").val();
		var age = $("#age").val();
		var gender = $('input[type="radio"][name="gender"]:checked').length;
		var desg = $("#desg").val();
		var skills = $('input[type="checkbox"][name="skills"]:checked').length;
		var doj = $("#doj").val();
		var city = $("#city").val();
		var state = $("#state").val();

		//useful regex
		var fnameRegex = /^[A-Za-z0-9\s\_\.]{2,30}$/;
		var lnameRegex = /^[A-Za-z0-9\s\_\.]{2,30}$/;
		var ageRegex = /^[0-9]{1,2}$/;

		//form validation 
		if (fname == "") {
			$("#fname").addClass("border-danger");
			alert("Enter First Name");
			$("#fname").focus();
			return false;
		}
		else if (!fnameRegex.test(fname)) {
			$("#fname").addClass("border-danger");
			alert("Invalid First Name");
			$("#fname").focus();
			return false;
		} else {
			$("#fname").removeClass("border-danger");
		}


		if (lname == "") {
			$("#lname").addClass("border-danger");
			alert("Enter Last Name");
			$("#lname").focus();
			return false;
		}
		else if (!lnameRegex.test(lname)) {
			$("#lname").addClass("border-danger");
			alert("Invalid Last Name");
			$("#lname").focus();
			return false;
		} else {
			$("#lname").removeClass("border-danger");
		}


		if (age == "") {
			$("#age").addClass("border-danger");
			alert("Enter Age");
			$("#age").focus();
			return false;
		} else if (!ageRegex.test(age)) {
			$("#age").addClass("border-danger");
			alert("Invalid Age Characters Not Allowed");
			$("#age").focus();
			return false;
		} else if (age < 15 || age > 80) {
			$("#age").addClass("border-danger");
			alert("Age Allowed : 15-80");
			$("#age").focus();
			return false;
		} else {
			$("#age").removeClass("border-danger");
		}


		if (gender == 0) {
			alert("Chose Gender");
			return false;
		} else {
			$("#genderError").hide();
		}


		if (desg == "") {
			$("#desg").addClass("border-danger");
			alert("Enter Designation");
			$("#desg").focus();
			return false;
		} else {
			$("#desg").removeClass("border-danger");
		}


		if (skills == 0) {
			alert("Chose At least One Skill");
			return false;
		} else {
			$("#skillsError").hide();
		}


		if (!doj) {
			$("#doj").addClass("border-danger");
			alert("Select Date Of Joining");
			$("#doj").focus();
			return false;
		} else {
			$("#doj").removeClass("border-danger");
		}


		if (city == "") {
			$("#city").addClass("border-danger");
			alert("Enter City");
			$("#city").focus();
			return false;
		} else {
			$("#city").removeClass("border-danger");
		}


		if (state == "") {
			$("#state").addClass("border-danger");
			alert("Chose State");
			$("#state").focus();
			return false;
		} else {
			$("#state").removeClass("border-danger");
		}

	});


	//form events
	//first name
	$("#fname").change(function() {
		var fname = $("#fname").val();
		var fnameRegex = /^[A-Za-z]{2,30}$/;
		if (fname == "") {
			$("#fname").addClass("border-danger");
		}
		else if (!fnameRegex.test(fname)) {
			$("#fname").addClass("border-danger");
		}
		else {
			$("#fname").removeClass("border-danger");
		}
	});


	//last name
	$("#lname").change(function() {
		var lname = $("#lname").val();
		var lnameRegex = /^[A-Za-z]{1,30}$/;
		if (lname == "") {
			$("#lname").addClass("border-danger");

		}
		else if (!lnameRegex.test(lname)) {
			$("#lname").addClass("border-danger");
		}
		else {
			$("#lname").removeClass("border-danger");
		}
	});

	//age
	$("#age").change(function() {
		var age = $("#age").val();
		var ageRegex = /^[0-9]{1,2}$/;
		if (age == "") {
			$("#age").addClass("border-danger");
		}
		else if (!ageRegex.test(age)) {
			$("#age").addClass("border-danger");
		} else if (age < 15 || age > 80) {
			$("#age").addClass("border-danger");
		}
		else {
			$("#age").removeClass("border-danger");
		}
	});

	//gender
	$("input[type='radio'][name='gender']").click(function() {
		if (!($('input[type="radio"][name="gender"]').length == 0)) {
			$("#genderError").hide();
		}
	});


	//designation
	$("#desg").change(function() {
		var desg = $("#desg").val();
		if (desg == "") {
			$("#desg").addClass("border-danger");
		} else {
			$("#desg").removeClass("border-danger");
		}
	});


	//skills
	$('input[type="checkbox"][name="skills"]').click(function() {
		if ($(('input[type="checkbox"][name="skills"]').length == 0)) {
			$("#skillsError").hide();
		}
	});

	//date of joining
	$("#doj").change(function() {
		var doj = $("#doj").val();
		if (!doj) {
			$("#doj").addClass("border-danger");
		} else {
			$("#doj").removeClass("border-danger");
		}
	});

	//city
	$("#city").change(function() {
		var city = $("#city").val();
		if (city == "") {
			$("#city").addClass("border-danger");
		} else {
			$("#city").removeClass("border-danger");
		}
	});

	//state
	$("#state").change(function() {
		var state = $("#state").val();
		if (state == "") {
			$("#state").addClass("border-danger");
		} else {
			$("#state").removeClass("border-danger");
		}
	});



	//dynamic checkboxes for update
	var skills = $("#skills").val().split(",");
	var $checkboxes = $("input[type=checkbox]");
	$checkboxes.each(function(idx, element) {
		if (skills.indexOf(element.value) != -1) {
			element.setAttribute("checked", "checked");
			$("#skills").val("");
		} else {
			element.removeAttribute("checked");
		}
	});
	
});