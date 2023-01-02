window.onload = () =>{
    $(document).ready(function () {
        $('#summernote').summernote({
            placeholder: 'Please enter a content.',
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