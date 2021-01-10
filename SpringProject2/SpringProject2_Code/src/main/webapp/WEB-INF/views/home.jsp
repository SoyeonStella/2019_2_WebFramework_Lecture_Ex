<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<!-- **시험나올듯 : home.jsp에서 Show current offers를 클릭하면 http://localhost:8080/helloSpringMVC/offer 로 넘어간다. -->
	<p> <a href="${pageContext.request.contextPath}/attLectures"> 학기별 이수 학점 조회 </a></p>
	<p> <a href="${pageContext.request.contextPath}/registerLecture"> 수강 신청 하기 </a></p>
	<p> <a href="${pageContext.request.contextPath}/viewRegistLectures"> 수강 신청 조회하기 </a></p>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()"> Logout </a>
	</c:if>

	<form id="logout" action="<c:url value="/logout"/>" method="post" >
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	
</body>
</html>
