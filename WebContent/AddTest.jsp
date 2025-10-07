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
<title>Add Tests</title>
</head>
<body>
	<form:form action="${contextPath}/addTest" modelAttribute="test"
		method="post">
TestName<input type="text" name="testname">

		
		<input type="submit" value="submit">
	</form:form>
</body>
</html>