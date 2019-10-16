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
    width: 500px;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }
  thead {
  background-color : orange;
  }
  tbody {
  background-color :#F5ECCE;
  }
  body {
  background-color :#F5ECCE;
  }
  h1 {
  text-align : center;
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
				<td>&#149 ${(order.creditCardNumber == "") ? "<I>No Value</I>" : order.creditCardNumber}</td>
			</tr>
			<tr>
				<td>cardType</td>
				<td>${order.creditCard}</td>
			</tr>
			<tr>
				<td>price</td>
				<td>${(order.priceEach == "") ? "<I>No Value</I>" : order.priceEach}</td>
			</tr>
			<tr>
				<td>initial</td>
				<td>${(order.middleInitial == "") ? "<I>No Value</I>" : order.middleInitial}</td>
			</tr>
			<tr>
				<td>itemNum</td>
				<td>${(order.itemNumber == "") ? "<I>No Value</I>" : order.itemNumber}</td>
			</tr>
			<tr>
				<td>address</td>
				<td>${(order.shippingAddress == "") ? "<I>No Value</I>" : order.shippingAddress}</td>
			</tr>
			<tr>
				<td>firstName</td>
				<td>${(order.firstName == "") ? "<I>No Value</I>" : order.firstName}</td>
			</tr>
			<tr>
				<td>description</td>
				<td>${(order.description == "") ? "<I>No Value</I>" : order.description}</td>
			</tr>
			<tr>
				<td>lastName</td>
				<td>${(order.lastName == "") ? "<I>No Value</I>" : order.lastName}</td>
			</tr>
			<tr>
			</tr>
		</tbody>
	</table>

</body>
</html>