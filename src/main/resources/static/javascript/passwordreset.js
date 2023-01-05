window.onload=function(){
    let password1 = document.getElementById("password1");
    let password2 = document.getElementById("password2");
    let password3 = document.getElementById("password3");
    let button_event= document.getElementById("button-event");
    let passwordErrMsg = document.getElementById("warningPw");
    let passwordErrMsg2 = document.getElementById("warningPw2");

    //비밀번호는 최소 6자 이상, 영문과 숫자로 이뤄져야합니다
    password2.addEventListener("keyup", ()=>{
        if(password2.value.length < 6) {
            passwordErrMsg.style.display = "flex";
        } else {
            passwordErrMsg.style.display = "none";
        }

        const cond = /^(?=.*?[a-z])(?=.*?[0-9]).{6,}$/;
        if(false===cond.test(password2.value)) {
            passwordErrMsg.style.display = "flex";
        } else {
            passwordErrMsg.style.display = "none";
        }
        if(password2.value != password3.value) {
            passwordErrMsg2.style.display = "flex";
        } else {
            passwordErrMsg2.style.display = "none";
        }
    })
    //비밀번호가 일치하지 않습니다
    password3.addEventListener("keyup", ()=>{
        if(password2.value != password3.value) {
            passwordErrMsg2.style.display = "flex";
        } else {
            passwordErrMsg2.style.display = "none";
        }
    })

    console.log(id);
    $("#button-event").on("click", function () {
        const id = $("#id").val();
        const password = $("#password").val();
        $.ajax({
            type: "post",
            url: "/check/login",
            data: {
                userId: id,
                userPassword: password
            },
            success: function (data) {
                if(data) {
                    $("#PwForm").submit();
                } else {
                    $("#password-reset-fail").css("display", "flex");
                }
            }
        })
    })
}
