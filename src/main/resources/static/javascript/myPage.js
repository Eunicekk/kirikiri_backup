window.onload=function(){

    // 메뉴로 페이지 이동 이벤트
    let navitem = document.querySelector(".menu ul li");
    let ident = navitem.id.split("_")[1];

    navitem.parentNode.setAttribute("data-current", ident);
    navitem.setAttribute("style","background-color : gray");

    let pages = document.querySelectorAll(".tabpage");
    for(let i=1; i<pages.length; i++){
        pages[i].style.display="none";
    }

    let tabs = document.querySelectorAll(".menu ul li");
    for(let j=0; j<tabs.length; j++){
        tabs[j].onclick=click;
    }


    function click(){
        let current = this.parentNode.getAttribute("data-current");
        document.getElementById("link_" + current).setAttribute("style","background-color : #fff");

        document.getElementById("tabpage_" + current).style.display="none";

        let ident = this.id.split("_")[1];
        this.setAttribute("style", "background-color: gray");
        document.getElementById("tabpage_" + ident).style = "block";

        this.parentNode.setAttribute("data-current", ident);
    }


    // 썸네일 이벤트
    const file = document.querySelector("input[type='file']");
    const thumbnail = document.querySelector("label[for='picture'] div");
    file.addEventListener("change", function(event){
        let reader = new FileReader();
        reader.readAsDataURL(event.target.files[0]);
        reader.onload = function(event){
            console.log(event);
            let url = event.target.result;
            if(url.includes("image")){
                thumbnail.style.backgroundImage = "url('" + url +"')";
            }else{
                thumbnail.style.backgroundImage = "url('../images/account.svg')";
            }
        }
    });

    // delete 버튼 활성화
    const form = document.querySelector("#delete_form");
    const checkBox = document.querySelector("#checknotice");
    const submitButton = document.querySelector("#delete");
    let agreement = false;

    form.addEventListener('submit', (e)=>e.preventDefault()); // 새로 고침(submit) 되는 것을 막음

    checkBox.addEventListener('input', function(event){
        agreement = !agreement;
        toggleSubmitButton();
    });

    function toggleSubmitButton(){
        if(agreement){
            submitButton.disabled = false; // 동의가 되었으면 활성화
        }else{
            submitButton.disabled = true; // 동의가 안되어있으면 비활성화
        }
    }






}

