$(document).ready(function (){
    let token = $("meta[name='_csrf']").attr("content");
    let header = $("meta[name='_csrf_header']").attr("content");
    let lat, lng, accur;

    $("#attY").on("click",function (){
        window.navigator.geolocation.getCurrentPosition(function (position){
            lat = position.coords.latitude;
            lng = position.coords.longitude;
            accur = Math.floor(position.coords.accuracy);

            alert(lat + "," + lng + "/" + accur);
        },
        function (error){
            switch (error.code){
                case error.PERMISSION_DENIED:
                    str = "사용자거부";
                    break;
                case error.POSITION_UNAVAILABLE:
                    str = "지리정보 없음";
                    break;
                case error.TIMEOUT:
                    str = "시간 초과";
                    break;
            }
            alert(str);
        });
        $.ajax({
            type:"POST",
            url:"/attend/attend.do",
            data:{"lat":lat,"lng":lng, "accur":accur},
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