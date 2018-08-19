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
            function f_remove() {
                var form = document.getElementById('boardManagerRemoveForm');
                form.submit();
            }
		</script>

		<div id="section-wrap">
			<div id="section">

				<div class="board-form">

					<div class="board-title">
						<span>게시판관리 정보</span>
					</div><!-- .board-list-title -->

					<form id="boardManagerRemoveForm" action="${pageContext.request.contextPath}/board/remove" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="hidden" name="board_seq" value="${boardManager.board_seq}" />
						${boardManager.board_id}
						<hr />
						${boardManager.board_name}
					</form>

					<a href="${pageContext.request.contextPath}/board/manager/change/${boardManager.board_seq}">변경</a>
					<a href="#" onclick="f_delete(); return false;">제거</a>
					<a href="#" onclick="history.back(); return false;">취소</a>

				</div>

			</div><!-- #section -->
		</div><!-- #section-wrap -->

	</tiles:putAttribute>
</tiles:insertDefinition>