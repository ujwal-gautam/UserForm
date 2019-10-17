function report() {		
		$.ajax({			
			type:"GET",
			url:"report.action",
			 contentType : "application/json",
			success: function(result){
				var tableData="";
				$.each(result.list, function() {					
					tableData += "<tr><td>" + this.studentId + "</td>" + 
					"<td>" + this.firstName + "</td>" + 
					"<td>" + this.lastName + "</td>" + 
					"<td>" + this.emailId + "</td>" +
					"<td>" + this.address + "</td>" +
					"<td>"+
					"<button onclick='fetchOldRecord(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#updateModal'>Update</button>"+
					"<button onclick='deleteUser(this);' class='btn btn-sm btn-danger'>Delete</button>"+
					"</td></tr>" ;
				});
				$("#tbody").html(tableData);
			},
			error: function(result){
				alert("Some error occurred.");
			}
		});
	}

//function for fecthing old information into the form
function fetchOldRecord(that){		
	   $("#studentId").val($(that).parent().prev().text());
	   $("#firstName").val($(that).parent().prev().prev().prev().text());
	   $("#lastName").val($(that).parent().prev().prev().prev().text());
	   $("#emailId").val($(that).parent().prev().text());
	   $("#address").val($(that).parent().prev().prev().prev().text());
   	}

function updateNewRecord() {
	var studentId = $("#studentId").val();
	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();
	var emailId = $("#emailId").val();
	var address = $("#address").val();
	
	var updateData ={
		"studentId" : studentId,
		"firstName" : firstName,
		"lastName" : lastName,
		"emailId" : emailId,
		"address" : address
	}
	$.ajax({
		type:"POST",
		url:"updateUser.action",
        contentType : "application/json",
		data:JSON.stringify(updateData),
        success:function(result){
        	var htl= result.msg;
			$("#resp").html(htl);
        },
        error: function(result){
        	alert("Some error occurred.");
        }
	});	
}


//function for deleting user information from database
function deleteUser(that) {	
	$.ajax({
		type:"POST",
		url:"deleteUser.action",
		 contentType : "application/json",
		data:"studentId="+$(that).parent().prev().prev().prev().text(),
		success: function(data){
			if(data.msg==="Delete Successful"){
				alert(data.msg)
				$(that).closest('tr').remove();
				
			} else{
				alert(data.msg)
			}
		},
		error:function(data){
			alert("Some error occurred.");
		}
	});
}