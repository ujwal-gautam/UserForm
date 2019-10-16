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
		<tr>
			<td colspan="2" align="center" style="padding-left:15px"><b>Student Login</b></td></tr>

		<tr>
			<td colspan="2" align="left" valign="middle" >
				<div id="errorMsg" class="error_msg"></div>
			</td>
		</tr>

		<html:form>
			<div class="form-group">
				<label for="id"><bean:text name="student.id"/></label>
				<input type="text" class="form-control" id= "id" name="id">
			</div>

			<div class="form-group">
				<label><bean:text name="student.first.name"/></label>
				<input type="text" class="form-control" id= "firstName" name="firstName">
			</div>

			<div class="form-group">
				<label><bean:text name="student.last.name"/></label>
				<input type="text" class="form-control" id= "lastName" name="lastName">
			</div>

			<div class="form-group">
				<label><bean:text name="student.email.id"/></label>
				<input type="email" class="form-control" id= "emailId" name="emailId">
			</div>

			<div class="form-group">
				<label for="comment"><bean:text name="student.address"/></label>
				<textarea class="form-control" rows="5" id= "comment"></textarea>
			</div>
			<button   class="btn btn-success btn-block" type="button" name="btn" id="btn" onclick = "validation_form()"><label><bean:text name= "student.register"/></label></button>
			<div class="text-center" id="resp" style="margin-top: 14px;"></div>
		</html:form>
	</div>
</div>
</body>
</html>