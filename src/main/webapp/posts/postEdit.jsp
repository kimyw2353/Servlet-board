<%--
  Created by IntelliJ IDEA.
  User: Purple
  Date: 2022-04-08
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<div>
    <form action="/postEdit.do" method="post">
        <table>
            <tr>
                <td>
                    <input type="text" value="${postView.title}" name="title">
                </td>
                <td>
                    <input type="text" value="${postView.content}" name="content">
                    <input type="text" value="${postView.idx}" name="idx">
                </td>
                <td>
                    <button type="">수정</button>
                    <button type="button" onclick="window.location.href='postList.do'">돌아가기</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
