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

				<div class="member-list">

					<div class="member-list-title">
						<span>회원 목록</span>
					</div><!-- .member-list-title -->

					<table class="member-list-table">
						<colgroup>
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="20%" />
							<col width="20%" />
							<col width="10%" />
							<col width="10%" />
						</colgroup>
						<thead>
							<tr>
								<th>아이디</th>
								<th>이름</th>
								<th>이메일</th>
								<th>권한</th>
								<th>등록일</th>
								<th>수정일</th>
								<th>수정</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${! empty memberList}">
								<c:forEach var="list" items="${memberList}">
									<tr>
										<td>${list.member_id}</td>
										<td>${list.member_name}</td>
										<td>${list.member_email}</td>
										<td>${list.member_roles}</td>
										<td>${list.regi_date}</td>
										<td>${list.modi_date}</td>
										<td><a href="${pageContext.request.contextPath}/member/modify/${list.member_id}">수정</a></td>
										<td><a href="${pageContext.request.contextPath}/member/delete/${list.member_id}">삭제</a></td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="8">없음</td>
								</tr>
							</c:otherwise>
						</c:choose>
						</tbody>
					</table><!-- .member-list-table -->

					<div class="member-list-link">
						<a href="${pageContext.request.contextPath}/index">뒤로가기</a>
					</div><!-- .member-list-link -->

				</div><!-- .member-list -->

			</div><!-- #section -->
		</div><!-- #section-wrap -->

	</tiles:putAttribute>
</tiles:insertDefinition>