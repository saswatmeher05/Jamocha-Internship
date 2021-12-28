$(document).ready(function () {
//Form Validation
    //1. Hide Error Sections
    $("#fnameError").hide();
    $("#lnameError").hide();
    $("#ageError").hide();
	$("#genderError").hide();
	$("#desgError").hide();
	$("#skillsError").hide();
	$("#dojError").hide();
	$("#cityError").hide();
	$("#StateError").hide();
	

    //2. Define Error Variables
    var fnameError = false;
    var lnameError = false;
    var ageError = false;
	var genderError= false;
	var desgError= false;
	var skillsError= false;
	var dojError= false;
	var cityError= false;
	var stateError= false;

    //3. Define Validation Functions 

    /*fname*/
    function validateFname() {
        var val = $("#fname").val();
        var regex = /^[A-Za-z]{2,30}$/;
        if (val == "") {
            $("#fnameError").show();
            $("#fnameError").html("<b>First Name </b>Can Not Be Empty!");
            $("#fnameError").css("color", "red");
            fnameError = false;
        } else if (val.length < 2) {
            $("#fnameError").show();
            $("#fnameError").html("<b>First Name </b>too Short!");
            $("#fnameError").css("color", "red");
            fnameError = false;
        } else if (!regex.test(val)) {
            $("#fnameError").show();
            $("#fnameError").html("<b>Invalid </b> First Name!");
            $("#fnameError").css("color", "red");
            fnameError = false;
        } else {
            $("#fnameError").hide();
            fnameError = true;
        }
        return fnameError;
    }

    /*lname*/
    function validateLname() {
        var val = $("#lname").val();
        var regex = /^[A-Za-z]{3,30}$/;
        if (val == "") {
            $("#lnameError").show();
            $("#lnameError").html("<b>Last Name </b>Can Not Be Empty!");
            $("#lnameError").css("color", "red");
            lnameError = false;
        } else if (val.length < 3) {
            $("#lnameError").show();
            $("#lnameError").html("<b>Last Name </b>too Short!");
            $("#lnameError").css("color", "red");
            lnameError = false;
        } else if (!regex.test(val)) {
            $("#lnameError").show();
            $("#lnameError").html("<b>Invalid </b> Last Name!");
            $("#lnameError").css("color", "red");
            lnameError = false;
        } else {
            $("#lnameError").hide();
            lnameError = true;
        }
        return lnameError;
    }

    /*age*/
    function validateAge() {
        var val=$("#age").val();
        var regex=/^[0-9]{1,2}$/;
        if(val==""){
            $("#ageError").show();
            $("#ageError").html("<b>Age </b>Can Not Be Empty");
            $("#ageError").css("color", "red");
            ageError = false;
        }else if(!regex.test(val)){
            $("#ageError").show();
            $("#ageError").html("<b>Age </b>Invalid");
            $("#ageError").css("color", "red");
            ageError = false;
        }else if(val<15 || val>99){
            $("#ageError").show();
            $("#ageError").html("<b>Age </b>Limit 15-99");
            $("#ageError").css("color", "red");
            ageError = false;
        }else{
            $("#ageError").hide();
            ageError = true;
        }
        return ageError;
    }

	/*gender*/
	function validateGender(){
		var len=$('input[type="radio"][name="gender"]:checked').length;
		if(len==0){
			$("#genderError").show();
			$("#genderError").html("Chose One Option");
			$("#genderError").css("color","red");
			genderError=false;
		}else{
			$("#genderError").hide();
			genderError=true;
		}
		return genderError;
	}
	
	/*designation*/
	function validateDesg(){
		var val=$("#desg").val();
		var regex=/^[A-Za-z\s]{3,30}$/;
		if(val==""){
			$("#desgError").show();
			$("#desgError").html("<b>Designation</b> Cannot be Empty");
			$("#desgError").css("color","red");
			desgError=false;
		}else if(!regex.test(val)){
			$("#desgError").show();
			$("#desgError").html("Symbols and Numbers not allowed");
			$("#desgError").css("color","red");
			desgError=false;
		}else{
			$("#desgError").hide();
			desgError=true;
		}
		return desgError;
	}
	
	/*skills*/
	function validateSkills(){
		var len=$('input[type="checkbox"][name="skills"]:checked').length;
		if(len==0){
			$("#skillsError").show();
			$("#skillsError").html("Chose One Option");
			$("#skillsError").css("color","red");
			skillsError=false;
		}else{
			$("#skillsError").hide();
			skillsError=true;
		}
		return skillsError;
	}
	
	/*doj*/
	function validateDoj(){
		if(!$("#doj").val()){
			$("#dojError").show();
			$("#dojError").html("Chose <b>Date Of Joining</b>");
			$("#dojError").css("color","red");
			dojError=false;
		}
		else{
			$("#dojError").hide();
			dojError=true;			
		}
		return dojError;
	}
	
	/*city*/
	function validateCity(){
		var val=$("#city").val();
		var regex=/^[A-Za-z\.\&]{3,25}$/;
		if(val==""){
			$("#cityError").show();
			$("#cityError").html("<b>City Name </b>Can Not Be Empty");
			$("#cityError").css("color","red");
			cityError=false;
		}else if(!regex.test(val)){
			$("#cityError").show();
			$("#cityError").html("Invalid <b>City Name</b>");
			$("#cityError").css("color","red");
			cityError=false;
		}else{
			$("#cityError").hide();
			cityError=true;
		}
		return cityError;
	}
	
	/*state*/
	function validateState(){
		var val=$("#state").val();
		if(val==""){
			$("#stateError").show();
			$("#stateError").html("Chose <b>State</b>");
			$("#stateError").css("color","red");
			stateError=false;
		}else{
			$("#stateError").hide();
			stateError=true;
		}
		return stateError;
	}
	

    //4. Link With Action Events
    $("#fname").keyup(function () {
        validateFname();
    });
    $("#lname").keyup(function () {
        validateLname();
    });
    $("#age").keyup(function () {
        validateAge();
    });
	$('input[type="radio"][name="gender"]').change(function(){
		validateGender();
	});
	$("#desg").keyup(function(){
		validateDesg();
	});
	
	$('input[type="checkbox"][name="skills"]').change(function(){
		validateSkills();
	});
	
	$("#doj").click(function(){
		validateDoj();
	});
	
	$("#city").keyup(function(){
		validateCity();
	});
	
	$("#state").click(function(){
		validateState();
	})

	
    //5. On Submit
    $("#frm").submit(function () {
        validateFname();
        validateLname();
        validateAge();
		validateGender();
		validateDesg();
		validateSkills();
		validateDoj();
		validateCity();
		validateState();
        if (fnameError && lnameError && ageError && genderError && desgError && skillsError && dojError && cityError && stateError) {
            return true;
        } else {
            return false;
        }
    });
 $("#smt").click(function(){
	alert("Sumit Clicked");
	});
	

//for dynamic checkboxes
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