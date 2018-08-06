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
		
		<div id="section-wrap">
			<div id="section">

				<div class="access-list">

					<div class="access-list-title">
						<span>접근관리 목록</span>
					</div><!-- .access-list-title -->

					<table class="pure-table pure-table-horizontal access-list-table">
						<colgroup>
							<col width="5%" />
							<col width="20%" />
							<col width="15%" />
							<col width="20%" />
							<col width="20%" />
							<col width="10%" />
							<col width="5%" />
							<col width="5%" />
						</colgroup>
						<thead>
							<tr>
								<th>순번</th>
								<th>접근 URL</th>
								<th>접근 Roles</th>
								<th>등록일</th>
								<th>수정일</th>
								<th>삭제여부</th>
								<th>수정</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${! empty accessList}">
								<c:forEach var="list" items="${accessList}">
									<tr>
										<td>${list.access_seq}</td>
										<td>${list.access_url}</td>
										<td>${list.access_roles}</td>
										<td>${list.regi_date}</td>
										<td>${list.modi_date}</td>
										<td>${list.del_yn}</td>
										<td><a href="${pageContext.request.contextPath}/access/modify/${list.access_seq}">수정</a></td>
										<td><a href="${pageContext.request.contextPath}/access/delete/${list.access_seq}">삭제</a></td>
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
					</table><!-- .access-list-table -->

					<div class="access-list-link">
						<a href="${pageContext.request.contextPath}/access/register">등록</a>
						<a href="${pageContext.request.contextPath}/index">뒤로가기</a>
					</div><!-- .access-list-link -->

				</div><!-- .access-list -->

			</div><!-- #section -->
		</div><!-- #section-wrap -->

	</tiles:putAttribute>
</tiles:insertDefinition>