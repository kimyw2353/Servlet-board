<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="paging">
    <c:if test="${param.nextPageNo ne null || !empty param.nextPageNo}">

        <a href="${action}?page=${param.firstPageNo}"> 처음 </a>
        <a href="${action}?page=${param.prevPageNo}" }> << </a>
        <c:forEach var="idx" begin="${param.startPageNo}" end="${param.endPageNo}">
            <a href="${action}?page=${idx}">${idx}</a>
        </c:forEach>
        <a href="${action}?page=${param.nextPageNo}"> >> </a>
        <a href="${action}?page=${param.finalPageNo}">끝</a>

    </c:if>
    <c:if test="${param.nextPageNo eq null|| empty param.nextPageNo}">
        <span>1</span>
    </c:if>
</div>
