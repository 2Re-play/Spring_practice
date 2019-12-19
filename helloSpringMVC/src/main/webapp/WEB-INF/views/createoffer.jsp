<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="offer">
		<table class="formtable">
			<tr>
				<td class="lable">Name:</td>
				<td><sf:input class="control" type="text" path="name"></sf:input><br>
				<sf:errors class="error" path="name"></sf:errors></td>
			</tr>
			<tr>
				<td class="lable">email:</td>
				<td><sf:input class="control" type="text" path="email"></sf:input><br>
				<sf:errors class="error" path="email"></sf:errors></td>
			</tr>
			<tr>
				<td class="lable">Offer:</td>
				<td><sf:textarea class="control" path="text" rows="10"
						cols="10"></sf:textarea><br>
						<sf:errors class="error" path="text"></sf:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="control" type="submit" value="new"></td>
			</tr>
		</table>
	</sf:form>

</body>
</html>