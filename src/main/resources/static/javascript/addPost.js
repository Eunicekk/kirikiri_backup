window.onload = () =>{
    $(document).ready(function () {
        $('#summernote').summernote({
            placeholder: '내용을 입력해주세요',
            height: 400,
            maxHeight: 400,
            minHeight: 400,
        });
    });

    $("#categoryName").change(function () {
        console.log(3);
        $("#category-form").submit();
    });


}