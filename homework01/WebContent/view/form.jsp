<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  body {
  background-color :#F5ECCE;
  }
  h1 {
  text-align : center;
  }
</style>
</head>
<body>
	<h1> A Sample Form</h1> <br/>
	<form action="/homework01/order" method="post">
	Item Number : <input type="text" name="itemNumber"> <br/>
	Description : <input type="text" name="description"> <br/>
	Price Each : <input type="text" name = "priceEach"> <br/>
	<hr>
	First Name : <input type="text" name = "firstName"> <br/>
	Last Name : <input type="text" name = "lastName"> <br/>
	Middle Initial : <input type="text" name = "middleInitial"> <br/>
	Shipping Address : <input type="text" name = "shippingAddress" style="width:200px; height:50px;"> <br/>
	Credit Card :<br/>
	<input type="radio" name="creditCard" value="Visa" checked=""> Visa <br/>
    <input type="radio" name="creditCard" value="MasterCard">MasterCard <br/>
    <input type="radio" name="creditCard" value="American Express">American Express <br/>
    <input type="radio" name="creditCard" value="Discover">Discover <br/>
    <input type="radio" name="creditCard" value="Java SmartCard">Java SmartCard <br/>
    Credit Card Number : <input type="password" name="creditCardNumber"> <br/>
    Repeat Credit Card Number : <input type="password" name="repeatCreditCardNumber"> <br/>
    <p align ="center">
    <input type="submit" value="Submit order">
    </p>
	</form>
</body>
</html>