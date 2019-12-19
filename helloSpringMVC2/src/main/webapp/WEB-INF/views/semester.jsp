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
        border: 1px solid #333333;
        border-collapse: collapse;
      }
      
td {
        padding: 10px;
        border: 1px solid #333333;
      }
</style>
</head>
<body>

<table class="formtable">
			<tr>
				<td>년도</td>
				<td>학기</td>
				<td>이수학점</td>
				<td>상세보기</td>
			</tr>
			<c:forEach var="semesters" items="${semesters}">
			<tr>
				<td><p> <c:out value="${semesters.class_year}"></c:out></td>
				<td><p> <c:out value="${semesters.class_semester}"></c:out></td>
				<td><p> <c:out value="${semesters.class_grade}"></c:out></td>
				<td><a href="${pageContext.request.contextPath}/myclass/semester/list?year=${semesters.class_year}&semester=${semesters.class_semester}"> 링크</a></td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>