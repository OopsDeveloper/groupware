/*!
 * Common Js
 * Last Date : 21.09.27
 */

$(document).ready(function() {
	$('.jsCurrentMenu').click(function() {
        $pathDepth = $(this).closest('article');
        $chihDepth = $(this).next('.dropdown-menu');

        if($($pathDepth).hasClass('show')) {
            $($pathDepth).removeClass('show');
            $($pathDepth).find($chihDepth).removeClass('show');
        } else {
            $($pathDepth).addClass('show');
            $($pathDepth).find($chihDepth).addClass('show');
 
        }
    });//$('.jsCurrentMenu') dropdown
	
	CKEDITOR.replace( 'p_content', { skin: 'moono-lisa'});//Editor
	
    // 서버에는 value 값이 전송
	$('label.radio, label.checkbox').click(function() {
		var clickFor = $(this).attr('for');//선택된 label for값
		var clickType = $(this).attr('class');//선택된 labe,input type 
		var inputName = $('#'+clickFor).attr('name');//선택된 input name
				
		if( clickType == 'radio' ) {
			var names = $('input[name='+inputName+']').length;//동일 name 
			var namesArr = new Array(names);//동일 name 배열
			for( var i=0; i<names; i++ ) {                          
				namesArr[i] = $('input[name='+inputName+']').eq(i).attr('id');
				if( $('#'+namesArr[i]).prop('checked') == true ) {
					$('#'+namesArr[i]).removeAttr('checked');
				}
			}
			$('#'+clickFor).attr('checked',true); //선택된 label 의 input checked
		}   // radio 일경우 input name이 같은 radio는 checked가 하나
		
	});//$('label.radio, label.checkbox')
	    
});//$(document).ready(function()


//Modal
function fn_modalClose() {
	var html = $('div.modal').closest('html');
	$('#jsModalClose').click( function() {
        $('div.modal').removeClass('show');
        $('div.modal').css('display', '');
        $(html).removeClass('laypop');
    });
	/*$('div.modal').click( function() {
		$(this).removeClass('show');
		$(this).css('display', '');
		$(html).removeClass('laypop');
	});*/
}
function fn_modalOpen(id) {
	var html = $(id).closest('html');
	var modalBg = $(id).closest('div.modal');	
	$(modalBg).addClass('show');
	$(html).addClass('laypop');
    $(modalBg).css('display', 'block');
}

// Modal - 조직도 - 정보보기
function fn_InfoPage(o) {
	$itMe = $(o); 
	var params = {"joinSabun" : $itMe.data('sabun') };
	var mId = $('#jsModalPersonInfo');
		
	fn_modalClose();
	// ajax 데이터 연결
    $.ajax({
    	url : '/org/mSabunInfo',
    	dataType : 'json', 
    	data : params,
    	success : function(data) {
    		fn_modalOpen(mId);
    		$.each(data.data , function(i, el) {  
    	    	$('#jsViewInfo').empty();
    	    	var str = '<div class="item photo">';
    	    		str += '<img src="/images/photo/proFile/'+ el.joinSabun +'.jpg" alt="Photo"></div>';
    	    		str +='<ul class="item view-li">';
    	    		str +='<li><span class="tit">사번</span>';
    	    		str +='<strong class="data">'+ el.joinSabun +'</strong></li>';
    	    		str +='<li><span class="tit">이름</span>';
    	    		str +='<strong class="data">'+ el.joinName +'</strong></li>';
    	    		str +='<li><span class="tit">성별</span>';
    	    		str +='<strong class="data">'+ el.joinGender +'</strong></li>';
    	    		str +='<li><span class="tit">이메일</span>';
    	    		str +='<strong class="data">'+ el.joinEmail +'</strong></li>';
    	    		str +='<li><span class="tit">부서명</span>';
    	    		str +='<strong class="data">'+ el.commNm +'</strong></li>';
    	    		str +='<li><span class="tit">직급/직위</span>';
    	    		str +='<strong class="data">'+ el.joinPosition +'</strong></li>';
    	    		str +='<li><span class="tit">부서 연락처</span>';
    	    		str +='<strong class="data">'+ el.departmentTel +'</strong></li>';
    	    	$('#jsViewInfo').append(str);
    	    });//$.each
    	    	    	    
    	}, error : function(xhr, status, error) {
			console.log('xhr', xhr);
			console.log('status', status);
			console.log('error', error);
		} 
    });//$.ajax

}// fn_InfoPage() 조직도-모달팝업

//Modal - 쪽지보관함 - 쪽지보기
function fn_MsgPage(e){
	$itMe = $(e);
	var params = {"msgReceive" : $itMe.data('sabun'), "msgNo": $itMe.data('no') };	
	var mId = $('#jsModalPersonInfo');
	
	fn_modalClose();
    // ajax 데이터 연결
    $.ajax({
    	url : '/msg/msgShow',
    	dataType : 'json', 
    	data : params,
    	success : function(data) {
    		fn_modalOpen(mId);
	    	$('#jsViewInfo').empty();
	    	var str = '<ul class="item view-li">';
	    		str +='<li><span class="tit">제목</span>';
	    		str +='<strong class="data">'+ data.data.msgTitle +'</strong></li>';
	    		str +='<li><span class="tit">보낸시간</span>';
	    		str +='<strong class="data">'+ data.data.msgStime +'</strong></li>';
	    		str +='<li><span class="tit">보낸사람</span>';
	    		str +='<strong class="data">'+ data.data.msgSend +'</strong></li>';
	    		str +='<li><span class="tit">내용</span>';
	    		str +='<strong class="data">'+ data.data.msgContent +'</strong></li>';
	    	$('#jsViewInfo').append(str);
    	    
    	    	    	    
    	}, error : function(xhr, status, error) {
			console.log('xhr', xhr);
			console.log('status', status);
			console.log('error', error);
		} 
    });//$.ajax
}//fn_MsgPage() 쪽지보관함-모달 팝업

//Modal - 쪽지보관함 - 쪽지보내기
function fn_MsgSend(name,sabun){
	
	if((sabun != undefined || sabun != null) && (name != undefined || name != null)){
		chooseSabun(name,sabun);		
	}
	var modalBg = $('#jsModalMsgSend').closest('div.modal');
	
	$('#jsModalMsgClose').click( function() {
        $(modalBg).removeClass('show');
        $(modalBg).css('display', '');
    });
	$(modalBg).addClass('show');
    $(modalBg).css('display', 'block');
}

