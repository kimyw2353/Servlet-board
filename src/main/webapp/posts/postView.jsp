<%--
  Created by IntelliJ IDEA.
  User: Purple
  Date: 2022-04-08
  Time: 오전 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <ul>
            <li>
                <h2>${postView.title}</h2>
            </li>
            <li><h4>작성자 ${postView.name}</h4></li>
            <li></li>
            <li></li>
            <li>
                <p>${postView.content}</p>
            </li>
            <li>
                <button type="button" onclick="edit()">수정</button>
                <button type="button" onclick="window.location.href='main.do'">홈으로</button>
            </li>
            <li></li>
        </ul>
    </div>
</body>
</html>
