$(document).ready(function (){
    let token = $("meta[name='_csrf']").attr("content");
    let header = $("meta[name='_csrf_header']").attr("content");

    $("#attY").on("click",function (){
        $.ajax({
            type:"POST",
            url:"/attend/attend.do",
            data:{"data":"Y"},
            dataType:"json",
            beforeSend : function(xhr){
                xhr.setRequestHeader(header, token);
            },
            success:function (result){
                console.log(result);
            },
            error:function (error){

            }
        });
    });
    $("#attN").on("click",function (){
        if ($("#attContent").val() === "") {
            alert("불참 사유를 입력해주세요!");
        } else {
            alert("\"" + $("#attContent").val() + "\"" + "의 사유로 불참하였습니다.");
        }
    });
});