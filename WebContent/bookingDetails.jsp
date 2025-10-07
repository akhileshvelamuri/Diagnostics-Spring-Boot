<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Details</title>
</head>
<body>
	<form action="${contextPath}/conform?${_csrf.parameterName}=${_csrf.token}"
		method="post" enctype="multipart/form-data">
	User Name:
	<input type="text" name="username" value="${username}" readonly>
	<br> Test Name:
	<input type="text" value="${testname}" name="testname"
		readonly="readonly">
	<br> Lab Name:
	<input type="text" value="${labname}" name="labname"
		readonly="readonly">
	<br> Date:
	<input type="date" name="date" min="2019-12-01" max="2020-12-31">
	<br>
	<br> Slot:
	<select name="slot">
		<option>09:00AM - 10:00AM</option>
		<option>10:00AM - 11:00AM</option>
		<option>11:00AM - 12:00PM</option>
		<option>12:00PM - 01:00PM</option>
		<option>01:00PM - 02:00PM</option>
		<option>02:00PM - 03:00PM</option>
		<option>03:00PM - 04:00PM</option>
		<option>04:00PM - 05:00PM</option>
		<option>05:00PM - 06:00PM</option>
	</select>
	<br>
	<br>
	<h5>Personal Details</h5>
	<textarea rows="5" cols="60" name="personaldetails"></textarea>
	<br>
	<input type="file" name="file" />
	<br>
	<input type="submit" value="Book Now">
	</form>

</body>
</html>