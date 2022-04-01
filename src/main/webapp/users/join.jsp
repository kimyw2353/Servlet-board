<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>서블릿 회원가입</title>
    <script src="../WEB-INF/lib/jquery-3.6.0.min.js"></script>
</head>
<body style="text-align: center">
    <h2>Join Page</h2>
    <form action="${pageContext.request.contextPath}/join.do" method="post" id="joinF" style="text-align: left; width: 500px;margin: 0 auto;">
        <div>
            <label for="userid">아 이 디</label>
            <input type="text" id="userid" name="userid">
            <button type="button" onclick="idCheck()" name="checkId" class="checkId">중복 확인</button>
        </div>
        <div>
            <label for="userpw">비밀번호</label>
            <input type="password" id="userpw" name="userpw" placeholder="6~13자리의 영문자+숫자+특수문자 조합" size="30">
        </div>
        <div>
            <label for="checkpw">비밀번호확인</label>
            <input type="password" id="checkpw" name="checkpw" placeholder="비밀번호를 한번 더 입력해 주세요" size="30">
        </div>
        <div>
            <label for="name">이 름</label>
            <input type="text" id="name" name="name">
        </div>
        <div>
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" size="15">
            <!--<input type="text" id="email_add" name="email_add" size="15">
            <select name="email_sel" id="email_sel" onchange="change_email()";>
                <option value="">--직접입력--</option>
                <option value="naver.com">naver.com</option>
                <option value="gmail.com">gmail.com</option>
                <option value="daum.net">daum.net</option>
            </select>-->
        </div>
            <button type="button" onclick="joinCheck()">회원가입</button>
    </form>
</body>
<script>
    //const joinF = document.getElementById('joinF');

    let checkId = 0;
    $(function (){
        $("#checkId").click(function (){
            const userid = $("#userid").val();
            $.ajax({
                async:true,
                type: 'POST',
                data: userid,
                url : "/idcheck",
                dataType : "json",
                contentType : "application/json; charset=UTF-8",
                success : function (data){
                    if(data.cnt > 0){
                        alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
                        $("#userid").focus();
                    }else{
                        alert("사용 가능한 아이디입니다.");
                        $("userpw").focus();
                        checkId = 1;
                    }
                },
                error : function (error){
                    alert("error : "+error);
                }
            });
        });
    });

    function joinCheck() {
    const userid = document.getElementById('userid');
    const userpw = document.getElementById('userpw');
    const checkpw = document.getElementById('checkpw');
    const name = document.getElementById('name');
    const email = document.getElementById('email');

    if (!userid.value){
        alert('아이디를 입력해주세요');
        userid.focus();
        return false;
    }
    if (!userpw.value){
        alert('비밀번호를 입력해주세요');
        userid.focus();
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
    if (!email.value){
        alert('이메일을 입력해주세요.');
        checkpw.focus();
        return false;
    }
    document.getElementById('joinF').submit();
    }

    function idCheck() {
        const userid = joinF.userid.value;
        if (userid.length == 0 || userid == "") {
            alert('아이디를 입력해주세요.');
            joinF.userid.focus();
        }else {
            window.open('', '', 'top=300, left=300, width=400, height=150');
        }
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
