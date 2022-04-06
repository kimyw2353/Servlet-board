<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<c:import url="../top.jsp" />
<body style="text-align: center;">
    <h2>Login Page</h2>
    <form action="${pageContext.request.contextPath}/login.do" method="post" id="loginF" style="text-align: left; width: 500px;margin: 0 auto;">
        <table style="width: 500px;margin: 0 auto;">
            <tr>
                <td class="col_1 right">이메일 : </td>
                <td class="col_2 left">
                    <input type="text" name="inputEmail" id="inputEmail" placeholder="이메일을 입력하세요.">
                </td>
            </tr>
            <tr>
                <td class="col_1 right">비밀번호 : </td>
                <td class="col_2 left">
                    <input type="password" name="inputPw" id="inputPw" placeholder="비밀번호를 입력하세요.">
                </td>
            </tr>
            <tr>
                <td class="center" colspan="2">
                    <button class="btn" id="submit_btn" type="button" onclick="loginCheck()">로그인</button>
                    <button class="btn" type="button" onclick="location.href='/main.do'">홈으로</button>
                </td>
            </tr>
        </table>
    </form>
</body>
<script>
    function loginCheck(){
        const input_email = document.getElementById('inputEmail');
        const input_pw = document.getElementById('inputPw');

        if(!input_email.value){
            alert('아이디를 입력해주세요.');
            input_email.focus();
            return false;
        }
        if(!input_pw.value){
            alert('비밀번호를 입력해주세요.');
            input_pw.focus();
            return false;
        }
        document.getElementById('loginF').submit();
    }
</script>
</html>