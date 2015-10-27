<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Database Web Client</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
<body>
	<h3>Create new offer</h3>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/create-offer">
		<table>
			<tr>
				<td>Product title:</td>
				<td><form:input type="text" path="productTitle" /></td>
			</tr>
			<tr>
				<td>Product code:</td>
				<td><form:input type="text" path="productCode" /></td>
			</tr>
			<tr>
				<td>Cost per unit:</td>
				<td><form:input type="text" path="cost" /></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><form:input type="text" path="quantity" /></td>
			</tr>
		</table>
		<hr />
		<input type="submit" value="Create" />
		<hr />
	</form:form>
	<a href="${pageContext.request.contextPath}">Home</a>
</body>
</html>