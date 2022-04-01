<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.min.js"></script>
</head>
<body style="text-align: center;">
    <h2>Login Page</h2>
    <form action="${pageContext.request.contextPath}/" method="post" id="loginF" style="text-align: left; width: 500px;margin: 0 auto;">
        <table style="width: 500px;margin: 0 auto;">
            <tr>
                <td class="col_1 right">아이디 : </td>
                <td class="col_2 left">
                    <input type="text" id="input_id" placeholder="아이디를 입력하세요.">
                </td>
            </tr>
            <tr>
                <td class="col_1 right">비밀번호 : </td>
                <td class="col_2 left">
                    <input type="text" id="input_pw" placeholder="아이디를 입력하세요.">
                </td>
            </tr>
            <tr>
                <td class="center">
                    <button class="btn" id="submit_btn" type="button" onclick="loginCheck()">로그인</button>
                    <button class="btn" type="button" onclick="location.href='/main'">홈으로</button>
                </td>
            </tr>
        </table>
    </form>
</body>
<script>
    function loginCheck(){
        const input_id = document.getElementById('#input_id').value();
        const input_pw = document.getElementById('#input_pw').value()
        alert(input_id+input_pw);
    }
</script>
</html>
