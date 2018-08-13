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
            function f_modify() {
                var form = document.getElementById('boardModifyForm');
                form.submit();
            }
		</script>

		<div id="section-wrap">
			<div id="section">

				<div class="board-form">

					<div class="board-title">
						<span>게시판 목록</span>
					</div><!-- .board-list-title -->

					<form id="boardModifyForm" action="${pageContext.request.contextPath}/board/modify" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="hidden" name="seq" id="seq" value="${board.seq}"/>
						<input type="text" name="title" id="title" value="${board.title}"/>
						<hr />
						<textarea name="content" id="content">${board.content}</textarea>
					</form>

					<a href="#" onclick="f_modify(); return false;">완료</a>
					<a href="#" onclick="history.back(); return false;">취소</a>

				</div>

			</div><!-- #section -->
		</div><!-- #section-wrap -->

	</tiles:putAttribute>
</tiles:insertDefinition>