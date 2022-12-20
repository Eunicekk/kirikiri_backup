window.onload=function() {


    // 메뉴로 페이지 이동 이벤트
    let navitem = document.querySelector(".menu ul li");
    let ident = navitem.id.split("_")[1];

    navitem.parentNode.setAttribute("data-current", ident);
    navitem.setAttribute("style", "background-color : #e5e7eb");

    let pages = document.querySelectorAll(".tabpage");
    for (let i = 1; i < pages.length; i++) {
        pages[i].style.display = "none";
    }

    let tabs = document.querySelectorAll(".menu ul li");
    for (let j = 0; j < tabs.length; j++) {
        tabs[j].onclick = click;
    }


    function click() {
        let current = this.parentNode.getAttribute("data-current");
        document.getElementById("link_" + current).setAttribute("style", "background-color : #fff");

        document.getElementById("tabpage_" + current).style.display = "none";

        let ident = this.id.split("_")[1];
        this.setAttribute("style", "background-color: #e5e7eb");
        document.getElementById("tabpage_" + ident).style = "block";

        this.parentNode.setAttribute("data-current", ident);
    }


    // 썸네일 이벤트
    const file = document.querySelector("input[type='file']");
    const thumbnail = document.querySelector("label[for='picture'] div");
    file.addEventListener("change", function (event) {
        let reader = new FileReader();
        reader.readAsDataURL(event.target.files[0]);
        reader.onload = function (event) {
            console.log(event);
            let url = event.target.result;
            if (url.includes("image")) {
                thumbnail.style.backgroundImage = "url('" + url + "')";
            } else {
                thumbnail.style.backgroundImage = "url('../../img/account.png')";
                // ../images/account.png 대신 backend에 저장된 이미지 파일
            }
        }
    });


    // delete 버튼 활성화
    const form = document.querySelector("#delete_form");
    const checkBox = document.querySelector("#checknotice");
    const submitButton = document.querySelector("#delete");
    let agreement = false;

    checkBox.addEventListener('input', function (event) {
        agreement = !agreement;
        toggleSubmitButton();
    });

    function toggleSubmitButton() {
        if (agreement) {
            submitButton.disabled = false; // 동의가 되었으면 활성화
        } else {
            submitButton.disabled = true; // 동의가 안되어있으면 비활성화
        }
    }

    // -------------------------------------------------------------------------------













    // -------------------------------------------------------------------------------
    // 미완성...
    // 소셜 계정 연동 여부



    // class social{
    //     constructor(socialType, bool){
    //         this.socialType =socialType;
    //         this.bool = bool;
    //     }
    // }
    //
    // let git = new social("git", true);
    // let google = new social("google", false);
    // let facebook = new social("facebook", true);
    // let naver = new social("naver", false);
    // let kakao = new social("kakao", true);

    // let socialArray = [git, google, facebook, naver, kakao]

    //
    // if(git.bool === true){
    //     document.getElementById("git").style.opacity = 1;
    //     document.querySelector("#git span").innerHTML = "깃허브 해제하기";
    // }
    // if(google.bool === true){
    //     document.getElementById("google").style.opacity = 1;
    //     document.querySelector("#google span").innerHTML = "구글 해제하기";
    // }
    // if(facebook.bool === true){
    //     document.getElementById("facebook").style.opacity = 1;
    //     document.querySelector("#facebook span").innerHTML = "메타 해제하기";
    // }
    // if(naver.bool === true){
    //     document.getElementById("naver").style.opacity = 1;
    //     document.querySelector("#naver span").innerHTML = "네이버 해제하기";
    // }
    // if(kakao.bool === true){
    //     document.getElementById("kakao").style.opacity = 1;
    //     document.querySelector("#kakao span").innerHTML = "카카오톡 해제하기";
    // }
    //
    //
    //
    // if(git.bool === false){
    //     document.getElementById("git").style.opacity = 0.3;
    //     document.querySelector("#git span").innerHTML = "깃허브 연결하기";
    //     document.getElementById("git").onclick = function () {
    //         document.getElementById("git").href = "";
    //     }
    // }
    // if(google.bool === false){
    //     document.getElementById("google").style.opacity = 0.3;
    //     document.querySelector("#google span").innerHTML = "구글 연결하기";
    // }
    // if(facebook.bool === false){
    //     document.getElementById("facebook").style.opacity = 0.3;
    //     document.querySelector("#facebook span").innerHTML = "메타 연결하기";
    // }
    // if(naver.bool === false){
    //     document.getElementById("naver").style.opacity = 0.3;
    //     document.querySelector("#naver span").innerHTML = "네이버 연결하기";
    // }
    // if(kakao.bool === false){
    //     document.getElementById("kakao").style.opacity = 0.3;
    //     document.querySelector("#kakao span").innerHTML = "카카오톡 연결하기";
    // }


    // let trueCount = 3;
    // let socialArray = [git, google, facebook, naver, kakao];
    //
    // document.getElementById("git").addEventListener("click", function(event) {
    //     if (trueCount != 1) {
    //         if (git.bool == true){
    //             git.bool = false;
    //             trueCount--;
    //         }
    //     }
    //
    // })










    //
    // for(let i=0; i<socialArray.length; i++){
    //
    //     document.getElementById(socialArray[i].socialType).addEventListener("click", function (event) {
    //         if(trueCount != 1){
    //             if(socialArray[i].socialType == true){
    //                 socialArray[i].socialType == false;
    //                 trueCount--;
    //
    //                 event.preventDefault();
    //             }
    //         }else{
    //             alert("머임");
    //             swal({
    //                 title : "소셜계정 연동해제 실패",
    //                 text : "로그인에 필요한 마지막 SNS 계정이기 떄문에 삭제할 수 없습니다",
    //                 icon : "warning"
    //             })
    //             event.preventDefault();
    //         }
    //     })
    // }




    // =============================================================


    // 이메일 유효성 검사

    let userEmail = document.getElementById("email");
    let changeEmail = null;

    userEmail.addEventListener("change", function(){
        changeEmail = userEmail.value;
    })


    const exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
    let duplicateCheck = false;
    let count = 0;

    document.getElementById("emailSubmit").addEventListener("click",function (event) {
        if((changeEmail.length == 0 || !exptext.test(changeEmail)) && count === 0){
            event.preventDefault();
            let div = document.createElement("div");
            div.className = "wrong-email-div";
            div.innerText = "올바른 이메일 형식이 아닙니다."
            document.querySelector(".wrong-email").append(div);
            count++;
        }else if(changeEmail.length == 0 || !exptext.test(changeEmail)){
            event.preventDefault();
        }

        /*if(changeEmail.length == 0){
            swal({
                title : "이메일 오류",
                text : "이메일을 입력하지 않으셨습니다",
                icon : "error"
            })
            //alert(changeEmail.length);
            event.preventDefault();
        }else if(!exptext.test(changeEmail)){
            swal({
                title : "이메일 오류",
                text : "올바르지 않은 형식입니다",
                icon : "warning"
            })
            //alert(changeEmail.length);
            event.preventDefault();
        }else if(duplicateCheck == true){
            swal({
                title : "이메일 오류",
                text : "중복된 이메일입니다",
                icon : "error"
            })
            event.preventDefault();
        }else{
            return true;
        }*/
    });

    // 필수 정보 입력 여부

    let changeName = null;
    let changeNickname = null;
    let nicknameDuplicate = false;

    document.getElementById("username").addEventListener("change", function () {
        changeName = document.getElementById("username").value;
    })
    document.getElementById("userNickname").addEventListener("change", function () {
        changeNickname = document.getElementById("userNickname").value;
    })

    document.getElementById("infoSubmit").addEventListener("click",function (event) {

        if(changeName != null && changeNickname == null) {
            if(changeName.length == 0){
                swal({
                    title : "이름 오류",
                    text : "이름이 입력되지 않았습니다",
                    icon : "warning"
                })
                event.preventDefault();
            }
        }else if(changeName == null && changeNickname != null) {
            if (changeNickname.length == 0) {
                swal({
                    title: "닉네임 오류",
                    text: "닉네임이 입력되지 않았습니다",
                    icon: "warning"
                })
                event.preventDefault();
            } else if (nicknameDuplicate == true) {
                swal({
                    title: "닉네임 오류",
                    text: "중복되 닉네임입니다",
                    icon: "warning"
                })
                event.preventDefault();
            }
        }else if (changeName != null && changeNickname != null) {
                if (changeName.length == 0 && changeNickname.length == 0) {
                    swal({
                        title: "이름, 닉네임 오류",
                        text: "이름과 닉네임이 입력되지 않았습니다",
                        icon: "warning"
                    })
                    event.preventDefault();
                } else if (changeName.length == 0) {
                    swal({
                        title: "이름 오류",
                        text: "이름이 입력되지 않았습니다",
                        icon: "warning"
                    })
                    event.preventDefault();
                } else if (changeNickname == 0) {
                    swal({
                        title: "닉네임 오류",
                        text: "닉네임이 입력되지 않았습니다",
                        icon: "warning"
                    })
                    event.preventDefault();
                } else if (nicknameDuplicate === true) {
                    swal({
                        title: "닉네임 오류",
                        text: "중복된 닉네임입니다",
                        icon: "warning"
                    })
                    event.preventDefault();
                }

            }
    })

}

function checkSlide1(){
    if(document.querySelector("#toggle-slide1").checked){
        document.querySelector(".userage span").innerText = "공개";
        document.querySelector(".userage span").style.color = "#0090F9";
    }else{
        document.querySelector(".userage span").innerText = "비공개";
        document.querySelector(".userage span").style.color = "#e5e7eb";
    }
}
function checkSlide2(){
    if(document.querySelector("#toggle-slide2").checked){
        document.querySelector(".userlivingplace span").innerText = "공개";
        document.querySelector(".userlivingplace span").style.color = "#0090F9";
    }else{
        document.querySelector(".userlivingplace span").innerText = "비공개";
        document.querySelector(".userlivingplace span").style.color = "#e5e7eb";
    }
}

function mouseOver(target){
    target.style.opacity = "1";
    target.style.cursor = "pointer";
}
function mouseOut(target){
    target.style.opacity = "0.3";
}