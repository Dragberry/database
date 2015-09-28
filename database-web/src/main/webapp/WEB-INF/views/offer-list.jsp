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
			            type: 'GET',
			            dataType: 'json',
			            contentType: 'application/json',
			            mimeType: 'application/json',
			            data: {
			            	operator : $("#operator").val(),
			            	field : $("#field").val(),
			            	condition : $("#condition").val(),
			            	value : $("#value").val()
			            },
			            success : function(data) {
			            	$("#resultQuery").html(data["resultQuery"]);
			            }
			        });
			});
			
			$("#removeConditionButton").click(function() {
				$.ajax({
					url : 'remove-condition',
					type: 'DELETE',
				 	success : function(data) {
		            	$("#resultQuery").html(data["resultQuery"]);
		            }
				});
			});	
		
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
				<c:forEach var="operator" items="${operatorList}">
					<option>${operator}</option>
				</c:forEach>
			</select>
			<select id="field" form="add-condition">
				<c:forEach var="field" items="${fieldList}">
					<option>${field}</option>
				</c:forEach>
			</select>
			<select id="condition" form="add-condition">
				<c:forEach var="condition" items="${conditionList}">
					<option>${condition}</option>
				</c:forEach>
			</select>
			<input type="text" id="value" form="add-condition"/> 
			<input id="addConditionButton" type="button" value="Add" />
			<input id="removeConditionButton" type="button" value="Remove" />
		</form>
	</div>
	<div>
		<span id="resultQuery"></span>
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