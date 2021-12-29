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
		var errors = "";
		//useful regex
		var fnameRegex = /^[A-Za-z]{3,30}$/;
		var lnameRegex = /^[A-Za-z]{3,30}$/;
		var ageRegex = /^[0-9]{2,2}$/;

		//form validation 
		if (fname == "") {
			$("#fname").addClass("border-danger");
			errors += "Please Enter First Name\n";
		}
		else if (!fnameRegex.test(fname)) {
			$("#fname").addClass("border-danger");
			errors += "Invalid First Name\n";
		} else {
			$("#fname").removeClass("border-danger");
		}


		if (lname == "") {
			$("#lname").addClass("border-danger");
			errors += "Enter Last Name\n";
		}
		else if (!lnameRegex.test(lname)) {
			$("#lname").addClass("border-danger");
			errors += "Invalid Last Name\n";
		} else {
			$("#lname").removeClass("border-danger");
		}


		if (age == "") {
			$("#age").addClass("border-danger");
			errors += "Enter Age\n";
		} else if (!ageRegex.test(age)) {
			$("#age").addClass("border-danger");
			errors += "Only Numericals Allowed\n";
		} else if (age < 15 || age > 80) {
			$("#age").addClass("border-danger");
			errors += "Age Range: 15-80\n";
		} else {
			$("#age").removeClass("border-danger");
		}


		if (gender == 0) {
			errors += "Select Gender\n";
			$("#genderError").show();
			$("#genderError").html("<br>Select Gender");
			$("#genderError").css("color", "red");
			// alert("Select Gender");
		} else {
			$("#genderError").hide();
		}


		if (desg == "") {
			$("#desg").addClass("border-danger");
			errors += "Enter Designation\n";
		} else {
			$("#desg").removeClass("border-danger");
		}


		if (skills == 0) {
			errors += "Chose At Least One Skill\n";
			$("#skillsError").show();
			$("#skillsError").html("<br>Select One Skill");
			$("#skillsError").css("color", "red");
			// alert("Chose At Least One Skill");
		} else {
			$("#skillsError").hide();
		}


		if (!doj) {
			$("#doj").addClass("border-danger");
			errors += "Chose Date Of Joining\n";
		} else {
			$("#doj").removeClass("border-danger");
		}


		if (city == "") {
			$("#city").addClass("border-danger");
			errors += "Enter Your City Name\n";
		} else {
			$("#city").removeClass("border-danger");
		}


		if (state == "") {
			$("#state").addClass("border-danger");
			errors += "Chose State\n";
		} else {
			$("#state").removeClass("border-danger");
		}

		//on submit
		if (errors.length) {
			// alert(errors);
			alert("Incomplete Inputs Try Again!");
			return false;
		} else {

		}

	});

	//form events 
	var flag = true;
	//first name
	$("#fname").change(function() {
		var fname = $("#fname").val();
		var fnameRegex = /^[A-Za-z]{3,30}$/;
		if (fname == "") {
			$("#fname").addClass("border-danger");
			alert("Enter First Name");
		}
		else if (!fnameRegex.test(fname)) {
			$("#fname").addClass("border-danger");
			alert("Invalid First Name");
		}
		else {
			$("#fname").removeClass("border-danger");
		}
	});


	//last name
	$("#lname").change(function() {
		var lname = $("#lname").val();
		var lnameRegex = /^[A-Za-z]{3,30}$/;
		if (lname == "") {
			$("#lname").addClass("border-danger");
			alert("Enter Last Name");
		}
		else if (!lnameRegex.test(lname)) {
			$("#lname").addClass("border-danger");
			alert("Invalid Last Name");
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
			alert("Enter Age");
		}
		else if (!ageRegex.test(age)) {
			$("#age").addClass("border-danger");
			alert("Only Numbers Allowed");
		} else if (age < 15 || age > 80) {
			$("#age").addClass("border-danger");
			alert("Allowed Age Range : 15-80");
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
			alert("Enter Designation");
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
			alert("Enter City");
		} else {
			$("#city").removeClass("border-danger");
		}
	});

	//state
	$("#state").change(function() {
		var state = $("#state").val();
		if (state == "") {
			$("#state").addClass("border-danger");
			alert("Chose State");
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