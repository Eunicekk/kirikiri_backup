window.onload=function(){
    let password1 = document.getElementById("password1");
    let password2 = document.getElementById("password2");
    let password3 = document.getElementById("password3");
    let button_event= document.getElementById("button-event");
    let passwordErrMsg = document.getElementById("warningPw");
    let passwordErrMsg2 = document.getElementById("warningPw2");
    //에러메세지

    // 비밀번호 최소 6자 이상 입력해주세요
    function over6Password() {
        var condi = /^(?=.*?[a-z])(?=.*?[0-9]).{6,}$/;
        var pwd = $("#resPass").val();
        if (false === condi.test(pwd)) {
            passwordErrMsg.style.display = "flex";
        } else {
            passwordErrMsg.style.display = "none";
        }
    }
    // 비밀번호가 일치하지 않습니다
    function confirmPassword(){
        if(password2.value != password3.value) {
            button_event.addEventListener("click", ()=>{
                passwordErrMsg2.style.display = "flex";
            })
        } else {
            passwordErrMsg2.style.display = "none";
            password3.onkeyup = confirmPassword;
        }
    }
}
