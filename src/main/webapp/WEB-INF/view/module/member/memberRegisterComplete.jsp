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

        <div id="section-wrap">
            <div id="section">

                <div class="member-register-complete">

                    <div class="member-register-complete-title">
                        <span>회원가입이 완료되었습니다.</span>
                    </div><!-- #member-register-complete-title -->

                    <div class="member-register-complete-content">
                        <p>블라블라블라블라</p>
                    </div><!-- #member-register-complete-content -->

                    <div class="member-register-complete-link">
                        <a href="${pageContext.request.contextPath}/index">홈으로</a>
                    </div><!-- .member-register-complete-link -->

                </div><!-- .member-register-complete -->

            </div><!-- #section -->
        </div><!-- #section-wrap -->


    </tiles:putAttribute>
</tiles:insertDefinition>