<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="action" value="/userList.do"/>
<span>firstPageNo : ${param.firstPageNo}</span>
<span>prevPageNo : ${param.prevPageNo}</span>
<span>startPageNo : ${param.startPageNo}</span>
<span>pageNo : ${param.pageNo}</span>
<span>endPageNo : ${param.endPageNo}</span>
<span>pageSize : ${param.pageSize}</span>
<div id="paging">
    <c:if test="${param.prevPageNo > 10}">
        <a href="${action}?page=${param.firstPageNo}"> first </a>
        <a href="${action}?page=${param.prevPageNo}"}> < </a>
    </c:if>
    <c:forEach var="idx" begin="${param.startPageNo}" end="${param.endPageNo}">
        <a href="${action}?page=${idx}">${idx}</a>
    </c:forEach>
        <a href="${action}?page=${param.nextPageNo}"> > </a>
        <a href="${action}?page=${param.finalPageNo}">final</a>
</div>
