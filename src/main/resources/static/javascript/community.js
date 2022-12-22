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
}