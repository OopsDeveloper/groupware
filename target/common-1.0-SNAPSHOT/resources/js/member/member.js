function deleteMember(id){
    let token = $("meta[name='_csrf']").attr("content");
    let header = $("meta[name='_csrf_header']").attr("content");

    $.ajax({
        type:"POST",
        url:"/member/deleteMemebr.do",
        data:{"id":id},
        beforeSend : function(xhr){
            xhr.setRequestHeader(header, token);
        },
        success:function (result){
            console.log(result);
        },
        error:function (error){

        }
    });
}
