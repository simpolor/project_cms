<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="default-body">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/module/board.css">
		<script>
            function f_delete() {
                var form = document.getElementById('boardDeleteForm');
                form.submit();
            }
		</script>

		<div id="section-wrap">
			<div id="section">

				<div class="board-form">

					<div class="board-title">
						<span>게시판 목록</span>
					</div><!-- .board-list-title -->

					<form id="boardDeleteForm" action="${pageContext.request.contextPath}/board/delete" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="hidden" name="seq" value="${board.seq}" />
						${board.title}
						<hr />
						${board.content}
					</form>

					<a href="${pageContext.request.contextPath}/board/modify?seq=${board.seq}">글수정</a>
					<a href="#" onclick="f_delete(); return false;">글삭제</a>
					<a href="#" onclick="history.back(); return false;">취소</a>

				</div>

			</div><!-- #section -->
		</div><!-- #section-wrap -->

	</tiles:putAttribute>
</tiles:insertDefinition>