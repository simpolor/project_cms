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
                            <a href="${pageContext.request.contextPath}/admin/bookmark/list">즐겨찾기</a>
                            <a href="${pageContext.request.contextPath}/admin/notice/list">공지사항</a>
                            <a href="${pageContext.request.contextPath}/admin/board/list">자유게시판</a>
                            <a href="${pageContext.request.contextPath}/admin/ask/list">문의사항</a>
                            <a href="${pageContext.request.contextPath}/admin/member/list">회원</a>
                        </div>
                    </div><!-- #nav -->
                </div><!-- #nav-wrap -->