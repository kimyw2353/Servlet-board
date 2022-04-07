<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="action" value="/userList.do"/>
<div id="paging">
    <a href="${action}?page=${param.firstPageNo}"> 처음 </a>
    <a href="${action}?page=${param.prevPageNo}"}> << </a>
    <c:forEach var="idx" begin="${param.startPageNo}" end="${param.endPageNo}">
    <a href="${action}?page=${idx}">${idx}</a>
    </c:forEach>
    <a href="${action}?page=${param.nextPageNo}"> >> </a>
    <a href="${action}?page=${param.finalPageNo}">끝</a>
</div>
