window.onload=function(){
    let password1 = document.getElementById("password1");
    let password2 = document.getElementById("password2");
    let password3 = document.getElementById("password3");
    let button_event= document.getElementById("button-event");
    // 비밀번호 최소 6자 이상 입력해주세요
    function over6Password() {
        var condi = /^(?=.*?[a-z])(?=.*?[0-9]).{6,}$/;
        var pwd = $("#resPass").val();
        if (false === condi.test(pwd)) {
            alert('비밀번호는 6자 이상이어야 하며, 숫자/소문자를 포함해야 합니다.');
            return false;
        } else {
            console.log("이벤트");
            return true;
            }
        }
    }
    // 비밀번호가 일치하지 않습니다
function confirmPassword(){
    if(password2 != password3) {
        password3.setCustomValidity("비밀번호가 일치하지 않습니다.");
    } else {
        password3.setCustomValidity('');
    }
}
password3.onkeyup = confirmPassword;