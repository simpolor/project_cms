<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="default-body">

		<h1>Memer Info</h1>

		<table>
			<tr>
				<th>아이디</th>
				<td>${member.member_id}</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${member.member_pw}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${member.member_name}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${member.member_email}</td>
			</tr>
			<tr>
				<th>권한</th>
				<td>${member.member_roles}</td>
			</tr>
		</table>

		<hr>

		<button onclick="f_move('${pageContext.request.contextPath}/index')">홈으로</button>

	</tiles:putAttribute>
</tiles:insertDefinition>