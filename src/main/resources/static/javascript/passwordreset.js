window.onload=function(){
    let nowPass = document.getElementById("password1");
    let resPass = document.getElementById("password2");
    let retryPass = document.getElementById("password3");
    let buttonEvent = document.getElementById("button-event");
    // 비밀번호 최소 6자 이상 입력해주세요
    function over6Password() {
        var reg = /^(?=.*?[a-z])(?=.*?[0-9]).{6,}$/;
        var pw = $("#resPass").val();
        if (false === reg.test(pw)) {
            alert('비밀번호는 6자 이상이어야 하며, 숫자/소문자를 포함해야 합니다.');
        } else {
            console.log("이벤트");
            }
        }
    }
    // 비밀번호가 일치하지 않습니다
if(resPass!==retryPass) {
    swal({
        title: "비밀번호가 이상합니다.", text: "비밀번호가 일치하지 않습니다.", icon: "wornning"
    })
}

    // 비밀번호가 성공적으로 변경되었습니다. *이벤트*