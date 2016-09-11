<%@page import="com.wyreLease.model.Exercise"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Minutes</title>
<script type="text/javascript" src="static/javascript/jquery-3.1.0.js"></script>
<script>
	$(document).ready(
			function() {
				$.getJSON('<spring:url value="activities.json"/>', {
					ajax : true
				}, function(data) {
					var html = "<option value=''>Select</option>";
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="'+data[i].desc+'">'
								+ data[i].desc + '</option>';
					}
					html += '</option>';
					$('#activities').html(html).val("${exercise.activity}")
				})
			})
</script>
</head>
<body>
	<h1>Add Minutes</h1>
	Language:
	<a href="?language=en">English</a> |
	<a href="?language=in">Hindi</a>
	<form:form commandName="exercise">
		<table>
			<tr>
				<td><spring:message code="exercise.text" /></td>
				<td><form:input path="minutes" /></td>
				<td><select name="activity" id="activities"
					value="${exercise.activity}" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit"></td>
			</tr>
		</table>
	</form:form>


</body>
<h1>Our goal for the day is : ${goal.minutes}</h1>
</html>