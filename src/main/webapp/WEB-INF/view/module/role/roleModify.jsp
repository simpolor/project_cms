<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="default-body">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/module/role.css">
		<script>
            function f_submit(){
                document.getElementById("roleModifyForm").submit();
            }
		</script>

		<div id="section-wrap">
			<div id="section">

				<div class="role-register">

					<div class="role-register-title">
						<span>권한관리 등록</span>
					</div><!-- #role-register-title -->

					<div class="role-register-form">
						<form id="roleModifyForm" class="pure-form" action="/role/modify/${role.role_seq}" method="post">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

							<table class="role-register-table">
								<tr>
									<th><label for="role_code">권한 코드</label></th>
									<td><input type="text" name="role_code" id="role_code" value="${role.role_code}" disabled="disabled" /></td>
								</tr>
								<tr>
									<th><label for="role_name">권한명</label></th>
									<td><input type="text" name="role_name" id="role_name" value="${role.role_name}" placeholder="권한명" required="required" /></td>
								</tr>
								<tr>
									<th>삭제여부</th>
									<td>
										<c:choose>
											<c:when test="${'Y' eq role.del_yn}">
												<label for="del_yn1">Y</label><input type="radio" name="del_yn" id="del_yn1" value="Y" checked />
												<label for="del_yn2">N</label><input type="radio" name="del_yn" id="del_yn2" value="N" />
											</c:when>
											<c:otherwise>
												<label for="del_yn1">Y</label><input type="radio" name="del_yn" id="del_yn1" value="Y" />
												<label for="del_yn2">N</label><input type="radio" name="del_yn" id="del_yn2" value="N" checked />
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</table>

						</form>
					</div><!-- .role-register-form -->

					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<div class="role-register-error-msg">
							<span><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></span>
							<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
						</div><!-- .role-register-error-msg -->
					</c:if>

					<div class="role-register-link">
						<a href="#" onclick="f_submit()">수정하기</a>
						<a href="${pageContext.request.contextPath}/index">뒤로가기</a>
					</div><!-- .role-register-link -->

				</div><!-- .role-register -->

			</div><!-- #section -->
		</div><!-- #section-wrap -->


	</tiles:putAttribute>
</tiles:insertDefinition>