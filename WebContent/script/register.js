var focus = false;
var regExStudentNumber = new RegExp("^[0-9]*$");
var regExName = new RegExp("^[a-zA-Z0-9\\s]+$");

// var student_Id = $("#id"), firstName= $("#firstName"), lastName = $("#lastName"),  emailId = $("#emailId"), address = $("#address"), error_div = $("error_div");

function validation_form() {

    var studentId = document.getElementById("id");
    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var emailId = document.getElementById("emailId");
    var address = document.getElementById("comment");

    alert(firstName.value);

if (studentId) {
    if (!(studentId.value.length > 0)) {
        displayMsg("Please Enter the number","errorMsg");
        focus = true;
        studentId.focus();
        return false;
    }

}
    if (firstName) {
        if (!(firstName.value.trim().length > 0)) {
            displayMsg("Please Enter the First Name.","errorMsg");
            focus = true;
            firstName.focus();
            return false;
        }
    }
    if(lastName) {
        if (!(lastName.value.trim().length > 0)) {
            displayMsg("Please Enter the Last Name.","errorMsg");
            focus = true;
            lastName.focus();
            return false;
        }
    }
    if (emailId) {
        if (!(emailId.value.trim().length > 0)) {
            displayMsg("Please Enter the Email Id","errorMsg");
            focus = true;
            emailId.focus();
            return false;
        }
    }
    if (address) {
        if (!(address.value.trim().length > 0)) {
            displayMsg("Please Enter the Address.","errorMsg");
            focus = true;
            address.focus();
            return false;
        }
    }
//	var data = new Object();

/*	var display = [{
		"studentId" : studentId,
		"firstName" : firstName,
		"lastName" : lastName,
		"emailId" : emailId,
		"address" : address
	}];*/

  /* alert(JSON.stringify(display));*/
    $.ajax({
		url : "studentDetails.action",
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		// data : JSON.stringify(display),
        data : {
		       "studentId":$("#studentId").val(),
            "firstName":$("#firstName").val(),
            "lastName": $("#lastName").val(),
            "emailId=": $("#emailId").val(),
            "address=": $("#comment").val()
        },
		success : function(response){

			/*var html = data.msg;
			$("#resp").html(html);*/
		},
		error : function(response){

		}
	});
}

//This function is use to validate Name which is mandatory
/*function validateName(fieldId,errorDivId) {
    var name = document.getElementById("firstName");
    if ((name.value != "") && (name.value != null) && (name.value.length > 0)) {
        focus = false;
        if (regExName.test(document.getElementById(fieldId).value) != true) {
            displayMsg("Only alphabets and numbers are allowed.", errorDivId);
            document.getElementById(fieldId).focus();
            document.getElementById(fieldId).select();
        }
    }
}*/

//function will display the error message inside a div.
function displayMsg(msg){
    document.getElementById("errorMsg").innerHTML = msg;
}
