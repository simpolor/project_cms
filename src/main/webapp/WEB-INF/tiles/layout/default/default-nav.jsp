<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

                <div id="nav-wrap">
                    <div id="nav">
                        <div class="nav-menus">
                            <a href="${pageContext.request.contextPath}/member/list">회원관리</a>
                            <a href="${pageContext.request.contextPath}/access/list">접근관리</a>
                            <a href="${pageContext.request.contextPath}/role/list">권한관리</a>
                            <a href="${pageContext.request.contextPath}/demo">데모</a>
                            <a href="${pageContext.request.contextPath}/board/list/1">게시판</a>
                            <a href="${pageContext.request.contextPath}/board/manager/list/1">게시판관리</a>
                        </div>
                    </div><!-- #nav -->
                </div><!-- #nav-wrap -->