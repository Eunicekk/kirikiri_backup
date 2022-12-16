window.onload=function () {

    let userNickname = "사용자 닉네임";

    function userNick(){
        document.getElementById("name").innerText = userNickname;
    }

    userNick();

    let actScore = "10";  // 활동 점수
    function score(){
        document.getElementById("actScore").innerText = actScore;
    }

    score();


    // menu로 각각 다른 tabpage 출력

    let menuCheck = document.querySelector(".menu ul li");
    let ident = menuCheck.id.split("_")[1];

    menuCheck.parentNode.setAttribute("data-current", ident);
    menuCheck.style.color = "blue";
    menuCheck.style.borderBottom = "2px solid blue";

    let tabPages = document.querySelectorAll(".tabPage");
    for(let i =1; i<tabPages.length; i++){
        tabPages[i].style.display="none";
    }

    let menu = document.querySelectorAll(".menu ul li");
    for(let j=0; j<menu.length; j++) {
        menu[j].onclick = click;
    }

    /* for(let k=0; k<menu.length; k++){
         menu[k].onmouseover=function(){
             menu[k].style.borderBottom = "2px solid blue";
             menu[k].style.color = "blue";
         };
     }

     for(let i=0; i<menu.length; i++) {
         menu[i].onmouseout = function () {
             menu[i].style.borderBottom = "none";
             menu[i].style.color = "black";
         };
     }*/


    function click(){
        let current = this.parentNode.getAttribute("data-current");
        document.getElementById("link_"+current).style.color = "black";
        document.getElementById("link_"+current).style.borderBottom = "none";

        document.getElementById("tabPage_"+ current).style.display = "none";

        let ident = this.id.split("_")[1];
        this.style.color = "blue";
        this.style.borderBottom = "2px solid blue"

        document.getElementById("tabPage_"+ ident).style= "block";


        this.parentNode.setAttribute("data-current", ident);
    }

    // 데이터 개수에 따라 div 구현

    class content{
        constructor(boardType, time, title){
            this.boardType = boardType;
            this.time = time;
            this.title = title;
        }
    }
    // 받은 데이터가 2개라고 가정
    let A = new content("자유 게시판", "2022-12-10", "제목1");
    let B = new content("맛집/놀거리", "2022-12-11", "제목2");
    let C = new content("맛집/놀거리", "2022-12-11", "제목2");
    let D = new content("맛집/놀거리", "2022-12-11", "제목2");
    let E = new content("맛집/놀거리", "2022-12-11", "제목2");

    let contentArray = [A,B,C,D,E];
    let count = 5;

    // 받은 데이터의 개수(count) 만큼 div 태그 생성
    function makeDiv(){
        for(let i=0; i<count; i++) {
            let div = document.createElement("div");
            div.className = "content";
            div.id = "content"+ i;

            document.querySelector(".contentParent").prepend(div);
        }
    }

    makeDiv();

    function makeDivInside(){
        for(let i=0; i<count; i++) {
            let whereAndTime = document.createElement("div");
            whereAndTime.className = "whereAndTime";
            whereAndTime.id = "whereAndTime" + i;

            let title = document.createElement("div");
            title.className = "title";
            title.id = "title" + i;

            document.querySelector("#content" + i).append(whereAndTime, title);
        }
    }

    makeDivInside();

    function makeTitleInside(){
        for(let i=0; i<count; i++){
            let title = document.createElement("a");

            document.querySelector("#title" + i).append(title);
            title.innerHTML = contentArray[i].title;
            title.className = "aTitle"
            title.id = "aTitle"+i;
            title.href ="/";
        }
    }

    makeTitleInside();

    function makeWhereAndTimeInside(){
        for(let i=0; i<count; i++){
            let where = document.createElement("div");
            where.className="where";
            where.id="where"+ i;
            let time = document.createElement("div");
            time.className="time";
            time.id="time"+ i;
            document.querySelector("#whereAndTime"+ i).append(where, time);

            time.innerHTML = contentArray[i].time;
            where.innerHTML = contentArray[i].boardType + "에 게시물을 작성하였습니다";
        }
    }

    makeWhereAndTimeInside();


}

