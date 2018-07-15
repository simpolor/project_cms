<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="default-layout">
	<tiles:putAttribute name="default-body">

		<style>

			@import url('//fonts.googleapis.com/earlyaccess/nanumgothic.css');
			.nanumgothic * {
				font-family: 'Nanum Gothic', sans-serif;
			}

			@font-face {
				font-family: 'Nanum Gothic';
				font-style: normal;
				font-weight: 400;
				src: url('/fonts/NanumGothic/NanumGothic-Regular.eot');
				src: url('/fonts/NanumGothic/NanumGothic-Regular.eot?#iefix') format('embedded-opentype'),
				url('/fonts/NanumGothic/NanumGothic-Regular.woff2') format('woff2'),
				url('/fonts/NanumGothic/NanumGothic-Regular.woff') format('woff'),
				url('/fonts/NanumGothic/NanumGothic-Regular.ttf') format('truetype');
			}

			@font-face {
				font-family: 'Godo';
				font-style: normal;
				font-weight: 400;
				src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/godo/Godo/GodoM.woff2') format('woff2'),
				url('//cdn.jsdelivr.net/korean-webfonts/1/corps/godo/Godo/GodoM.woff') format('woff');
			} @font-face {
				font-family: 'Godo';
				font-style: normal;
				font-weight: 700; src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/godo/Godo/GodoB.woff2') format('woff2'),
				url('//cdn.jsdelivr.net/korean-webfonts/1/corps/godo/Godo/GodoB.woff') format('woff');
			}

			h2 {
				font-family: "Nanum Gothic";
			}

			/*h3 {
				font-family: "Godo";
			}*/

		</style>

		<h1>테스트</h1>
		<h2>테스트</h2>
		<h3>테스트</h3>
		<c:if test="${! empty demo}">
			<table border="1">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>나이</th>
					<th>취미</th>
				</tr>

				<tr>
					<td>${demo.seq}</td>
					<td>${demo.name}</td>
					<td>${demo.age}</td>
					<td>${demo.hobby}</td>
				</tr>
			</table>
		</c:if>

		<img src="/image/sample.jpg" alt="sample" />
	</tiles:putAttribute>
</tiles:insertDefinition>