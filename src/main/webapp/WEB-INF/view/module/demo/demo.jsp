<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="default-body">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/module/demo.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/purecss-extension/purecss-modal.css">

		<div id="section-wrap">
			<div id="section">

				<div class="demo">

					<div class="demo-title">
						<span>데모 목록</span>
					</div><!-- .demo-title -->

					<c:if test="${! empty demo}">
						<table class="pure-table pure-table-horizontal demo-table">

							<thead>
							<tr>
								<th>번호</th>
								<th>이름</th>
								<th>나이</th>
								<th>취미</th>
							</tr>
							</thead>

							<tbody>
							<tr>
								<td>${demo.seq}</td>
								<td>${demo.name}</td>
								<td>${demo.age}</td>
								<td>${demo.hobby}</td>
							</tr>
							</tbody>
						</table>
					</c:if>

					<img src="/image/sample.jpg">
					<img src="/image/sample.jpg">
					<img src="/image/sample.jpg">

				</div<!-- #demo -->

			</div><!-- #section -->
		</div><!-- #section-wrap -->

	</tiles:putAttribute>
</tiles:insertDefinition>