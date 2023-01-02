window.onload=function(){
    let password1 = document.getElementById("password1");
    let password2 = document.getElementById("password2");
    let password3 = document.getElementById("password3");
    let button_event= document.getElementById("button-event");
    let passwordErrMsg = document.getElementById("warningPw");
    let passwordErrMsg2 = document.getElementById("warningPw2");
    let flag1 = 0;
    let flag2 = 0;
    let flag3 = 0;
    // 비밀번호 최소 6자 이상 입력해주세요
    password2.addEventListener("keyup", ()=>{
        if(password2.value.length < 6) {
            passwordErrMsg.style.display = "flex";
            flag1 = 0;
            if (flag1===0 || flag2===0 || flag3===0){
                button_event.style.display = "none";
            }
        } else {
            passwordErrMsg.style.display = "none";
            flag1 = 1;
            if (flag1===1 && flag2===1 && flag3===1){
                button_event.style.display = "block";
            }
        }
    })
    //비밀번호는 영문과 숫자로 이뤄져야합니다
    password2.addEventListener("keyup", ()=>{
        const cond = /^(?=.*?[a-z])(?=.*?[0-9]).{6,}$/;
        if(false===cond.test(password2.value)) {
            passwordErrMsg.style.display = "flex";
            flag2 = 0;
            if (flag1===0 || flag2===0 || flag3===0){
                button_event.style.display = "none";
            }
        } else {
            passwordErrMsg.style.display = "none";
            flag2 = 1;
            if (flag1===1 && flag2===1 && flag3===1){
                button_event.style.display = "block";
            }
        }
    })
    //비밀번호가 일치하지 않습니다
    password3.addEventListener("keyup", ()=>{
        if(password2.value != password3.value) {
            passwordErrMsg2.style.display = "flex";
            flag3 = 0;
            if (flag1===0 || flag2===0 || flag3===0){
                button_event.style.display = "none";
            }
        } else {
            passwordErrMsg2.style.display = "none";
            flag3 = 1;
            if (flag1===1 && flag2===1 && flag3===1){
                button_event.style.display = "block";
            }
        }
    })


}
