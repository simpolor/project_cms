<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="default-body">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member.css">
		<script>
            function f_submit(){
                document.getElementById("memberRegisterForm").submit();
            }
		</script>

		<div id="section-wrap">
			<div id="section">

				<div class="member-info">

					<div class="member-info-title">
						<span>회원가입</span>
					</div><!-- .member-info-title-->

					<table class="member-info-table">
						<tr>
							<th>아이디</th>
							<td>${member.member_id}</td>
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
					</table><!-- .member-info-table-->

					<div class="member-info-link">
						<a href="${pageContext.request.contextPath}/member/modify/${member.member_id}">수정하기</a>
						<a href="${pageContext.request.contextPath}/index">뒤로가기</a>
					</div><!-- .member-info-link -->

				</div><!-- .member-info -->

			</div><!-- #section -->
		</div><!-- #section-wrap -->


	</tiles:putAttribute>
</tiles:insertDefinition>