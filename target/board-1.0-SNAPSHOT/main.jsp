<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="top.jsp" />
<body style="text-align: center">
<h1>Main Page</h1>
<c:if test="${loginUser eq null}">
    <button onclick='location.href="join.do";'>회원가입</button>
    <button onclick='location.href="login.do";'>로그인</button>
</c:if>
<c:if test="${loginUser ne null}">
    <button onclick='location.href="logout.do";'>로그아웃</button>
    <button onclick='location.href="userList.do";'>회원목록</button>
    <button onclick='location.href="write.do";'>글작성하기</button>
    <button onclick='location.href="postList.do";'>글목록</button>
    <h4>[${loginUser.name}]님 로그인중. . .</h4>
</c:if>
</body>
<c:import url="foot.jsp" />