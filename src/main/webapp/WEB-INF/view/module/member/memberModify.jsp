<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="default-body">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/module/member.css">
		<script>
            function f_submit(){
                document.getElementById("memberModifyForm").submit();
            }
		</script>

		<div id="section-wrap">
			<div id="section">

				<div class="member-register">

					<div class="member-register-title">
						<span>회원가입</span>
					</div><!-- .member-register-title-->

					<div class="member-register-form">
						<form id="memberModifyForm" class="pure-form" method="post" action="/member/modify/${member.member_id}">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

							<table class="member-register-table">
								<tr>
									<th><label for="member_id">아이디</label></th>
									<td><input type="text" name="member_id" id="member_id" value="${member.member_id}" placeholder="아이디" disabled="disabled" /></td>
								</tr>
								<tr>
									<th><label for="member_name">이름</label></th>
									<td><input type="text" name="member_name" id="member_name" value="${member.member_name}" placeholder="이름" required="required" /></td>
								</tr>
								<tr>
									<th><label for="member_email">이메일</label></th>
									<td><input type="text" name="member_email" id="member_email" value="${member.member_email}" placeholder="이메일" required="required" /></td>
								</tr>
								<tr>
									<th><label for="member_roles">회원 권한</label></th>
									<td><input type="text" name="member_roles" id="member_roles" value="${member.member_roles}" placeholder="회원 권한" required="required" /></td>
								</tr>
							</table>

						</form>
					</div><!-- .member-register-form -->

					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<div class="member-register-error-msg">
							<span><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></span>
							<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
						</div><!-- .member-register-error-msg -->
					</c:if>

					<div class="member-register-button">
						<button onclick="f_submit()" class="pure-button">회원수정</button>
					</div><!-- .member-register-button -->

					<div class="member-register-link">
						<a href="${pageContext.request.contextPath}/member/list">뒤로가기</a>
					</div><!-- .member-register-link -->

				</div><!-- .member-register -->

			</div><!-- #section -->
		</div><!-- #section-wrap -->


	</tiles:putAttribute>
</tiles:insertDefinition>