<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="html" uri="/struts-tags" %>
<%@ taglib prefix="bean" uri="/struts-tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="script/lib/jquery-2.2.3.min.js"></script>
    <script type ="text/javascript" src = "script/studentUpdateDelete.js"></script>

	<title>Insert title here</title>
</head>
<body onload="report();">
<div class = "container">
	<table class = "table table-bordered">
		<thead>
		<tr class="bg-info">
			<th><label><bean:text name = "student.id"/></label></th>
			<th><label><bean:text name = "student.first.name"/></label></th>
			<th><label><bean:text name = "student.ltast.name"/></label></th>
			<th><label><bean:text name = "student.email.id"/></label></th>
			<th><label><bean:text name = "student.address"/></label></th>
		</tr>
		</thead>
		<tbody id="tbody">
		</tbody>
	</table>
</div>
<div class="container" id="updateBlock">
	<div class="modal fade" id="updateModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h4 class="modal-title">Update New Information</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label><bean:text name = "student.id" /></label>
						<input type="text" name="id" id="id" class="form-control input-sm">
					</div>

					<div class="form-group">
						<label><bean:text name ="student.first.name" /></label>
						<input type="text" name="firstName" id="firstName" class="form-control input-sm">
					</div>

					<div class="form-group">
						<label><bean:text name = "student.email.id" /></label>
						<input type="text" name="emailId" id="emailId" class="form-control input-sm">
					</div>

					<div class="form-group">
						<label><bean:text name = "student.address" /></label>
						<input type="password" name="comment" id="comment" class="form-control input-sm">
					</div>

					<button onclick="updateNewRecord();" class="btn btn-info btn-block">Update</button>
					<div id="resp" class="text-center" style="margin-top: 13px;"></div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>