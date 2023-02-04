window.onload = () => {
    // 정렬 버튼 클릭 시, 정렬 항목 나열
    let sort = document.getElementById("sort-button");
    let sortType = document.getElementById("sort-type");
    let check = document.getElementById("sort-check");
    sort.addEventListener("click", ()=>{
        if(check.checked === false) {
            sortType.style.visibility = "visible";
            check.checked = true;
        }
        else {
            sortType.style.visibility = "hidden";
            check.checked = false;
        }
    })

    let myPage = document.getElementsByClassName("mypage");
    let myPageMenu = document.getElementById("mypage-menu");
    let myPageCheck = document.getElementById("mypage-check");

    myPage[0].addEventListener("click", ()=>{
        if(myPageCheck.checked === false) {
            myPageMenu.style.visibility = "visible";
            myPageCheck.checked = true;
        }
        else {
            myPageMenu.style.visibility = "hidden";
            myPageCheck.checked = false;
        }
    })
}