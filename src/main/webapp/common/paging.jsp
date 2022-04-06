<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="paging">
    <c:url var="action" value="/userList.do"/>
    <c:if test="${param.firstPageNo ne 1}">
        <a href="${action}?page=${param.firstPageNo}"> << </a>
        <a href="${action}?page=${param.prevPageNo}"}> < </a>
    </c:if>
    <c:forEach begin="${param.startPageNo}" end="${param.endPageNo}" step="1" var="idx">
        <c:choose>
            <c:when test="${param.pageNo eq idx}">
                ${idx}
            </c:when>
            <c:otherwise>
                <a href="${action}?page=${idx}">${idx}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${param.nextPageNo}">
        <a href="${action}?page=${param.endPageNo+1}">next</a>
    </c:if>
</div>
