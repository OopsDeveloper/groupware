$(document).ready(function (){
    $("#attY").click(function (){
        alert("참석했당");
    });
    $("#attN").click(function (){
        if ($("#attContent").val() === "") {
            alert("불참 사유를 입력해주세요!");
        } else {
            alert("\"" + $("#attContent").val() + "\"" + "의 사유로 불참하였습니다.");
        }
    });
});