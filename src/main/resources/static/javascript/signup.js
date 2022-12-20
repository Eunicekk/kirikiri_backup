window.onload = ()=>{
    // 회원가입 빈칸에 잘못 입력 시 경고 메세지
    console.log(3);
    let id = document.getElementById("id");
    let password = document.getElementById("password");
    let email = document.getElementById("email");
    let name = document.getElementById("name");
    let nickname = document.getElementById("nickname");

    let msgId = document.getElementById("warning-msg-id")
    let msgPw1 = document.getElementById("warning-msg-pw1")
    let msgPw2 = document.getElementById("warning-msg-pw2")
    let msgEmail = document.getElementById("warning-msg-email")
    let msgName = document.getElementById("warning-msg-name")
    let msgNickname = document.getElementById("warning-msg-nickname")

    const passwordCheck = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]/;
    const emailCheck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

    id.addEventListener("keyup", ()=>{
        if(id.value.length < 4) {
            msgId.style.display = "flex";
        } else {
            msgId.style.display = "none";
        }
    })
    password.addEventListener("keyup", ()=>{
        if(password.value.length < 6) {
            msgPw1.style.display = "flex";
            msgPw2.style.display = "none";
        } else if(!passwordCheck.test(password.value)) {
            msgPw1.style.display = "none";
            msgPw2.style.display = "flex";
        } else {
            msgPw1.style.display = "none";
            msgPw2.style.display = "none";
        }

    })
    email.addEventListener("keyup", ()=>{
        if(!emailCheck.test(email.value)) {
            msgEmail.style.display = "flex";
        } else {
            msgEmail.style.display = "none";
        }
    })
    name.addEventListener("keyup", ()=>{
        if(name.value.length < 2) {
            msgName.style.display = "flex";
        } else {
            msgName.style.display = "none";
        }
    })
    nickname.addEventListener("keyup", ()=>{
        if(nickname.value.length < 1) {
            msgNickname.style.display = "flex";
        } else {
            msgNickname.style.display = "none";
        }
    })

    // 회원가입 클릭 시, 아이디 중복 확인 체크하고 중복 시에 경고 메세지, 아니면 회원가입
    let signup = document.getElementById("signup-button");
    let signupErrMsg = document.getElementById("signup-fail");

    signup.addEventListener("click", ()=>{
        signupErrMsg.style.display = "flex";
    })

    // 이메일 수신 동의 버튼 클릭 시, 좌우로 이동
    let emailButton = document.getElementById("email-agree-button");
    let check = document.getElementById("email-check");
    let emailButtonCircle = document.getElementById("email-agree-button-circle");

    emailButton.addEventListener("click", ()=>{
        if(check.checked === true) {
            emailButton.style.backgroundColor = "rgb(229 231 235)";
            emailButtonCircle.style.transform = "translate(-20px)";
            check.checked = false;
        } else {
            emailButton.style.backgroundColor = "rgb(0 144 249)";
            emailButtonCircle.style.transform = "translate(0)";
            check.checked = true;
        }
    })
}