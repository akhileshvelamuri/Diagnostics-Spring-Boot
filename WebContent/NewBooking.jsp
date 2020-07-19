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
<title>Booking</title>
</head>
<body>
	<form action="${contextPath}/searchLab" method="Get">
		<input type="hidden" name="username" value="${username}">
		Tests:<select name="testname">
			<c:forEach var="tests" items="${test}">
				<option>${tests.testname}</option>
			</c:forEach>
		</select> <input type="submit" value="search"><br> <br> 
		<input type="hidden" name="labname" value="${labname}">
	</form>
</body>
</html>