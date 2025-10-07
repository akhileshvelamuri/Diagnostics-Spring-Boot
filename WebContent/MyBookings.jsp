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
<title>User Bookings</title>
</head>
<body>
	<div>
		<div>
			<h1>My Bookings</h1>
		</div>
	</div>
	<table border='1'>
		<tr>
			<th>Booking_Id</th>
			<th>User Name</th>
			<th>Lab Name</th>
			<th>Test Name</th>
			<th>Date</th>
			<th>Slot</th>
			<th>Personal Details</th>

			<th>status</th>

		</tr>
		<c:forEach var="bookin" items="${bookinglist}">
			<tr>
				<td>${bookin.bid}</td>
				<td>${bookin.username}</td>
				<td>${bookin.labname}</td>
				<td>${bookin.testname}</td>
				<td>${bookin.date}</td>
				<td>${bookin.slot}</td>
				<td>${bookin.personaldetails}</td>
				<td>${bookin.status}</td>
				<td><img src="${contextPath}/images/${bookin.path}" /></td>
			</tr>
		</c:forEach>
	</table>
	<form method="get" action="${contextPath}/welcome">
		<input type="submit" value="home">
	</form>
</body>
</html>