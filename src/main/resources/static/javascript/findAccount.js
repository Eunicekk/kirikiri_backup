window.onload = function () {
    document.getElementById("not-email").style.display = "none";
    document.getElementById("failed-search").style.display = "none";
    document.addEventListener("keyup", email_check, false);

    function email_check(event) {
        var email = document.getElementById("input-checkbox").value;
        var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

        if (exptext.test(email) != true) { //이메일 형식이 아닐 경우
            document.getElementById("not-email").style.display = "";
            document.getElementById("failed-search").style.display = "none";
            return false;
        } else { //이메일 형식이 맞을 경우
            if(email == 0){ // DB와 비교해 있는 이메일이 아니면 출력
                document.getElementById("not-email").style.display = "none";
                document.getElementById("failed-search").style.display = "";
            }
            else{ // DB와 비교해 있는 이메일이면 확인 페이지로 넘어가기

            }
        }
    }
}