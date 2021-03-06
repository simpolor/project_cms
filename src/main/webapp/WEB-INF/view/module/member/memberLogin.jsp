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
                document.getElementById("memberLoginForm").submit();
            }
		</script>

		<div id="section-wrap">
			<div id="section">

				<div class="member-login">

					<div class="member-login-title">
						<span>회원로그인</span>
					</div><!-- .member-login-title -->

					<div class="member-login-form">
						<form id="memberLoginForm" class="pure-form" method="post" action="/member/login">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<input type="hidden" name="target_url" value="/member/register"/>

							<table class="member-login-table">
								<tr>
									<th><label for="member_id">아이디</label></th>
									<td><input type="text" name="member_id" id="member_id" placeholder="아이디" required /></td>
								</tr>
								<tr>
									<th><label for="member_id">비밀번호</label></th>
									<td><input type="password" name="member_pw" id="member_pw" placeholder="비밀번호" required /></td>
								</tr>
							</table>

						</form>
					</div><!-- .member-login-form -->

					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
					<div class="member-login-error-msg">
						<span><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></span>
						<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
					</div><!-- .member-login-error-msg -->
					</c:if>

					<div class="member-login-button">
						<button onclick="f_submit()" class="pure-button">로그인</button>
					</div><!-- .member-login-button -->

					<div class="member-login-link">
						<a href="${pageContext.request.contextPath}/index">홈으로</a>
					</div><!-- .member-login-link -->

				</div><!-- .member-login -->

			</div><!-- #section -->
		</div><!-- #section-wrap -->

	</tiles:putAttribute>
</tiles:insertDefinition>