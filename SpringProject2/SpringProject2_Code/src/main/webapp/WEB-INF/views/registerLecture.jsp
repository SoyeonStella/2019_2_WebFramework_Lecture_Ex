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

	<!-- createoffer()의 model.addAttribute("offer", new Offer());의 offer와 modelAttribute의 이름이 일치해야한다. -->
	<!-- springform이기 때문에 토큰을 줄 필요없이 자동으로 토큰이 부여된다. -->
	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="lecture">
		<table class="formtable">
			<tr>
				<td class="label">Year: </td>
				<td><sf:input class="control" type="number" path="att_year" value="2020" readonly="true" /> <br/>
				<sf:errors path="att_year" class="error"/>
				</td>
			</tr>
			<tr>
				<td class="label">Term: </td>
				<td><sf:input class="control" type="number" name="att_term" path="att_term" value="1" readonly="true"/> <br/>
				<sf:errors path="att_term" class="error"/>
				</td>
			</tr>
	
			<tr>
				<td class="label">Code: </td>
				<td><sf:input class="control" type="text" path="sub_code" /> <br/>
					<!-- 에러메세지를 view에 출력 -->
					<sf:errors path="sub_code" class="error"/>
				</td>
			</tr>
			<tr>
				<td class="label">Title: </td>
				<td><sf:input class="control" type="text" path="sub_title" /> <br/>
					<!-- 에러메세지를 view에 출력 -->
					<sf:errors path="sub_title" class="error"/>
				</td>
			</tr>
			<tr>
				<td class="label">Part: </td>
				<td><sf:input class="control" type="text" path="sub_part" /> <br/>
					<!-- 에러메세지를 view에 출력 -->
					<sf:errors path="sub_part" class="error"/>
				</td>
			</tr>
			<tr>
				<td class="label">Credit: </td>
				<td><sf:input class="control" type="text" path="sub_credit" /> <br/>
					<!-- 에러메세지를 view에 출력 -->
					<sf:errors path="sub_credit" class="error"/>
				</td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="수강 신청" /></td>
			</tr>
		</table>
	</sf:form>

</body>
</html>