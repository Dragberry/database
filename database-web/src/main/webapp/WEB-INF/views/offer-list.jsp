<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Database Web Client</title>
</head>
<body>
	Offer List
	<table border="1">
		<th>No</th>
		<th>Product code</th>
		<th>Product title</th>
		<th>Cost</th>
		<th>Quantity</th>

		<c:forEach var="offer" items="${offerList}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${offer.product.productCode}</td>
				<td>${offer.product.productTitle}</td>
				<td>${offer.cost}</td>
				<td>${offer.quantity}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>