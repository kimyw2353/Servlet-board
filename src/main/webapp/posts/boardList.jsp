<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../top.jsp" />
<body>
<div class="list">
    <ul>
        <li>
            <button class="btn" onclick="location.href='main.do'">홈으로</button>
        </li>
        <li>
            <h1>Post List</h1>
        </li>
    </ul>
    <table class="listT">
        <tr>
            <td class="th" id="td_id">글번호</td>
            <td class="th" id="td_name">제목</td>
            <td class="th" id="td_email">작성자</td>
            <td class="th" id="td_create">작성일</td>
            <td class="th" id="td_update">수정일</td>
        </tr>

        <c:if test="${postList eq null || empty postList}">
            <tr>
                <td colspan="5">등록된 게시물이 없습니다.</td>
            </tr>
        </c:if>

        <c:if test="${postList ne null}">
            <c:forEach items="${postList}" var="list">
                <tr>
                    <td>${list.idx}</td>
                    <td><a href="postEdit.do?idx=${list.idx}">${list.title}</a></td>
                    <td>${list.user_idx}</td>
                    <td>${list.create_at}</td>
                    <td>${list.update_at}</td></a>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <c:if test="${paging ne null || !empty paging}">
        <jsp:include page="../common/paging.jsp">
            <jsp:param name="action" value="/boardList.do"/>
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
</div>
</body>
</html>
