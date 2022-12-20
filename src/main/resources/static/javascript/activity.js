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
    menuCheck.style.color = "rgb(0, 144, 249)";
    menuCheck.style.borderBottom = "2px solid rgb(0, 144, 249)";

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
        this.style.color = "rgb(0, 144, 249)";
        this.style.borderBottom = "2px solid rgb(0, 144, 249)"

        document.getElementById("tabPage_"+ ident).style= "block";


        this.parentNode.setAttribute("data-current", ident);
    }

    // 데이터 개수에 따라 게시물 수 구현

    class content{
        constructor(boardType, time, title){
            this.boardType = boardType;
            this.time = time;
            this.title = title;
        }
    }
    // 받은 데이터가 5개라고 가정
    let A = new content("자유 게시판", "2022-12-10", "제목1");
    let B = new content("맛집/놀거리", "2022-12-11", "제목2");
    let C = new content("고민 상담", "2022-12-12", "제목3");
    let D = new content("구인/구직", "2022-12-13", "제목4");
    let E = new content("맛집/놀거리", "2022-12-14", "제목5");

    let contentArray = [A,B,C,D,E];
    let count = 5;

    // 받은 데이터의 개수(count) 만큼 div 태그 생성
    function makeDiv(){
        for(let i=0; i<count; i++) {
            let div = document.createElement("div");
            div.className = "content";
            div.id = "content"+ i;

            document.querySelector(".write").prepend(div);
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

    //---------------------------------------------------------------------------------

    // 데이터 개수에 따라 댓글 수 구현

    class comment{
        constructor(boardType, time, title, writer){
            this.boardType = boardType;
            this.time = time;
            this.title = title;
            this.writer = writer;
        }
    }
    // 받은 데이터가 3개라고 가정
    let comment1 = new comment("자유 게시판", "2022-12-10", "제목1", "작성자1");
    let comment2 = new comment("맛집/놀거리", "2022-12-11", "제목2", "작성자2");
    let comment3 = new comment("고민 상담", "2022-12-12", "제목3", "작성자3");

    let commentArray = [comment1, comment2, comment3];
    let commentCount = 3;

    // 받은 데이터의 개수(count) 만큼 div 태그 생성
    function makeCommentDiv(){
        for(let i=0; i<commentCount; i++) {
            let div = document.createElement("div");
            div.className = "commentContent";
            div.id = "commentContent"+ i;

            document.querySelector(".comment").prepend(div);
        }
    }

    makeCommentDiv();

    function makeCommentDivInside(){
        for(let i=0; i<commentCount; i++) {
            let whereAndTime = document.createElement("div");
            whereAndTime.className = "commentWhereAndTime";
            whereAndTime.id = "commentWhereAndTime" + i;

            let title = document.createElement("div");
            title.className = "commentTitle";
            title.id = "commentTitle" + i;

            document.querySelector("#commentContent" + i).append(whereAndTime, title);
        }
    }

    makeCommentDivInside();

    function makeCommentTitleInside(){
        for(let i=0; i<commentCount; i++){
            let title = document.createElement("a");

            document.querySelector("#commentTitle" + i).append(title);
            title.innerHTML = commentArray[i].title;
            title.className = "commentATitle"
            title.id = "commentATitle"+i;
            title.href ="/";
        }
    }

    makeCommentTitleInside();

    function makeCommentWhereAndTimeInside(){
        for(let i=0; i<commentCount; i++){
            let where = document.createElement("div");
            where.className="commentWhere";
            where.id="commentWhere"+ i;
            let time = document.createElement("div");
            time.className="commentTime";
            time.id="commentTime"+ i;
            document.querySelector("#commentWhereAndTime"+ i).append(where, time);

            time.innerHTML = commentArray[i].time;
            where.innerHTML = commentArray[i].boardType + "에 " + commentArray[i].writer + "님이 작성한 게시물에 댓글을 작성하였습니다";
        }
    }

    makeCommentWhereAndTimeInside();

    //--------------------------------------------------------------------------------------------------

    class like{
        constructor(boardType, title, writer){
            this.boardType = boardType;
            this.title = title;
            this.writer = writer;
        }
    }
    // 받은 데이터가 10개라고 가정
    let like1 = new like("자유 게시판", "제목1", "작성자1");
    let like2 = new like("맛집/놀거리 게시판", "제목2", "작성자2");
    let like3 = new like("고민 상담 게시판", "제목3", "작성자3");
    let like4 = new like("구인/구직 게시판", "제목4", "작성자4");
    let like5 = new like("자유 게시판", "제목5", "작성자5");
    let like6 = new like("자유 게시판", "제목6", "작성자6");
    let like7 = new like("고민 상담 게시판", "제목7", "작성자7");
    let like8 = new like("구인/구직 게시판", "제목8", "작성자8");
    let like9 = new like("자유 게시판", "제목9", "작성자9");
    let like10 = new like("맛집/놀거리 게시판", "제목10", "작성자10");

    let likeArray = [like1, like2, like3, like4, like5, like6, like7, like8, like9, like10];
    let likeCount = 10;

    function makeLikeDiv(){
        for(let i=0; i<likeCount; i++) {
            let div = document.createElement("div");
            div.className = "likeContent";
            div.id = "likeContent"+ i;

            document.querySelector(".like").prepend(div);
        }
    }

    makeLikeDiv();

    function makeLikeDivInside(){
        for(let i=0; i<likeCount; i++) {
            let where = document.createElement("div");
            where.className = "likeWhere";
            where.id = "likeWhere" + i;

            let title = document.createElement("div");
            title.className = "likeTitle";
            title.id = "likeTitle" + i;

            document.querySelector("#likeContent" + i).append(where, title);

        }
    }

    makeLikeDivInside();


    function makeLikeTitleInside(){
        for(let i=0; i<likeCount; i++){
            let title = document.createElement("a");

            document.querySelector("#likeTitle" + i).append(title);
            title.innerHTML = likeArray[i].title;
            title.className = "likeATitle"
            title.id = "likeATitle"+i;
            title.href ="/";
        }
    }

    makeLikeTitleInside();

    function makeLikeWhereInside(){
        for(let i=0; i<likeCount; i++){
            let where = document.createElement("div");

            document.querySelector("#likeWhere" + i).append(where);
            where.innerHTML = likeArray[i].boardType + "에 " + likeArray[i].writer + "님이 작성한 게시물에 좋아요를 작성하였습니다";
            where.className = "likeAWhere";
            where.id = "likeAWhere"+i;
        }
    }

    makeLikeWhereInside();


}

