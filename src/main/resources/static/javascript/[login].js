window.onload = () => {
    // 아이디 혹은 비밀번호 입력하지 않을 시, 경고메세지
    let id = document.getElementById("id");
    let password = document.getElementById("password");

    let warningMsgId = document.getElementById("warning-msg-id");
    let warningMsgPw = document.getElementById("warning-msg-pw");
    id.addEventListener("keyup", ()=>{
        console.log(3);
        if(id.value === "") {
            warningMsgId.style.display = "flex";
            warningMsgPw.style.display = "none";
        } else if(password.value === "") {
            warningMsgId.style.display = "none";
            warningMsgPw.style.display = "flex";
        } else {
            warningMsgId.style.display = "none";
            warningMsgPw.style.display = "none";
        }
    })
    password.addEventListener("keyup", ()=>{
        if(id.value === "") {
            warningMsgId.style.display = "flex";
            warningMsgPw.style.display = "none";
        } else if(password.value === "") {
            warningMsgId.style.display = "none";
            warningMsgPw.style.display = "flex";
        } else {
            warningMsgId.style.display = "none";
            warningMsgPw.style.display = "none";
        }
    })


    let login = document.getElementById("login-button");
    let loginErrMsg = document.getElementById("login-fail");
    login.addEventListener("click", ()=>{
        loginErrMsg.style.display = "flex";
    })
}