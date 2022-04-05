<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
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
    <c:forEach items="${userList}" var="list">
    <tr>
        <td>${list.id}</td>
        <td>${list.name}</td>
        <td>${list.email}</td>
        <td>${list.create_at}</td>
        <td>${list.update_at}</td>
    </tr>

    </c:forEach>
</table>
</body>
</html>
