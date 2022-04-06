<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>서블릿 회원가입</title>
    <link rel="stylesheet" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.min.js"></script>
</head>

<body style="text-align: center;">

    <h2>Join Page</h2>
    <form action="${pageContext.request.contextPath}/join.do" method="post" id="joinF" style="text-align: left; width: 500px;margin: 0 auto;">
    <table style="text-align: right; width: 500px; margin: 0 auto;">
        <tr>
            <td class="col_1">이 메 일</td>
            <td class="col_2 left"><input oninput="checkEmail()" class="inputT" type="text" id="userEmail" name="userEmail" placeholder="이메일을 입력해주세요."></td>
        </tr>
        <tr>
            <td class="col_1"></td>
            <td class="col_2 left">
                <span id="email_ok">사용 가능한 아이디입니다.</span>
                <span id="email_already">이미 사용중인 아이디입니다.</span>
            </td>
        </tr>
        <tr>
            <td class="col_1">비 밀 번 호</td>
            <td class="col_2 left"><input type="password" class="inputT" id="userpw" name="userpw"
            placeholder="6~13자리 영문,숫자,특수문자"></td>
        </tr>
        <tr>
            <td class="col_1" style="font-size: 17px;">비밀번호확인</td>
            <td class="col_2 left"><input type="password" class="inputT" id="checkpw" name="checkpw"
            placeholder="비밀번호를 입력해주세요."></td>
        </tr>
        <tr>
            <td class="col_1">이&nbsp;&nbsp; 름</td>
            <td class=" left"><input type="text" class="inputT" id="name" name="name"
            placeholder="이름을 입력해주세요."></td>
        </tr>
        <tr>
            <td colspan="2">
                <div class="center">
                    <button class="btn" id="submit_btn" type="button" onclick="joinCheck()">회원가입</button>
                    <button class="btn" type="button" onclick="location.href='/main.do'">홈으로</button>
                </div>
            </td>
        </tr>
    </table>
    </form>
</body>
<script>
    let inputCheck = 0;
    function checkEmail() {
        let userEmail = $("#userEmail").val(); //id값이 userEmail인 곳의 값 저장
        $.ajax({
            url: '/checkId.do', //컨트롤러에서 인식할 주소
            type: 'post',
            data: {userEmail: userEmail},
            dataType: 'text',
            success: function (result) {
                console.log("result : " + result)
                if (result == 1) {
                    $('#email_already').css('display', 'none');
                    $('#email_ok').css('display', 'block');
                    $('#email_ok').css('color', '#397a07');
                    inputCheck = 1;
                    console.log("inputId : " + inputCheck);
                } else {
                    $('#id_ok').css('display', 'none');
                    $('#id_already').css('display', 'block');
                    inputCheck = 0;
                    console.log("inputId : " + inputCheck);
                }
            }
        })
    }

    function joinCheck() {
        const email = document.getElementById('userEmail');
        const userpw = document.getElementById('userpw');
        const checkpw = document.getElementById('checkpw');
        const name = document.getElementById('name');
        console.log(inputCheck);
        if (!email.value){
            alert('이메일을 입력해주세요.');
            email.focus();
            return false;
        }
        if(inputCheck==0){
            console.log(inputId);
            alert('다른 이메일을 입력해주세요.');
            email.focus();
            return false;
        }
        if (!userpw.value){
            alert('비밀번호를 입력해주세요');
            userpw.focus();
            return false;
        }
        //비밀번호 정규식

        const pwCheck = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@!%*#?&])[A-Za-z\d$@!%*#?&]{6,13}$/;
        if (!pwCheck.test(userpw.value)){
            alert('비밀번호는 영문자+숫자+특수문자 조합으로 6~13자리로 입력해주세요.');
            userpw.focus();
            return false;
        }
        if (checkpw.value!==userpw.value){
            alert('비밀번호가 일치하지 않습니다.');
            checkpw.focus();
            return false;
        }
        if (!name.value){
            alert('이름을 입력해주세요.');
            name.focus();
            return false;
        }

        document.getElementById('joinF').submit();
    }
    //이메일 자동완성
    //function change_email(){
      //  const email_add = document.getElementById('email_add');
        //const email_sel = document.getElementById('email_sel');
//
  //      const idx = email_sel.options.selectedIndex; //선택된 옵션순서
    //    const val = email_sel.options[idx].value;    //선택된 옵션 값

 //       email_add.value = val;
 //   }
</script>
</html>
