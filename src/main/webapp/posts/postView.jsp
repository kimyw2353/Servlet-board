<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <c:if test="${userCheck}">
                    <button type="button" onclick="window.location.href='postEdit.do?idx=${postView.idx}'">수정</button>
                    <button type="button" onclick="deleteCheck()">글 삭제</button>

                </c:if>
                <button type="button" onclick="window.location.href='postList.do'">목록으로</button>
                <button type="button" onclick="window.location.href='main.do'">홈으로</button>
            </li>
            <li></li>
        </ul>
    </div>
</body>
<script>
    function deleteCheck(){
        if(confirm("정말 삭제하시겠습니까?")==true){
            location.href = 'postDelete.do?idx=${postView.idx}';
        }else {
            return false;
        }
    }
</script>
</html>
