<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>2020-1 수강신청 결과 조회 </h1>
<hr>
<table border=1>
<tr>
<td>년도</td>
<td>학기</td>
<td>코드</td>
<td>교과명</td>
<td>구분</td>
<td>학점</td>
</tr>
<c:forEach var="lecturesBy2020_1" items="${lecturesBy2020_1}">
<tr>
<td><c:out value="${lecturesBy2020_1.att_year }" /></td>
<td><c:out value="${lecturesBy2020_1.att_term }" /></td>
<td><c:out value="${lecturesBy2020_1.sub_code }" /></td>
<td><c:out value="${lecturesBy2020_1.sub_title }" /></td>
<td><c:out value="${lecturesBy2020_1.sub_part }" /></td>
<td><c:out value="${lecturesBy2020_1.sub_credit }" /></td>
</tr>
</c:forEach>
</table>
	

</body>
</html>