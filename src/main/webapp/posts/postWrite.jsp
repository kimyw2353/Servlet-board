<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../top.jsp" />
<body>
    <div>
        <h2>글쓰기</h2>
        <form action="${pageContext.request.contextPath}/write.do" method="post" id="writeF">
            <table>
                <tr>
                    <td>
                        <input type="text" class="inputTitle" id="title" name="title" required placeholder="제목을 입력해주세요.">
                    </td>
                    <td>
                        <input type="text" class="inputTitle" id="content" name="content" required placeholder="내용을 입력해주세요.">
                        <input type="hidden" value="${loginUser.idx}" name="user_idx">
                    </td>
                    <td>
                        <button type="button" onclick="writeCheck()">글쓰기</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
<script>
    function writeCheck(){
        const title = document.getElementById('title');
        const content = document.getElementById('content');
        const idx = document.getElementById('idx');

        if(!title.value){
            alert('제목을 입력해주세요.');
            return false;
        }else if(!content.value){
            alert('내용을 입력해주세요.');
            return false;
        }

        document.getElementById('writeF').submit();

    }
</script>
</body>
</html>
