window.onload = () => {
    // 정렬 버튼 클릭 시, 정렬 항목 나열
    let sort = document.getElementById("sort-button");
    let sortType = document.getElementById("sort-type");
    sort.addEventListener("click", ()=>{
        if(sortType.style.visibility === "hidden") {
            sortType.style.visibility = "visible";
        }
        else {
            sortType.style.visibility = "hidden";
        }
    })
}