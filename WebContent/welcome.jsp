<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Welcome</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #800080;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

p {
	text-align: center
}
</style>
</head>
<body style="background-image: url('');">
	<div>
		<font class="center" color="white">Diagnostics</font>
	</div>
	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h2>
				Welcome ${pageContext.request.userPrincipal.name} | <a
					onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h2>
		</c:if>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<form method="Get" action="${contextPath}/AddTest">
		<input type="submit" value="AddTest">
	</form>
	<br>
	<form method="Get" action="${contextPath}/Addlabs">
		<input type="submit" value="AddLab">
	</form>
	<br>
	<form method="Get" action="${contextPath}/BookingList">
		<input type="submit" value="Booking List">
	</form>
	<br>	
</body>
</html>
