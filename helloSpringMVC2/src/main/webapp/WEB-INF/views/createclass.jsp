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
		modelAttribute="myClass" accept-charset="UTF-8">
		<table class="formtable">
			<tr>
				<td>수강년도 :</td>
				<td><sf:input class="control" type="text" path="class_year"></sf:input><br>
				<sf:errors class="error" path="class_year"></sf:errors></td>
			</tr>
			<tr>
				<td>학기 :</td>
				<td><sf:input class="control" type="text" path="class_semester"></sf:input><br>
				<sf:errors class="error" path="class_semester"></sf:errors></td>
			</tr>
			<tr>
				<td>교과 코드 :</td>
				<td><sf:input class="control" type="text" path="class_code"></sf:input><br>
				<sf:errors class="error" path="class_code"></sf:errors></td>
			</tr>
			<tr>
				<td>교과목명 :</td>
				<td><sf:input class="control" type="text" path="class_name"></sf:input><br>
				<sf:errors class="error" path="class_name"></sf:errors></td>
			</tr>
			<tr>
				<td>구분 :</td>
				<td><sf:input class="control" type="text" path="class_category"></sf:input><br>
				<sf:errors class="error" path="class_category"></sf:errors></td>
			</tr>
			<tr>
				<td>학점 :</td>
				<td><sf:input class="control" type="text" path="class_grade"></sf:input><br>
				<sf:errors class="error" path="class_grade"></sf:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="control" type="submit" value="new"></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>