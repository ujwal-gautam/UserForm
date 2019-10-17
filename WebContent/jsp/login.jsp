<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="html" uri="/struts-tags" %>
<%@ taglib prefix="bean" uri="/struts-tags" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>BasicApplication</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<!-- importing bootstrap file -->
	<script src="script/lib/jquery-2.2.3.min.js"></script>
	<script type ="text/javascript" src = "script/register.js"></script>
</head>
<body>
<div id="popupContact">
	<div class="container">
        <tr><td colspan="2" align="center" valign="middle" style="padding-left:15px"><b>Student Form</b></td></tr>

<form action="studentDetails.action" method = "POST">
        <table cellspacing="0" cellpadding="5"  style="width: 100%">
            <tr>
                <td colspan="4" style="text-align: center; height: 25px;" id="errorMsg" class="errorMessage">
                    &nbsp;
                </td>
            </tr>
            <div class="form-group">
                <tr>
                    <td>
				<label for="id"><bean:text name="student.id"/></label><span style="color: red; ">*</span></label>
                    </td>
                </tr>
                <tr>
                    <td>
				<input type="text" class="form-control" id= "id" name="id">
                    </td>
                </tr>
			</div>

			<div class="form-group">

                <tr>
                    <td>
				<label><bean:text name="student.first.name"/></label><span style="color: red; ">*</span></label>
                    </td>
                </tr>

                <tr>
                    <td>
				<input type="text" class="form-control" id= "firstName" name="firstName">
                    </td>
                </tr>
			</div>

			<div class="form-group">
                <tr>
                    <td>
				<label><bean:text name="student.last.name"/></label><span style="color: red; ">*</span></label>
                    </td>
                </tr>

                <tr>
                    <td>
				<input type="text" class="form-control" id= "lastName" name="lastName">
                    </td>
                </tr>
			</div>

			<div class="form-group">

                <tr>
                    <td>
				<label><bean:text name="student.email.id"/></label><span style="color: red; ">*</span></label>
                    </td>
                </tr>
                <tr>
                    <td>
				<input type="email" class="form-control" id= "emailId" name="emailId">
                    </td>
                </tr>
			</div>

			<div class="form-group">
                <tr>
                    <td>
				<label for="comment"><bean:text name="student.address"/></label><span style="color: red; ">*</span></label>
                    </td>
                </tr>

                <tr>
                    <td>
				<textarea class="form-control" rows="5" id= "comment"></textarea>
                    </td>
                </tr>
			</div>

            <tr>
                <td>
			<button   class="btn btn-success btn-block" type="button" name="btn" id="btn" onclick = "validation_form()"><label><bean:text name= "student.register"/></label></button>
                </td>
            </tr>
			<div class="text-center" id="resp" style="margin-top: 14px;"></div>
		</table>
</form>
	</div>

</div>
</body>
</html>