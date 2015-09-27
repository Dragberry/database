<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
	<title>Database Web Client</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
<body>
	<script>
		$( document ).ready(function() {
			$("#addConditionButton").click(function() {
					$.ajax({
			            url : 'add-condition',
			            data: {
			            	"operator" : $("operatot").val()
			            },
			            success : function(data) {
			            	console.log(data);
			            	$("#resultQuery").html(data["resultQuery"]);
			            }
			        });
				}		
			);
		});
		
	</script>
	<div>
		<span>Common search:</span>
		<br/>
		<form action="search-offers" method="get">
			<input type="text" value="${query}" name="query" /> 
			<input type="submit" value="Search" />
		</form>
	</div>
	<hr/>
	<div>
		<span>Conditional search:</span>
		<br/>
		<form action="add-condition" method="get">
			<select id="operator" form="add-condition">
				<option>AND</option>
				<option>OR</option>
			</select>
			<select id="field" form="add-condition">
				<option>Product title</option>
				<option>Product code</option>
				<option>Cost</option>
				<option>Quantity</option>
			</select>
			<select id="condition" form="add-condition">
				<option>EQUALS</option>
				<option>NOT_EQUALS</option>
			</select>
			<input type="text" name="value" form="add-condition"/> 
			<input id="addConditionButton" type="button" value="Add" form="add-condition" />
			<input type="submit" value="Remove" form="remove-condition" />
		</form>
	</div>
	<div>
		<span id="resultQuery"/>
	</div>
	<hr/>
	<div>
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
	</div>
</body>
</html>