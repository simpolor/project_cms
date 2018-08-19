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
            function f_change() {
                var form = document.getElementById('boardManagerChangeForm');
                form.submit();
            }
		</script>

		<div id="section-wrap">
			<div id="section">

				<div class="board-form">

					<div class="board-title">
						<span>게시판관리 변경</span>
					</div><!-- .board-list-title -->

					<form id="boardManagerChangeForm" action="${pageContext.request.contextPath}/board/manager/change" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="hidden" name="board_seq" id="board_seq" value="${boardManager.board_seq}"/>
						<input type="text" name="board_id" id="board_id" value="${boardManager.board_id}"/>
						<hr />
						<input type="text" name="board_name" id="board_name" value="${boardManager.board_name}"/>
					</form>

					<a href="#" onclick="f_change(); return false;">변경</a>
					<a href="#" onclick="history.back(); return false;">취소</a>

				</div>

			</div><!-- #section -->
		</div><!-- #section-wrap -->

	</tiles:putAttribute>
</tiles:insertDefinition>