<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="default-body">

		<script src="https://use.fontawesome.com/6714ff5e81.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/module/board.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/purecss-extension/purecss-pagination.css">

		<div id="section-wrap">
			<div id="section">

				<div class="board-list">

					<div class="board-list-title">
						<span>게시판 목록</span>
					</div><!-- .board-list-title -->

					<table class="pure-table pure-table-horizontal board-list-table">
						<colgroup>
							<col width="10%" />
							<col width="60%" />
							<col width="15%" />
							<col width="15%" />
						</colgroup>
						<thead>
							<tr>
								<th>순번</th>
								<th>제목</th>
								<th>등록일</th>
								<th>등록자</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${! empty boardList}">
									<c:forEach var="list" items="${boardList}">
										<tr>
											<td>${list.seq}</td>
											<td><a href="${pageContext.request.contextPath}/board/view/${list.seq}">${list.title}</a></td>
											<td>${list.regi_date}</td>
											<td>${list.regi_name}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td class="pure-txt-center" colspan="4">없음</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table><!-- .board-list-table -->

					<div class="board-list-link">
						<a href="${pageContext.request.contextPath}/board/write">등록</a>
						<a href="${pageContext.request.contextPath}/index">뒤로가기</a>
					</div><!-- .board-list-link -->

				</div><!-- .board-list -->

				<div class="board-pagination">
					<div class="pure-pagination">
						<a href="#"><i class="fa fa-chevron-left"></i></a>
						<a href="#"><i class="fa fa-angle-left"></i></a>

						<a href="#">1</a>
						<strong>2</strong>
						<a href="#">3</a>
						<a href="#">4</a>
						<a href="#">5</a>

						<a href="#"><i class="fa fa-angle-right"></i></a>
						<a href="#"><i class="fa fa-chevron-right"></i></a>
					</div>
				</div>

				<div class="board-pagination">
					<a href="${pageContext.request.contextPath}/board/list/1"><i class="fa fa-chevron-left"></i></a>
					<a href="${pageContext.request.contextPath}/board/list/${paging.startPage}"><i class="fa fa-angle-double-left"></i></a>
					<a href="${pageContext.request.contextPath}/board/list/${paging.prevPage}"><i class="fa fa-angle-left"></i></a>

					<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
						<c:choose>
							<c:when test="${i == paging.pageNo}">
								<strong>${i}</strong>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/board/list/${i}">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<a href="${pageContext.request.contextPath}/board/list/${paging.nextPage}"><i class="fa fa-angle-right"></i></a>
					<a href="${pageContext.request.contextPath}/board/list/${paging.endPage}"><i class="fa fa-angle-double-right"></i></a>
					<a href="${pageContext.request.contextPath}/board/list/${paging.totalPage}"><i class="fa fa-chevron-right"></i></a>
				</div><!-- board-pagination -->

				<div class="board-pagination">
					<a href="${pageContext.request.contextPath}/board/list/${pagination.firstPageNo}"><i class="fa fa-chevron-left"></i></a>
					<a href="${pageContext.request.contextPath}/board/list/${pagination.startPageNo}"><i class="fa fa-angle-double-left"></i></a>
					<a href="${pageContext.request.contextPath}/board/list/${pagination.prevPageNo}"><i class="fa fa-angle-left"></i></a>

					<c:forEach var="i" begin="${pagination.startPageNo}" end="${pagination.endPageNo}">
						<c:choose>
							<c:when test="${i == pagination.currentPageNo}">
								<strong>${i}</strong>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/board/list/${i}">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<a href="${pageContext.request.contextPath}/board/list/${pagination.nextPageNo}"><i class="fa fa-angle-right"></i></a>
					<a href="${pageContext.request.contextPath}/board/list/${pagination.endPageNo}"><i class="fa fa-angle-double-right"></i></a>
					<a href="${pageContext.request.contextPath}/board/list/${pagination.finalPageNo}"><i class="fa fa-chevron-right"></i></a>
				</div><!-- board-pagination -->

			</div><!-- #section -->
		</div><!-- #section-wrap -->

	</tiles:putAttribute>
</tiles:insertDefinition>