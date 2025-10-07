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
	<h2>
		Welcome ${pageContext.request.userPrincipal.name} | <a
			onclick="document.forms['logoutForm'].submit()">Logout</a>
	</h2>


	<form:form action="${contextPath}/addLab" modelAttribute="lab"
		method="post">
LabName<input type="text" name="labName">

		<select name="testname">
			<c:forEach var="test" items="${test}">
				<option>${test.testname}</option>
			</c:forEach>

		</select>
		<input type="submit" value="submit">

	</form:form>

</body>
</html>