<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

                <div id="header-wrap">
                    <div id="header">
                        <div class="header-logo">
                            <a href="${pageContext.request.contextPath}/admin/bookmark/list">BUUKMARK ADMIN</a>
                        </div>

                        <div class="header-left">
                            <sec:authorize access="isAuthenticated()">
                                <sec:authentication var="identity" property="principal.identity" />
                                <sec:authentication var="username" property="principal.username" />
                                <span>${username} ( ${identity} ) 님 환영합니다.</span>
                            </sec:authorize>
                        </div>

                        <div class="header-right">
                            <sec:authorize access="isAnonymous()">
                                <a href="${pageContext.request.contextPath}/member/login">로그인</a>
                                <a href="${pageContext.request.contextPath}/member/register">회원가입</a>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                <sec:authentication var="identity" property="principal.identity" />
                                <a href="${pageContext.request.contextPath}/member/info/${identity}">회원정보</a>
                                <a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
                            </sec:authorize>
                        </div>

                    </div><!-- #header -->
                </div><!-- #header-wrap -->