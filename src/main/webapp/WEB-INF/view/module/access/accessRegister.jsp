<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="default-body">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/module/access.css">
		<script>
            function f_submit(){
                document.getElementById("accessRegisterForm").submit();
            }
		</script>

		<div id="section-wrap">
			<div id="section">

				<div class="access-register">

					<div class="access-register-title">
						<span>접근URL 등록</span>
					</div><!-- #access-register-title -->

					<div class="access-register-form">
						<form id="accessRegisterForm" class="pure-form" method="post" action="/access/register">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

							<table class="access-register-table">
								<tr>
									<th><label for="access_url">접근 URL</label></th>
									<td><input type="text" name="access_url" id="access_url" placeholder="접근 URL" required="required"  /></td>
								</tr>
								<tr>
									<th><label for="access_roles">접근 ROLES</label></th>
									<td><input type="text" name="access_roles" id="access_roles" placeholder="접근 ROLES" required="required" /></td>
								</tr>
							</table>

						</form>
					</div><!-- .access-register-form -->

					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<div class="access-register-error-msg">
							<span><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></span>
							<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
						</div><!-- .access-register-error-msg -->
					</c:if>

					<div class="access-register-link">
						<a href="#" onclick="f_submit()">등록하기</a>
						<a href="${pageContext.request.contextPath}/index">뒤로가기</a>
					</div><!-- .access-register-link -->

					<c:if test="${! empty roleList}">
						<hr />

						<table>
							<c:forEach var="role" items="${roleList}">
								<tr>
									<td>${role.role_code}</td>
									<td>${role.role_name}</td>
								</tr>
							</c:forEach>
						</table>
					</c:if>


				</div><!-- .access-register -->

			</div><!-- #section -->
		</div><!-- #section-wrap -->


	</tiles:putAttribute>
</tiles:insertDefinition>