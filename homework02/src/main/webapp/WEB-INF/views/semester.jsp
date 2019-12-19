<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table class="formtable">
			<tr>
				<td>년도</td>
				<td>학기</td>
				<td>이수학점</td>
				<td>상세보기</td>
			</tr>
			<c:forEach var="mySemester" items="${mySemester}">
				<tr>
				<td><c:out value="${mySemester.class_year}"></c:out></td>
				<td><c:out value="${mySemester.class_semester}"></c:out></td>
				<td><c:out value="${mySemester.sum_grade}"></c:out></td>
				<td><a href="${pageContext.request.contextPath}/myclass?year=${mySemester.class_year}&semester=${mySemester.class_semester}">링크</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>