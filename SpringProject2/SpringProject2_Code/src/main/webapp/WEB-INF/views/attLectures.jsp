<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>년도/학기 이수 학점 조회하기</title>
</head>
<body>
<h2>년도/학기 이수 학점 조회하기</h2>
<table border=1>

<%-- <tr>
<td>년도</td>
<td>학기</td>
<td>이수 학점</td>
<td>상세보기</td>
</tr>

<tr>
<td>2016</td>
<td>1</td>
<td><c:out value="${creditTotal2016_1}"></c:out></td>
<td><p> <a href="${pageContext.request.contextPath}/view2016_1Lectures"> 조회 </a></p></td>
</tr>

<tr>
<td>2016</td>
<td>2</td>
<td><c:out value="${creditTotal2016_2}"></c:out></td>
<td><p> <a href="${pageContext.request.contextPath}/view2016_2Lectures"> 조회 </a></p></td>
</tr>

<tr>
<td>2019</td>
<td>1</td>
<td><c:out value="${creditTotal2019_1}"></c:out></td>
<td><p> <a href="${pageContext.request.contextPath}/view2019_1Lectures"> 조회 </a></p></td>
</tr>

<tr>
<td>2019</td>
<td>2</td>
<td><c:out value="${creditTotal2019_2}"></c:out></td>
<td><p> <a href="${pageContext.request.contextPath}/view2019_2Lectures"> 조회 </a></p></td>
</tr> --%>

<tr>
	<th>수강년도</th>
	<th>학기</th>
	<th>이수학점</th>
	<th>상세보기</th>
</tr>
<c:forEach var="lectures" items="${lectures}">
	<tr>
		<td><c:out value="${lectures.att_year}" /></td>
		<td><c:out value="${lectures.att_term}" /></td>
		<td><c:out value="${lectures.sub_credit}" /></td>
		<td>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<a href="viewLectures?att_year=<c:out value="${lectures.att_year}"/>&att_term=<c:out value="${lectures.att_term}"/>">조회</a></td>
	</tr>
</c:forEach>

</table>	
	

</body>
</html>