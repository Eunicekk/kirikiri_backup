window.onload = () =>{
    $(document).ready(function () {
        $('#summernote').summernote({
            placeholder: '내용을 입력해주세요',
            height: 400,
            maxHeight: 400,
            minHeight: 400,
        });
    });
}