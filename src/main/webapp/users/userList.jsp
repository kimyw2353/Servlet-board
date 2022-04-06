<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../top.jsp" />
<body>
<h2 style="text-align: center">User List</h2>
<table class="listT">
    <tr>
        <td class="th" id="td_id">아이디</td>
        <td class="th" id="td_name">이름</td>
        <td class="th" id="td_email">이메일</td>
        <td class="th" id="td_create">가입일</td>
        <td class="th" id="td_update">수정일</td>
    </tr>

    <c:if test="${userList eq null}">
        <tr>
            <td colspan="5">등록된 회원이 없습니다.</td>
        </tr>
    </c:if>

    <c:if test="${userList ne null}">
        <c:forEach items="${userList}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.email}</td>
                <td>${list.create_at}</td>
                <td>${list.update_at}</td>
            </tr>
        </c:forEach>
    </c:if>


</table>
<c:if test="${paging ne null}">
    <jsp:include page="../common/paging.jsp">
        <jsp:param name="pageSize" value="${paging.pageSize}"/>
        <jsp:param name="firstPageNo" value="${paging.firstPageNo}"/>
        <jsp:param name="prevPageNo" value="${paging.prevPageNo}"/>
        <jsp:param name="startPageNo" value="${paging.startPageNo}"/>
        <jsp:param name="pageNo" value="${paging.pageNo}"/>
        <jsp:param name="endPageNo" value="${paging.endPageNo}"/>
        <jsp:param name="nextPageNo" value="${paging.nextPageNo}"/>
        <jsp:param name="finalPageNo" value="${paging.finalPageNo}"/>
    </jsp:include>
</c:if>
<c:if test="${paging eq null}">
    <h2>paging이 null</h2>
</c:if>
</body>
</html>
