<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main - 환영합니다</title>
</head>
<body style="text-align: center">
<h1>Main Page</h1>
<c:if test="${loginUserId eq null}">
    <button onclick='location.href="join.do";'>회원가입</button>
    <button onclick='location.href="login.do";'>로그인</button>
</c:if>
    <button onclick='location.href="userList.do";'>회원목록</button>
<c:if test="${loginUserId ne null}">
    <button onclick='location.href="logout.do";'>로그아웃</button>
    <button onclick='location.href="boardList.do";'>글목록</button>
    <h4>[${loginUserId}]님 로그인중. . .</h4>
</c:if>
</body>
</html>
