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
<title>Insert title here</title>
</head>
<body>
	<form method="Get" action="${contextPath}/booking">
		<input type="hidden" name="username" value="${username}"> 
		Test Name:<input type="text" name="testname" value="${testname}" readonly="readonly">
		<br>
		<br> 
		Labs: <select name="labname">
			<c:forEach var="labs" items="${lab}">
				<option>${labs}</option>
			</c:forEach>
		</select> <input type="submit" value="Book">
	</form>
</body>
</html>
