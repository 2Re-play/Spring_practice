<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }
  thead {
  background-color : orange;
  }
  tbody {
  background-color : white;
  }
  body {
  background-color :#F5ECCE;
  }
</style>
</head>
<body>
	<h3>Reading All Request Parameter</h3>
	<br />
	<table>
		<thead>
			<tr>
				<th>Parameter Name</th>
				<th>Parameter Value(s)</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>cardNum</td>
				<td>${order.creditCardNumber}</td>
			</tr>
			<tr>
				<td>cardType</td>
				<td>${order.creditCard}</td>
			</tr>
			<tr>
				<td>price</td>
				<td>${order.priceEach}</td>
			</tr>
			<tr>
				<td>initial</td>
				<td>${order.middleInitial}</td>
			</tr>
			<tr>
				<td>itemNum</td>
				<td>${order.itemNumber}</td>
			</tr>
			<tr>
				<td>address</td>
				<td>${order.shippingAddress}</td>
			</tr>
			<tr>
				<td>firstName</td>
				<td>${order.firstName}</td>
			</tr>
			<tr>
				<td>description</td>
				<td>${order.description}</td>
			</tr>
			<tr>
				<td>lastName</td>
				<td>${order.lastName}</td>
			</tr>
			<tr>
			</tr>
		</tbody>
	</table>

</body>
</html>