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
                hideCommentsButton[i].innerHTML = "댓글 모두 보기";
            } else {
                hiddenCheck[i].checked = false;
                comments[i].style.display = "block";
                hideCommentsButton[i].innerHTML = "댓글 모두 숨기기";
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