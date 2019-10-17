var regExStudentNumber = new RegExp("^[0-9]*$");



// var student_Id = $("#id"), firstName= $("#firstName"), lastName = $("#lastName"),  emailId = $("#emailId"), address = $("#address"), error_div = $("error_div");

function validation_form() {

    var studentId = document.getElementById("id");
    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var emailId = document.getElementById("emailId");
    var address = document.getElementById("comment");
    var error_div = document.getElementById("errorMsg");

    if (studentId && studentId.value.length != 0 && regExStudentNumber.test(studentId.value) != true) {
        error_div.html("Please Enter the Number.");

        return false;
    }

        if (firstName && !(firstName.value > 0)) {
            error_div.html("Please Enter the First Name.");
            return false;
        }
	if(lastName && !(lastName.value > 0)){
		error_div.html("Please Enter the Last Name.");
		return false;
	}
	if(emailId && !(emailId.value > 0)){
		error_div.html("Please Enter the Email Id");
		focus = true;
		emailId.focus();
		return false;
	}
	if(address && !(address.value > 0)){
		error_div.html("Please Enter the Address.");
		focus = true;
		address.focus();
		return false;
	}
//	var data = new Object();

	var display = {
		"studentId" : studentId,
		"firstName" : firstName,
		"lastName" : lastName,
		"emailId" : emailId,
		"address" : address
	}

	console.log("ajax call");
	$.ajax({
		url : "studentDetails.action",
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify(display),
		success : function(response){

			var html = data.msg;
			$("#resp").html(html);
		},
		error : function(response){

		}
	})

}
