window.onload = ()=>{
    // 댓글 모두 숨기기 버튼 클릭 시, 해당 댓글의 대댓글이 닫힘
    let hideCommentsButton = document.getElementsByClassName("comment-reply-hidden");
    let comments = document.getElementsByClassName("comment-reply-list");
    let hiddenCheck = document.getElementsByClassName("hidden-check");

    for(let i = 0; i < hideCommentsButton.length; i++){
        hideCommentsButton[i].addEventListener("click", ()=>{
            if(hiddenCheck[i].checked === false) {
                hiddenCheck[i].checked = true;
                comments[i].style.display = "none";
                hideCommentsButton[i].innerHTML = "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"currentColor\" aria-hidden=\"true\" class=\"rotate-180 transform h-4 w-4\"><path fill-rule=\"evenodd\" d=\"M11.47 7.72a.75.75 0 011.06 0l7.5 7.5a.75.75 0 11-1.06 1.06L12 9.31l-6.97 6.97a.75.75 0 01-1.06-1.06l7.5-7.5z\" clip-rule=\"evenodd\"></path></svg>댓글 모두 보기";
            } else {
                hiddenCheck[i].checked = false;
                comments[i].style.display = "block";
                hideCommentsButton[i].innerHTML = "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"currentColor\" aria-hidden=\"true\" class=\"h-4 w-4\"><path fill-rule=\"evenodd\" d=\"M11.47 7.72a.75.75 0 011.06 0l7.5 7.5a.75.75 0 11-1.06 1.06L12 9.31l-6.97 6.97a.75.75 0 01-1.06-1.06l7.5-7.5z\" clip-rule=\"evenodd\"></path></svg>댓글 모두 숨기기";
            }
        })
    }

    // 댓글 쓰기 버튼 클릭 시, 해당 댓글의 답글 작성란 보여주기
    let writeCommentButton = document.getElementsByClassName("comment-reply-add");
    let replyForm = document.getElementsByClassName("comment-reply-write");
    let replyCheck = document.getElementsByClassName("reply-check")

    for(let i = 0; i < writeCommentButton.length; i++){
        writeCommentButton[i].addEventListener("click", ()=>{
            if(replyCheck[i].checked === false) {
                replyForm[i].style.display = "block";
                replyCheck[i].checked = true;
                writeCommentButton[i].innerHTML = "댓글 취소"
            } else {
                replyForm[i].style.display = "none"
                replyCheck[i].checked = false;
                writeCommentButton[i].innerHTML = "댓글 쓰기"
            }
        })
    }
}