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
<title>Admin Booking List</title>
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

				<c:set var="status" value="${bookin.status }" />
				<c:if test="${status.equals('pending')}">
					<form action="${contextPath}/${bookin.bid}/status">
						<td><select id="status" name="status">
								<option>Accept</option>
								<option>Reject</option>
						</select> <input type="submit" /></td>
					</form>
				</c:if>
				<c:if test="${status.equals('Accept') || status.equals('Reject')}">
					<td>${bookin.status}</td>
				</c:if>
				<td><img src="${contextPath}/images/${bookin.path}"/></td>
			</tr>
		</c:forEach>
	</table>
	<form method="get" action="${contextPath}/welcome">
		<input type="submit" value="home">
	</form>
</body>
</html>