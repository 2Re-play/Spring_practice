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
				<td>수강년도</td>
				<td>학기</td>
				<td>교과코드</td>
				<td>교과목명</td>
				<td>구분</td>
				<td>학점</td>
			</tr>
			<c:forEach var="myClass" items="${myClass}">
			<tr>
				<td><p> <c:out value="${myClass.class_year}"></c:out></td>
				<td><p> <c:out value="${myClass.class_semester}"></c:out></td>
				<td><p> <c:out value="${myClass.class_code}"></c:out></td>
				<td><p> <c:out value="${myClass.class_name}"></c:out></td>
				<td><p> <c:out value="${myClass.class_category}"></c:out></td>
				<td><p> <c:out value="${myClass.class_grade}"></c:out></td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>
