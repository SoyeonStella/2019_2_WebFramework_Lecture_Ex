<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- offer가 model에도 들어가서 controller로 넘어가기 때문에 .jsp파일에서 offer.name을 접근 가능하다. -->
${offer.name} 의 수강신청이 완료되었습니다. <br/>
<p> <a href="${pageContext.request.contextPath}/viewRegistLectures"> 수강 신청 조회하기 </a></p>

</body>
</html>